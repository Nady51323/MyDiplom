package ru.iteco.fmhandroid.ui.tests.authorization;


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
public class SuccessfulAuthorizationTests {

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);



    @Before

    public void waitElement() throws InterruptedException {

        AboutAppSteps.waitIdEnterButton();// предполагается, что мы не авторизованы

        try {
            AuthorizationSteps.isAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            AuthorizationSteps.logOut();
        }

    }

    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с валидными данными (латинские символы).")

    public void successfulAuthorizationTest() throws InterruptedException {

        DataHelper.logIn();
        AboutAppSteps.waitIdElementMenu();
        AuthorizationSteps.logOut();

    }

    @Test
    @DisplayName("Блок Авторизация. Выход из приложения.")

    public void logOutTest() throws InterruptedException {

        DataHelper.logIn();
        AuthorizationSteps.logOut();
        AuthorizationSteps.isAuthorizationScreen();

    }

}
