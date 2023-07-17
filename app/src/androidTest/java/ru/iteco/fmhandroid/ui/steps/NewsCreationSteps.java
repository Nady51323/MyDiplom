package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class NewsCreationSteps {
    public static void inputNewsValidData() throws InterruptedException {

        //создание новости, ввод валидных значений.

        //выбрать категорию
        NewsSelectCategorySteps.selectNewsCategoryAd();

        //заполнить заглавие
        ViewInteraction enterTitle = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        enterTitle.check(matches(isDisplayed()));
        enterTitle.perform(replaceText("Enter Title:13  !@#$%^&*(-+){}<>12345678910123456789"), closeSoftKeyboard());
        enterTitle.check(matches(withText("Enter Title:13  !@#$%^&*(-+){}<>12345678910123456789")));
        Thread.sleep(2000);

        //выбрать текущую дату
        NewsSteps.newsDate();

        //выбрать текущее время
        NewsSteps.newsTime();

        //заполнить описание
        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        inputDescription.check(matches(isDisplayed()));
        inputDescription.perform(typeText("Description:13 !@#$%^&*(-+){}<>12345678910123456789"), closeSoftKeyboard());
        inputDescription.check(matches(withText("Description:13 !@#$%^&*(-+){}<>12345678910123456789")));
        Thread.sleep(2000);

    }

    public static void inputNewsInvalidDataCategory() throws InterruptedException {

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
        NewsSteps.newsDate();

        //выбрать текущее время
        NewsSteps.newsTime();

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
        NewsSteps.newsTime();

        //заполнить описание
        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        inputDescription.check(matches(isDisplayed()));
        inputDescription.perform(typeText("Description:13 !@#$%^&*(-+){}<>12345678910123456789"), closeSoftKeyboard());
        inputDescription.check(matches(withText("Description:13 !@#$%^&*(-+){}<>12345678910123456789")));
        Thread.sleep(2000);
    }

    public static void inputNewsEmptyCategory() throws InterruptedException {

        //создание новости без ввода категории.

        // заполнить заглавие
        ViewInteraction enterTitle = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        enterTitle.check(matches(isDisplayed()));
        enterTitle.perform(replaceText("Enter Title:13  !@#$%^&*(-+){}<>12345678910123456789"), closeSoftKeyboard());
        enterTitle.check(matches(withText("Enter Title:13  !@#$%^&*(-+){}<>12345678910123456789")));
        Thread.sleep(2000);

        //выбрать текущую дату
        NewsSteps.newsDate();

        //выбрать текущее время
        NewsSteps.newsTime();

        //заполнить описание
        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        inputDescription.check(matches(isDisplayed()));
        inputDescription.perform(typeText("Description:13 !@#$%^&*(-+){}<>12345678910123456789"), closeSoftKeyboard());
        inputDescription.check(matches(withText("Description:13 !@#$%^&*(-+){}<>12345678910123456789")));
        Thread.sleep(2000);

    }

    public static void inputNewsInvalidDataTime() throws InterruptedException {

        //создание новости, ввод невалидных данных, поле время.

        //выбрать категорию
        NewsSelectCategorySteps.selectNewsCategoryAd();

        ViewInteraction enterTitle = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        enterTitle.check(matches(isDisplayed()));
        enterTitle.perform(replaceText("Enter Title:13  !@#$%^&*(-+){}<>12345678910123456789"), closeSoftKeyboard());
        enterTitle.check(matches(withText("Enter Title:13  !@#$%^&*(-+){}<>12345678910123456789")));
        Thread.sleep(2000);


        //выбрать текущую дату
        NewsSteps.newsDate();

        //ввести время не существующее
        ViewInteraction inputEditText = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_publish_time_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        inputEditText.perform(click());

        ViewInteraction imageButton = onView(
                allOf(withClassName(is("androidx.appcompat.widget.AppCompatImageButton")), withContentDescription("Switch to text input mode for the time input."),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        4),
                                0),
                        isDisplayed()));
        imageButton.perform(click());

        ViewInteraction editTextHour = onView(
                allOf(withClassName(is("androidx.appcompat.widget.AppCompatEditText")),
                        childAtPosition(
                                allOf(withClassName(is("android.widget.RelativeLayout")),
                                        childAtPosition(
                                                withClassName(is("android.widget.TextInputTimePickerView")),
                                                1)),
                                0),
                        isDisplayed()));
        editTextHour.perform(replaceText("25"), closeSoftKeyboard());

        ViewInteraction editTextHour1 = onView(
                allOf(withClassName(is("androidx.appcompat.widget.AppCompatEditText")),
                        childAtPosition(
                                allOf(withClassName(is("android.widget.RelativeLayout")),
                                        childAtPosition(
                                                withClassName(is("android.widget.TextInputTimePickerView")),
                                                1)),
                                3),
                        isDisplayed()));
        editTextHour1.perform(click());

        ViewInteraction editTextMinute = onView(
                allOf(withClassName(is("androidx.appcompat.widget.AppCompatEditText")),
                        childAtPosition(
                                allOf(withClassName(is("android.widget.RelativeLayout")),
                                        childAtPosition(
                                                withClassName(is("android.widget.TextInputTimePickerView")),
                                                1)),
                                3),
                        isDisplayed()));
        editTextMinute.perform(replaceText("61"), closeSoftKeyboard());

        //ButtonSteps.buttonОк();
        ViewInteraction clickOk = onView(
                allOf(withId(android.R.id.button1)));
        clickOk.check(matches(isDisplayed()));
        clickOk.perform(scrollTo(), click());
        Thread.sleep(3000);

        ViewInteraction errorMessage = onView(
                allOf(IsInstanceOf.<View>instanceOf(android.widget.TextView.class), withText("Enter a valid time"),
                        withParent(allOf(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class)))),
                        isDisplayed()));
        errorMessage.check(matches(withText("Enter a valid time")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }


}
