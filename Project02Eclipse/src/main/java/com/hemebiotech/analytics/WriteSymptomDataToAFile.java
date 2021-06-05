package main.java.com.hemebiotech.analytics;

import java.io.FileNotFoundException;
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
	public int setSymptoms(List<String> listWriter) {
		try (var writer = new FileWriter (filepath)) {
			for (String line : listWriter) {
				writer.write(line + "\n");
			}
		} catch(FileNotFoundException e) {
			System.out.println("File not found " + e.toString());
			return -1;
		} catch (IOException e) {
			System.out.println("File write problem " + e.toString());
			return -2;
		} catch(Exception e) {
			System.out.println("Other exception " + e.toString());
			return -3;
		}
		return 0;
	}
}
