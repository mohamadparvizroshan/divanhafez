package com.example.data

import com.example.model.Ghazal
import com.example.model.Interpretation
import com.example.model.Verse

object HafezPoemsData {
  val poems: List<Ghazal> = listOf(
    Ghazal(
      id = 1,
      number = 1,
      titleFa = "الا یا ایها الساقی",
      titleEn = "O Cupbearer, Bring the Wine",
      themeFa = "عشق، معرفت، سلوک",
      themeEn = "Love, Mystic Path, Awakening",
      verses = listOf(
        Verse(
          firstHalfFa = "الا یا ایها الساقی ادر کأسا و ناولها",
          secondHalfFa = "که عشق آسان نمود اول ولی افتاد مشکل‌ها",
          translationEn = "O Cupbearer, pass round the bowl and offer it,\nFor love seemed easy at first, but difficulties arose.",
          transliteration = "Alā yā ayyuha-s-sāqī adir ka’san wa nāwilhā\nKe ‘ishq āsān nemūd avval valī oftād moshkel-hā"
        ),
        Verse(
          firstHalfFa = "به بوی نافه‌ای کاخر صبا زان طره بگشاید",
          secondHalfFa = "ز تاب جعد مشکینش چه خون افتاد در دل‌ها",
          translationEn = "For the scent of musk which the dawn breeze unfurls from those tresses,\nWhat heart-blood was shed by the twists of those fragrant locks!",
          transliteration = "Be bū-ye nāfeh-ī k-ākher sabā z-ān torra bogshāyad\nZe tāb-e ja’d-e moshkīnash che khūn oftād dar del-hā"
        ),
        Verse(
          firstHalfFa = "به می سجاده رنگین کن گرت پیر مغان گوید",
          secondHalfFa = "که سالک بی‌خبر نبود ز راه و رسم منزل‌ها",
          translationEn = "Stain your prayer carpet with wine if the Spiritual Guide bids you,\nFor the traveler is never unaware of the stages and wayfares.",
          transliteration = "Be mey sajjādeh rangīn kon gar-at Pīr-e Moghān gūyad\nKe sālek bī-khabar nabvad ze rāh o rasm-e manzel-hā"
        ),
        Verse(
          firstHalfFa = "شب تاریک و بیم موج و گردابی چنین هایل",
          secondHalfFa = "کجا دانند حال ما سبکباران ساحل‌ها",
          translationEn = "Dark night, fear of ocean waves, and such a terrifying whirlpool;\nHow can the carefree on the shores ever comprehend our state?",
          transliteration = "Shab-e tārīk o bīm-e mowj o gerdābī chenīn hāyel\nKojā dānand hāl-e mā sabok-bārān-e sāhel-hā"
        ),
        Verse(
          firstHalfFa = "حضوری گر همی‌خواهی از او غایب مشو حافظ",
          secondHalfFa = "متی ما تلق من تهوی دع الدنیا و اهملها",
          translationEn = "If you desire union and presence, never drift from Him, Hafez;\nWhen you meet the Beloved, forsake the trivial world and cast it aside.",
          transliteration = "Hozūrī gar hamī-khwāhī az ū ghāyeb mashow Hāfez\nMatā mā talqa man tahwā da’i-d-dunyā wa ahmilhā"
        )
      ),
      interpretation = Interpretation(
        verdictFa = "بسیار مبارک و همراه با گشایش، اما نیازمند صبر در دشواری‌ها",
        verdictEn = "Highly auspicious with divine opening, yet demanding steadfast patience through initial hurdles",
        messageFa = "نیتی که در دل دارید کاری بزرگ، ارزشمند و سرنوشت‌ساز است. در ابتدای این مسیر ممکن است همه‌چیز ساده به نظر آید، اما با فراز و نشیب‌هایی روبرو خواهید شد. دلسرد نشوید؛ دریای توفانی سختی دارد، اما ساحل رستگاری و وصال در انتظار شماست. از انسان‌های باحکمت و باتجربه مشورت بگیرید.",
        messageEn = "The venture in your heart is noble and transcendent. Though difficulties may emerge early on, trust the process. You are sailing deep waters—do not let surface doubts deter you. Seek guidance from those wiser than yourself, stay true to your purpose, and spiritual triumph is assured.",
        adviceFa = "تمرکز خود را حفظ کنید و به سخنان بیهوده افراد ناآگاه توجه نکنید. راز خود را به هر کس نگویید و به خدا توکل کنید.",
        adviceEn = "Stay centered, ignore the noise of skeptics, keep your sacred intentions close to your chest, and persist."
      )
    ),
    Ghazal(
      id = 3,
      number = 3,
      titleFa = "اگر آن ترک شیرازی",
      titleEn = "If that Shirazian Beauty",
      themeFa = "زیبایی، سخاوت، رهایی از قید",
      themeEn = "Beauty, Generosity, Transcendence",
      verses = listOf(
        Verse(
          firstHalfFa = "اگر آن ترک شیرازی به دست آرد دل ما را",
          secondHalfFa = "به خال هندویش بخشم سمرقند و بخارا را",
          translationEn = "If that Shirazian beauty would take my heart in hand,\nFor their dark mole I would gladly bestow Samarkand and Bukhara.",
          transliteration = "Agar ān Tork-e Shīrāzī be dast ārad del-e mā rā\nBe khāl-e hendūyash bakhsham Samarqand o Bokhārā rā"
        ),
        Verse(
          firstHalfFa = "بده ساقی می باقی که در جنت نخواهی یافت",
          secondHalfFa = "کنار آب رکن‌آباد و گلگشت مصلی را",
          translationEn = "Pour, Cupbearer, whatever wine remains! In Paradise itself you will not find\nThe gentle banks of Roknabad or the rose walks of Musalla.",
          transliteration = "Bedeh sāqī mey-e bāqī ke dar jannat nakhwāhī yāft\nKenār-e āb-e Roknābād o golgasht-e Mosallā rā"
        ),
        Verse(
          firstHalfFa = "نصیحت گوش کن جانا که از جان دوست‌تر دارند",
          secondHalfFa = "جوانان سعادتمند پند پیر دانا را",
          translationEn = "Listen to wise counsel, sweet soul, for dearer than life itself\nWise and fortunate youths hold the advice of the aged sage.",
          transliteration = "Nasīhat gūsh kon jānā ke az jān dūst-tar dārand\nJavānān-e sa’ādatmand pand-e pīr-e dānā rā"
        ),
        Verse(
          firstHalfFa = "غزل گفتی و در سفتی بیا و خوش بخوان حافظ",
          secondHalfFa = "که بر نظم تو افشاند فلک عقد ثریا را",
          translationEn = "You have sung an ode and pierced pearls of wisdom! Come, sing sweetly Hafez,\nSo that upon your verse the heavens may shower the necklace of the Pleiades.",
          transliteration = "Ghazal goftī o dor softī biyā o khowsh bekhwān Hāfez\nKe bar nazm-e tow afshānad falak ‘eqd-e Sorayyā rā"
        )
      ),
      interpretation = Interpretation(
        verdictFa = "فالی نیکو و سرشار از بخت و خوش‌اقبالی و گشایش مالی و عاطفی",
        verdictEn = "Splendid fortune, generous openings in love, relationships and worldly affairs",
        messageFa = "مقصود شما حاصل خواهد شد و بخت و اقبال به شما لبخند می‌زند. دل به زیبایی‌ها و شادی‌های زندگی بسپارید و از تنگ‌نظری دوری گزینید. گشایشی غیرمنتظره در روابط عاطفی یا کاری شما پدید خواهد آمد.",
        messageEn = "Your wish is aligned with generosity and beauty. Let go of scarcity thinking and cultivate an open, lavish heart. Joyful reconciliations or unexpected blessings will grace your endeavors.",
        adviceFa = "اندرز بزرگان و خیرخواهان را پذیرا باشید و از خودپسندی بپرهیزید تا کامیابی شما پایدار بماند.",
        adviceEn = "Value genuine mentorship, listen humbly to experienced elders, and share your good fortune freely."
      )
    ),
    Ghazal(
      id = 184,
      number = 184,
      titleFa = "دوش دیدم که ملایک در میخانه زدند",
      titleEn = "Last Night Angels Knocked on Tavern Doors",
      themeFa = "خلقت انسان، امانت الهی، عشق ازلی",
      themeEn = "Creation, The Divine Trust, Cosmic Love",
      verses = listOf(
        Verse(
          firstHalfFa = "دوش دیدم که ملایک در میخانه زدند",
          secondHalfFa = "گل آدم بسرشتند و به پیمانه زدند",
          translationEn = "Last night I saw angels knocking on the tavern doors;\nThey kneaded Adam’s clay and shaped it with the cup of love.",
          transliteration = "Dūsh dīdam ke malāyek dar-e meykhehneh zadand\nGel-e Ādam besereshtand o be peymāneh zadand"
        ),
        Verse(
          firstHalfFa = "ساکنان حرم ستر و عفاف ملکوت",
          secondHalfFa = "با من راه‌نشین باده مستانه زدند",
          translationEn = "The celestial inhabitants of Heaven’s veiled sanctuary\nShared sweet intoxicating cups of wine with a wanderer like me.",
          transliteration = "Sākenān-e haram-e setr o ‘efāf-e malakūt\nBā man-e rāh-neshīn bādeh-ye mastāneh zadand"
        ),
        Verse(
          firstHalfFa = "آسمان بار امانت نتوانست کشید",
          secondHalfFa = "قرعه کار به نام من دیوانه زدند",
          translationEn = "The heavens could not bear the weight of the Divine Trust;\nThe sacred lot was drawn and cast upon me, the wild and passionate fool.",
          transliteration = "Āsemān bār-e amānat natavānest kashīd\nQor’eh-ye kār be nām-e man-e dīvāneh zadand"
        ),
        Verse(
          firstHalfFa = "جنگ هفتاد و دو ملت همه را عذر بنه",
          secondHalfFa = "چون ندیدند حقیقت ره افسانه زدند",
          translationEn = "Forgive the endless conflicts among seventy-two nations;\nNot beholding the true Reality, they strayed into tales and fables.",
          transliteration = "Jang-e haftād o dow mellat hameh rā ‘ozr beneh\nChūn nadīdand haqīqat rah-e afsāneh zadand"
        ),
        Verse(
          firstHalfFa = "شکر ایزد که میان من و او صلح افتاد",
          secondHalfFa = "صوفیان رقص‌کنان ساغر شکرانه زدند",
          translationEn = "Praise God, peace has now blossomed between my Soul and the Beloved;\nThe Sufis dance in ecstasy and raise cups of thanksgiving.",
          transliteration = "Shokr-e Īzad ke miyān-e man o ū solh oftād\nSūfiyān raqs-konān sāghar-e shokrāneh zadand"
        )
      ),
      interpretation = Interpretation(
        verdictFa = "فوق‌العاده عالی؛ نشانه‌ی رسالتی بزرگ و موفقیتی شگفت‌انگیز",
        verdictEn = "Magnificent omen; a sign of a unique cosmic destiny and lasting spiritual achievement",
        messageFa = "شما برای انجام کاری مهم و ویژه برگزیده شده‌اید. رسالتی بر دوش دارید که شاید دیگران از پذیرش آن هراس داشته‌اند، اما شما شایستگی آن را دارید. کینه‌ها و اختلافات گذشته را به فراموشی بسپارید، زیرا صلح و آشتی بزرگی در افق زندگی شما پدیدار شده است.",
        messageEn = "You are called to undertake a profound calling that others felt intimidated by. Trust your innate spiritual strength. A reconciliation is dawning that will dissolve past grievances. Keep faith in the sacred spark within you.",
        adviceFa = "شکرگزار نعمت‌های الهی باشید، از قضاوت و تعصب بی‌جا دوری کنید و با دلی پاک قدم بردارید.",
        adviceEn = "Express gratitude for every grace, rise above petty disputes, and step forward with fearless courage."
      )
    ),
    Ghazal(
      id = 255,
      number = 255,
      titleFa = "یوسف گمگشته بازآید به کنعان",
      titleEn = "Lost Joseph Shall Return to Canaan",
      themeFa = "امید، پایان هجران، صبر، پیروزی",
      themeEn = "Hope, Return of Joy, Patience, Deliverance",
      verses = listOf(
        Verse(
          firstHalfFa = "یوسف گمگشته بازآید به کنعان غم مخور",
          secondHalfFa = "کلبه احزان شود روزی گلستان غم مخور",
          translationEn = "Lost Joseph shall return to Canaan; grieve not!\nThe hut of sorrows shall bloom into a garden of roses; grieve not!",
          transliteration = "Yūsof-e gom-gashteh bāz-āyad be Kan’ān gham makhor\nKolbeh-ye ahzān shavad rūzī golestān gham makhor"
        ),
        Verse(
          firstHalfFa = "این دل غمدیده حالش به شود دل بد مکن",
          secondHalfFa = "وین سر شوریده بازآید به سامان غم مخور",
          translationEn = "This sorrowful heart will heal; do not lose hope!\nThis restless soul shall find tranquil balance; grieve not!",
          transliteration = "Īn del-e gham-dīdeh hālash beh shavad del bad makon\n V-īn sar-e shūrīdeh bāz-āyad be sāmān gham makhor"
        ),
        Verse(
          firstHalfFa = "دور گردون گر دو روزی بر مراد ما نرفت",
          secondHalfFa = "دایما یک سان نباشد حال دوران غم مخور",
          translationEn = "If the celestial wheel did not turn in our favor for a day or two,\nThe tides of time never remain the same; grieve not!",
          transliteration = "Dowr-e gardūn gar dow rūzī bar morād-e mā naraft\nDā’emā yek-sān nabāshad hāl-e dowrān gham makhor"
        ),
        Verse(
          firstHalfFa = "هان مشو نومید چون واقف نه‌ای از سر غیب",
          secondHalfFa = "باشد اندر پرده بازی‌های پنهان غم مخور",
          translationEn = "Beware! Do not despair, for you know not the secrets of the unseen;\nBehind the mystical veil lie hidden games of wonder; grieve not!",
          transliteration = "Hān mashow nowmīd chūn wāqef ne-ī az serr-e gheyb\nBāshad andar pardeh bāzī-hā-ye penhān gham makhor"
        ),
        Verse(
          firstHalfFa = "ای دل ار سیل فنا بنیاد هستی برکند",
          secondHalfFa = "چون تو را نوح است کشتیبان ز طوفان غم مخور",
          translationEn = "O heart, even if the flood of annihilation sweeps life’s foundation away,\nSince Noah is your steersman, fear not the tempest; grieve not!",
          transliteration = "Ey del ar seyl-e fanā bonyād-e hastī bar-kanad\nChūn tow rā Nūh ast keshtībān ze tūfān gham makhor"
        ),
        Verse(
          firstHalfFa = "حافظا در کنج فقر و خلوت شب‌های تار",
          secondHalfFa = "تا بود وردت دعا و درس قرآن غم مخور",
          translationEn = "Hafez, in the quiet corner of solitude and dark nights,\nAs long as prayer and sacred truth remain your chant, grieve not!",
          transliteration = "Hāfezā dar konj-e faqr o khelvat-e shab-hā-ye tār\nTā bovad verd-at do’ā o dars-e Qor’ān gham makhor"
        )
      ),
      interpretation = Interpretation(
        verdictFa = "بشارت بسیار بزرگ! پایان غم‌ها و بازگشت شادمانی و امید",
        verdictEn = "Tidings of immense joy! The end of separation, despair turning into sweet triumph",
        messageFa = "این یکی از روشن‌ترین و امیدوارکننده‌ترین فال‌های دیوان حافظ است. روزهای سختی و نگرانی شما به پایان نزدیک می‌شود. آن چیزی یا فردی که گم کرده‌اید یا از دست رفته می‌پنداشتید، به زودی به زندگی شما بازخواهد گشت. امید خود را هرگز از دست ندهید، زیرا جهان در حال دگرگونی به نفع شماست.",
        messageEn = "One of the most comforting and radiant omens in all of world literature. Your season of sorrow is drawing to its close. Whatever you thought was lost—a person, an opportunity, a creative dream—shall return restored. Have faith in the unseen harmony orchestrating your life.",
        adviceFa = "اندوه را از سینه بیرون کنید، به خداوند پناه ببرید و آماده‌ی استقبال از مژده و گشایش باشید.",
        adviceEn = "Cast away gloomy thoughts, cultivate unwavering hope, and prepare to welcome good news."
      )
    ),
    Ghazal(
      id = 470,
      number = 470,
      titleFa = "سینه مالامال درد است",
      titleEn = "The Breast is Filled with Pain",
      themeFa = "طلب درمان، همدلی، دوستی و صفا",
      themeEn = "Yearning for Healing, True Companionship, Sincerity",
      verses = listOf(
        Verse(
          firstHalfFa = "سینه مالامال درد است ای دریغا مرهمی",
          secondHalfFa = "دل ز تنهایی به جان آمد خدا را همدمی",
          translationEn = "The breast is overflowing with pain; alas, where is the balm?\nThe heart is exhausted by loneliness; by God, send a soulmate companion!",
          transliteration = "Sīneh mālā-māl-e dard ast ey darīghā marhamī\nDel ze tanhāyī be jān āmad Khodā rā hamdamī"
        ),
        Verse(
          firstHalfFa = "چشم آسایش که دارد از سپهر تیزرو",
          secondHalfFa = "ساقیا جامی به من ده تا بیاسایم دمی",
          translationEn = "Who can hope for tranquil rest from the fast-whirling sphere of fate?\nCupbearer, give me a cup that I may rest a tranquil moment.",
          transliteration = "Chashm-e āsāyesh ke dārad az sepehr-e tīz-row\nSāqiyā jāmī be man deh tā biyāsāyam damī"
        ),
        Verse(
          firstHalfFa = "در طریق عشق بازی امن و آسایش بلاست",
          secondHalfFa = "ریش باد آن دل که با درد تو خواهد مرهمی",
          translationEn = "In the way of passionate love, safety and ease are mere afflictions;\nWounded be that heart that seeks a worldly salve for your sweet ache!",
          transliteration = "Dar tarīq-e ‘eshq-bāzī amn o āsāyesh balāst\nRīsh bād ān del ke bā dard-e tow khwāhad marhamī"
        ),
        Verse(
          firstHalfFa = "اهل کام و ناز را در کوی رندی راه نیست",
          secondHalfFa = "رهروی باید جهان‌سوزی نه خامی بی‌غمی",
          translationEn = "Those seeking idle comfort have no entry to the alley of the mystics;\nA traveler is needed who burns all worldly pretenses, not an untried heart.",
          transliteration = "Ahl-e kām o nāz rā dar kūy-e rendī rāh nīst\nRah-rowī bāyad jahān-sūzī na khāmī bī-ghamī"
        ),
        Verse(
          firstHalfFa = "آدمی در عالم خاکی نمی‌آید به دست",
          secondHalfFa = "عالمی دیگر بباید ساخت وز نو آدمی",
          translationEn = "A truly noble human is hard to find in this dust-bound world;\nA new world must be built, and from the new world, a new human born!",
          transliteration = "Ādamī dar ‘ālam-e khākī nemī-āyad be dast\n‘Ālamī dīgar bebāyad sākht v-az now ādamī"
        )
      ),
      interpretation = Interpretation(
        verdictFa = "هشدار و توصیه به تغییر محیط، رهایی از تنهایی و بازسازی درونی",
        verdictEn = "Insightful counsel: time to break isolation, seek authentic companions, and reinvent your inner state",
        messageFa = "دلتنگ و رنجیده‌خاطرید و احساس می‌کنید اطرافیان ارزش درونی شما را درک نمی‌کنند. این فال به شما گوشزد می‌کند که وقت آن رسیده است که دایره دوستان و محیط خود را متحول کنید. منتظر درمان از بیرون نباشید؛ خودتان باید دنیایی نو بسازید.",
        messageEn = "You are feeling unseen and weighed down by superficial surroundings. The oracle advises you that complaining in isolation will not cure the heart. Seek true souls who share your depth. Reinvent your circumstances with creative courage.",
        adviceFa = "به افراد بی‌وفا دل نبندید. برای رشد و بازسازی خود وقت بگذارید و به دنبال دوستان واقعی و اهل دل باشید.",
        adviceEn = "Step away from fair-weather friends, embrace self-renewal, and seek companions of spiritual substance."
      )
    ),
    Ghazal(
      id = 407,
      number = 407,
      titleFa = "مزرع سبز فلک دیدم و داس مه نو",
      titleEn = "I Beheld Heaven’s Green Field",
      themeFa = "حسابرسی اعمال، غنیمت شمردن عمر، کشت نیکی",
      themeEn = "Harvest of Life, Value of Time, Sowing Goodness",
      verses = listOf(
        Verse(
          firstHalfFa = "مزرع سبز فلک دیدم و داس مه نو",
          secondHalfFa = "یادم از کشته خویش آمد و هنگام درو",
          translationEn = "I beheld the green field of heaven and the crescent sickle of the moon;\nI was reminded of my own sown crop and the approaching harvest time.",
          transliteration = "Mazra’-e sabz-e falak dīdam o dās-e mah-e now\nYādam az koshteh-ye khwīsh āmad o hengām-e derow"
        ),
        Verse(
          firstHalfFa = "گفتم ای بخت بخفتیدی و خورشید دمید",
          secondHalfFa = "گفت با این همه از سابقه نومید مشو",
          translationEn = "I said: 'O Fortune, you slept while the morning sun arose!'\nShe answered: 'Yet, despite all, do not despair of eternal grace.'",
          transliteration = "Goftam ey bakht bekhoftīdī o khowrshīd damīd\nGoft bā īn hameh az sābeqeh nowmīd mashow"
        ),
        Verse(
          firstHalfFa = "گر روی پاک و مجرد چو مسیحا به فلک",
          secondHalfFa = "از فروغت به ثریا رسد از قدر صد تو",
          translationEn = "If you ascend pure and unburdened like the Messiah unto the sky,\nFrom your radiance a hundredfold honor shall reach the stars.",
          transliteration = "Gar ravī pāk o mojarrad chū Masīhā be falak\nAz forūghat be Sorayyā rasad az qadr sad tow"
        ),
        Verse(
          firstHalfFa = "گوشوار زر و لعل ار چه گرانوار بود",
          secondHalfFa = "دور خوبی گذران است نصیحت بشنو",
          translationEn = "Though earrings of gold and ruby may be precious beyond measure,\nThe season of youth is fleeting; hear this timeless advice!",
          transliteration = "Gūshvār-e zar o la’l ar che gerānvār bovad\nDowr-e khūbī gozarān ast nasīhat beshnow"
        )
      ),
      interpretation = Interpretation(
        verdictFa = "فرصتی نو برای جبران گذشته و دروی محصول تلاش‌ها",
        verdictEn = "A fresh golden hour to make amends, sow good seeds, and harvest earned fruits",
        messageFa = "از گذر زمان یا تأخیر در کارهایتان نگران نشوید. لطف خداوند بی‌پایان است و هیچ تلاشی گم نخواهد شد. اکنون زمان مناسبی است تا برنامه‌ریزی کنید، کم‌کاری‌های گذشته را جبران نمایید و بذر نیکی و صداقت بکارید تا نتیجه‌ای درخشان برداشت کنید.",
        messageEn = "Do not lament lost time. Divine mercy is ever renewer of life. Today is the day to act cleanly, plant sincere seeds in work and love, and focus on lasting virtues rather than transient distractions.",
        adviceFa = "وقت را غنیمت شمارید، از تنبلی پرهیز کرده و با راستی و پاکدستی به اهداف خود بپردازید.",
        adviceEn = "Seize this critical window, cultivate disciplined integrity, and your harvest will be bountiful."
      )
    ),
    Ghazal(
      id = 136,
      number = 136,
      titleFa = "دست از طلب ندارم",
      titleEn = "I Will Not Cease from Seeking",
      themeFa = "همت بلند، پایداری، عزم جزم، وصال یار",
      themeEn = "High Resolve, Perseverance, Ultimate Attainment",
      verses = listOf(
        Verse(
          firstHalfFa = "دست از طلب ندارم تا کام من برآید",
          secondHalfFa = "یا تن رسد به جانان یا جان ز تن برآید",
          translationEn = "I will not cease from seeking until my desire is fulfilled;\nEither my body shall reach the Beloved, or my soul shall leave my body.",
          transliteration = "Dast az talab nadāram tā kām-e man bar-āyad\nYā tan rasad be jānān yā jān ze tan bar-āyad"
        ),
        Verse(
          firstHalfFa = "بگشای تربتم را بعد از وفات و بنگر",
          secondHalfFa = "کز آتش درونم دود از کفن برآید",
          translationEn = "Open my resting grave after I pass away, and behold:\nFrom the inner fire of my longing, smoke will rise from the shroud!",
          transliteration = "Bogshāy torbatam rā ba’d az vafāt o bengar\nK-az ātash-e darūnam dūd az kafan bar-āyad"
        ),
        Verse(
          firstHalfFa = "بنمای رخ که خلقی واله شوند و حیران",
          secondHalfFa = "بگشای لب که فریاد از مرد و زن برآید",
          translationEn = "Unveil your radiant face so that creation may be amazed and intoxicated;\nOpen your sweet lips that cries of wonder may rise from women and men.",
          transliteration = "Benmāy rokh ke khalqī vāleh shavand o heyrān\nBogshāy lab ke faryād az mard o zan bar-āyad"
        ),
        Verse(
          firstHalfFa = "در کارخانه عشق از کفر و دین چه پرسی",
          secondHalfFa = "مقصود چون تو باشی کفر از دهن برآید",
          translationEn = "In the boundless sanctuary of love, what ask you of orthodoxy or heresy?\nWhen You are the goal, all dogmas dissolve into ecstatic wonder.",
          transliteration = "Dar kārkhāneh-ye ‘eshq az kofr o dīn che porsī\nMaqsūd chūn Tow bāshī kofr az dahan bar-āyad"
        )
      ),
      interpretation = Interpretation(
        verdictFa = "بسیار استوار و موفقیت‌آمیز؛ نشانه‌ی رسیدن به مقصود با پایداری",
        verdictEn = "Resolute and triumphant; reaching your beloved objective through persistent will",
        messageFa = "شما فردی با عزم راسخ و اراده‌ای پولادین هستید. حافظ به شما مژده می‌دهد که تسلیم نشوید و تا آخر خط بایستید. هرچند راه ناهموار باشد، پاداش پایداری شما رسیدن به مقصود دلخواه و غلبه بر رقیبان خواهد بود.",
        messageEn = "Your determination is your greatest ally. Hafez calls you to stay relentless and unfaltering. The breakthrough you seek requires that you do not quit an inch before the finish line. Success is imminent.",
        adviceFa = "به شک و تردیدهای درونی پایان دهید و با اتکال به حق و اعتمادبه‌نفس پیش بروید.",
        adviceEn = "Banish all hesitation; your persistent devotion will turn the impossible into reality."
      )
    ),
    Ghazal(
      id = 22,
      number = 22,
      titleFa = "چو بشنوی سخن اهل دل",
      titleEn = "When You Hear the Words of Wise Hearts",
      themeFa = "حکمت، تواضع در برابر حقیقت، رندی",
      themeEn = "Wisdom, Humility before Truth, Spiritual Openness",
      verses = listOf(
        Verse(
          firstHalfFa = "چو بشنوی سخن اهل دل مگو که خطاست",
          secondHalfFa = "سخن‌شناس نه‌ای جان من خطا این جاست",
          translationEn = "When you hear the speech of enlightened souls, say not that it is mistaken;\nYou are not versed in deep wisdom, my dear—the mistake lies right here!",
          transliteration = "Chū beshnavī sokhan-e ahl-e del magū ke khatāst\nSokhan-shenās ne-ī jān-e man khatā īn-jāst"
        ),
        Verse(
          firstHalfFa = "سرم به دنیی و عقبی فرو نمی‌آید",
          secondHalfFa = "تبارک الله از این فتنه‌ها که در سر ماست",
          translationEn = "My head does not bow to this world nor the next;\nBlessed be God for the ecstatic storms that swirl within my mind!",
          transliteration = "Saram be donyī o ‘oqba forū nemī-āyad\nTabārak-Allāh az īn fetneh-hā ke dar sar-e māst"
        ),
        Verse(
          firstHalfFa = "در اندرون من خسته دل ندانم کیست",
          secondHalfFa = "که من خموشم و او در فغان و در غوغاست",
          translationEn = "I know not who dwells within this weary heart of mine,\nFor while I remain in silence, He is in loud outcry and divine song!",
          transliteration = "Dar andarūn-e man-e khasteh-del nadānam kīst\nKe man khamūsham o ū dar foghān o dar ghowghāst"
        )
      ),
      interpretation = Interpretation(
        verdictFa = "دعوت به تأمل و فروتنی؛ شنیدن نقدها و یافتن صدای حقیقت درون",
        verdictEn = "Call to reflection and humility; heed constructive criticism and find your inner light",
        messageFa = "شاید اخیراً توصیه‌ای شنیده‌اید که در ابتدا به مذاقتان خوش نیامده باشد. با شتاب داوری نکنید. در سخنان دیگران نشانه‌هایی پنهان برای هدایت شما نهفته است. درون شما غوغایی برپاست که نشان از بیداری روحی شما دارد.",
        messageEn = "Do not be quick to dismiss counsel that challenges your current perspective. The soul grows when it listens past ego. An inner awakening is underway—listen to that quiet, divine voice inside.",
        adviceFa = "قضاوت عجولانه را کنار بگذارید و به دنبال حقیقت بروید نه تأیید تعصبات پیشین.",
        adviceEn = "Set aside pride, welcome wise insights, and honor the transformative flame within."
      )
    ),
    Ghazal(
      id = 94,
      number = 94,
      titleFa = "زان یار دلنوازم",
      titleEn = "From That Heart-Soothing Beloved",
      themeFa = "شکرگزاری، گشایش، رفع دلخوری، وصال",
      themeEn = "Thankfulness, Resolution of Misunderstanding, Joyous Union",
      verses = listOf(
        Verse(
          firstHalfFa = "زان یار دلنوازم شکریست با شکایت",
          secondHalfFa = "گر نکته دان عشقی خوش بشنو این حکایت",
          translationEn = "Regarding that heart-comforting Beloved, I have both thanks and lament;\nIf you are a connoisseur of love, listen sweetly to this tale.",
          transliteration = "Z-ān yār-e delnavāzam shokrī-st bā shekāyat\nGar nokteh-dān-e ‘eshqī khowsh beshnow īn hekāyat"
        ),
        Verse(
          firstHalfFa = "بی‌مزد بود و منت هر خدمتی که کردم",
          secondHalfFa = "یا رب مباد کس را مخدوم بی‌عنایت",
          translationEn = "Without reward or praise was every service I performed;\nO Lord, let no one suffer a master bereft of kindness!",
          transliteration = "Bī-mozd būd o mennat har khedmatī ke kardam\nYā Rabb mabād kas rā makhdūm-e bī-‘enāyat"
        ),
        Verse(
          firstHalfFa = "در زلف چون کمندش ای دل مپیچ کان جا",
          secondHalfFa = "سرها بریده بینی بی‌جرم و بی‌جنایت",
          translationEn = "Tangle not in those lasso-like curls, O heart, for there\nYou shall behold noble heads severed without fault or crime.",
          transliteration = "Dar zolf-e chūn kamandash ey del mapīch k-ān jā\nSar-hā borīdeh bīnī bī-jorm o bī-jenāyat"
        ),
        Verse(
          firstHalfFa = "رندی آموز و کرم کن که نه چندان هنر است",
          secondHalfFa = "حیوانی که ننوشد می و انسان نشود",
          translationEn = "Learn spiritual freedom and practice boundless generosity;\nThere is no virtue in a creature that avoids the cup of awakening and never becomes human.",
          transliteration = "Rendī āmūz o karam kon ke na chandān honar ast\nHeyvānī ke nanūshad mey o ensān nashavad"
        )
      ),
      interpretation = Interpretation(
        verdictFa = "پایان گله‌گذاری‌ها و گشایش در یک رابطه عاطفی یا کاری مهم",
        verdictEn = "Resolution of past grievances and sweet harmony returning to a crucial partnership",
        messageFa = "شما زحمات فراوانی کشیده‌اید اما احساس می‌کنید قدردانی لازم از شما نشده است. به زودی این سوءتفاهم‌ها برطرف خواهد شد. طرف مقابل متوجه ارزش و خلوص نیت شما خواهد شد و پاداش شکیبایی خود را دریافت خواهید کرد.",
        messageEn = "You have given much and felt unappreciated. Do not let bitterness harden your spirit. A shift is taking place wherein your genuine loyalty and sincerity will be fully recognized and rewarded.",
        adviceFa = "از سرزنش و گله‌گذاری مداوم بپرهیزید و با بزرگواری و بخشش راه را برای آشتی هموار سازید.",
        adviceEn = "Practice magnanimity, transcend petty grievances, and let your grace do the speaking."
      )
    )
  )
}
