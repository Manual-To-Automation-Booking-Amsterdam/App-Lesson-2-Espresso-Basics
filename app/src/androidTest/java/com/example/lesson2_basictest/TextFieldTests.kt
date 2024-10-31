package com.example.lesson2_basictest


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class TextFieldTests {

    var textToEnter = "Some text"

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun textFieldTests() {
        /*
        This will click on the Text Field button on the Home screen
         */
        onView(allOf(withId(R.id.textFieldButton), isDisplayed()))
            .perform(click())

        /*
        This will enter text in the text field
         */
        onView(allOf(withId(R.id.textField), isDisplayed()))
            .perform(replaceText(textToEnter), closeSoftKeyboard())

        /*
        This will click the Submit button to submit the text entered in the
        previous step
         */
        onView(allOf(withId(R.id.submitButton), isDisplayed()))
            .perform(click())

        /*
        This will verify that the text you entered previously is present in
        the label
         */
        onView(allOf(withId(R.id.enteredTextLabel), isDisplayed()))
            .check(matches(withText("Entered Text: $textToEnter")))
    }
}
