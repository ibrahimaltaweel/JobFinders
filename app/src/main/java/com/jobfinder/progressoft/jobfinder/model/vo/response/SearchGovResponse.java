package com.jobfinder.progressoft.jobfinder.model.vo.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.jobfinder.progressoft.jobfinder.model.vo.GitHubJob;

import java.util.List;


public class SearchGovResponse implements Parcelable {

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
    private List<GitHubJob> gitHubJobs;


    public SearchGovResponse(List<GitHubJob> gitHubJobs) {
        this.setGitJobsList(gitHubJobs);
    }

    protected SearchGovResponse(Parcel in) {
        gitHubJobs = in.createTypedArrayList(GitHubJob.CREATOR);
    }

    public List<GitHubJob> getSearchGovJobsList() {
        return gitHubJobs;
    }

    public void setGitJobsList(List<GitHubJob> gitHubJobs) {
        this.gitHubJobs = gitHubJobs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(gitHubJobs);
    }
}
