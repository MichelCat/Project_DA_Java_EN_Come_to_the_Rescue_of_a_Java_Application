package main.java.com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 * @see ISymptomReader
 * @see WriteSymptomDataToAFile
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * Update symptom file name
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();
		
		if (filepath != null) {
			try (var reader = new BufferedReader (new FileReader(filepath))) {
				String line = reader.readLine();
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
			} catch(FileNotFoundException e) {
				System.out.println("File not found " + e.toString());
			} catch (IOException e) {
				System.out.println("File read problem " + e.toString());
			} catch(Exception e) {
				System.out.println("Other exception " + e.toString());
			}
		}
		
		return result;
	}

}
