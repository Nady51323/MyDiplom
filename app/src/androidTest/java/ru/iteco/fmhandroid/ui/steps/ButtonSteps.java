package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screenElements.ClaimCreationScreen;
import ru.iteco.fmhandroid.ui.screenElements.ClaimsScreen;

public class ButtonSteps {

    public static void buttonОк() throws InterruptedException {

        Allure.step("Клик по кнопке 'ОК' c id:" + (android.R.id.button1));
        ClaimCreationScreen.okButton.check(matches(isDisplayed()));
        ClaimCreationScreen.okButton.perform(scrollTo(), click());

    }

    public static void buttonCancel() throws InterruptedException {

        Allure.step("Клик по кнопке 'Отмена' c id:" + (R.id.cancel_button));
        ClaimsScreen.cancelButton.check(matches(isDisplayed()));
        ClaimsScreen.cancelButton.perform(click());

    }

    public static void saveButton() throws InterruptedException {

        Allure.step("Клик по кнопке 'Сохранить' c id:" + (R.id.save_button));
        ClaimsScreen.saveButton.check(matches(isDisplayed()));
        ClaimsScreen.saveButton.perform(scrollTo(), click());

    }

    public static void throwOffButton() throws InterruptedException {

        Allure.step("Клик по кнопке 'Сбросить'");
        ClaimsScreen.throwOffStatusButton.check(matches(isDisplayed()));
        ClaimsScreen.throwOffStatusButton.perform(scrollTo(), click());
        Thread.sleep(2000);
    }



}
