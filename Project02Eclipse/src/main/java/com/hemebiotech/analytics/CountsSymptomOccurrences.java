package main.java.com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CountsSymptomOccurrences is a symptom list treatment class
 * @author MC
 * @version 1.0
 */
public class CountsSymptomOccurrences {
	
	/**
	 * Counting of symptom occurrence numbers
	 * <p> Pre-condition : Symptom List (name symptom)</p>
	 * <p> Post-condition : List of symptoms with number of occurrences (name symptom, number of occurrences)</p>
	 * @param listOfSourceSymptoms Symptom list
	 * @return List of symptoms with number of occurrences 
	 */
	public Map<String, Integer> getListOfSymptomOccurrences(List<String> listOfSourceSymptoms) {
		Map<String, Integer> listOfSymptomOccurrences = new HashMap<>();
		for (String symptomElement : listOfSourceSymptoms) {
			if (!listOfSymptomOccurrences.containsKey(symptomElement)) {
				listOfSymptomOccurrences.put(symptomElement, 1);
			} else {
				listOfSymptomOccurrences.put(symptomElement, listOfSymptomOccurrences.get(symptomElement) + 1);
			}
		}
		return listOfSymptomOccurrences;
	}
	
	
	/**
	 * Generating the list of symptom occurrence numbers to write
	 * <p> Pre-condition : List of symptoms with number of occurrences (name symptom, number of occurrences)</p>
	 * <p> Post-condition : List of labels to write (name symptom + " : " + number of occurrences)</p>
	 * @param listOfSymptomOccurrences List of symptoms with number of occurrences
	 * @return List of labels to write
	 */
	public List<String> getListOfWrittenSymptoms(Map<String, Integer> listOfSymptomOccurrences) {
		List<String> listOfDestinationSymptoms = new ArrayList<>();
		for (Map.Entry<String, Integer> elem : listOfSymptomOccurrences.entrySet()) {
			listOfDestinationSymptoms.add(elem.getKey() + " : " + elem.getValue());
		}
		return listOfDestinationSymptoms;
	}
}
