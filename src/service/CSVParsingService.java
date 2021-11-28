package service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import dto.NationDto;
import entity.City;
import entity.Climate;
import entity.Language;
import entity.Media;
import entity.Race;
import entity.Religion;

//csv 파심을 담당하는 서비스
public class CSVParsingService {

	//파일을 읽어 한줄씩 파싱
	public static List<NationDto> readFile(Path path) throws Exception {
		List<NationDto> nationList = new LinkedList<>();
		BufferedReader csv = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString()), "UTF-8"));
		if (csv.readLine().split(",").length != 14) {
			throw new Exception("칼럼이 14개인 공공데이터 형식이 아닙니다.");
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
			if (col[0] == null) {
				throw new Exception("국가 이름이 없는 행이 존재합니다. 올바른 파일을 다시 업로드 해주세요");
			} else {
				nationList.add(new NationDto(-1, col[0], col[1], col[2], climateParser(col[3]), col[4],
						cityParser(col[5]), religionParser(col[6]), raceParser(col[7]), mediaParser(col[8]),
						((col[9] == null) ? null : Double.parseDouble(col[9])), col[10], col[11],
						languageParser(col[12]), ((col[13] == null) ? null : Integer.parseInt(col[13])), null));
			}
		}
		csv.close();
		return nationList;
	}

	//괄호안의 컴마를 무시하여 파싱하는 메서드
	private static List<String> ignoreParenthesisInComma(String origin) {
		if (origin == null)
			return null;
		List<String> parsed = Arrays.asList(origin.split(","));
		List<String> parenthesisIgnored = new ArrayList<>();

		for (int i = 0; i < parsed.size(); i++) {
			ArrayList<String> subList = new ArrayList<>();
			if (parsed.get(i).contains("(")) {
				for (; i < parsed.size(); i++) {
					if (!parsed.get(i).contains(")")) {
						subList.add(parsed.get(i));
					} else {
						break;
					}
				}
				subList.add(parsed.get(i));
			} else {
				subList.add(parsed.get(i));
			}

			parenthesisIgnored.add(String.join(",", subList).trim());
		}
		return parenthesisIgnored;
	}

	//인종 파서
	private static List<Race> raceParser(String str) {
		if (str == null)
			return null;
		List<String> parsed = ignoreParenthesisInComma(str);

		List<Race> raceList = new ArrayList<>();
		for (int i = 0; i < parsed.size(); i++) {
			if (!parsed.get(i).contains("%")) {
				raceList.add(new Race(-1, -1, parsed.get(i), null));
			} else {
				StringBuilder builder = new StringBuilder();
				int index = (parsed.get(i).indexOf("%") - 1);
				for (; index >= 0; index--) {
					char ch = parsed.get(i).charAt(index);
					if (('0' <= ch && ch <= '9') || ch == '.') {
						builder.append(ch);
					} else {
						break;
					}
				}
				try {
					raceList.add(new Race(-1, -1, parsed.get(i), Double.parseDouble(builder.reverse().toString())));
				} catch (Exception e) {
					raceList.add(new Race(-1, -1, parsed.get(i), null));
				}
			}
		}
		return raceList;
	}

	//종교 파서
	private static List<Religion> religionParser(String str) {
		if (str == null)
			return null;
		List<String> parsed = ignoreParenthesisInComma(str);

		List<Religion> religionList = new ArrayList<>();
		for (int i = 0; i < parsed.size(); i++) {
			if (!parsed.get(i).contains("%")) {
				religionList.add(new Religion(-1, -1, parsed.get(i), null));
			} else {
				StringBuilder builder = new StringBuilder();
				int index = (parsed.get(i).indexOf("%") - 1);
				for (; index >= 0; index--) {
					char ch = parsed.get(i).charAt(index);
					if (('0' <= ch && ch <= '9') || ch == '.') {
						builder.append(ch);
					} else {
						break;
					}
				}
				try {
					religionList.add(new Religion(-1, -1, parsed.get(i), Double.parseDouble(builder.reverse().toString())));
				} catch (Exception e) {
					religionList.add(new Religion(-1, -1, parsed.get(i), null));
				}
			}
		}
		return religionList;
	}

	//기후 파서
	private static List<Climate> climateParser(String str) {
		if (str == null) {
			return null;
		} else {
			List<String> parsed = ignoreParenthesisInComma(str);
			return parsed.stream().map(s -> new Climate(-1, -1, s)).toList();
		}
	}

	//언어 파서
	private static List<Language> languageParser(String str) {
		if (str == null) {
			return null;
		} else {
			List<String> parsed = ignoreParenthesisInComma(str);
			return (parsed.stream().map(s -> new Language(-1, -1, s))).toList();
		}
	}

	//도시 파서
	private static List<City> cityParser(String str) {
		if (str == null) {
			return null;
		} else {
			List<String> parsed = ignoreParenthesisInComma(str);
			return parsed.stream().map(s -> new City(-1, -1, s)).toList();
		}
	}

	//매체 파서
	private static List<Media> mediaParser(String str) {
		if (str == null) {
			return null;
		} else {
			List<String> parsed = ignoreParenthesisInComma(str);
			return parsed.stream().map(s -> new Media(-1, -1, s)).toList();
		}
	}
}
