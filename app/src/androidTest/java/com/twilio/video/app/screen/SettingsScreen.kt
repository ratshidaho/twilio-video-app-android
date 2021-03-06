package com.twilio.video.app.screen

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.twilio.video.app.R
import com.twilio.video.app.util.getString
import com.twilio.video.app.util.retryEspressoAction

fun assertSettingsTitleIsVisible() {
    retryEspressoAction { onView(withText(getString(R.string.settings))).check(matches(isDisplayed())) }
}

fun logout() {
    onView(ViewMatchers.withId(androidx.preference.R.id.recycler_view))
            .perform(RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                    ViewMatchers.hasDescendant(withText(
                            getString(R.string.settings_screen_logout))), ViewActions.click()))
}