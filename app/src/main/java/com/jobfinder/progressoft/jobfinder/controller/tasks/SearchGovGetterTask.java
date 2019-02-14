package com.jobfinder.progressoft.jobfinder.controller.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.jobfinder.progressoft.jobfinder.controller.util.CacheUtil;
import com.jobfinder.progressoft.jobfinder.controller.util.WebService;
import com.jobfinder.progressoft.jobfinder.model.parser.SearchGovParser;
import com.jobfinder.progressoft.jobfinder.model.vo.C;
import com.jobfinder.progressoft.jobfinder.model.vo.response.SearchGovResponse;

import java.util.HashMap;
import java.util.Map;

public class SearchGovGetterTask extends AsyncTask<String,Void,SearchGovResponse> {

    private OnSearchGovReady onSearchGovReady;
    private static final String PARAM_QUERY = "query";
    private Context context;
    private String response;
    private String TAG="SearchGovGetterTask";

    public SearchGovGetterTask(Context context, OnSearchGovReady onSearchGovReady) {
        this.onSearchGovReady = onSearchGovReady;
        this.context=context;
    }

    @Override
    protected SearchGovResponse doInBackground(String... params) {
        if (params.length == 0) {
            return null;
        }
        Map<String, String> parameters = new HashMap<>();
        parameters.put(PARAM_QUERY, params[0]);

         response = WebService.callSearchService(parameters);
        Log.d(TAG, "doInBackground: "+response);
        return SearchGovParser.parse(response);
    }

    @Override
    protected void onPostExecute(SearchGovResponse searchGovJobsResponse) {
        super.onPostExecute(searchGovJobsResponse);

        cache(searchGovJobsResponse);

        if (onSearchGovReady != null) {
            onSearchGovReady.onSearchGovReady(searchGovJobsResponse);
        }
    }


    private void cache(SearchGovResponse searchGovJobsResponse) {
        if (searchGovJobsResponse == null || searchGovJobsResponse.getError() != null || searchGovJobsResponse.getSearchGovJobsList().isEmpty()) {
            return;
        }

        CacheUtil.cacheDataAsync(context, response, C.FILE_CLASSES);
    }

    public interface OnSearchGovReady {
        void onSearchGovReady(SearchGovResponse searchGovJobsResponse);
    }
}
