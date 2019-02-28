

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SlideShowMaker {


	//Erstellt eine Liste aller gemeinsamen Elemente
	private static List<String> calculateCommon(Slide a, Slide b) {
		
		ArrayList<String> ausgabe = new ArrayList<String>(0);
		
		for (int index = 0; index < a.tags.size(); index++) {

			for (int index2 = 0; index2 < b.tags.size(); index2++ ) {
				if(a.tags.get(index).equals(b.tags.get(index2))) {
					ausgabe.add(a.tags.get(index));
				}
			}		
		}
		return ausgabe;
	}

	public static int calculateScore(Slide a, Slide b) {
		
		List<String> common = calculateCommon(a, b);
		int anzahlCommon = common.size();
				
		int leftJoined = a.tags.size() - anzahlCommon;	
		
		int rightJoined = b.tags.size() - anzahlCommon;
			
		return Math.min(Math.min(leftJoined, rightJoined), anzahlCommon);
		
	}


	
	public ArrayList<Slide> buildSlideShow(ArrayList<Slide> eingabe) {
		
		ArrayList<Slide> a = eingabe;
		ArrayList<Slide> ausgabe = new ArrayList<>(a.size());
		
		int starter = 0;
		int highestMatch = 0;
		int pointer = 0;
		
		//iteriert
		for(int index = 0; index < a.size(); index++) {

			if(index == a.size()-1) {
				break;
			}
			
			for (int index2 = index+1; index2 < a.size(); index2++) {

				if(calculateScore(a.get(index), a.get(index2)) > highestMatch) {
					highestMatch = calculateScore(a.get(index), a.get(index2));
					pointer = index2;
				}
			}
			Collections.swap(a, index+1, pointer);
			
		}

		return ausgabe;	
	}
	
	
	
}
