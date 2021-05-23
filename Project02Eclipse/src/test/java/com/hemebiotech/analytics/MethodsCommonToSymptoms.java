package test.java.com.hemebiotech.analytics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MethodsCommonToSymptoms {
	// Symptom list
	protected String elementFever = "fever";
	protected String elementCough = "cough";
	protected String elementBlurredVision = "blurred vision";
	
	// Ressource directories
	protected String referencesDirectory = "src/test/resources/references/";
	protected String workDirectory = "src/test/resources/work/";

	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// Symptom List (name symptom)
	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// General case
	protected List<String> getListOfSourceSymptomsNormal() {
		return Arrays.asList(elementFever, elementCough, elementCough, elementBlurredVision, elementFever);
	}

	// Borderline cases : Empty list
	protected List<String> getListOfSourceSymptomsEmpty() {
		return Arrays.asList();
	}
	

	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// List of symptoms with number of occurrences (name symptom, number of occurrences)
	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// General case
	protected Map<String, Integer> getListOfSymptomOccurrencesNormal() {
		Map<String, Integer> listOfDestinationSymptoms = new HashMap<>();
		listOfDestinationSymptoms.put(elementFever, 2);
		listOfDestinationSymptoms.put(elementCough, 2);
		listOfDestinationSymptoms.put(elementBlurredVision, 1);
		return listOfDestinationSymptoms;
	}
	
	// Borderline cases : Empty list
	protected Map<String, Integer> getListOfSymptomOccurrencesEmpty() {
		return new HashMap<>();
	}
	

	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// List of labels to write (name symptom + " : " + number of occurrences)
	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// General case
	protected List<String> getListOfWrittenSymptomsNormal() {
		return Arrays.asList(elementFever + " : 2"
				, elementCough + " : 2"
				, elementBlurredVision + " : 1");
	}
	
	// Borderline cases : Empty list
	protected List<String> getListOfWrittenSymptomsEmpty() {
		return Arrays.asList();
	}
}
