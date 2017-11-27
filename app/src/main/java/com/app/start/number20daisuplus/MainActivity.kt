package com.app.start.number20daisuplus


import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Handler
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.KeyEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.NumberPicker
import android.widget.RelativeLayout
import android.widget.TextView

import java.util.Random

class MainActivity : AppCompatActivity() {
    private var NumberPicker1: NumberPicker? = null
    private var NumberPicker2: NumberPicker? = null
    private var NumberPicker3: NumberPicker? = null
    private var NumberPicker4: NumberPicker? = null
    private var NumberPicker5: NumberPicker? = null
    private var NumberPicker6: NumberPicker? = null
    private var NumberPicker7: NumberPicker? = null
    private var NumberPicker8: NumberPicker? = null
    private var NumberPicker9: NumberPicker? = null
    private var NumberPicker10: NumberPicker? = null
    private var NumberPicker11: NumberPicker? = null
    private var NumberPicker12: NumberPicker? = null
    private var NumberPicker13: NumberPicker? = null
    private var NumberPicker14: NumberPicker? = null
    private var NumberPicker15: NumberPicker? = null
    private var NumberPicker16: NumberPicker? = null
    private var NumberPicker17: NumberPicker? = null
    private var NumberPicker18: NumberPicker? = null
    private var NumberPicker19: NumberPicker? = null
    private var NumberPicker20: NumberPicker? = null
    internal var count = intArrayOf(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5)
    private var preference: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sp = PreferenceManager.getDefaultSharedPreferences(this)
        var s = sp.getInt("START", 0)
        sp.edit().putInt("START", s + 1).commit()
        s = sp.getInt("START", 0)

        preference = getSharedPreferences("Preference Name", Context.MODE_PRIVATE)//Kotlinに変換した所Contextにエラー発生→android.context.Contextをインポート
        editor = preference!!.edit()

        if (preference!!.getBoolean("Launched", false) == false) {
            //2回に1回表示
            if (s % 2 == 0) {
                val dialog = AlertDialog.Builder(
                        this@MainActivity)
                dialog.setTitle("ありがとうございます！")
                dialog.setMessage("このアプリをインストールしていただき、ありがとうございます！もしよろしければ、レビューを書いていただけると嬉しいです！")
                dialog.setPositiveButton("レビューを書く"
                ) { dialog, which ->
                    editor!!.putBoolean("Launched", true)
                    editor!!.commit()
                    // TODO 自動生成されたメソッド・スタブ
                    val uri = Uri.parse("https://play.google.com/store/apps/details?id=com.app.start.number20daisustart")
                    val i = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(i)
                }
                dialog.setNegativeButton("また後で"
                ) { dialog, which ->
                    // TODO 自動生成されたメソッド・スタブ
                }
                dialog.setNegativeButton("もう表示しない") { dialog, which ->
                    // NGボタン押下時の処理
                    editor!!.putBoolean("Launched", true)
                    editor!!.commit()
                }


                dialog.show()
            }
        } else {

        }
    }


    fun onClick(view: View) {
        //ここはサイコロを振るボタン//
        when (view.id) {
            R.id.mainbutton1 -> diceroll(view)
        //これは確率変動画面にかんいするためのボタン//
            R.id.mainbutton2 -> {
                setContentView(R.layout.tuning)
                val t2 = findViewById(R.id.counta) as TextView
                t2.text = "合計確立を100%にしてください"
                t2.textSize = 30.0f
            }
        //ここから確率変動ボタン処理//
        /* case R.id.buttonX:
                View rinkX = this.getLayoutInflater().inflate(R.layout.numpick, null);
                NumberPickerX = (NumberPicker)rinkX.findViewById(R.id.numberPicker);
                NumberPickerX.setMaxValue(100);
                NumberPickerX.setMinValue(0);
                NumberPickerX.setValue(count[X-1]);
                new AlertDialog.Builder(this)
                      .setView(rinkX)
                      .show();
                count[X-1] =NumberPickerX.getValue();
                NumberPickerX.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                        count[X-1] = NumberPickerX.getValue();
                    }
                });
                break;*/
        //1の確率//
            R.id.button1 -> {
                val rink1 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker1 = rink1.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker1!!.maxValue = 100
                NumberPicker1!!.minValue = 0
                NumberPicker1!!.value = count[0]
                AlertDialog.Builder(this)
                        .setView(rink1)
                        .show()
                count[0] = NumberPicker1!!.value
                NumberPicker1!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[0] = NumberPicker1!!.value
                    //合計確率の表示//
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //2の確率//
            R.id.button2 -> {
                val rink2 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker2 = rink2.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker2!!.maxValue = 100
                NumberPicker2!!.minValue = 0
                NumberPicker2!!.value = count[1]
                AlertDialog.Builder(this)
                        .setView(rink2)
                        .show()
                count[1] = NumberPicker2!!.value
                NumberPicker2!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[1] = NumberPicker2!!.value
                    //合計確率の表示//
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //3の確率//
            R.id.button3 -> {
                val rink3 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker3 = rink3.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker3!!.maxValue = 100
                NumberPicker3!!.minValue = 0
                NumberPicker3!!.value = count[2]
                AlertDialog.Builder(this)
                        .setView(rink3)
                        .show()
                count[2] = NumberPicker3!!.value
                NumberPicker3!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[2] = NumberPicker3!!.value
                    //合計確率の表示//
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //4の確率//
            R.id.button4 -> {
                val rink4 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker4 = rink4.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker4!!.maxValue = 100
                NumberPicker4!!.minValue = 0
                NumberPicker4!!.value = count[3]
                AlertDialog.Builder(this)
                        .setView(rink4)
                        .show()
                count[3] = NumberPicker4!!.value
                NumberPicker4!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[3] = NumberPicker4!!.value
                    //合計確率の表示//
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //5の確率//
            R.id.button5 -> {
                val rink5 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker5 = rink5.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker5!!.maxValue = 100
                NumberPicker5!!.minValue = 0
                NumberPicker5!!.value = count[4]
                AlertDialog.Builder(this)
                        .setView(rink5)
                        .show()
                count[4] = NumberPicker5!!.value
                NumberPicker5!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[4] = NumberPicker5!!.value
                    //合計確率の表示//
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //6の確率//
            R.id.button6 -> {
                val rink6 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker6 = rink6.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker6!!.maxValue = 100
                NumberPicker6!!.minValue = 0
                NumberPicker6!!.value = count[5]
                AlertDialog.Builder(this)
                        .setView(rink6)
                        .show()
                count[5] = NumberPicker6!!.value
                NumberPicker6!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[5] = NumberPicker6!!.value
                    //合計確率の表示//
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //7の確率//
            R.id.button7 -> {
                val rink7 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker7 = rink7.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker7!!.maxValue = 100
                NumberPicker7!!.minValue = 0
                NumberPicker7!!.value = count[6]
                AlertDialog.Builder(this)
                        .setView(rink7)
                        .show()
                count[6] = NumberPicker7!!.value
                NumberPicker7!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[6] = NumberPicker7!!.value
                    //合計確率の表示//
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //8の確率//
            R.id.button8 -> {
                val rink8 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker8 = rink8.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker8!!.maxValue = 100
                NumberPicker8!!.minValue = 0
                NumberPicker8!!.value = count[7]
                AlertDialog.Builder(this)
                        .setView(rink8)
                        .show()
                count[7] = NumberPicker8!!.value
                NumberPicker8!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[7] = NumberPicker8!!.value
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //9の確率//
            R.id.button9 -> {
                val rink9 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker9 = rink9.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker9!!.maxValue = 100
                NumberPicker9!!.minValue = 0
                NumberPicker9!!.value = count[8]
                AlertDialog.Builder(this)
                        .setView(rink9)
                        .show()
                count[8] = NumberPicker9!!.value
                NumberPicker9!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[8] = NumberPicker9!!.value
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //10の確率//
            R.id.button10 -> {
                val rink10 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker10 = rink10.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker10!!.maxValue = 100
                NumberPicker10!!.minValue = 0
                NumberPicker10!!.value = count[9]
                AlertDialog.Builder(this)
                        .setView(rink10)
                        .show()
                count[9] = NumberPicker10!!.value
                NumberPicker10!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[9] = NumberPicker10!!.value
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //11の確率//
            R.id.button11 -> {
                val rink11 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker11 = rink11.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker11!!.maxValue = 100
                NumberPicker11!!.minValue = 0
                NumberPicker11!!.value = count[10]
                AlertDialog.Builder(this)
                        .setView(rink11)
                        .show()
                count[10] = NumberPicker11!!.value
                NumberPicker11!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[10] = NumberPicker11!!.value
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //12の確率//
            R.id.button12 -> {
                val rink12 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker12 = rink12.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker12!!.maxValue = 100
                NumberPicker12!!.minValue = 0
                NumberPicker12!!.value = count[11]
                AlertDialog.Builder(this)
                        .setView(rink12)
                        .show()
                count[11] = NumberPicker12!!.value
                NumberPicker12!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[11] = NumberPicker12!!.value
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //13の確率//
            R.id.button13 -> {
                val rink13 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker13 = rink13.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker13!!.maxValue = 100
                NumberPicker13!!.minValue = 0
                NumberPicker13!!.value = count[12]
                AlertDialog.Builder(this)
                        .setView(rink13)
                        .show()
                count[12] = NumberPicker13!!.value
                NumberPicker13!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[12] = NumberPicker13!!.value
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //14の確率//
            R.id.button14 -> {
                val rink14 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker14 = rink14.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker14!!.maxValue = 100
                NumberPicker14!!.minValue = 0
                NumberPicker14!!.value = count[13]
                AlertDialog.Builder(this)
                        .setView(rink14)
                        .show()
                count[13] = NumberPicker14!!.value
                NumberPicker14!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[13] = NumberPicker14!!.value
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //15の確率//
            R.id.button15 -> {
                val rink15 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker15 = rink15.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker15!!.maxValue = 100
                NumberPicker15!!.minValue = 0
                NumberPicker15!!.value = count[14]
                AlertDialog.Builder(this)
                        .setView(rink15)
                        .show()
                count[14] = NumberPicker15!!.value
                NumberPicker15!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[14] = NumberPicker15!!.value
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //16の確率//
            R.id.button16 -> {
                val rink16 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker16 = rink16.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker16!!.maxValue = 100
                NumberPicker16!!.minValue = 0
                NumberPicker16!!.value = count[15]
                AlertDialog.Builder(this)
                        .setView(rink16)
                        .show()
                count[15] = NumberPicker16!!.value
                NumberPicker16!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[15] = NumberPicker16!!.value
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //17の確率//
            R.id.button17 -> {
                val rink17 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker17 = rink17.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker17!!.maxValue = 100
                NumberPicker17!!.minValue = 0
                NumberPicker17!!.value = count[16]
                AlertDialog.Builder(this)
                        .setView(rink17)
                        .show()
                count[16] = NumberPicker17!!.value
                NumberPicker17!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[16] = NumberPicker17!!.value
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //18の確率//
            R.id.button18 -> {
                val rink18 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker18 = rink18.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker18!!.maxValue = 100
                NumberPicker18!!.minValue = 0
                NumberPicker18!!.value = count[17]
                AlertDialog.Builder(this)
                        .setView(rink18)
                        .show()
                count[17] = NumberPicker18!!.value
                NumberPicker18!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[17] = NumberPicker18!!.value
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //19の確率//
            R.id.button19 -> {
                val rink19 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker19 = rink19.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker19!!.maxValue = 100
                NumberPicker19!!.minValue = 0
                NumberPicker19!!.value = count[18]
                AlertDialog.Builder(this)
                        .setView(rink19)
                        .show()
                count[18] = NumberPicker19!!.value
                NumberPicker19!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[18] = NumberPicker19!!.value
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //20の確率//
            R.id.button20 -> {
                val rink20 = this.layoutInflater.inflate(R.layout.numpick, null)
                NumberPicker20 = rink20.findViewById(R.id.numberPicker) as NumberPicker
                NumberPicker20!!.maxValue = 100
                NumberPicker20!!.minValue = 0
                NumberPicker20!!.value = count[19]
                AlertDialog.Builder(this)
                        .setView(rink20)
                        .show()
                count[19] = NumberPicker20!!.value
                NumberPicker20!!.setOnValueChangedListener { picker, oldVal, newVal ->
                    count[19] = NumberPicker20!!.value
                    val t2 = findViewById(R.id.counta) as TextView
                    t2.text = (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                            + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19]).toString()
                    t2.textSize = 50.0f
                }
            }
        //ダイス画面に戻るためのボタン//
            R.id.button0 -> {
                if (100 != (count[0] + count[1] + count[2] + count[3] + count[4] + count[5] + count[6] + count[7] + count[8] + count[9]
                        + count[10] + count[11] + count[12] + count[13] + count[14] + count[15] + count[16] + count[17] + count[18] + count[19])) {
                    AlertDialog.Builder(this@MainActivity)
                            .setTitle("エラー")
                            .setMessage("合計確率を100%にしてください")
                            .setPositiveButton("OK", null)
                            .show()
                    //break(Kotlinに変換したらエラーが出たので削除した・・・なぜエラーが？)
                }
                setContentView(R.layout.activity_main)
                setContentView(R.layout.activity_main)
                val layout = findViewById(R.id.layout_simple) as RelativeLayout
            }
        }//
    }

    fun diceroll(View: View) {
        var z: Int
        val y = Random()
        z = y.nextInt(100)
        z = z + 1
        val a = count[0]
        val b = count[1]
        val c = count[2]
        val d = count[3]
        val e = count[4]
        val f = count[5]
        val g = count[6]
        val h = count[7]
        val i = count[8]
        val j = count[9]
        val k = count[10]
        val l = count[11]
        val m = count[12]
        val n = count[13]
        val o = count[14]
        val p = count[15]
        val q = count[16]
        val r = count[17]
        val s = count[18]
        val t = count[19]
        if (100 != a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q + r + s + t) {
            AlertDialog.Builder(this@MainActivity)
                    .setTitle("エラー")
                    .setMessage("合計確率を100%にしてください")
                    .setPositiveButton("OK", null)
                    .show()
        } else if (z <= a) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "1"
        } else if (z <= a + b) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "2"
        } else if (z <= a + b + c) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "3"
        } else if (z <= a + b + c + d) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "4"
        } else if (z <= a + b + c + d + e) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "5"
        } else if (z <= a + b + c + d + e + f) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "6"
        } else if (z <= a + b + c + d + e + f + g) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "7"
        } else if (z <= a + b + c + d + e + f + g + h) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "8"
        } else if (z <= a + b + c + d + e + f + g + h + i) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "9"
        } else if (z <= a + b + c + d + e + f + g + h + i + j) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "10"
        } else if (z <= a + b + c + d + e + f + g + h + i + j + k) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "11"
        } else if (z <= a + b + c + d + e + f + g + h + i + j + k + l) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "12"
        } else if (z <= a + b + c + d + e + f + g + h + i + j + k + l + m) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "13"
        } else if (z <= a + b + c + d + e + f + g + h + i + j + k + l + m + n) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "14"
        } else if (z <= a + b + c + d + e + f + g + h + i + j + k + l + m + n + o) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "15"
        } else if (z <= a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "16"
        } else if (z <= a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "17"
        } else if (z <= a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q + r) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "18"
        } else if (z <= a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q + r + s) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "19"
        } else if (z <= a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q + r + s + t) {
            val t1 = this.findViewById(R.id.start) as TextView
            t1.text = "20"
        }
    }
}