package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ButtonSteps {

    //Авторизация
    public static void signIn() throws InterruptedException {

        //кнопка входа в приложение

        ViewInteraction clickEnterButton = onView(
                allOf(withId(R.id.enter_button)));
        clickEnterButton.check(matches(isDisplayed()));
        clickEnterButton.perform(click());
        Thread.sleep(2000);
    }


    public static void imageButtonLogOut() throws InterruptedException {

        //имиджевая кнопка выход

        ViewInteraction clickImageButtonLogOut = onView(
                allOf(withId(R.id.authorization_image_button)));
        clickImageButtonLogOut.perform(click());
        Thread.sleep(500);
    }

    public static void buttonLogOut() throws InterruptedException {

        // кнопка выход из приложения

        ViewInteraction textViewLogOutTest = onView(
                allOf(withId(android.R.id.title)));
        textViewLogOutTest.perform(click());
        Thread.sleep(1000);
    }

    //кнопки для всех блоков

    public static void buttonОк() throws InterruptedException {

        //кнопка Ок

        ViewInteraction clickOk = onView(
                allOf(withId(android.R.id.button1)));
        clickOk.check(matches(isDisplayed()));
        clickOk.perform(scrollTo(), click());
        Thread.sleep(3000);

    }

    public static void buttonCancel() throws InterruptedException {

        //кнопка отмена

        ViewInteraction clickCancel = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel.perform(click());
        Thread.sleep(2000);
    }

    public static void saveButton() throws InterruptedException {

        //кнопка сохранить

        ViewInteraction clickSave = onView(
                allOf(withId(R.id.save_button)));
        clickSave.check(matches(isDisplayed()));
        clickSave.perform(scrollTo(), click());
        Thread.sleep(2000);
    }

    public static void throwOffButton() throws InterruptedException {

        //кнопка сбросить

        ViewInteraction clickStatusThrowOff = onView(
                anyOf(withText("Throw off"), withText("Сбросить")));
        clickStatusThrowOff.perform(scrollTo());
        clickStatusThrowOff.check(matches(isDisplayed()));
        clickStatusThrowOff.perform(click());
        Thread.sleep(2000);
    }

    //Блок Претензии
    public static void buttonFiltersClaims() throws InterruptedException {

        //кнопка фильтрации претензий

        ViewInteraction clickButtonFilters = onView(
                allOf(withId(R.id.filters_material_button)));
        clickButtonFilters.check(matches(isDisplayed()));
        clickButtonFilters.perform(click());
        Thread.sleep(2000);
    }

    public static void buttonRefresh() {

        //кнопка "обновить" в блоке "Претензии"

        ViewInteraction checkButtonRefresh = onView(
                allOf(withId(R.id.claim_retry_material_button),
                        withParent(allOf(withId(R.id.all_claims_cards_block_constraint_layout),
                                withParent(withId(R.id.container_list_claim_include))))));
        checkButtonRefresh.check(matches(isDisplayed()));
    }

    public static void clickOkFilter() {

        //кнопка "Ок" фильтрации в блоке "Претензии"

        ViewInteraction clickOkFilter = onView(
                allOf(withId(R.id.claim_list_filter_ok_material_button)));
        clickOkFilter.check(matches(isDisplayed()));
        clickOkFilter.perform(scrollTo(), click());

    }

    public static void createNewClaim() throws InterruptedException {

        // кнопка "добавить новую претензию"

        ViewInteraction clickCreateNewClaim = onView(
                allOf(withId(R.id.add_new_claim_material_button)));
        clickCreateNewClaim.perform(click());
        Thread.sleep(2000);

    }

    public static void statusProcessingButton() {

        //изменить "статус претензии"

        ViewInteraction statusProcessingButton = onView(
                allOf(withId(R.id.status_processing_image_button)));
        statusProcessingButton.perform(scrollTo());
        statusProcessingButton.check(matches(isDisplayed()));
        statusProcessingButton.perform(click());

    }

    public static void closeClaimButton() throws InterruptedException {

        // кнопка "закрыть претензию"

        ViewInteraction clickClose = onView(
                allOf(withId(R.id.close_image_button)));
        clickClose.perform(scrollTo());
        clickClose.check(matches(isDisplayed()));
        clickClose.perform(click());
        Thread.sleep(2000);

    }

    public static void editButton() throws InterruptedException {

        //кнопка "редактировать" в блоке "Претензии"

        ViewInteraction clickEditButton = onView(
                allOf(withId(R.id.edit_processing_image_button)));
        clickEditButton.perform(scrollTo());
        clickEditButton.check(matches(isDisplayed()));
        clickEditButton.perform(click());
        Thread.sleep(2000);
    }

    public static void selectFromList() throws InterruptedException {

        //кнопка "выбрать из списка" в блоке "Претензии"

        ViewInteraction clickExecutor = onView(
                allOf(withId(R.id.executor_drop_menu_auto_complete_text_view)));
        clickExecutor.check(matches(isDisplayed()));
        clickExecutor.perform(click(), closeSoftKeyboard());
        Thread.sleep(2000);

    }

    public static void addCommentButton() throws InterruptedException {

        //кнопка "добавить комментарий" в блоке "Претензии"

        ViewInteraction clickAddCommentButton = onView(
                allOf(withId(R.id.add_comment_image_button)));
        clickAddCommentButton.perform(scrollTo());
        clickAddCommentButton.check(matches(isDisplayed()));
        clickAddCommentButton.perform(click());
        Thread.sleep(2000);
    }


    //Блок Новости
    public static void editNewsButton() {

        // кнопка "создать новость"

        ViewInteraction clickControlPanel = onView(
                allOf(withId(R.id.edit_news_material_button)));
        clickControlPanel.check(matches(isDisplayed()));
        clickControlPanel.perform(click());
    }

    public static void addNewsButton() throws InterruptedException {

        //кнопку "добавить новость +"

        ViewInteraction clickAddNews = onView(
                allOf(withId(R.id.add_news_image_view)));
        clickAddNews.check(matches(isDisplayed()));
        clickAddNews.perform(click());
        Thread.sleep(2000);

    }

    public static void buttonFilterNews() throws InterruptedException {

        //кнопка фильтрации новостей

        ViewInteraction clickButtonNewsFilters = onView(
                allOf(withId(R.id.filter_news_material_button)));
        clickButtonNewsFilters.check(matches(isDisplayed()));
        clickButtonNewsFilters.perform(click());
        Thread.sleep(2000);
    }

    public static void newsFilterButton() throws InterruptedException {

        //кнопка фильтр новостей

        ViewInteraction clickFilter = onView(
                allOf(withId(R.id.filter_button)));
        clickFilter.check(matches(isDisplayed()));
        clickFilter.perform(click());
        Thread.sleep(1000);
    }

    public static void buttonCancelNews() {

        //кнопка "отмена" в блоке "Новости"

        ViewInteraction clickCancelButton = onView(
                allOf(withId(android.R.id.button2)));
        clickCancelButton.check(matches(isDisplayed()));
        clickCancelButton.perform(scrollTo(), click());

    }

    public static void buttonLoveIsAll() {

        //кнопка перехода в блоке Тематические цитаты

        ViewInteraction clickButtonLoveIsAll = onView(
                allOf(withId(R.id.our_mission_image_button)));
        clickButtonLoveIsAll.check(matches(isDisplayed()));
        clickButtonLoveIsAll.perform(click());
    }

    public static void listRecyclerOurMission() {

        //выбор цитаты в блоке Тематические цитаты

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.our_mission_item_list_recycler_view)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));
    }

}
