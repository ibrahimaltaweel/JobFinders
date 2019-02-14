package com.jobfinder.progressoft.jobfinder.model.parser;

import com.jobfinder.progressoft.jobfinder.model.vo.GitHubJob;
import com.jobfinder.progressoft.jobfinder.model.vo.response.GitHubJobsResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GitHubJobsParser {
    private static final String VALUE_COMPANY = "company";
    private static final String VALUE_COMPANY_URL = "company_url";
    private static final String VALUE_COMPANY_LOGO = "company_logo";
    private static final String VALUE_CREATED_AT = "created_at";
    private static final String VALUE_DESCRIPTION = "description";
    private static final String VALUE_HOW_TO_APPLY = "how_to_apply";
    private static final String VALUE_ID = "id";
    private static final String VALUE_LOCATION = "location";
    private static final String VALUE_TITLE = "title";
    private static final String VALUE_TYPE = "type";
    private static final String VALUE_URL = "url";

    public static GitHubJobsResponse parse(String json) {
        if (json == null || json.isEmpty()) {
            return null;
        }

        try {
            JSONArray jsonArray = new JSONArray(json);
            //  ResponseError responseError = Parser.parseResponseError(jsonObject);

            /*if (responseError != null && responseError.getErrorCode() != 0) {
                return new GitHubJobsResponse(responseError);
            }*/
            List<GitHubJob> gitHubJobList = new ArrayList<>();
            //JSONArray responseJsonArray = jsonObject.getJSONArray(ARRAY_RESPONSE);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject contactJsonObject = jsonArray.getJSONObject(i);
                String company = contactJsonObject.has(VALUE_COMPANY)?contactJsonObject.getString(VALUE_COMPANY):"";
                String companyUrl = contactJsonObject.has(VALUE_COMPANY_URL)?contactJsonObject.getString(VALUE_COMPANY_URL):"";
                String companyLogo = contactJsonObject.has(VALUE_COMPANY_LOGO)?contactJsonObject.getString(VALUE_COMPANY_LOGO):"";
                String createdAt = contactJsonObject.has(VALUE_CREATED_AT)?contactJsonObject.getString(VALUE_CREATED_AT):"";
                String description = contactJsonObject.has(VALUE_DESCRIPTION)?contactJsonObject.getString(VALUE_DESCRIPTION):"";
                String apply = contactJsonObject.has(VALUE_HOW_TO_APPLY)?contactJsonObject.getString(VALUE_HOW_TO_APPLY):"";
                String id = contactJsonObject.has(VALUE_ID)?contactJsonObject.getString(VALUE_ID):null;
               String location = contactJsonObject.has(VALUE_LOCATION)?contactJsonObject.getString(VALUE_LOCATION):"";
                String title = contactJsonObject.has(VALUE_TITLE)?contactJsonObject.getString(VALUE_TITLE):"";
                String type =contactJsonObject.has(VALUE_TYPE)? contactJsonObject.getString(VALUE_TYPE):"";
                String url = contactJsonObject.has(VALUE_URL)?contactJsonObject.getString(VALUE_URL):"";

                GitHubJob gitHubJob = new GitHubJob(company, companyUrl,companyLogo,createdAt,description,apply,
                id,location,title,type,url);
                gitHubJobList.add(gitHubJob);
            }

            return new GitHubJobsResponse(gitHubJobList);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

}
