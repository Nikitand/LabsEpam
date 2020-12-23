package service;

import model.Promo;

public class PromoCreator   {
        public  static  final String TESTDATA_PRODUCT_PROMO = "testdata.promo.failpromo";

        public  static Promo withCredentialsFromProperty(){
            return  new Promo(TestDataReader.getTestData(TESTDATA_PRODUCT_PROMO));
        }
}
