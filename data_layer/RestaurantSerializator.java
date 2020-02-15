package data_layer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import business_layer.MenuItem;

public class RestaurantSerializator {

	public void serialize(ArrayList<MenuItem> item) {
		
		 try {
				ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("serial")) ;	
				int i = 0;
				
				for(MenuItem item2: item) {
					if(i == 0)
						objOStrm.writeObject(item2.getProductName()); 
					else {
						objOStrm = new ObjectOutputStream(new FileOutputStream("serial", true)) {
						
							protected void writeStreamHeader() throws IOException {
								reset();
							}
						};	
					objOStrm.writeObject(item2.getProductName()); 
					}
				i++;
				}
				
			}  	catch(IOException e) {  
				System.out.println("Exception during serialization: " + e);   
			} 
	}
	
}
