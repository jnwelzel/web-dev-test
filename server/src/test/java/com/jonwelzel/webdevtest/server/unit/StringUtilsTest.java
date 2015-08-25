package com.jonwelzel.webdevtest.server.unit;

import com.jonwelzel.webdevtest.server.core.utils.StringUtils;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jwelzel on 25/08/15.
 */
public class StringUtilsTest {

    @Test
    public void shouldMaskName() {
        String name = "Jonathan Welzel";
        String result = StringUtils.maskName(name);
        char firstChar = result.charAt(0);
        char lastChar = result.charAt(result.length() - 1);
        int maskCharCount = countMaskChars(result);

        assertThat(firstChar).isEqualTo('J');
        assertThat(lastChar).isEqualTo('l');
        assertThat(name.length()).isEqualTo(result.length());
        assertThat(maskCharCount).isEqualTo(10);
    }

    @Test
    public void shouldMaskEmail() {
        String email = "jnwelzel@gmail.com";
        String result = StringUtils.maskEmail(email);
        int maskCharCount = countMaskChars(result);

        assertThat(email.length()).isEqualTo(result.length());
        assertThat(maskCharCount).isEqualTo(13);
    }

    private int countMaskChars(String text) {
        int maskCharCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == StringUtils.DEFAULT_MASK_CHAR) {
                maskCharCount++;
            }
        }
        return maskCharCount;
    }

}
