package ru.iteco.fmhandroid.ui.tests.about;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class PrivacyPolicyTest {

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
    @DisplayName("Блок О приложении. Переход к политике конфиденциальности.")

    public void goToPrivacyPolicy() throws InterruptedException {

        AboutAppSteps.goToAboutScreen();
        AboutAppSteps.goToPrivacyPolicy();
        AboutAppSteps.checkTheSuccessfulTransitionToPrivacyPolicy();
    }


}
