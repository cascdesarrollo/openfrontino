package com.openfrontino.tools.security;


public class Encrypting {

    private static String SEARCH_PATTERN
            = "ABCDEFGHIJKLMNROPQRSTUVWXYZabcdefghijklmnropqrstuvwxyz1234567890!#$%&/()=?+*}]{[-_.:,;";
    private static String CRYPT_PATTERN
            = "7534216890qazcwsxedrfvtgbyhnuj!#$%&/()=?+*}]{[-_.:,;miklpoPOLIKMJUYHNBGTRFVCDEWSXZAQ><";

    public static String crypt(String _text) {
        int idx;
        String result = "";
        for (idx = 0; idx <= _text.length() - 1; idx++) {
            result = result + (cryptCharacter(_text.substring(idx, idx + 1),
                    _text.length(), idx));
        }

        return result;
    }

    private static String cryptCharacter(String _char, int _var,
            int to_index) {
        int index;
        if (SEARCH_PATTERN.contains(_char)) {
            index = (SEARCH_PATTERN.indexOf(_char) + _var + to_index)
                    % SEARCH_PATTERN.length();
            return CRYPT_PATTERN.substring(index, index + 1);
        }
        return _char;
    }

    public static String desCrypt(String _text) {

        int idx;
        String result = "";

        for (idx = 0; idx <= _text.length() - 1; idx++) {
            result = result + (desCryptChar(_text.substring(idx, idx + 1),
                    _text.length(), idx));
        }
        return result;
    }

    public static String desCryptChar(String _char, int _var,
            int a_index) {
        int index;

        if (CRYPT_PATTERN.contains(_char)) {
            if ((CRYPT_PATTERN.indexOf(_char) - _var - a_index) > 0) {
                index = (CRYPT_PATTERN.indexOf(_char) - _var
                        - a_index) % CRYPT_PATTERN.length();
            } else {
                index = (SEARCH_PATTERN.length())
                        + ((CRYPT_PATTERN.indexOf(_char) - _var
                        - a_index) % CRYPT_PATTERN.length());
            }
            index = index % CRYPT_PATTERN.length();
            return SEARCH_PATTERN.substring(index, index + 1);
        } else {
            return _char;
        }
    }

}
