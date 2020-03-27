package com.dicoding.picodiploma.tugas1_made

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class act_detail_movie() : AppCompatActivity() {


    companion object {
        const val PARSEL = "parsel"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_detail_movie)

        //ambil info dari moveintent
        val getdata = intent.getParcelableExtra(PARSEL) as? Movie
        val gettitle = getdata?.title
        val getRating = getdata?.rating
        val getrelease = getdata?.release
        val getdescription = getdata?.description
        val getcover = getdata?.cover

        //tarik id dari xml
        val titles: TextView = findViewById(R.id.movie_title)
        val rating: TextView = findViewById(R.id.rating_details)
        val release: TextView = findViewById(R.id.release_date_details)
        val details: TextView = findViewById(R.id.movie_details)
        val cover: ImageView = findViewById(R.id.movie_cover)

        //overlay ke xml
        titles.text = gettitle
        rating.text = getRating
        release.text = getrelease
        details.text = getdescription
        if (getcover != null) {
            cover.setImageResource(getcover)
        }

        //tombol beli dan favorite
        val buy: Button = findViewById(R.id.buy)
        val favorite: Button = findViewById(R.id.favorite)
        buy.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, gettitle + " ditambahkan ke keranjang", Toast.LENGTH_SHORT).show()
        })
        favorite.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, gettitle + " ditambahkan ke favorite", Toast.LENGTH_SHORT).show()
        })


    }
}


