package me.drakeet.layoutformatter;

import junit.framework.TestCase;

/**
 * Created by drakeet on 16/4/11.
 */
public class FormatterTest extends TestCase {

    private String xml1;
    private String xml2;
    private String xml3;
    private String xml4;


    @Override protected void setUp() throws Exception {
        super.setUp();
        xml1 = "<Test android:text=\"123\"\nandroid:id=\"456\"/>";
        xml2 = "<Test android:text=\"123\"\nandroid:id=\"456\" />";
        xml3 = "<Test android:text=\"123\"\nandroid:id=\"456\">";
        xml4 = "<Test android:text=\"123\"\nandroid:id=\"456\" >";
    }


    public void testRetrofit() {
        xml1 = Formatter.retrofit(xml1);
        xml2 = Formatter.retrofit(xml2);
        xml3 = Formatter.retrofit(xml3);
        xml4 = Formatter.retrofit(xml4);
        System.out.println(xml1);
        System.out.println(xml2);
        System.out.println(xml3);
        System.out.println(xml4);
        assertEquals(xml1, "<Test android:text=\"123\"\nandroid:id=\"456\"\n/>");
        assertEquals(xml2, "<Test android:text=\"123\"\nandroid:id=\"456\"\n/>");
        assertEquals(xml3, "<Test android:text=\"123\"\nandroid:id=\"456\"\n>");
        assertEquals(xml4, "<Test android:text=\"123\"\nandroid:id=\"456\"\n>");
    }
}