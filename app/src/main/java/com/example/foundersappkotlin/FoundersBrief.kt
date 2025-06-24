package com.example.foundersappkotlin

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class FoundersBrief : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.founders_brief)

        // Get founder data from intent
        val founder = intent.getSerializableExtra("founderData", FounderDetails::class.java)

        // View references
        val img = findViewById<ImageView>(R.id.founder_img)
        val name = findViewById<TextView>(R.id.founder_heading)
        val desc = findViewById<TextView>(R.id.founder_desc)
//        val titleName = findViewById<TextView>(R.id.top_bar_name)
        val backBtn = findViewById<TextView>(R.id.back_button)

        // Populate data if not null
        founder?.let {
            img.setImageResource(it.imgId)
            name.text = it.name
//            titleName.text = it.name
            desc.text = it.desc
        }

        // Back button action
        backBtn.setOnClickListener {
            finish()
        }
    }
}
