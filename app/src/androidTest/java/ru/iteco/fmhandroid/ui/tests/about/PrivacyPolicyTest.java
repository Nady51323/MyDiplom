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
import ru.iteco.fmhandroid.ui.data.TestData;
import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class PrivacyPolicyTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    String Login = TestData.ValidLogin;
    String Password = TestData.ValidPassword;

    @Before

    public void waitElement() throws InterruptedException {


        try {
            AboutAppSteps.waitIdElementMenu();

        } catch (NoMatchingViewException e) {
            AuthorizationSteps.isAuthorizationScreen();
            AuthorizationSteps.logIn(Login, Password);
        }

    }



    @Test
    @DisplayName("Блок О приложении. Переход к политике конфиденциальности.")

    public void goToPrivacyPolicy() throws InterruptedException {

        AboutAppSteps.goToAboutScreen();
        AboutAppSteps.goToPrivacyPolicy();
        AboutAppSteps.checkTheSuccessfulTransitionToPrivacyPolicy();
    }


}
