package com.kodesnippets.aaqib.alarm;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Moosa moosa.bh@gmail.com on 4/25/2016 25 April.
 * Everything is possible in programming.
 */
public class TempModel implements Parcelable {
    private String name;
    private String time;
    private String message;

    public TempModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TempModel(String name, String time, String message) {
        this.name = name;
        this.time = time;
        this.message = message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.time);
        dest.writeString(this.message);
    }

    protected TempModel(Parcel in) {
        this.name = in.readString();
        this.time = in.readString();
        this.message = in.readString();
    }

    public static final Parcelable.Creator<TempModel> CREATOR = new Parcelable.Creator<TempModel>() {
        @Override
        public TempModel createFromParcel(Parcel source) {
            return new TempModel(source);
        }

        @Override
        public TempModel[] newArray(int size) {
            return new TempModel[size];
        }
    };
}
