package com.example.laithwings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var flagW = "Traditional"
        val spinnerW:Spinner = findViewById(R.id.spinnerW)
        var wingOptions = arrayOf("Traditional","Boneless")

        var flagS = "Buffalo"
        val spinnerS : Spinner = findViewById(R.id.spinnerS);
        var sauceOptions = arrayOf("Buffalo","Honey","Crazy","Bbq","Sweet Chili");

        val wings : EditText = findViewById(R.id.wingNum);
        val button:Button = findViewById(R.id.CalcBt)
        val result:TextView = findViewById(R.id.resultTxt);
        spinnerW.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,wingOptions);
        spinnerW.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                flagW = "Traditional" //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                flagW = wingOptions.get(position);
            }

        }

        spinnerS.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sauceOptions);
        spinnerS.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                flagS = "Buffalo"//To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                flagS = sauceOptions.get(position);//To change body of created functions use File | Settings | File Templates.
            }

        }

        button.setOnClickListener { view ->
            val res = calcPrice(flagW, flagS, wings.text.toString().toInt())

            result.text = ((res*10000.0).roundToInt()/10000.0).toString();

        }





    }

    public fun calcPrice(Type:String,Sauce:String,Num:Int):Double{
        var TypePrice : Double = 0.0;
        var SaucePrice : Double = 0.0;
        if(Type=="Traditional") TypePrice = 0.19;
        else TypePrice = 0.25;

        if(Sauce=="Buffalo" || Sauce=="Honey") SaucePrice = 0.05;
        else if(Sauce=="Crazy") SaucePrice = 0.03;
        else SaucePrice = 0.02;

        var Result : Double = (TypePrice+SaucePrice)*Num;
        return Result;
    }
}
