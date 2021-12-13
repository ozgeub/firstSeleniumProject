package com.ozge.Variables;

public class PageObjects {

    public final static String popupContainer = "//div[@class=\"homepage-popup\"]";
    public final static String popupContainerClose = "//div[@class=\"modal-close\"]";
    public final static String loginContainer = "//div[@class=\"account-nav-item user-login-container\"]";
    public final static String loginButton = "//div[@class=\"login-button\"]";
    public final static String loginErrorMsg = "Lütfen geçerli bir e-posta adresi giriniz.";
    public final static String loginErrorMsg2 = "E-posta adresiniz ve/veya şifreniz hatalı.";
    public final static String loginErrorPth = "//div[@id=\"error-box-wrapper\"]/span[@class=\"message\"]";
        public final static String loginPage = "//*[@id=\"login-register\"]";
    public final static String emailTextBox = "//*[@id=\"login-email\"]";
    public final static String passwordTxtBox ="//*[@id=\"login-password-input\"]";
    public final static String loginSubmit = "//*[@class=\"q-primary q-fluid q-button-medium q-button submit\"]";
    public final static String hesabımText="//div[@class=\"link account-user\"]";

    // Search box Objects
    public final static String searchTextBox ="//input[@class=\"search-box\"]";
    public final static String searchClick = "//div[@class=\"suggestion-result\"]/a[1]";
    public final static String searchRsltChck= "//div[@class=\"dscrptn\"]";

    // Marka selection Objects
    public final static String markaTextBox = "//input[@class=\"fltr-srch-inpt\"]";
    public final static String markaCheckBox= "//div[@class=\"fltrs\"]//a[contains(@href,'monster')]/div[@class=\"chckbox\"]";
    public final static String brandValidation="//div[@class=\"slctd-fltr-item\"][1]/span[1]";
    // Price Selection Objects
    public final static String fiyatText = "//div[@class=\"aggrgtn-cntnr-wrppr\"]/div[contains(@data-title,'Fiyat')]";
    public final static String minFiyatTxtBox = "//input[@class=\"fltr-srch-prc-rng-input min\"]";
    public final static String maxFiyatTxtBox = "//input[@class=\"fltr-srch-prc-rng-input max\"]";
    public final static String fiyatBtn = "//button[@class=\"fltr-srch-prc-rng-srch\"]";
    public final static String priceValidation="//div[@class=\"slctd-fltr-item\"][2]/span[1]";

    public final static String selectedUrun = "//div[@class=\"ratings\"]/span[text()='7']";
    public final static String sepeteAtBtn = "//div[@class=\"product-button-container\"]/button[@class=\"add-to-basket\"]";

}

