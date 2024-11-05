package com.example.doanltdd_1

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.doanltdd_1.DataSource.DataSource
import com.example.doanltdd_1.Entity.Vocabulary

class VocabularyActivity : AppCompatActivity() {
    private lateinit var frontCard: View
    private lateinit var backCard: View
    private lateinit var playAudioButton: ImageView
    private lateinit var playAudioButtonBack: ImageView
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button
    private lateinit var mediaPlayer: MediaPlayer
    private var isFrontVisible = true
    private lateinit var vocabularyList: List<Vocabulary>
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

        // Thiết lập dữ liệu và hiển thị từ đầu tiên
        vocabularyList = DataSource.getVocabularyByUnitId(intent.getIntExtra("unitId", -1))
        updateFlashcard()

        // Hiệu ứng lật khi nhấn vào flashcard
        frontCard.setOnClickListener { flipCard() }
        backCard.setOnClickListener { flipCard() }

        // Phát âm thanh
        playAudioButton.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this, vocabularyList[currentIndex].audioResId)
            mediaPlayer.start()
        }
        // Phát âm thanh sau
        playAudioButtonBack.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this, vocabularyList[currentIndex].audioResId)
            mediaPlayer.start()
        }

        // Nút Previous
        previousButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                updateFlashcard()
            }
        }

        // Nút Next
        nextButton.setOnClickListener {
            if (currentIndex < vocabularyList.size - 1) {
                currentIndex++
                updateFlashcard()
            }
        }
    }

    private fun flipCard() {
        val flipIn = AnimationUtils.loadAnimation(this, R.anim.card_flip_in)
        val flipOut = AnimationUtils.loadAnimation(this, R.anim.card_flip_out)

        if (isFrontVisible) {
            frontCard.startAnimation(flipOut)
            frontCard.visibility = View.GONE
            backCard.visibility = View.VISIBLE
            backCard.startAnimation(flipIn)
        } else {
            backCard.startAnimation(flipOut)
            backCard.visibility = View.GONE
            frontCard.visibility = View.VISIBLE
            frontCard.startAnimation(flipIn)
        }
        isFrontVisible = !isFrontVisible
    }


    private fun updateFlashcard() {
        val vocabulary = vocabularyList[currentIndex]
        //Mặt Trước
        findViewById<TextView>(R.id.flashcard_word).text = vocabulary.word
        findViewById<TextView>(R.id.flashcard_part_of_speech).text = vocabulary.partOfSpeech
        findViewById<TextView>(R.id.flashcard_phonetic).text = vocabulary.phonetic
        findViewById<ImageView>(R.id.flashcard_image).setImageResource(vocabulary.image)
        //Mặt Sau
        findViewById<TextView>(R.id.flashcard_part_of_speech_back).text = vocabulary.partOfSpeech
        findViewById<TextView>(R.id.flashcard_phonetic_back).text = vocabulary.phonetic
        findViewById<TextView>(R.id.flashcard_meaning).text = vocabulary.meaning
        findViewById<ImageView>(R.id.flashcard_image_back).setImageResource(vocabulary.image)

        // Kiểm tra nếu đến cuối hoặc đầu danh sách để ẩn hiện nút
        previousButton.visibility = if (currentIndex == 0) View.INVISIBLE else View.VISIBLE
        nextButton.visibility = if (currentIndex == vocabularyList.size - 1) View.INVISIBLE else View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
