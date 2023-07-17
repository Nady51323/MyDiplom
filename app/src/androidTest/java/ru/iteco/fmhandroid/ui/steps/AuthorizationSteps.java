package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;


public class AuthorizationSteps {

    public static void isAuthorizationScreen() {

        //проверка отображения окна авторизации

        ViewInteraction checkTextAuthorization = onView(
                anyOf(withText("Authorization"), withText("Авторизация")));
        checkTextAuthorization.check(matches(isDisplayed()));

        ViewInteraction checkTextHintLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        checkTextHintLogin.check(matches(isDisplayed()));

        ViewInteraction checkTextHintPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        checkTextHintPassword.check(matches(isDisplayed()));

        ViewInteraction checkTextButtonSignIn = onView(
                anyOf(withText("Sign in"), withText("Войти")));
        checkTextButtonSignIn.check(matches(isDisplayed()));

    }

    public static void logIn() throws InterruptedException {

        //авторизация

        AuthorizationSteps.isAuthorizationScreen();

        ViewInteraction loginInput = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        loginInput.perform(replaceText("login2"), closeSoftKeyboard());
        loginInput.check(matches(withText("login2")));

        ViewInteraction passwordInput = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        passwordInput.perform(replaceText("password2"), closeSoftKeyboard());
        passwordInput.check(matches(withText("password2")));

        ButtonSteps.signIn();
        Thread.sleep(2000);

    }


    public static void verificationOfSuccessfulAuthorization() {

        //проверка успешной авторизации

        ViewInteraction mainScreenVisibleNews = onView(
                allOf(withId(R.id.container_list_news_include_on_fragment_main)));
        mainScreenVisibleNews.check(matches(isDisplayed()));

        ViewInteraction mainScreenVisibleClaim = onView(
                allOf(withId(R.id.container_list_claim_include_on_fragment_main)));
        mainScreenVisibleClaim.check(matches(isDisplayed()));

    }

    public static void logOut() throws InterruptedException {

        //выход из приложения

        ButtonSteps.imageButtonLogOut();
        ButtonSteps.buttonLogOut();
        Thread.sleep(500);

    }
}


