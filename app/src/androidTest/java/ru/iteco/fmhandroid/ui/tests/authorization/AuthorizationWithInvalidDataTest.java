package ru.iteco.fmhandroid.ui.tests.authorization;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;
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
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ButtonSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationWithInvalidDataTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void ThreadSleep() throws InterruptedException {
        Thread.sleep(7000);
    }

    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Некорректный логин,корректный пароль")

    public void enterWrongLoginCorrectPassword() throws InterruptedException {

        ViewInteraction inputWrongLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        inputWrongLogin.check(matches(isDisplayed()));
        inputWrongLogin.perform(typeText("login28*-/"), closeSoftKeyboard());
        inputWrongLogin.check(matches(withText("login28*-/")));


        ViewInteraction inputCorrectPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        inputCorrectPassword.check(matches(isDisplayed()));
        inputCorrectPassword.perform(typeText("password2"), closeSoftKeyboard());
        inputCorrectPassword.check(matches(withText("password2")));

        ButtonSteps.signIn();
        AuthorizationSteps.isAuthorizationScreen();

    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Корректный логин, начинающийся с пробелов,корректный пароль.")

    public void spaceAtStartOfLogin() throws InterruptedException {

        ViewInteraction enterSpaceAtStartOfLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        enterSpaceAtStartOfLogin.check(matches(isDisplayed()));
        enterSpaceAtStartOfLogin.perform(typeText("   login2"), closeSoftKeyboard());
        enterSpaceAtStartOfLogin.check(matches(withText("   login2")));


        ViewInteraction enterCorrectInPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        enterCorrectInPassword.check(matches(isDisplayed()));
        enterCorrectInPassword.perform(typeText("password2"), closeSoftKeyboard());
        enterCorrectInPassword.check(matches(withText("password2")));

        ButtonSteps.signIn();

        // ОР: вход в приложение не выполнен.
        AuthorizationSteps.isAuthorizationScreen();

        //ФР: Осуществлен вход в приложение. Баг.
        //AuthorizationSteps.logOut(); удалить!?

    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Корректный логин в поле пароль, корректный пароль в поле логин.")

    public void swapCorrectLoginPassword() throws InterruptedException {

        AuthorizationSteps.logOut();

        ViewInteraction inputPasswordInLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        inputPasswordInLogin.check(matches(isDisplayed()));
        inputPasswordInLogin.perform(typeText("password2"), closeSoftKeyboard());
        inputPasswordInLogin.check(matches(withText("password2")));


        ViewInteraction inputLoginInPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        inputLoginInPassword.check(matches(isDisplayed()));
        inputLoginInPassword.perform(typeText("login2"), closeSoftKeyboard());
        inputLoginInPassword.check(matches(withText("login2")));

        ButtonSteps.signIn();
        AuthorizationSteps.isAuthorizationScreen();

    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Корректный логин, некорректный пароль.")

    public void enterCorrectLoginWrongPassword() throws InterruptedException {

        ViewInteraction inputCorrectLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        inputCorrectLogin.check(matches(isDisplayed()));
        inputCorrectLogin.perform(typeText("login2"), closeSoftKeyboard());
        inputCorrectLogin.check(matches(withText("login2")));


        ViewInteraction inputWrongPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        inputWrongPassword.check(matches(isDisplayed()));
        inputWrongPassword.perform(typeText("qwerty123"), closeSoftKeyboard());
        inputWrongPassword.check(matches(withText("qwerty123")));

        ButtonSteps.signIn();

        // вход в приложение не выполнен.
        AuthorizationSteps.isAuthorizationScreen();
    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Корректный логин, заканчивающийся на пробелы,корректный пароль.")

    public void spaceAfterLogin() throws InterruptedException {

       // AuthorizationSteps.logOut();
        // Thread.sleep(3000);

        ViewInteraction enterSpaceAtStartOfLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        enterSpaceAtStartOfLogin.check(matches(isDisplayed()));
        enterSpaceAtStartOfLogin.perform(typeText("login2     "), closeSoftKeyboard());
        enterSpaceAtStartOfLogin.check(matches(withText("login2     ")));


        ViewInteraction enterCorrectInPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        enterCorrectInPassword.check(matches(isDisplayed()));
        enterCorrectInPassword.perform(typeText("password2"), closeSoftKeyboard());
        enterCorrectInPassword.check(matches(withText("password2")));

        ButtonSteps.signIn();

        // ОР: вход в приложение не выполнен.
        AuthorizationSteps.isAuthorizationScreen();

        //ФР: Осуществлен вход в приложение. Баг.
        //AuthorizationSteps.logOut(); удалить!?

    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Логин и пароль с заглавной буквы.")

    public void loginPasswordCapitalized() throws InterruptedException {

        AuthorizationSteps.logOut();

        ViewInteraction enterLoginWithCapitalLetter = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        enterLoginWithCapitalLetter.check(matches(isDisplayed()));
        enterLoginWithCapitalLetter.perform(typeText("Login2"), closeSoftKeyboard());
        enterLoginWithCapitalLetter.check(matches(withText("Login2")));


        ViewInteraction enterPasswordWithCapitalLetter = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        enterPasswordWithCapitalLetter.check(matches(isDisplayed()));
        enterPasswordWithCapitalLetter.perform(typeText("Password2"), closeSoftKeyboard());
        enterPasswordWithCapitalLetter.check(matches(withText("Password2")));

        ButtonSteps.signIn();
        AuthorizationSteps.isAuthorizationScreen();

    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с невалидными данными.")
    @Description("Пробелы в поле логин,корректный пароль.")

    public void spaceInLogin() throws InterruptedException {

        ViewInteraction enterSpaceInLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        enterSpaceInLogin.check(matches(isDisplayed()));
        enterSpaceInLogin.perform(typeText("   "), closeSoftKeyboard());
        enterSpaceInLogin.check(matches(withText("   ")));


        ViewInteraction enterCorrectInPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        enterCorrectInPassword.check(matches(isDisplayed()));
        enterCorrectInPassword.perform(typeText("password2"), closeSoftKeyboard());
        enterCorrectInPassword.check(matches(withText("password2")));

        ButtonSteps.signIn();
        AuthorizationSteps.isAuthorizationScreen();

    }


    @Test
    @DisplayName("Блок Авторизация. Вход в личный кабинет с пустыми полями.")

    public void inputWithEmptyFields() throws InterruptedException {

        ViewInteraction emptyFieldLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        emptyFieldLogin.check(matches(isDisplayed()));
        emptyFieldLogin.perform(typeText(""), closeSoftKeyboard());
        emptyFieldLogin.check(matches(withText("")));


        ViewInteraction emptyFieldPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        emptyFieldPassword.check(matches(isDisplayed()));
        emptyFieldPassword.perform(typeText(""), closeSoftKeyboard());
        emptyFieldPassword.check(matches(withText("")));

        ButtonSteps.signIn();
        AuthorizationSteps.isAuthorizationScreen();

    }

}
