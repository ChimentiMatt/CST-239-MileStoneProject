//package app;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
///** Class storage T*/
//public class UpdatedArray<T> 
//{
//	
//	/** Generic method that takes in an inputArray and prints out the data either in ascending/descending with name or price
//	 * @param ascending boolean
//	 * @param name boolean
//	 * @param price boolean
//	 * @param updatedArray E[]*/
//	public void printArray(ArrayList<ItemInterface> updatedArray, boolean ascending, boolean name, boolean price)
//	{
//		System.out.println("\nGrumbling Goblins Stock--------------------------------");
//		// if name was chosen
//		if(name) {
//
//			Comparator<ItemInterface> compareByName = (ItemInterface o1, ItemInterface o2) -> o1.getName().compareTo( o2.getName());
//			Collections.sort(updatedArray, compareByName);
//			
//			if (ascending == false) {
//				System.out.println("REVERSE");
//				Collections.sort(updatedArray, Collections.reverseOrder());
//			}
//		}
//		// if price was chosen in ascending order
//		else if(price == true  && ascending == true) {
//			updatedArray.sort((a, b) -> {
//	                if (a.getPrice() > b.getPrice()) {
//	                    return -1;
//	                }
//	                if (a.getPrice() < b.getPrice()) {
//	                    return 1;
//	                }
//	                return 0;
//	            });
//		}
//		// if price was chosen in descending order
//		else 
//		{
//			updatedArray.sort((a, b) -> {
//                if (a.getPrice() > b.getPrice()) {
//                    return 1;
//                }
//                if (a.getPrice() < b.getPrice()) {
//                    return -1;
//                }
//                return 0;
//            });
//		}
//		
//		//output stream using forEach the information
//		updatedArray.forEach(element -> System.out.println(element.getName() + "\t\t" + element.getPrice() + " copper " + "\t stock: " + element.getQuantity()));
//	}
//	
//	/** Method that saves the array to the JSON file
//	 * @param updateARray ArrayList
//	 * @throws IOExeception IOEception*/
//	public void saveArray(ArrayList<ItemInterface> updatedArray) throws IOException
//	{
//		PrintWriter pw;
//		try
//		{
//			// Create a file File to 
//			File file = new File("inventory.json");
//			
//			FileWriter fw = new FileWriter(file, false);
//			pw = new PrintWriter(fw);
//			
//			
//			// Write items into JSON
//			ObjectMapper objectMapper = new ObjectMapper();
//			String json = "";
//			for(ItemInterface loopItem : updatedArray)
//			{
//				json += objectMapper.writeValueAsString(loopItem) + "\n";
//			}
//			pw.println(json);
//			
//			// Cleanup
//			pw.close();
//			
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}
//	}
//	
//}
//
