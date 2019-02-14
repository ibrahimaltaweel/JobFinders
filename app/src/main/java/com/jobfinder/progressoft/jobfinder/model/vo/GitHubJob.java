package com.jobfinder.progressoft.jobfinder.model.vo;

import android.os.Parcel;
import android.os.Parcelable;

public class GitHubJob implements Parcelable {
    public static final Creator<GitHubJob> CREATOR = new Creator<GitHubJob>() {
        @Override
        public GitHubJob createFromParcel(Parcel in) {
            return new GitHubJob(in);
        }

        @Override
        public GitHubJob[] newArray(int size) {
            return new GitHubJob[size];
        }
    };
    private String company;
    private String companyUrl;
    private String companyLogo;
    private String createdAt;
    private String description;
    private String apply;
    private String location;
    private String title;
    private String type;
    private String url;
    private String id;


    public GitHubJob(Parcel in) {
        company = in.readString();
        companyUrl = in.readString();
        companyLogo = in.readString();
        createdAt = in.readString();
        description = in.readString();
        apply = in.readString();
        location = in.readString();
        title = in.readString();
        type = in.readString();
        url = in.readString();
        id = in.readString();
    }

    public GitHubJob(String company, String companyUrl, String companyLogo, String createdAt, String description, String apply, String id, String location, String title, String type, String url) {
        this.setCompany(company);
        this.setCompanyUrl(companyUrl);
        this.setCompanyLogo(companyLogo);
        this.setCreatedAt(createdAt);
        this.setDescription(description);
        this.setApply(apply);
        this.setId(id);
        this.setLocation(location);
        this.setTitle(title);
        this.setType(type);
        this.setUrl(url);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApply() {
        return apply;
    }

    public void setApply(String apply) {
        this.apply = apply;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(company);
        dest.writeString(companyUrl);
        dest.writeString(companyLogo);
        dest.writeString(createdAt);
        dest.writeString(description);
        dest.writeString(apply);
        dest.writeString(location);
        dest.writeString(title);
        dest.writeString(type);
        dest.writeString(url);
    }
}
