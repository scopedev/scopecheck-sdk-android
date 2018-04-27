package com.scopemedia.scopescheck.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * @author Maikel Rehl on 6/12/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ScopeResponse implements Parcelable {

    @JsonProperty("status")
    @SerializedName("status")
    private String status;

    @JsonProperty("error")
    @SerializedName("error")
    private String error;

    public ScopeResponse() {

    }

    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(error);
    }

    protected ScopeResponse(Parcel in) {
        this.status = in.readString();
        this.error = in.readString();
    }
}
