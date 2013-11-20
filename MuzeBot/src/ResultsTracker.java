import java.io.File;
import java.io.IOException;
import java.util.*;

public class ResultsTracker {

	public ResultsTracker(String filename) throws IOException{
		
		File database = new File(filename);
		
		if(database.exists()){
			  Scanner in = new Scanner(database).useDelimiter("[\t|\n|\r]+");
			  while (in.hasNext()){
				  
			  }
		  }else{
			  database.createNewFile();
		  }
		
	}
	
}
