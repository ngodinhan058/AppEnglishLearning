package com.example.doanltdd_1.DataSource

import com.example.doanltdd_1.Entity.Unit
import com.example.doanltdd_1.Entity.Vocabulary
import com.example.doanltdd_1.R

object DataSource {
    val units = listOf(
        Unit(1,"Unit 1", R.drawable.ic_hand_icon),
        Unit(2,"Unit 2", R.drawable.ic_exercise),
        Unit(3,"Unit 3", R.drawable.ic_launcher_foreground),
        Unit(4,"Unit 4", R.drawable.ic_home),
        Unit(5,"Unit 5", R.drawable.ic_grammar),
        Unit(6,"Unit 6", R.drawable.ic_launcher_foreground),


    )
    // Sample list of vocabulary items
    val vocabularyList = listOf(
        Vocabulary(1, R.drawable.activity, "activity", "noun", "/ækˈtɪv.ə.ti/", "hoạt động", R.raw.activity, 1),
        Vocabulary(2, R.drawable.art, "art", "noun", "/ɑːt/", "nghệ thuật", R.raw.art, 1),
        Vocabulary(3, R.drawable.boarding_school, "boarding school", "noun", "/ˈbɔː.dɪŋ ˌskuːl/", "trường nội trú", R.raw.boarding_school, 1),
        Vocabulary(4, R.drawable.calculator, "calculator", "noun", "/ˈkæl.kjə.leɪ.tər/", "máy tính", R.raw.calculator, 1),
        Vocabulary(5, R.drawable.classmate, "classmate", "noun", "/ˈklɑːs.meɪt/", "bạn cùng lớp", R.raw.classmate, 1),
        Vocabulary(6, R.drawable.compass, "compass", "noun", "/ˈkʌm.pəs/", "com-pa", R.raw.compass, 1),
        Vocabulary(7, R.drawable.favorite, "favourite", "adjective", "/ˈfeɪ.vər.ɪt/", "được yêu thích", R.raw.favorite, 1),
        Vocabulary(8, R.drawable.help, "help", "noun, verb", "/help/", "sự giúp đỡ, giúp đỡ", R.raw.help, 1),
        Vocabulary(9, R.drawable.international, "international", "adjective", "/ˌɪn.təˈnæʃ.ən.əl/", "quốc tế", R.raw.international, 1),
        Vocabulary(10, R.drawable.interview, "interview", "noun, verb", "/ˈɪn.tə.vjuː/", "cuộc phỏng vấn, phỏng vấn", R.raw.interview, 1),
        Vocabulary(11, R.drawable.knock, "knock", "verb", "/nɒk/", "gõ (cửa)", R.raw.knock, 1),
        Vocabulary(12, R.drawable.remember, "remember", "verb", "/rɪˈmem.bər/", "nhớ, ghi nhớ", R.raw.remember, 1),
        Vocabulary(13, R.drawable.share, "share", "verb", "/ʃeər/", "chia sẻ", R.raw.share, 1),
        Vocabulary(14, R.drawable.smart, "smart", "adjective", "/smɑːt/", "bảnh bao, gọn gàng", R.raw.smart, 1),
        Vocabulary(15, R.drawable.swimming_pool, "swimming pool", "noun", "/ˈswɪm.ɪŋ ˌpuːl/", "bể bơi", R.raw.swimming_pool, 1),

        // Add more vocabulary items as needed
    )

    // Method to get vocabulary by Unit ID
    fun getVocabularyByUnitId(unitId: Int): List<Vocabulary> {
        return vocabularyList.filter { it.unitId == unitId }
    }

}