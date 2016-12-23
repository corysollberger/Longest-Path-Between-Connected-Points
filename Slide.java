//Class that holds connections between islands
//Acts similarly to a tuple
public class Slide {
	public String x; //start
	public String y; //end
	
	//Constructor
	public Slide(String x,String y){
		this.x = x;
		this.y = y;
	}
	
	public void printSlide(){
		System.out.print("("+x+","+y+")");
	}
}
