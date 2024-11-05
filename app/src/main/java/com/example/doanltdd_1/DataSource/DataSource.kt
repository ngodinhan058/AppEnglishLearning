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
        Vocabulary(1, R.drawable.ic_hand_icon, "apple", "noun", "/ˈæpl/", "A fruit", R.raw.active, 1),
        Vocabulary(2, R.drawable.ic_hand_icon, "run", "verb", "/rʌn/", "To move swiftly", R.raw.activity, 1),
        Vocabulary(3, R.drawable.ic_hand_icon, "run", "verb", "/rʌn/", "To move swiftly", R.raw.activity, 2),
        // Add more vocabulary items as needed
    )

    // Method to get vocabulary by Unit ID
    fun getVocabularyByUnitId(unitId: Int): List<Vocabulary> {
        return vocabularyList.filter { it.unitId == unitId }
    }

}