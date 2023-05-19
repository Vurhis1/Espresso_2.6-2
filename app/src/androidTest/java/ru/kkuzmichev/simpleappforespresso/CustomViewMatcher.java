package ru.kkuzmichev.simpleappforespresso;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Matcher;
import org.junit.runner.Description;

public class CustomViewMatcher {
    public static Matcher<View> recyclerViewSizeMatcher(int size) {
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            String result;

            @Override
            public void describeTo(org.hamcrest.Description description) {
                description.appendText("List size: " + size);
                description.appendText("\nGet:");
                description.appendText(result);
            }

            @Override
            protected boolean matchesSafely(RecyclerView item) {
                int items = item.getAdapter().getItemCount();
                result = "List size: " + items;
                return size == items;
            }
        };
    }
}
