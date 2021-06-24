package com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class WriteSymptomDataToAFileTest extends SymptomAbstractTest {
	private static String resultFile = workDirectory + "resultFile.txt";
	private static String destinationFile = referencesDirectory + "destinationFile.txt";

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
		var resultFilePath = Paths.get(resultFile);
		java.nio.file.Files.deleteIfExists(resultFilePath);
		
		var writingDestinationSymptoms = new WriteSymptomDataToAFile(resultFile);
		int returnCode = writingDestinationSymptoms.setSymptoms(listOfSourceSymptoms);
		Assert.assertEquals(0, returnCode);
		
		// Test result file with reference file
		var destinationReferenceFilePath = Paths.get(destinationFile);
		Assert.assertEquals(Files.readString(destinationReferenceFilePath), Files.readString(resultFilePath));
	}
	
	// Borderline cases : Empty filename
	@Test
	void testSetSymptomsEmpty() {
		// Source list
		List<String> listOfSourceSymptoms = getListOfWrittenSymptomsNormal();
		
		var writingDestinationSymptoms = new WriteSymptomDataToAFile("");
		int returnCode = writingDestinationSymptoms.setSymptoms(listOfSourceSymptoms);
		Assert.assertEquals(-1, returnCode);
	}
	
	// Borderline cases : Null filename
	@Test
	void testSetSymptomsNull() {
		// Source list
		List<String> listOfSourceSymptoms = getListOfWrittenSymptomsNormal();
		
		var writingDestinationSymptoms = new WriteSymptomDataToAFile(null);
		int returnCode = writingDestinationSymptoms.setSymptoms(listOfSourceSymptoms);
		Assert.assertEquals(-3, returnCode);
	}
}
