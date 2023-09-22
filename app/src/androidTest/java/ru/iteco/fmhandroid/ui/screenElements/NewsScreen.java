package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsScreen {
    public static ViewInteraction newsScreenIsVisible = onView(withId(R.id.all_news_cards_block_constraint_layout));
    public static ViewInteraction newsFilterScreenIsVisible = onView(withId(R.id.filter_news_title_text_view));
    public static ViewInteraction categoryTextInputOfNews = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static ViewInteraction newsRecyclerView = onView(withId(R.id.news_list_recycler_view));
    public static ViewInteraction titleTextInputOfNews = onView(withId(R.id.news_item_title_text_input_edit_text));
    public static ViewInteraction publicationDateTextInputOfNews = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public static ViewInteraction publicationDateStartTextInputOfNews = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public static ViewInteraction publicationDateEndTextInputOfNews = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public static ViewInteraction timeTextInputOfNews = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public static ViewInteraction descriptionTextInputOfNews = onView(withId(R.id.news_item_description_text_input_edit_text));
    public static ViewInteraction checkBoxActive = onView (withText("Active"));//onView(withId(R.id.filter_news_active_material_check_box));
    public static ViewInteraction checkBoxInactive = onView (withText("Not active"));//(withId(R.id.filter_news_inactive_material_check_box));
    public static ViewInteraction controlPanel = onView(withText("Control panel"));
    public static ViewInteraction filterNews = onView(withText("Filter news"));
    public static ViewInteraction errorMessageWhenDeletingNews = onView(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future."));
    public static ViewInteraction checkCreationNews = onView(withText("Enter Title:13  !@#$%^&*(-+){}<>12345678910123456789"));
    public static ViewInteraction checkCategoryOfNews = onView(withText("Category_Категория//12345678910123456789101234567891012345678910"));

    // Кнопка редактирования новостей
    public static ViewInteraction editNewsButton = onView(withId(R.id.edit_news_material_button));

    // Создание новости
    public static ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));

    // Фильтрация новостей
    public static ViewInteraction filterNewsMaterialButton = onView(withId(R.id.filter_news_material_button));
    public static ViewInteraction filterButton = onView(withId(R.id.filter_button));

    // Категории новостей
    public static ViewInteraction moveThroughCategory1 = onView(withText("Объявление"));
    public static ViewInteraction moveThroughCategory2 = onView(withText("День рождения"));
    public static ViewInteraction moveThroughCategory3 = onView(withText("Зарплата"));
    public static ViewInteraction moveThroughCategory4 = onView(withText("Профсоюз"));
    public static ViewInteraction moveThroughCategory5 = onView(withText("Праздник"));
    public static ViewInteraction moveThroughCategory6 = onView(withText("Массаж"));
    public static ViewInteraction moveThroughCategory7 = onView(withText("Благодарность"));
    public static ViewInteraction moveThroughCategory8 = onView(withText("Нужна помощь"));

}
