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
        int ia = 0;
        int iaa = 0;
        int iaaa = 0;

        // TODO тут не правильно
        while (b[ia].matches("\\s.*")) {
            b[ia] = b[ia].replaceFirst("\\s", "");
            System.out.println("Найдены пробелы устраняю !!!" + b[ia] );
            ia++;
        }

        for (int i = 0; i < b.length ; i++) {
            b[i] = b[i].replaceAll("[\\u00A0\\s]+", " ");
        }

        for (int i = 0; i < b.length ; i++) {
            b[i] = b[i].trim();
        }


//        for (int i = 0; i < b.length; i++) {
//            b[i] = b[i].trim();
//            b[i] = b[i].replaceAll("\\s+", " ").replaceAll("\\s$", "");
//            System.out.println("***" + b[i]);
//            while (b[i].matches("\\s.*")) {
//                b[i] = b[i].replaceFirst("\\s", "");
//                System.out.println("Найдены пробелы устраняю !!!" + b[i] );
//            }
//        }

        // remove extra tabs
//        for (int i = 0; i < b.length; i++) {
//            b[i] = b[i].replaceAll("\\t+", " ").replaceAll("\\t$", "");
//            if (b[i].matches("\\t.*")) {
//                b[i] = b[i].replaceFirst("\\t", "");
//                System.out.println("Найдены табы устраняю !!!" + b[i] );
//            }
//        }



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
        // TODO Что-то не то
        for (int ffff = 0; ffff < list.size(); ffff++) {
            if (list.get(ffff).matches("[^\\wА-яЁё]+")) {
                System.out.println("Ага");
                System.out.println("Ага: " + list.get(ffff));
                list.remove(ffff);
            }
        }
        for (int ffa = 0; ffa < list.size(); ffa++) {
            if (list.get(ffa).length() == 0) {
//                System.out.println("выловил еще значение с нулевой длинной");
                list.remove(ffa);
            }
        }

        try {

            if ((list.get(list.size() - 4).matches("Отдел ПФР в Новозыбковском муниципальном районе")) || list.get(list.size() - 6).matches("Отдел ПФР в Новозыбковском муниципальном районе")) {
                System.out.println("Обнаружен пресс-рулиз от ПФР 4");
                for (int fff = 0; fff < 4; fff++) {
                    list.remove(list.size() - 1);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Файл не ПФР");
        }

        try {

            if ((list.get(list.size() - 5).matches("Отдел ПФР в Новозыбковском муниципальном районе")) || list.get(list.size() - 6).matches("Отдел ПФР в Новозыбковском муниципальном районе")) {
                System.out.println("Обнаружен пресс-рулиз от ПФР 5");
                for (int fff = 0; fff < 5; fff++) {
                    list.remove(list.size() - 1);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Файл не ПФР");
        }

//        for (int fff = 0; fff < list.size(); fff++) {
//            if (list.get(fff).matches("")) {
////                System.out.println("выловил еще значение с нулевой длинной");
//                list.remove(ff);
//            }
//        }


        list.set(0, "<p style=\"line-height: normal; text-align: justify;\">" + list.get(0) + "</p>\n<hr id=\"system-readmore\" />");

        for (int h = 1; h < list.size(); h++) {
            list.set(h, "<p style=\"line-height: normal; text-align: justify;\">" + list.get(h) + "<br /><br /></p>");
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
