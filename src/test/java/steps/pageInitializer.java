package steps;

import pages.*;

public class pageInitializer {

    public static homePage homePage;
    public static menSweatshirtPage menSweatshirtPage;
    public static machStreetSweatshirtPage machStreetSweatshirtPage;
    public static checkOutPage checkOutPage;
    public static reviewPaymentPage reviewPaymentPage;


    public static void intializePageObjects() {
        homePage = new homePage();
        menSweatshirtPage = new menSweatshirtPage();
        machStreetSweatshirtPage = new machStreetSweatshirtPage();
        checkOutPage = new checkOutPage();
        reviewPaymentPage = new reviewPaymentPage();
    }
}



