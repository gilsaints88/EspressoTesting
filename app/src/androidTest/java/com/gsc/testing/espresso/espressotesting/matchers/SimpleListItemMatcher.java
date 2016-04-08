package com.gsc.testing.espresso.espressotesting.matchers;

import android.support.test.espresso.core.deps.guava.base.CharMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.Map;

import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;
import static org.hamcrest.core.IsEqual.equalTo;
//import static org.hamcrest.EasyMock2Matchers.equalTo;

/**
 * Created by Vergil Santos on 4/7/16.
 */
public class SimpleListItemMatcher {
    private SimpleListItemMatcher() {}

    public static Matcher<Object> withItemContent(String itemText) {
        checkNotNull(itemText);
        return withItemContent(equalTo(itemText));
    }

    public static Matcher<Object> withItemContent(final Matcher<String> itemTextMatcher) {
        checkNotNull(itemTextMatcher);

        return new TypeSafeMatcher<Object>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("expected text: " + itemTextMatcher);
            }

            @Override
            public void describeMismatchSafely(Object description, Description mismatchDescription) {
                mismatchDescription.appendText("actual text: " + description.toString());
            }

            @Override
            public boolean matchesSafely(Object item) {
                return itemTextMatcher.equals(item);
            }
        };
    }

}
