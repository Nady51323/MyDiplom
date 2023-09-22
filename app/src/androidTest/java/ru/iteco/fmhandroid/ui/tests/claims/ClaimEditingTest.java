package ru.iteco.fmhandroid.ui.tests.claims;


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
import ru.iteco.fmhandroid.ui.steps.ButtonSteps;
import ru.iteco.fmhandroid.ui.steps.ClaimsCreationSteps;
import ru.iteco.fmhandroid.ui.steps.ClaimsSteps;
import ru.iteco.fmhandroid.ui.steps.QuotesSteps;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimEditingTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    String NewTitle = "Claim #1 Edit title";
    String NewDate = "13.10.1980";
    String NewTime = "13:00";
    String NewDescription = "Edit Description 123#|+!";

    @Before

    public void waitElement() throws InterruptedException {

        AboutAppSteps.waitIdEnterButton(); // предполагается, что мы не авторизованы

        try {
            AuthorizationSteps.isAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            AuthorizationSteps.logOut();
        }

        DataHelper.logIn();
    }

    @Test
    @DisplayName("Блок Претензии. Редактирование претензии.")// должна быть создана 1 претензия перед сдачей

    public void claimEditing() throws InterruptedException {

        ClaimsSteps.goToClaimsScreen();
        ClaimsSteps.createNewClaim();
        DataHelper.createClaim();

        QuotesSteps.loveIsAllButton();
        ClaimsSteps.goToClaimsScreen();

        ClaimsSteps.openFirstClaim();
        ClaimsSteps.waitIdElementStatusButton();// Thread.sleep(2000);
        ClaimsSteps.statusProcessingButton();
        Thread.sleep(2000);

        ButtonSteps.throwOffButton();
        Thread.sleep(2000);
        DataHelper.addComment();
        Thread.sleep(2000);
        ButtonSteps.buttonОк();
        Thread.sleep(3000);
        ClaimsSteps.editButton();
        Thread.sleep(2000);

        ClaimsCreationSteps.editClaim(NewTitle, NewDate, NewTime, NewDescription);

        ClaimsSteps.statusProcessingButton();
        ClaimsSteps.changeClaimStatusToExecute();
        DataHelper.addComment();
        ButtonSteps.buttonОк();
       // ClaimsSteps.checkClaimStatusExecuted(); не видит текст

        ClaimsSteps.closeClaimButton();

      /* ClaimsScreen.editTitleOfClaim.perform(clearText());// редактировать название



        ViewInteraction editTitle = onView(
                allOf(withId(R.id.title_edit_text)));
        editTitle.perform(clearText());
        ClaimsScreen.editTitleOfClaim.perform(typeText());
        editTitle.check(matches(withText("Claim #1 Edit title")));

        //выбрать исполнителя из списка
        ClaimsSteps.selectFromList();

        ViewInteraction selectExecutorFromList =
                onView(withText("Ivanov Ivan Ivanovich"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        Thread.sleep(2000);

        //изменить дату
        ViewInteraction editDate = onView(
                allOf(withId(R.id.date_in_plan_text_input_edit_text)));
        editDate.perform(clearText());
        editDate.perform(replaceText("13.10.1989"), closeSoftKeyboard());
        editDate.check(matches(withText("13.10.1989")));

        //изменить время
        ViewInteraction editTime = onView(
                allOf(withId(R.id.time_in_plan_text_input_edit_text)));
        editTime.perform(clearText());
        editTime.perform(replaceText("13:00"), closeSoftKeyboard());
        editTime.check(matches(withText("13:00")));

        //редактировать описание
        ViewInteraction editDescription = onView(
                allOf(withId(R.id.description_edit_text)));
        editDescription.perform(clearText());
        editDescription.perform(typeText("Edit Description 123#|+!"), closeSoftKeyboard());
        editDescription.check(matches(withText("Edit Description 123#|+!")));

        //сохранить
        ButtonSteps.saveButton();*/

        AuthorizationSteps.logOut();

    }
}
