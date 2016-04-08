package com.gsc.testing.espresso.espressotesting;

import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Vergil Santos on 4/4/16.
 */
@RunWith(JUnit4.class)
public class ScreenSlideActivityTest {
    @Rule
    public ActivityTestRule<ScreenSlideActivity> activityRule = new ActivityTestRule<>(ScreenSlideActivity.class);

    @Test
    public void slideViewPagerTest() {
        onView(withId(R.id.pager)).perform(swipeLeft());
        onView(withText("Step 2: Lorem Ipsum")).check(matches(isDisplayed()));

        SystemClock.sleep(6000);

        onView(withId(R.id.pager)).perform(swipeLeft());
        onView(withText("Step 2: Lorem Ipsum")).check(matches(isDisplayed())); // why does this still pass? "Step 2"
//        onView(withText("Step 3: Lorem Ipsum")).check(matches(isDisplayed())); // as expected, passes
//        onView(withText("Step 4: Lorem Ipsum")).check(matches(isDisplayed())); // as expected, fails
    }
}
