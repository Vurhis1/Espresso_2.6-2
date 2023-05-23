package ru.kkuzmichev.simpleappforespresso;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.ViewAssertion;

public class CustomViewAssertions {
    public static ViewAssertion isRecyclerView() {
        return (view, noViewFoundException) -> {
            if (!(view instanceof RecyclerView))
                throw new IllegalStateException("Это не RecyclerView");
        };
    }
}
