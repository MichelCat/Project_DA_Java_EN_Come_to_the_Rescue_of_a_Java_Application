package main.java.com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Main class
 * @author MC
 * @version 1.0
 */
public class AnalyticsCounter {
	// Ressource directories
	protected static String referencesDirectory = "src/main/resources/references/";
	protected static String workDirectory = "src/main/resources/work/";
	// Ressource files
	protected static String sourceFile = "symptoms.txt";
	protected static String destinationFile = "result.out";

	
	/**
	 * Main method
	 * @param args Unused
	 */
	public static void main(String[] args) {
		// Reading Symptoms From Source File
		var readingSourceSymptoms = new ReadSymptomDataFromFile(referencesDirectory + sourceFile);
		List<String> listOfSourceSymptoms = readingSourceSymptoms.getSymptoms();
		
		var treatsOccurrencesOfSymptoms = new CountsSymptomOccurrences();
		// Counting of symptom occurrence numbers
		Map<String, Integer> listOfSymptomOccurrences = treatsOccurrencesOfSymptoms.getListOfSymptomOccurrences(listOfSourceSymptoms);
		// Generating the list of symptom occurrence numbers to write
		List<String> listOfDestinationSymptoms = treatsOccurrencesOfSymptoms.getListOfWrittenSymptoms(listOfSymptomOccurrences);
		
		// Writing symptoms in the result file
		var writingDestinationSymptoms = new WriteSymptomDataToAFile(workDirectory + destinationFile);
		writingDestinationSymptoms.setSymptoms(listOfDestinationSymptoms);
		
		// End
		System.out.println("End");
	}
}
