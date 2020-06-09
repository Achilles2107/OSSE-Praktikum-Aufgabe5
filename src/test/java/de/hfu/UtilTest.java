package de.hfu;

import org.junit.Test;

import static org.junit.Assert.*;
import static de.hfu.Util.*;

public class UtilTest {


    /**
     * Checks the valid Inputs 1-6
     */
    @Test
        public void validDate() {

        for (int i = 1; i <= 12; ++i) {
            if (i <= 6) {
                assertTrue(istErstesHalbjahr(i));
            } else {
                assertFalse(istErstesHalbjahr(i));
            }
        }
    }

        /**
        *  Exception Test
        */

        @Test(expected=IllegalArgumentException.class)
        public void invalidDate(){
                assertFalse(istErstesHalbjahr(-12));
                assertFalse(istErstesHalbjahr(21));
                assertFalse(istErstesHalbjahr(0));
        }

}