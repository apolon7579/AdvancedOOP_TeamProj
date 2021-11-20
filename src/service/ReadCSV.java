package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import dto.NationDto;
import entity.Nation;

public class ReadCSV {

	public static void main(String[] args) {
		List<NationDto> list = ReadCSV.readFile("");
		System.out.println(list.size());
		for (NationDto n : list) {
			System.out.println(n);
		}

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
				ArrayList<ArrayList<String>> col = new ArrayList<>();

				for (int i = 0; i < parsed.size(); i++) {
					ArrayList<String> subList = new ArrayList<>();
					if (parsed.get(i).contains("\"")) {
						subList.add(parsed.get(i++).replace('\"', '\0'));
						for (; i < parsed.size(); i++) {
							if (!parsed.get(i).contains("\"")) {
								subList.add(parsed.get(i));
							} else {
								break;
							}
						}
						subList.add(parsed.get(i).replace('\"', '\0'));
					} else {
						subList.add(parsed.get(i));
					}
					col.add(subList);
				}

				nationList.add(new NationDto(-1, col.get(0).get(0), col.get(1).get(0), col.get(2).get(0), null,
						col.get(4).get(0), null, null, null, null,
						((col.get(9).get(0).equals("")) ? null : Double.parseDouble(col.get(9).get(0))),
						col.get(10).get(0), col.get(11).get(0), null, Integer.parseInt(col.get(13).get(0)), null));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nationList;
	}

}
