package test.java.com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.java.com.hemebiotech.analytics.AnalyticsCounter;

class AnalyticsCounterTest extends AnalyticsCounter {
	// Test files
	private static String mainDestinationFile = "mainDestinationFile.txt";
	

	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// Main
	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// General case
	@Test
	void testMainNormal() throws IOException {
		// Ressource directories
		referencesDirectory = "src/test/resources/references/";
		workDirectory = "src/test/resources/work/";
		// Ressource files
		sourceFile = "mainSourceFile.txt";
		destinationFile = "mainResultFile.txt";
		
		// Deletion of the old result file
		var resultFilePath = Paths.get(workDirectory + destinationFile);
		java.nio.file.Files.deleteIfExists(resultFilePath);
		
		main(null);
		
		// Test result file with reference file
		var destinationReferenceFilePath = Paths.get(referencesDirectory + mainDestinationFile);
		Assert.assertEquals(Files.readString(destinationReferenceFilePath), Files.readString(resultFilePath));
	}

}
