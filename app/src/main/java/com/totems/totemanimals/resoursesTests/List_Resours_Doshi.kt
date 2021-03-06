package com.totems.totemanimals.resoursesTests

import com.totems.totemanimals.R

object List_Resours_Doshi : ListResourseClass() {


    val BALANCE_LEVEL_MIN = 11.66f
    val BALANCE_LEVEL_MAX = 15.66f
    const val VATA_KEY = "VATA"
    const val PITTA_KEY = "PITTA"
    const val KAPHA_KEY = "KAPHA"


    //todo картинки 2х дош
    override val imIdList: Array<Int> = arrayOf(
        R.drawable.im_vata,
        R.drawable.im_pitta,
        R.drawable.im_kapha,
        R.drawable.im_pitta_vata,
        R.drawable.im_vata_kapha,
        R.drawable.im_pitta_kapha,
        R.drawable.im_sama_doshas
    )

    override val nameIdList: Array<String> = arrayOf("\nДисбаланс Вата-Доши\n", "\nДисбаланс Питта-Доши\n", "\nДисбаланс Капха-Доши\n","Баланс всех дош")

    override val descriptIdList: Array<String> = arrayOf(
        "\n\t\t\t\t\t\t Дисбаланс Вата-Доши. \n" +
                "\n\t Усиление Ваты в организме может быть вызвано ветреной и холодной погодой, чрезмерно интенсивной активностью и работой, переутомлением, «распылением» на множество дел сразу, бурными эмоциями, беспокойствами, страхами, недосыпанием, беспорядочным образом жизни, неправильным питанием, голоданием.\n\n" +
                "\n\tВату выводит из равновесия недостаточное употребление жидкости, пища с преобладанием острого, горького и вяжущего вкусов, чрезмерное употребление сладкого из рафинированного белого сахара, изделия из белой муки, очень холодная пища и напитки. Сыроедение не для Вата-конституции!\n\n" +
                "\n\t При дисбалансе Ваты у человека сохнет, грубеет и трескается кожа, холодеют руки и ноги, снижается потоотделение, уменьшается вес. Перевозбуждение Ваты приводит к бессоннице, тревожности, беспокойству в уме, беспорядочности мыслей, легкомысленности, ощущению разбитости и усталости.\n\n" +
                "\n\tТипичные болезни, вызываемые увеличением Вата-доши: бессонница, артрит, радикулит, судороги, метеоризм, запор, болезни почек, истощение, менструальные нарушения, мигрень, невралгия, астения, тромбофлебит, ревматизм, импотенция, астма, кашель с мокротой и другие.\n\n" +
                "\n\tСредства для стабилизации Вата-Доши: тепло, покой, усиленное питание, продукты и лекарственные средства с преобладанием сладкого, солёного и кислого вкусов.\n\n" +
                "\n\t Практические советы для баланса Вата-доши \n\n" +
                "\t\t\t•\t\t\tВременем года Ваты является осень, поэтому в этот период старайтесь особенно соблюдать рекомендации, уравновешивающие Вата-конституцию. Тепло одевайтесь в холодную, а особенно ветреную погоду, необходимо держать ноги в тепле, а руки в перчатках, чтобы не допустить сухости кожи рук. \n\n" +
                "\t\t\t•\t\t\tСледите за тем, чтобы не мёрзнуть во время сна. Хорошо согреться помогает пуховая шаль. \n\n" +
                "\t\t\t•\t\t\tДля Ваты подходит спокойная, рутинная работа, которая будет её успокаивать - вязание, шитьё, рисование и т.д. Поскольку Ваты личности творческие, то и заниматься им нужно творческой деятельностью, что-то создавать, реализовывать. Когда делаете что-либо, старайтесь концентрироваться на нём, чувствуйте, что это единственное что сейчас важно и не думайте о других делах. \n\n" +
                "\t\t\t•\t\t\tБлагоприятные виды спорта: бег, йога, цигун, плавание, теннис, ведосипед. \n\n" +
                "\t\t\t•\t\t\tВата любит тишину, спокойствие и уединение. Полезно ежедневно заниматься духовными практиками и пранаямой. Практики помогут снять напряжение, расслабиться. Практикуйте медитацию, которая успокаивает ум и чувства. \n\n" +
                "\t\t\t•\t\t\tРазвивайте в себе терпимость, не занимайтесь самокритикой и осуждением окружающих. Тогда вы сможете примирить в себе духовное с материальным и обрести гармонию. \n\n" +
                "\t\t\t•\t\t\tКак только у вас начинает сохнуть кожа лица и рук, трескаются губы, ломит кости и вы чувствуете, что часто мёрзнете, проделайте массаж всего тела с тёплым маслом гхи вечером после душа. Массажируйте тело маслом гхи каждый день, пока ваше самочувствие не улучшится. Настоятельно рекомендуем смазывать тёплым маслом гхи шею, а также уши, нос, пупок. Можно сделать следующую процедуру - разогреть масло в медном тазике и опустить в него ноги. Считается, что топленое масло гхи прогревает тело и наполняет его солнечной энергией и, таким образом, многие болезни уходят. \n\n" +
                "\t\t\t•\t\t\tВате также полезен ежедневный массаж с применением тёплого кунжутного масла, особенно осенью, зимой и холодной весной. В особенности нужно хорошо промасливать лицо, шею, уши, нос, живот, спину, суставы, стопы и руки. Перед душем положите в стакан с горячей водой бутылочку с кунжутным маслом. Пока вы будете принимать душ, масло успеет хорошо нагреться. Кунжутное масло выводит воздух из суставов и костей. \n\n" +
                "\t\t\t•\t\t\tКаждый день полезно втирать небольшое количество масла на кожу головы. При сухости носовых ходов и пазух носа смазывайте внутреннюю поверхность крыльев носа небольшим количеством тёплого топленого масла гхи или кунжутного масла. При запоре Аюрведа предписывает для Ваты клизменную терапию с использованием трав и кунжутного масла, как самое эффективное средство. \n\n" +
                "\t\t\t•\t\t\tВаты просыпаются очень рано, на рассвете. Старайтесь пораньше ложиться спать, чтобы к утру успеть восстановить и накопить силы. \n\n"
        ,
        "\n\t\t\t\t\t\t Дисбаланс Питта-Доши. \n" +
                "\n\t Увеличению Питты в организме способствует жаркая влажная погода, пища с преобладанием острого, солёного и кислого вкусов, стимулирующие напитки (кофе, чай, алкоголь). Эмоции, приводящие к заболеваниям: раздражительность, ненависть, ревность, подавленный гнев. \n\n" +
                "\n\t При дисбалансе Питты у человека жирнеет кожа, повышается температура тела, усиливается потоотделение и уменьшается вес. \n\n" +
                "\n\t Типичные физические проблемы, вызываемые увеличением Питта-Доши: нарушения пищеварения, изжога и постоянное чувство жжения, тошнота и рвота, гастриты и язвы, болезни крови, геморрой, колит, болезни желчного пузыря и печени, увеличение щитовидной железы, кожные заболевания (прыщи, угри, крапивница, фурункулез, сыпь и др.), выпадение волос, аллергия, близорукость, конъюнктивит, лихорадка, головные боли, гипертония, стоматит, жажда, потливость и неприятный запах. \n\n" +
                "\n\t В психологическом плане вышедшая из под контроля Питте свойственны агрессивность, резкость в высказываниях, самокритичность, циничность, беспокойство, обиды, замыкание в себе. Питту выводит из себя каждое не к месту сказанное слово и даже неуместный взгляд. \n\n" +
                "\n\t Средства стабилизации Питта-Доши: прохлада, покой, умеренность во всём, регулярное питание, отказ от стимуляторов, продукты и лекарственные средства с преобладанием сладкого, горького и вяжущего вкусов. \n\n" +
                "\n\t Практические советы для баланса Питта-доши\n\n" +
                "\t\t\t•\t\t\t Временем года Питты является лето, поэтому в этот период старайтесь особенно соблюдать рекомендации, уравновешивающие Питта-конституцию. Избегайте палящего солнца, побольше купайтесь, проводите это время спокойно, снижайте уровень активности. \n\n" +
                "\t\t\t•\t\t\t Для Питты полезно от применение кокосового масла, которое охлаждает кожу, особенно когда его применяют на голове при перегреве. \n\n" +
                "\t\t\t•\t\t\t Постарайтесь контролировать свои эмоции, избавляйтесь от агрессии и раздражения, старайтесь внимательно и спокойно слушать других людей. \n\n" +
                "\t\t\t•\t\t\t Полезна духовная практика и медитация. \n\n" +
                "\t\t\t•\t\t\t Благоприятные виды спорта: бег, плавание, теннис, альпинизм, лыжный спорт, акробатика. \n\n" +
                "\t\t\t•\t\t\t Полезно регулярно заниматься йогой. Особое внимание следует уделять асанам, массирующим желудочно-кишечный тракт (наклоны и скрутки). \n\n"
        ,
        "\n\t\t\t\t\t\t Дисбаланс Капха-Доши.\n" +
                "\n\t Увеличению Капхи в организме способствует холодная, сырая погода, сон в дневное время, пища, в которой преобладают сладкий, солёный и кислый вкусы, а также тяжёлая, жирная и очень холодная пища. Эмоции, приводящие к дисбалансу: зависть, гордыня, отсутствие новизны в жизни, чрезмерные волнения о собственном нездоровом образе жизни. \n\n" +
                "\n\t При разбалансировке Капхи жирнеет кожа, холодеют и тяжелеют руки и ноги, усиливается отделение слизи и мочеиспускание, повышается вес, возрастает апатия и сонливость. \n\n" +
                "\n\t Чаще всего дисбаланс Капха-Доши отражается на слизистых оболочках. Это насморки, простуда, воспаление лимфатических узлов. \n\n" +
                "\n\t Типичные болезни, вызываемые увеличением Капха-Доши: диабет, запор, ожирение, отёчность, опухоли, повышенное давление, сердечно-сосудистые заболевания, диабет, одышка, гайморит, бронхит, грипп, ангина, астма, фарингит, аллергия, проблемы пищеварения, кожные болезни, боли в суставах. \n\n" +
                "\n\t Психологические признаки разбалансировки – упрямство, лень, жадность, привязанность, чувство собственничества, зависть и праздность, порождающая медлительность ума. Капха может быть депрессивной, меланхоличной и подозрительной. Она вдруг начинает ощущать свою ненужность и глубокое разочарование в людях. \n\n" +
                "\n\t Средства для стабилизации Капха-Доши: тепло, физическая активность, умеренное питание, продукты и лекарственные средства с преобладанием острого, горького и вяжущего вкусов. \n\n" +
                
                "\n\t Практические советы для баланса Капха-доши \n\n" +
                "\t\t\t•\t\t\t Временем года Капхи является конец зимы и ранняя весна, поэтому в эти периоды старайтесь особенно соблюдать рекомендации, уравновешивающие Капха-конституцию. \n\n" +
                "\t\t\t•\t\t\t Капхе лучше всего подходит такое стимулирующее масло, как горчичное. Также типу Капха полезно применять кунжутное масло, у которого сухая кожа из за плохого кровообращения. \n\n" +
                
                "\t\t\t•\t\t\t Строго соблюдайте диету. Не спите днём, особенно после еды. Лучше после еды прогуляться и подышать свежим воздухом. \n\n" +
                "\t\t\t•\t\t\t Ведите активный образ жизни и занимайтесь спортом. Наиболее подходящие виды физической активности: силовые нагрузки на тренажёрах, аэробика, танцы, гребля, водное поло, дзюдо и самбо. \n\n" +
                "\t\t\t•\t\t\t Не засиживайтесь допоздна и пораньше вставайте. Старайтесь находить для себя новые хобби и интересы, избегайте однообразия и апатии. \n\n" +
                "\t\t\t•\t\t\t Не накапливайте ненужные вещи, избавляйтесь от старого. Старые вещи - это старое сознание. Освобождайте место в своей жизни для чего-то нового. \n\n" +
                "\t\t\t•\t\t\t Занимайтесь духовными практиками, пранаямой и медитацией. \n\n"
    ,

    )
        // 0-low 1-high 2-bal vata || 3-low 4-high 5-bal pitta|| 6-low 7-high 9-bal kapha
    override val addDescriptionList: Array<String> = arrayOf(
            "\nНедостаток ваты вызывает следующее:\n" +
                    "\t- Летаргия\t \n" +
                    "\t- Тошнота\n" +
                    "\t- Депрессия\t \n" +
                    "\t- Ненормальность желудочной деятельности\n"
        ,
            "\nИзбыток ваты вызывает следующее:\n" +
                    "\t- Нервозность \n" +
                    "\t- Угрюмость\n" +
                    "\t- Беспокойство \n" +
                    "\t- Потеря сознания\n" +
                    "\t- Страх \n" +
                    "\t- Ухудшение сенсорных функций\n" +
                    "\t- Замешательство \n" +
                    "\t- Дрожание конечностей\n" +
                    "\t- Огорчение\t \n" +
                    "\t- Запор\n" +
                    "\t- Печаль\t\n" +
                    "\t- Бессоница\n" +
                    "\t- Чувство незащищённости\t \n" +
                    "\t- Сухая и грубая кожа\n" +
                    "\t- Недостаток целостности и честности\t \n" +
                    "\t- Низкая живость\n"
            ,
            "\nВата-доша сбалансированна \n"
            ,
            "\nНедостаток питты вызывает следующее:\n" +
                    "\t- Расстройство желудка \n" +
                    "\t- Потеря блеска кожи\n" +
                    "\t- Ненормальная потеря телесного тепла\n" +
                    "\t- Нерегулярная моторика  желудочно-кишечного тракта         \n"
            ,
            "\nИзбыток питты вызывает следующее:\n" +
                    "\t- Амбициозность\t \n" +
                    "\t- Ненависть\n" +
                    "\t- Гнев\t \n" +
                    "\t- Ревность\n" +
                    "\t- Зависть\t \n" +
                    "\t- Осуждающие или  критические тенденции\n" +
                    "\t- Страх неудачи\n" +
                    "\t- Недостаток проницательности\n" +
                    "\t- Незамедлительные речь и действия\t\n" +
                    "\t- Гордость\n" +
                    "\t- Скептицизм\t\n" +
                    "\t- Ощущение жжения\n" +
                    "\t- Чрезмерная жажда\t\n" +
                    "\t- Жажда прохлады\n" +
                    "\t- Потеря сна\t \n" +
                    "\t- Лихорадка\n" +
                    "\t- Фрустрация\n"
            ,
            "\nПитта-доша сбалансированна \n"
            ,
            "\nНедостаток капхи вызывает следующее:\n" +
                    "\t- Жажда\t\n" +
                    "\t- Судороги\n" +
                    "\t- Головокружение\t\n" +
                    "\t- Боли в теле\n" +
                    "\t- Сухость во рту\t\n"
            ,
            "\nИзбыток капхи вызывает следующее:\n" +
                    "\t- Скука\t\n" +
                    "\t- Недостаток интереса\n" +
                    "\t- Небрежность\t\n" +
                    "\t- Повышенное выделение секреций во рту\n" +
                    "\t- Недостаток сострадания\t\n" +
                    "\t- Летаргия\n" +
                    "\t- Жадность\t \n" +
                    "\t- Чрезмерный сон\n" +
                    "\t- Чувство недостатка поддержки или любви\t\n" +
                    "\t- Ненормальное переваривание пищи\n" +
                    "\t- Одержимое поведение\t\n" +
                    "\t- Тучность\n" +
                    "\t- Злость\t\n" +
                    "\t- Тошнота\n"
            ,
            "\nКапха-доша - сбалансированна\n"
            ,

        )


}