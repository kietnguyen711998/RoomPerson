package com.kietnguyen.roomperson

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.kietnguyen.roomperson.model.Person
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class AddActivity : AppCompatActivity() {
    private lateinit var db: PersonDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        PersonDatabase.getInstance(this)?.let {
            db = it
        }
        btn_add.setOnClickListener {
            if (edt_name.text.isNotEmpty() && edt_address.text.isNotEmpty()) {
                val person = Person(
                    null,
                    edt_name.text.toString(),
                    edt_address.text.toString(),
                    null
                )
                GlobalScope.async {
                    val totalSaved = db.personDao().addPerson(person)
                    runOnUiThread {
                        if (totalSaved > 0) {
                            Toast.makeText(
                                this@AddActivity, "Data saved",
                                Toast.LENGTH_LONG
                            ).show()
                            this@AddActivity.finish()
                        } else {
                            Toast.makeText(
                                this@AddActivity, "Data fail to save",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            } else {
                Toast.makeText(
                    this@AddActivity, "Field cannot be empty",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        edt_name.addTextChangedListener {
            Toast.makeText(
                this@AddActivity,
                "Name Changed",
                Toast.LENGTH_LONG
            ).show()
        }

        edt_address.addTextChangedListener {
            Toast.makeText(
                this@AddActivity,
                "Address Changed",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}