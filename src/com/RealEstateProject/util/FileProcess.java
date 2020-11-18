package com.RealEstateProject.util;

import com.RealEstateProject.Person;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileProcess {


    public static void writePerson(List<Person> datArrayList) throws IOException {

        PrintWriter pw = null;
        FileOutputStream fo = null;
        File file = null;
        try {
            file = new File("D:\\Ders Belgeleri\\Java Projects\\Java Project 1\\person.txt");
            pw = new PrintWriter(new FileOutputStream(file));
            fo = new FileOutputStream(file);
            int datList = datArrayList.size();
            for (int i = 0; i < datList; i++) {
                pw.write(datArrayList.get(i).toString() + "\n");
            }
        } finally {
            pw.flush();
            pw.close();
            fo.close();
        }

    }

}
