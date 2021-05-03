package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
//=> mc 18/04/2021d : Traitement des exceptions
import java.io.IOException;
import java.io.FileNotFoundException;
//=< mc 18/04/2021d

public class AnalyticsCounter {
// mc 18/04/2021a : Remplacer headache par headacheCount
// mc 18/04/2021b : Correction rush en rash
// mc 18/04/2021c : Fermeture fichier lecture
// mc 18/04/2021d : Traitement des exceptions
// mc 18/04/2021e : Suppression commentaires inutiles
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {
		// first get input
		//=> mc 18/04/2021d : Traitement des exceptions
		try {
		//=< mc 18/04/2021d
			BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
			String line = reader.readLine();
	
			int i = 0;
			//=> mc 18/04/2021a : Remplacer headache par headacheCount
			//int headCount = 0;	// counts headaches
			//=< mc 18/04/2021a
			while (line != null) {
				i++;	// increment i
				System.out.println("symptom from file: " + line);
				if (line.equals("headache")) {
					//=> mc 18/04/2021a : Remplacer headache par headacheCount
					//headCount++;
					//System.out.println("number of headaches: " + headCount);
					headacheCount++;
					//=< mc 18/04/2021a
				}
				//=> mc 18/04/2021b : Correction rush en rash
				//else if (line.equals("rush")) {
				else if (line.equals("rash")) {
				//=< mc 18/04/2021b
					rashCount++;
				}
				else if (line.contains("pupils")) {
					pupilCount++;
				}
	
				line = reader.readLine();	// get another symptom
			}
			//=> mc 18/04/2021c : Fermeture fichier lecture
			reader.close();
			//=< mc 18/04/2021c
		//=> mc 18/04/2021d : Traitement des exceptions
		} catch(FileNotFoundException e) {
			System.out.println("Fichier introuvable " + e.toString());
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("Problème de lecture fichier " + e.toString());
			System.exit(-1);
		}
		//=< mc 18/04/2021d
		
		// next generate output
		//=> mc 18/04/2021d : Traitement des exceptions
		try {
		//=< mc 18/04/2021d
			FileWriter writer = new FileWriter ("result.out");
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");
			writer.close();
		//=> mc 18/04/2021d : Traitement des exceptions
		} catch(FileNotFoundException e) {
			System.out.println("Fichier introuvable " + e.toString());
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("Problème d'écriture fichier " + e.toString());
			System.exit(-1);
		}
		//=< mc 18/04/2021d
	}
}
