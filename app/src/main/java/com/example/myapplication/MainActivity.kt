package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button:Button =  findViewById(R.id.btResult)
        val dishPrice:TextView = findViewById(R.id.dishPrice)
        val starterPrice:TextView = findViewById(R.id.starterPrice)
        val ResultTv:TextView = findViewById(R.id.textResult)
        var flag:String = "Mansaf"
        val spinnerVal:Spinner = findViewById(R.id.spSelect)
        var option = arrayOf("Mansaf","Kabsah","Mandy","Burger","Shamwerma")
        var dishPrices = arrayOf(8,5,5.5,6,4)
        spinnerVal.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,option)
        spinnerVal.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = option.get(p2)
                dishPrice.text = dishPrices.get(p2).toString();
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        var flag1:String = "vegetable salads"
        val spinnerVal1:Spinner = findViewById(R.id.spSelect1)
        var option1 = arrayOf("vegetable salads","salads of pasta"," fruit salads","legumes","poultry")
        var starterPrices = arrayOf(2.5,3,2.4,2,4)
        spinnerVal1.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,option1)
        spinnerVal1.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag1 = option1.get(p2)
                starterPrice.text = starterPrices.get(p2).toString();
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        button.setOnClickListener{
            var x = starterPrice.text.toString().toDouble()
            var y = dishPrice.text.toString().toDouble()
            var tax:Double = 6.4;

            ResultTv.text = (((tax/100)*(x+y)) + (x+y)).toString()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val d = RateUs()
        val d2 = Suggestions()
        if(item.itemId == R.id.item1)
        {
        d.show(supportFragmentManager,"")
        }
        if(item.itemId == R.id.item2)
        {
            d2.show(supportFragmentManager,"")
        }
        return true;
    }
}
