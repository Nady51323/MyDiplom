package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.utils.CustomViewActions.waitDisplayed;

import android.content.Intent;

import androidx.test.espresso.intent.Intents;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screenElements.AboutAppScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;

public class AboutAppSteps {

    public static void goToAboutScreen() throws InterruptedException {

        Allure.step("Переход на экран 'О приложении'");
        MainScreen.mainMenuButton.perform(click());
        MainScreen.aboutOfMenu.check(matches(isDisplayed()));
        MainScreen.aboutOfMenu.perform(click());

    }

    public static void goToPrivacyPolicy() throws InterruptedException {

        Allure.step("Переход к политике конфиденциальности");
        Intents.init();
        AboutAppScreen.privacyPolicyValue.perform(click());

    }

    public static void goToTermsOfUse() throws InterruptedException {

        Allure.step("Переход к пользовательскому соглашению");
        Intents.init();
        AboutAppScreen.termsOfUseValue.perform(click());

    }


    public static void checkTheSuccessfulTransitionToPrivacyPolicy() throws InterruptedException {

        Allure.step("Проверка перехода на сайт с политикой конфиденциальности");
        intended(hasData("https://vhospice.org/#/privacy-policy/"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();

    }

    public static void checkTheSuccessfulTransitionToTermsOfUse() {

        Allure.step("Проверка перехода на сайт с пользовательским соглашением");
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
    }

    public static void waitIdEnterButton() {
        Allure.step("Ожидание отображения кнопки 'вход из приложение'");
        onView(isRoot()).perform(waitDisplayed(R.id.enter_button, 10000));

    }

    public static void waitIdElementMenu() {
        Allure.step("Ожидание отображения кнопки 'Меню'");
        onView(isRoot()).perform(waitDisplayed( R.id.main_menu_image_button, 10000));
    }


}

