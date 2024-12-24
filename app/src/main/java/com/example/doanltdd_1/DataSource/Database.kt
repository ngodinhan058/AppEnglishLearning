package com.example.doanltdd_1.DataSource

import android.content.Context
import androidx.room.Room
import com.example.doanltdd_1.Entity.AppDatabase
import com.example.doanltdd_1.Entity.Grammar
import com.example.doanltdd_1.Entity.Question
import com.example.doanltdd_1.Entity.QuestionGrammar
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
            UnitEntity(1, "Unit 1", R.drawable.unit1),
            UnitEntity(2, "Unit 2", R.drawable.unit2),
            UnitEntity(3, "Unit 3", R.drawable.unit3),
            UnitEntity(4, "Unit 4", R.drawable.unit4),
            UnitEntity(5, "Unit 5", R.drawable.unit5),
            UnitEntity(6, "Unit 7", R.drawable.unit6),
            UnitEntity(7, "Unit 8", R.drawable.unit7),
            UnitEntity(8, "Unit 8", R.drawable.unit8),
            UnitEntity(9, "Unit 9", R.drawable.unit9),
            UnitEntity(10, "Unit 10", R.drawable.unit10),
            UnitEntity(11, "Unit 11", R.drawable.unit11),
            UnitEntity(12, "Unit 12", R.drawable.unit12),
        )
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                getDatabase().unitDao().insertUnits(units)
            }
        }
    }
    fun insertGrammar() {
        val grammarList = listOf(
            Grammar(
                id = 1,
                unitId = 1,
                title = "Thì hiện tại đơn",
                content = "Duy rides his bicycle to school every day.\n" +
                        "Dịch nghĩa: Duy đạp xe đến trường mỗi ngày.\n" +
                        "\n" +
                        "My biology class starts at 7 am in the morning.\n" +
                        "Dịch nghĩa: Tiết Sinh học của tôi bắt đầu lúc 7 giờ sáng.\n" +
                        "\n" +
                        "Our uniforms dry faster on sunny days.\n" +
                        "Dịch nghĩa: Đồng phục của chúng tôi khô nhanh hơn vào những ngày nắng.\n" +
                        "\n" +
                        "I often finish my homework right after school. \n" +
                        "Dịch nghĩa: Tôi thường hoàn thành bài tập về nhà ngay sau giờ học.",
                usage = "Thì Hiện tại đơn là thì thể hiện những hành động hoặc sự việc xảy ra thường xuyên hoặc cố định, không đổi.\n" +
                        "\n" +
                        "Cấu trúc:\n" +
                        "\n" +
                        "Câu khẳng định: S + V(s/es)\n" +
                        "Câu phủ định: S + don’t/doesn’t + V(bare)\n" +
                        "Câu hỏi: Do/Does + S + V(bare)?\n" +
                        "Nếu chủ ngữ trong câu sử dụng Thì Hiện tại đơn là số ít (she/he/it/danh từ số ít/danh từ không đếm được) thì thêm “s/es” ở cuối động từ chính trong câu khẳng định và sử dụng “does” trong câu phủ định và câu hỏi.\n" +
                        "\n" +
                        "Nếu chủ ngữ trong câu sử dụng Thì Hiện tại đơn là số nhiều (I/you/we/they/danh từ số nhiều) thì giữ nguyên động từ chính trong câu khẳng định và sử dụng “do” trong câu phủ định và câu hỏi.\n" +
                        "\n" +
                        "Thì Hiện tại đơn được sử dụng để diễn tả những sự việc, hành động luôn xảy ra thường xuyên, hoặc lặp đi lặp lại, hoặc diễn tả một chân lý, sự thật hiển nhiên, hoặc các sự việc cố định như lịch trình tàu, xe, …vv. Thì Hiện tại đơn còn được sử dụng để thể hiện tần suất thực hiện một hành động."
            ),
            Grammar(
                id = 2,
                unitId = 1,
                title = "Trạng từ chỉ tần suất",
                content = "We always have math class on Mondays.\n" +
                        "Dịch nghĩa: Chúng tôi luôn học toán vào các ngày thứ Hai.\n" +
                        "\n" +
                        "Duy and Mai rarely have lunch together at school.\n" +
                        "Dịch nghĩa: Duy và Mai hiếm khi dùng bữa trưa cùng nhau ở trường.",
                usage = "Trạng từ chỉ tần suất được sử dụng để thể hiện mức độ thường xuyên xảy ra của một hành động hay sự việc nào đó.\n" +
                        "\n" +
                        "Đây là những từ như always (luôn luôn), usually (thường xuyên), often (thường xuyên), sometimes (thỉnh thoảng), rarely (hiếm khi), never (không bao giờ).\n" +
                        "\n" +
                        "Trạng từ chỉ tần suất thường xuất hiện trong các câu sử dụng Thì Hiện tại đơn. Thông thường, đặt các trạng từ chỉ tần suất trước động từ chính trong câu.\n" +
                        "\n"
            ),
            Grammar(
                id = 3,
                unitId = 2,
                title = "Giới từ chỉ vị trí",
                content = "The book is on the armchair.\n" +
                        "Dịch nghĩa: Cuốn sách đang trên cái ghế bành.\n" +
                        "\n" +
                        "The cat is under the bed.\n" +
                        "Dịch nghĩa: Con mèo đang nằm dưới giường.\n" +
                        "\n" +
                        "She is standing in front of the lamp.\n" +
                        "Dịch nghĩa: Cô ấy đang đứng trước cái đèn.\n" +
                        "\n" +
                        "The keys are between the cushions of the sofa.\n" +
                        "Dịch nghĩa: Chùm chìa khóa đang ở giữa mấy cái gối trên sofa.",
                usage = "Giới từ chỉ vị trí miêu tả địa điểm của người hoặc vật nào đó so với người hoặc vật khác.\n" +
                        "\n" +
                        "Các giới từ chỉ vị trí thường gặp gồm có: in (trong), on (trên), behind (đằng sau), under (dưới), next to (bên cạnh), in front of (trước), between (ở giữa)."
            ),
            Grammar(
                id = 4,
                unitId = 2,
                title = "Sở hữu cách ",
                content = "Phong's room has a bed, a desk, a fan, and a wardrobe.\n" +
                        "Dịch nghĩa: Phòng của Phong có một chiếc giường, bàn học, cái quạt và tủ quần áo.\n" +
                        "\n" +
                        "My friend’s sister is two years older than me.\n" +
                        "Dịch nghĩa: Chị gái của bạn tôi lớn hơn tôi hai tuổi.\n" +
                        "\n" +
                        "My flat is smaller than my friend’s. (= my friend’s flat.)\n" +
                        "Dịch nghĩa: Căn hộ của tôi nhỏ hơn của bạn tôi. (= căn hộ của bạn tôi.)",
                usage = "Sở hữu cách thể hiện quyền sở hữu của danh từ đứng trước nó đối với sự vật nào đó. Hình thức của sở hữu cách là ‘s, viết cuối danh từ có quyền sở hữu.\n" +
                        "\n" +
                        "***Lưu ý:\n" +
                        "\n" +
                        "Dạng sở hữu cách ‘s đứng cuối danh từ riêng hoặc danh từ số ít.\n" +
                        "Danh từ có sở hữu cách có thể có danh từ khác theo sau hoặc không."
            ),
            Grammar(
                id = 5,
                unitId = 3,
                title = "Thì Hiện tại tiếp diễn",
                usage = "Thì Hiện tại tiếp diễn là thì thể hiện những hành động, sự việc đang xảy ra trong thời điểm hiện tại. \n" +
                        "\n" +
                        "Cấu trúc:\n" +
                        "\n" +
                        "Câu khẳng định: S + is/am/are + V-ing\n" +
                        "Câu phủ định: S + isn’t/aren’t/am not + V-ing\n" +
                        "Câu hỏi: Is/Am/Are + S + V-ing?\n" +
                        "Thì Hiện tại tiếp diễn được sử dụng để diễn tả những sự việc, hành động đang xảy ra tại thời điểm nói. Những hành động này chưa được hoàn thành. Thì Hiện tại tiếp diễn còn được sử dụng để nói về những sự việc hay hành động đã kéo dài được một thời gian tại thời điểm nói và chưa có dấu hiệu dừng lại, hoặc diễn tả một trạng thái, tình trạng tạm thời.\n" +
                        "\n" +
                        "Một số dấu hiệu nhận biết của Thì Hiện tại tiếp diễn gồm có: now, at present, at the moment, … (đều có nghĩa hiện tại, bây giờ)",
                content = "Look, Minh is making a cake!\n" +
                        "Dịch nghĩa: Nhìn kìa, Minh đang làm bánh!\n" +
                        "\n" +
                        "I am learning to swim these days.\n" +
                        "Dịch nghĩa: Dạo này tôi đang học bơi.\n" +
                        "\n"
            ),
            Grammar(
                id = 6,
                unitId = 4,
                title = "Cấp so sánh hơn của tính từ",
                usage = "Cấu trúc:\n" +
                        "\n" +
                        "Tính từ ngắn: adj-er/ier + than\n" +
                        "Tính từ dài: more + adj + than",
                content = "Life in the city is more expensive than life in the countryside.\n" +
                        "Dịch nghĩa: Cuộc sống ở thành phố đắt đỏ hơn so với cuộc sống ở nông thôn.\n" +
                        "\n" +
                        "The museum is nearer than the temple, so let’s go to the museum first.\n" +
                        "Dịch nghĩa: Đi bảo tàng gần hơn đi chùa, nên chúng ta cùng đến bảo tàng trước nào!\n" +
                        "\n" +
                        "Walking is better for our health than taking the bus.\n" +
                        "Dịch nghĩa: Đi bộ tốt cho sức khỏe của chúng ta hơn là đi xe buýt.\n" +
                        "\n"
            ),
            Grammar(
                id = 7,
                unitId = 5,
                title = "Danh từ đếm được và danh từ không đếm được",
                usage = "Danh từ đếm được là những danh từ chỉ người và vật mà có thể đếm được bằng số đếm. Danh từ đếm được gồm danh từ số ít và danh từ số nhiều.\n" +
                        "\n" +
                        "→ Sử dụng some (một vài), many (nhiều), a few (một ít) để thể hiện số lượng đối với các danh từ đếm được. \n" +
                        "\n" +
                        "Danh từ không đếm được là những danh từ chỉ vật mà không thể đếm được bằng số đếm. Danh từ không đếm được thường không có dạng số nhiều.\n" +
                        "\n" +
                        "→ Sử dụng some (một chút), much (nhiều), a little (một ít) để thể hiện lượng đối với các danh từ không đếm được. ",
                content = "I’m packing a few pills for our trip to the mountains tomorrow.\n" +
                        "Dịch nghĩa: Tôi đang chuẩn bị một vài viên thuốc cho chuyến dã ngoại trên núi của chúng ta vào ngày mai.\n" +
                        "\n" +
                        "Do you have some suncream?\n" +
                        "Dịch nghĩa: Bạn có kem chống nắng không?"
            ),
            Grammar(
                id = 8,
                unitId = 5,
                title = "Động từ khiếm khuyết: must - mustn’t (bắt buộc - cấm)",
                usage = "Must được sử dụng để thể hiện sự cần thiết hay vô cùng quan trọng của một hành động nào đó.\n" +
                        "Mustn’t được sử dụng để nói về hành động bị cấm hay không được phép. \n" +
                        "Must - mustn’t là động từ khiếm khuyết, phải được theo sau bởi một động từ thường với chức năng là động từ chính trong câu.",
                content = "You must be careful when you go swimming at the beach.\n" +
                        "Dịch nghĩa: Bạn phải cẩn thận khi bạn đi bơi ở biển.\n" +
                        "\n" +
                        "We mustn’t litter in this national park.  \n" +
                        "Dịch nghĩa: Chúng ta không được phép xả rác bừa bãi ở khu vực công viên quốc gia này.",
            ),
            Grammar(
                id = 9,
                unitId = 6,
                title = "Động từ khiếm khuyết: should - shouldn’t (nên - không nên)",
                usage = "Should - shouldn’t được sử dụng để diễn tả lời khuyên.\n" +
                        "\n" +
                        "Should được sử dụng để nói về những hành động tốt nên làm.\n" +
                        "Shouldn’t được sử dụng để nói về những hành động không tốt và không nên làm. \n" +
                        "Should - shouldn’t là động từ khiếm khuyết, phải được theo sau bởi một động từ thường với chức năng là động từ chính trong câu.",
                content = "We should plant more trees.\n" +
                        "Dịch nghĩa: Chúng ta nên trồng nhiều cây hơn.\n" +
                        "\n" +
                        "Everyone shouldn’t break things during Tet.  \n" +
                        "Dịch nghĩa: Mọi người không nên đập vỡ đồ đạc vào dịp Tết.\n" +
                        "\n",
            ),
            Grammar(
                id = 10,
                unitId = 6,
                title = "Some/any (một vài/bất kì)",
                usage = "Some/any được sử dụng để thể hiện số lượng.\n" +
                        "\n" +
                        "Some được sử dụng với các danh từ đếm được số nhiều và danh từ không đếm được trong câu khẳng định.\n" +
                        "Any được sử dụng với các danh từ đếm được số nhiều và danh từ không đếm được trong câu phủ định và câu hỏi. \n" +
                        "Some/any đứng ở trước danh từ trong câu. ",
                content = "My mother always decorates the house with some flowers for Tet.\n" +
                        "Dịch nghĩa: Mẹ tôi luôn trang hoàng nhà cửa với một vài loài hoa vào dịp Tết.\n" +
                        "\n" +
                        "Vietnamese people usually buy some salt to wish for good luck in the New Year.\n" +
                        "Dịch nghĩa: Người Việt thường mua một ít muối để cầu may vào năm mới.\n" +
                        "\n" +
                        "We don’t have any banh chung yet.\n" +
                        "Dịch nghĩa: Chúng tôi chưa có bánh chưng.\n" +
                        "\n" +
                        "Did you get any new clothes for the New Year?\n" +
                        "Dịch nghĩa: Bạn đã mua quần áo mới cho năm mới chưa?",
            ),
            Grammar(
                id = 11,
                unitId = 7,
                title = "Câu hỏi với từ để hỏi",
                usage = "Các từ để hỏi thông dụng được liệt kê trong bảng dưới đây.\n" +
                        "Từ để hỏi | Ý nghĩa \n" +
                        "When | Khi nào \n" +
                        "How many | Bao nhiêu \n" +
                        "What | cái gì\n" +
                        "Where | Ở đâu \n" +
                        "Who | ai \n" +
                        "Why | Tại sao \n",
                content = "What television shows are currently popular?\n" +
                        "Dịch nghĩa: Các chương trình truyền hình nào đang phổ biến hiện nay?\n" +
                        "\n" +
                        "How often do you watch television in a typical week?\n" +
                        "Dịch nghĩa: Bạn thường xem TV bao nhiêu lần trong tuần?\n" +
                        "\n" +
                        "When do you often watch movies?\n" +
                        "Dịch nghĩa: Bạn thường xem phim vào lúc nào?\n" +
                        "\n" +
                        "Why do you enjoy watching television?\n" +
                        "Dịch nghĩa: Tại sao bạn thích xem TV?",
            ),
            Grammar(
                id = 12,
                unitId = 7,
                title = "Liên từ trong câu ghép",
                usage = "Câu ghép là câu có hai hoặc nhiều mệnh đề độc lập trong một câu. Một mệnh đề độc lập gồm có chủ ngữ và động từ (có thể có những thành phần khác như tân ngữ, trạng ngữ, vv…) và có thể đứng riêng lẻ mà không bị tối nghĩa hay bị sai về mặt ngữ pháp.\n" +
                        "\n" +
                        "Sử dụng các liên từ để liên kết các mệnh đề trong một câu ghép. Một số liên từ trong câu ghép là but (nhưng), so (vì vậy), and (và).",
                content = "Mai wanted to watch her favorite show, but it was already over when she turned on the TV.\n" +
                        "Dịch nghĩa: Mai muốn xem chương trình yêu thích của cô ấy, nhưng khi cô bật TV lên thì nó đã kết thúc.\n" +
                        "\n" +
                        "My mother enjoys watching TV shows and documentaries, and she finds them both informative and entertaining.\n" +
                        "Dịch nghĩa: Mẹ tôi thích xem các chương trình truyền hình và phim tài liệu, và bà ấy thấy cả hai đều bổ ích và giải trí.\n" +
                        "\n" +
                        "I enjoy watching documentaries, so I often try to find educational channels.\n" +
                        "Dịch nghĩa: Tôi thích xem phim tài liệu, vì vậy tôi thường xuyên tìm kiếm các kênh mang tính giáo dục.",
            ),
            Grammar(
                id = 13,
                unitId = 8,
                title = "Thì Quá khứ đơn",
                usage = "Thì Quá khứ đơn là thì thể hiện sự việc hay hành động đã xảy ra trong quá khứ.\n" +
                        "\n" +
                        "Cấu trúc:\n" +
                        "\n" +
                        "Câu khẳng định: S + V(ed)\n" +
                        "Câu phủ định: S + didn’t + V(bare)\n" +
                        "Câu hỏi: Did + S  + V(bare)?\n" +
                        "Với các động từ thường có quy tắc, thêm “ed” vào cuối để tạo thành dạng quá khứ của động từ. Tuy nhiên, có rất nhiều động từ bất quy tắc không thêm “ed” mà biến đổi theo nhiều cách để trở thành dạng quá khứ. \n" +
                        "\n" +
                        "Thì Quá khứ đơn được sử dụng để diễn tả những sự việc, hành động đã hoàn thành trong quá khứ.",
                content = "I forgot my goggles yesterday at swimming practice.\n" +
                        "Dịch nghĩa: Hôm qua tôi quên mất kính bơi tại buổi tập bơi.\n" +
                        "\n" +
                        "Nam participated in a running competition last week.\n" +
                        "Dịch nghĩa: Nam đã tham gia một cuộc thi chạy vào tuần trước.\n" +
                        "\n" +
                        "He played football with his friends yesterday afternoon.\n" +
                        "Dịch nghĩa: Anh ấy đã chơi bóng đá cùng bạn bè vào buổi chiều hôm qua.\n" +
                        "\n",
            ),
            Grammar(
                id = 14,
                unitId = 8,
                title = "Câu mệnh lệnh",
                usage = "Câu mệnh lệnh được sử dụng để đưa ra yêu cầu hoặc mệnh lệnh cho ai đó. \n" +
                        "\n" +
                        "Cấu trúc:\n" +
                        "\n" +
                        "Khẳng định: V(bare)\n" +
                        "Phủ định: Don’t + V(bare)",
                content = "Pass me the ball!\n" +
                        "Dịch nghĩa: Chuyền cho tôi quả bóng đi!\n" +
                        "\n" +
                        "Don't forget to follow the rules of the game.\n" +
                        "Dịch nghĩa: Đừng quên tuân thủ các quy tắc của trò chơi.",
            ),
            Grammar(
                id = 15,
                unitId = 9,
                title = "Tính từ sở hữu",
                usage = "Một tính từ sở hữu chỉ được sử dụng khi có danh từ đứng sau nó. Các tính từ sở hữu được tổng hợp trong bảng dưới đây.\n" +
                        "\n" +
                        "Đại từ nhân xưng | Tính từ sở hữu | Ý nghĩa tính từ sở hữu\n" +
                        "I | my | của tôi \n" +
                        "you | your | của bạn\n" +
                        "we | our | của chúng ta\n" +
                        "they | their | của họ\n" +
                        "he | his | của anh ấy\n" +
                        "she | her | của cô ấy\n" +
                        "it | its | của nó\n",
                content = "Ví dụ:\n" +
                        "\n" +
                        "My parents bought me some souvenirs from that stall over there.\n" +
                        "Dịch nghĩa: Bố mẹ tôi đã mua cho tôi một số quà lưu niệm từ cái quầy đằng kia.\n" +
                        "\n" +
                        "Our country is famous for its street food.\n" +
                        "Dịch nghĩa: Đất nước của chúng ta nổi tiếng nhờ đặc sản đường phố của nó."
            ),

            Grammar(
                id = 16,
                unitId = 9,
                title = "Đại từ sở hữu",
                usage = "Một đại từ sở hữu có thể đứng riêng lẻ, không có danh từ theo sau. Các đại từ sở hữu được tổng hợp trong bảng dưới đây.\n" +
                        "\n" +
                        "Đại từ nhân xưng | Đại từ sở hữu | Ý nghĩa đại từ sở hữu\n" +
                        "I | mine | của tôi \n" +
                        "you | yours | của bạn\n" +
                        "we | ours | của chúng ta\n" +
                        "they | theirs | của họ\n" +
                        "he | his | của anh ấy\n" +
                        "she | hers | của cô ấy\n" +
                        "it | - | -\n",
                content = "Ví dụ:\n" +
                        "\n" +
                        "Your city is more crowded than mine.\n" +
                        "Dịch nghĩa: Thành phố của bạn đông đúc hơn thành phố của tôi.\n" +
                        "\n" +
                        "I think Mai’s hair is a little bit longer than yours.\n" +
                        "Dịch nghĩa: Tôi nghĩ tóc của Mai dài hơn một chút so với tóc của bạn."
            ),
            Grammar(
                id = 17,
                unitId = 10,
                title = "Thì Tương lai đơn",
                usage = "Thì Tương lai đơn được sử dụng để diễn tả những sự việc hay hành động sẽ xảy ra trong tương lai nhưng chưa có dự định hay kế hoạch cụ thể từ trước. Thì Tương lai đơn còn được sử dụng để đưa ra những dự đoán về những sự việc có thể xảy ra trong tương lai. Ngoài ra, có thể sử dụng Thì Tương lai đơn khi đề nghị, đồng ý hoặc hứa hẹn sẽ làm gì đó.\n",
                content = "Cấu trúc:\n" +
                        "\n" +
                        "Câu khẳng định: S + will + V(bare)\n" +
                        "Câu phủ định: S + won’t + V(bare)\n" +
                        "Câu hỏi: Will + S  + V(bare)?\n" +
                        "\n" +
                        "Ví dụ:\n" +
                        "\n" +
                        "My future house will be on the Moon.\n" +
                        "Dịch nghĩa: Nhà tương lai của tôi sẽ ở trên Mặt Trăng.\n" +
                        "\n" +
                        "Vy thinks we will see flying cars soon.\n" +
                        "Dịch nghĩa: Vy nghĩ rằng chúng ta sẽ sớm được thấy xe hơi biết bay.\n" +
                        "\n" +
                        "I’ll come to fix your electric fan tomorrow. I promise.\n" +
                        "Dịch nghĩa: Ngày mai tôi sẽ đến sửa quạt điện cho bạn. Tôi hứa đấy."
            ),

            Grammar(
                id = 18,
                unitId = 10,
                title = "Động từ khiếm khuyến: Might",
                usage = "Might được sử dụng để nói về sự vật, hiện tượng có khả năng xảy ra trong tương lai, nhưng không chắc chắn sẽ xảy ra. Might là động từ khiếm khuyết, phải được theo sau bởi một động từ thường với chức năng là động từ chính trong câu.\n",
                content = "Ví dụ:\n" +
                        "\n" +
                        "Our houses might get our electricity from the Sun.\n" +
                        "Dịch nghĩa: Nhà của chúng ta có khả năng là sẽ lấy điện từ Mặt Trời.\n" +
                        "\n" +
                        "Robots might take care of our housework.\n" +
                        "Dịch nghĩa: Người máy có khả năng sẽ làm việc nhà hộ chúng ta."
            ),
            Grammar(
                id = 19,
                unitId = 11,
                title = "Mạo từ",
                usage = "Mạo từ gồm hai loại: mạo từ không xác định (a/an) và mạo từ xác định (the). A/an đứng trước các danh từ đếm được số ít khi chúng chưa được xác định, hoặc khi chỉ nói chung về chúng. The đứng trước cả danh từ số ít và danh từ số nhiều khi chúng đã được xác định, tức khi chúng là một vật duy nhất, hay khi ai cũng biết về chúng, hoặc khi chúng được nhắc lại lần thứ hai.\n",
                content = "Ví dụ:\n" +
                        "\n" +
                        "My mother bought a reusable shopping bag recently.\n" +
                        "Dịch nghĩa: Gần đây mẹ tôi đã mua một cái túi mua sắm có thể tái sử dụng.\n" +
                        "\n" +
                        "The Sun is much larger than the Earth.\n" +
                        "Dịch nghĩa: Mặt Trời lớn hơn nhiều so với Trái Đất.\n" +
                        "\n" +
                        "There is some paper in your drawer. Pass me the paper so I can recycle it, please.\n" +
                        "Dịch nghĩa: Có một ít giấy trong ngăn kéo của bạn. Đưa cho tôi chỗ giấy đó để tôi đem đi tái chế nào."
            ),

            Grammar(
                id = 20,
                unitId = 11,
                title = "Câu điều kiện loại I",
                usage = "Câu điều kiện loại I diễn tả những sự việc hoặc hành động có thể xảy ra và có khả năng cao sẽ xảy ra trong hiện tại hoặc trong tương lai.\n",
                content = "Cấu trúc: If + S + V(s/es), S + will/won’t + V(bare)\n" +
                        "\n" +
                        "Ví dụ:\n" +
                        "\n" +
                        "If I recycle more, I will help the environment.\n" +
                        "Dịch nghĩa: Nếu tôi tái chế nhiều hơn, tôi sẽ giúp bảo vệ môi trường.\n" +
                        "\n" +
                        "If we walk instead of asking our parents to drive us, we will be more healthy.\n" +
                        "Dịch nghĩa: Nếu chúng ta đi bộ thay vì nhờ bố mẹ chở, chúng ta sẽ khỏe mạnh hơn."
            ),

            Grammar(
                id = 21,
                unitId = 12,
                title = "Cấp so sánh nhất của tính từ: Tính từ ngắn",
                usage = "Cấp so sánh nhất của tính từ được sử dụng để so sánh từ 3 người hoặc vật trở lên. Cấp so sánh nhất của tính từ nhấn mạnh tính chất nào đó của 1 người hay vật là nhất so với những người hay vật còn lại trong nhóm.\n" +
                        "Cấu trúc:\n" +
                        "\n" +
                        "Tính từ ngắn: the adj-est/iest\n" +
                        "Có các tính từ đặc biệt trong so sánh nhất không tuân thủ cấu trúc trên, một số từ đã được liệt kê trong bảng dưới đây.\n" +
                        "\n" +
                        "Tính từ | Cấp so sánh nhất\n" +
                        "good | the best\n" +
                        "bad | the worst\n" +
                        "far | the farthest/furthest\n" +
                        "little | the least\n" +
                        "many/much | the most\n" +
                        "\n",
                content =
                "Ví dụ:\n" +
                        "\n" +
                        "My future robot will be the tallest in the world!\n" +
                        "Dịch nghĩa: Người máy tương lai của tôi sẽ là người máy cao nhất thế giới!\n" +
                        "\n" +
                        "This is the smartest robot ever! It can work as a doctor and cure diseases.\n" +
                        "Dịch nghĩa: Đây là người máy thông minh nhất từng thấy! Nó có thể hành nghề bác sĩ và chữa bệnh."
            )






        )

        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                val dao = getDatabase().grammarDao()
                val existingIds = dao.getAllGrammarIds() // Lấy danh sách ID hiện tại

                // Lọc các bản ghi có id chưa tồn tại
                val newGrammar = grammarList.filter { it.id !in existingIds }

                if (newGrammar.isNotEmpty()) {
                    dao.insertGrammar(newGrammar)
                }
            }
        }
    }
    fun insertQuestionGrammar() {
        val questionGrammarList = listOf(
            QuestionGrammar(
                id = 1,
                unitId = 1,
                question = "rides / Duy / to school / every day.",
                answer = "Duy rides to school every day."
            ),
            QuestionGrammar(
                id = 2,
                unitId = 1,
                question = "always / We / have / math class.",
                answer = "We always have math class."
            ),
            QuestionGrammar(
                id = 3,
                unitId = 1,
                question = "My biology / starts / class / at 7 am.",
                answer = "My biology class starts at 7 am."
            ),
            QuestionGrammar(
                id = 4,
                unitId = 1,
                question = "dry / Our uniforms / faster / on sunny days.",
                answer = "Our uniforms dry faster on sunny days."
            ),
            QuestionGrammar(
                id = 5,
                unitId = 1,
                question = "I / often / finish / my homework.",
                answer = "I often finish my homework."
            ),
            QuestionGrammar(
                id = 6,
                unitId = 1,
                question = "usually / Mai / studies / hard.",
                answer = "Mai usually studies hard."
            ),
            QuestionGrammar(
                id = 7,
                unitId = 1,
                question = "rarely / have / Duy and Mai / lunch together.",
                answer = "Duy and Mai rarely have lunch together."
            ),
            QuestionGrammar(
                id = 8,
                unitId = 1,
                question = "sometimes / visit / We / our grandparents.",
                answer = "We sometimes visit our grandparents."
            ),
            QuestionGrammar(
                id = 9,
                unitId = 1,
                question = "always / wakes up / She / early.",
                answer = "She always wakes up early."
            ),
            QuestionGrammar(
                id = 10,
                unitId = 1,
                question = "teaches / Mr. John / English / every day.",
                answer = "Mr. John teaches English every day."
            ),
            QuestionGrammar(
                id = 11,
                unitId = 2,
                question = "on / The book / the armchair / is.",
                answer = "The book is on the armchair."
            ),
            QuestionGrammar(
                id = 12,
                unitId = 2,
                question = "under / The cat / the bed / is.",
                answer = "The cat is under the bed."
            ),
            QuestionGrammar(
                id = 13,
                unitId = 2,
                question = "in front of / is / She / the lamp.",
                answer = "She is in front of the lamp."
            ),
            QuestionGrammar(
                id = 14,
                unitId = 2,
                question = "are / between / the keys / the cushions.",
                answer = "The keys are between the cushions."
            ),
            QuestionGrammar(
                id = 15,
                unitId = 2,
                question = "next to / The chair / is / the table.",
                answer = "The chair is next to the table."
            ),
            QuestionGrammar(
                id = 16,
                unitId = 2,
                question = "Phong's / room / a desk / has.",
                answer = "Phong's room has a desk."
            ),
            QuestionGrammar(
                id = 17,
                unitId = 2,
                question = "friend's / sister / My / is older.",
                answer = "My friend's sister is older."
            ),
            QuestionGrammar(
                id = 18,
                unitId = 2,
                question = "My / is / smaller / flat.",
                answer = "My flat is smaller."
            ),
            QuestionGrammar(
                id = 19,
                unitId = 2,
                question = "is / This / Lan's / notebook.",
                answer = "This is Lan's notebook."
            ),
            QuestionGrammar(
                id = 20,
                unitId = 2,
                question = "belongs / This book / to / Nam's sister.",
                answer = "This book belongs to Nam's sister."
            ),
            QuestionGrammar(
                id = 21,
                unitId = 3,
                question = "is / Minh / making / a cake.",
                answer = "Minh is making a cake."
            ),
            QuestionGrammar(
                id = 22,
                unitId = 3,
                question = "learning / I / to swim / am.",
                answer = "I am learning to swim."
            ),
            QuestionGrammar(
                id = 23,
                unitId = 3,
                question = "are / They / playing / soccer.",
                answer = "They are playing soccer."
            ),
            QuestionGrammar(
                id = 24,
                unitId = 3,
                question = "at the moment / reading / She / is.",
                answer = "She is reading at the moment."
            ),
            QuestionGrammar(
                id = 25,
                unitId = 3,
                question = "working / We / on / are / a new project.",
                answer = "We are working on a new project."
            ),
            QuestionGrammar(
                id = 26,
                unitId = 3,
                question = "cooking / He / dinner / is / now.",
                answer = "He is cooking dinner now."
            ),
            QuestionGrammar(
                id = 27,
                unitId = 3,
                question = "My father / fixing / is / the car.",
                answer = "My father is fixing the car."
            ),
            QuestionGrammar(
                id = 28,
                unitId = 3,
                question = "am / My sister and I / painting / the house.",
                answer = "My sister and I are painting the house."
            ),
            QuestionGrammar(
                id = 29,
                unitId = 3,
                question = "the children / Is / playing / in the garden?",
                answer = "Are the children playing in the garden?"
            ),
            QuestionGrammar(
                id = 30,
                unitId = 3,
                question = "am / writing / I / an email.",
                answer = "I am writing an email."
            ),
            QuestionGrammar(
                id = 31,
                unitId = 4,
                question = "more / Life in the city / than / expensive / is life in the countryside.",
                answer = "Life in the city is more expensive than life in the countryside."
            ),
            QuestionGrammar(
                id = 32,
                unitId = 4,
                question = "nearer / than / The museum / is / the temple.",
                answer = "The museum is nearer than the temple."
            ),
            QuestionGrammar(
                id = 33,
                unitId = 4,
                question = "better / Walking / for our health / than / is taking the bus.",
                answer = "Walking is better for our health than taking the bus."
            ),
            QuestionGrammar(
                id = 34,
                unitId = 4,
                question = "faster / Cars / than / are / bicycles.",
                answer = "Cars are faster than bicycles."
            ),
            QuestionGrammar(
                id = 35,
                unitId = 4,
                question = "is / The book / more interesting / than / the movie.",
                answer = "The book is more interesting than the movie."
            ),
            QuestionGrammar(
                id = 36,
                unitId = 4,
                question = "is / My house / bigger / than / her house.",
                answer = "My house is bigger than her house."
            ),
            QuestionGrammar(
                id = 37,
                unitId = 4,
                question = "more delicious / Pizza / than / burgers / is.",
                answer = "Pizza is more delicious than burgers."
            ),
            QuestionGrammar(
                id = 38,
                unitId = 4,
                question = "is / today / colder / than / yesterday.",
                answer = "Today is colder than yesterday."
            ),
            QuestionGrammar(
                id = 39,
                unitId = 4,
                question = "more difficult / This exercise / than / is / the previous one.",
                answer = "This exercise is more difficult than the previous one."
            ),
            QuestionGrammar(
                id = 40,
                unitId = 4,
                question = "The test / than / was / harder / we expected.",
                answer = "The test was harder than we expected."
            ),
            QuestionGrammar(
                id = 41,
                unitId = 5,
                question = "packing / I’m / a few / pills.",
                answer = "I’m packing a few pills."
            ),
            QuestionGrammar(
                id = 42,
                unitId = 5,
                question = "some / Do / you / have / suncream?",
                answer = "Do you have some suncream?"
            ),
            QuestionGrammar(
                id = 43,
                unitId = 5,
                question = "some / We / water / need.",
                answer = "We need some water."
            ),
            QuestionGrammar(
                id = 44,
                unitId = 5,
                question = "some / My friend / bought / fruits.",
                answer = "My friend bought some fruits."
            ),
            QuestionGrammar(
                id = 45,
                unitId = 5,
                question = "don’t / We / have / any / milk.",
                answer = "We don’t have any milk."
            ),
            QuestionGrammar(
                id = 46,
                unitId = 5,
                question = "Did / any / you / get / oranges?",
                answer = "Did you get any oranges?"
            ),
            QuestionGrammar(
                id = 47,
                unitId = 5,
                question = "bought / My mom / a few / books.",
                answer = "My mom bought a few books."
            ),
            QuestionGrammar(
                id = 48,
                unitId = 5,
                question = "Do / have / you / any / rice?",
                answer = "Do you have any rice?"
            ),
            QuestionGrammar(
                id = 49,
                unitId = 5,
                question = "a little / I / need / sugar.",
                answer = "I need a little sugar."
            ),
            QuestionGrammar(
                id = 50,
                unitId = 5,
                question = "has / My friend / a few / questions.",
                answer = "My friend has a few questions."
            ),
            QuestionGrammar(
                id = 51,
                unitId = 6,
                question = "be / careful / You / must.",
                answer = "You must be careful."
            ),
            QuestionGrammar(
                id = 52,
                unitId = 6,
                question = "mustn’t / We / litter / here.",
                answer = "We mustn’t litter here."
            ),
            QuestionGrammar(
                id = 53,
                unitId = 6,
                question = "pay / You / must / attention.",
                answer = "You must pay attention."
            ),
            QuestionGrammar(
                id = 54,
                unitId = 6,
                question = "mustn’t / run / You / in the classroom.",
                answer = "You mustn’t run in the classroom."
            ),
            QuestionGrammar(
                id = 55,
                unitId = 6,
                question = "must / We / wear / uniforms.",
                answer = "We must wear uniforms."
            ),
            QuestionGrammar(
                id = 56,
                unitId = 6,
                question = "should / study / You / harder.",
                answer = "You should study harder."
            ),
            QuestionGrammar(
                id = 57,
                unitId = 6,
                question = "shouldn’t / We / waste / food.",
                answer = "We shouldn’t waste food."
            ),
            QuestionGrammar(
                id = 58,
                unitId = 6,
                question = "eat / You / more / should / vegetables.",
                answer = "You should eat more vegetables."
            ),
            QuestionGrammar(
                id = 59,
                unitId = 6,
                question = "shouldn’t / drive / fast / You.",
                answer = "You shouldn’t drive fast."
            ),
            QuestionGrammar(
                id = 60,
                unitId = 6,
                question = "help / others / We / should.",
                answer = "We should help others."
            ),
            QuestionGrammar(
                id = 61,
                unitId = 7,
                question = "What / are / television shows / popular?",
                answer = "What television shows are popular?"
            ),
            QuestionGrammar(
                id = 62,
                unitId = 7,
                question = "How / often / do / you watch?",
                answer = "How often do you watch?"
            ),
            QuestionGrammar(
                id = 63,
                unitId = 7,
                question = "Why / do / you / enjoy watching?",
                answer = "Why do you enjoy watching?"
            ),
            QuestionGrammar(
                id = 64,
                unitId = 7,
                question = "When / do / you / watch movies?",
                answer = "When do you watch movies?"
            ),
            QuestionGrammar(
                id = 65,
                unitId = 7,
                question = "Where / are / your / keys?",
                answer = "Where are your keys?"
            ),
            QuestionGrammar(
                id = 66,
                unitId = 7,
                question = "Who / is / that / man?",
                answer = "Who is that man?"
            ),
            QuestionGrammar(
                id = 67,
                unitId = 7,
                question = "How / many / apples / do you have?",
                answer = "How many apples do you have?"
            ),
            QuestionGrammar(
                id = 68,
                unitId = 7,
                question = "What / are / your / hobbies?",
                answer = "What are your hobbies?"
            ),
            QuestionGrammar(
                id = 69,
                unitId = 7,
                question = "When / is / your / birthday?",
                answer = "When is your birthday?"
            ),
            QuestionGrammar(
                id = 70,
                unitId = 7,
                question = "Where / do / you / live?",
                answer = "Where do you live?"
            ),
            QuestionGrammar(
                id = 71,
                unitId = 8,
                question = "He / played / football / yesterday.",
                answer = "He played football yesterday."
            ),
            QuestionGrammar(
                id = 72,
                unitId = 8,
                question = "My family / traveled / to / the beach.",
                answer = "My family traveled to the beach."
            ),
            QuestionGrammar(
                id = 73,
                unitId = 8,
                question = "I / forgot / my / book yesterday.",
                answer = "I forgot my book yesterday."
            ),
            QuestionGrammar(
                id = 74,
                unitId = 8,
                question = "We / watched / a / movie last night.",
                answer = "We watched a movie last night."
            ),
            QuestionGrammar(
                id = 75,
                unitId = 8,
                question = "They / visited / their / grandparents on Sunday.",
                answer = "They visited their grandparents on Sunday."
            ),
            QuestionGrammar(
                id = 76,
                unitId = 8,
                question = "Pass / me / the / book.",
                answer = "Pass me the book."
            ),
            QuestionGrammar(
                id = 77,
                unitId = 8,
                question = "Don't / forget / to / study.",
                answer = "Don't forget to study."
            ),
            QuestionGrammar(
                id = 78,
                unitId = 8,
                question = "Please / be / quiet / now.",
                answer = "Please be quiet now."
            ),
            QuestionGrammar(
                id = 79,
                unitId = 8,
                question = "Close / the / door / slowly.",
                answer = "Close the door slowly."
            ),
            QuestionGrammar(
                id = 80,
                unitId = 8,
                question = "Take / care / of / yourself.",
                answer = "Take care of yourself."
            ),
            QuestionGrammar(
                id = 81,
                unitId = 9,
                question = "My / parents / bought / me souvenirs.",
                answer = "My parents bought me souvenirs."
            ),
            QuestionGrammar(
                id = 82,
                unitId = 9,
                question = "Our / school / is / big.",
                answer = "Our school is big."
            ),
            QuestionGrammar(
                id = 83,
                unitId = 9,
                question = "Her / cat / is / cute.",
                answer = "Her cat is cute."
            ),
            QuestionGrammar(
                id = 84,
                unitId = 9,
                question = "His / car / is / red.",
                answer = "His car is red."
            ),
            QuestionGrammar(
                id = 85,
                unitId = 9,
                question = "Their / house / is / beautiful.",
                answer = "Their house is beautiful."
            ),
            QuestionGrammar(
                id = 86,
                unitId = 9,
                question = "This / book / is / mine.",
                answer = "This book is mine."
            ),
            QuestionGrammar(
                id = 87,
                unitId = 9,
                question = "The / bicycles / are / theirs.",
                answer = "The bicycles are theirs."
            ),
            QuestionGrammar(
                id = 88,
                unitId = 9,
                question = "That / pen / is / yours.",
                answer = "That pen is yours."
            ),
            QuestionGrammar(
                id = 89,
                unitId = 9,
                question = "The / toys / are / his.",
                answer = "The toys are his."
            ),
            QuestionGrammar(
                id = 90,
                unitId = 9,
                question = "The / house / is / ours.",
                answer = "The house is ours."
            ),
            QuestionGrammar(
                id = 91,
                unitId = 10,
                question = "My / future house / will / be / on the Moon.",
                answer = "My future house will be on the Moon."
            ),
            QuestionGrammar(
                id = 92,
                unitId = 10,
                question = "Vy / thinks / we / will / see flying cars.",
                answer = "Vy thinks we will see flying cars."
            ),
            QuestionGrammar(
                id = 93,
                unitId = 10,
                question = "I / will / come / to / fix your fan.",
                answer = "I will come to fix your fan."
            ),
            QuestionGrammar(
                id = 94,
                unitId = 10,
                question = "Our / houses / might / get / electricity from the Sun.",
                answer = "Our houses might get electricity from the Sun."
            ),
            QuestionGrammar(
                id = 95,
                unitId = 10,
                question = "Robots / might / take / care of / our housework.",
                answer = "Robots might take care of our housework."
            ),
            QuestionGrammar(
                id = 96,
                unitId = 10,
                question = "I / might / visit / my friend / tomorrow.",
                answer = "I might visit my friend tomorrow."
            ),
            QuestionGrammar(
                id = 97,
                unitId = 10,
                question = "You / will / enjoy / this / movie.",
                answer = "You will enjoy this movie."
            ),
            QuestionGrammar(
                id = 98,
                unitId = 10,
                question = "The / weather / might / be / rainy tomorrow.",
                answer = "The weather might be rainy tomorrow."
            ),
            QuestionGrammar(
                id = 99,
                unitId = 10,
                question = "I / won't / forget / to / call you.",
                answer = "I won't forget to call you."
            ),
            QuestionGrammar(
                id = 100,
                unitId = 10,
                question = "He / will / buy / a / new laptop.",
                answer = "He will buy a new laptop."
            ),
            QuestionGrammar(
                id = 101,
                unitId = 11,
                question = "My / mother / bought / a / reusable bag.",
                answer = "My mother bought a reusable bag."
            ),
            QuestionGrammar(
                id = 102,
                unitId = 11,
                question = "The / Sun / is / larger / than the Earth.",
                answer = "The Sun is larger than the Earth."
            ),
            QuestionGrammar(
                id = 103,
                unitId = 11,
                question = "Pass / me / the / paper / please.",
                answer = "Pass me the paper please."
            ),
            QuestionGrammar(
                id = 104,
                unitId = 11,
                question = "There / is / an / apple / on the table.",
                answer = "There is an apple on the table."
            ),
            QuestionGrammar(
                id = 105,
                unitId = 11,
                question = "If / I / recycle / more, / I will help the environment.",
                answer = "If I recycle more, I will help the environment."
            ),
            QuestionGrammar(
                id = 106,
                unitId = 11,
                question = "If / we / walk, / we / will be healthier.",
                answer = "If we walk, we will be healthier."
            ),
            QuestionGrammar(
                id = 107,
                unitId = 11,
                question = "The / bag / is / in / the drawer.",
                answer = "The bag is in the drawer."
            ),
            QuestionGrammar(
                id = 108,
                unitId = 11,
                question = "If / you / study / harder, / you will pass.",
                answer = "If you study harder, you will pass."
            ),
            QuestionGrammar(
                id = 109,
                unitId = 11,
                question = "The / book / is / on / the shelf.",
                answer = "The book is on the shelf."
            ),
            QuestionGrammar(
                id = 110,
                unitId = 11,
                question = "If / it / rains, / we / won’t go out.",
                answer = "If it rains, we won’t go out."
            ),
            QuestionGrammar(
                id = 111,
                unitId = 12,
                question = "My / future robot / will / be / the tallest in the world.",
                answer = "My future robot will be the tallest in the world."
            ),
            QuestionGrammar(
                id = 112,
                unitId = 12,
                question = "This / is / the / smartest robot / ever!",
                answer = "This is the smartest robot ever!"
            ),
            QuestionGrammar(
                id = 113,
                unitId = 12,
                question = "The / Nile / is / the / longest river.",
                answer = "The Nile is the longest river."
            ),
            QuestionGrammar(
                id = 114,
                unitId = 12,
                question = "This / is / the / most beautiful / place I’ve seen.",
                answer = "This is the most beautiful place I’ve seen."
            ),
            QuestionGrammar(
                id = 115,
                unitId = 12,
                question = "Mount / Everest / is / the / highest mountain.",
                answer = "Mount Everest is the highest mountain."
            ),
            QuestionGrammar(
                id = 116,
                unitId = 12,
                question = "This / exam / was / the / hardest one.",
                answer = "This exam was the hardest one."
            ),
            QuestionGrammar(
                id = 117,
                unitId = 12,
                question = "That / dog / is / the / friendliest.",
                answer = "That dog is the friendliest."
            ),
            QuestionGrammar(
                id = 118,
                unitId = 12,
                question = "This / is / the / best / idea we’ve had.",
                answer = "This is the best idea we’ve had."
            ),
            QuestionGrammar(
                id = 119,
                unitId = 12,
                question = "The / Amazon / is / the / widest river.",
                answer = "The Amazon is the widest river."
            ),
            QuestionGrammar(
                id = 120,
                unitId = 12,
                question = "This / is / the / most interesting / book.",
                answer = "This is the most interesting book."
            ),



            )

        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                val dao = getDatabase().questionGrammarDao()
                val existingIds = dao.getAllQuestionGrammarIds()
                val newQuestions = questionGrammarList.filter { it.id !in existingIds }

                // Chỉ chèn các câu hỏi mới
                if (newQuestions.isNotEmpty()) {
                    dao.insertQuestions(newQuestions)
                }
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
                    "n",
                    "/ækˈtɪv.ə.ti/",
                    "hoạt động",
                    R.raw.activity,
                    1
                ),
                Vocabulary(2, R.drawable.art, "art", "n", "/ɑːt/", "nghệ thuật", R.raw.art, 1),
                Vocabulary(
                    3,
                    R.drawable.boarding_school,
                    "boarding school",
                    "n",
                    "/ˈbɔː.dɪŋ ˌskuːl/",
                    "trường nội trú",
                    R.raw.boarding_school,
                    1
                ),
                Vocabulary(
                    4,
                    R.drawable.calculator,
                    "calculator",
                    "n",
                    "/ˈkæl.kjə.leɪ.tər/",
                    "máy tính",
                    R.raw.calculator,
                    1
                ),
                Vocabulary(
                    5,
                    R.drawable.classmate,
                    "classmate",
                    "n",
                    "/ˈklɑːs.meɪt/",
                    "bạn cùng lớp",
                    R.raw.classmate,
                    1
                ),
                Vocabulary(
                    6,
                    R.drawable.compass,
                    "compass",
                    "n",
                    "/ˈkʌm.pəs/",
                    "com-pa",
                    R.raw.compass,
                    1
                ),
                Vocabulary(
                    7,
                    R.drawable.favorite,
                    "favourite",
                    "adj",
                    "/ˈfeɪ.vər.ɪt/",
                    "được yêu thích",
                    R.raw.favorite,
                    1
                ),
                Vocabulary(
                    8,
                    R.drawable.help,
                    "help",
                    "n, v",
                    "/help/",
                    "sự giúp đỡ, giúp đỡ",
                    R.raw.help,
                    1
                ),
                Vocabulary(
                    9,
                    R.drawable.international,
                    "international",
                    "adj",
                    "/ˌɪn.təˈnæʃ.ən.əl/",
                    "quốc tế",
                    R.raw.international,
                    1
                ),
                Vocabulary(
                    10,
                    R.drawable.interview,
                    "interview",
                    "n, v",
                    "/ˈɪn.tə.vjuː/",
                    "cuộc phỏng vấn, phỏng vấn",
                    R.raw.interview,
                    1
                ),
                Vocabulary(11, R.drawable.knock, "knock", "v", "/nɒk/", "gõ (cửa)", R.raw.knock, 1),
                Vocabulary(
                    12,
                    R.drawable.remember,
                    "remember",
                    "v",
                    "/rɪˈmem.bər/",
                    "nhớ, ghi nhớ",
                    R.raw.remember,
                    1
                ),
                Vocabulary(13, R.drawable.share, "share", "v", "/ʃeər/", "chia sẻ", R.raw.share, 1),
                Vocabulary(
                    14,
                    R.drawable.smart,
                    "smart",
                    "adj",
                    "/smɑːt/",
                    "bảnh bao, gọn gàng",
                    R.raw.smart,
                    1
                ),
                Vocabulary(
                    15,
                    R.drawable.swimming_pool,
                    "swimming pool",
                    "n",
                    "/ˈswɪm.ɪŋ ˌpuːl/",
                    "bể bơi",
                    R.raw.swimming_pool,
                    1
                ),
                Vocabulary(16, R.drawable.between, "between", "prep", "/bɪˈtwiːn/", "ở giữa", R.raw.between, 2),
                Vocabulary(17, R.drawable.chest_of_drawers, "chest of drawers", "n", "/ˌtʃest əv ˈdrɔːz/", "tủ có ngăn kéo", R.raw.chest_of_drawers, 2),
                Vocabulary(18, R.drawable.cooker, "cooker", "n", "/ˈkʊk.ər/", "bếp", R.raw.cooker, 2),
                Vocabulary(19, R.drawable.country_house, "country house", "n", "/ˌkʌn.tri ˈhaʊs/", "nhà ở vùng quê", R.raw.country_house, 2),
                Vocabulary(20, R.drawable.crazy, "crazy", "adj", "/ˈkreɪ.zi/", "kì lạ, lạ thường", R.raw.crazy, 2),
                Vocabulary(21, R.drawable.cupboard, "cupboard", "n", "/ˈkʌb.əd/", "tủ đựng bát đĩa, quần áo", R.raw.cupboard, 2),
                Vocabulary(22, R.drawable.department_store, "department store", "n", "/dɪˈpɑːt.mənt ˌstɔːr/", "cửa hàng, bách hoá", R.raw.department_store, 2),
                Vocabulary(23, R.drawable.dishwasher, "dishwasher", "n", "/ˈdɪʃˌwɒʃ.ər/", "máy rửa bát", R.raw.dishwasher, 2),
                Vocabulary(24, R.drawable.flat, "flat", "n", "/flæt/", "căn hộ", R.raw.flat, 2),
                Vocabulary(25, R.drawable.furniture, "furniture", "n", "/ˈfɜː.nɪ.tʃər/", "đồ đạc trong nhà", R.raw.furniture, 2),
                Vocabulary(26, R.drawable.hall, "hall", "n", "/hɔːl/", "sảnh", R.raw.hall, 2),
                Vocabulary(27, R.drawable.in_front_of, "in front of", "prep", "/ɪn frʌnt əv/", "ở đằng trước, phía trước", R.raw.in_front_of, 2),
                Vocabulary(28, R.drawable.next_to, "next to", "prep", "/nekst tuː/", "bên cạnh", R.raw.next_to, 2),
                Vocabulary(29, R.drawable.shelf, "shelf", "n", "/ʃelf/", "kệ, giá", R.raw.shelf, 2),
                Vocabulary(30, R.drawable.sink, "sink", "n", "/sɪŋk/", "bồn rửa bát", R.raw.sink, 2),
                Vocabulary(31, R.drawable.strange, "strange", "adj", "/streɪndʒ/", "kì lạ", R.raw.strange, 2),
                Vocabulary(32, R.drawable.town_house, "town house", "n", "/ˈtaʊn ˌhaʊs/", "nhà phố", R.raw.town_house, 2),
                Vocabulary(33, R.drawable.wardrobe, "wardrobe", "n", "/ˈwɔː.drəʊb/", "tủ đựng quần áo", R.raw.wardrobe, 2),
                Vocabulary(34, R.drawable.active, "active", "adj", "/ˈæk.tɪv/", "hăng hái, năng động", R.raw.active, 3),
                Vocabulary(35, R.drawable.appearance, "appearance", "n", "/əˈpɪə.rəns/", "bề ngoài, ngoại hình", R.raw.appearance, 3),
                Vocabulary(36, R.drawable.careful, "careful", "adj", "/ˈkeə.fəl/", "cẩn thận", R.raw.careful, 3),
                Vocabulary(37, R.drawable.caring, "caring", "adj", "/ˈkeə.rɪŋ/", "chu đáo, biết quan tâm", R.raw.caring, 3),
                Vocabulary(38, R.drawable.cheek, "cheek", "n", "/tʃiːk/", "má", R.raw.cheek, 3),
                Vocabulary(39, R.drawable.clever, "clever", "adj", "/ˈklev.ər/", "lanh lợi, thông minh", R.raw.clever, 3),
                Vocabulary(40, R.drawable.confident, "confident", "adj", "/ˈkɒn.fɪ.dənt/", "tự tin", R.raw.confident, 3),
                Vocabulary(41, R.drawable.creative, "creative", "adj", "/kriˈeɪ.tɪv/", "sáng tạo", R.raw.creative, 3),
                Vocabulary(42, R.drawable.friendly, "friendly", "adj", "/ˈfrend.li/", "thân thiện", R.raw.friendly, 3),
                Vocabulary(43, R.drawable.funny, "funny", "adj", "/ˈfʌn.i/", "ngộ nghĩnh, khôi hài", R.raw.funny, 3),
                Vocabulary(44, R.drawable.hard_working, "hard-working", "adj", "/ˌhɑːdˈwɜː.kɪŋ/", "chăm chỉ", R.raw.hard_working, 3),
                Vocabulary(45, R.drawable.kind, "kind", "adj", "/kaɪnd/", "tốt bụng", R.raw.kind, 3),
                Vocabulary(46, R.drawable.loving, "loving", "adj", "/ˈlʌv.ɪŋ/", "giàu tình yêu thương", R.raw.loving, 3),
                Vocabulary(47, R.drawable.personality, "personality", "n", "/ˌpɜː.sənˈæl.ə.ti/", "tính cách", R.raw.personality, 3),
                Vocabulary(48, R.drawable.shoulder, "shoulder", "n", "/ˈʃəʊl.dər/", "vai", R.raw.shoulder, 3),
                Vocabulary(49, R.drawable.shy, "shy", "adj", "/ʃaɪ/", "xấu hổ", R.raw.shy, 3),
                Vocabulary(50, R.drawable.slim, "slim", "adj", "/slɪm/", "mảnh khảnh, thanh mảnh", R.raw.slim, 3),
                Vocabulary(51, R.drawable.art_gallery, "art gallery", "n", "/ˈɑːt ˌɡæl.ər.i/", "phòng trưng bày các tác phẩm nghệ thuật", R.raw.art_gallery, 4),
                Vocabulary(52, R.drawable.busy, "busy", "adj", "/ˈbɪz.i/", "nhộn nhịp, náo nhiệt", R.raw.busy, 4),
                Vocabulary(53, R.drawable.cathedral, "cathedral", "n", "/kəˈθiː.drəl/", "nhà thờ lớn, thánh đường", R.raw.cathedral, 4),
                Vocabulary(54, R.drawable.cross, "cross", "v", "/krɒs/", "đi ngang qua, qua, vượt", R.raw.cross, 4),
                Vocabulary(55, R.drawable.dislike, "dislike", "v", "/dɪˈslaɪk/", "không thích, ghét", R.raw.dislike, 4),
                Vocabulary(56, R.drawable.famous, "famous", "adj", "/ˈfeɪ.məs/", "nổi tiếng", R.raw.famous, 4),
                Vocabulary(57, R.drawable.faraway, "faraway", "adj", "/ˌfɑː.rəˈweɪ/", "xa xôi, xa", R.raw.faraway, 4),
                Vocabulary(58, R.drawable.finally_img, "finally", "adv", "/ˈfaɪ.nəl.i/", "cuối cùng", R.raw.finally_mp3, 4),
                Vocabulary(59, R.drawable.narrow, "narrow", "adj", "/ˈnær.əʊ/", "hẹp, chật hẹp", R.raw.narrow, 4),
                Vocabulary(60, R.drawable.outdoor, "outdoor", "adj", "/ˈaʊtˌdɔːr/", "ngoài trời", R.raw.outdoor, 4),
                Vocabulary(61, R.drawable.railway_station, "railway station", "n", "/ˈreɪl.weɪ ˌsteɪ.ʃən/", "ga tàu hỏa", R.raw.railway_station, 4),
                Vocabulary(62, R.drawable.sandy, "sandy", "adj", "/ˈsæn.dɪ/", "có cát, phủ cát", R.raw.sandy, 4),
                Vocabulary(63, R.drawable.square, "square", "n", "/skweər/", "quảng trường", R.raw.square, 4),
                Vocabulary(64, R.drawable.suburb, "suburb", "n", "/ˈsʌb.ɜːb/", "khu vực ngoại ô", R.raw.suburb, 4),
                Vocabulary(65, R.drawable.turning, "turning", "n", "/ˈtɜː.nɪŋ/", "chỗ ngoặt, chỗ rẽ", R.raw.turning, 4),
                Vocabulary(66, R.drawable.workshop, "workshop", "n", "/ˈwɜːk.ʃɒp/", "phân xưởng (sản xuất, sửa chữa)", R.raw.workshop, 4),
                Vocabulary(67, R.drawable.amazing, "amazing", "adj", "/əˈmeɪ.zɪŋ/", "tuyệt vời", R.raw.amazing, 5),
                Vocabulary(68, R.drawable.backpack, "backpack", "n", "/ˈbæk.pæk/", "ba-lô", R.raw.backpack, 5),
                Vocabulary(69, R.drawable.boat, "boat", "n", "/bəʊt/", "con thuyền", R.raw.boat, 5),
                Vocabulary(70, R.drawable.laban, "compass", "n", "/ˈkʌm.pəs/", "la bàn", R.raw.compass, 5),
                Vocabulary(71, R.drawable.desert, "desert", "n", "/ˈdez.ət/", "sa mạc", R.raw.desert, 5),
                Vocabulary(72, R.drawable.island, "island", "n", "/ˈaɪ.lənd/", "đảo, hòn đảo", R.raw.island, 5),
                Vocabulary(73, R.drawable.join_in, "join in", "v", "/dʒɔɪn/", "tham gia", R.raw.join_in, 5),
                Vocabulary(74, R.drawable.landscape, "landscape", "n", "/ˈlænd.skeɪp/", "phong cảnh", R.raw.landscape, 5),
                Vocabulary(75, R.drawable.litter, "litter", "v", "/ˈlɪt.ər/", "vứt rác (bừa bãi)", R.raw.litter, 5),
                Vocabulary(76, R.drawable.man_made, "man-made", "adj", "/ˌmænˈmeɪd/", "nhân tạo", R.raw.man_made, 5),
                Vocabulary(77, R.drawable.mount, "mount", "n", "/maʊnt/", "núi, đồi, đỉnh", R.raw.mount, 5),
                Vocabulary(78, R.drawable.mountain_range, "mountain range", "n", "/ˈmaʊn.tɪn ˌreɪndʒ/", "dãy núi", R.raw.mountain_range, 5),
                Vocabulary(79, R.drawable.natural_wonder, "natural wonder", "n", "/ˈnætʃ.ər.əl ˈwʌn.dər/", "kì quan thiên nhiên", R.raw.natural_wonder, 5),
                Vocabulary(80, R.drawable.plaster, "plaster", "n", "/ˈplɑː.stər/", "băng, gạc y tế", R.raw.plaster, 5),
                Vocabulary(81, R.drawable.rock, "rock", "n", "/rɒk/", "tản đá, phiến đá", R.raw.rock, 5),
                Vocabulary(82, R.drawable.show, "show", "n, v", "/ʃəʊ/", "(sự) trình diễn", R.raw.show, 5),
                Vocabulary(83, R.drawable.suncream, "suncream", "n", "/ˈsʌn ˌkriːm/", "kem chống nắng", R.raw.suncream, 5),
                Vocabulary(84, R.drawable.waterfall, "waterfall", "n", "/ˈwɔː.tə.fɔːl/", "thác nước", R.raw.waterfall, 5),
                Vocabulary(85, R.drawable.behave, "behave", "v", "/bɪˈheɪv/", "đối xử, cư xử", R.raw.behave, 6),
                Vocabulary(86, R.drawable.celebrate, "celebrate", "v", "/ˈsel.ə.breɪt/", "kỉ niệm", R.raw.celebrate, 6),
                Vocabulary(87, R.drawable.cheerful, "cheer", "v", "/tʃɪər/", "chúc mừng", R.raw.cheer, 6),
                Vocabulary(88, R.drawable.decorate, "decorate", "v", "/ˈdek.ə.reɪt/", "trang hoàng", R.raw.decorate, 6),
                Vocabulary(89, R.drawable.family_gathering, "family gathering", "n", "/ˈfæm.əl.i ˈɡæð.ər.ɪŋ/", "sum họp gia đình", R.raw.family_gathering, 6),
                Vocabulary(90, R.drawable.firework, "firework", "n", "/ˈfaɪə.wɜːk/", "pháo hoa", R.raw.firework, 6),
                Vocabulary(91, R.drawable.funny, "fun", "n", "/fʌn/", "sự vui đùa, vui vẻ", R.raw.funny, 6),
                Vocabulary(92, R.drawable.lucky, "lucky", "n", "/lʌk/", "điều may mắn", R.raw.luck, 6),
                Vocabulary(93, R.drawable.lucky_money, "lucky money", "n", "/ˈlʌk.i ˈmʌn.i/", "tiền lì xì", R.raw.lucky_money, 6),
                Vocabulary(94, R.drawable.mochi_rice_cake, "mochi rice cake", "n", "/ˈməʊ.tʃi ˈraɪs ˌkeɪk/", "bánh gạo mochi", R.raw.mochi_rice_cake, 6),
                Vocabulary(95, R.drawable.relatives, "relative", "n", "/ˈrel.ə.tɪv/", "bà con (họ hàng)", R.raw.relative, 6),
                Vocabulary(96, R.drawable.strike, "strike", "v", "/straɪk/", "đánh, điểm", R.raw.strike, 6),
                Vocabulary(97, R.drawable.temple, "temple", "n", "/ˈtem.pəl/", "ngôi đền", R.raw.temple, 6),
                Vocabulary(98, R.drawable.throw_img, "throw", "v", "/θrəʊ/", "ném, vứt", R.raw.throw_mp3, 6),
                Vocabulary(99, R.drawable.welcome, "welcome", "v", "/ˈwel.kəm/", "chào đón", R.raw.welcome, 6),
                Vocabulary(100, R.drawable.wish, "wish", "n, v", "/wɪʃ/", "điều ước, ước, chúc", R.raw.wish, 6),
                Vocabulary(101, R.drawable.animated, "animated (film)", "adj", "/ˈæn.ɪ.meɪ.tɪd/", "hoạt hình", R.raw.animated, 7),
                Vocabulary(102, R.drawable.cartoon, "cartoon", "n", "/kɑːˈtuːn/", "phim hoạt hình", R.raw.cartoon, 7),
                Vocabulary(103, R.drawable.channel, "channel", "n", "/ˈtʃæn.əl/", "kênh (truyền hình)", R.raw.channel, 7),
                Vocabulary(104, R.drawable.character, "character", "n", "/ˈkær.ək.tər/", "nhân vật", R.raw.character, 7),
                Vocabulary(105, R.drawable.clever, "clever", "adj", "/ˈklev.ər/", "khôn ngoan, thông minh", R.raw.clever, 7),
                Vocabulary(106, R.drawable.clip, "clip", "n", "/klɪp/", "đoạn phim ngắn", R.raw.clip, 7),
                Vocabulary(107, R.drawable.comedy, "comedy", "n", "/ˈkɒm.ə.di/", "phim hài", R.raw.comedy, 7),
                Vocabulary(108, R.drawable.compete, "compete", "v", "/kəmˈpiːt/", "thi đấu", R.raw.compete, 7),
                Vocabulary(109, R.drawable.cute, "cute", "adj", "/kjuːt/", "xinh xắn", R.raw.cute, 7),
                Vocabulary(110, R.drawable.dolphin, "dolphin", "n", "/ˈdɒl.fɪn/", "cá heo", R.raw.dolphin, 7),
                Vocabulary(111, R.drawable.educate, "educate", "v", "/ˈedʒ.u.keɪt/", "giáo dục", R.raw.educate, 7),
                Vocabulary(112, R.drawable.educational, "educational", "adj", "/ˌedʒ.ʊˈkeɪ.ʃən.əl/", "mang tính giáo dục", R.raw.educational, 7),
                Vocabulary(113, R.drawable.funny, "funny", "adj", "/ˈfʌn.i/", "buồn cười, ngộ nghĩnh", R.raw.funny, 7),
                Vocabulary(114, R.drawable.guide, "(TV) guide", "n", "/ɡaɪd/", "chương trình TV", R.raw.guide, 7),
                Vocabulary(115, R.drawable.live, "live", "adj", "/laɪv/", "(truyền) trực tiếp", R.raw.live, 7),
                Vocabulary(116, R.drawable.programme, "programme", "n", "/ˈprəʊ.ɡræm/", "chương trình (truyền hình)", R.raw.programme, 7),
                Vocabulary(117, R.drawable.talent_show, "talent show", "n", "/ˈtæl.ənt ˌʃəʊ/", "cuộc thi tài năng trên truyền hình", R.raw.talent_show, 7),
                Vocabulary(118, R.drawable.viewer, "viewer", "n", "/ˈvjuː.ər/", "người xem (TV)", R.raw.viewer, 7),
                Vocabulary(119, R.drawable.aerobics, "aerobics", "n", "/eəˈrəʊ.bɪks/", "thể dục nhịp điệu", R.raw.aerobics, 8),
                Vocabulary(120, R.drawable.career, "career", "n", "/kəˈrɪər/", "nghề nghiệp, sự nghiệp", R.raw.career, 8),
                Vocabulary(121, R.drawable.competition, "competition", "n", "/ˌkɒm.pəˈtɪʃ.ən/", "cuộc đua", R.raw.competition, 8),
                Vocabulary(122, R.drawable.congratulation, "congratulation", "n", "/kənˌɡrætʃ.əˈleɪ.ʃən/", "lời chúc mừng", R.raw.congratulation, 8),
                Vocabulary(123, R.drawable.equipment, "equipment", "n", "/ɪˈkwɪp.mənt/", "thiết bị, dụng cụ", R.raw.equipment, 8),
                Vocabulary(124, R.drawable.fantastic, "fantastic", "adj", "/fænˈtæs.tɪk/", "tuyệt", R.raw.fantastic, 8),
                Vocabulary(125, R.drawable.fit, "fit", "adj", "/fɪt/", "mạnh khoẻ", R.raw.fit, 8),
                Vocabulary(126, R.drawable.goggles, "goggles", "n", "/ˈɡɒɡ.əlz/", "kính bơi", R.raw.goggles, 8),
                Vocabulary(127, R.drawable.gym, "gym", "n", "/dʒɪm/", "trung tâm thể dục thể thao", R.raw.gym, 8),
                Vocabulary(128, R.drawable.karate, "karate", "n", "/kəˈrɑː.ti/", "môn võ ka-ra-te", R.raw.karate, 8),
                Vocabulary(129, R.drawable.last, "last", "v", "/lɑːst/", "kéo dài", R.raw.last, 8),
                Vocabulary(130, R.drawable.marathon, "marathon", "n", "/ˈmær.ə.θən/", "cuộc đua ma-ra-tông", R.raw.marathon, 8),
                Vocabulary(131, R.drawable.racket, "racket", "n", "/ˈræk.ɪt/", "cái vợt (cầu lông ...)", R.raw.racket, 8),
                Vocabulary(132, R.drawable.score, "score", "v", "/skɔːr/", "ghi bàn, ghi điểm", R.raw.score, 8),
                Vocabulary(133, R.drawable.shoot, "shoot", "v", "/ʃuːt/", "bắn, bắn súng", R.raw.shoot, 8),
                Vocabulary(134, R.drawable.sporty, "sporty", "adj", "/ˈspɔː.ti/", "khỏe mạnh, dáng thể thao", R.raw.sporty, 8),
                Vocabulary(135, R.drawable.take_place, "take place", "v", "/teɪk pleɪs/", "xảy ra, được tổ chức", R.raw.take_place, 8),
                Vocabulary(136, R.drawable.tournament, "tournament", "n", "/ˈtʊə.nə.mənt/", "giải đấu", R.raw.tournament, 8),
                Vocabulary(137, R.drawable.bank, "(river) bank", "n", "/bæŋk/", "bờ (sông)", R.raw.bank, 9),
                Vocabulary(138, R.drawable.crowded, "crowded", "adj", "/ˈkraʊ.dɪd/", "đông đúc", R.raw.crowded, 9),
                Vocabulary(139, R.drawable.floating_market, "floating market", "n", "/ˈfləʊ.tɪŋ ˈmɑː.kɪt/", "chợ nổi", R.raw.floating_market, 9),
                Vocabulary(140, R.drawable.helpful, "helpful", "adj", "/ˈhelp.fəl/", "sẵn sàng giúp đỡ", R.raw.helpful, 9),
                Vocabulary(141, R.drawable.helmet, "helmet", "n", "/ˈhel.mət/", "mũ bảo hiểm", R.raw.helmet, 9),
                Vocabulary(142, R.drawable.landmark, "landmark", "n", "/ˈlænd.mɑːk/", "địa điểm, công trình thu hút du khách", R.raw.landmark, 9),
                Vocabulary(143, R.drawable.city_map, "(city) map", "n", "/mæp/", "sơ đồ thành phố", R.raw.city_map, 9),
                Vocabulary(144, R.drawable.palace, "palace", "n", "/ˈpæl.ɪs/", "cung điện", R.raw.palace, 9),
                Vocabulary(146, R.drawable.possessive, "possessive", "pro", "/pəˈzes.ɪv/", "(đại từ) sở hữu", R.raw.possessive, 9),
                Vocabulary(147, R.drawable.postcard, "postcard", "n", "/ˈpəʊst.kɑːd/", "bưu thiếp", R.raw.postcard, 9),
                Vocabulary(148, R.drawable.rent, "rent", "v", "/rent/", "thuê", R.raw.rent, 9),
                Vocabulary(149, R.drawable.royal_palace, "Royal Palace", "n", "/ˈrɔɪ.əl ˈpæl.ɪs/", "Cung điện Hoàng gia", R.raw.royal_palace, 9),
                Vocabulary(150, R.drawable.shell, "shell", "n", "/ʃel/", "vỏ sò", R.raw.shell, 9),
                Vocabulary(151, R.drawable.stall, "stall", "n", "/stɔːl/", "gian hàng", R.raw.stall, 9),
                Vocabulary(152, R.drawable.street_food, "street food", "n", "/ˈstriːt ˌfuːd/", "đường phố", R.raw.street_food, 9),
                Vocabulary(153, R.drawable.times_square, "Times Square", "n", "/ˈtaɪmz skweər/", "Quảng trường Thời đại", R.raw.times_square, 9),
                Vocabulary(154, R.drawable.tower, "tower", "n", "/taʊər/", "tháp", R.raw.tower, 9),
                Vocabulary(155, R.drawable.vacation, "vacation", "n", "/veɪˈkeɪ.ʃən/", "kì nghỉ (hè)", R.raw.vacation, 9),
                Vocabulary(156, R.drawable.appliance, "appliance", "n", "/əˈplaɪ.əns/", "thiết bị", R.raw.appliance, 10),
                Vocabulary(157, R.drawable.cottage, "cottage", "n", "/ˈkɒt.ɪdʒ/", "nhà tranh", R.raw.cottage, 10),
                Vocabulary(158, R.drawable.dishwasher, "dishwasher", "n", "/ˈdɪʃˌwɒʃ.ər/", "máy rửa bát", R.raw.dishwasher, 10),
                Vocabulary(159, R.drawable.dry, "dry", "v", "/draɪ/", "làm khô, sấy khô", R.raw.dry, 10),
                Vocabulary(160, R.drawable.electric_cooker, "electric cooker", "n", "/iˈlek.trɪk ˈkʊk.ər/", "bếp điện", R.raw.electric_cooker, 10),
                Vocabulary(161, R.drawable.helicopter, "helicopter", "n", "/ˈhel.ɪˌkɒp.tər/", "máy bay lên thẳng", R.raw.helicopter, 10),
                Vocabulary(162, R.drawable.hi_tech, "hi-tech", "adj", "/ˈhɑɪˈtek/", "công nghệ cao", R.raw.hi_tech, 10),
                Vocabulary(163, R.drawable.housework, "housework", "n", "/ˈhaʊs.wɜːk/", "công việc nhà", R.raw.housework, 10),
                Vocabulary(164, R.drawable.location, "location", "n", "/ləʊˈkeɪ.ʃən/", "địa điểm", R.raw.location, 10),
                Vocabulary(165, R.drawable.look_after, "look after", "v", "/lʊk ˈɑːf.tər/", "trông nom, chăm sóc", R.raw.look_after, 10),
                Vocabulary(166, R.drawable.ocean, "ocean", "n", "/ˈəʊ.ʃən/", "đại dương", R.raw.ocean, 10),
                Vocabulary(167, R.drawable.outside, "outside", "adv", "/ˌaʊtˈsaɪd/", "ngoài", R.raw.outside, 10),
                Vocabulary(168, R.drawable.solar_energy, "solar energy", "n", "/ˈsəʊ.lər ˈen.ə.dʒi/", "năng lượng mặt trời", R.raw.solar_energy, 10),
                Vocabulary(169, R.drawable.space, "space", "n", "/speɪs/", "không gian vũ trụ", R.raw.space, 10),
                Vocabulary(170, R.drawable.super_img, "super", "adj", "/ˈsuː.pər/", "siêu đẳng", R.raw.super_mp3, 10),
                Vocabulary(171, R.drawable.type, "type", "n", "/taɪp/", "kiểu, loại", R.raw.type, 10),
                Vocabulary(172, R.drawable.ufo, "UFO", "n", "/ˌjuː.efˈəʊ/", "vật thể bay, đĩa bay không xác định", R.raw.ufo, 10),
                Vocabulary(173, R.drawable.washing_machine, "washing machine", "n", "/ˈwɒʃ.ɪŋ məˌʃiːn/", "máy giặt", R.raw.washing_machine, 10),
                Vocabulary(174, R.drawable.wireless, "wireless", "adj", "/ˈwaɪə.ləs/", "không dây", R.raw.wireless, 10),
                Vocabulary(175, R.drawable.be_in_need, "be in need", "v", "/biː ɪn niːd/", "cần", R.raw.be_in_need, 11),
                Vocabulary(176, R.drawable.charity, "charity", "n", "/ˈtʃær.ə.ti/", "từ thiện", R.raw.charity, 11),
                Vocabulary(177, R.drawable.container, "container", "n", "/kənˈteɪ.nər/", "đồ đựng", R.raw.container, 11),
                Vocabulary(178, R.drawable.do_a_survey, "do a survey", "v", "/du: ə ˈsɜː.veɪ/", "thực hiện khảo sát", R.raw.do_a_survey, 11),
                Vocabulary(179, R.drawable.environment, "environment", "n", "/ɪnˈvaɪ.rən.mənt/", "môi trường", R.raw.environment, 11),
                Vocabulary(180, R.drawable.exchange, "exchange", "v", "/ɪksˈtʃeɪndʒ/", "trao đổi", R.raw.exchange, 11),
                Vocabulary(181, R.drawable.fair, "fair", "n", "/feər/", "hội chợ", R.raw.fair, 11),
                Vocabulary(182, R.drawable.go_green, "go green", "n", "/ɡəʊ ɡriːn/", "sống xanh (thân thiện môi trường)", R.raw.go_green, 11),
                Vocabulary(183, R.drawable.instead_of, "instead of", "prep", "/ɪnˈsted ˌəv/", "thay cho", R.raw.instead_of, 11),
                Vocabulary(184, R.drawable.pick_up, "pick up", "v", "/pɪk ʌp/", "nhặt (rác), đón", R.raw.pick_up, 11),
                Vocabulary(185, R.drawable.president, "president", "n", "/ˈprez.ɪ.dənt/", "chủ tịch", R.raw.president, 11),
                Vocabulary(186, R.drawable.recycle, "recycle", "v", "/ˌriːˈsaɪ.kəl/", "tái chế", R.raw.recycle, 11),
                Vocabulary(187, R.drawable.recycling_bin, "recycling bin", "n", "/ˌriːˈsaɪ.klɪŋ bin/", "thùng đựng rác tái chế", R.raw.recycling_bin, 11),
                Vocabulary(188, R.drawable.reduce, "reduce", "v", "/rɪˈdʒuːs/", "giảm", R.raw.reduce, 11),
                Vocabulary(189, R.drawable.reuse, "reuse", "v", "/ˌriːˈjuːz/", "tái sử dụng", R.raw.reuse, 11),
                Vocabulary(190, R.drawable.reusable, "reusable", "adj", "/ˌriːˈjuː.zə.bəl/", "có thể dùng lại được", R.raw.reusable, 11),
                Vocabulary(191, R.drawable.rubbish, "rubbish", "n", "/ˈrʌb.ɪʃ/", "rác", R.raw.rubbish, 11),
                Vocabulary(192, R.drawable.tip, "tip", "n", "/tɪp/", "mẹo, cách", R.raw.tip, 11),
                Vocabulary(193, R.drawable.wrap, "wrap", "v", "/ræp/", "gói, bọc", R.raw.wrap, 11),
                Vocabulary(194, R.drawable.age, "age", "n", "/eɪdʒ/", "độ tuổi", R.raw.age, 12),
                Vocabulary(195, R.drawable.broken, "broken", "adj", "/ˈbrəʊ.kən/", "bị hỏng, bị vỡ", R.raw.broken, 12),
                Vocabulary(196, R.drawable.choice, "choice", "n", "/tʃɔɪs/", "sự lựa chọn", R.raw.choice, 12),
                Vocabulary(197, R.drawable.do_the_dishes, "do the dishes", "v", "/du ðə dɪʃes/", "rửa bát, đĩa", R.raw.do_the_dishes, 12),
                Vocabulary(198, R.drawable.do_the_washing, "do the washing", "v", "/du ðə ˈwɒʃ.ɪŋ/", "giặt giũ quần áo", R.raw.do_the_washing, 12),
                Vocabulary(199, R.drawable.feelings, "feelings", "n", "/ˈfiː.lɪŋz/", "cảm xúc, tình cảm", R.raw.feelings, 12),
                Vocabulary(200, R.drawable.guard, "guard", "v, n", "/ɡɑːd/", "bảo vệ, người canh gác", R.raw.guard, 12),
                Vocabulary(201, R.drawable.height, "height", "n", "/haɪt/", "chiều cao", R.raw.height, 12),
                Vocabulary(202, R.drawable.iron, "iron", "v", "/aɪrn/", "là, ủi (quần áo)", R.raw.iron, 12),
                Vocabulary(203, R.drawable.pick, "pick", "v", "/pɪk/", "hái, thu hoạch (hoa, quả,...)", R.raw.pick, 12),
                Vocabulary(204, R.drawable.planet, "planet", "n", "/ˈplæn.ɪt/", "hành tinh", R.raw.planet, 12),
                Vocabulary(205, R.drawable.price, "price", "n", "/praɪs/", "giá, số tiền mua hoặc bán", R.raw.price, 12),
                Vocabulary(206, R.drawable.put_away, "put away", "v", "/put əˈweɪ/", "cất, dọn", R.raw.put_away, 12),
                Vocabulary(207, R.drawable.repair, "repair", "v", "/rɪˈpeər/", "sửa chữa", R.raw.repair, 12),
                Vocabulary(208, R.drawable.robot, "robot", "n", "/ˈrəʊ.bɒt/", "người máy", R.raw.robot, 12),
                Vocabulary(209, R.drawable.space_station, "space station", "n", "/ˈspeɪs ˌsteɪ.ʃən/", "trạm vũ trụ", R.raw.space_station, 12),
                Vocabulary(210, R.drawable.useful, "useful", "adj", "/ˈjuːs.fəl/", "hữu ích", R.raw.useful, 12),
                Vocabulary(211, R.drawable.water, "water", "v", "/ˈwɔː.tər/", "tưới nước", R.raw.water, 12),
                Vocabulary(212, R.drawable.weight, "weight", "n", "/weɪt/", "trọng lượng", R.raw.weight, 12),
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
            database.vocabularyDao().deleteVocabularies()
        }
    }
}