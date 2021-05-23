package test.java.com.hemebiotech.analytics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.java.com.hemebiotech.analytics.CountsSymptomOccurrences;

class CountsSymptomOccurrencesTest extends MethodsCommonToSymptoms {

	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// Counting of symptom occurrence numbers
	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// General case
	@Test
	void testGetListOfSymptomOccurrencesNormal() {
		// Source list
		List<String> listOfSourceSymptoms = getListOfSourceSymptomsNormal();
		// Destination list
		Map<String, Integer> listOfDestinationSymptoms = getListOfSymptomOccurrencesNormal();
		
		var treatsOccurrencesOfSymptoms = new CountsSymptomOccurrences();
		Map<String, Integer> listOfResultSymptoms = treatsOccurrencesOfSymptoms.getListOfSymptomOccurrences(listOfSourceSymptoms);
		
		Assert.assertEquals(listOfDestinationSymptoms, listOfResultSymptoms);
	}

	// Borderline cases : Empty list
	@Test
	void testGetListOfSymptomOccurrencesEmpty() {
		// Source list
		List<String> listOfSourceSymptoms = getListOfSourceSymptomsEmpty();
		// Destination list
		Map<String, Integer> listOfDestinationSymptoms = getListOfSymptomOccurrencesEmpty();
		
		var treatsOccurrencesOfSymptoms = new CountsSymptomOccurrences();
		Map<String, Integer> listOfResultSymptoms = treatsOccurrencesOfSymptoms.getListOfSymptomOccurrences(listOfSourceSymptoms);
		
		Assert.assertEquals(listOfDestinationSymptoms, listOfResultSymptoms);
	}
	

	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// Generating the list of symptom occurrence numbers to write
	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// General case
	@Test
	void testGetListOfWrittenSymptomsNormal() {
		// Source list
		Map<String, Integer> listOfSourceSymptoms = getListOfSymptomOccurrencesNormal();
		// Destination list
		List<String> listOfDestinationSymptoms = getListOfWrittenSymptomsNormal();
		
		var treatsOccurrencesOfSymptoms = new CountsSymptomOccurrences();
		List<String> listOfResultSymptoms = treatsOccurrencesOfSymptoms.getListOfWrittenSymptoms(listOfSourceSymptoms);
		
		Assert.assertEquals(listOfDestinationSymptoms, listOfResultSymptoms);
	}

	// Borderline cases : Empty list
	@Test
	void testGetListOfWrittenSymptomsEmpty() {
		// Source list
		Map<String, Integer> listOfSourceSymptoms = getListOfSymptomOccurrencesEmpty();
		// Destination list
		List<String> listOfDestinationSymptoms = getListOfWrittenSymptomsEmpty();
		
		var treatsOccurrencesOfSymptoms = new CountsSymptomOccurrences();
		List<String> listOfResultSymptoms = treatsOccurrencesOfSymptoms.getListOfWrittenSymptoms(listOfSourceSymptoms);
		
		Assert.assertEquals(listOfDestinationSymptoms, listOfResultSymptoms);
	}
}
