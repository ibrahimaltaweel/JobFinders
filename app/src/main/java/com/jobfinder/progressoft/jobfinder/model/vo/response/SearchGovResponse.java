package com.jobfinder.progressoft.jobfinder.model.vo.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.jobfinder.progressoft.jobfinder.model.vo.GitHubJobs;
import com.jobfinder.progressoft.jobfinder.model.vo.ResponseError;

import java.util.List;


public class SearchGovResponse implements Parcelable {

    private ResponseError error;
    private List<GitHubJobs> gitHubJobs;

    public SearchGovResponse(List<GitHubJobs> gitHubJobs) {
        this.setGitJobsList(gitHubJobs);
    }

    public SearchGovResponse(ResponseError error) {
        this.setError(error);
    }

    protected SearchGovResponse(Parcel in) {
        error = in.readParcelable(ResponseError.class.getClassLoader());
        gitHubJobs = in.createTypedArrayList(GitHubJobs.CREATOR);
    }

    public static final Creator<SearchGovResponse> CREATOR = new Creator<SearchGovResponse>() {
        @Override
        public SearchGovResponse createFromParcel(Parcel in) {
            return new SearchGovResponse(in);
        }

        @Override
        public SearchGovResponse[] newArray(int size) {
            return new SearchGovResponse[size];
        }
    };

    public ResponseError getError() {
        return error;
    }

    public void setError(ResponseError error) {
        this.error = error;
    }

    public List<GitHubJobs> getSearchGovJobsList() {
        return gitHubJobs;
    }

    public void setGitJobsList(List<GitHubJobs> gitHubJobs) {
        this.gitHubJobs = gitHubJobs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(error, flags);
        dest.writeTypedList(gitHubJobs);
    }
}