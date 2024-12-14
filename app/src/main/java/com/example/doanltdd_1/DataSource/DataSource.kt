package com.example.doanltdd_1.DataSource

import com.example.doanltdd_1.Entity.Question
import com.example.doanltdd_1.Entity.Unit
import com.example.doanltdd_1.Entity.Vocabulary
import com.example.doanltdd_1.R

object DataSource {
    val units = listOf(
        Unit(1, "Unit 1", R.drawable.ic_hand_icon),
        Unit(2, "Unit 2", R.drawable.ic_exercise),
        Unit(3, "Unit 3", R.drawable.ic_launcher_foreground),
        Unit(4, "Unit 4", R.drawable.ic_home),
        Unit(5, "Unit 5", R.drawable.ic_grammar),
        Unit(6, "Unit 6", R.drawable.ic_launcher_foreground),


        )

    // Sample list of vocabulary items
    val vocabularyList = listOf(
        Vocabulary(
            1,
            R.drawable.activity,
            "activity",
            "noun",
            "/ækˈtɪv.ə.ti/",
            "hoạt động",
            R.raw.activity,
            1
        ),
        Vocabulary(2, R.drawable.art, "art", "noun", "/ɑːt/", "nghệ thuật", R.raw.art, 1),
        Vocabulary(
            3,
            R.drawable.boarding_school,
            "boarding school",
            "noun",
            "/ˈbɔː.dɪŋ ˌskuːl/",
            "trường nội trú",
            R.raw.boarding_school,
            1
        ),
        Vocabulary(
            4,
            R.drawable.calculator,
            "calculator",
            "noun",
            "/ˈkæl.kjə.leɪ.tər/",
            "máy tính",
            R.raw.calculator,
            1
        ),
        Vocabulary(
            5,
            R.drawable.classmate,
            "classmate",
            "noun",
            "/ˈklɑːs.meɪt/",
            "bạn cùng lớp",
            R.raw.classmate,
            1
        ),
        Vocabulary(
            6,
            R.drawable.compass,
            "compass",
            "noun",
            "/ˈkʌm.pəs/",
            "com-pa",
            R.raw.compass,
            1
        ),
        Vocabulary(
            7,
            R.drawable.favorite,
            "favourite",
            "adjective",
            "/ˈfeɪ.vər.ɪt/",
            "được yêu thích",
            R.raw.favorite,
            1
        ),
        Vocabulary(
            8,
            R.drawable.help,
            "help",
            "noun, verb",
            "/help/",
            "sự giúp đỡ, giúp đỡ",
            R.raw.help,
            1
        ),
        Vocabulary(
            9,
            R.drawable.international,
            "international",
            "adjective",
            "/ˌɪn.təˈnæʃ.ən.əl/",
            "quốc tế",
            R.raw.international,
            1
        ),
        Vocabulary(
            10,
            R.drawable.interview,
            "interview",
            "noun, verb",
            "/ˈɪn.tə.vjuː/",
            "cuộc phỏng vấn, phỏng vấn",
            R.raw.interview,
            1
        ),
        Vocabulary(11, R.drawable.knock, "knock", "verb", "/nɒk/", "gõ (cửa)", R.raw.knock, 1),
        Vocabulary(
            12,
            R.drawable.remember,
            "remember",
            "verb",
            "/rɪˈmem.bər/",
            "nhớ, ghi nhớ",
            R.raw.remember,
            1
        ),
        Vocabulary(13, R.drawable.share, "share", "verb", "/ʃeər/", "chia sẻ", R.raw.share, 1),
        Vocabulary(
            14,
            R.drawable.smart,
            "smart",
            "adjective",
            "/smɑːt/",
            "bảnh bao, gọn gàng",
            R.raw.smart,
            1
        ),
        Vocabulary(
            15,
            R.drawable.swimming_pool,
            "swimming pool",
            "noun",
            "/ˈswɪm.ɪŋ ˌpuːl/",
            "bể bơi",
            R.raw.swimming_pool,
            1
        ),

        // Add more vocabulary items as needed
    )

    val questions = listOf(


        Question(
            id = 1,
            text = "I______ know the correct answer.",
            answers = listOf("am not", "not", "don’t", "doesn’t"),
            correctAnswerIndex = 2,
            idUnit = 1
        ),


        Question(
            id = 2,
            text = "They ______ agree with my opinion.",
            answers = listOf("are", "don’t", "aren’t", "do"),
            correctAnswerIndex = 1,
            idUnit = 1
        ),


        Question(
            id = 3,
            text = "Kathy usually ______ in front of the window during the class.",
            answers = listOf("sits", "sitting", "sit", "is sit"),
            correctAnswerIndex = 0,
            idUnit = 1
        ),


        Question(
            id = 4,
            text = "What does this word ______?",
            answers = listOf("means", "meaning", "mean", "is mean"),
            correctAnswerIndex = 2,
            idUnit = 1
        ),


        Question(
            id = 5,
            text = "He ______ share anything to me.",
            answers = listOf("don’t do", "isn’t", "not", "doesn’t"),
            correctAnswerIndex = 3,
            idUnit = 1
        ),


        Question(
            id = 6,
            text = "I come from Canada. Where ______ you come from?",
            answers = listOf("are", "do", "is", "not"),
            correctAnswerIndex = 1,
            idUnit = 1
        ),


        Question(
            id = 7,
            text = "Jane ______ tea very often.",
            answers = listOf("doesn’t drink", "drink", "is drink", "isn’t drink"),
            correctAnswerIndex = 0,
            idUnit = 1
        ),


        Question(
            id = 8,
            text = "How often ______ you play tennis?",
            answers = listOf("do", "are", "is", "play"),
            correctAnswerIndex = 0,
            idUnit = 1
        ),


        Question(
            id = 9,
            text = "Rice ______ in cold climates.",
            answers = listOf("isn’t grow", "don’t grow", "aren’t grow", "doesn’t grow"),
            correctAnswerIndex = 3,
            idUnit = 1
        ),


        Question(
            id = 10,
            text = "I ______ a compass and a calculator in Maths lesson.",
            answers = listOf("am use", "use", "aren’t use", "doesn’t use"),
            correctAnswerIndex = 1,
            idUnit = 1
        ),

        // Unit 2
        Question(
            id = 11,
            text = "I sit ______ Sarah at school.",
            answers = listOf("on", "next to", "between", "above"),
            correctAnswerIndex = 1,
            idUnit = 2
        ),


        Question(
            id = 12,
            text = "Our family stays ______ a stilt house.",
            answers = listOf("in", "on", "in front of", "between"),
            correctAnswerIndex = 0,
            idUnit = 2
        ),


        Question(
            id = 13,
            text = "There are four students at each table ___ me is my friend Justine.",
            answers = listOf("in front of", "near to", "opposite", "behind"),
            correctAnswerIndex = 0,
            idUnit = 2
        ),


        Question(
            id = 14,
            text = "Tom sits ______ Lucy and James.",
            answers = listOf("between", "in front of", "near to", "beside"),
            correctAnswerIndex = 0,
            idUnit = 2
        ),


        Question(
            id = 15,
            text = "We have posters ______ the walls.",
            answers = listOf("on", "above", "under", "behind"),
            correctAnswerIndex = 0,
            idUnit = 2
        ),


        Question(
            id = 16,
            text = "______ the teacher's desk is a clock.",
            answers = listOf("opposite", "above", "next to", "beside"),
            correctAnswerIndex = 1,
            idUnit = 2
        ),


        Question(
            id = 17,
            text = "There's a wastepaper basket ______ her desk.",
            answers = listOf("on", "under", "between", "behind"),
            correctAnswerIndex = 1,
            idUnit = 2
        ),


        Question(
            id = 18,
            text = "Joe and Alan sit ______ each other.",
            answers = listOf("between", "beside", "next", "near"),
            correctAnswerIndex = 1,
            idUnit = 2
        ),


        Question(
            id = 19,
            text = "We had sandwiches ______ a pretty fountain.",
            answers = listOf("by", "on", "in", "near"),
            correctAnswerIndex = 0,
            idUnit = 2
        ),


        Question(
            id = 20,
            text = "You need to walk ______ this road quickly. There's lots of traffic.",
            answers = listOf("across", "by", "on", "near"),
            correctAnswerIndex = 0,
            idUnit = 2
        ),

        // Unit 3
        Question(
            id = 21,
            text = "He is at the bank. He _______ money from his account.",
            answers = listOf("is drawing", "is studying", "is sunbathing", "is making"),
            correctAnswerIndex = 0,
            idUnit = 3
        ),


        Question(
            id = 22,
            text = "He is in the library. He ______",
            answers = listOf("is waiting", "is posting", "is reading", "is coming"),
            correctAnswerIndex = 2,
            idUnit = 3
        ),


        Question(
            id = 23,
            text = "He is in the garden. He ______ the flowers.",
            answers = listOf("is watering", "is waiting", "is studying", "is posting"),
            correctAnswerIndex = 0,
            idUnit = 3
        ),


        Question(
            id = 24,
            text = "She is on the beach. She ______",
            answers = listOf("is waiting", "is reading", "is sunbathing", "is speaking"),
            correctAnswerIndex = 2,
            idUnit = 3
        ),


        Question(
            id = 25,
            text = "He is in the post office. He ______ letter.",
            answers = listOf("is waiting", "is posting", "is drawing", "is watering"),
            correctAnswerIndex = 1,
            idUnit = 3
        ),


        Question(
            id = 26,
            text = "He is in the telephone box. He ______ a call.",
            answers = listOf("is making", "is coming", "is studying", "is drawing"),
            correctAnswerIndex = 0,
            idUnit = 3
        ),


        Question(
            id = 27,
            text = "We ______ English at the moment.",
            answers = listOf("are posting", "are studying", "are coming", "are waiting"),
            correctAnswerIndex = 1,
            idUnit = 3
        ),


        Question(
            id = 28,
            text = "Look! David and Max ______ home.",
            answers = listOf("are waiting", "are coming", "are speaking", "are drawing"),
            correctAnswerIndex = 1,
            idUnit = 3
        ),


        Question(
            id = 29,
            text = "She ______ for her boyfriend now.",
            answers = listOf("is drawing", "is making", "is waiting", "is studying"),
            correctAnswerIndex = 2,
            idUnit = 3
        ),


        Question(
            id = 30,
            text = "I ______ to a dentist.",
            answers = listOf("am waiting", "am posting", "am speaking", "am coming"),
            correctAnswerIndex = 0,
            idUnit = 3
        ),


        // Unit 4
        Question(
            id = 31,
            text = "David was ……….. than John.",
            answers = listOf("more good", "better", "go", "more better"),
            correctAnswerIndex = 1,
            idUnit = 4
        ),


        Question(
            id = 32,
            text = "This building is ……….. than that one.",
            answers = listOf("beautiful", "more beautiful", "beautifuler", "more beautifuller"),
            correctAnswerIndex = 1,
            idUnit = 4
        ),


        Question(
            id = 33,
            text = "Dorothy promised to be ……….. with her money.",
            answers = listOf("careful", "carefuler", "more careful", "carefuller"),
            correctAnswerIndex = 2,
            idUnit = 4
        ),


        Question(
            id = 34,
            text = "New York’s population is ……….. than San Francisco’s.",
            answers = listOf("larger", "large", "more large", "largerest"),
            correctAnswerIndex = 0,
            idUnit = 4
        ),


        Question(
            id = 35,
            text = "This old machine is ……….. than we thought.",
            answers = listOf("more powerful", "powerful", "powerfuler", "most powerful"),
            correctAnswerIndex = 0,
            idUnit = 4
        ),


        Question(
            id = 36,
            text = "We’ve got … time than I thought.",
            answers = listOf("little", "more little", "less", "littler"),
            correctAnswerIndex = 2,
            idUnit = 4
        ),


        Question(
            id = 37,
            text = "People are not friendly in big cities. They are usually… than in small towns.",
            answers = listOf("friendly", "more friendly", "friendlier", "friendliest"),
            correctAnswerIndex = 2,
            idUnit = 4
        ),


        Question(
            id = 38,
            text = "Mary is 10 years old. Julie is 8 years old. Mary is … than Julie.",
            answers = listOf("older", "elder", "more old", "oldest"),
            correctAnswerIndex = 0,
            idUnit = 4
        ),


        Question(
            id = 39,
            text = "The road is … than the motorway.",
            answers = listOf("narrow", "narrower", "more narrow", "most narrow"),
            correctAnswerIndex = 1,
            idUnit = 4
        ),


        Question(
            id = 40,
            text = "It’s … than it looks.",
            answers = listOf("badder", "worse", "more bad", "worser"),
            correctAnswerIndex = 1,
            idUnit = 4
        ),

        // Unit 5
        Question(
            id = 41,
            text = "You……………tidy up room.",
            answers = listOf("must", "don't have to", "have to", "mustn't"),
            correctAnswerIndex = 2,
            idUnit = 5
        ),


        Question(
            id = 42,
            text = "It’s late. You ……………make so much noise.",
            answers = listOf("mustn't", "must", "don't have to", "have to"),
            correctAnswerIndex = 0,
            idUnit = 5
        ),


        Question(
            id = 43,
            text = "You……………smoke.",
            answers = listOf("mustn't", "must", "have to", "don't have to"),
            correctAnswerIndex = 0,
            idUnit = 5
        ),


        Question(
            id = 44,
            text = "We……………be home by 9 o’clock. The film starts at 9=15.",
            answers = listOf("have to", "mustn't", "don't have to", "must"),
            correctAnswerIndex = 3,
            idUnit = 5
        ),


        Question(
            id = 45,
            text = "You …………… do your homework.",
            answers = listOf("must", "have to", "don't have to", "mustn't"),
            correctAnswerIndex = 0,
            idUnit = 5
        ),


        Question(
            id = 46,
            text = "I …………… finish this essay today. It has to be handed in by tomorrow.",
            answers = listOf("must", "don't have to", "have to", "mustn't"),
            correctAnswerIndex = 2,
            idUnit = 5
        ),


        Question(
            id = 47,
            text = "Passengers…………… talk to the driver whilst the bus is in motion.",
            answers = listOf("mustn't", "don't have to", "have to", "must"),
            correctAnswerIndex = 0,
            idUnit = 5
        ),


        Question(
            id = 48,
            text = "You …………… play with fire.",
            answers = listOf("mustn't", "must", "don't have to", "have to"),
            correctAnswerIndex = 0,
            idUnit = 5
        ),


        Question(
            id = 49,
            text = "The rules……………be obeyed at all times! shouted the headmaster.",
            answers = listOf("must", "mustn't", "don't have to", "have to"),
            correctAnswerIndex = 0,
            idUnit = 5
        ),


        Question(
            id = 50,
            text = "I……………go. Otherwise I'll miss my train.",
            answers = listOf("have to", "mustn't", "must", "don't have to"),
            correctAnswerIndex = 2,
            idUnit = 5
        ),


        Question(
            id = 51,
            text = "I……………be home at one o'clock. Otherwise, my mother will kill me.",
            answers = listOf("must", "have to", "mustn't", "don't have to"),
            correctAnswerIndex = 1,
            idUnit = 5
        ),


        Question(
            id = 52,
            text = "You…………… play tennis to enjoy watching tennis matches.",
            answers = listOf("don't have to", "mustn't", "have to", "must"),
            correctAnswerIndex = 0,
            idUnit = 5
        ),


        Question(
            id = 53,
            text = "You…………… buy me presents though I always appreciate it when you do.",
            answers = listOf("don't have to", "mustn't", "must", "have to"),
            correctAnswerIndex = 0,
            idUnit = 5
        ),


        Question(
            id = 54,
            text = "It's really important to remember. You……………forget.",
            answers = listOf("mustn't", "must", "have to", "don't have to"),
            correctAnswerIndex = 0,
            idUnit = 5
        ),


        Question(
            id = 55,
            text = "You……………tell anybody. It is a big secret.",
            answers = listOf("mustn't", "must", "don't have to", "have to"),
            correctAnswerIndex = 0,
            idUnit = 5
        ),


        Question(
            id = 56,
            text = "We are already late. We……………waste any more time.",
            answers = listOf("mustn't", "must", "have to", "don't have to"),
            correctAnswerIndex = 0,
            idUnit = 5
        ),


        Question(
            id = 57,
            text = "This is a sterile area. It must be kept clean. You……………bring any food or drink in here.",
            answers = listOf("mustn't", "don't have to", "have to", "must"),
            correctAnswerIndex = 0,
            idUnit = 5
        ),


        Question(
            id = 58,
            text = "You……………come at 8.00. Come at whatever time suits you.",
            answers = listOf("don't have to", "mustn't", "have to", "must"),
            correctAnswerIndex = 0,
            idUnit = 5
        ),


        Question(
            id = 59,
            text = "You……………smoke in this area. It is forbidden.",
            answers = listOf("mustn't", "don't have to", "must", "have to"),
            correctAnswerIndex = 0,
            idUnit = 5
        ),


        Question(
            id = 60,
            text = "I……………go back again. The treatment is finished.",
            answers = listOf("don't have to", "must", "mustn't", "have to"),
            correctAnswerIndex = 0,
            idUnit = 5
        ),
        // Unit 6
        Question(
            id = 61,
            text = "If you have time you should............................ the National Museum.",
            answers = listOf("clean", "visit", "fasten", "watch"),
            correctAnswerIndex = 1,
            idUnit = 6
        ),


        Question(
            id = 62,
            text = "When you are driving a car, you should. .........................your seatbelt.",
            answers = listOf("study", "visit", "eat", "fasten"),
            correctAnswerIndex = 3,
            idUnit = 6
        ),


        Question(
            id = 63,
            text = "When you play football, you should    .........................the ball.",
            answers = listOf("fasten", "take", "clean", "watch"),
            correctAnswerIndex = 3,
            idUnit = 6
        ),


        Question(
            id = 64,
            text = "It's late and you are tired. You should...................... to bed.",
            answers = listOf("eat", "go", "take", "study"),
            correctAnswerIndex = 1,
            idUnit = 6
        ),


        Question(
            id = 65,
            text = "You should  .....................your teeth at least twice a day.",
            answers = listOf("fasten", "clean", "visit", "watch"),
            correctAnswerIndex = 1,
            idUnit = 6
        ),


        Question(
            id = 66,
            text = "It's too far from here. You should....................a taxi to get there.",
            answers = listOf("study", "take", "go", "eat"),
            correctAnswerIndex = 1,
            idUnit = 6
        ),


        Question(
            id = 67,
            text = "If you want to pass the exam, you should....................more.",
            answers = listOf("clean", "study", "visit", "fasten"),
            correctAnswerIndex = 1,
            idUnit = 6
        ),


        Question(
            id = 68,
            text = "He wants to lose weight, so he should.................... less.",
            answers = listOf("watch", "clean", "eat", "go"),
            correctAnswerIndex = 2,
            idUnit = 6
        ),


        Question(
            id = 69,
            text = "It's raining now. I think you should....................an umbrella.",
            answers = listOf("eat", "fasten", "take", "study"),
            correctAnswerIndex = 2,
            idUnit = 6
        ),


        Question(
            id = 70,
            text = "He is ill. He should............................ at home.",
            answers = listOf("stay", "watch", "go", "clean"),
            correctAnswerIndex = 0,
            idUnit = 6
        ),

        // Unit 7
        Question(
            id = 71,
            text = "Do you know……………language is spoken in Kenya?",
            answers = listOf("which", "who", "What", "how"),
            correctAnswerIndex = 0,
            idUnit = 7
        ),


        Question(
            id = 72,
            text = "…………is your blood type?",
            answers = listOf("which", "who", "What", "how"),
            correctAnswerIndex = 2,
            idUnit = 7
        ),


        Question(
            id = 73,
            text = "……do you play tennis? For exercise",
            answers = listOf("which", "who", "What", "why"),
            correctAnswerIndex = 3,
            idUnit = 7
        ),


        Question(
            id = 74,
            text = "…………..can I buy some milk? At the supermarket.",
            answers = listOf("which", "where", "What", "how"),
            correctAnswerIndex = 1,
            idUnit = 7
        ),


        Question(
            id = 75,
            text = "………..much do you weigh?",
            answers = listOf("which", "who", "What", "how"),
            correctAnswerIndex = 3,
            idUnit = 7
        ),


        Question(
            id = 76,
            text = "………hat is this? It’s my brother’s.",
            answers = listOf("which", "who", "What", "whose"),
            correctAnswerIndex = 3,
            idUnit = 7
        ),


        Question(
            id = 77,
            text = "…………can I park my car? Over there.",
            answers = listOf("where", "who", "What", "how"),
            correctAnswerIndex = 0,
            idUnit = 7
        ),


        Question(
            id = 78,
            text = "……tall are you?",
            answers = listOf("which", "who", "What", "how"),
            correctAnswerIndex = 3,
            idUnit = 7
        ),


        Question(
            id = 79,
            text = "……….do you like your tea? I like it with cream and sugar.",
            answers = listOf("which", "who", "What", "how"),
            correctAnswerIndex = 3,
            idUnit = 7
        ),


        Question(
            id = 80,
            text = "……picture do you prefer – this one or that one?",
            answers = listOf("which", "who", "What", "how"),
            correctAnswerIndex = 0,
            idUnit = 7
        ),


        Question(
            id = 81,
            text = "……………….is that woman? I think she is a teacher.",
            answers = listOf("which", "who", "What", "how"),
            correctAnswerIndex = 1,
            idUnit = 7
        ),


        Question(
            id = 82,
            text = "…………book is this? It’s mine.",
            answers = listOf("which", "who", "What", "whose"),
            correctAnswerIndex = 3,
            idUnit = 7
        ),


        Question(
            id = 83,
            text = "……………….do you usually eat lunch? At noon.",
            answers = listOf("which", "who", "What", "when"),
            correctAnswerIndex = 3,
            idUnit = 7
        ),


        Question(
            id = 84,
            text = "……..does your father work? At City Hall.",
            answers = listOf("which", "where", "What", "how"),
            correctAnswerIndex = 1,
            idUnit = 7
        ),


        Question(
            id = 85,
            text = "……usually gets up the earliest in your family?",
            answers = listOf("which", "who", "What", "how"),
            correctAnswerIndex = 1,
            idUnit = 7
        ),


        Question(
            id = 86,
            text = "…………….do you think of this hotel? It’s pretty good.",
            answers = listOf("which", "who", "What", "how"),
            correctAnswerIndex = 3,
            idUnit = 7
        ),


        Question(
            id = 87,
            text = "………..does your father work at that company? Because It’s near our house.",
            answers = listOf("which", "why", "What", "how"),
            correctAnswerIndex = 1,
            idUnit = 7
        ),


        Question(
            id = 88,
            text = "……..dances the best in your family?",
            answers = listOf("which", "who", "What", "how"),
            correctAnswerIndex = 1,
            idUnit = 7
        ),

        // Unit 8
        Question(
            id = 89,
            text = "They_________the bus yesterday.",
            answers = listOf("don’t catch", "weren’t catch", "didn’t catch", "not catch"),
            correctAnswerIndex = 2,
            idUnit = 8
        ),


        Question(
            id = 90,
            text = "My sister_________home last night.",
            answers = listOf("comes", "come", "came", "was come"),
            correctAnswerIndex = 2,
            idUnit = 8
        ),


        Question(
            id = 91,
            text = "My father_________tired when I _________ home.",
            answers = listOf("was – got", "is – get", "was – getted", "were – got"),
            correctAnswerIndex = 0,
            idUnit = 8
        ),


        Question(
            id = 92,
            text = "What_________you_________two days ago?",
            answers = listOf("do – do", "did – did", "do – did", "did – do"),
            correctAnswerIndex = 3,
            idUnit = 8
        ),


        Question(
            id = 93,
            text = "Where_________your family_________on the summer holiday last year?",
            answers = listOf("do – go", "does – go", "did – go", "did – went"),
            correctAnswerIndex = 2,
            idUnit = 8
        ),

        Question(
            id = 94,
            text = "We_________David in town a few days ago.",
            answers = listOf("did see", "was saw", "did saw", "saw"),
            correctAnswerIndex = 3,
            idUnit = 8
        ),


        Question(
            id = 95,
            text = "It was cold, so I_________ the window.",
            answers = listOf("shut", "was shut", "am shut", "shutted"),
            correctAnswerIndex = 0,
            idUnit = 8
        ),


        Question(
            id = 96,
            text = "I_________to the cinema three times last week.",
            answers = listOf("was go", "went", "did go", "goed"),
            correctAnswerIndex = 1,
            idUnit = 8
        ),


        Question(
            id = 97,
            text = "What_________you_________last weekend?",
            answers = listOf("were/do", "did/did", "did/do", "do/did"),
            correctAnswerIndex = 2,
            idUnit = 8
        ),


        Question(
            id = 98,
            text = "The police_________on my way home last night.",
            answers = listOf("was stop", "stopped", "stops", "stopping"),
            correctAnswerIndex = 1,
            idUnit = 8
        ),

        Question(
            id = 99,
            text = "The film wasn’t very good. I_________ it very much.",
            answers = listOf("enjoyed", "wasn’t enjoy", "didn’t enjoyed", "didn’t enjoy"),
            correctAnswerIndex = 3,
            idUnit = 8
        ),


        Question(
            id = 100,
            text = "The bed was very uncomfortable. I_________sleep very well.",
            answers = listOf("didn’t", "did", "wasn’t", "not"),
            correctAnswerIndex = 0,
            idUnit = 8
        ),


        Question(
            id = 101,
            text = "The window was opened and a bird_________into the room.",
            answers = listOf("fly", "flew", "was flew", "did fly"),
            correctAnswerIndex = 1,
            idUnit = 8
        ),


        Question(
            id = 102,
            text = "I_________a lot of money yesterday. I_________an expensive dress.",
            answers = listOf("spend/buy", "spent/buy", "spent/bought", "was spent/bought"),
            correctAnswerIndex = 2,
            idUnit = 8
        ),

        // Unit 9
        Question(
            id = 103,
            text = "This isn’t her skirt. ________ is blue.",
            answers = listOf("Hers", "Her", "She", "He"),
            correctAnswerIndex = 0,
            idUnit = 9
        ),

        Question(
            id = 104,
            text = "______ daughter is a teacher.",
            answers = listOf("Our", "Ours", "Us", "We"),
            correctAnswerIndex = 0,
            idUnit = 9
        ),


        Question(
            id = 105,
            text = "This is my new dress. Look at _____!",
            answers = listOf("I", "mine", "me", "my"),
            correctAnswerIndex = 2,
            idUnit = 9
        ),


        Question(
            id = 106,
            text = "Linda is _______ cousin.",
            answers = listOf("him", "he", "he’s", "his"),
            correctAnswerIndex = 3,
            idUnit = 9
        ),

        Question(
            id = 107,
            text = "This craft isn’t mine. It’s _______.",
            answers = listOf("Him", "She", "Hers", "Them"),
            correctAnswerIndex = 2,
            idUnit = 9
        ),
        Question(
            id = 108,
            text = "Take an umbrella with you when you go out. It  _________ later.",
            answers = listOf("might sun", "might heat", "might rain", "might cool"),
            correctAnswerIndex = 2,
            idUnit = 10
        ),

        Question(
            id = 109,
            text = "Don’t make too much noise. You ______ the baby.",
            answers = listOf("might sleep", "might wake", "might rest", "might calm"),
            correctAnswerIndex = 1,
            idUnit = 10
        ),

        Question(
            id = 110,
            text = "Be careful of that dog. It ____ you.",
            answers = listOf("might bark", "might meow", "might lick", "might bite"),
            correctAnswerIndex = 3,
            idUnit = 10
        ),

        Question(
            id = 111,
            text = "I don’t think we should throw that letter away. We ______ it later.",
            answers = listOf("might need", "might lose", "might find", "might give"),
            correctAnswerIndex = 0,
            idUnit = 10
        ),

        Question(
            id = 112,
            text = "Be careful. The footbath is very icy. You ______",
            answers = listOf("might slip", "might walk", "might slide", "might step"),
            correctAnswerIndex = 0,
            idUnit = 10
        ),

        Question(
            id = 113,
            text = "Don’t let the children play in this room. They ______ something.",
            answers = listOf("might fix", "might break", "might build", "might paint"),
            correctAnswerIndex = 1,
            idUnit = 10
        ),
        // Unit 11
        Question(
            id = 114,
            text = "My dog ___ bark unless it is hungry.",
            answers = listOf("won’t", "don’t", "will", "doesn't"),
            correctAnswerIndex = 0,
            idUnit = 11
        ),

        Question(
            id = 115,
            text = "Unless you ___ to go to bed early, we should go out.",
            answers = listOf("want", "wants", "go", "goes"),
            correctAnswerIndex = 0,
            idUnit = 11
        ),

        Question(
            id = 116,
            text = "___ you don’t slow down, we are going to crash!",
            answers = listOf("Unless", "If", "When", "Since"),
            correctAnswerIndex = 0,
            idUnit = 11
        ),

        Question(
            id = 117,
            text = "You cannot go into bars ___ you are over 18.",
            answers = listOf("unless", "if", "when", "since"),
            correctAnswerIndex = 0,
            idUnit = 11
        ),

        Question(
            id = 118,
            text = "In my country, ____ you cannot speak English, it’s hard to get a good job.",
            answers = listOf("unless", "if", "when", "since"),
            correctAnswerIndex = 0,
            idUnit = 11
        ),

        Question(
            id = 119,
            text = "She’ll fail the exam if she ___ study.",
            answers = listOf("doesn’t", "if", "won't", "didn't"),
            correctAnswerIndex = 0,
            idUnit = 11
        ),

        Question(
            id = 120,
            text = "We’ll be late ____ we leave soon.",
            answers = listOf("unless", "if", "since", "when"),
            correctAnswerIndex = 0,
            idUnit = 11
        ),

        Question(
            id = 121,
            text = "___ I am not feeling better tomorrow I will go to the doctor’s.",
            answers = listOf("If", "Unless", "Since", "When"),
            correctAnswerIndex = 0,
            idUnit = 11
        ),

        Question(
            id = 122,
            text = "____ you do not make the payment in time, your car will be confiscated.",
            answers = listOf("If", "Unless", "When", "Since"),
            correctAnswerIndex = 0,
            idUnit = 11
        ),

        Question(
            id = 123,
            text = "You will lose your job ___ you change your attitude and become friendlier.",
            answers = listOf("if", "unless", "since", "when"),
            correctAnswerIndex = 1,
            idUnit = 11
        ),

        Question(
            id = 124,
            text = "She won’t know the truth ___ you tell it to her.",
            answers = listOf("if", "unless", "since", "when"),
            correctAnswerIndex = 1,
            idUnit = 11
        ),

        Question(
            id = 125,
            text = "____ you arrive early, you’ll be able to meet the customers before the meeting.",
            answers = listOf("If", "Unless", "Since", "When"),
            correctAnswerIndex = 0,
            idUnit = 11
        ),

        Question(
            id = 126,
            text = "____ she eats healthy food, she won’t lose some weight.",
            answers = listOf("If", "Unless", "Since", "When"),
            correctAnswerIndex = 1,
            idUnit = 11
        ),

        Question(
            id = 127,
            text = "They won’t arrive on time ___ they finish the work early.",
            answers = listOf("if", "unless", "since", "when"),
            correctAnswerIndex = 1,
            idUnit = 11
        ),

        Question(
            id = 128,
            text = "Will she be able to eat some cake ___ I put eggs in it?",
            answers = listOf("if", "unless", "since", "when"),
            correctAnswerIndex = 0,
            idUnit = 11
        ),


        // Unit 12
        Question(
            id = 129,
            text = "Unlike some other books about_______, it is unlikely that this will become a key text for those at the forefront of conservation action.",
            answers = listOf("biodiversity", "commercial", "occasion", "atmosphere"),
            correctAnswerIndex = 0,
            idUnit = 12
        ),

        Question(
            id = 130,
            text = "Economic analyses of soil_______ conservation investments may be done from private and social perspectives.",
            answers = listOf("conservation", "information", "dictionary", "supermarket"),
            correctAnswerIndex = 0,
            idUnit = 12
        ),

        Question(
            id = 131,
            text = "Endangered species_______ by the World Wildlife Fund.",
            answers = listOf("will protect", "would protect", "be protected", "are protected"),
            correctAnswerIndex = 3,
            idUnit = 12
        ),

        Question(
            id = 132,
            text = "By cutting down trees, we _______the natural habitat of birds and animals.",
            answers = listOf("damage", "harm", "hurt", "injure"),
            correctAnswerIndex = 0,
            idUnit = 12
        ),

        Question(
            id = 133,
            text = "The by-laws say that all dogs_______be kept on a lead in the park.",
            answers = listOf("ought", "need", "have", "must"),
            correctAnswerIndex = 3,
            idUnit = 12
        ),

        Question(
            id = 134,
            text = "Many plant and animal species are thought to be on the_______of extinction.",
            answers = listOf("verge", "state", "way", "mood"),
            correctAnswerIndex = 0,
            idUnit = 12
        ),

        Question(
            id = 135,
            text = "Despite the bad weather, he ______ get to the airport in time.",
            answers = listOf("was able to", "could", "couldn't", "might"),
            correctAnswerIndex = 0,
            idUnit = 12
        ),

        Question(
            id = 136,
            text = "The giant panda is now______.",
            answers = listOf(
                "an endangered species",
                "in danger of becoming extinct",
                "is becoming extinction",
                "A or B"
            ),
            correctAnswerIndex = 3,
            idUnit = 12
        ),

        Question(
            id = 137,
            text = "Because of people’s______ with the environment, many kinds of plants and animals are becoming rare.",
            answers = listOf("interference", "supply", "survival", "influence"),
            correctAnswerIndex = 2,
            idUnit = 12
        ),

        Question(
            id = 138,
            text = "The______ is the air, water and land in or on which people, animals and plants live.",
            answers = listOf("environment", "consequence", "planet", "resource"),
            correctAnswerIndex = 0,
            idUnit = 12
        ),

        Question(
            id = 139,
            text = "Learners______ can feel very if an exercise is too difficult.",
            answers = listOf("courageous", "encouraging", "discouraged", "encouraged"),
            correctAnswerIndex = 2,
            idUnit = 12
        ),

        Question(
            id = 140,
            text = "The society was set up to______ endangered species from extinction.",
            answers = listOf("preserve", "prevent", "distinguish", "survive"),
            correctAnswerIndex = 1,
            idUnit = 12
        ),

        Question(
            id = 141,
            text = "The factory was fined for______ chemicals into the river.",
            answers = listOf("dumping", "discharging", "producing", "exposing"),
            correctAnswerIndex = 1,
            idUnit = 12
        ),

        Question(
            id = 142,
            text = "Some______ animals become tame if they get used to people.",
            answers = listOf("wild", "domestic", "endangered", "rare"),
            correctAnswerIndex = 0,
            idUnit = 12
        ),

        Question(
            id = 143,
            text = "We all regard pollution as a matter to human beings.",
            answers = listOf("serious", "solemn", "great", "huge"),
            correctAnswerIndex = 0,
            idUnit = 12
        )


    )


    // Method to get vocabulary by Unit ID
    fun getVocabularyByUnitId(unitId: Int): List<Vocabulary> {
        return vocabularyList.filter { it.unitId == unitId }
    }

}