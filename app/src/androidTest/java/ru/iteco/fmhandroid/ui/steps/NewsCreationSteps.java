package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;

public class NewsCreationSteps {
    public static void inputNewsValidData(String Title, String Description) throws InterruptedException {

        Allure.step("Создание новости, ввод валидных значений.");
        NewsSelectCategorySteps.selectNewsCategoryAd();  //выбрать категорию
        NewsScreen.titleTextInputOfNews.perform(replaceText(Title)); //заполнить заглавие
        NewsScreen.titleTextInputOfNews.check(matches(withText(Title)));
        Thread.sleep(2000);

        NewsSteps.selectCurrentNewsDate(); //выбрать текущую дату
        NewsSteps.selectCurrentNewsTime(); //выбрать текущее время

        NewsScreen.descriptionTextInputOfNews.perform(replaceText(Description));   //заполнить описание
        NewsScreen.descriptionTextInputOfNews.check(matches(withText(Description)));
        Thread.sleep(2000);


    }

    public static void editNewsButton() {

        Allure.step("Клик по кнопке 'Редактировать новость' c id:" + (R.id.edit_news_material_button));
        NewsScreen.editNewsButton.check(matches(isDisplayed()));
        NewsScreen.editNewsButton.perform(click());

    }

    public static void addNewsButton() throws InterruptedException {

        Allure.step("Клик по кнопке 'Создать новость' c id:" + (R.id.add_news_image_view));
        NewsScreen.addNewsButton.check(matches(isDisplayed()));
        NewsScreen.addNewsButton.perform(click());
        Thread.sleep(2000);


    }



  /*  public static void inputNewsInvalidDataCategory() throws InterruptedException {

        // создание новости, ввод невалидных данных, поле категория.

        //ввести категорию
        ViewInteraction inputCategory = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategory.perform(replaceText("Category_Категория//12345678910123456789101234567891012345678910"), closeSoftKeyboard());
        inputCategory.check(matches(withText("Category_Категория//12345678910123456789101234567891012345678910")));

        // заполнить заголовок
        ViewInteraction enterTitle = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        enterTitle.check(matches(isDisplayed()));
        enterTitle.perform(replaceText("Enter Title:13  !@#$%^&*(-+){}<>12345678910123456789"), closeSoftKeyboard());
        enterTitle.check(matches(withText("Enter Title:13  !@#$%^&*(-+){}<>12345678910123456789")));
        Thread.sleep(2000);

        //выбрать текущую дату
        NewsSteps.selectCurrentNewsDate();

        //выбрать текущее время
        NewsSteps.selectCurrentNewsTime();

        //заполнить описание
        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        inputDescription.check(matches(isDisplayed()));
        inputDescription.perform(typeText("Description:13 !@#$%^&*(-+){}<>12345678910123456789"), closeSoftKeyboard());
        inputDescription.check(matches(withText("Description:13 !@#$%^&*(-+){}<>12345678910123456789")));
        Thread.sleep(2000);
    }

    public static void inputNewsInvalidDataTitleDate() throws InterruptedException {

        // создание новости, ввод невалидных данных, поле заголовок, дата.

        //выбрать категорию
        NewsSelectCategorySteps.selectNewsCategoryAd();

        ViewInteraction enterTitle = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        enterTitle.check(matches(isDisplayed()));
        enterTitle.perform(replaceText("Title//12345678910123456789101234567891012345678910123456"), closeSoftKeyboard());
        enterTitle.check(matches(withText("Title//12345678910123456789101234567891012345678910123456")));
        Thread.sleep(2000);

        //ввести невалидную дату
        ViewInteraction inputPublishDate = onView(
                allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
        inputPublishDate.perform(replaceText("13.10.1991"));

        //выбрать текущее время
        NewsSteps.selectCurrentNewsTime();

        //заполнить описание
        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        inputDescription.check(matches(isDisplayed()));
        inputDescription.perform(typeText("Description:13 !@#$%^&*(-+){}<>12345678910123456789"), closeSoftKeyboard());
        inputDescription.check(matches(withText("Description:13 !@#$%^&*(-+){}<>12345678910123456789")));
        Thread.sleep(2000);
    }*/

   /* public static void inputNewsEmptyCategory() throws InterruptedException {

        //создание новости без ввода категории.

        // заполнить заглавие
        ViewInteraction enterTitle = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        enterTitle.check(matches(isDisplayed()));
        enterTitle.perform(replaceText("Enter Title:13  !@#$%^&*(-+){}<>12345678910123456789"), closeSoftKeyboard());
        enterTitle.check(matches(withText("Enter Title:13  !@#$%^&*(-+){}<>12345678910123456789")));
        Thread.sleep(2000);

        //выбрать текущую дату
        NewsSteps.selectCurrentNewsDate();

        //выбрать текущее время
        NewsSteps.selectCurrentNewsTime();

        //заполнить описание
        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        inputDescription.check(matches(isDisplayed()));
        inputDescription.perform(typeText("Description:13 !@#$%^&*(-+){}<>12345678910123456789"), closeSoftKeyboard());
        inputDescription.check(matches(withText("Description:13 !@#$%^&*(-+){}<>12345678910123456789")));
        Thread.sleep(2000);

    }*/



}
