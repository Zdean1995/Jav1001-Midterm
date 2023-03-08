package com.auchtermuchty.converter
/*
Zachary Dean
A00275392

This is an android app that is used for converting between various distance units.  It is essentially an android version of
the app I made for lab 1
 */


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.auchtermuchty.converter.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //I managed to figure out this on my own.  I typed .listen at the end of txtDistanceInput and found this
        //This makes it so the output text updates as the input text is changed
        binding.txtDistanceInput.addTextChangedListener { setOutput() }

        /*
        The following is for making the output change as the unit spinners are changed.
        onNothingSelected hasn't been touch since as far as I'm aware that's not possible
        Taken from:
        https://stackoverflow.com/questions/46447296/android-kotlin-onitemselectedlistener-for-spinner-not-working
         */
        binding.spnInputUnit.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                setOutput()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        binding.spnOutputUnit.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                setOutput()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

    }

    /*
    This function is for setting the output text.  It takes the input value and multiplies it by the
    ratio of the two units.
     */
    fun setOutput() {
        try {
            val inputValue = binding.txtDistanceInput.text.toString().toDouble()
            val inputDataType = getUnit(binding.spnInputUnit.selectedItem.toString())
            val outputDataType = getUnit(binding.spnOutputUnit.selectedItem.toString())
            val outputValue = inputValue * (inputDataType/outputDataType)
            binding.txtDistanceOutput.setText(outputValue.toString())

        } catch(exception: Exception) {
            /*
            This stops the app from crashing when the input value is empty.  It also stops the output
            value from not changing when the input box is cleared
             */
            binding.txtDistanceOutput.setText("0")
        }
    }
}

//This is the same function used in my lab 1.
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