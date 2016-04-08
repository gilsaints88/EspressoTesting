package com.gsc.testing.espresso.espressotesting;

import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;

import com.gsc.testing.espresso.espressotesting.matchers.SimpleListItemMatcher;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Map;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Vergil Santos on 4/5/16.
 */
@RunWith(JUnit4.class)
public class ListViewActivityTest {
    @Rule
    public ActivityTestRule<AndroidListViewActivity> activityRule = new ActivityTestRule<>(AndroidListViewActivity.class);

    @Test
    public void displayListViewTest() {
//        SystemClock.sleep(4000);

//        onView(withText("Adobe Fireworks")).check(matches(isDisplayed())); // Check if "Adobe Fireworks" is currently displayed
//        onData(is("Adobe Fireworks")).check(matches(isDisplayed())); // Check if "Adobe Fireworks" is currently displayed



//        onView(withText("Adobe Fireworks")).perform(click()); // Perform click using onView
//        onData(is("Adobe Fireworks")).perform(click()); // Perform click using onData
        onData(SimpleListItemMatcher.withItemContent("Adobe Fireworks")).inAdapterView(withId(activityRule.getActivity().getListView().getId())).perform(click());


        SystemClock.sleep(4000);

        // Check the detail view
        onView(allOf(withId(R.id.product_label), withText("Adobe Fireworks"))).check(matches(isDisplayed()));
    }
}