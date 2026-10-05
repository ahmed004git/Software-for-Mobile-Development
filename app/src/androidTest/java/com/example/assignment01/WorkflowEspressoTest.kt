package com.example.assignment01

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WorkflowEspressoTest {

    @Test
    fun testLoginToHomeToCommentsAndBackToHome() {
        ActivityScenario.launch(LogIn_Page::class.java).use {
            onView(withId(R.id.btnLogin)).perform(click())
            onView(withId(R.id.btnComment)).check(matches(isDisplayed()))
            onView(withId(R.id.btnComment)).perform(click())
            onView(withId(R.id.etCommentInput)).check(matches(isDisplayed()))
            onView(withId(R.id.btnBack)).perform(click())
            onView(withId(R.id.btnComment)).check(matches(isDisplayed()))
        }
    }

    @Test
    fun testLoginToMenuAndLogout() {
        ActivityScenario.launch(LogIn_Page::class.java).use {
            onView(withId(R.id.btnLogin)).perform(click())

            onView(withId(R.id.tab_menu)).perform(click())

            onView(withId(R.id.btnLogout)).check(matches(isDisplayed()))
            onView(withId(R.id.btnLogout)).perform(click())
            onView(withId(R.id.btnLogin)).check(matches(isDisplayed()))
        }
    }
}