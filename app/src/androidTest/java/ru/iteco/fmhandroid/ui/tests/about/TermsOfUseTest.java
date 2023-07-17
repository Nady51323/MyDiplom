package ru.iteco.fmhandroid.ui.tests.about;


import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class TermsOfUseTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void ThreadSleep() throws InterruptedException {
        Thread.sleep(7000);
    }


    @Test
    @DisplayName("Блок О приложении. Переход к пользовательскому соглашению.")

    public void goToTermsOfUse() throws InterruptedException {

        //AuthorizationSteps.logIn();
        AboutAppSteps.goToAboutScreen();
        AboutAppSteps.goToTermsOfUse();
        AboutAppSteps.checkTheSuccessfulTransitionToTermsOfUse();

    }

}
