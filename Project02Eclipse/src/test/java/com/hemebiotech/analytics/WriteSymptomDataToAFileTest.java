package test.java.com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.java.com.hemebiotech.analytics.WriteSymptomDataToAFile;

class WriteSymptomDataToAFileTest {
	String sourceFile = "src/test/resources/resultFile.txt";
	String destinationFile = "src/test/resources/destinationReferenceFile.txt";
	String elementFever = "fever";
	String elementCough = "cough";
	String elementBlurredVision = "blurred vision";

	@Test
	void testSetSymptomsNormal() throws IOException {
		// Liste source
		List<String> listOfSourceSymptoms = Arrays.asList(elementFever + " : 2"
						, elementCough + " : 2"
						, elementBlurredVision + " : 1");
		
		// Suppression de l'ancien fichier résultat
		var resultFilePath = Paths.get(sourceFile);
		java.nio.file.Files.deleteIfExists(resultFilePath);
		
		var writingDestinationSymptoms = new WriteSymptomDataToAFile(sourceFile);
		writingDestinationSymptoms.setSymptoms(listOfSourceSymptoms);
		
		// Test fichier résultat avec fichier référence
		var destinationReferenceFilePath = Paths.get(destinationFile);
		Assert.assertEquals(Files.readString(destinationReferenceFilePath), Files.readString(resultFilePath));
	}

}
