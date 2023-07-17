package ru.iteco.fmhandroid.ui.tests.claims;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;
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
public class ClaimEditingTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void ThreadSleep() throws InterruptedException {
        Thread.sleep(7000);

        AuthorizationSteps.logIn();
    }

    @Test
    @DisplayName("Блок Претензии. Редактирование претензии.")

    public void claimEditing() throws InterruptedException {

        //переходим на экран претензий
        ClaimsSteps.goToClaimsScreen();

        // создать новую претензию
        ButtonSteps.createNewClaim();

        ClaimsCreationSteps.inputNewClaimValidData();

        ClaimsSteps.openFirstClaim();
        ButtonSteps.statusProcessingButton();
        ButtonSteps.throwOffButton();
        ClaimsSteps.addComment();
        ButtonSteps.buttonОк();
        ButtonSteps.editButton();

        // редактировать название
        ViewInteraction editTitle = onView(
                allOf(withId(R.id.title_edit_text)));
        editTitle.perform(clearText());
        editTitle.perform(typeText("Claim #1 Edit title"));
        editTitle.check(matches(withText("Claim #1 Edit title")));

        //выбрать исполнителя из списка
        ButtonSteps.selectFromList();

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
        ButtonSteps.saveButton();
        ButtonSteps.statusProcessingButton();
        ClaimsSteps.changeClaimStatusToExecute();
        ClaimsSteps.addComment();
        ButtonSteps.buttonОк();

        ViewInteraction checkClaimStatus = onView(
                anyOf(withText("Executed"), withText("Выполнено")));
        checkClaimStatus.check(matches(isDisplayed()));

        ButtonSteps.closeClaimButton();

        AuthorizationSteps.logOut();

    }
}
