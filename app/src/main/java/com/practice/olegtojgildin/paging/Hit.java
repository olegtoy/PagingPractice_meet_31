package com.practice.olegtojgildin.paging;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

public final class Hit {

    @SerializedName("webformatHeight")
    private int webformatHeight;

    @SerializedName("imageWidth")
    private int imageWidth;

    @SerializedName("favorites")
    private int favorites;

    @SerializedName("webformatURL")
    private String webformatURL;

    @SerializedName("previewHeight")
    private int previewHeight;

    @SerializedName("userImageURL")
    private String userImageURL;

    @SerializedName("comments")
    private int comments;

    @SerializedName("previewURL")
    private String previewURL;

    @SerializedName("type")
    private String type;

    @SerializedName("imageHeight")
    private int imageHeight;

    @SerializedName("tags")
    private String tags;

    @SerializedName("previewWidth")
    private int previewWidth;

    @SerializedName("user_id")
    private int userId;

    @SerializedName("downloads")
    private int downloads;

    @SerializedName("largeImageURL")
    private String largeImageURL;

    @SerializedName("pageURL")
    private String pageURL;

    @SerializedName("id")
    private int id;

    @SerializedName("imageSize")
    private int imageSize;

    @SerializedName("webformatWidth")
    private int webformatWidth;

    @SerializedName("user")
    private String user;

    @SerializedName("views")
    private int views;

    @SerializedName("likes")
    private int likes;

    public int getWebformatHeight(){
        return webformatHeight;
    }

    public int getImageWidth(){
        return imageWidth;
    }

    public int getFavorites(){
        return favorites;
    }

    public String getWebformatURL(){
        return webformatURL;
    }

    public int getPreviewHeight(){
        return previewHeight;
    }

    public String getUserImageURL(){
        return userImageURL;
    }

    public int getComments(){
        return comments;
    }

    public String getPreviewURL(){
        return previewURL;
    }

    public String getType(){
        return type;
    }

    public int getImageHeight(){
        return imageHeight;
    }

    public String getTags(){
        return tags;
    }

    public int getPreviewWidth(){
        return previewWidth;
    }

    public int getUserId(){
        return userId;
    }

    public int getDownloads(){
        return downloads;
    }

    public String getLargeImageURL(){
        return largeImageURL;
    }

    public String getPageURL(){
        return pageURL;
    }

    public int getId(){
        return id;
    }

    public int getImageSize(){
        return imageSize;
    }

    public int getWebformatWidth(){
        return webformatWidth;
    }

    public String getUser(){
        return user;
    }

    public int getViews(){
        return views;
    }

    public int getLikes(){
        return likes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hit)) return false;
        Hit image = (Hit) o;
        return Objects.equals(id, image.getId()) &&
                Objects.equals(user, image.getUserId()) &&
                Objects.equals(webformatURL, image.getWebformatURL());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, webformatURL);
    }

    public static DiffUtil.ItemCallback<Hit> DIFF_CALBACK =  new DiffUtil.ItemCallback<Hit>() {
        @Override
        public boolean areItemsTheSame(@NonNull Hit oldItem, @NonNull Hit newItem) {
            return oldItem.getWebformatURL().equals(newItem.webformatURL);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Hit oldItem, @NonNull Hit newItem) {
            return oldItem.getWebformatURL().equals(newItem.getWebformatURL());
        }
    };
}

