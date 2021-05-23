package test.java.com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.java.com.hemebiotech.analytics.WriteSymptomDataToAFile;

class WriteSymptomDataToAFileTest extends MethodsCommonToSymptoms {
	String sourceFile = "src/test/resources/resultFile.txt";
	String destinationFile = "src/test/resources/destinationReferenceFile.txt";

	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// Writing symptoms in the result file
	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// General case
	@Test
	void testSetSymptomsNormal() throws IOException {
		// Source list
		List<String> listOfSourceSymptoms = getListOfWrittenSymptomsNormal();
		
		// Deletion of the old result file
		var resultFilePath = Paths.get(sourceFile);
		java.nio.file.Files.deleteIfExists(resultFilePath);
		
		var writingDestinationSymptoms = new WriteSymptomDataToAFile(sourceFile);
		writingDestinationSymptoms.setSymptoms(listOfSourceSymptoms);
		
		// Test result file with reference file
		var destinationReferenceFilePath = Paths.get(destinationFile);
		Assert.assertEquals(Files.readString(destinationReferenceFilePath), Files.readString(resultFilePath));
	}
}
