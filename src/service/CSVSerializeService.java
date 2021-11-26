package service;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.util.List;

public class CSVSerializeService {

	public static void writeFile(Path path, List<String> serializesNationList) throws Exception {
		BufferedWriter csv = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path.toString() +"\\외교부_국가·지역별_일반정보_"+ System.nanoTime() + ".csv"), "EUC-KR"));
		csv.write("국가,국가코드(ISO 2자리 코드),수도,기후,위치,주요도시,종교,주요민족,언론,면적(㎢),면적출처,면적설명,언어,기준년도\n");
		csv.flush();

		for (String str : serializesNationList) {
			csv.write(str);
			csv.flush();
		}
		csv.close();
	}
}
