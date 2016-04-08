package com.gsc.testing.espresso.espressotesting;

import android.support.test.rule.ActivityTestRule;
import android.widget.Button;
import android.widget.Toolbar;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Vergil Santos on 3/28/16.
 */

@RunWith(JUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void displayMainActivity() {
//        onView(withText("Hello World!")).check(matches(isDisplayed()));
//        onView(withText("Hello World!")).check(doesNotExist());

//        onView(CoreMatchers.allOf(withId(R.id.btn_espresso_testing), withText("EspressoTesting"))).check(matches(isDisplayed()));
//        onView(CoreMatchers.allOf(isAssignableFrom(Button.class), withText("EspressoTesting"))).check(matches(isDisplayed()));
        onView(CoreMatchers.allOf(withParent(isAssignableFrom(Toolbar.class)), withText("EspressoTesting"))).check(matches(isDisplayed()));
    }
}
