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

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * @author visweswarar
 *
 */
public class csvTest {

	/**
	 * 
	 */
	public csvTest() {
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
		List<HashMap<String, String>> listOfColumns = new ArrayList<HashMap<String, String>>();

		System.out.println("-------------------------------------");
		Reader in = new FileReader(myCurrentDir + File.separator + "test.csv");
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		int cSize = records.iterator().next().size();
		System.out.println("Column size " + cSize);
		// CSVRecord record=null;
		HashMap<String, String> colMap = new HashMap<String, String>();
		
		for (int i = 0; i < cSize; i++) {
			for (CSVRecord record : records) {
				// System.out.println("Column size "+record.size());
				colMap.put(String.valueOf(i), record.get(i));
				System.out.println(record.get(i));

				// System.out.println("CSV rocords are:
				// "+record.getRecordNumber());
			}
			System.out.println("==========================");
		}

	}
}
