package com.zs.bookclient;

/**
 * Created by smartzheng on 2017/6/20.
 */

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Book.java
 *
 * Created by lypeer on 2016/7/16.
 */
public class Book implements Parcelable {
    private String name;
    private int price;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.price);
    }

    public Book() {
    }

    protected Book(Parcel in) {
        this.name = in.readString();
        this.price = in.readInt();
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}