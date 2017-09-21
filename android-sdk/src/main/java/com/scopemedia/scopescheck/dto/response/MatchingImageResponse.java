package com.scopemedia.scopescheck.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scopemedia.scopescheck.dto.model.Media;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchingImageResponse extends ScopeResponse implements Parcelable {

    @JsonProperty("medias")
    private Media[] medias;

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelableArray(medias, PARCELABLE_WRITE_RETURN_VALUE);
    }

    private MatchingImageResponse(Parcel in) {
        super(in);
        medias = (Media[]) in.readParcelableArray(Media.class.getClassLoader());
    }

    public static final Creator<MatchingImageResponse> CREATOR = new Creator<MatchingImageResponse>() {
        @Override
        public MatchingImageResponse[] newArray(int size) {
            return new MatchingImageResponse[size];
        }

        @Override
        public MatchingImageResponse createFromParcel(Parcel source) {
            return new MatchingImageResponse(source);
        }
    };
}