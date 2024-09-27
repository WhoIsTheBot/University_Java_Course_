package labs.lab0;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class Variant5Test {

    @Test(priority = 1,dataProvider = "inputProvider")
    public void inputTest(int p1, int p3) {
        assertEquals(new Variant5().inputOutputTask(p1), p3);
    }

    @DataProvider
    public Object[][] inputProvider() {
        return new Object[][] { { 3, 27 }, { 2, 8 } };
    }

    //////////////////////////////////////////

    @Test(priority = 2,enabled = false)
    public void loginOld() {

        Assert.assertFalse(new Variant5().booleanTask(3, 7));

    }
    //////////////////////////////////////////

    @Test(priority = 3,dataProvider = "integerProvider")
    public void inputTest(int p1,int p2, int p3) {
        assertEquals(new Variant5().integerNumbersTask(p1,p2), p3);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] { { 100,10, 0 }, { 12,8, 4 }, { 139, 20, 19 } };
    }


    ////////////////////////////////////////////////

    @Test(priority = 4, dataProvider = "ifProvider")
    public void ifTest(int p1, int p2, int p3, int[] r1) {
        assertEquals(new Variant5().ifTask(p1, p2, p3), r1);
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] {
                { 2, 3, -1, new int[] {2, 1} }, // 2 positives, 1 negative
                { 0, 0, 0, new int[] {0, 0} },  // 0 positives, 0 negatives
                { -3, -3, -3, new int[] {0, 3} } // 0 positives, 3 negatives
        };
    }
    //////////////////////////////////////////////////

    @Test(priority = 5, dataProvider = "booleanProvider")
    public void booleanTest(int p1, int p2, boolean p3) {
        assertEquals(new Variant5().booleanTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { { 5,6, true }, { 0,-5, true }, { 0,-2, false } };
    }

    //////////////////////////////////////////////////

    @Test(priority = 6, dataProvider = "switchProvider")
    public void switchTest(int p1, double A, double B , double r) {
        assertEquals(new Variant5().switchTask(p1,A,B), r);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] { { 3, 1, 2, 2 }, { 1,2,2,4 } };
    }



    ///////////////////////////////////////////////////

    @Test(priority = 7,dataProvider = "forProvider")
    public void forTest(int n, double p2) {
        assertEquals(new Variant5().forTask(n), p2);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] { { 3, 0.3}, { 7, 0.7 }, { 3, 0.3 } };
    }



    //////////////////////////////////////////

    @Test(priority = 8,dataProvider = "whileProvider")
    public void whileTest(int a, int c) {
        assertEquals(new Variant5().whileTask(a), c);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] { { 32, 5}, { 16, 4}, { 1, 0}, { 2, 1} };
    }


    //////////////////////////////////////////
    @Test(priority = 9,dataProvider = "arrayProvider")
    public void arrayTest(int[] array, int value) {
        assertEquals(new Variant5().arrayTask(value), array);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] {
                { new int[] { 1, 1, 2, 3, 5 }, 5 }
        };
    }



    //////////////////////////////////////////

    @Test(priority = 10, dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int[][] input, int N, int D, int[][] output) {
        assertEquals(new Variant5().twoDimensionArrayTask(input, N, D), output);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input = {
                {2, 3, 6, 9, -9},
                {34, 98, -9, 2, 1},
                {-4, 2, 1, 6, 1},
                {-98, 8, 1, 5, 3}
        };

        int[][] output1 = {
                {2, 5, 8},
                {34, 37, 40},
                {-4, -1, 2},
                {-98, -95, -92}
        };

        int[][] output2 = {
                {2, 6, 10, 14},
                {34, 38, 42, 46},
                {-4, 0, 4, 8},
                {-98, -94, -90, -86}
        };

        return new Object[][] {
                {input, 3, 3, output1},
                {input, 4, 4, output2}
        };
    }

}
