package hello.csv;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParsingExcelCSVTest {
	
	@Autowired
	private ParsingExcelCSVFile parsingExcelCSVFile;
	
	@Test
	public void teste() {
		//ClassPathResource resource = new ClassPathResource("teste.csv", getClass());
		parsingExcelCSVFile.parseHeaders("/home/rogerio/work/app-forms/uploading/src/test/resources/hello/teste.csv");
		
	}

}
