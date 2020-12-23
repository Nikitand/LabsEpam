package service;

import model.TShirt;

public class TShirtCreator {
    public  static  final String TESTDATA_PRODUCT_SIZE = "testdata.tshirt.size";

    public  static TShirt withCredentialsFromProperty(){
        return  new TShirt(TestDataReader.getTestData(TESTDATA_PRODUCT_SIZE));
    }
}
