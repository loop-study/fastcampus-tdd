package tdd_basic_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BlankReplaceTest {
    private BlankReplace blankReplace = new BlankReplace();

    @Test
    @DisplayName("연속된 공백 -> 하나의 공백")
    public void blackReplace() throws Exception {
        //given
        String s = "hello  world";

        //when
        boolean result = blankReplace.refineTest(s).equals("hello world");

        //then
        assertEquals(result, true);
    }

    @Test
    @DisplayName("연속된 공백 3개 -> 하나의 공백")
    public void threeBlackReplace() throws Exception {
        //given
        String s = "hello   world";

        //when
        boolean result = blankReplace.refineTest(s).equals("hello world");

        //then
        assertEquals(result, true);
    }

    @Test
    @DisplayName("연속된 공백 4개 -> 하나의 공백")
    public void fourBlackReplace() throws Exception {
        //given
        String s = "hello    world";

        //when
        boolean result = blankReplace.refineTest(s).equals("hello world");

        //then
        assertEquals(result, true);
    }

//    @Test
//    @DisplayName("배열로 테스트")
//    public void blankArrayTest() throws Exception {
//        String[] s = {"hello  world",  "hello   world",  "hello    world"};
//
//        for (int i = 0; i < s.length; i++) {
//            boolean result = blankReplace.refineTest(s[i]).equals("hello world");
//            assertEquals(result, true);
//        }
//    }

    @ParameterizedTest
    @CsvSource(value = {"hello  world",  "hello   world",  "hello    world"})
    @DisplayName("배열로 테스트")
    public void blankArrayTest(String s) throws Exception {
        boolean result = blankReplace.refineTest(s).equals("hello world");
        assertEquals(result, true);
    }
}