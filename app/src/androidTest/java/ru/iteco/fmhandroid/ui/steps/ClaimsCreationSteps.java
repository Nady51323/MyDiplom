package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;

import ru.iteco.fmhandroid.R;

public class ClaimsCreationSteps {
    public static void inputNewClaimValidData() throws InterruptedException {

        //создание новой претензии, ввод валидных значений

        ViewInteraction textInputTitle = onView(
                allOf(withId(R.id.title_edit_text)));
        textInputTitle.check(matches(isDisplayed()));
        textInputTitle.perform(typeText("NewClaim:13  !@#$%^&*(-+){}<>12345678910123456789"));
        textInputTitle.check(matches(withText("NewClaim:13  !@#$%^&*(-+){}<>12345678910123456789")));

        ButtonSteps.selectFromList();

        ViewInteraction selectExecutorFromList =
                onView(withText("Ivanov Ivan Ivanovich"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        Thread.sleep(2000);

        ViewInteraction editDate = onView(
                allOf(withId(R.id.date_in_plan_text_input_edit_text)));
        editDate.perform(replaceText("20.06.1700"));
        editDate.check(matches(isDisplayed()));

        ViewInteraction chooseTime = onView(
                allOf(withId(R.id.time_in_plan_text_input_edit_text)));
        chooseTime.perform(click());

        ButtonSteps.buttonОк();

        ViewInteraction textInputEditDescription = onView(
                allOf(withId(R.id.description_edit_text)));
        textInputEditDescription.check(matches(isDisplayed()));
        textInputEditDescription.perform(typeText("NewClaim:13  !@#$%^&*(-+){}<>12345678910123456789"), closeSoftKeyboard());
        textInputEditDescription.check(matches(withText("NewClaim:13  !@#$%^&*(-+){}<>12345678910123456789")));

        ButtonSteps.saveButton();

    }
}
