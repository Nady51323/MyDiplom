package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.utils.CustomViewActions.waitDisplayed;

import androidx.test.espresso.matcher.RootMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screenElements.ClaimCreationScreen;
import ru.iteco.fmhandroid.ui.screenElements.ClaimsScreen;

public class ClaimsCreationSteps {
    public static void inputNewClaimValidData(String Title, String Date, String Description) {

        Allure.step("Создание претензии, ввод валидных значений.");
        ClaimCreationScreen.titleTextInputOfClaim.perform(replaceText(Title));
        ClaimCreationScreen.titleTextInputOfClaim.check(matches(withText(Title)));
        ClaimsScreen.selectFromList.perform(click(), closeSoftKeyboard());
        ClaimCreationScreen.selectExecutorFromList.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        ClaimsSteps.waitIdElementExecutor();
        ClaimCreationScreen.dateOfClaim.perform(replaceText(Date));
        ClaimCreationScreen.dateOfClaim.check(matches(withText(Date)));
        ClaimCreationScreen.timeOfClaim.perform(click());
        ClaimCreationScreen.okButton.perform(scrollTo(), click());
        ClaimCreationScreen.descriptionTextInputOfClaim.perform(replaceText(Description));
        ClaimCreationScreen.descriptionTextInputOfClaim.check(matches(withText(Description)));
        ClaimCreationScreen.saveButton.perform(scrollTo(), click());
        ClaimsCreationSteps.waitIdElementListClaims();

    }

    public static void editClaim(String NewTitle, String NewDate, String NewTime, String NewDescription) throws InterruptedException {

        Allure.step("Редактирование претензии.");
        ClaimCreationScreen.titleTextInputOfClaim.perform(clearText());//очищаем название
        ClaimCreationScreen.titleTextInputOfClaim.perform(replaceText(NewTitle));
        ClaimCreationScreen.titleTextInputOfClaim.check(matches(withText(NewTitle)));

        ClaimsScreen.selectFromList.perform(click(), closeSoftKeyboard());
        ClaimCreationScreen.selectExecutorFromList.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        ClaimsSteps.waitIdElementExecutor(); //Thread.sleep(2000);

        ClaimCreationScreen.dateOfClaim.perform(clearText());
        ClaimCreationScreen.dateOfClaim.perform(replaceText(NewDate));
        ClaimCreationScreen.dateOfClaim.check(matches(withText(NewDate)));

        ClaimCreationScreen.timeOfClaim.perform(clearText());
        ClaimCreationScreen.timeOfClaim.perform(replaceText(NewTime));
        ClaimCreationScreen.timeOfClaim.check(matches(withText(NewTime)));

        ClaimCreationScreen.descriptionTextInputOfClaim.perform(clearText());
        ClaimCreationScreen.descriptionTextInputOfClaim.perform(replaceText(NewDescription));
        ClaimCreationScreen.descriptionTextInputOfClaim.check(matches(withText(NewDescription)));

        ClaimCreationScreen.saveButton.perform(scrollTo(), click());
        Thread.sleep(3000);

    }
    public static void waitIdElementListClaims() {
        Allure.step("Ожидание отображения списка претензий");
        onView(isRoot()).perform(waitDisplayed(R.id.all_claims_cards_block_constraint_layout, 7000));
    }


}
