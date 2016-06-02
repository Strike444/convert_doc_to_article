package ru.andreyshimanovich;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Created by strike on 13.05.16.
 */
public class WritetxtFile {
        WritetxtFile(String a, File pathfail) {
        PrintWriter pw = null;
//            String pf = pathfail;
//            System.out.println("НУКА " + pf );
        try {
//            pw = new PrintWriter(new FileOutputStream("d:\\temp\\1.txt"));
            if (System.getProperty("os.name").equals("Linux")) {
                String home = System.getProperty("user.home");
                File f = new File(home + "/article/");
                if (f.exists() && f.isDirectory()) {
//                    System.out.println("Каталог существует");
                }
                else {
                    f.mkdirs();
                }
                pw = new PrintWriter(new FileOutputStream("/home/strike/article/" + pathfail.getName().replaceAll(".doc", "") + ".txt"));
//            System.out.println("ТРА ля ля " + pathfail.toString());
            }
            else {
                pw = new PrintWriter(new FileOutputStream("d:\\temp\\" + pathfail.getName().replaceAll(".doc", "") + ".txt"));
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("Ошибка открытия файла txt");
            System.exit(0);
        }
        pw.println(a);
        pw.close();
        System.out.println("Файл " + pathfail.getName().replaceAll(".doc","") + ".txt записан.");
    }
}
