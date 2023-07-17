package ru.iteco.fmhandroid.ui.tests.claims;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ButtonSteps;
import ru.iteco.fmhandroid.ui.steps.ClaimsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsFilteringTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void ThreadSleep() throws InterruptedException {
        Thread.sleep(7000);
        AuthorizationSteps.logIn();
    }


    @Test
    @DisplayName("Блок Претензии. Фильтрация претензий.")
    @Description("Кликабельность чек-боксов каждого статуса.")

    public void claimsFilteringClickEveryCheckBox() throws InterruptedException {

        ClaimsSteps.goToClaimsScreen();
        ButtonSteps.buttonFiltersClaims();
        ClaimsSteps.checkBoxInProgressFiltersClaims();
        ButtonSteps.clickOkFilter();
        Thread.sleep(1000);

        ButtonSteps.buttonFiltersClaims();
        ClaimsSteps.checkBoxOpenFiltersClaims();
        ClaimsSteps.checkBoxInProgressFiltersClaims();
        ButtonSteps.clickOkFilter();
        Thread.sleep(1000);

        ButtonSteps.buttonFiltersClaims();
        ClaimsSteps.checkBoxInProgressFiltersClaims();
        ClaimsSteps.checkBoxExecutedFiltersClaims();
        ButtonSteps.clickOkFilter();
        Thread.sleep(1000);

        ButtonSteps.buttonFiltersClaims();
        ClaimsSteps.checkBoxExecutedFiltersClaims();
        ClaimsSteps.checkBoxCancelledFiltersClaims();
        ButtonSteps.clickOkFilter();
        Thread.sleep(1000);

        AuthorizationSteps.logOut();
    }

    @Test
    @DisplayName("Блок Претензии. Фильтрация претензий.")
    @Description("Ни один статус не выбран.")

    public void claimsFilteringWithoutStatusSelection() throws InterruptedException {

        ClaimsSteps.goToClaimsScreen();
        ButtonSteps.buttonFiltersClaims();
        ClaimsSteps.checkBoxOpenFiltersClaims();
        ClaimsSteps.checkBoxInProgressFiltersClaims();
        ButtonSteps.clickOkFilter();
        Thread.sleep(1000);
        ButtonSteps.buttonRefresh();

        AuthorizationSteps.logOut();

    }


    @Test
    @DisplayName("Блок Претензии. Фильтрация претензий.")
    @Description("Выбран статус Открыта.")

    public void claimsFilteringStatusOpen() throws InterruptedException {

        ClaimsSteps.goToClaimsScreen();
        ButtonSteps.buttonFiltersClaims();
        ClaimsSteps.checkBoxInProgressFiltersClaims();
        ButtonSteps.clickOkFilter();
        Thread.sleep(1000);

        // карточка 1

        ViewInteraction clickOpenClaim1 = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickOpenClaim1.perform(actionOnItemAtPosition(0, click()));

        ClaimsSteps.checkClaimStatusOpen();
        ButtonSteps.closeClaimButton();

        //карточка 2

        ViewInteraction clickOpenClaim2 = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickOpenClaim2.perform(actionOnItemAtPosition(1, click()));
        Thread.sleep(1000);

        ClaimsSteps.checkClaimStatusOpen();
        ButtonSteps.closeClaimButton();


        // карточка 3

        ViewInteraction clickOpenClaim3 = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickOpenClaim3.perform(actionOnItemAtPosition(2, click()));

        ClaimsSteps.checkClaimStatusOpen();
        ButtonSteps.closeClaimButton();

        //карточка 4

        ViewInteraction clickOpenClaim4 = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickOpenClaim4.perform(actionOnItemAtPosition(3, click()));
        Thread.sleep(1000);

        ClaimsSteps.checkClaimStatusOpen();
        ButtonSteps.closeClaimButton();

        AuthorizationSteps.logOut();

    }

}