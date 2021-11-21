package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import entity.Nation;

public class WriteCSV {

    public static boolean writeFile(List<Nation> nations, String title, String path) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + "/" + title + ".csv", true));
            for(Nation nation : nations)
            {
                bufferedWriter.write("\"" + nation.getName() + "\",\"" + nation.getCode() + "\",\"" + nation.getCapital() + "\",\"" + nation.getLocation() + "\",\"" + nation.getArea() +"\"");
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
