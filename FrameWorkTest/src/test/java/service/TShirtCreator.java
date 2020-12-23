package service;

import model.TShirt;

public class TShirtCreator {
    public  static  final String TESTDATA_PRODUCT_SIZE = "testdata.tshirt.size";
    public  static  final String TESTDATA_PRODUCT_NAME = "testdata.tshirt.name";

    public  static TShirt withCredentialsFromProperty(){
        return  new TShirt(TestDataReader.getTestData(TESTDATA_PRODUCT_SIZE),
                TestDataReader.getTestData(TESTDATA_PRODUCT_NAME));
    }
}
