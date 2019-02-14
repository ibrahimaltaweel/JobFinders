package com.jobfinder.progressoft.jobfinder.controller.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.jobfinder.progressoft.jobfinder.R;
import com.jobfinder.progressoft.jobfinder.controller.tasks.GitHubJobsGetterTask;
import com.jobfinder.progressoft.jobfinder.controller.tasks.SearchGovGetterTask;
import com.jobfinder.progressoft.jobfinder.model.vo.GitHubJob;
import com.jobfinder.progressoft.jobfinder.model.vo.response.GitHubJobsResponse;
import com.jobfinder.progressoft.jobfinder.model.vo.response.SearchGovResponse;
import com.jobfinder.progressoft.jobfinder.view.adapter.GitHubJobsAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, GitHubJobsGetterTask.OnGitHubJobsReady, SearchGovGetterTask.OnSearchGovReady, CallBack {
    private GitHubJobsAdapter gitHubJobsAdapter;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    private EditText edit_postion;
    private Spinner spinner;
    int selectedProvider = 0;
    String description = "";
    String location = "";
    List<GitHubJob> getJobsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.activity_main);
        initViews();
        initListener();

    }

    public void getGetHubJobs(int provider, String description, String location) {
        startLoading();
        if (isNetworkAvailable()) {
            Log.d(TAG, "getGetHubJobs: " + provider + description + location);
            switch (provider) {
                case 0:
                    new GitHubJobsGetterTask(this, MainActivity.this).execute(description, location);
                    new SearchGovGetterTask(this, MainActivity.this).execute(description + location);
                    break;
                case 1:
                    new GitHubJobsGetterTask(this, MainActivity.this).execute(description, location);
                    break;
                case 2:
                    new SearchGovGetterTask(this, MainActivity.this).execute(description + location);
                    break;
            }
        } else {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            stopLoading();
        }
    }

    public void textChangeListener() {
        edit_postion.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0) {
                    description = edit_postion.getText().toString();
                    getGetHubJobs(selectedProvider, description, location);
                }

            }
        });

    }

    public void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        spinner = (Spinner) findViewById(R.id.spinner);
        edit_postion = (EditText) findViewById(R.id.postion);
    }

    public void initListener() {
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("All");
        categories.add("GitHub");
        categories.add("Search.gov");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), "AIzaSyB6oP31az92snW2KXth0YR5rGAAtrS7814");
        }

        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.NAME));

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.i("place", "Place: " + place.getName());
                location = place.getName();
                getGetHubJobs(selectedProvider, description, location);

            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i("place", "An error occurred: " + status);
            }
        });

        textChangeListener();
    }

    public void openWebURL(String inURL) {
        Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(inURL));
        startActivity(browse);
    }

    @Override
    public void onGitHubJobsReady(GitHubJobsResponse gitHubJobsResponse) {
        try {
            if (selectedProvider == 0) {
                getJobsList = gitHubJobsResponse.getGitJobsList();
            } else {
                if (progressDialog.isShowing()) {
                    stopLoading();
                }
                gitHubJobsAdapter = new GitHubJobsAdapter(getApplicationContext(), gitHubJobsResponse.getGitJobsList(), this);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(gitHubJobsAdapter);
                gitHubJobsAdapter.notifyDataSetChanged();

            }
        } catch (Exception e) {

        }
    }

    @Override
    public void onSearchGovReady(SearchGovResponse searchGovJobsResponse) {
        try {
            if (selectedProvider == 0) {
                getJobsList.addAll(searchGovJobsResponse.getSearchGovJobsList());
            } else {
                getJobsList.clear();
                getJobsList.addAll(searchGovJobsResponse.getSearchGovJobsList());
            }

            if (progressDialog != null) {
                stopLoading();
            }

            gitHubJobsAdapter = new GitHubJobsAdapter(getApplicationContext(), getJobsList, this);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(gitHubJobsAdapter);
            gitHubJobsAdapter.notifyDataSetChanged();
        } catch (Exception e) {

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedProvider = (int) parent.getItemIdAtPosition(position);
        getGetHubJobs(selectedProvider, description, location);
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void startLoading() {
        progressDialog = ProgressDialog.show(this, null, null, false, false);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        progressDialog.setContentView(R.layout.progressdialog);
        progressDialog.show();
    }

    public void stopLoading() {
        if (!isFinishing()) {
            if (progressDialog != null) {
                progressDialog.dismiss();
                progressDialog.cancel();
                progressDialog = null;
            }
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onRecyclerListener(String url) {
        openWebURL(url);
    }
}