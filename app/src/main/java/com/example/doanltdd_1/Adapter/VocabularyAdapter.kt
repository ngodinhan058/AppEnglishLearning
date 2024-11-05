package com.example.doanltdd_1.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doanltdd_1.Entity.Vocabulary
import com.example.doanltdd_1.R

import android.media.MediaPlayer
import android.widget.Button

class VocabularyAdapter(private val vocabList: List<Vocabulary>) : RecyclerView.Adapter<VocabularyAdapter.VocabularyViewHolder>() {

    class VocabularyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val word: TextView = itemView.findViewById(R.id.vocabulary_word)
        val partOfSpeech: TextView = itemView.findViewById(R.id.vocabulary_part_of_speech)
        val phonetic: TextView = itemView.findViewById(R.id.vocabulary_phonetic)
        val meaning: TextView = itemView.findViewById(R.id.vocabulary_meaning)
        val image: ImageView = itemView.findViewById(R.id.vocabulary_image)
        val playButton: Button = itemView.findViewById(R.id.play_audio_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VocabularyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vocabulary_item, parent, false)
        return VocabularyViewHolder(view)
    }

    override fun onBindViewHolder(holder: VocabularyViewHolder, position: Int) {
        val vocabulary = vocabList[position]
        holder.word.text = vocabulary.word
        holder.partOfSpeech.text = vocabulary.partOfSpeech
        holder.phonetic.text = vocabulary.phonetic
        holder.meaning.text = vocabulary.meaning
        holder.image.setImageResource(vocabulary.image)

        holder.playButton.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(holder.itemView.context, vocabulary.audioResId)
            mediaPlayer.start()

            mediaPlayer.setOnCompletionListener {
                mediaPlayer.release() // Release resources after playback
            }
        }
    }

    override fun getItemCount() = vocabList.size
}


