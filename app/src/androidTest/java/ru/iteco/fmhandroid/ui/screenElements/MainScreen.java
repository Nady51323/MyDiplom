package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainScreen {

    // Выход из приложения
    public static ViewInteraction clickImageButtonLogOut = onView(withId(R.id.authorization_image_button));
    public static ViewInteraction logOutButton = onView(withId(android.R.id.title));

    // Меню
    public static ViewInteraction mainMenuButton = onView(withId(R.id.main_menu_image_button));
    public static ViewInteraction claimsOfMenu = onView(withText("Claims"));
    public static ViewInteraction newsOfMenu = onView(withText("News"));
    public static ViewInteraction aboutOfMenu = onView(withText("About"));

    // Переход к блоку цитат о хосписе
    public static ViewInteraction goToQuotesBlockButton = onView(withId(R.id.our_mission_image_button));


}
