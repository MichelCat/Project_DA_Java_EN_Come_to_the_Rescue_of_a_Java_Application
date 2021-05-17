package test.java.com.hemebiotech.analytics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.java.com.hemebiotech.analytics.ReadSymptomDataFromFile;

class ReadSymptomDataFromFileTest {
	String sourceFile = "src/test/resources/sourceReferenceFile.txt";
	String elementFever = "fever";
	String elementCough = "cough";
	String elementBlurredVision = "blurred vision";

	@Test
	void testGetSymptomsNormal() {
		// Liste destination
		List<String> listOfDestinationSymptoms = Arrays.asList(elementFever, elementCough, elementCough, elementBlurredVision, elementFever);
		
		var readingSourceSymptoms = new ReadSymptomDataFromFile(sourceFile);
		List<String> listOfResultSymptoms = readingSourceSymptoms.getSymptoms();
		
		Assert.assertEquals(listOfDestinationSymptoms, listOfResultSymptoms);
	}

}
