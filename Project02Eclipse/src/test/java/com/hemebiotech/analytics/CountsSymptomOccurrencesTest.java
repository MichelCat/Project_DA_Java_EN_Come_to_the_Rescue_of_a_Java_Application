package test.java.com.hemebiotech.analytics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.java.com.hemebiotech.analytics.CountsSymptomOccurrences;

class CountsSymptomOccurrencesTest {
	String elementFever = "fever";
	String elementCough = "cough";
	String elementBlurredVision = "blurred vision";

	@Test
	void testGetListOfSymptomOccurrencesNormal() {
		// Liste source
		List<String> listOfSourceSymptoms = Arrays.asList(elementFever, elementCough, elementCough, elementBlurredVision, elementFever);
		// Liste destination
		Map<String, Integer> listOfDestinationSymptoms = new HashMap<>();
		listOfDestinationSymptoms.put(elementFever, 2);
		listOfDestinationSymptoms.put(elementCough, 2);
		listOfDestinationSymptoms.put(elementBlurredVision, 1);
		
		var treatsOccurrencesOfSymptoms = new CountsSymptomOccurrences();
		Map<String, Integer> listOfResultSymptoms = treatsOccurrencesOfSymptoms.getListOfSymptomOccurrences(listOfSourceSymptoms);
		
		Assert.assertEquals(listOfDestinationSymptoms, listOfResultSymptoms);
	}

	@Test
	void testGetListOfSymptomOccurrencesEmpty() {
		// Liste source
		List<String> listOfSourceSymptoms = Arrays.asList();
		// Liste destination
		Map<String, Integer> listOfDestinationSymptoms = new HashMap<>();
		
		var treatsOccurrencesOfSymptoms = new CountsSymptomOccurrences();
		Map<String, Integer> listOfResultSymptoms = treatsOccurrencesOfSymptoms.getListOfSymptomOccurrences(listOfSourceSymptoms);
		
		Assert.assertEquals(listOfDestinationSymptoms, listOfResultSymptoms);
	}

	@Test
	void testGetListOfWrittenSymptomsNormal() {
		// Liste source
		Map<String, Integer> listOfSourceSymptoms = new HashMap<>();
		listOfSourceSymptoms.put(elementFever, 2);
		listOfSourceSymptoms.put(elementCough, 2);
		listOfSourceSymptoms.put(elementBlurredVision, 1);
		// Liste destination
		List<String> listOfDestinationSymptoms = Arrays.asList(elementFever + " : 2"
						, elementCough + " : 2"
						, elementBlurredVision + " : 1");
		
		var treatsOccurrencesOfSymptoms = new CountsSymptomOccurrences();
		List<String> listOfResultSymptoms = treatsOccurrencesOfSymptoms.getListOfWrittenSymptoms(listOfSourceSymptoms);
		
		Assert.assertEquals(listOfDestinationSymptoms, listOfResultSymptoms);
	}

	@Test
	void testGetListOfWrittenSymptomsEmpty() {
		// Liste source
		Map<String, Integer> listOfSourceSymptoms = new HashMap<>();
		// Liste destination
		List<String> listOfDestinationSymptoms = Arrays.asList();
		
		var treatsOccurrencesOfSymptoms = new CountsSymptomOccurrences();
		List<String> listOfResultSymptoms = treatsOccurrencesOfSymptoms.getListOfWrittenSymptoms(listOfSourceSymptoms);
		
		Assert.assertEquals(listOfDestinationSymptoms, listOfResultSymptoms);
	}

}
