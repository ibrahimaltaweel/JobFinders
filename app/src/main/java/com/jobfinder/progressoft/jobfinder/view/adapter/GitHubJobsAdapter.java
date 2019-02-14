package com.jobfinder.progressoft.jobfinder.view.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jobfinder.progressoft.jobfinder.R;
import com.jobfinder.progressoft.jobfinder.controller.activity.CallBack;
import com.jobfinder.progressoft.jobfinder.model.vo.GitHubJob;

import java.util.List;

public class GitHubJobsAdapter extends RecyclerView.Adapter<GitHubJobsAdapter.MyViewHolder> implements ListAdapter {

    public List<GitHubJob> gitHubJobList;
    Context context;
    private int selectedIndex;
    private CallBack callBack;


    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
        notifyDataSetChanged();
    }

    public GitHubJobsAdapter(Context context, List<GitHubJob> gitHubJobList, CallBack callBack) {
        this.gitHubJobList = gitHubJobList;
        this.context = context;
        this.callBack = callBack;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.git_hub_job_list_row, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        GitHubJob gitHubJob = gitHubJobList.get(position);
        if (gitHubJob.getTitle().length() > 0) {
            holder.title.setText(gitHubJob.getTitle());
        } else {
            holder.title.setVisibility(View.GONE);
        }
        String location = gitHubJob.getLocation().replaceAll("[;\\/:*?\"<>|&']", "");
        if (gitHubJob.getLocation().length() > 0) {
            holder.locatin.setVisibility(View.VISIBLE);

            holder.locatin.setText(location);
        } else {
            holder.locatin.setVisibility(View.GONE);
        }
        if (gitHubJob.getCompany().length() > 0) {
            holder.companyName.setVisibility(View.VISIBLE);
            holder.companyName.setText(gitHubJob.getCompany());
        } else {
            holder.companyName.setVisibility(View.GONE);
        }
        if (gitHubJob.getCreatedAt().length() > 0) {
            holder.createdAt.setVisibility(View.VISIBLE);

            holder.createdAt.setText(gitHubJob.getCreatedAt());
        } else {
            holder.createdAt.setVisibility(View.GONE);
        }
        if (gitHubJob.getType().length() > 0) {
            holder.fullTime.setText(gitHubJob.getType());
            holder.fullTime.setVisibility(View.VISIBLE);
        } else {
            holder.fullTime.setVisibility(View.GONE);
        }
        if (gitHubJob.getCompanyLogo().length() > 0) {
            Glide.with(context)
                    .load(gitHubJob.getCompanyLogo())
                    .into(holder.imageView);
        } else {
            holder.imageView.setImageResource(R.drawable.splash_screen);
        }

        holder.onClick(callBack,gitHubJob.getUrl());

    }

    @Override
    public int getItemCount() {
        return gitHubJobList.size();
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

     static class MyViewHolder extends RecyclerView.ViewHolder {
         TextView title, locatin, companyName, fullTime, createdAt;
         ImageView imageView;
         int index;
         View view;


         MyViewHolder(View view) {
            super(view);
            this.view = view;
            title = view.findViewById(R.id.txt_title);
            locatin = view.findViewById(R.id.txt_locaton);
            companyName = view.findViewById(R.id.txt_company_name);
            fullTime = view.findViewById(R.id.txt_full_time);
            createdAt = view.findViewById(R.id.txt_created_at);
            imageView = view.findViewById(R.id.imageView);

        }
        void onClick(final CallBack callBack,final String url){
             view.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                    callBack.onRecyclerListener(url);
                 }
             });
        }
    }
}