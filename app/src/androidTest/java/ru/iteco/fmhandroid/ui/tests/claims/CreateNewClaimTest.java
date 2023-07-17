package ru.iteco.fmhandroid.ui.tests.claims;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
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

    @Before
    public void ThreadSleep() throws InterruptedException {
        Thread.sleep(7000);

        AuthorizationSteps.logIn();
    }

    @Test
    @DisplayName("Блок Претензии. Создание новой претензии, ввод валидных значений.")

    public void createNewClaimValidData() throws InterruptedException {

        //перейти на экран претензий
        ClaimsSteps.goToClaimsScreen();

        //создать новую претензию
        ButtonSteps.createNewClaim();

        ClaimsCreationSteps.inputNewClaimValidData();

        ViewInteraction textView = onView(
                allOf(withId(R.id.description_material_text_view), withText("NewClaim:13  !@#$%^&*(-+){}<>12345678910123456789"),
                        withParent(withParent(withId(R.id.claim_list_card))),
                        isDisplayed()));
        textView.check(matches(withText("NewClaim:13  !@#$%^&*(-+){}<>12345678910123456789")));

        ClaimsSteps.openFirstClaim();
        ButtonSteps.statusProcessingButton();
        ClaimsSteps.changeClaimStatusToExecute();
        ClaimsSteps.addComment();
        ButtonSteps.buttonОк();
        ButtonSteps.closeClaimButton();

        AuthorizationSteps.logOut();
    }


    @Test
    @DisplayName("Блок Претензии. Создание новой претензии с пустыми полями.")

    public void createNewClaimEmptyFields() throws InterruptedException {

        ClaimsSteps.goToClaimsScreen();
        ButtonSteps.createNewClaim();
        ButtonSteps.saveButton();
        ClaimsSteps.validationMessage();
        ButtonSteps.buttonОк();
        ButtonSteps.buttonCancel();
        ClaimsSteps.errorMessage();
        ButtonSteps.buttonОк();

        AuthorizationSteps.logOut();

    }
}





