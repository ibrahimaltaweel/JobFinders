package com.jobfinder.progressoft.jobfinder.model.vo.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.jobfinder.progressoft.jobfinder.model.vo.GitHubJob;
import com.jobfinder.progressoft.jobfinder.model.vo.ResponseError;

import java.util.List;


public class GitHubJobsResponse implements Parcelable {

    private ResponseError error;
    private List<GitHubJob> gitHubJobs;

    public GitHubJobsResponse(List<GitHubJob> gitHubJobs) {
        this.setGitJobsList(gitHubJobs);
    }

    public GitHubJobsResponse(ResponseError error) {
        this.setError(error);
    }

    protected GitHubJobsResponse(Parcel in) {
        error = in.readParcelable(ResponseError.class.getClassLoader());
        gitHubJobs = in.createTypedArrayList(GitHubJob.CREATOR);
    }

    public static final Creator<GitHubJobsResponse> CREATOR = new Creator<GitHubJobsResponse>() {
        @Override
        public GitHubJobsResponse createFromParcel(Parcel in) {
            return new GitHubJobsResponse(in);
        }

        @Override
        public GitHubJobsResponse[] newArray(int size) {
            return new GitHubJobsResponse[size];
        }
    };

    public ResponseError getError() {
        return error;
    }

    public void setError(ResponseError error) {
        this.error = error;
    }

    public List<GitHubJob> getGitJobsList() {
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
        dest.writeParcelable(error, flags);
        dest.writeTypedList(gitHubJobs);
    }
}
