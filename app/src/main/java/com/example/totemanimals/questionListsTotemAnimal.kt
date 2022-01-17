package com.example.totemanimals

object questionListsTotemAnimal {
        //лист с текстом вопросов
    val quest_totem_animal = arrayOf("Какой чувственный аспект вам ближе?",
            "В какое время дня вы чувствуете наибольшую активность?",
            "Какой чертой характера вас чаще характеризуют окружающие?",
            "Какая у вас комплекция тела?",
            "Кем вы себя ощущаете по своей природе?",
            "Какую пищу вы предпочитаете?",
            "Какой тип характера подходит вам в большей степени?",
            "Какая деятельность приносит вам ощущение отдыха?",
            "Кто вы, какую роль предпочитаете в жизни?",
            "Чего вы хотите получать от жизни?",
            "Чего вы боитесь, каковы ваши страхи?",
            "Куда вы поедете отдыхать если будет такая возможность?",
            "Какая ваша, самая мешающая вам жить, отрицательная черта характера?",)

    // лист с количеством ответов для каждого вопроса
        val answer_num = arrayOf(4,4,14,3,3,3,3,3,5,8,3,5,9,)

    //Лист начисляемых баллов для каждого ответа?
    //TODO в каждом листе, надо вложить еще один лист с ответами по количеству ответов
        val answer_right_check = arrayOf<Array<Array<Int>>>( // 13 листов (кол-во вопросов) с 15 элементами (15 кнопок)
        //1 вопрос
        arrayOf(
            /*1 вода*/arrayOf(1,	1,	0,	0,	1,	0,	0,	1,	1,	0,	0,	0,	1,	1,	0,),
            /*2 воздух*/arrayOf(1,	0,	1,	1,	0,	1,	0,	0,	0,	1,	1,	1,	0,	1,	0,),
            /*3 земля*/arrayOf(0,	1,	1,	0,	0,	0,	1,	1,	0,	0,	0,	1,	1,	0,	1,),
            /*4 огонь*/arrayOf(0,	0,	0,	1,	1,	1,	1,	0,	1,	1,	1,	0,	0,	0,	1,),
            /*5 кнопка*/arrayOf(0),/*6 кнопка*/arrayOf(0),/*7 кнопка*/arrayOf(0),/*8 кнопка*/arrayOf(0),/*9 кнопка*/arrayOf(0),/*10 кнопка*/arrayOf(0),/*11 кнопка*/arrayOf(0),/*12 кнопка*/arrayOf(0),/*13 кнопка*/arrayOf(0),/*14 кнопка*/arrayOf(0),/*15 кнопка*/arrayOf(0),
            ),

        //2 вопрос
        arrayOf(
            /*1 вечер*/arrayOf(0,	0,	1,	1,	1,	0,	0,	0,	1,	0,	0,	0,	1,	1,	1,),
            /*2 ночь*/arrayOf(0,	0,	1,	1,	0,	0,	1,	1,	0,	0,	0,	0,	0,	1,	1,),
            /*3 утро*/arrayOf(1,	1,	0,	0,	0,	1,	1,	0,	1,	1,	1,	1,	0,	0,	0,),
            /*4 день*/arrayOf(1,	1,	0,	0,	1,	1,	0,	1,	0,	1,	1,	1,	1,	0,	0,),
            /*5 кнопка*/arrayOf(0),/*6 кнопка*/arrayOf(0),/*7 кнопка*/arrayOf(0),/*8 кнопка*/arrayOf(0),/*9 кнопка*/arrayOf(0),/*10 кнопка*/arrayOf(0),/*11 кнопка*/arrayOf(0),/*12 кнопка*/arrayOf(0),/*13 кнопка*/arrayOf(0),/*14 кнопка*/arrayOf(0),/*15 кнопка*/arrayOf(0),
        ),
        //3 вопрос
        arrayOf(
            /*1 Смелость*/arrayOf(0,	0,	0,	0,	0,	0,	0,	1,	0,	1,	1,	0,	0,	0,	1 ,   ),
            /*2 Мудрость*/arrayOf(0,	0,	1,	1,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,            ),
            /*3 Доброта*/arrayOf(1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,),
            /*4 Хитрость*/arrayOf(0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	1,      ),
            /*5 Запасливость*/arrayOf(1,	1,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,            ),
            /*6 Упрямство*/arrayOf(0,	0,	0,	0,	1,	0,	0,	0,	1,	0,	0,	0,	1,	0,	0,            ),
            /*7 Коварство*/arrayOf(0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	1,            ),
            /*8 Наглость*/arrayOf(0,	1,	0,	0,	0,	0,	0,	0,	1,	0,	1,	0,	1,	0,	0,            ),
            /*9 Верность*/arrayOf(0,	0,	0,	1,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,	0,            ),
            /*10 Гордость*/arrayOf(0,	0,	0,	0,	1,	0,	0,	0,	0,	1,	1,	0,	0,	0,	0,),
            /*11 Целеустремленность*/arrayOf(0,	1,	0,	0,	0,	0,	0,	1,	1,	0,	0,	0,	0,	0,	0,            ),
            /*12 Уверенность*/arrayOf(0,	0,	0,	0,	1,	0,	0,	1,	0,	1,	0,	1,	0,	0,	0,            ),
            /*13 Осторожность*/arrayOf(0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	1,	0,            ),
            /*14 Наблюдательность*/arrayOf(1,	0,	0,	0,	0,	1,	1,	0,	0,	0,	0,	0,	0,	0,	0,            ),
            /*15 кнопка*/arrayOf(0),
        ),
        //4 вопрос
        arrayOf(
            /*1 развитая*/arrayOf(0,	0,	1,	0,	1,	0,	0,	0,	1,	1,	0,	0,	0,	0,	1,            ),
            /*2 крепкое*/arrayOf(0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	1,	1,	0,	0,            ),
            /*3 худоба*/arrayOf(1,	0,	0,	1,	0,	1,	1,	0,	0,	0,	0,	0,	0,	1,	0,            ),
            /*4 кнопка*/arrayOf(0),/*5 кнопка*/arrayOf(0),/*6 кнопка*/arrayOf(0),/*7 кнопка*/arrayOf(0),/*8 кнопка*/arrayOf(0),/*9 кнопка*/arrayOf(0),/*10 кнопка*/arrayOf(0),/*11 кнопка*/arrayOf(0),/*12 кнопка*/arrayOf(0),/*13 кнопка*/arrayOf(0),/*14 кнопка*/arrayOf(0),/*15 кнопка*/arrayOf(0),
        ),
        //5 вопрос
        arrayOf(
            /*1 деятель*/arrayOf(1,	1,	1,	0,	1,	0,	0,	1,	1,	0,	0,	1,	1,	0,	1,            ),
            /*2 интелектуал*/arrayOf(0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,            ),
            /*3 эстет*/arrayOf(0,	0,	0,	1,	0,	1,	0,	0,	0,	1,	1,	0,	0,	0,	0,            ),
            /*4 кнопка*/arrayOf(0),/*5 кнопка*/arrayOf(0),/*6 кнопка*/arrayOf(0),/*7 кнопка*/arrayOf(0),/*8 кнопка*/arrayOf(0),/*9 кнопка*/arrayOf(0),/*10 кнопка*/arrayOf(0),/*11 кнопка*/arrayOf(0),/*12 кнопка*/arrayOf(0),/*13 кнопка*/arrayOf(0),/*14 кнопка*/arrayOf(0),/*15 кнопка*/arrayOf(0),
        ),
        //6 вопрос
        arrayOf(
            /*1 Острая*/arrayOf(0,	1,	1,	0,	1,	0,	1,	0,	1,	0,	0,	1,	0,	0,	1,            ),
            /*2 Сухая*/arrayOf(0,	0,	0,	1,	0,	1,	0,	0,	0,	1,	0,	0,	0,	1,	0,            ),
            /*3 мясо*/arrayOf(1,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	1,	0,	0,            ),
            /*4 кнопка*/arrayOf(0),/*5 кнопка*/arrayOf(0),/*6 кнопка*/arrayOf(0),/*7 кнопка*/arrayOf(0),/*8 кнопка*/arrayOf(0),/*9 кнопка*/arrayOf(0),/*10 кнопка*/arrayOf(0),/*11 кнопка*/arrayOf(0),/*12 кнопка*/arrayOf(0),/*13 кнопка*/arrayOf(0),/*14 кнопка*/arrayOf(0),/*15 кнопка*/arrayOf(0),
        ),
        //7 вопрос
        arrayOf(
            /*1 замкнутый*/arrayOf(0,	0,	0,	1,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,            ),
            /*2 обычный*/arrayOf(1,	1,	1,	0,	1,	0,	1,	1,	1,	1,	0,	1,	1,	0,	0,            ),
            /*3 эгоцентричный*/arrayOf(0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,            ),
            /*4 кнопка*/arrayOf(0),/*5 кнопка*/arrayOf(0),/*6 кнопка*/arrayOf(0),/*7 кнопка*/arrayOf(0),/*8 кнопка*/arrayOf(0),/*9 кнопка*/arrayOf(0),/*10 кнопка*/arrayOf(0),/*11 кнопка*/arrayOf(0),/*12 кнопка*/arrayOf(0),/*13 кнопка*/arrayOf(0),/*14 кнопка*/arrayOf(0),/*15 кнопка*/arrayOf(0),
        ),
        //8 вопрос
        arrayOf(/*1 путеш*/arrayOf(0,	0,	0,	0,	1,	1,	0,	0,	1,	0,	1,	1,	0,	0,	1,        ),
            /*2 смена*/arrayOf(0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,            ),
            /*3 дома*/arrayOf(1,	1,	1,	1,	0,	0,	0,	1,	0,	1,	0,	0,	1,	0,	0,            ),
            /*4 кнопка*/arrayOf(0),/*5 кнопка*/arrayOf(0),/*6 кнопка*/arrayOf(0),/*7 кнопка*/arrayOf(0),/*8 кнопка*/arrayOf(0),/*9 кнопка*/arrayOf(0),/*10 кнопка*/arrayOf(0),/*11 кнопка*/arrayOf(0),/*12 кнопка*/arrayOf(0),/*13 кнопка*/arrayOf(0),/*14 кнопка*/arrayOf(0),/*15 кнопка*/arrayOf(0),
        ),
        //9 вопрос "Охотник","Работяга","Бродяга","Лидер","Мыслитель"
        arrayOf(
            /*1 оХОТНИК*/arrayOf(0,	0,	0,	0,	0,	0,	1,	1,	0,	0,	0,	0,	0,	0,	1,            ),
            /*2 работяга*/arrayOf(1,	1,	1,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,            ),
            /*3 бродяга*/arrayOf(0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	1,	0,            ),
            /*4 лидер*/arrayOf(0,	0,	0,	0, 0,	0,	0,	0	,0,	1,	1,	0,	0,	0,	0,            ),
            /*5 мыслитель*/arrayOf(0,	0,	0,	1,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,            ),
            /*6 кнопка*/arrayOf(0),/*7 кнопка*/arrayOf(0), /*8 кнопка*/arrayOf(0),/*9 кнопка*/arrayOf(0),/*10 кнопка*/arrayOf(0),/*11 кнопка*/arrayOf(0),/*12 кнопка*/arrayOf(0),/*13 кнопка*/arrayOf(0),/*14 кнопка*/arrayOf(0),/*15 кнопка*/arrayOf(0),
        ),
        //10 вопрос "Развлечений","Семью","Денег","Знаний","Здоровья","Известности","Свободы","Власти"
        arrayOf(
            /*1 развлеч*/arrayOf(0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,            ),
            /*2 семья*/arrayOf(1,	1	,1,	0	,0	,1,	0,	0,	0,	0,	0,	0,	1,	0,	0,            ),
            /*3 деньги*/arrayOf(0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,            ),
            /*4 знания*/arrayOf(0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,            ),
            /*5 здоровье*/arrayOf(0,	0,	0,	0,	1,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,            ),
            /*6 Изветсноть*/arrayOf(0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	1,	0,	0,	0,	0,            ),
            /*7 свобода*/arrayOf(0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	,0	,0	,1,            ),
            /*8 власть*/arrayOf(0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,            ),
            /*9 кнопка*/arrayOf(0),/*10 кнопка*/arrayOf(0),/*11 кнопка*/arrayOf(0),/*12 кнопка*/arrayOf(0),/*13 кнопка*/arrayOf(0),/*14 кнопка*/arrayOf(0),/*15 кнопка*/arrayOf(0),
        ),
        //11 вопрос
        arrayOf(
            /*1 одиноч*/arrayOf(0,	0,	0,	0,	1,	1,	0,	0,	0,	0,	1,	1,	1,	0,	0,            ),
            /*2 предательства*/arrayOf(0,	0,	0,	1,	0,	0,	1,	0,	1,	1,	0,	0,	0,	0,	1,            ),
            /*3 изменений*/arrayOf(1,	1,	1,	0,	0,	0,	0,	1	,0	,0,	0,	0,	0,	1,	0,            ),
            /*4 кнопка*/arrayOf(0),/*5 кнопка*/arrayOf(0),/*6 кнопка*/arrayOf(0),/*7 кнопка*/arrayOf(0),/*8 кнопка*/arrayOf(0),/*9 кнопка*/arrayOf(0),/*10 кнопка*/arrayOf(0),/*11 кнопка*/arrayOf(0),/*12 кнопка*/arrayOf(0),/*13 кнопка*/arrayOf(0),/*14 кнопка*/arrayOf(0),/*15 кнопка*/arrayOf(0),
        ),
        //12 вопрос В лес, с палаткой, охота, рыбалка, по грибы",
        //            "В деревню","Город, останусь в городе или поеду в другой город","В необычные места, например в горы","На море"
        arrayOf(
            /*1 лес*/arrayOf(0,	0,	1,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,            ),
            /*2 деревня*/arrayOf(1,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,            ),
            /*3 город*/arrayOf(0,	0,	0,	0,	1,	0,	0,	0,	0,	1,	1,	0,	0,	0,	0,            ),
            /*4 необычные горы*/arrayOf(0,	0,	0,	0,	0,	0,	1,	0,	1,	0,	0,	1,	0,	0,	0,            ),
            /*5 море*/arrayOf(0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	1,            ),
            /*6 кнопка*/arrayOf(0),/*7 кнопка*/arrayOf(0),/*8 кнопка*/arrayOf(0),/*9 кнопка*/arrayOf(0),/*10 кнопка*/arrayOf(0),/*11 кнопка*/arrayOf(0),/*12 кнопка*/arrayOf(0),/*13 кнопка*/arrayOf(0),/*14 кнопка*/arrayOf(0),/*15 кнопка*/arrayOf(0),
        ),
        //13 вопрос
        arrayOf(
            /*1 агресс*/arrayOf(0,	0,	0,	0,	0,	0,	0,	1,	0,	1,	1,	0,	0,	0,	1,            ),
            /*2 щедрость*/arrayOf(0,	1,	0,	0,	1,	0,	0,	1,	1,	1,	0,	1,	0,	0,	0,            ),
            /*3 обидчвивость*/arrayOf(0,	0,	0,	1,	1,	1,	1,	0,	0,	0,	1,	0,	1,	1,	0,            ),
            /*4 зависть*/arrayOf(0,	1,	1,	0,	0,	1,	1,	0,	0,	1,	1,	0,	0,	1,	0,            ),
            /*5 недоверчивость*/arrayOf(0,	1,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,	1,            ),
            /*6 лень*/arrayOf(0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,            ),
            /*7 жадность*/arrayOf(1,	0,	1,	0,	0,	0,	0	,1,	1,	0,	0,	0,	1,	0,	0,            ),
            /*8 доверчивость*/arrayOf(1,	0,	0,	1,	1,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,            ),
            /*9 лживость*/arrayOf(1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,            ),
            /*10 кнопка*/arrayOf(0),/*11 кнопка*/arrayOf(0),/*12 кнопка*/arrayOf(0),/*13 кнопка*/arrayOf(0),/*14 кнопка*/arrayOf(0),/*15 кнопка*/arrayOf(0),
        ),
            )

    val button_name_list = arrayOf<Array<String>>( // 13 листов по 15 (кол_во кнопок- вариантов ответа)
        arrayOf("Вода - Вкус","Воздух - Осязание","Земля - Запах","Огонь - Зрение","","","","","","","","","","","",),
        arrayOf("Вечер","Ночь","Утро","День","","","","","","","","","","","",),
        arrayOf("Смелость","Мудрость","Доброта",
            "Хитрость","Запасливость","Упрямство","Коварство","Наглость",
            "Верность","Гордость","Целеустремленность","Уверенность","Осторожность","Наблюдательность","",),
        arrayOf("Развитая мышечная масса, атлетическое телосложение",
            "Крепкое тело, есть склонность к полноте",
            "Худоба, утонченная фигура, мало жировой массы","","","","","","","","","","","","",),
        arrayOf("Деятель","Интелектуал","Эстет","","","","","","","","","","","","",),
        arrayOf("Острая, пряная пиша, цитрусовые, ферментированные продукты",
            "Сухая пища, сухофрукты, овощи, фрукты, обезжиренная молочная продукция, орехи",
            "Мясо, зерновые продукты, каши, выпечка, молочные продукты","","","","","","","","","","","","",),
        arrayOf("Замкнутый","Обычный, сбалансированный между замкнутостью и эгоизмом","Эгоцентричный(Ставите превыше всего себя)","","","","","","","","","","","","",),
        arrayOf("Путешествовать, посещать новые места",
            "Предпочитаю смену деятельности, помогает переключиться на что-то новое, отдохнуть от старого",
            "Сидеть дома, заниматься домашними делами","","","","","","","","","","","","",),
        arrayOf("Охотник","Работяга","Бродяга","Лидер","Мыслитель","","","","","","","","","","",),
        arrayOf("Развлечений","Семью","Денег","Знаний","Здоровья","Известности","Свободы","Власти","","","","","","","",),
        arrayOf("Одиночества","Предательства","Изменений","","","","","","","","","","","","",),
        arrayOf("В лес, с палаткой, охота, рыбалка, по грибы",
            "В деревню","Город, останусь в городе или поеду в другой город","В необычные места, например в горы","На море","","","","","","","","","","",),
        arrayOf("Агрессивность","Щедрость","Обидчивость","Зависть","Недоверчивость","Лень","Жадность","Доверчивость","Лживость","","","","","","",),


    )
}