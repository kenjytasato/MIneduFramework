package pom;

import driver.driver;
import pages.applyForCertificatePage;
import pages.landingPage;
import pages.termsAndConditionsPage;

public class landingPOM {

    driver Driver = null;
    termsAndConditionsPage tyc = null;
    landingPage lp = null;

    public landingPOM(driver Driver) {

        this.Driver = Driver;
        lp = new landingPage(Driver);
        tyc = new termsAndConditionsPage(Driver);
    }

        public void acceptTermAndConditions()
        {

        tyc.checkcheckbox();
        tyc.ClickAcceptButton();
     }

    public String checkmodularCode() {
        return Driver.return_Prop().getProperty("modularCode");
    }


    public void applyForCertificate() {

         lp.applyForCertificate();

    }

    public void acceptTerms()
    {lp.pressCertificateAccept();}
    public void cancelTerms()
    {lp.pressCertificateCancel();}


}