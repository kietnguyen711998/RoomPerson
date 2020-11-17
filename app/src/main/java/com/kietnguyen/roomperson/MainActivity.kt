package com.kietnguyen.roomperson

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var db: PersonDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PersonDatabase.getInstance(this)?.let {
            db = it
        }

        fab_add.setOnClickListener {
            val intentGoToAddActivity = Intent(this, AddActivity::class.java)
            startActivity(intentGoToAddActivity)
        }
    }

    override fun onResume() {
        super.onResume()
        fetchData()
    }

    fun fetchData() {
        GlobalScope.launch {
            val listItem = db.personDao().readAllPerson()
            runOnUiThread {
                val adapter = PersonAdapter(listItem)
                recycler_view.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                recycler_view.adapter = adapter
            }
        }
    }
}