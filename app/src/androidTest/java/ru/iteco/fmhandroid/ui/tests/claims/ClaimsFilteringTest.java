package ru.iteco.fmhandroid.ui.tests.claims;


import androidx.test.espresso.NoMatchingViewException;
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
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ClaimsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsFilteringTest {

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
    @DisplayName("Блок Претензии. Фильтрация претензий.")
    @Description("Кликабельность чек-боксов каждого статуса.")

    public void claimsFilteringClickEveryCheckBox() throws InterruptedException {

        ClaimsSteps.goToClaimsScreen();
        ClaimsSteps.buttonFiltersClaims();
        ClaimsSteps.checkBoxInProgressFiltersClaims();
        ClaimsSteps.buttonOkFilter();
        ClaimsSteps.buttonFiltersClaims();
        ClaimsSteps.checkBoxOpenFiltersClaims();
        ClaimsSteps.checkBoxInProgressFiltersClaims();
        ClaimsSteps.buttonOkFilter();
        ClaimsSteps.buttonFiltersClaims();
        ClaimsSteps.checkBoxInProgressFiltersClaims();
        ClaimsSteps.checkBoxExecutedFiltersClaims();
        ClaimsSteps.buttonOkFilter();
        ClaimsSteps.buttonFiltersClaims();
        ClaimsSteps.checkBoxExecutedFiltersClaims();
        ClaimsSteps.checkBoxCancelledFiltersClaims();
        ClaimsSteps.buttonOkFilter();
        AuthorizationSteps.logOut();
    }

    @Test
    @DisplayName("Блок Претензии. Фильтрация претензий.")
    @Description("Ни один статус не выбран.")

    public void claimsFilteringWithoutStatusSelection() throws InterruptedException {

        ClaimsSteps.goToClaimsScreen();
        ClaimsSteps.buttonFiltersClaims();
        ClaimsSteps.checkBoxOpenFiltersClaims();
        ClaimsSteps.checkBoxInProgressFiltersClaims();
        ClaimsSteps.buttonOkFilter();
        ClaimsSteps.buttonRefresh();
        AuthorizationSteps.logOut();

    }


    @Test
    @DisplayName("Блок Претензии. Фильтрация претензий.")
    @Description("Выбран статус Открыта.")

    public void claimsFilteringStatusOpen() throws InterruptedException {

        ClaimsSteps.goToClaimsScreen();
        ClaimsSteps.buttonFiltersClaims();
        ClaimsSteps.checkBoxInProgressFiltersClaims();
        ClaimsSteps.buttonOkFilter();
        ClaimsSteps.buttonFiltersClaims();
        ClaimsSteps.buttonOkFilter();

        // карточка 1

        ClaimsSteps.openFirstClaim();
        Thread.sleep(2000);
        ClaimsSteps.checkClaimStatusOpen();
        ClaimsSteps.closeClaimButton();

        //карточка 2 // на второй карточке падает тест с ошибкой не находит текст

        ClaimsSteps.openSecondClaim();
        Thread.sleep(2000);
        ClaimsSteps.checkClaimStatusOpen();
        ClaimsSteps.closeClaimButton();

        // карточка 3

        ClaimsSteps.openThirdClaim();
        Thread.sleep(2000);
        ClaimsSteps.checkClaimStatusOpen();
        ClaimsSteps.closeClaimButton();

        //карточка 4

        ClaimsSteps.openFourthClaim();
        Thread.sleep(2000);

        ClaimsSteps.checkClaimStatusOpen();
        ClaimsSteps.closeClaimButton();

        AuthorizationSteps.logOut();

    }

}