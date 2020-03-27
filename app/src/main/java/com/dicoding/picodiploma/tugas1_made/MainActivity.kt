package com.dicoding.picodiploma.tugas1_made

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.AdapterView
import android.widget.ListView
import com.dicoding.picodiploma.tugas1_made.act_detail_movie.Companion.PARSEL


class MainActivity : AppCompatActivity() {


    private lateinit var adapter: movie_adapter
    private lateinit var movieTitle: Array<String>
    private lateinit var movieRating: Array<String>
    private lateinit var movieRelease : Array<String>
    private lateinit var movieDescription: Array<String>
    private lateinit var movieCover: TypedArray
    private var movies = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = movie_adapter(this)
        listView.adapter = adapter
        prepare()
        addItem()

        //move intent dengan parcelable
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val move1 = Intent(this@MainActivity, act_detail_movie::class.java)
            move1.putExtra("parsel",movies[position])
            startActivity(move1)
        }
    }
    //resource
    private fun prepare() {
        movieTitle = resources.getStringArray(R.array.movie_title)
        movieRating = resources.getStringArray(R.array.movie_rating)
        movieRelease=resources.getStringArray(R.array.movie_release_date)
        movieDescription = resources.getStringArray(R.array.movie_description)
        movieCover = resources.obtainTypedArray(R.array.movie_cover)
    }
    private fun addItem() {
        for (position in movieTitle.indices) {
            val movie = Movie(

                movieTitle[position],
                movieRating[position],
                movieRelease[position],
                movieDescription[position],
                movieCover.getResourceId(position, -1)
            )
            movies.add(movie)
        }
        adapter.movie = movies
    }
}




