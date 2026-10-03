package com.example.assignment01

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class CameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_camera)

        findViewById<View>(R.id.btnBack)?.setOnClickListener { finish() }

        findViewById<View>(R.id.btnShutter)?.setOnClickListener {
            startActivity(Intent(this, StoryEditorActivity::class.java))
            finish()
        }
    }
}