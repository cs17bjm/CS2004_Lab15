import java.util.ArrayList;

public class ScalesSolution
{
	
	private int[] scasol;
	
	//Solution starting from random vertex
	public ScalesSolution(int size) {
		scasol = new int[size+1];
		ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			listOfNumbers.add(i);
		}
		for (int i = 0; i < size; i++) {
			int n = CS2004.UI(0, listOfNumbers.size()-1);
			scasol[i] = listOfNumbers.get(n);
			if (i == 0) scasol[size] = listOfNumbers.get(n);	//returning back to first vertex
			listOfNumbers.remove(n);
		}

	} 
	
	//Solution starting from user specified vertex (startVertex)
	public ScalesSolution(int size, int startVertex) {
		scasol = new int[size+1];
		ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			listOfNumbers.add(i);
		}
		scasol[0] = listOfNumbers.get(startVertex);		//starting vertex
		scasol[size] = listOfNumbers.get(startVertex);	//returning back to first vertex
		listOfNumbers.remove(startVertex);
		for (int i = 1; i < size; i++) {
			int n = CS2004.UI(0, listOfNumbers.size()-1);
			scasol[i] = listOfNumbers.get(n);
			listOfNumbers.remove(n);
		}
	} 
	
	public ScalesSolution(int[] input) {
		scasol = input;
	}
	
	//swapping 2 elements over
	public void smallChange() {
		int first = CS2004.UI(1, scasol.length-2);
		int second = CS2004.UI(1, scasol.length-2);
		while(first==second) {second = CS2004.UI(1, scasol.length-2);}
		
		int temp = scasol[first];
		scasol[first] = scasol[second];
		scasol[second] = temp;
	}
	
	//Display the current solution
	public void print()
	{
		for (int i = 0; i < scasol.length; i++) {
			System.out.print(scasol[i]);
		}
		System.out.print("\t");
	}
	
	public int[] getSol() {
		return scasol;
	}

	//Calculates weight based on current solution
	public double calculateWeight() {
		double weight = 0;
		for (int i = 1; i < scasol.length; i++) {
			weight += Lab15.weights[scasol[i-1]][scasol[i]];
		}
		return weight;
	}
}
