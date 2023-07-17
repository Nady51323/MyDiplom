package ru.iteco.fmhandroid.ui.tests.ThematicQuotes;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ButtonSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ThematicQuotesTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);


    @Before
    public void ThreadSleep() throws InterruptedException {
        Thread.sleep(7000);

        AuthorizationSteps.logIn();
    }

    @Test
    @DisplayName("Блок Тематические цитаты.")
    @Description("Наличие и возможности просмотра цитат в блоке цитат о хосписе.")

    public void checkingForQuotesInBlockTest() throws InterruptedException {

        ButtonSteps.buttonLoveIsAll();

        ViewInteraction checkTextLoveIsAll = onView(
                anyOf(withText("Love is all"), withText("Главное - жить любя")));
        checkTextLoveIsAll.check(matches(isDisplayed()));

        ButtonSteps.listRecyclerOurMission();
        ButtonSteps.listRecyclerOurMission();

        ViewInteraction checkTextID = onView(
                allOf(withId(R.id.our_mission_title_text_view)));
        checkTextID.check(matches(isDisplayed()));

        AuthorizationSteps.logOut();
    }
}
