package com.auchtermuchty.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.auchtermuchty.converter.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btnConvert.setOnClickListener {
            try{
                val inputValue = binding.txtDistanceInput.text.toString().toDouble()
                val inputDataType = getUnit(binding.spnInputUnit.selectedItem.toString())
                val outputDataType = getUnit(binding.spnOutputUnit.selectedItem.toString())
                val outputValue = inputValue * (inputDataType/outputDataType)
                binding.txtDistanceOutput.setText(outputValue.toString())

            } catch(exception: NullPointerException) {
                val toast = Toast.makeText(this, "Please enter an value", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }
}

fun getUnit (unit: String): Double {
    return when (unit){
        "mm" -> 1.0
        "cm" -> 10.0
        "m" -> 1000.0
        "km" -> 1000000.0
        "in" -> 25.4
        "ft" -> 304.8
        "yd" -> 914.4
        "mi" -> 1609344.0
        else -> 1.0
    }
}