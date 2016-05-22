package ru.andreyshimanovich;

import com.sun.deploy.util.StringUtils;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by strike on 14.05.16.
 */
public class ParseString {
    public String d;

    ParseString(String a) {
        String[] b = a.split("\r");
        String c = "";

        // remove extra spaces
        for (int i = 0; i < b.length; i++) {
            b[i] = b[i].replaceAll("\\s+", " ").replaceAll("\\s$", "");
            if (b[i].matches("\\s.*")) {
                b[i] = b[i].replaceFirst("\\s", "");
            }
        }

        ArrayList<String> list = new ArrayList<>();

        for (int k = 0; k < b.length; k++) {
            list.add(k, b[k]);
        }

        for (int f = 0; f < list.size(); f++) {
            if (list.get(f).equals("")) {
//                System.out.println("выловил пустое значение");
                list.remove(f);
            }
        }

        for (int ff = 0; ff < list.size(); ff++) {
            if (list.get(ff).length() == 0) {
//                System.out.println("выловил еще значение с нулевой длинной");
                list.remove(ff);
            }
        }

//        for (int kk = 0; kk < list.size(); kk++) {
//            System.out.println("list clear " + list.get(kk) + " " + list.get(kk).length());
//        }

//        System.out.println("конец " + list.get(list.size() - 1).length());

        String[] myArray = {}; // конвертируем ArrayList в массив
        myArray = list.toArray(new String[list.size()]);

        for (int fff = 0; fff < myArray.length; fff++) {
            c = c + myArray[fff] + "\r\n";
        }

        d = c;
    }
}
