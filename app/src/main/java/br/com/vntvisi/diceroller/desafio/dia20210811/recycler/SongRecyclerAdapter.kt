package br.com.vntvisi.diceroller.desafio.dia20210811.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.vntvisi.diceroller.R
import br.com.vntvisi.diceroller.desafio.dia20210811.model.Song

class SongRecyclerAdapter(
    private val lista: List<Song>,
    private val onItemClickListener: ItemClickListener
) : RecyclerView.Adapter<SongRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song = lista[position]
        holder.bind(song, onItemClickListener)
    }

    override fun getItemCount(): Int = lista.size

    fun interface ItemClickListener {
        fun onClick(song: Song)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(song: Song, onItemClickListener: ItemClickListener) {
            itemView.apply {
                this.setOnClickListener { onItemClickListener.onClick(song) }
                this.findViewById<TextView>(R.id.desafio_recycler_view_song_name).text = song.name
                this.findViewById<TextView>(R.id.desafio_recycler_view_song_duration).text =
                    "[${song.duration}]"
            }
        }

    }
}