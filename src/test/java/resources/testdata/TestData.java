package resources.testdata;


import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "credentials")
    public Object[][] getData() {
        Object[][] data = new Object[][]{
                {"test1@gmail.com", "test123"},
                {"test2@gmail.com", "test234"},
                {"test3@gmail.com", "test345"}
        };
        return data;
    }
}