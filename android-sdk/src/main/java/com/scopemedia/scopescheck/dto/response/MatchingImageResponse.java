package com.scopemedia.scopescheck.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scopemedia.scopescheck.dto.model.MatchingArea;
import com.scopemedia.scopescheck.dto.model.Media;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchingImageResponse extends ScopeResponse implements Parcelable {

    @JsonProperty("medias")
    private Media[] medias;

    @JsonProperty("matchingArea")
    private MatchingArea matchingArea;

    public MatchingImageResponse() {
        super();
    }

    /**
     * Returns all similar medias
     * @return {@link Media}
     */
    public Media[] getMedias() {
        return medias;
    }

    public MatchingArea getMatchingArea() {
        return matchingArea;
    }

    public void setMatchingArea(MatchingArea matchingArea) {
        this.matchingArea = matchingArea;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedArray(this.medias, flags);
        dest.writeParcelable(this.matchingArea, flags);
    }

    protected MatchingImageResponse(Parcel in) {
        super(in);
        this.medias = in.createTypedArray(Media.CREATOR);
        this.matchingArea = in.readParcelable(MatchingArea.class.getClassLoader());
    }

    public static final Creator<MatchingImageResponse> CREATOR = new Creator<MatchingImageResponse>() {
        @Override
        public MatchingImageResponse createFromParcel(Parcel source) {
            return new MatchingImageResponse(source);
        }

        @Override
        public MatchingImageResponse[] newArray(int size) {
            return new MatchingImageResponse[size];
        }
    };
}