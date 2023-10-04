package ru.iteco.fmhandroid.ui.data;

public class TestDataForClaimsNews {

    private final String TITLE;
    private final String DATE;
    private final String DESCRIPTION;

    private final String TITLE1;
    private final String DATE1;
    private final String TIME1;
    private final String DESCRIPTION1;
    private final String COMMENT;

    private final String InvalidDataCategoryNews;
    private final String TitleNews;
    private final String DescriptionNews;
    private final String InvalidDataTitleNews;
    private final String InvalidPublishDateNews;

    private final String DateStartNews;
    private final String DateEndNews;

    private final String Login;
    private final String Password;



    private final String WrongLogin1;
    private final String WrongLogin2;
    private final String WrongLogin3;
    private final String WrongLogin4;
    private final String WrongLogin5;
    private final String WrongPassword1;
    private final String WrongPassword2;



    public TestDataForClaimsNews() {

        Login = TestData.ValidLogin;
        Password = TestData.ValidPassword;

        WrongLogin1 = TestData.WrongLogin1;
        WrongLogin2 = TestData.WrongLogin2;
        WrongLogin3 = TestData.WrongLogin3;
        WrongLogin4 = TestData.WrongLogin4;
        WrongLogin5 = TestData.WrongLogin5;
        WrongPassword1 = TestData.WrongPassword1;
        WrongPassword2 = TestData.WrongPassword2;

        TITLE = TestData.TITLE;
        DATE = TestData.DATE;
        DESCRIPTION = TestData.DESCRIPTION;
        COMMENT = TestData.COMMENT;

        TITLE1 = TestData.TITLE1;
        DATE1 = TestData.DATE1;
        TIME1 = TestData.TIME1;
        DESCRIPTION1 = TestData.DESCRIPTION1;

        InvalidDataCategoryNews = TestData.InvalidDataCategoryNews;
        TitleNews = TestData.TitleNews;
        DescriptionNews = TestData.DescriptionNews;
        InvalidDataTitleNews = TestData.InvalidDataTitleNews;
        InvalidPublishDateNews = TestData.InvalidPublishDateNews;

        DateStartNews = TestData.DateStartNews;
        DateEndNews = TestData.DateEndNews;


    }
}
