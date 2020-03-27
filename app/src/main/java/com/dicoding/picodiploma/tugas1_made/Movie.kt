package com.dicoding.picodiploma.tugas1_made

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Movie(
    var title: String?,
    var rating: String?,
    var release: String?,
    var description: String?,
    var cover: Int
    ):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(rating)
        parcel.writeString(release)
        parcel.writeString(description)
        parcel.writeInt(cover)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}