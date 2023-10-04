package ru.iteco.fmhandroid.ui.screenElements;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthorizationScreen {

    public static ViewInteraction checkTextAuthorization = onView(withText("Authorization"));
    public static ViewInteraction loginInput = onView(withHint("Login"));
    public static ViewInteraction passwordInput = onView(withHint("Password"));
    public static ViewInteraction enterButton = onView(withId(R.id.enter_button));
    public static ViewInteraction mainScreenVisibleNews = onView(withId(R.id.container_list_news_include_on_fragment_main));
    public static ViewInteraction mainScreenVisibleClaim = onView(withId(R.id.container_list_claim_include_on_fragment_main));

}
