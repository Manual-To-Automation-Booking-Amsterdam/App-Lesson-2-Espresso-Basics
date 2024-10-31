package com.example.lesson2_basictest


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class AlertTests {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun alertTests() {
        /*
        This will click the Alert Button on the Home screen of the app.
         */
        onView(withId(R.id.alertButton))
            .perform(click())

        /*
        This will click the Yes button in the dialog that appears, taking us to the
        Alert page
         */
        onView(withId(android.R.id.button1))
            .perform(click())

        /*
        This will verify that the text on the Alert Page is currently displayed,
        verifying that we have made it to the page
         */
        onView(withId(R.id.alertPageText))
            .check(matches(isDisplayed()))

        onView(withId(R.id.alertPageText))
            .check(matches(withText("You are on the Alert page!")))
    }
}
