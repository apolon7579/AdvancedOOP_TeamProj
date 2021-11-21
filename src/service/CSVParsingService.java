package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import dto.NationDto;
import entity.City;
import entity.Climate;
import entity.Language;
import entity.Media;

public class CSVParsingService {

	public static void main(String[] args) {
		List<NationDto> list = CSVParsingService
				.readFile("C:\\Users\\mjk49\\Desktop\\학교공부\\2-2\\고급객체지향프로그래밍\\조별과제 자료\\외교부_국가·지역별 일반정보_20201231.csv");
		System.out.println(list.size());
		for (NationDto n : list) { System.out.println(n); }

	}

	public static List<NationDto> readFile(String path) {
		List<NationDto> nationList = new LinkedList<>();
		try (BufferedReader csv = new BufferedReader(new FileReader(path))) {
			if (csv.readLine().split(",").length != 14) {
				throw new Exception("칼럼이 14개여야 합니다.");
			}

			String line = null;
			List<String> parsed = new ArrayList<>();
			while ((line = csv.readLine()) != null) {
				parsed = Arrays.asList(line.split(","));
				String[] col = new String[14];
				int index = 0;

				for (int i = 0; i < parsed.size(); i++) {
					ArrayList<String> subList = new ArrayList<>();
					if (parsed.get(i).contains("\"")) {
						subList.add(parsed.get(i++).replace("\"", ""));
						for (; i < parsed.size(); i++) {
							if (!parsed.get(i).contains("\"")) {
								subList.add(parsed.get(i));
							} else {
								break;
							}
						}
						subList.add(parsed.get(i).replace("\"", ""));
					} else {
						subList.add(parsed.get(i));
					}

					col[index++] = String.join(",", subList);
				}
				//System.out.println();
				nationList.add(new NationDto(-1, col[0], col[1], col[2], climateParser(col[3]), col[4], cityParser(col[5]), null, null, mediaParser(col[8]),
						((col[9].equals("")) ? null : Double.parseDouble(col[9])), col[10], col[11], languageParser(col[12]),
						Integer.parseInt(col[13]), null));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nationList;
	}
	
	private static List<Climate> climateParser(String str){
		List<String> parsed = Arrays.asList(str.split(", "));
		return parsed.stream().map(s->new Climate(-1, -1, s)).toList();
	}
	
	private static List<Language> languageParser(String str){
		List<String> parsed = Arrays.asList(str.split(", "));
		return (parsed.stream().map(s->new Language(-1, -1, s))).toList();
		
	}
	
	private static List<City> cityParser(String str){
		List<String> parsed = Arrays.asList(str.split(", "));
		return parsed.stream().map(s->new City(-1, -1, s)).toList();
	}
	
	private static List<Media> mediaParser(String str){
		List<String> parsed = Arrays.asList(str.split(", "));
		return parsed.stream().map(s->new Media(-1, -1, s)).toList();
	}
}
