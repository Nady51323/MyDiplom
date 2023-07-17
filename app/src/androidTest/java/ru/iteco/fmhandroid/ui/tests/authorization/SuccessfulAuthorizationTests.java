package ru.iteco.fmhandroid.ui.tests.authorization;


import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ButtonSteps;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class SuccessfulAuthorizationTests {

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);


    @Before
    public void ThreadSleep() throws InterruptedException {
        Thread.sleep(7000);
    }

    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с валидными данными (латинские символы).")

    public void successfulAuthorizationTest() throws InterruptedException {

        AuthorizationSteps.logIn();
        AuthorizationSteps.verificationOfSuccessfulAuthorization();
        AuthorizationSteps.logOut();

    }

    @Test
    @DisplayName("Блок Авторизация. Выход из приложения.")

    public void logOutTest() throws InterruptedException {

        AuthorizationSteps.logIn();
        ButtonSteps.imageButtonLogOut();
        ButtonSteps.buttonLogOut();
        AuthorizationSteps.isAuthorizationScreen();

    }

}
