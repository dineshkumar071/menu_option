package com.example.recycleviewer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_form.*

class form : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var p1: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        setTitle("enter the data")
        var strarr = resources.getStringArray(R.array.categories)
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, strarr)
        spinner.onItemSelectedListener = this
        Submit.setOnClickListener {
            var name2: String? = editText.text.toString()
            var description2: String? = editText2.text.toString()
            var category2: String? = spinner.selectedItem.toString()//strarr.get(p1)
            var size2: String? = editText4.text.toString()
            var i = Intent()

            if (name2.equals("") || description2.equals("") || category2.equals("") || size2.equals(
                    ""
                )
            ) {
                Toast.makeText(this, "Enter All the Fields", Toast.LENGTH_SHORT).show()
            } else {
                i.putExtra("appname", name2)
                i.putExtra("description", description2)
                i.putExtra("category", category2)
                i.putExtra("size", size2)
                setResult(Activity.RESULT_OK, i)
                finish()
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
        // An item was selected. You can retrieve the selected item using
        //parent.getItemAtPosition(pos)
        p1 = pos

    }


}
