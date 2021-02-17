package com.example.recycleviewer

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val users = ArrayList<user>()
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        floatingActionButton.setOnClickListener {
            var intent: Intent = Intent(this, form::class.java)
            startActivityForResult(intent, 1)

        }
        recyclerview.adapter =
            CustomAdapter(this, users, object : CustomAdapter.ItemClickInterfaces {
                override fun itemClick() {

                    val alert =
                        LayoutInflater.from(this@MainActivity).inflate(R.layout.openactivity, null)
                    val mbuiler =
                        AlertDialog.Builder(this@MainActivity).setView(alert).setTitle("DATA")
                    // Set a positive button and its click listener on alert dialog
                    mbuiler.setPositiveButton("OK") { dialog, which ->
                        // Do something when user press the positive button
                        Toast.makeText(
                            applicationContext,
                            "Ok, we change the app background.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                    mbuiler.setNegativeButton("CANCEL") { _, _ ->
                        Toast.makeText(
                            applicationContext,
                            "You cancelled the dialog.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    val mAlert = mbuiler.show()
                }
            })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                R.id.books -> {
                    val bookusers = ArrayList<user>()
                    for (i in users) {
                        if (i.Category == "books") {
                            bookusers.add(user(i.name, i.Description, i.Category, i.Size, "update"))
                        }
                    }
                    recyclerview.adapter = CustomAdapter(this, bookusers, object :
                        CustomAdapter.ItemClickInterfaces {
                        override fun itemClick() {
                            val alert = LayoutInflater.from(this@MainActivity)
                                .inflate(R.layout.openactivity, null)
                            val mbuiler = AlertDialog.Builder(this@MainActivity).setView(alert)
                                .setTitle("DATA")
                            // Set a positive button and its click listener on alert dialog
                            mbuiler.setPositiveButton("OK") { dialog, which ->
                                // Do something when user press the positive button
                                Toast.makeText(
                                    applicationContext,
                                    "Ok, we change the app background.",
                                    Toast.LENGTH_SHORT
                                ).show()

                            }
                            mbuiler.setNegativeButton("CANCEL") { _, _ ->
                                Toast.makeText(
                                    applicationContext,
                                    "You cancelled the dialog.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            val mAlert = mbuiler.show()
                        }
                    })
                    return true
                }
                R.id.music -> {
                    val musicusers = ArrayList<user>()
                    for (i in users) {
                        if (i.Category == "music") {
                            musicusers.add(
                                user(
                                    i.name,
                                    i.Description,
                                    i.Category,
                                    i.Size,
                                    "update"
                                )
                            )
                        }
                    }
                    recyclerview.adapter = CustomAdapter(this, musicusers, object :
                        CustomAdapter.ItemClickInterfaces {
                        override fun itemClick() {
                            val alert = LayoutInflater.from(this@MainActivity)
                                .inflate(R.layout.openactivity, null)
                            val mbuiler = AlertDialog.Builder(this@MainActivity).setView(alert)
                                .setTitle("DATA")
                            // Set a positive button and its click listener on alert dialog
                            mbuiler.setPositiveButton("OK") { dialog, which ->
                                // Do something when user press the positive button
                                Toast.makeText(
                                    applicationContext,
                                    "Ok, we change the app background.",
                                    Toast.LENGTH_SHORT
                                ).show()

                            }
                            mbuiler.setNegativeButton("CANCEL") { _, _ ->
                                Toast.makeText(
                                    applicationContext,
                                    "You cancelled the dialog.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            val mAlert = mbuiler.show()
                        }
                    })
                    return true
                }
                R.id.games -> {
                    val gameusers = ArrayList<user>()
                    for (i in users) {
                        if (i.Category == "games") {
                            gameusers.add(user(i.name, i.Description, i.Category, i.Size, "update"))
                        }
                    }
                    recyclerview.adapter = CustomAdapter(this, gameusers, object :
                        CustomAdapter.ItemClickInterfaces {
                        override fun itemClick() {
                            val alert = LayoutInflater.from(this@MainActivity)
                                .inflate(R.layout.openactivity, null)
                            val mbuiler = AlertDialog.Builder(this@MainActivity).setView(alert)
                                .setTitle("DATA")
                            // Set a positive button and its click listener on alert dialog
                            mbuiler.setPositiveButton("OK") { dialog, which ->
                                // Do something when user press the positive button
                                Toast.makeText(
                                    applicationContext,
                                    "Ok, we change the app background.",
                                    Toast.LENGTH_SHORT
                                ).show()

                            }
                            mbuiler.setNegativeButton("CANCEL") { _, _ ->
                                Toast.makeText(
                                    applicationContext,
                                    "You cancelled the dialog.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            val mAlert = mbuiler.show()
                        }
                    })
                    return true
                }

            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                var appname3: String? = data?.getStringExtra("appname")
                var description3: String? = data?.getStringExtra("description")
                var category3: String? = data?.getStringExtra("category")
                var size3: String? = data?.getStringExtra("size")
                users.add(user(appname3, description3, category3, size3, "update"))
                recyclerview.adapter?.notifyDataSetChanged()
            }
        }
    }

}
