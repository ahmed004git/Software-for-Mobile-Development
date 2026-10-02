package com.example.assignment01

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        TopNavHelper.setupTopNav(this, NavTab.HOME)

        findViewById<View>(R.id.btnSearch)?.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        findViewById<View>(R.id.btnChat)?.setOnClickListener {
            startActivity(Intent(this, ChatsActivity::class.java))
        }

        val navigateToCreatePost = View.OnClickListener {
            startActivity(Intent(this, CreatePostActivity::class.java))
        }
        findViewById<View>(R.id.layoutCreatePost)?.setOnClickListener(navigateToCreatePost)
        findViewById<View>(R.id.tvWhatsOnYourMind)?.setOnClickListener(navigateToCreatePost)

        findViewById<View>(R.id.btnCreateStory)?.setOnClickListener {
            startActivity(Intent(this, CameraActivity::class.java))
        }

        val navigateToStoryViewer = View.OnClickListener {
            startActivity(Intent(this, StoryViewerActivity::class.java))
        }
        findViewById<View>(R.id.storyItem1)?.setOnClickListener(navigateToStoryViewer)
        findViewById<View>(R.id.storyItem2)?.setOnClickListener(navigateToStoryViewer)

        val navigateToProfile = View.OnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
        findViewById<View>(R.id.ivProfileAvatar)?.setOnClickListener(navigateToProfile)
        findViewById<View>(R.id.postUserAvatar)?.setOnClickListener(navigateToProfile)
        findViewById<View>(R.id.postUserName)?.setOnClickListener(navigateToProfile)

        findViewById<View>(R.id.btnReaction)?.setOnClickListener {
            startActivity(Intent(this, ReactionPickerActivity::class.java))
        }

        findViewById<View>(R.id.btnComment)?.setOnClickListener {
            startActivity(Intent(this, CommentsActivity::class.java))
        }
    }
}