package hello.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

@Service
public class ParsingExcelCSVFile {

	public void parse(String filename) {

		Reader in = null;
		try {
			in = new FileReader(filename);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		Iterable<CSVRecord> records = null;
		try {
			records = CSVFormat.EXCEL.parse(in);
		} catch (IOException e) {

			e.printStackTrace();
		}
		for (CSVRecord record : records) {
			String cardtoken = record.get("P_08_CARD_TOKEN");
			String falhas = record.get("QTD_FALHAS");
		}
	}

	public void parseHeaders(String filename) {
		Reader in = null;
		try {
			in = new FileReader(filename);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		Iterable<CSVRecord> records = null;
		try {
			records = CSVFormat.RFC4180.withHeader(Headers.class).parse(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (CSVRecord record : records) {
			String cardToken = record.get(Headers.P_08_CARD_TOKEN);
			String falhas = record.get(Headers.QTD_FALHAS);
			
		}

	}

}
