package com.jonwelzel.webdevtest.server.core.utils;

/**
 * Created by jwelzel on 25/08/15.
 */
public class StringUtils {

    public static final char DEFAULT_MASK_CHAR = '*';

    public static String maskName(String name) {
        return maskString(name, " ", true);
    }

    public static String maskEmail(String email) {
        String _email = maskString(email, "@", true);
        return _email.replace(" ", "@");
    }

    public static String maskString(String content, String splitter, boolean spacePostfix) {
        StringBuilder sentenceReformed = new StringBuilder();
        for (String word : content.split(splitter)) {
            sentenceReformed.append(maskWord(word, DEFAULT_MASK_CHAR));
            if(spacePostfix) {
                sentenceReformed.append(" ");
            }
        }
        return sentenceReformed.toString().trim();
    }

    public static String maskWord(String word, char maskChar) {
        StringBuilder ret = new StringBuilder();
        if (word.length() > 2) {
            ret.append(word.charAt(0));
            for (int i = 1; i < word.length() - 1; i++) {
                ret.append(maskChar);
            }
            ret.append(word.charAt(word.length() - 1));
            return ret.toString();
        }

        return word;
    }

}
