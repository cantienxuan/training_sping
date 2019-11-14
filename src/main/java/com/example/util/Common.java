package com.example.util;

public class Common {

    public static final String REGEX_DIGIT = "\\d+";

    /**
     * Hàm replace kí tự space và -
     * @param input input truyền vào
     * @return chuỗi đã loại bỏ space và -
     */
    public static String replaceInput(String input) {
        return input.replace(" ", "").replace("-", "");

    }

    /**
     * Hàm kiểm tra null và regex số
     * @param stringInput string truyền vào
     * @return true nếu thỏa mãn k null và là số halfsize, false nếu không
     */
    public static boolean checkInput(String stringInput) {
        boolean isOK = false;

        if (stringInput != null) {
            if (stringInput.matches(Common.REGEX_DIGIT)) {
                isOK = true;
            }
        }

        return isOK;
    }
}
