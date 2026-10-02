package com.example.assignment01

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ReactionPickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reaction_picker)

        val dismissListener = View.OnClickListener { finish() }
        findViewById<View>(R.id.main)?.setOnClickListener(dismissListener)
        findViewById<View>(R.id.btnLike)?.setOnClickListener(dismissListener)
        findViewById<View>(R.id.btnLove)?.setOnClickListener(dismissListener)
        findViewById<View>(R.id.btnHaha)?.setOnClickListener(dismissListener)
        findViewById<View>(R.id.btnWow)?.setOnClickListener(dismissListener)
        findViewById<View>(R.id.btnSad)?.setOnClickListener(dismissListener)
        findViewById<View>(R.id.btnAngry)?.setOnClickListener(dismissListener)
    }
}