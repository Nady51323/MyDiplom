package ru.iteco.fmhandroid.ui.tests.authorization;


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
import ru.iteco.fmhandroid.ui.data.TestData;
import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationWithInvalidDataTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    String Login = TestData.ValidLogin;
    String Password = TestData.ValidPassword;
    String WrongLogin1 = TestData.WrongLogin1;
    String WrongLogin2 = TestData.WrongLogin2;
    String WrongLogin3 = TestData.WrongLogin3;
    String WrongLogin4 = TestData.WrongLogin4;
    String WrongLogin5 =  TestData.WrongLogin5;
    String WrongPassword1 = TestData.WrongPassword1;
    String WrongPassword2 =  TestData.WrongPassword2;

    @Before

    public void waitElement() throws InterruptedException {

        try {
            AboutAppSteps.waitIdEnterButton();
        } catch (NoMatchingViewException e) {
            AboutAppSteps.waitIdElementMenu();
            AuthorizationSteps.logOut();
        }

    }

    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Некорректный логин,корректный пароль")

    public void enterWrongLoginCorrectPassword() throws InterruptedException {

        AuthorizationSteps.logIn(WrongLogin1,Password);
        AuthorizationSteps.isAuthorizationScreen();

    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Корректный логин, начинающийся с пробелов,корректный пароль.")

    public void spaceAtStartOfLogin() throws InterruptedException {

        AuthorizationSteps.logIn(WrongLogin2,Password);
        AboutAppSteps.waitIdEnterButton();
        AuthorizationSteps.isAuthorizationScreen();

    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Корректный логин в поле пароль, корректный пароль в поле логин.")

    public void swapCorrectLoginPassword() throws InterruptedException {

        AuthorizationSteps.logIn(Password,Login);
        AuthorizationSteps.isAuthorizationScreen();

    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Корректный логин, некорректный пароль.")

    public void enterCorrectLoginWrongPassword() throws InterruptedException {

        AuthorizationSteps.logIn(Login,WrongPassword1);
        AuthorizationSteps.isAuthorizationScreen();
    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Корректный логин, заканчивающийся на пробелы,корректный пароль.")

    public void spaceAfterLogin() throws InterruptedException {

        AuthorizationSteps.logIn(WrongLogin3,Password);
        AboutAppSteps.waitIdEnterButton();
        AuthorizationSteps.isAuthorizationScreen();

    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Логин и пароль с заглавной буквы.")

    public void loginPasswordCapitalized() throws InterruptedException {

        AuthorizationSteps.logIn(WrongLogin4,WrongPassword2);
        AuthorizationSteps.isAuthorizationScreen();

    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Пробелы в поле логин,корректный пароль.")

    public void spaceInLogin() throws InterruptedException {

        AuthorizationSteps.logIn(WrongLogin5,Password);
        AuthorizationSteps.isAuthorizationScreen();

    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с пустыми полями.")

    public void inputWithEmptyFields() throws InterruptedException {

        AuthorizationSteps.signIn();
        AuthorizationSteps.isAuthorizationScreen();

    }

}
