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
import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationWithInvalidDataTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    String validLogin = "login2";
    String validPassword = "password2";
    String wrongLogin1 = "login28*-/";
    String wrongLogin2 = "   login2";
    String wrongLogin3 = "login2     ";
    String wrongLogin4 = "Login2";
    String wrongLogin5 = "   ";
    String wrongPassword1 = "qwerty123";
    String wrongPassword2 = "Password2";

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
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Некорректный логин,корректный пароль")

    public void enterWrongLoginCorrectPassword() throws InterruptedException {

        AuthorizationSteps.logIn(wrongLogin1,validPassword);
        AuthorizationSteps.isAuthorizationScreen();

    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Корректный логин, начинающийся с пробелов,корректный пароль.")

    public void spaceAtStartOfLogin() throws InterruptedException {

        AuthorizationSteps.logIn(wrongLogin2,validPassword);
        AuthorizationSteps.isAuthorizationScreen();

        // ОР: вход в приложение не выполнен.

        //ФР: Осуществлен вход в приложение. Баг.


    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Корректный логин в поле пароль, корректный пароль в поле логин.")

    public void swapCorrectLoginPassword() throws InterruptedException {

        AuthorizationSteps.logIn(validPassword,validLogin);
        AuthorizationSteps.isAuthorizationScreen();

    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Корректный логин, некорректный пароль.")

    public void enterCorrectLoginWrongPassword() throws InterruptedException {

        AuthorizationSteps.logIn(validLogin,wrongPassword1);
        AuthorizationSteps.isAuthorizationScreen();
    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Корректный логин, заканчивающийся на пробелы,корректный пароль.")

    public void spaceAfterLogin() throws InterruptedException {

        AuthorizationSteps.logIn(wrongLogin3,validPassword);
        AuthorizationSteps.isAuthorizationScreen();

        // ОР: вход в приложение не выполнен.

        //ФР: Осуществлен вход в приложение. Баг.
        //AuthorizationSteps.logOut(); удалить!?

    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Логин и пароль с заглавной буквы.")

    public void loginPasswordCapitalized() throws InterruptedException {

        AuthorizationSteps.logIn(wrongLogin4,wrongPassword2);
        AuthorizationSteps.isAuthorizationScreen();

    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Пробелы в поле логин,корректный пароль.")

    public void spaceInLogin() throws InterruptedException {

        AuthorizationSteps.logIn(wrongLogin5,validPassword);
        AuthorizationSteps.isAuthorizationScreen();

    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с пустыми полями.")

    public void inputWithEmptyFields() throws InterruptedException {

        AuthorizationSteps.signIn();
        AuthorizationSteps.isAuthorizationScreen();

    }

}
