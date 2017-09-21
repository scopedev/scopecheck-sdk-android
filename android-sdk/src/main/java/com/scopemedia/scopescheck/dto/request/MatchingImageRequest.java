package com.scopemedia.scopescheck.dto.request;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scopemedia.scopescheck.Utils;
import com.scopemedia.scopescheck.dto.model.Area;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchingImageRequest extends ScopeRequest implements Parcelable {

    @JsonProperty("base64")
    private String base64;

    @JsonProperty("mediaId")
    private long mediaId;

    @JsonProperty("mediaUrl")
    private String mediaUrl;

    @JsonProperty("modelId")
    private String appId;

    @JsonProperty("area")
    private Area area;

    public MatchingImageRequest() {
    }

    /**
     * Media as ID, Bitmap, Base64 or as URL is required
     * @param id Media ID
     * @return PredictionRequest
     */
    public MatchingImageRequest setMediaId(long id) {
        this.mediaId = id;
        return this;
    }

    /**
     * Media as ID, Bitmap, Base64 or as URL is required
     * @param bitmap encoded media
     * @return SimilarImageRequest
     */
    public MatchingImageRequest setMediaAsBitmap(Bitmap bitmap) {
        this.base64 = Utils.bitmap2base64(bitmap);
        return this;
    }

    /**
     * Media as ID, Bitmap, Base64 or as URL is required
     * @param base64 encoded media
     * @return SimilarImageRequest
     */
    public MatchingImageRequest setMediaAsBase64(String base64) {
        this.base64 = base64;
        return this;
    }

    /**
     * Media as ID, Bitmap, Base64 or as URL is required
     * @param url media URL
     * @return SimilarImageRequest
     */
    public MatchingImageRequest setMediaAsUrl(String url) {
        this.mediaUrl = url;
        return this;
    }

    /**
     * @param appId app ID use for similar images.
     * @return SimilarImageRequest
     */
    public MatchingImageRequest setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    /**
     * Set an area which will be used for the similar images
     * @param area Area will be used for the similar images. See {@link Area}
     * @return SimilarImageRequest
     */
    public MatchingImageRequest setArea(Area area) {
        this.area = area;
        return this;
    }

    @Override
    public boolean checkAllRequired() {
        return mediaId != 0.0 || mediaUrl != null || base64 != null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(appId);
        dest.writeLong(mediaId);
        dest.writeString(mediaUrl);
        dest.writeString(base64);
        dest.writeParcelable(area, PARCELABLE_WRITE_RETURN_VALUE);
    }

    private MatchingImageRequest(Parcel in) {
        super(in);
        this.appId = in.readString();
        this.mediaId = in.readLong();
        this.mediaUrl = in.readString();
        this.base64 = in.readString();
        this.area = in.readParcelable(Area.class.getClassLoader());
    }

    public static final Creator<MatchingImageRequest> CREATOR = new Creator<MatchingImageRequest>() {
        @Override
        public MatchingImageRequest[] newArray(int size) {
            return new MatchingImageRequest[size];
        }

        @Override
        public MatchingImageRequest createFromParcel(Parcel source) {
            return new MatchingImageRequest(source);
        }
    };
}
