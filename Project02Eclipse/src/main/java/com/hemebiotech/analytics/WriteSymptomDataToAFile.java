package main.java.com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Simple writer implementation based on file system 
 *
 * @see ISymptomWriter
 * @see ReadSymptomDataFromFile
 *
 * @author MC
 * @version 1.0
 */
public class WriteSymptomDataToAFile implements ISymptomWriter {

	private String filepath;
	
	/**
	 * Update symptom file name
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public WriteSymptomDataToAFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Write sympton in file
	 */
	@Override
	public void setSymptoms(List<String> listWriter) {
		try (var writer = new FileWriter (filepath)) {
			for (String line : listWriter) {
				writer.write(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
