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

					String tmp = String.join(",", subList);
					col[index++] = ((tmp.equals("")) ? null : tmp);
				}
				// System.out.println();
				if (col[0] == null) {
					throw new Exception("국가 이름이 없는 국가가 존재합니다. 파일을 수정하고 다시 업로드 해주세요");
				} else {
					nationList.add(new NationDto(-1, col[0], col[1], col[2], climateParser(col[3]), col[4],
							cityParser(col[5]), null, null, mediaParser(col[8]),
							((col[9] == null) ? null : Double.parseDouble(col[9])), col[10], col[11],
							languageParser(col[12]), ((col[13] == null) ? null : Integer.parseInt(col[13])), null));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nationList;
	}

	private static List<Climate> climateParser(String str) {
		if (str == null) {
			return null;
		} else {
			List<String> parsed = Arrays.asList(str.split(", "));
			return parsed.stream().map(s -> new Climate(-1, -1, s)).toList();
		}
	}

	private static List<Language> languageParser(String str) {
		if (str == null) {
			return null;
		} else {
			List<String> parsed = Arrays.asList(str.split(", "));
			return (parsed.stream().map(s -> new Language(-1, -1, s))).toList();
		}
	}

	private static List<City> cityParser(String str) {
		if (str == null) {
			return null;
		} else {
			List<String> parsed = Arrays.asList(str.split(", "));
			return parsed.stream().map(s -> new City(-1, -1, s)).toList();
		}
	}

	private static List<Media> mediaParser(String str) {
		if (str == null) {
			return null;
		} else {
			List<String> parsed = Arrays.asList(str.split(", "));
			return parsed.stream().map(s -> new Media(-1, -1, s)).toList();
		}
	}
}
