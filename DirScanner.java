package ru.andreyshimanovich;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Created by Андрей on 21.05.2016.
 */
public class DirScanner {
    private String[] itogmas = {};
    DirScanner() {
        Scanner input = new Scanner(System.in);
        File f;
        String path, file;
        boolean result = false;
 //       System.out.println("Enter the required path for search: ");
        path = "d:\\temp\\";
//        path = input.nextLine();
        f = new File(path);
//        f = new File(path + ".");
//        System.out.println("Enter the name of required file: ");
//        file = input.nextLine();
        File[] filesindir = f.listFiles();
        // Перегоняем в ArreyList для выкидования не нужных файлов
        ArrayList<File> listfiles = new ArrayList<>();
        ArrayList<String> listdocfiles = new ArrayList<>();


        for (int k = 0; k < filesindir.length; k++) {
            listfiles.add(k, filesindir[k]);
        }

        for (int i = 0; i < listfiles.size(); i++) {
//            if (files[i].toString().equals(path + ".\\" + file) && files[i].isFile()) {
//                result = true;
//                break;
//            }
            if (listfiles.get(i).toString().matches(".*.doc")) {

                System.out.println(listfiles.get(i));
                listdocfiles.add(listfiles.get(i).toString());
            }
        }
//        System.out.println(listdocfiles);
//        System.out.println(listdocfiles.size());
        // Переводим в массив
        String[] myArrayDoc = {};

        myArrayDoc = listdocfiles.toArray(new String[listdocfiles.size()]);
        itogmas = myArrayDoc;
//        if (result == true)
//            System.out.println("File located in the folder");
//        else System.out.println("File was not found ");
    }
    public String[] getItogmas(){
        return  itogmas;
    }
}
