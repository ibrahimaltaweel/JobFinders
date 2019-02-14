package com.jobfinder.progressoft.jobfinder.controller.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.jobfinder.progressoft.jobfinder.controller.util.CacheUtil;
import com.jobfinder.progressoft.jobfinder.controller.util.WebService;
import com.jobfinder.progressoft.jobfinder.model.parser.GitHubJobsParser;
import com.jobfinder.progressoft.jobfinder.model.vo.response.GitHubJobsResponse;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class GitHubJobsGetterTask extends AsyncTask<String, Void, GitHubJobsResponse> {

    private static final String PARAM_DESCRIPTION = "description";
    private static final String PARAM_LOCATION = "location";
    private static final String FILE_CLASSES = "classes";
    private OnGitHubJobsReady onGitHubJobsReady;
    private Context context;
    private String response;

    public GitHubJobsGetterTask(Context context, OnGitHubJobsReady onGitHubJobsReady) {
        this.onGitHubJobsReady = onGitHubJobsReady;
        this.context = context;
    }

    @Override
    protected GitHubJobsResponse doInBackground(String... params) {
        if (params.length == 0) {
            return null;
        }
        Map<String, String> parameters = new HashMap<>();
        parameters.put(PARAM_DESCRIPTION, params[0]);
        parameters.put(PARAM_LOCATION, params[1]);


        response = WebService.callGetService(parameters);
        Log.d(TAG, "doInBackground: " + response);
        return GitHubJobsParser.parse(response);
    }

    @Override
    protected void onPostExecute(GitHubJobsResponse gitHubJobsResponse) {
        super.onPostExecute(gitHubJobsResponse);
        cache(gitHubJobsResponse);
        if (onGitHubJobsReady != null)
            onGitHubJobsReady.onGitHubJobsReady(gitHubJobsResponse);
    }


    private void cache(GitHubJobsResponse gitHubJobsResponse) {
        if (gitHubJobsResponse == null || gitHubJobsResponse.getGitJobsList().isEmpty())
            return;
        CacheUtil.cacheDataAsync(context, response, FILE_CLASSES);
    }

    public interface OnGitHubJobsReady {
        void onGitHubJobsReady(GitHubJobsResponse gitHubJobsResponse);
    }
}
