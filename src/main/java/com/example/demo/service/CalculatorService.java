package com.example.demo.service;

import java.util.List;

public class CalculatorService {

    public int sumList(List<Integer> list) {
        if (list == null) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            result = result + list.get(i);
        }

        return result;
    }

    /**
     * Return the number of occurrence of toSearch in list
     * @param list the list of element
     * @param toSearch the value to search
     * @return the number of occurrence
     */
    public int occurrence(List<String> list, String toSearch) {
        if (list == null) {
            return 0;
        }

        int result = 0;

        for (String s : list) {

            if (s != null && s.equals(toSearch)) {
                result++;
            }
            if (s == null && toSearch == null) {
                result ++;
            }
        }
        return result;
    }
}
