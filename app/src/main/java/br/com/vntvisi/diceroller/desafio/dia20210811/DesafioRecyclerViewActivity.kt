package br.com.vntvisi.diceroller.desafio.dia20210811

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import br.com.vntvisi.diceroller.databinding.ActivityDesafioRecyclerViewBinding
import br.com.vntvisi.diceroller.desafio.dia20210811.db.SongData
import br.com.vntvisi.diceroller.desafio.dia20210811.recycler.SongRecyclerAdapter
import br.com.vntvisi.diceroller.desafio.dia20210811.recycler.SongRecyclerAdapter.ItemClickListener as SongRecyclerAdapterItemClickListener

class DesafioRecyclerViewActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDesafioRecyclerViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val itemClickListener = SongRecyclerAdapterItemClickListener { song ->
            Toast.makeText(
                this,
                "${song.name} has ${song.duration}", Toast.LENGTH_SHORT
            ).show()
        }

        val recyclerView = binding.desafioRecyclerViewList
        val adapter = SongRecyclerAdapter(SongData().loadSongs(), itemClickListener)
        val layoutManager = LinearLayoutManager(this, VERTICAL, false)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}