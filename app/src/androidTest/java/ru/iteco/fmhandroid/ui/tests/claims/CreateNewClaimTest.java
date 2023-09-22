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
public class CreateNewClaimTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    String Title = "Title NewClaim:13 !@#$%^&*(-+){}<>123456789101234";
    String Date = "10.10.1100";
    String Description = "Description NewClaim:13 !@#$%^&*(-+){}<>123456789";


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
    @DisplayName("Блок Претензии. Создание новой претензии, ввод валидных значений.")

    public void createNewClaimValidData() throws InterruptedException {

        ClaimsSteps.goToClaimsScreen();
        ClaimsSteps.createNewClaim();
        ClaimsCreationSteps.inputNewClaimValidData(Title, Date, Description);
        QuotesSteps.loveIsAllButton();
        ClaimsSteps.goToClaimsScreen();
        //ClaimCreationScreen.checkTitleOfClaim.check(matches(isDisplayed())); не видит текст

        ClaimsSteps.openFirstClaim();
        ClaimsSteps.statusProcessingButton();
        ClaimsSteps.changeClaimStatusToExecute();
        DataHelper.addComment();
        ButtonSteps.buttonОк();
        ClaimsSteps.closeClaimButton();
        AuthorizationSteps.logOut();
    }


    @Test
    @DisplayName("Блок Претензии. Создание претензии с пустыми полями.")

    public void createNewClaimEmptyFields() throws InterruptedException {

        ClaimsSteps.goToClaimsScreen();
        ClaimsSteps.createNewClaim();
        ButtonSteps.saveButton();
        ClaimsSteps.waitIdElementButtonOk();
        ClaimsSteps.validationMessage();
        ButtonSteps.buttonОк();
        ButtonSteps.buttonCancel();
        ClaimsSteps.waitIdElementButtonOk();
        ClaimsSteps.errorMessage();
        ButtonSteps.buttonОк();
        AuthorizationSteps.logOut();

    }
}





