package ru.iteco.fmhandroid.ui.tests.claims;


import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

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
import ru.iteco.fmhandroid.ui.data.TestData;
import ru.iteco.fmhandroid.ui.screenElements.ClaimCreationScreen;
import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ButtonSteps;
import ru.iteco.fmhandroid.ui.steps.ClaimsCreationSteps;
import ru.iteco.fmhandroid.ui.steps.ClaimsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class CreateNewClaimTest {


    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    String Login = TestData.ValidLogin;
    String Password = TestData.ValidPassword;
    String Title = TestData.TITLE;
    String Date = TestData.DATE;
    String Description = TestData.DESCRIPTION;


    @Before

    public void waitElement() throws InterruptedException {

        try {
            AboutAppSteps.waitIdElementMenu();
        } catch (NoMatchingViewException e) {
            AuthorizationSteps.isAuthorizationScreen();
            AuthorizationSteps.logIn(Login, Password);
        }
    }

    @Test
    @DisplayName("Блок Претензии. Создание новой претензии, ввод валидных значений.")

    public void createNewClaimValidData() throws InterruptedException {

        ClaimsSteps.goToClaimsScreen();
        ClaimsSteps.createNewClaim();
        ClaimsCreationSteps.inputNewClaimValidData(Title, Date, Description);
        ClaimCreationScreen.checkTitleOfClaim.check(matches(isDisplayed()));
    }



    @Test
    @DisplayName("Блок Претензии. Создание претензии с пустыми полями.")

    public void createNewClaimEmptyFields() throws InterruptedException {

        ClaimsSteps.goToClaimsScreen();
        ClaimsSteps.createNewClaim();
        ButtonSteps.saveButton();
        ClaimsSteps.validationMessage();
        ButtonSteps.buttonОк();
        ButtonSteps.buttonCancel();
        ClaimsSteps.errorMessage();
        ButtonSteps.buttonОк();

    }
}





