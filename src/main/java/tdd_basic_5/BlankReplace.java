package tdd_basic_5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BlankReplace {

    public String refineTest(String s) {
        return  refineTest(s, new ArrayList<>());
    }

    public String refineTest(String s, List<String> bannedWords) {
        s = s.replace("    ", " ")
                .replace("\t", " ")
                .replace("   ", " ")
                .replace("  ", " ")
                .replace("  ", " ")
                .replace("mockist", "*******")
                .replace("purist", "******");

        for (String bannedWord : bannedWords) {
            s = s.replace(bannedWord, repeat(bannedWord.length()));
        }

        return s;
    }

    public String repeat(int length) {
        StringBuilder builder = new StringBuilder();

        IntStream.range(0, length)
                .forEach(i -> builder.append("*"));

        return builder.toString();
    }
}
