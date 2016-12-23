import java.util.ArrayList;

//Handles JJ's Problem, returns longest path if it exists
public class JJ {
	
	ArrayList<Slide> slides; //# of slides
	ArrayList<ArrayList<String>> results; //Successful Trips
	ArrayList<String> bestRoute; //the best path to take
	
	Slide start; //The Starting Point(island)
	Slide pos; //Current Position
	
	boolean started = false;
	
	//Constructor
	public JJ(ArrayList<Slide> s){
		slides = s;
		start = slides.get(0);
		pos = slides.get(0);
		results = new ArrayList<ArrayList<String>>();
	}
	
	//Checks slides for a successful path
	public void checkSlides(){
		ArrayList<String> r = new ArrayList();
		System.out.println("Starting...");
		execute(slides, r, start.x);
		//System.out.println(results.size());
		printResults(results);
	}
	
	//Handles the Slide Traversals
	public void execute(ArrayList<Slide> s, ArrayList<String> r, String pos){
		System.out.println("Start: "+start.x+"|" + pos +" posx");
		printSlides(s);
		ArrayList<Slide> tempSlides = new ArrayList<Slide>(); //available slides
		ArrayList<String> tempResults = new ArrayList<String>(); //temporary results
		tempSlides.addAll(s); //available slides
		tempResults.addAll(r); //temporary results
		tempResults.add(pos);
		
		//Handles stopping condition (Successful loop)
		if(pos.equals(start.x) && started == true){
			if (started == false){
				started = true;
			} else {
				results.add(tempResults);
				System.out.println("added");
			}
		} else {
			started = true;
		//Iterates through current list of slides, if a move can be made -> recurse
			for (int i=0;i<s.size();i++){
				System.out.print("Checking Cur Pos "+pos+"|");
				s.get(i).printSlide();
				System.out.print("\n");
				if (pos.equals(s.get(i).x)){ //if y in (x,y) matches x in (x,y)'
					pos = s.get(i).y; //update pos
					//temp.add(tempSlides.get(i));
					Slide temp = s.get(i);
					tempSlides.remove(temp); //remove choice
					execute(tempSlides,tempResults,pos); //recursion
					tempSlides.add(temp);
					pos = temp.x; //update pos
					//printSlides(tempSlides);
				}
			}
		}
	}
	//Prints the current state of variables
	public void printVars(){
		System.out.println("Current State:\nStart: "+start.x+"\nCurrent Pos: "+pos.x);
	}
	
	public static void printResults(ArrayList<ArrayList<String>> s){
		System.out.print("Results["+s.size()+"]: ");
		for (int i=0; i<s.size();i++){
				System.out.print("\n");
			for (int j=0;j<s.get(i).size();j++){
				System.out.print(s.get(i).get(j));
			}
		}
		System.out.print("\n");
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
	
	//Calculates the path that has the most jewels and prints
	public void getBest(){
		ArrayList<String> best = new ArrayList<String>();
		for (int i=0;i<results.size();i++){
			if (results.get(i).size()> best.size()){
				best = results.get(i);
			}
		}
		System.out.println("Best Route (JEWELS): "+(best.size()-1));
		for (int i=0;i<best.size();i++){
			System.out.println(best.get(i));
		}
	}
}

