package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

//import static ru.iteco.fmhandroid.utils.CustomViewActions.waitId;

import static ru.iteco.fmhandroid.utils.CustomViewActions.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;


public class AuthorizationSteps {

    public static void isAuthorizationScreen() {

        Allure.step("Проверка отображения окна авторизации");
        AuthorizationScreen.checkTextAuthorization.check(matches(isDisplayed()));
        AboutAppSteps.waitIdEnterButton();
    }

    public static void signIn() throws InterruptedException {

        Allure.step("Кликнуть на кнопку 'Войти'");
        AuthorizationScreen.enterButton.perform(click());
        AuthorizationSteps.waitIdElement();

    }

    public static void logIn(String login, String password) throws InterruptedException {

        Allure.step("Авторизация (вход в личный кабинет)");
        AuthorizationScreen.loginInput.perform(replaceText(login));
        AuthorizationScreen.loginInput.check(matches(withText(login)));
        AuthorizationScreen.passwordInput.perform(replaceText(password));
        AuthorizationScreen.passwordInput.check(matches(withText(password)));
        AuthorizationScreen.enterButton.perform(click());

    }


    public static void verificationOfSuccessfulAuthorization() {

        Allure.step("Проверка успешной авторизации");
        AuthorizationScreen.mainScreenVisibleNews.check(matches(isDisplayed()));
        AuthorizationScreen.mainScreenVisibleClaim.check(matches(isDisplayed()));


    }

    public static void logOut() throws InterruptedException {

        Allure.step("Выход из личного кабинета");
        MainScreen.clickImageButtonLogOut.perform(click());
        MainScreen.logOutButton.check(matches(isDisplayed()));
        MainScreen.logOutButton.perform(click());
        AboutAppSteps.waitIdEnterButton();

    }

    public static void waitIdElement() {
        Allure.step("Проверка отображения кнопки авторизации");
        onView(isRoot()).perform(waitDisplayed(R.id.enter_button, 7000));
    }

    public static void waitIdElementListNews() {
        Allure.step("Ожидание отображения контейнера новостей");
        onView(isRoot()).perform(waitDisplayed(R.id.container_list_news_include_on_fragment_main, 7000));
    }
}


