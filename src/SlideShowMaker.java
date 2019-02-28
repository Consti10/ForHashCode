

import java.util.ArrayList;
import java.util.List;

public class SlideShowMaker {

	//Erstellt eine Liste aller gemeinsamen Elemente
	private String[] calculateCommon(Slide a, Slide b) {
		
		List<String> ausgabe = new ArrayList<String>(0);
		
		for (int index = 0; index < a.tags.length; index++) {
			for (int index2 = 0; index2 < b.tags.length; ) {
				if(a.tags[index].equals(b.tags[index2])) {
					ausgabe.add(a.tags[index]);
				}
			}		
		}
		
		
		return ausgabe.toArray();
		
		
	}
	
	
	
	private int calculateScore(Slide a, Slide b) {
		
		String[] common = calculateCommon(a, b);
		int anzahlCommon = common.length;
		
				
		int leftJoined = a.tags.length - anzahlCommon;	
		
		int rightJoined = b.tags.length - anzahlCommon;
			
		return Math.min(Math.min(leftJoined, rightJoined), anzahlCommon);
		
	}
	
	//vertauscht zwei Elemente im array
	private Slide[] swap(Slide[]eingabe, int index1, int index2) {
		
		Slide temp = eingabe[index1];
		eingabe[index1] = eingabe[index2];
		eingabe[index2] = temp;
		
		return eingabe;
	}
	
	
	
	
	public Slide[] buildSlideShow(Slide[] eingabe) {
		
		Slide[] a = eingabe;
		Slide[] ausgabe = new Slide[a.length];
		
		int starter = 0;
		int highestMatch = 0;
		int pointer = 0;
		
		//iteriert
		for(int index = 0; index < a.length; index++) {
			
			if(index == a.length-1) {
				break;
			}
			
			for (int index2 = index+1; index2 < a.length; index2++) {
				
				if(calculateScore(a[index], a[index2]) > highestMatch) {
					highestMatch = calculateScore(a[index], a[index2]);
					pointer = index2;
				}
			}
			swap(a, index+1, pointer);
			
		}

		return ausgabe;	
	}
	
	
	
}
