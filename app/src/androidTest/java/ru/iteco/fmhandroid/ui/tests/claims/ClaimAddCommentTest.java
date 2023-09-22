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
import ru.iteco.fmhandroid.ui.steps.ClaimsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimAddCommentTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);


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
    @DisplayName("Блок Претензии. Добавление комментариев в претензии.")

    public void claimAddComment() throws InterruptedException {

        //переходим на экран претензий
        ClaimsSteps.goToClaimsScreen(); // +

        // создать новую претензию
        ClaimsSteps.createNewClaim(); // +
        DataHelper.createClaim();// +

        ClaimsSteps.openFirstClaim();// +
        ClaimsSteps.waitIdElementStatusButton(); // +

        //добавить комментарий кнопка
        ClaimsSteps.addCommentButton(); // +

        //ввести комментарий
        DataHelper.addComment();// +
        ButtonSteps.saveButton(); // +
        //Thread.sleep(3000);

        //проверка отображения комментария
      //  ClaimsSteps.checkAddComment(); - не ищет по тексту!!! ошибка!!

        //смена статуса претензии
        ClaimsSteps.statusProcessingButton();
        ButtonSteps.throwOffButton();// не ищет по тексту!!! ошибка!!

        //добавить комментарий
        DataHelper.addComment();
        ButtonSteps.buttonОк();

        //смена статуса претензии
        ClaimsSteps.statusProcessingButton();
        ClaimsSteps.takeToWorkButton();

        //смена статуса претензии
        ClaimsSteps.statusProcessingButton();
        ClaimsSteps.changeClaimStatusToExecute();

        //добавить комментарий
        DataHelper.addComment();
        ButtonSteps.buttonОк();
        ClaimsSteps.closeClaimButton();

        AuthorizationSteps.logOut();

    }
}

