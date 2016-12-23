import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//The Driver for JJ's Slide problem
public class Driver {
		static ArrayList<Slide> slides;
	public static void main(String[] args){
		slides = new ArrayList<Slide>(); //List of Slides
		
		//Create Scanner Object
		Scanner console = new Scanner(System.in);
		
		//Gather and Parse input
		System.out.println("Please Enter a String of Inputs:...");
		String input = console.nextLine();
		parseInput(input);
		printSlides(slides);
		/*
		//TESTING
		Slide s1 = new Slide("1","3");
		Slide s2 = new Slide("3","1");
		Slide s3 = new Slide("1","2");
		Slide s4 = new Slide("2","1");
		Slide s5 = new Slide("3","2");
		slides.add(s1);
		slides.add(s2);
		slides.add(s3);
		slides.add(s4);
		slides.add(s5);
		*/
		printSlides(slides);
		JJ j = new JJ(slides);
		j.printVars();
		j.checkSlides();
		j.getBest();
		//System.out.println(test(75) + "(milliseconds)");
		
	}
	
	//Parses User Input (whitespace delimited pairs)
	public static void parseInput(String s){
		String temp = "";
		ArrayList<String> inputs = new ArrayList<String>();
		//int count = 1;
		//Check for whitespaces, and create pairs accordingly
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			Character.toString(c);
			if (Character.isWhitespace(c)){
				System.out.println(temp);
				inputs.add(temp);
				temp = "";
			} else {
				temp+=c;
			}
		}
		inputs.add(temp);
		for (int i=0;i<inputs.size();i++){
			String x = inputs.get(i);
			String y = inputs.get(i+1);
			Slide tempslide = new Slide(x,y);
			slides.add(tempslide);
			i++;
		}
	}
	//Prints current state of slides list into std.out
	public static void printSlides(ArrayList<Slide> s){
		System.out.print("Slides["+s.size()+"]:");
		for (int i=0;i<s.size();i++){
			s.get(i).printSlide();
			if (i!=(s.size()-1)){
				System.out.print(",");
			} else {
				System.out.print("\n");
			}
		}
	}
	
	//Tests the algorithm for time
	//n the number of slides, 
	public static long test(int n){
		Random rand = new Random();
		slides.clear();
		for (int i=0;i<n;i++){
			int x = rand.nextInt(50)+1; //between 1-50
			int y = rand.nextInt(50)+1; //between 1-50
			Slide temp = new Slide(x+"",y+"");
			slides.add(temp);
		}
		//Start the test
		long startTime = System.currentTimeMillis();
		JJ test = new JJ(slides);
		test.checkSlides();
		test.getBest();
		long endTime = System.currentTimeMillis();
		long totalTime= endTime-startTime;
		return totalTime;
	}
}
