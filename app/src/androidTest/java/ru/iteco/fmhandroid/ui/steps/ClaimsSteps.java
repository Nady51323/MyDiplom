package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ClaimsSteps {
    public static void goToClaimsScreen() throws InterruptedException {

        //переходим на экран претензий

        ViewInteraction clickMainMenuButton = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenuButton.check(matches(isDisplayed()));
        clickMainMenuButton.perform(click());
        Thread.sleep(2000);

        ViewInteraction clickClaims = onView(
                anyOf(withText("Claims"), withText("Претензии")));
        clickClaims.check(matches(isDisplayed()));
        clickClaims.perform(click());
        Thread.sleep(2000);

    }

    public static void checkClaimStatusOpen() throws InterruptedException {

        //проверка, что претензия в статусе Открыто

        ViewInteraction checkClaimStatus = onView(
                anyOf(withText("Open"), withText("Открыто")));
        checkClaimStatus.check(matches(isDisplayed()));
        Thread.sleep(2000);
    }

    public static void changeClaimStatusToExecute() {

        // изменить статус претензии на "Выполнить"

        ViewInteraction clickStatusToExecute = onView(
                anyOf(withText("To execute"), withText("Выполнить")));
        clickStatusToExecute.perform(scrollTo());
        clickStatusToExecute.check(matches(isDisplayed()));
        clickStatusToExecute.perform(click());
    }

    public static void addComment() throws InterruptedException {

        //добавить комментарий

        ViewInteraction enterCommentThrowOff = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        enterCommentThrowOff.check(matches(isDisplayed()));
        enterCommentThrowOff.perform(typeText("Add comment :13@#$%()&"));
        Thread.sleep(1000);
    }


    public static void validationMessage() throws InterruptedException {

        ViewInteraction checkValidationMessage = onView(
                allOf(withId(android.R.id.message)));
        checkValidationMessage.check(matches(isDisplayed()));
        checkValidationMessage.check(matches(withText("Fill empty fields")));
        Thread.sleep(2000);
    }

    public static void errorMessage() {

        ViewInteraction checkTextMessage = onView(
                anyOf(withText("The changes won't be saved, do you really want to log out?"),
                        withText("Изменения не будут сохранены. Вы действительно хотите выйти?")));
        checkTextMessage.check(matches(isDisplayed()));
    }

    public static void openFirstClaim() throws InterruptedException {

        // кнопка открыть вновь созданную претензию

        ViewInteraction clickClaimOpen = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickClaimOpen.perform(actionOnItemAtPosition(0, click()));
        Thread.sleep(2000);
    }

    public static void checkBoxInProgressFiltersClaims() {

        //кнопка чек-бокс "In Progress"

        ViewInteraction clickCheckBoxInProgress = onView(
                allOf(withId(R.id.item_filter_in_progress)));
        clickCheckBoxInProgress.check(matches(isDisplayed()));
        clickCheckBoxInProgress.perform(scrollTo(), click());
    }

    public static void checkBoxOpenFiltersClaims() {

        //кнопка чек-бокс "Open"

        ViewInteraction clickCheckBoxOpen = onView(
                allOf(withId(R.id.item_filter_open)));
        clickCheckBoxOpen.check(matches(isDisplayed()));
        clickCheckBoxOpen.perform(scrollTo(), click());
    }

    public static void checkBoxExecutedFiltersClaims() {

        //кнопка чек-бокс "Executed"

        ViewInteraction clickCheckBoxExecuted = onView(
                allOf(withId(R.id.item_filter_executed)));
        clickCheckBoxExecuted.check(matches(isDisplayed()));
        clickCheckBoxExecuted.perform(scrollTo(), click());
    }

    public static void checkBoxCancelledFiltersClaims() {

        //кнопка чек-бокс "Cancelled"

        ViewInteraction clickCheckBoxCancelled = onView(
                allOf(withId(R.id.item_filter_cancelled)));
        clickCheckBoxCancelled.check(matches(isDisplayed()));
        clickCheckBoxCancelled.perform(scrollTo(), click());
    }

    public static void takeToWorkButton() throws InterruptedException {

        //кнопка "взять в работу"

        ViewInteraction clickStatusTakeToWork = onView(
                anyOf(withText("take to work"), withText("Взять в работу")));
        clickStatusTakeToWork.perform(scrollTo());
        clickStatusTakeToWork.check(matches(isDisplayed()));
        clickStatusTakeToWork.perform(click());
        Thread.sleep(1000);
    }


}




