package itu.master1.projetandroid.menu.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Content implements Parcelable {
    @SerializedName("title")
    private String title;
    @SerializedName("text")
    private String description;
    @SerializedName("images")
    private String[] images;
    @SerializedName("videos")
    private String[] videos;

    public static final Content[] contents = {
            new Content("science de la vie", "La science nous permet de voir"),
            new Content("histoire", "l'histoire est formidable"),
            new Content("mathématiques", "la mathématique est une science exacte"),
            new Content("Géographie", "la terre est ronde"),
            new Content("science de la vie", "La science nous permet de voir"),
            new Content("histoire", "l'histoire est formidable"),
            new Content("mathématiques", "la mathématique est une science exacte"),
            new Content("Géographie", "la terre est ronde"),
            new Content("science de la vie", "La science nous permet de voir"),
            new Content("histoire", "l'histoire est formidable"),
            new Content("mathématiques", "la mathématique est une science exacte"),
            new Content("Géographie", "la terre est ronde"),
            new Content("science de la vie", "La science nous permet de voir"),
            new Content("histoire", "l'histoire est formidable"),
            new Content("mathématiques", "la mathématique est une science exacte"),
            new Content("Géographie", "la terre est ronde"),
    };

    public Content() {

    }

    public Content(String _title, String _description) {
        this.title = _title;
        this.description = _description;
    }


    protected Content(Parcel in) {
        title = in.readString();
        description = in.readString();
        images = in.createStringArray();
        videos = in.createStringArray();
    }

    public static final Creator<Content> CREATOR = new Creator<Content>() {
        @Override
        public Content createFromParcel(Parcel in) {
            return new Content(in);
        }

        @Override
        public Content[] newArray(int size) {
            return new Content[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public String[] getVideos() {
        return videos;
    }

    public void setVideos(String[] videos) {
        this.videos = videos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(description);
    }
}
