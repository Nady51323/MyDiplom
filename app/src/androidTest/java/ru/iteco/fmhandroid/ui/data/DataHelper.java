package ru.iteco.fmhandroid.ui.data;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.matcher.RootMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.screenElements.ClaimCreationScreen;
import ru.iteco.fmhandroid.ui.screenElements.ClaimsScreen;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;


public class DataHelper {

    public static void logIn() throws InterruptedException {
        //авторизация
        Allure.step("Авторизация. Валидные данные.");
        AuthorizationScreen.loginInput.perform(replaceText("login2"), closeSoftKeyboard());
        AuthorizationScreen.loginInput.check(matches(withText("login2")));
        AuthorizationScreen.passwordInput.perform(replaceText("password2"), closeSoftKeyboard());
        AuthorizationScreen.passwordInput.check(matches(withText("password2")));
        AuthorizationScreen.enterButton.perform(click());
        AuthorizationSteps.waitIdElementListNews();


    }

    public static void createClaim() throws InterruptedException {

        Allure.step("Создание претензии. Валидные данные.");
        ClaimCreationScreen.titleTextInputOfClaim.perform(replaceText("Title NewClaim:13"));
        ClaimsScreen.selectFromList.perform(click(), closeSoftKeyboard());
        ClaimCreationScreen.selectExecutorFromList.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        ClaimCreationScreen.dateOfClaim.perform(replaceText("20.06.1100"));
        ClaimCreationScreen.timeOfClaim.perform(click());
        ClaimCreationScreen.okButton.perform(scrollTo(), click());
        ClaimCreationScreen.descriptionTextInputOfClaim.perform(replaceText("Description NewClaim:13"));
        ClaimCreationScreen.saveButton.perform(scrollTo(), click());
        Thread.sleep(2000);

    }

    public static void addComment() {

        Allure.step("Добавление текста комментария.");
        ClaimsScreen.addComment.check(matches(isDisplayed()));
        ClaimsScreen.addComment.perform(typeText("Add comment :13@#$%()&"));
    }

}
