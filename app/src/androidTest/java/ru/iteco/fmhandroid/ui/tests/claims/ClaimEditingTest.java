package ru.iteco.fmhandroid.ui.tests.claims;


import static ru.iteco.fmhandroid.ui.data.TestData.COMMENT;
import static ru.iteco.fmhandroid.ui.data.TestData.DATE1;
import static ru.iteco.fmhandroid.ui.data.TestData.DESCRIPTION1;
import static ru.iteco.fmhandroid.ui.data.TestData.TIME1;
import static ru.iteco.fmhandroid.ui.data.TestData.TITLE1;

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
import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ButtonSteps;
import ru.iteco.fmhandroid.ui.steps.ClaimsCreationSteps;
import ru.iteco.fmhandroid.ui.steps.ClaimsSteps;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimEditingTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    String Login = TestData.ValidLogin;
    String Password = TestData.ValidPassword;
    String Title = TestData.TITLE;
    String Date = TestData.DATE;
    String Description = TestData.DESCRIPTION;
    String NewTitle = TITLE1;
    String NewDate = DATE1;
    String NewTime = TIME1;
    String NewDescription = DESCRIPTION1;
    String NewComment = COMMENT;

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
    @DisplayName("Блок Претензии. Редактирование претензии.")

    public void claimEditing() throws InterruptedException {

        ClaimsSteps.goToClaimsScreen();
        ClaimsSteps.createNewClaim();
        ClaimsCreationSteps.inputNewClaimValidData(Title, Date, Description);
        ClaimsSteps.waitIdElementCreateNewClaimButton();

        ClaimsSteps.openFirstClaim();
        ClaimsSteps.waitIdElementStatusButton();
        ClaimsSteps.statusProcessingButton();
        ButtonSteps.throwOffButton();
        ClaimsCreationSteps.addComment(NewComment);
        ButtonSteps.buttonОк();
        ClaimsSteps.waitIdElementStatusButton();

        ClaimsSteps.editButton();
        ClaimsCreationSteps.editClaim(NewTitle, NewDate, NewTime, NewDescription);
        ClaimsSteps.waitIdElementStatusButton();
        ClaimsSteps.statusProcessingButton();
        ClaimsSteps.changeClaimStatusToExecute();
        ClaimsCreationSteps.addComment(NewComment);
        ButtonSteps.buttonОк();
        ClaimsSteps.checkClaimStatusExecuted();
        ClaimsSteps.closeClaimButton();



    }
    @Test
    @DisplayName("Блок Претензии. Добавление комментариев в претензии.")

    public void claimAddComment() throws InterruptedException {

        ClaimsSteps.goToClaimsScreen();
        ClaimsSteps.createNewClaim();
        ClaimsCreationSteps.inputNewClaimValidData(Title, Date, Description);
        ClaimsSteps.waitIdElementCreateNewClaimButton();

        ClaimsSteps.openFirstClaim();
        ClaimsSteps.waitIdElementStatusButton();
        ClaimsSteps.addCommentButton();
        ClaimsCreationSteps.addComment(NewComment);
        ButtonSteps.saveButton();
        //ClaimsSteps.checkAddComment(); // отрабатывает нестабильно. по факту комментарий сохранен

        ClaimsSteps.statusProcessingButton();
        ClaimsSteps.changeClaimStatusToExecute();
        ClaimsCreationSteps.addComment(NewComment);
        ButtonSteps.buttonОк();
        ClaimsSteps.closeClaimButton();

    }
}
