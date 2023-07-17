package ru.iteco.fmhandroid.ui.tests.claims;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
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
public class ClaimAddCommentTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void ThreadSleep() throws InterruptedException {
        Thread.sleep(7000);

        AuthorizationSteps.logIn();
    }

    @Test
    @DisplayName("Блок Претензии. Добавление комментариев в претензии.")

    public void claimAddComment() throws InterruptedException {

        //переходим на экран претензий
        ClaimsSteps.goToClaimsScreen();

        // создать новую претензию
        ButtonSteps.createNewClaim();
        ClaimsCreationSteps.inputNewClaimValidData();
        ClaimsSteps.openFirstClaim();

        //добавить комментарий
        ButtonSteps.addCommentButton();

        //ввести комментарий
        ClaimsSteps.addComment();
        ButtonSteps.saveButton();

        //проверка отображения комментария

        ViewInteraction checkTextComment = onView(
                allOf(withId(R.id.comment_description_text_view), withText("Add comment :13@#$%()&")));
        checkTextComment.check(matches(isDisplayed()));
        checkTextComment.check(matches(withText("Add comment :13@#$%()&")));
        Thread.sleep(2000);

        //смена статуса претензии
        ButtonSteps.statusProcessingButton();
        ButtonSteps.throwOffButton();

        //добавить комментарий
        ClaimsSteps.addComment();
        ButtonSteps.buttonОк();

        //смена статуса претензии
        ButtonSteps.statusProcessingButton();
        ClaimsSteps.takeToWorkButton();

        //смена статуса претензии
        ButtonSteps.statusProcessingButton();
        ClaimsSteps.changeClaimStatusToExecute();

        //добавить комментарий
        ClaimsSteps.addComment();
        ButtonSteps.buttonОк();
        ButtonSteps.closeClaimButton();

        AuthorizationSteps.logOut();

    }
}

