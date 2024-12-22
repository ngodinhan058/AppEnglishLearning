package com.example.doanltdd_1

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.doanltdd_1.Entity.AppDatabase
import com.example.doanltdd_1.Entity.Vocabulary
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class VocabularyActivity : AppCompatActivity() {
    private lateinit var frontCard: View
    private lateinit var backCard: View
    private lateinit var playAudioButton: ImageView
    private lateinit var playAudioButtonBack: ImageView
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button
    private lateinit var mediaPlayer: MediaPlayer
    private var isFrontVisible = true
    private var vocabularyList: List<Vocabulary> = emptyList()
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vocabulary_item)

        frontCard = findViewById(R.id.front_card)
        backCard = findViewById(R.id.back_card)


        playAudioButton = findViewById(R.id.button_play_audio)
        playAudioButtonBack = findViewById(R.id.button_play_audio_back)
        previousButton = findViewById(R.id.button_previous)
        nextButton = findViewById(R.id.button_next)
// Thiết lập cameraDistance trong code
        val scale :Float = resources.displayMetrics.density // Lấy mật độ màn hình
        frontCard.cameraDistance = 8000 * scale
        backCard.cameraDistance = 8000 * scale
        val unitId = intent.getIntExtra("unitId", -1)

        // Load data from Room database
        val database = AppDatabase.getDatabase(this)
        GlobalScope.launch {
            vocabularyList = database.vocabularyDao().getVocabularyByUnitId(unitId)
            if (vocabularyList.isNotEmpty()) {
                updateFlashcard()
            }
        }

        frontCard.setOnClickListener { flipCard() }
        backCard.setOnClickListener { flipCard() }

        playAudioButton.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this, vocabularyList[currentIndex].audioResId)
            mediaPlayer.start()
        }

        playAudioButtonBack.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this, vocabularyList[currentIndex].audioResId)
            mediaPlayer.start()
        }

        previousButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                updateFlashcard()
            }
        }

        nextButton.setOnClickListener {
            if (currentIndex < vocabularyList.size - 1) {
                currentIndex++
                updateFlashcard()
            }
        }
    }

    private fun flipCard() {
        val flipIn = AnimatorInflater.loadAnimator(this, R.animator.card_flip_in) as AnimatorSet
        val flipOut = AnimatorInflater.loadAnimator(this, R.animator.card_flip_out) as AnimatorSet

        if (isFrontVisible) {
            flipOut.setTarget(frontCard)
            flipIn.setTarget(backCard)

            flipOut.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    frontCard.visibility = View.GONE
                    backCard.visibility = View.VISIBLE
                    flipIn.start()
                }
            })
            flipOut.start()
        } else {
            flipOut.setTarget(backCard)
            flipIn.setTarget(frontCard)

            flipOut.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    backCard.visibility = View.GONE
                    frontCard.visibility = View.VISIBLE
                    flipIn.start()
                }
            })
            flipOut.start()
        }

        isFrontVisible = !isFrontVisible
    }



    private fun updateFlashcard() {
        val vocabulary = vocabularyList[currentIndex]
        findViewById<TextView>(R.id.flashcard_word).text = vocabulary.word
        findViewById<TextView>(R.id.flashcard_part_of_speech).text = vocabulary.partOfSpeech
        findViewById<TextView>(R.id.flashcard_phonetic).text = vocabulary.phonetic
        findViewById<ImageView>(R.id.flashcard_image).setImageResource(vocabulary.image)

        findViewById<TextView>(R.id.flashcard_part_of_speech_back).text = vocabulary.partOfSpeech
        findViewById<TextView>(R.id.flashcard_phonetic_back).text = vocabulary.phonetic
        findViewById<TextView>(R.id.flashcard_meaning).text = vocabulary.meaning
        findViewById<ImageView>(R.id.flashcard_image_back).setImageResource(vocabulary.image)

        previousButton.visibility = if (currentIndex == 0) View.INVISIBLE else View.VISIBLE
        nextButton.visibility = if (currentIndex == vocabularyList.size - 1) View.INVISIBLE else View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        if (this::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }
}
