package com.example.codechallenge060619.network

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImgDetail(
    @SerializedName("format")
    @Expose val format: String,
    @SerializedName("width")
    @Expose val width: Int,
    @SerializedName("height")
    @Expose val height: Int,
    @SerializedName("filename")
    @Expose val filename: String,
    @SerializedName("id")
    @Expose val id: Int,
    @SerializedName("author")
    @Expose val author: String,
    @SerializedName("author_url")
    @Expose val authorUrl: String,
    @SerializedName("post_url")
    @Expose val postUrl: String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(format)
        dest.writeInt(width)
        dest.writeInt(height)
        dest.writeString(filename)
        dest.writeInt(id)
        dest.writeString(author)
        dest.writeString(authorUrl)
        dest.writeString(postUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ImgDetail> {
        override fun createFromParcel(parcel: Parcel): ImgDetail {
            return ImgDetail(parcel)
        }

        override fun newArray(size: Int): Array<ImgDetail?> {
            return arrayOfNulls(size)
        }
    }
}