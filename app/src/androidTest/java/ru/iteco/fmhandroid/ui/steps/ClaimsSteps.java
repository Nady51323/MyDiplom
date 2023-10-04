package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
//import static ru.iteco.fmhandroid.utils.CustomViewActions.waitId;

import static ru.iteco.fmhandroid.utils.CustomViewActions.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screenElements.ClaimCreationScreen;
import ru.iteco.fmhandroid.ui.screenElements.ClaimsScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;

public class ClaimsSteps {


    public static void goToClaimsScreen() {

        Allure.step("Переход на экран 'Претензий'");
        MainScreen.mainMenuButton.perform(click());
        MainScreen.claimsOfMenu.check(matches(isDisplayed()));
        MainScreen.claimsOfMenu.perform(click());
        ClaimsSteps.waitIdElementFiltersButton();
    }

    public static void checkClaimStatusOpen() throws InterruptedException {

        Allure.step("Проверка, что претензия в статусе 'Open'");
        ClaimsScreen.claimStatusOpen.check(matches(isDisplayed()));

    }


    public static void changeClaimStatusToExecute() {

        Allure.step("Изменение статуса претензии на 'To execute'");
        ClaimsScreen.claimStatusToExecute.perform(scrollTo());
        ClaimsScreen.claimStatusToExecute.check(matches(isDisplayed()));
        ClaimsScreen.claimStatusToExecute.perform(scrollTo(), click());

    }

    public static void checkClaimStatusExecuted() throws InterruptedException {

        Allure.step("Проверка, что претензия в статусе 'Executed'");
        ClaimsScreen.claimStatusExecuted.check(matches(isDisplayed()));


    }

    public static void checkAddComment() throws InterruptedException {

        Allure.step("Проверка добавления комментария");
        ClaimCreationScreen.checkAddComment.check(matches(isDisplayed()));

    }


    public static void validationMessage() throws InterruptedException {

        Allure.step("Валидационное сообщение");
        ClaimsScreen.claimValidationMessage.check(matches(isDisplayed()));

    }

    public static void errorMessage() {

        Allure.step("Cообщение об ошибке");
        ClaimsScreen.errorMessage.check(matches(isDisplayed()));

    }

    public static void openFirstClaim() throws InterruptedException {

        Allure.step("Переход к первой претензии в блоке");
        ClaimsSteps.waitIdElementFiltersButton(); //Thread.sleep(2000);
        ClaimsScreen.containerForClaims.perform(actionOnItemAtPosition(0, click()));
        ClaimsSteps.waitIdElementStatusButton();

    }

    public static void openSecondClaim() throws InterruptedException {

        Allure.step("Переход ко второй претензии в блоке");
        ClaimsScreen.containerForClaims.perform(actionOnItemAtPosition(1, click()));

    }

    public static void openThirdClaim() throws InterruptedException {

        Allure.step("Переход к третьей претензии в блоке");
        ClaimsScreen.containerForClaims.perform(actionOnItemAtPosition(2, click()));

    }

    public static void openFourthClaim() throws InterruptedException {

        Allure.step("Переход к четвертой претензии в блоке");
        ClaimsScreen.containerForClaims.perform(actionOnItemAtPosition(3, click()));

    }


    public static void checkBoxInProgressFiltersClaims() {

        Allure.step("Клик на чек-бокс 'In Progress'");
        ClaimsScreen.inProgress.check(matches(isDisplayed()));
        ClaimsScreen.inProgress.perform(scrollTo(), click());

    }

    public static void checkBoxOpenFiltersClaims() {

        Allure.step("Клик на чек-бокс 'Open'");
        ClaimsScreen.open.check(matches(isDisplayed()));
        ClaimsScreen.open.perform(scrollTo(), click());

    }

    public static void checkBoxExecutedFiltersClaims() {

        Allure.step("Клик на чек-бокс 'Executed'");
        ClaimsScreen.executed.check(matches(isDisplayed()));
        ClaimsScreen.executed.perform(scrollTo(), click());

    }

    public static void checkBoxCancelledFiltersClaims() {

        Allure.step("Клик на чек-бокс 'Cancelled'");
        ClaimsScreen.cancelled.check(matches(isDisplayed()));
        ClaimsScreen.cancelled.perform(scrollTo(), click());

    }

    public static void takeToWorkButton() throws InterruptedException {

        Allure.step("Клик по кнопке 'Take to work'");
        ClaimsScreen.takeToWorkButton.check(matches(isDisplayed()));
        ClaimsScreen.takeToWorkButton.perform(scrollTo(), click());

    }

    public static void buttonFiltersClaims() throws InterruptedException {

        Allure.step("Начать фильтрацию претензий. Клик по кнопке c id:" + (R.id.filters_material_button));
        ClaimsScreen.buttonForClaimsFiltering.perform(click());
        ClaimsScreen.titleOfFilterDialog.check(matches(isDisplayed()));

    }


    public static void buttonRefresh() {

        Allure.step("Отображение кнопки 'Refresh'");//
        ClaimsScreen.buttonRefresh.check(matches(isDisplayed()));

    }

    public static void buttonOkFilter() {

        Allure.step("Фильтрация претензий. Клик по кнопке 'Ok' c id:" + (R.id.claim_list_filter_ok_material_button));
        ClaimsScreen.okButton.perform(scrollTo(), click());

    }

    public static void createNewClaim() throws InterruptedException {

        Allure.step("Добавление новой претензии. Клик по кнопке c id:" + R.id.add_new_claim_material_button);
        ClaimsScreen.addNewClaimButton.perform(click());
        ClaimsSteps.waitIdElementSaveButton();


    }


    public static void statusProcessingButton() throws InterruptedException {

        Allure.step("Изменить статус претензии. Клик по кнопке c id:" + (R.id.status_processing_image_button));
        ClaimsScreen.changeStatusButtonOfClaim.perform(scrollTo());
        ClaimsScreen.changeStatusButtonOfClaim.check(matches(isDisplayed()));
        ClaimsScreen.changeStatusButtonOfClaim.perform(scrollTo(), click());

    }

    public static void editButton() throws InterruptedException {

        Allure.step("'Редактировать'претензию. Клик по кнопке  c id:" + (R.id.edit_processing_image_button));
        ClaimsScreen.editClaimButton.check(matches(isDisplayed()));
        ClaimsScreen.editClaimButton.perform(scrollTo(), click());
    }


    public static void selectFromList() throws InterruptedException {

        Allure.step("'Выбрать из списка' в блоке 'Претензии'. Клик по кнопке c id:" + (R.id.executor_drop_menu_auto_complete_text_view));
        ClaimsScreen.selectFromList.check(matches(isDisplayed()));
        ClaimsScreen.selectFromList.perform(click(), closeSoftKeyboard());
        ClaimsSteps.waitIdElementExecutor();

    }

    public static void addCommentButton() throws InterruptedException {

        Allure.step("'Добавить комментарий' в блоке 'Претензии'. Клик по кнопке c id:" + (R.id.add_comment_image_button));
        ClaimsScreen.addCommentButton.perform(scrollTo());
        ClaimsScreen.addCommentButton.check(matches(isDisplayed()));
        ClaimsScreen.addCommentButton.perform(scrollTo(), click());
        ClaimsSteps.waitIdElementSaveButton();

    }

    public static void closeClaimButton() throws InterruptedException {

        Allure.step("'Закрыть претензию'. Клик по кнопке c id:" + (R.id.close_image_button));
        ClaimsScreen.closeClaimButton.check(matches(isDisplayed()));
        ClaimsScreen.closeClaimButton.perform(scrollTo(), click());


    }

    public static void waitIdElementExecutor() {
        Allure.step("Ожидание отображения исполнителя");
        onView(isRoot()).perform(waitDisplayed(R.id.executor_drop_menu_auto_complete_text_view, 10000));
    }

    public static void waitIdElementSaveButton() {
        Allure.step("Ожидание отображения кнопки сохранить");
        onView(isRoot()).perform(waitDisplayed(R.id.save_button, 10000));
    }

    public static void waitIdElementFiltersButton() {
        Allure.step("Ожидание отображения кнопки фильтрации претензий");
        onView(isRoot()).perform(waitDisplayed(R.id.filters_material_button, 10000));
    }
    public static void waitElementCloseButton() {
        Allure.step("Ожидание отображения кнопки закрыть претензию");
        onView(isRoot()).perform(waitDisplayed(R.id.close_image_button, 10000));
    }

   public static void waitIdElementAddCommentButton() {
        Allure.step("Ожидание отображения кнопки добавить комментарий");
        onView(isRoot()).perform(waitDisplayed(R.id.add_comment_image_button, 10000));
    }

    public static void waitIdElementCreateNewClaimButton() {
        Allure.step("Ожидание отображения кнопки создать новую претензию");
        onView(isRoot()).perform(waitDisplayed(R.id.add_new_claim_material_button, 7000));
    }


    public static void waitIdElementStatusButton() {
        Allure.step("Ожидание отображения кнопки добавить комментарий");
        onView(isRoot()).perform(waitDisplayed(R.id.status_processing_image_button, 7000));
    }

}




