package utils;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;


public class In {
    private Scanner sc;

    public In(String path) {
        sc = null;
        try {
            sc = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getLine() {
        return sc.nextLine();
    }

    public boolean hasNextLine(){
        return sc.hasNextLine();
    }


}
