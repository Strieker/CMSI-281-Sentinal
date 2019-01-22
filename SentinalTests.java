package sentinal2;

import static org.junit.Assert.*;


import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import java.util.*;
import java.io.*;

public class SentinalTests {

    Sentinal s;

    String absolutePath = "/Users/sas/Desktop/McLovin It/Sophomore Year/Work Hard/Semester 1/Data Structures/sentinal2/src/sentinal2/";
    @Before
    public void init () {
        try {
            s = new Sentinal(absolutePath + "posPhrases.txt",
                             absolutePath + "negPhrases.txt");
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSentinal() {
    	 try {
             s = new Sentinal(absolutePath + "posPhrases.txt",
                              absolutePath + "negPhrases.txt");
         } catch (Exception e) {
         	System.out.println("I RAN");
             fail();
         }
   }

    @Test
    public void testSentinalyze_1() {
        try {
            assertEquals("negative", s.sentinalyze(absolutePath + "negDoc.txt"));
        } catch (FileNotFoundException e) {
        	System.out.println("im negative");
            fail();
        }
    }
    @Test
    public void testSentinalyze_2() {
        try {
            assertEquals("positive", s.sentinalyze(absolutePath + "posDoc.txt"));
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    @Test
    public void testSentinalyze_3() {
        try {
            assertEquals("neutral", s.sentinalyze(absolutePath + "neuDoc.txt"));
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    @Test
    public void testSentinalyze_4() {
        try {
            assertEquals("positive", s.sentinalyze(absolutePath + "comDoc.txt"));
        } catch (FileNotFoundException e) {
            fail();
        }
    }

    @Test
    public void testSentinalyze_5() {
        try {
            assertEquals("neutral", s.sentinalyze(absolutePath + "comDoc2.txt"));
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    
    @Test
    public void testSentinalyze_6() {
        try {
            assertEquals("positive", s.sentinalyze(absolutePath + "comDoc3.txt"));
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    
    @Test
    public void testSentinalyze_7() {
        try {
            assertEquals("neutral", s.sentinalyze(absolutePath + "comDoc4.txt"));
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    
    @Test
    public void testSentinalyze_8() {
        try {
            assertEquals("negative", s.sentinalyze(absolutePath + "comDoc5.txt"));
        } catch (FileNotFoundException e) {
            fail();
        }
    }
}
