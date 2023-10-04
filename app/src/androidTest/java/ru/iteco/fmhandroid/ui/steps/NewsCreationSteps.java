package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;

public class NewsCreationSteps {

    public static void editNewsButton() {

        Allure.step("Клик по кнопке 'Редактировать новость' c id:" + (R.id.edit_news_material_button));
        NewsScreen.editNewsButton.check(matches(isDisplayed()));
        NewsScreen.editNewsButton.perform(click());

    }

    public static void addNewsButton() throws InterruptedException {

        Allure.step("Клик по кнопке 'Создать новость' c id:" + (R.id.add_news_image_view));
        NewsScreen.addNewsButton.check(matches(isDisplayed()));
        NewsScreen.addNewsButton.perform(click());

    }

}
