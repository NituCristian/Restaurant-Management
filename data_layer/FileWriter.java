package data_layer;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import business_layer.Restaurant;

public class FileWriter {

	public ArrayList<String> deserialize(Restaurant restaurant) {
		ArrayList<String> deStrings = new ArrayList<>();
		 try {
			 ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("serial"));
			 //String object2 = (String)objIStrm.readObject();
			 int size = 0;
			 
			 while(size < restaurant.getRestaurantMenu().size()) {
				 deStrings.add((String)objIStrm.readObject());
			 }
			  
			 }catch(Exception e) {       
				 
			 }  
		 
		
		 return deStrings;
	}
}
