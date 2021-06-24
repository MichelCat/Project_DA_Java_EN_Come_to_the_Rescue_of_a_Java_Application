package com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AnalyticsCounterTest {
	// Test files
	private static String mainDestinationFile = "mainDestinationFile.txt";
	

	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// Main
	// ---------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------
	// General case
	@BeforeAll
	static void setup() {
		// Ressource directories
		AnalyticsCounter.referencesDirectory = "src/test/resources/references/";
		AnalyticsCounter.workDirectory = "src/test/resources/work/";
		// Ressource files
		AnalyticsCounter.sourceFile = "mainSourceFile.txt";
		AnalyticsCounter.destinationFile = "mainResultFile.txt";
	}
	
	@Test
	void testMainNormal() throws IOException {
		// Deletion of the old result file
		var resultFilePath = Paths.get(AnalyticsCounter.workDirectory + AnalyticsCounter.destinationFile);
		java.nio.file.Files.deleteIfExists(resultFilePath);
		
		AnalyticsCounter.main(null);
		
		// Test result file with reference file
		var destinationReferenceFilePath = Paths.get(AnalyticsCounter.referencesDirectory + mainDestinationFile);
		Assert.assertEquals(Files.readString(destinationReferenceFilePath), Files.readString(resultFilePath));
	}

}
