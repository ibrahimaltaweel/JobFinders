package com.jobfinder.progressoft.jobfinder.model.vo.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.jobfinder.progressoft.jobfinder.model.vo.GitHubJob;

import java.util.List;


public class GitHubJobsResponse implements Parcelable {

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
    private List<GitHubJob> gitHubJobs;


    public GitHubJobsResponse(List<GitHubJob> gitHubJobs) {
        this.setGitJobsList(gitHubJobs);
    }

    public GitHubJobsResponse(Parcel in) {
        gitHubJobs = in.createTypedArrayList(GitHubJob.CREATOR);
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
        dest.writeTypedList(gitHubJobs);
    }
}
