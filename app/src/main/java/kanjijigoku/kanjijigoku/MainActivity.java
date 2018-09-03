package kanjijigoku.kanjijigoku;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SQLiteDatabase sampleDB = null;
    private final String dbName = "webnautes";

    private int testValue = 0;

    private AdView mAdView;
    private TextView txtScore;
    private TextView txtTimer;
    private TextView txtQuiz;

    private TextView txtOne;
    private TextView txtTwo;
    private TextView txtThree;

    private TextView txtClear;

    private ImageButton btnOne;
    private ImageButton btnTwo;
    private ImageButton btnThree;

    private ImageButton btnExit;

    private ImageView imgCrown;

    private String[] quizRadical = {"⼀"
            , "⼁"
            , "⼂"
            , "⼃"
            , ""
            , "⼄"
            , "⺃"
            , "⼅"
            , "⼆"
            , "⼇"
            , "⼈"
            , "⺅"
            , "𠆢"
            , "⼉"
            , "⼊"
            , "⼋"
            , ""
            , "⼌ "
            , "⼍"
            , "⼎"
            , "⼏"
            , "⺇"
            , "⼐"
            , "⼑"
            , "⺉"
            , "⼒"
            , "⼓"
            , "⼔"
            , "⼕"
            , "⼖"
            , "⼗"
            , "⼘"
            , "⼙"
            , "⼚"
            , "⼛"
            , "⼜"
            , "⼝"
            , ""
            , "⼞"
            , "⼟"
            , ""
            , "⼠"
            , ""
            , "⼡"
            , "⼢"
            , "⼣"
            , "⼤"
            , "⼥"
            , ""
            , "⼦"
            , ""
            , "⼧"
            , "⼨"
            , ""
            , "⼩"
            , "⺌"
            , "⺐"
            , "⼫"
            , "⼬"
            , "⼭"
            , ""
            , ""
            , "⼮"
            , "川"
            , "⼯"
            , ""
            , "⼰"
            , "⼱"
            , ""
            , "⼲"
            , "⺓"
            , "⼴"
            , "⼵"
            , "⼶"
            , "⼷"
            , "⼸"
            , ""
            , "⼹"
            , "⺕"
            , "⺔"
            , "⼺"
            , "⼻"
            , "⺾"
            , "⻌"
            , "⻏"
            , "⻖"
            , "⺍"
            , "⺖"
            , "⺘"
            , "⺡"
            , "⺨"
            , "⼼"
            , "⺗"
            , "⼽"
            , "⼾"
            , ""
            , "⼿"
            , "⽀"
            , "⽁"
            , "⺙"
            , "⽂"
            , "⽃"
            , "⽄"
            , "⽅"
            , ""
            , "⽆"
            , "⽇"
            , ""
            , "⽈"
            , "⽉"
            , "⺝"
            , ""
            , "⽊"
            , ""
            , "⽋"
            , "⽌"
            , "⽍"
            , ""
            , "⽎"
            , "⽏"
            , "⽐"
            , "⽑"
            , "⽒"
            , "⽓"
            , "⽔"
            , "⽕"
            , ""
            , "⺣"
            , "⽖"
            , "⺤"
            , "爫"
            , "⽗"
            , "⽘"
            , "⽙"
            , "⽚"
            , ""
            , ""
            , "⽜"
            , ""
            , "⽝"
            , ""
            , "⺭"
            , "㓁"
            , "⺹"
            , "⽞"
            , "⽟"
            , ""
            , "⽡"
            , "⽢"
            , "⽣"
            , "⽤"
            , "⽥"
            , ""
            , "⽦"
            , "⺪"
            , "⽧"
            , "⽨"
            , "⽩"
            , ""
            , "⽪"
            , "⽫"
            , "⽬"
            , ""
            , ""
            , "⽭"
            , ""
            , "⽮"
            , ""
            , "⽯"
            , ""
            , "⽰"
            , "⽱"
            , "⽲"
            , "⽳"
            , ""
            , "⽴"
            , ""
            , ""
            , ""
            , "氺"
            , "⺫"
            , "𦉰 "
            , "⻂"
            , "⺛"
            , "⽵"
            , "⺮"
            , "⽶"
            , ""
            , "⽷"
            , ""
            , "⽸"
            , "⽹"
            , "⽺"
            , "⺷"
            , "羽"
            , "⽻"
            , "⽼"
            , "⽽"
            , "⽾"
            , "⽿"
            , ""
            , "⾀"
            , "⾁"
            , "⾂"
            , "⾃"
            , "⾄"
            , ""
            , "⾅"
            , "⾆"
            , "⾇"
            , "⾈"
            , ""
            , "⾉"
            , "⾊"
            , "⾋"
            , "⾌"
            , "⾍"
            , ""
            , "⾎"
            , "⾏"
            , "⾐"
            , "⾑"
            , "⻃"
            , "⽠"
            , "⾒"
            , "⾓"
            , ""
            , "⾔"
            , ""
            , "⾕"
            , ""
            , "⾖"
            , ""
            , "⾗"
            , "⾘"
            , "⾙"
            , ""
            , "⾚"
            , "⾛"
            , ""
            , "⾜"
            , "⻊"
            , "⾝"
            , ""
            , "⾞"
            , ""
            , "⾟"
            , "⾠"
            , "⾡"
            , "⾢"
            , "⾣"
            , ""
            , "⾤"
            , ""
            , "⾥"
            , ""
            , "⾂"
            , ""
            , "⻨"
            , "⾦"
            , ""
            , "⻑"
            , "⾨"
            , "⾩"
            , "⾪"
            , "⾫"
            , "⾬"
            , "⻗"
            , "⾭"
            , "⻘"
            , "⾮"
            , "⻟"
            , "⻫"
            , "⾯"
            , "⾰"
            , ""
            , "⾲"
            , "⾳"
            , "⾴"
            , "⾵"
            , "⾶"
            , "⾷"
            , "⾸"
            , "⾹"
            , "⾺"
            , ""
            , "⾻"
            , ""
            , "⾼"
            , "⾽"
            , "⾾"
            , "⾿"
            , "⿀"
            , "⿁"
            , "⾱"
            , "⿂"
            , ""
            , "⿃"
            , "⿄"
            , "⿅"
            , "⿆"
            , "⿇"
            , ""
            , "⻩"
            , "黒"
            , "⻲"
            , "⿈"
            , "⿉"
            , "⿊"
            , "⿋"
            , "⻭"
            , "⿌"
            , "⿍"
            , "⿎"
            , "⿏"
            , "⿐"
            , "⿑"
            , "⿒"
            , "⿓"
            , "⿔"
            , "⿕"
    };

    private String[] quizRadicalCorrect = {
            "いち"
            ,"たてぼう"
            ,"てん"
            ,"の"
            ,"のかんむり"
            ,""
            ,"おつ"
            ,"はねぼう"
            ,"に"
            ,"なべぶた"
            ,"ひと"
            ,"にんべん"
            ,"ひとやね"
            ,"ひとあし"
            ,"いる"
            ,"はち"
            ,"はちがしら"
            ,"けいがまえ"
            ,"わかんむり"
            ,"にすい"
            ,"きにょう"
            ,"かぜかんむり"
            ,"かんにょう"
            ,"かたな"
            ,"りっとう"
            ,"ちから"
            ,"つつみがまえ"
            ,"さじ"
            ,"はこがまえ"
            ,"かくしがまえ"
            ,"じゅう"
            ,"ぼく"
            ,"ふしづくり"
            ,"がんだれ"
            ,"む"
            ,"また"
            ,"くち"
            ,"くちへん"
            ,"くにがまえ"
            ,"つち"
            ,"つちへん"
            ,"さむらい"
            ,"さむらいかんむり"
            ,"のまた"
            ,"なつあし"
            ,"ゆうべ"
            ,"だい"
            ,"おんな"
            ,"おんなへん"
            ,"こ"
            ,"こへん"
            ,"うかんむり"
            ,"すん"
            ,"すんづくり"
            ,"しょう"
            ,"しょうかんむり"
            ,"だいのまげあし"
            ,"しかばね"
            ,"くさのめ"
            ,"やま"
            ,"やまへん"
            ,"やまかんむり"
            ,"まがりがわ"
            ,"さんぼんがわ"
            ,"たくみ"
            ,"たくみへん"
            ,"おのれ"
            ,"はば"
            ,"はばへん"
            ,"かん"
            ,"いとがしら"
            ,"まだれ"
            ,"えんにょう"
            ,"にじゅうあし"
            ,"いぐるみ"
            ,"ゆみ"
            ,"ゆみへん"
            ,"けいがしら"
            ,"けいがしら"
            ,"けいがしら"
            ,"さんづくり"
            ,"ぎょうにんべん"
            ,"くさかんむり"
            ,"しんにょう"
            ,"おおざと"
            ,"こざとへん"
            ,"つ"
            ,"りっしんべん"
            ,"てへん"
            ,"さんずい"
            ,"けものへん"
            ,"こころ"
            ,"したごころ"
            ,"ほこ"
            ,"と"
            ,"とだれ"
            ,"て"
            ,"しにょう"
            ,"ぼくづくり"
            ,"ぼくづくり"
            ,"ぶん"
            ,"ますづくり"
            ,"おのづくり"
            ,"ほう"
            ,"ほうへん"
            ,"むにょう"
            ,"ひ"
            ,"ひへん"
            ,"ひらび"
            ,"つき"
            ,"つきへん"
            ,"にくづき"
            ,"き"
            ,"きへん"
            ,"あくび"
            ,"とめる"
            ,"がつ"
            ,"がつへん"
            ,"るまた"
            ,"なかれ"
            ,"くらべる"
            ,"け"
            ,"うじ"
            ,"きがまえ"
            ,"みず"
            ,"ひ"
            ,"ひへん"
            ,"れっか"
            ,"つめ"
            ,"つめかんむり"
            ,"つめかんむり"
            ,"ちち"
            ,"こう"
            ,"しょうへん"
            ,"かた"
            ,"かたへん"
            ,"きば"
            ,"うし"
            ,"うしへん"
            ,"いぬ"
            ,"おうへん"
            ,"しめすへん"
            ,"あみがしら"
            ,"おいかんむり"
            ,"げん"
            ,"たま"
            ,"うり"
            ,"かわら"
            ,"あまい"
            ,"うまれる"
            ,"もちいる"
            ,"た"
            ,"たへん"
            ,"ひき"
            ,"ひきへん"
            ,"やまいだれ"
            ,"はつがしら"
            ,"しろ"
            ,"はくへん"
            ,"けがわ"
            ,"さら"
            ,"め"
            ,"めへん"
            ,"よこめ"
            ,"ほこ"
            ,"ほこへん"
            ,"や"
            ,"やへん"
            ,"いし"
            ,"いしへん"
            ,"しめす"
            ,"じゅうのあし"
            ,"のぎへん"
            ,"あな"
            ,"あなかんむり"
            ,"たつ"
            ,"たつへん"
            ,"きば"
            ,"きばへん"
            ,"したみず"
            ,"あみがしら"
            ,"あみがしら"
            ,"ころもへん"
            ,"むにょう"
            ,"たけ"
            ,"たけかんむり"
            ,"こめ"
            ,"こめへん"
            ,"いと"
            ,"いとへん"
            ,"みずがめ"
            ,"あみめ"
            ,"ひつじ"
            ,"ひつじ"
            ,"はね"
            ,"はね"
            ,"おいかんむり"
            ,"しこうして"
            ,"らいすき"
            ,"みみ"
            ,"みみへん"
            ,"ふでづくり"
            ,"にく"
            ,"しん"
            ,"みずから"
            ,"いたる"
            ,"いたるへん"
            ,"うす"
            ,"した"
            ,"まいあし"
            ,"ふね"
            ,"ふねへん"
            ,"こん"
            ,"いろ"
            ,"くさ"
            ,"とらがしら"
            ,"むし"
            ,"むしへん"
            ,"ち"
            ,"ぎょうがまえ"
            ,"ころも"
            ,"にし"
            ,"にし"
            ,"うり"
            ,"みる"
            ,"つの"
            ,"つのへん"
            ,"げん"
            ,"ごんべん"
            ,"たに"
            ,"たにへん"
            ,"まめ"
            ,"まめへん"
            ,"いのこ"
            ,"むじなへん"
            ,"かい"
            ,"かいへん"
            ,"あか"
            ,"はしる"
            ,"そうにょう"
            ,"あし"
            ,"あしへん"
            ,"み"
            ,"みへん"
            ,"くるま"
            ,"くるまへん"
            ,"からい"
            ,"しんのたつ"
            ,"しんにょう"
            ,"むら"
            ,"ひよみのとり"
            ,"とりへん"
            ,"のごめ"
            ,"のごめへん"
            ,"さと"
            ,"さとへん"
            ,"しん"
            ,"まいあし"
            ,"むぎ"
            ,"かね"
            ,"かねへん"
            ,"ながい"
            ,"もんがまえ"
            ,"こざと"
            ,"れいづくり"
            ,"ふるとり"
            ,"あめ"
            ,"あめかんむり"
            ,"あお"
            ,"あお"
            ,"あらず"
            ,"しょくへん"
            ,"せい"
            ,"めん"
            ,"つくりがわ"
            ,"なめしがわ"
            ,"にら"
            ,"おと"
            ,"おおがい"
            ,"かぜ"
            ,"とぶ"
            ,"しょく"
            ,"くび"
            ,"かおり"
            ,"うま"
            ,"うまへん"
            ,"ほね"
            ,"ほねへん"
            ,"たかい"
            ,"かみかんむり"
            ,"たたかいがまえ"
            ,"においざけ"
            ,"れき"
            ,"おに"
            ,"なめしがわ"
            ,"うお"
            ,"うおへん"
            ,"とり"
            ,"しお"
            ,"しか"
            ,"むぎ"
            ,"あさ"
            ,"あさかんむり"
            ,"き"
            ,"くろ"
            ,"かめ"
            ,"き"
            ,"きび"
            ,"くろ"
            ,"ぬいとり"
            ,"は"
            ,"かえる"
            ,"かなえ"
            ,"つづみ"
            ,"ねずみ"
            ,"はな"
            ,"せい"
            ,"は"
            ,"りゅう"
            ,"かめ"
            ,"やく"

    };

    Timer timer;

    int min = 1;
    int max = 10;

    String correct = "";

    String answerOne = "";
    String answerTwo = "";
    String answerThree = "";

    // local variable
    String score;
    int countdownValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "MoneyBook.db", null, 1);

        MobileAds.initialize(this, "ca-app-pub-3847525926087017/6354261149");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        txtScore = findViewById(R.id.txtScore);
        txtTimer = findViewById(R.id.txtTimer);
        txtQuiz = findViewById(R.id.txtQuiz);

        txtOne = findViewById(R.id.txtOne);
        txtTwo = findViewById(R.id.txtTwo);
        txtThree = findViewById(R.id.txtThree);

        txtClear = findViewById(R.id.txtClear);

        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);

        imgCrown = findViewById(R.id.imgCrown);

        btnExit = findViewById(R.id.btnExit);

        txtOne.setOnClickListener(this);
        txtTwo.setOnClickListener(this);
        txtThree.setOnClickListener(this);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);

        btnExit.setOnClickListener(this);

        sampleDB = this.openOrCreateDatabase(dbName, MODE_PRIVATE, null);

        dbHelper.onCreate(sampleDB);

        if (dbHelper.getScore().equalsIgnoreCase("")) {
            dbHelper.insert("0", 0, 0);
            txtScore.setText("0");
            txtClear.setText("0");
        } else {
            txtScore.setText(dbHelper.getScore());

            String clear = dbHelper.getClear();
            txtClear.setText(clear);

            if (Integer.parseInt(clear) >= 1) {
                imgCrown.setVisibility(View.VISIBLE);
            }
        }

        init();
    }

    void init() {

        quizStart();

        time();

    }

    void time() {
        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "MoneyBook.db", null, 1);

        countdownValue = getCountdownTime();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        countdownValue--;
                        txtTimer.setText("" + countdownValue);
                        if (countdownValue <= 0) {
                            txtScore.setText(Integer.parseInt(txtScore.getText() + "") - getCountdownTime() + "");
                            dbHelper.updateScore(Integer.parseInt(txtScore.getText() + ""));
                            countdownValue = getCountdownTime();
                            quizStart();
                        }
                    }
                });
            }
        }, 0, 1000);
    }

    int getCountdownTime() {

        int countdown = (10 - (Integer.parseInt(txtScore.getText() + "") / 100));

        return countdown <= 3 ? 3 : countdown;
    }

    String getRandOperator() {
        Random rand = new Random();
        String operator = "";
        switch (1 + rand.nextInt((4 - 1) + 1)) {
            case 1:
                operator = "+";
                break;
            case 2:
                operator = "-";
                break;
            case 3:
                operator = "*";
                break;
            case 4:
                operator = "/";
                break;
        }
        return operator;
    }

    int getCorrect(int num1, int num2, String operator) {

        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }
        return 1;
    }

    int getRandNumber() {

        Random rand = new Random();
        return rand.nextInt((quizRadical.length) + 1);
    }

    void quizStart() {
        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "MoneyBook.db", null, 1);

        if (Integer.parseInt(txtScore.getText() + "") >= 1000) {

            dbHelper.updateClear(Integer.parseInt(txtClear.getText() + "") + 1);
            txtScore.setText("0");
            txtClear.setText(Integer.parseInt(txtClear.getText() + "") + 1 + "");
            imgCrown.setVisibility(View.VISIBLE);

            Dialog dlg = new Dialog(this);
            TextView text = new TextView(this);
            text.setText("地獄から出た！");
            dlg.setContentView(text);
            dlg.setTitle("");
            dlg.show();
        }

        Random rand = new Random();

        answerOne = "";
        answerTwo = "";
        answerThree = "";

        int randNum1 = getRandNumber();
        int randNum2 = getRandNumber();
        String operator = getRandOperator();

        if (operator.equalsIgnoreCase("-")) {
            if (randNum1 == randNum2) {
                randNum1 += randNum1;
            }
            if (randNum1 < randNum2) {
                int temp = randNum1;
                randNum1 = randNum2;
                randNum2 = temp;
            }
        }

        if (operator.equalsIgnoreCase("/")) {
            randNum1 = randNum1 * randNum2;
        }


        String quiz;

        int idx = getRandNumber();
        quiz = quizRadical[idx];

        correct = quizRadicalCorrect[idx];

        answerOne=quizRadicalCorrect[getRandNumber()];
        answerTwo=quizRadicalCorrect[getRandNumber()];
        answerThree=quizRadicalCorrect[getRandNumber()];

        while (answerOne == answerTwo || answerTwo == answerThree || answerOne == answerThree) {
            answerOne=quizRadicalCorrect[getRandNumber()];
            answerTwo=quizRadicalCorrect[getRandNumber()];
            answerThree=quizRadicalCorrect[getRandNumber()];
        }

        switch (1 + rand.nextInt((3 - 1) + 1)) {
            case 1:
                answerOne = correct;
                break;
            case 2:
                answerTwo = correct;
                break;
            case 3:
                answerThree = correct;
                break;
        }

        txtOne.setText(answerOne + "");
        txtTwo.setText(answerTwo + "");
        txtThree.setText(answerThree + "");

        txtQuiz.setText(quiz);
    }


    @Override
    public void onClick(View v) {
        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "MoneyBook.db", null, 1);
        switch (v.getId()) {
            case R.id.btnOne:
            case R.id.txtOne:
                if (answerOne == correct) {
                    dbHelper.updateScore(Integer.parseInt(txtScore.getText() + "") + countdownValue + 100);
                    txtScore.setText(Integer.parseInt(txtScore.getText() + "") + testValue + countdownValue + "");
                    countdownValue = getCountdownTime();
                    quizStart();
                    return;
                }
                countdownValue = 1;
                break;
            case R.id.btnTwo:
            case R.id.txtTwo:
                if (answerTwo == correct) {
                    dbHelper.updateScore(Integer.parseInt(txtScore.getText() + "") + countdownValue + 100);
                    txtScore.setText(Integer.parseInt(txtScore.getText() + "") + testValue + countdownValue + "");
                    countdownValue = getCountdownTime();
                    quizStart();
                    return;
                }
                countdownValue = 1;
                break;
            case R.id.btnThree:
            case R.id.txtThree:
                if (answerThree == correct) {
                    dbHelper.updateScore(Integer.parseInt(txtScore.getText() + "") + countdownValue + 100);
                    txtScore.setText(Integer.parseInt(txtScore.getText() + "") + testValue + countdownValue + "");
                    countdownValue = getCountdownTime();
                    quizStart();
                    return;
                }
                countdownValue = 1;
                break;
            case R.id.btnExit:
                moveTaskToBack(true);
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
        }
    }

    public class DBHelper extends SQLiteOpenHelper {

        // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        // DB를 새로 생성할 때 호출되는 함수
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE IF NOT EXISTS MONEYBOOK (_id INTEGER PRIMARY KEY AUTOINCREMENT, clear INTEGER, score INTEGER, create_at TEXT);");
        }

        // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        public void insert(String create_at, int clear, int score) {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("INSERT INTO MONEYBOOK VALUES(null, " + clear + ", " + score + ", '" + create_at + "');");
            db.close();
        }

        public void updateClear(int clear) {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("UPDATE MONEYBOOK SET clear=" + clear + "");
            db.close();
        }

        public void updateScore(int score) {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("UPDATE MONEYBOOK SET score=" + score + "");
            db.close();
        }

        public String getClear() {
            SQLiteDatabase db = getReadableDatabase();
            String result = "";

            Cursor cursor = db.rawQuery("SELECT * FROM MONEYBOOK", null);
            while (cursor.moveToNext()) {
                result += cursor.getInt(1);
            }

            return result;
        }

        public String getScore() {
            SQLiteDatabase db = getReadableDatabase();
            String result = "";

            Cursor cursor = db.rawQuery("SELECT * FROM MONEYBOOK", null);
            while (cursor.moveToNext()) {
                result += cursor.getInt(2);
            }

            return result;
        }
    }
}