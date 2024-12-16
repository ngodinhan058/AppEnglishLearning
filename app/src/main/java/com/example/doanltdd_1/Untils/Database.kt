package com.example.doanltdd_1.Untils

import android.content.Context
import androidx.room.Room
import com.example.doanltdd_1.Entity.AppDatabase
import com.example.doanltdd_1.Entity.Question
import com.example.doanltdd_1.Entity.UnitEntity
import com.example.doanltdd_1.Entity.Vocabulary
import com.example.doanltdd_1.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Database(applicationContext: Context) {
    private lateinit var database: AppDatabase
    private val context = applicationContext

    fun getDatabase(): AppDatabase {
        if (!::database.isInitialized) {
            database = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "app_database"
            ).build()
        }
        return database
    }

    fun insertUnits() {
        val units = listOf(
            UnitEntity(1, "Unit 1", R.drawable.ic_hand_icon),
            UnitEntity(2, "Unit 2", R.drawable.ic_exercise),
            UnitEntity(3, "Unit 3", R.drawable.ic_launcher_foreground),
            UnitEntity(4, "Unit 4", R.drawable.ic_home),
            UnitEntity(5, "Unit 5", R.drawable.ic_grammar),
            UnitEntity(6, "Unit 7", R.drawable.ic_launcher_foreground),
            UnitEntity(7, "Unit 8", R.drawable.ic_launcher_foreground),
            UnitEntity(8, "Unit 8", R.drawable.ic_launcher_foreground),
            UnitEntity(9, "Unit 9", R.drawable.ic_launcher_foreground),
            UnitEntity(10, "Unit 10", R.drawable.ic_grammar),
            UnitEntity(11, "Unit 11", R.drawable.ic_grammar),
            UnitEntity(12, "Unit 12", R.drawable.ic_grammar),
        )
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                getDatabase().unitDao().insertUnits(units)
            }
        }
    }

    fun insertQuestions() {
        GlobalScope.launch {
            val questions = listOf(
                Question(
                    1,
                    "I______ know the correct answer.",
                    listOf("am not", "not", "don’t", "doesn’t"),
                    2,
                    1
                ),
                Question(
                    2,
                    "They ______ agree with my opinion.",
                    listOf("are", "don’t", "aren’t", "do"),
                    1,
                    1
                ),
                Question(
                    3,
                    "Kathy usually ______ in front of the window during the class.",
                    listOf("sits", "sitting", "sit", "is sit"),
                    0,
                    1
                ),
                Question(
                    4,
                    "What does this word ______?",
                    listOf("means", "meaning", "mean", "is mean"),
                    2,
                    1
                ),
                Question(
                    5,
                    "He ______ share anything to me.",
                    listOf("don’t do", "isn’t", "not", "doesn’t"),
                    3,
                    1
                ),
                Question(
                    6,
                    "I come from Canada. Where ______ you come from?",
                    listOf("are", "do", "is", "not"),
                    1,
                    1
                ),
                Question(
                    7,
                    "Jane ______ tea very often.",
                    listOf("doesn’t drink", "drink", "is drink", "isn’t drink"),
                    0,
                    1
                ),
                Question(
                    8,
                    "How often ______ you play tennis?",
                    listOf("do", "are", "is", "play"),
                    0,
                    1
                ),
                Question(
                    9,
                    "Rice ______ in cold climates.",
                    listOf("isn’t grow", "don’t grow", "aren’t grow", "doesn’t grow"),
                    3,
                    1
                ),
                Question(
                    10,
                    "I ______ a compass and a calculator in Maths lesson.",
                    listOf("am use", "use", "aren’t use", "doesn’t use"),
                    1,
                    1
                ),
                // Unit 2
                Question(
                    11,
                    "I sit ______ Sarah at school.",
                    listOf("on", "next to", "between", "above"),
                    1,
                    2
                ),
                Question(
                    12,
                    "Our family stays ______ a stilt house.",
                    listOf("in", "on", "in front of", "between"),
                    0,
                    2
                ),
                Question(
                    13,
                    "There are four students at each table ___ me is my friend Justine.",
                    listOf("in front of", "near to", "opposite", "behind"),
                    0,
                    2
                ),
                Question(
                    14,
                    "Tom sits ______ Lucy and James.",
                    listOf("between", "in front of", "near to", "beside"),
                    0,
                    2
                ),
                Question(
                    15,
                    "We have posters ______ the walls.",
                    listOf("on", "above", "under", "behind"),
                    0,
                    2
                ),
                Question(
                    16,
                    "______ the teacher's desk is a clock.",
                    listOf("opposite", "above", "next to", "beside"),
                    1,
                    2
                ),
                Question(
                    17,
                    "There's a wastepaper basket ______ her desk.",
                    listOf("on", "under", "between", "behind"),
                    1,
                    2
                ),
                Question(
                    18,
                    "Joe and Alan sit ______ each other.",
                    listOf("between", "beside", "next", "near"),
                    1,
                    2
                ),
                Question(
                    19,
                    "We had sandwiches ______ a pretty fountain.",
                    listOf("by", "on", "in", "near"),
                    0,
                    2
                ),
                Question(
                    20,
                    "You need to walk ______ this road quickly. There's lots of traffic.",
                    listOf("across", "by", "on", "near"),
                    0,
                    2
                ),
                // Unit 3
                Question(
                    21,
                    "He is at the bank. He _______ money from his account.",
                    listOf("is drawing", "is studying", "is sunbathing", "is making"),
                    0,
                    3
                ),
                Question(
                    22,
                    "He is in the library. He ______",
                    listOf("is waiting", "is posting", "is reading", "is coming"),
                    2,
                    3
                ),
                Question(
                    23,
                    "He is in the garden. He ______ the flowers.",
                    listOf("is watering", "is waiting", "is studying", "is posting"),
                    0,
                    3
                ),
                Question(
                    24,
                    "She is on the beach. She ______",
                    listOf("is waiting", "is reading", "is sunbathing", "is speaking"),
                    2,
                    3
                ),
                Question(
                    25,
                    "He is in the post office. He ______ letter.",
                    listOf("is waiting", "is posting", "is drawing", "is watering"),
                    1,
                    3
                ),
                Question(
                    26,
                    "He is in the telephone box. He ______ a call.",
                    listOf("is making", "is coming", "is studying", "is drawing"),
                    0,
                    3
                ),
                Question(
                    27,
                    "We ______ English at the moment.",
                    listOf("are posting", "are studying", "are coming", "are waiting"),
                    1,
                    3
                ),
                Question(
                    28,
                    "Look! David and Max ______ home.",
                    listOf("are waiting", "are coming", "are speaking", "are drawing"),
                    1,
                    3
                ),
                Question(
                    29,
                    "She ______ for her boyfriend now.",
                    listOf("is drawing", "is making", "is waiting", "is studying"),
                    2,
                    3
                ),
                Question(
                    30,
                    "I ______ to a dentist.",
                    listOf("am waiting", "am posting", "am speaking", "am coming"),
                    0,
                    3
                ),
                Question(

                    31,

                    "David was ……….. than John.",

                    listOf("more good", "better", "go", "more better"),

                    1,

                    4

                ),


                Question(

                    32,

                    "This building is ……….. than that one.",

                    listOf("beautiful", "more beautiful", "beautifuler", "more beautifuller"),

                    1,

                    4

                ),


                Question(

                    33,

                    "Dorothy promised to be ……….. with her money.",

                    listOf("careful", "carefuler", "more careful", "carefuller"),

                    2,

                    4

                ),


                Question(

                    34,

                    "New York’s population is ……….. than San Francisco’s.",

                    listOf("larger", "large", "more large", "largerest"),

                    0,

                    4

                ),


                Question(

                    35,

                    "This old machine is ……….. than we thought.",

                    listOf("more powerful", "powerful", "powerfuler", "most powerful"),

                    0,

                    4

                ),


                Question(

                    36,

                    "We’ve got … time than I thought.",

                    listOf("little", "more little", "less", "littler"),

                    2,

                    4

                ),


                Question(

                    37,

                    "People are not friendly in big cities. They are usually… than in small towns.",

                    listOf("friendly", "more friendly", "friendlier", "friendliest"),

                    2,

                    4

                ),


                Question(

                    38,

                    "Mary is 10 years old. Julie is 8 years old. Mary is … than Julie.",

                    listOf("older", "elder", "more old", "oldest"),

                    0,

                    4

                ),


                Question(

                    39,

                    "The road is … than the motorway.",

                    listOf("narrow", "narrower", "more narrow", "most narrow"),

                    1,

                    4

                ),


                Question(

                    40,

                    "It’s … than it looks.",

                    listOf("badder", "worse", "more bad", "worser"),

                    1,

                    4

                ),


                // Unit 5

                Question(

                    41,

                    "You……………tidy up room.",

                    listOf("must", "don't have to", "have to", "mustn't"),

                    2,

                    5

                ),


                Question(

                    42,

                    "It’s late. You ……………make so much noise.",

                    listOf("mustn't", "must", "don't have to", "have to"),

                    0,

                    5

                ),


                Question(

                    43,

                    "You……………smoke.",

                    listOf("mustn't", "must", "have to", "don't have to"),

                    0,

                    5

                ),


                Question(

                    44,

                    "We……………be home by 9 o’clock. The film starts at 9=15.",

                    listOf("have to", "mustn't", "don't have to", "must"),

                    3,

                    5

                ),


                Question(

                    45,

                    "You …………… do your homework.",

                    listOf("must", "have to", "don't have to", "mustn't"),

                    0,

                    5

                ),


                Question(

                    46,

                    "I …………… finish this essay today. It has to be handed in by tomorrow.",

                    listOf("must", "don't have to", "have to", "mustn't"),

                    2,

                    5

                ),


                Question(

                    47,

                    "Passengers…………… talk to the driver whilst the bus is in motion.",

                    listOf("mustn't", "don't have to", "have to", "must"),

                    0,

                    5

                ),


                Question(

                    48,

                    "You …………… play with fire.",

                    listOf("mustn't", "must", "don't have to", "have to"),

                    0,

                    5

                ),


                Question(

                    49,

                    "The rules……………be obeyed at all times! shouted the headmaster.",

                    listOf("must", "mustn't", "don't have to", "have to"),

                    0,

                    5

                ),


                Question(

                    50,

                    "I……………go. Otherwise I'll miss my train.",

                    listOf("have to", "mustn't", "must", "don't have to"),

                    2,

                    5

                ),


                Question(

                    51,

                    "I……………be home at one o'clock. Otherwise, my mother will kill me.",

                    listOf("must", "have to", "mustn't", "don't have to"),

                    1,

                    5

                ),


                Question(

                    52,

                    "You…………… play tennis to enjoy watching tennis matches.",

                    listOf("don't have to", "mustn't", "have to", "must"),

                    0,

                    5

                ),


                Question(

                    53,

                    "You…………… buy me presents though I always appreciate it when you do.",

                    listOf("don't have to", "mustn't", "must", "have to"),

                    0,

                    5

                ),


                Question(

                    54,

                    "It's really important to remember. You……………forget.",

                    listOf("mustn't", "must", "have to", "don't have to"),

                    0,

                    5

                ),


                Question(

                    55,

                    "You……………tell anybody. It is a big secret.",

                    listOf("mustn't", "must", "don't have to", "have to"),

                    0,

                    5

                ),


                Question(

                    56,

                    "We are already late. We……………waste any more time.",

                    listOf("mustn't", "must", "have to", "don't have to"),

                    0,

                    5

                ),


                Question(

                    57,

                    "This is a sterile area. It must be kept clean. You……………bring any food or drink in here.",

                    listOf("mustn't", "don't have to", "have to", "must"),

                    0,

                    5

                ),


                Question(

                    58,

                    "You……………come at 8.00. Come at whatever time suits you.",

                    listOf("don't have to", "mustn't", "have to", "must"),

                    0,

                    5

                ),


                Question(

                    59,

                    "You……………smoke in this area. It is forbidden.",

                    listOf("mustn't", "don't have to", "must", "have to"),

                    0,

                    5

                ),


                Question(

                    60,

                    "I……………go back again. The treatment is finished.",

                    listOf("don't have to", "must", "mustn't", "have to"),

                    0,

                    5

                ),

                // Unit 6

                Question(

                    61,

                    "If you have time you should............................ the National Museum.",

                    listOf("clean", "visit", "fasten", "watch"),

                    1,

                    6

                ),


                Question(

                    62,

                    "When you are driving a car, you should. .........................your seatbelt.",

                    listOf("study", "visit", "eat", "fasten"),

                    3,

                    6

                ),


                Question(

                    63,

                    "When you play football, you should    .........................the ball.",

                    listOf("fasten", "take", "clean", "watch"),

                    3,

                    6

                ),


                Question(

                    64,

                    "It's late and you are tired. You should...................... to bed.",

                    listOf("eat", "go", "take", "study"),

                    1,

                    6

                ),


                Question(

                    65,

                    "You should  .....................your teeth at least twice a day.",

                    listOf("fasten", "clean", "visit", "watch"),

                    1,

                    6

                ),


                Question(

                    66,

                    "It's too far from here. You should....................a taxi to get there.",

                    listOf("study", "take", "go", "eat"),

                    1,

                    6

                ),


                Question(

                    67,

                    "If you want to pass the exam, you should....................more.",

                    listOf("clean", "study", "visit", "fasten"),

                    1,

                    6

                ),


                Question(

                    68,

                    "He wants to lose weight, so he should.................... less.",

                    listOf("watch", "clean", "eat", "go"),

                    2,

                    6

                ),


                Question(

                    69,

                    "It's raining now. I think you should....................an umbrella.",

                    listOf("eat", "fasten", "take", "study"),

                    2,

                    6

                ),


                Question(

                    70,

                    "He is ill. He should............................ at home.",

                    listOf("stay", "watch", "go", "clean"),

                    0,

                    6

                ),


                // Unit 7

                Question(

                    71,

                    "Do you know……………language is spoken in Kenya?",

                    listOf("which", "who", "What", "how"),

                    0,

                    7

                ),


                Question(

                    72,

                    "…………is your blood type?",

                    listOf("which", "who", "What", "how"),

                    2,

                    7

                ),


                Question(

                    73,

                    "……do you play tennis? For exercise",

                    listOf("which", "who", "What", "why"),

                    3,

                    7

                ),


                Question(

                    74,

                    "…………..can I buy some milk? At the supermarket.",

                    listOf("which", "where", "What", "how"),

                    1,

                    7

                ),


                Question(

                    75,

                    "………..much do you weigh?",

                    listOf("which", "who", "What", "how"),

                    3,

                    7

                ),


                Question(

                    76,

                    "………hat is this? It’s my brother’s.",

                    listOf("which", "who", "What", "whose"),

                    3,

                    7

                ),


                Question(

                    77,

                    "…………can I park my car? Over there.",

                    listOf("where", "who", "What", "how"),

                    0,

                    7

                ),


                Question(

                    78,

                    "……tall are you?",

                    listOf("which", "who", "What", "how"),

                    3,

                    7

                ),


                Question(

                    79,

                    "……….do you like your tea? I like it with cream and sugar.",

                    listOf("which", "who", "What", "how"),

                    3,

                    7

                ),


                Question(

                    80,

                    "……picture do you prefer – this one or that one?",

                    listOf("which", "who", "What", "how"),

                    0,

                    7

                ),


                Question(

                    81,

                    "……………….is that woman? I think she is a teacher.",

                    listOf("which", "who", "What", "how"),

                    1,

                    7

                ),


                Question(

                    82,

                    "…………book is this? It’s mine.",

                    listOf("which", "who", "What", "whose"),

                    3,

                    7

                ),


                Question(

                    83,

                    "……………….do you usually eat lunch? At noon.",

                    listOf("which", "who", "What", "when"),

                    3,

                    7

                ),


                Question(

                    84,

                    "……..does your father work? At City Hall.",

                    listOf("which", "where", "What", "how"),

                    1,

                    7

                ),


                Question(

                    85,

                    "……usually gets up the earliest in your family?",

                    listOf("which", "who", "What", "how"),

                    1,

                    7

                ),


                Question(

                    86,

                    "…………….do you think of this hotel? It’s pretty good.",

                    listOf("which", "who", "What", "how"),

                    3,

                    7

                ),


                Question(

                    87,

                    "………..does your father work at that company? Because It’s near our house.",

                    listOf("which", "why", "What", "how"),

                    1,

                    7

                ),


                Question(

                    88,

                    "……..dances the best in your family?",

                    listOf("which", "who", "What", "how"),

                    1,

                    7

                ),


                // Unit 8

                Question(

                    89,

                    "They_________the bus yesterday.",

                    listOf("don’t catch", "weren’t catch", "didn’t catch", "not catch"),

                    2,

                    8

                ),


                Question(

                    90,

                    "My sister_________home last night.",

                    listOf("comes", "come", "came", "was come"),

                    2,

                    8

                ),


                Question(

                    91,

                    "My father_________tired when I _________ home.",

                    listOf("was – got", "is – get", "was – getted", "were – got"),

                    0,

                    8

                ),


                Question(

                    92,

                    "What_________you_________two days ago?",

                    listOf("do – do", "did – did", "do – did", "did – do"),

                    3,

                    8

                ),


                Question(

                    93,

                    "Where_________your family_________on the summer holiday last year?",

                    listOf("do – go", "does – go", "did – go", "did – went"),

                    2,

                    8

                ),


                Question(

                    94,

                    "We_________David in town a few days ago.",

                    listOf("did see", "was saw", "did saw", "saw"),

                    3,

                    8

                ),


                Question(

                    95,

                    "It was cold, so I_________ the window.",

                    listOf("shut", "was shut", "am shut", "shutted"),

                    0,

                    8

                ),


                Question(

                    96,

                    "I_________to the cinema three times last week.",

                    listOf("was go", "went", "did go", "goed"),

                    1,

                    8

                ),


                Question(

                    97,

                    "What_________you_________last weekend?",

                    listOf("were/do", "did/did", "did/do", "do/did"),

                    2,

                    8

                ),


                Question(

                    98,

                    "The police_________on my way home last night.",

                    listOf("was stop", "stopped", "stops", "stopping"),

                    1,

                    8

                ),


                Question(

                    99,

                    "The film wasn’t very good. I_________ it very much.",

                    listOf("enjoyed", "wasn’t enjoy", "didn’t enjoyed", "didn’t enjoy"),

                    3,

                    8

                ),


                Question(

                    100,

                    "The bed was very uncomfortable. I_________sleep very well.",

                    listOf("didn’t", "did", "wasn’t", "not"),

                    0,

                    8

                ),


                Question(

                    101,

                    "The window was opened and a bird_________into the room.",

                    listOf("fly", "flew", "was flew", "did fly"),

                    1,

                    8

                ),


                Question(

                    102,

                    "I_________a lot of money yesterday. I_________an expensive dress.",

                    listOf("spend/buy", "spent/buy", "spent/bought", "was spent/bought"),

                    2,

                    8

                ),


                // Unit 9

                Question(

                    103,

                    "This isn’t her skirt. ________ is blue.",

                    listOf("Hers", "Her", "She", "He"),

                    0,

                    9

                ),


                Question(

                    104,

                    "______ daughter is a teacher.",

                    listOf("Our", "Ours", "Us", "We"),

                    0,

                    9

                ),


                Question(

                    105,

                    "This is my new dress. Look at _____!",

                    listOf("I", "mine", "me", "my"),

                    2,

                    9

                ),


                Question(

                    106,

                    "Linda is _______ cousin.",

                    listOf("him", "he", "he’s", "his"),

                    3,

                    9

                ),


                Question(

                    107,

                    "This craft isn’t mine. It’s _______.",

                    listOf("Him", "She", "Hers", "Them"),

                    2,

                    9

                ),

                Question(

                    108,

                    "Take an umbrella with you when you go out. It  _________ later.",

                    listOf("might sun", "might heat", "might rain", "might cool"),

                    2,

                    10

                ),


                Question(

                    109,

                    "Don’t make too much noise. You ______ the baby.",

                    listOf("might sleep", "might wake", "might rest", "might calm"),

                    1,

                    10

                ),


                Question(

                    110,

                    "Be careful of that dog. It ____ you.",

                    listOf("might bark", "might meow", "might lick", "might bite"),

                    3,

                    10

                ),


                Question(

                    111,

                    "I don’t think we should throw that letter away. We ______ it later.",

                    listOf("might need", "might lose", "might find", "might give"),

                    0,

                    10

                ),


                Question(

                    112,

                    "Be careful. The footbath is very icy. You ______",

                    listOf("might slip", "might walk", "might slide", "might step"),

                    0,

                    10

                ),


                Question(

                    113,

                    "Don’t let the children play in this room. They ______ something.",

                    listOf("might fix", "might break", "might build", "might paint"),

                    1,

                    10

                ),

                // Unit 11

                Question(

                    114,

                    "My dog ___ bark unless it is hungry.",

                    listOf("won’t", "don’t", "will", "doesn't"),

                    0,

                    11

                ),


                Question(

                    115,

                    "Unless you ___ to go to bed early, we should go out.",

                    listOf("want", "wants", "go", "goes"),

                    0,

                    11

                ),


                Question(

                    116,

                    "___ you don’t slow down, we are going to crash!",

                    listOf("Unless", "If", "When", "Since"),

                    0,

                    11

                ),


                Question(

                    117,

                    "You cannot go into bars ___ you are over 18.",

                    listOf("unless", "if", "when", "since"),

                    0,

                    11

                ),


                Question(

                    118,

                    "In my country, ____ you cannot speak English, it’s hard to get a good job.",

                    listOf("unless", "if", "when", "since"),

                    0,

                    11

                ),


                Question(

                    119,

                    "She’ll fail the exam if she ___ study.",

                    listOf("doesn’t", "if", "won't", "didn't"),

                    0,

                    11

                ),


                Question(

                    120,

                    "We’ll be late ____ we leave soon.",

                    listOf("unless", "if", "since", "when"),

                    0,

                    11

                ),


                Question(

                    121,

                    "___ I am not feeling better tomorrow I will go to the doctor’s.",

                    listOf("If", "Unless", "Since", "When"),

                    0,

                    11

                ),


                Question(

                    122,

                    "____ you do not make the payment in time, your car will be confiscated.",

                    listOf("If", "Unless", "When", "Since"),

                    0,

                    11

                ),


                Question(

                    123,

                    "You will lose your job ___ you change your attitude and become friendlier.",

                    listOf("if", "unless", "since", "when"),

                    1,

                    11

                ),


                Question(

                    124,

                    "She won’t know the truth ___ you tell it to her.",

                    listOf("if", "unless", "since", "when"),

                    1,

                    11

                ),


                Question(

                    125,

                    "____ you arrive early, you’ll be able to meet the customers before the meeting.",

                    listOf("If", "Unless", "Since", "When"),

                    0,

                    11

                ),


                Question(

                    126,

                    "____ she eats healthy food, she won’t lose some weight.",

                    listOf("If", "Unless", "Since", "When"),

                    1,

                    11

                ),


                Question(

                    127,

                    "They won’t arrive on time ___ they finish the work early.",

                    listOf("if", "unless", "since", "when"),

                    1,

                    11

                ),


                Question(

                    128,

                    "Will she be able to eat some cake ___ I put eggs in it?",

                    listOf("if", "unless", "since", "when"),

                    0,

                    11

                ),


                // Unit 12

                Question(

                    129,

                    "Unlike some other books about_______, it is unlikely that this will become a key text for those at the forefront of conservation action.",

                    listOf("biodiversity", "commercial", "occasion", "atmosphere"),

                    0,

                    12

                ),


                Question(

                    130,

                    "Economic analyses of soil_______ conservation investments may be done from private and social perspectives.",

                    listOf("conservation", "information", "dictionary", "supermarket"),

                    0,

                    12

                ),


                Question(

                    131,

                    "Endangered species_______ by the World Wildlife Fund.",

                    listOf("will protect", "would protect", "be protected", "are protected"),

                    3,

                    12

                ),


                Question(

                    132,

                    "By cutting down trees, we _______the natural habitat of birds and animals.",

                    listOf("damage", "harm", "hurt", "injure"),

                    0,

                    12

                ),


                Question(

                    133,

                    "The by-laws say that all dogs_______be kept on a lead in the park.",

                    listOf("ought", "need", "have", "must"),

                    3,

                    12

                ),


                Question(

                    134,

                    "Many plant and animal species are thought to be on the_______of extinction.",

                    listOf("verge", "state", "way", "mood"),

                    0,

                    12

                ),


                Question(

                    135,

                    "Despite the bad weather, he ______ get to the airport in time.",

                    listOf("was able to", "could", "couldn't", "might"),

                    0,

                    12

                ),


                Question(

                    136,

                    "The giant panda is now______.",

                    listOf(

                        "an endangered species",

                        "in danger of becoming extinct",

                        "is becoming extinction",

                        "A or B"

                    ),

                    3,

                    12

                ),


                Question(

                    137,

                    "Because of people’s______ with the environment, many kinds of plants and animals are becoming rare.",

                    listOf("interference", "supply", "survival", "influence"),

                    2,

                    12

                ),


                Question(

                    138,

                    "The______ is the air, water and land in or on which people, animals and plants live.",

                    listOf("environment", "consequence", "planet", "resource"),

                    0,

                    12

                ),


                Question(

                    139,

                    "Learners______ can feel very if an exercise is too difficult.",

                    listOf("courageous", "encouraging", "discouraged", "encouraged"),

                    2,

                    12

                ),


                Question(

                    140,

                    "The society was set up to______ endangered species from extinction.",

                    listOf("preserve", "prevent", "distinguish", "survive"),

                    1,

                    12

                ),


                Question(

                    141,

                    "The factory was fined for______ chemicals into the river.",

                    listOf("dumping", "discharging", "producing", "exposing"),

                    1,

                    12

                ),


                Question(

                    142,

                    "Some______ animals become tame if they get used to people.",

                    listOf("wild", "domestic", "endangered", "rare"),

                    0,

                    12

                ),


                Question(

                    143,

                    "We all regard pollution as a matter to human beings.",

                    listOf("serious", "solemn", "great", "huge"),

                    0,

                    12

                )

            )
            withContext(Dispatchers.IO) {
                getDatabase().questionDao().insertQuestions(questions)
            }
        }
    }

    fun insertVocabulary() {
        GlobalScope.launch {
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
            withContext(Dispatchers.IO) {
                getDatabase().vocabularyDao().insertAll(vocabularyList)
            }

        }
    }
    fun deleteAll() {
        GlobalScope.launch {
            database.unitDao().deleteAll()
            database.questionDao().deleteAll()
        }
    }
}