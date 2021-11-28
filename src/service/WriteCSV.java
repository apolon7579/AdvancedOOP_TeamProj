package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import entity.Nation;

//국가를 csv로 출력
public class WriteCSV {

	//csv 파일로 출력하는 메서드
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
