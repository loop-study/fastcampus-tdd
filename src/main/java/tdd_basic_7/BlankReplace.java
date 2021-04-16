package tdd_basic_7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BlankReplace {

    public String refineText(String source) {
        return  refineText(source, new ArrayList<>());
    }

    public String refineText(String source, List<String> bannedWords) {
        return maskBannedWords(compactWhiteSpaces(normalizeWhiteSpaces(trimWhiteSpaces(source))), bannedWords);
    }

    private String trimWhiteSpaces(String source) {
        return source.trim();
    }

    private String maskBannedWords(String source, List<String> bannedWords) {
        for (String bannedWord : bannedWords) {
            source = source.replace(bannedWord, repeat(bannedWord.length()));
        }
        return source;
    }

    private String normalizeWhiteSpaces(String source) {
        return source.replace("\t", " ");
    }

    public String compactWhiteSpaces(String source) {
        return source.indexOf("  ") < 0
                ? source
                : compactWhiteSpaces(source.replace("  ", " "));
    }

    public String repeat(int length) {
        StringBuilder builder = new StringBuilder();
        IntStream.range(0, length)
                .forEach(i -> builder.append("*"));
        return builder.toString();
    }
}
