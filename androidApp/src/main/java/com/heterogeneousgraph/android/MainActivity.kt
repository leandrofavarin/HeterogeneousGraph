package com.heterogeneousgraph.android

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.example.MyDatabase

class MainActivity : Activity() {
    val component = AppComponent::class.create(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)

        val db = component.myDatabase
        val books = db.bookQueries.selectAll().executeAsList()

        val textView = findViewById<TextView>(R.id.text_view)
        textView.text = books.joinToString("\n")
    }
}
