package com.dicoding.picodiploma.tugas1_made

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class movie_adapter internal constructor(private val context: Context): BaseAdapter(){
    internal var movie = ArrayList<Movie>()

    override fun getCount(): Int = movie.size
    override fun getItem(i : Int):Any = movie[i]
    override fun getItemId(i : Int):Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.listview_item, viewGroup, false)
        }
        val viewHolder = ViewHolder (itemView as View)

        val movie = getItem(position) as Movie
        viewHolder.bind(movie)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val txtTitle: TextView = view.findViewById(R.id.txt_title)
        private val txtrating: TextView = view.findViewById(R.id.rating)
        private val txtrelease: TextView = view.findViewById(R.id.release_date)
        private val txtDescription: TextView = view.findViewById(R.id.description)
        private val imgCover: ImageView = view.findViewById(R.id.movie_cover)

        internal fun bind(movie : Movie) {
            txtTitle.text = movie.title
            txtrating.text= movie.rating
            txtrelease.text = movie.release
            txtDescription.text = movie.description
            imgCover.setImageResource(movie.cover)
        }
    }

}