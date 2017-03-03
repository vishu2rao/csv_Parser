/**
 * 
 */
package com.vishu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * @author visweswarar
 *
 */
public class csvColRead {

	/**
	 * 
	 */
	public csvColRead() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */

	public static void main(String[] args) throws Exception {

		String myCurrentDir = System.getProperty("user.dir") + File.separator + "src" + File.separator
				+ System.getProperty("sun.java.command")
						.substring(0, System.getProperty("sun.java.command").lastIndexOf("."))
						.replace(".", File.separator);

		System.out.println("MyFile->" + myCurrentDir);

		System.out.println("-------------------------------------");
		Reader in = new FileReader(myCurrentDir + File.separator + "test.csv");
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

		System.out.println("Column size ");
		int row = 0;
		int size = 0;
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();

		// Process each record
		for (CSVRecord record : records) {
			List<String> list = new ArrayList<String>();
			size = (int) record.size();
			for (int i = 0; i < size; i++) {
				String val = record.get(i);
				if (val != null) {
					list.add(val);
				}
			}
			map.put(row++, list);
		}

		System.out.println("CSV records :" + map);

		/* following logic is to print the map with grouped column vaues */
		System.out.println("Column Groups");
		int col = 0;
		while (true) {
			if (col >= size)
				break;
			for (int i = 0; i < row; i++) {
				List<String> list = map.get((Integer) i);
				try {
					String val = list.get(col);

					// Here you can have this value to any of the data structure
					// you wanted
					// Can be mapped, listed etc
					System.out.println(val);
				} catch (Exception e) {
					continue;
				}
			}
			col++;
			System.out.println("==============================================");
		}
	}
}
