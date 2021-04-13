package tdd_basic_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tdd_basic_5.BlankReplace;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlankReplaceTest {
    private BlankReplace blankReplace = new BlankReplace();

    @ParameterizedTest
    @CsvSource(value = {"hello  world"
                     ,  "hello   world"
                     ,  "hello    world"
                     ,  "hello     world"
                     ,  "hello      world"
                     ,  "hello           world"})
    @DisplayName("배열로 테스트")
    public void blankArrayTest(String s) throws Exception {
        boolean result = blankReplace.refineTest(s).equals("hello world");
        assertEquals(result, true);
    }

    @ParameterizedTest
    @CsvSource(value = {"hello\t world", "hello \tworld"})
    @DisplayName("tab 공백 테스트")
    public void tabTest(String s) throws Exception {
        boolean result = blankReplace.refineTest(s).equals("hello world");
        assertEquals(result, true);
    }

    @ParameterizedTest
    @CsvSource(value = {"hello mockist,*******", "hello purist,******"})
    @DisplayName("금지어 마스킹 테스트")
    public void maskingTest(String s, String masking) throws Exception {
        boolean result = blankReplace.refineTest(s).equals("hello " + masking);
        assertEquals(result, true);
    }


    @ParameterizedTest
    @CsvSource(value = {"dkne", "dkjksd", "bmndkf"})
    @DisplayName("금지어 마스킹 테스트")
    public void randomWordsMaskingTest(String word) throws Exception {
        List<String> bannedWords = Arrays.asList(new String[]{"dkne", "dkjksd", "bmndkf"});
        String s = "hello " + word;
        String actual = "hello " + blankReplace.repeat(word.length());

        boolean result = blankReplace.refineTest(s, bannedWords).equals(actual);
        assertEquals(result, true);
    }
}