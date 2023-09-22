package ru.iteco.fmhandroid.ui.tests.ThematicQuotes;


import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.screenElements.QuotesScreen;
import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.QuotesSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ThematicQuotesTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);


    @Before
    public void waitElement() throws InterruptedException {

        AboutAppSteps.waitIdEnterButton(); // предполагается, что мы не авторизованы

        try {
            AuthorizationSteps.isAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            AuthorizationSteps.logOut();
        }

        DataHelper.logIn();
    }

    @Test
    @DisplayName("Блок Тематические цитаты.")
    @Description("Наличие и возможности просмотра цитат в блоке цитат о хосписе.")

    public void checkingForQuotesInBlockTest() throws InterruptedException {

        QuotesSteps.loveIsAllButton();
        QuotesScreen.checkTextLoveIsAll.check(matches(isDisplayed()));
        QuotesSteps.listRecyclerOurMission();
        QuotesSteps.listRecyclerOurMission();
        QuotesScreen.missionTitle.check(matches(isDisplayed()));
        AuthorizationSteps.logOut();
    }
}
