package main.java.com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will writes symptom data from a source
 * The important part is, the operation parameter, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 *
 * 
 * 
 * @author MC
 * @version 1.0
 */
public interface ISymptomWriter {
	/**
	 * Write the result list
	 * <p> Post-condition : If no data is available, no symtom will be written</p>
	 * @param listWriter List of symptoms with number of occurrences
	 */
	int setSymptoms(List<String> listWriter);
}
