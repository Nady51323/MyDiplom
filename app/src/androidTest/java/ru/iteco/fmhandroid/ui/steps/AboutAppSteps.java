package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import android.content.Intent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.Intents;

import ru.iteco.fmhandroid.R;

public class AboutAppSteps {

    public static void goToAboutScreen() throws InterruptedException {

        //переход на экран о приложении

        ViewInteraction clickMainMenuButton = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenuButton.check(matches(isDisplayed()));
        clickMainMenuButton.perform(click());
        Thread.sleep(500);

        ViewInteraction clickAbout = onView(
                anyOf(withText("About"), withText("О приложении")));
        clickAbout.check(matches(isDisplayed()));
        clickAbout.perform(click());
        Thread.sleep(500);

    }

    public static void goToPrivacyPolicy() throws InterruptedException {

        ViewInteraction checkTextPrivacyPolicy = onView(
                allOf(withId(R.id.about_privacy_policy_label_text_view)));
        checkTextPrivacyPolicy.check(matches(isDisplayed()));

        ViewInteraction privacyPolicyValue = onView(
                allOf(withId(R.id.about_privacy_policy_value_text_view)));
        privacyPolicyValue.check(matches(isDisplayed()));

        Intents.init();
        privacyPolicyValue.perform(click());

    }

    public static void goToTermsOfUse() throws InterruptedException {

        ViewInteraction checkTextTermsOfUse = onView(
                allOf(withId(R.id.about_terms_of_use_label_text_view)));
        checkTextTermsOfUse.check(matches(isDisplayed()));

        ViewInteraction termsOfUseValue = onView(
                allOf(withId(R.id.about_terms_of_use_value_text_view)));
        termsOfUseValue.check(matches(isDisplayed()));

        Intents.init();
        termsOfUseValue.perform(click());

    }


    public static void checkTheSuccessfulTransitionToPrivacyPolicy() {

        // проверка перехода на сайт с политикой конфиденциальности

        intended(hasData("https://vhospice.org/#/privacy-policy/"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();

    }

    public static void checkTheSuccessfulTransitionToTermsOfUse() {

        // проверка перехода на сайт с пользовательским соглашением

        intended(hasData("https://vhospice.org/#/terms-of-use"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
    }

}

