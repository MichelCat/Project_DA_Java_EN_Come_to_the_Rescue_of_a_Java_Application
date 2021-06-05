package test.java.com.hemebiotech.analytics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.java.com.hemebiotech.analytics.ReadSymptomDataFromFile;

class ReadSymptomDataFromFileTest extends SymptomAbstractTest {
	private static String sourceFile = referencesDirectory + "sourceFile.txt";

	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// Reading Symptoms From Source File
	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// General case
	@Test
	void testGetSymptomsNormal() {
		// Destination list
		List<String> listOfDestinationSymptoms = getListOfSourceSymptomsNormal();
		
		var readingSourceSymptoms = new ReadSymptomDataFromFile(sourceFile);
		List<String> listOfResultSymptoms = readingSourceSymptoms.getSymptoms();
		
		Assert.assertEquals(listOfDestinationSymptoms, listOfResultSymptoms);
	}
	
	// Borderline cases : Empty filename
	@Test
	void testGetSymptomsEmpty() {
		// Destination list
		List<String> listOfDestinationSymptoms = getListOfSourceSymptomsEmpty();
		
		var readingSourceSymptoms = new ReadSymptomDataFromFile("");
		List<String> listOfResultSymptoms = readingSourceSymptoms.getSymptoms();
		
		Assert.assertEquals(listOfDestinationSymptoms, listOfResultSymptoms);
	}
	
	// Borderline cases : Null filename
	@Test
	void testGetSymptomsNull() {
		// Destination list
		List<String> listOfDestinationSymptoms = getListOfSourceSymptomsEmpty();
		
		var readingSourceSymptoms = new ReadSymptomDataFromFile(null);
		List<String> listOfResultSymptoms = readingSourceSymptoms.getSymptoms();
		
		Assert.assertEquals(listOfDestinationSymptoms, listOfResultSymptoms);
	}
}
