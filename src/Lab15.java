import java.util.ArrayList;

public class Lab15 {
	static String filepath = "C:\\Users\\Brandon\\eclipse-workspace\\CS2004_Lab15\\CS2004 TSP Data (2018-2019)\\";
	static String textfile = filepath + "TSP_05.txt";

	static ArrayList <String> vertices = Text.readFile(textfile);
	static double [][] weights = new double[vertices.size()][vertices.size()];

	public static void main(String [] args) {
				
		weights = arrayStarter(weights);
//		printArray(weights);
		
		startTSP(5);
		
	}
	
	//This initialises the Array
	public static double[][] arrayStarter(double[][] arrayInput) {
		
		for(int i = 0;i<vertices.size();i++) {
			String [] temp = vertices.get(i).split(" ");
			
			for(int j = 0;j<vertices.size();j++) {
				Double tempD = Double.parseDouble(temp[j]);
				arrayInput[i][j] = tempD;
			}
		}
		return arrayInput;
	}
	//Printing a 2d array
	public static void printArray(double[][] input) {
		for(int i = 0;i<input.length;i++) {			
			for(int j = 0;j<input.length;j++) {
				System.out.print(input[i][j]+", ");
			}
			System.out.println();
		}
	}
	public static void startTSP(int iter) {
		ScalesSolution x = new ScalesSolution(vertices.size(),0);	//random solution starting from 0
//		ScalesSolution x = new ScalesSolution(vertices.size());		//random solution with random start vertex
		x.print();
		System.out.println(x.calculateWeight());
		double currentWeight = x.calculateWeight();

		for(int i = 0; i < iter; i++) {
			
			ScalesSolution y = new ScalesSolution(x.getSol());
			y.smallChange();

			double newWeight = y.calculateWeight();

			//If new solution have smaller weighting then replace old solution (x) with new solution (y)
			if (newWeight<currentWeight) {
				x = y;
			}
			x.print();
			System.out.println(x.calculateWeight());

		}

	}
}
