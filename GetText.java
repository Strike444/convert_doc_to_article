package ru.andreyshimanovich;

/**
 * Created by Andrey Shimanovich on 26.04.16.
 */

import org.apache.poi.hwpf.HWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GetText {
    public void getT() throws IOException {
        DirScanner dr = new DirScanner();
        String[] s = dr.getItogmas();
        for (int i = 0; i < s.length; i++) {
            File someFile = new File(s[i]);
//        File someFile = new File("d:\\temp\\1.doc");
            System.out.println("Файл для открытия " + someFile.toString());
            System.out.println("Файл " + someFile.getName() + " открыт.");
            FileInputStream inpStrm = new FileInputStream(someFile);
            HWPFDocument wordDoc = new HWPFDocument(inpStrm);
            String st = wordDoc.getText().toString();
//        return st
            ParseString ps = new ParseString(st);
            WritetxtFile wtext = new WritetxtFile(ps.d, someFile);
        }
    }
}

