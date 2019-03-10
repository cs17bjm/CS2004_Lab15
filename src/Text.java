
import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;

public class Text {
//	https://alvinalexander.com/blog/post/java/how-open-read-file-java-string-array-list
	static public ArrayList<String> readFile(String filename)
	{
		ArrayList<String> records = new ArrayList<String>();
	  try
	  {
	    BufferedReader reader = new BufferedReader(new FileReader(filename));
	    String line;
	    while ((line = reader.readLine()) != null)
	    {
	      records.add(line);
	    }
	    reader.close();
	    return records;
	  }
	  catch (Exception e)
	  {
	    System.err.format("Exception occurred trying to read '%s'.", filename);
	    e.printStackTrace();
	    return null;
	  }
	}
	
	
	static public void writeFile(String input)
	{
        try {
        	FileWriter fw = new FileWriter(new File("mytextfile.txt"));
             
            fw.write(String.format(input));
 
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         
	}
}
