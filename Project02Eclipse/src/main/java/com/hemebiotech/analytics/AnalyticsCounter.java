package main.java.com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Main class
 * @author MC
 * @version 1.0
 */
public class AnalyticsCounter {
	
	/**
	 * Main method
	 * @param args Unused
	 */
	public static void main(String[] args) {
		/**
		 * Production directory : ressource
		 */
		var ressourceDirectory = "src/main/resources/";
		
		// Reading Symptoms From Source File
		var readingSourceSymptoms = new ReadSymptomDataFromFile(ressourceDirectory + "symptoms.txt");
		List<String> listOfSourceSymptoms = readingSourceSymptoms.getSymptoms();
		
		var treatsOccurrencesOfSymptoms = new CountsSymptomOccurrences();
		// Counting of symptom occurrence numbers
		Map<String, Integer> listOfSymptomOccurrences = treatsOccurrencesOfSymptoms.getListOfSymptomOccurrences(listOfSourceSymptoms);
		// Generating the list of symptom occurrence numbers to write
		List<String> listOfDestinationSymptoms = treatsOccurrencesOfSymptoms.getListOfWrittenSymptoms(listOfSymptomOccurrences);
		
		// Writing symptoms in the result file
		var writingDestinationSymptoms = new WriteSymptomDataToAFile(ressourceDirectory + "result.out");
		writingDestinationSymptoms.setSymptoms(listOfDestinationSymptoms);
	}
}
