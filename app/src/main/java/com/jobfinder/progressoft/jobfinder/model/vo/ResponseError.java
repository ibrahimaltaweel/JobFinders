package com.jobfinder.progressoft.jobfinder.model.vo;

import android.os.Parcel;
import android.os.Parcelable;

public class ResponseError implements Parcelable {
    private int errorCode;
    private String description;

    public ResponseError(int errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected ResponseError(Parcel in) {
        errorCode = in.readInt();
        description = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(errorCode);
        dest.writeString(description);
    }

    public static final Parcelable.Creator<ResponseError> CREATOR = new Parcelable.Creator<ResponseError>() {
        @Override
        public ResponseError createFromParcel(Parcel in) {
            return new ResponseError(in);
        }

        @Override
        public ResponseError[] newArray(int size) {
            return new ResponseError[size];
        }
    };
}