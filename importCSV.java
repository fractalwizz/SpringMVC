import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;

public class importCSV {
	
	public static void main(String[] args){
		importCSV csv = new importCSV();
		csv.read();
	}
	
public void read(){

	String[][] classArray = new String[128][14];
	String[][] roomArray = new String[19][5];
	String classCSV = "/Users/C/Desktop/Classes.csv";
	String roomCSV = "/Users/C/Desktop/Rooms.csv";
	BufferedReader reader = null;
	String line = "";
	String split = ",";
	int x = 0;
	int y = 0;
	
//******************BEGIN CLASS IMPORT	
	try{
		reader = new BufferedReader(new FileReader(classCSV));
			while ((line = reader.readLine()) != null){
				String[] splitter = line.split(split);
					splitter[4] = splitter[4].replaceAll(":","");
					splitter[5] = splitter[5].replaceAll(":","");
					
				for (y=0; y<12;y++)
					classArray[x][y] = splitter[y];
				x++;
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			if (reader != null){
				try {
					reader.close();	
				} catch (IOException e){
					e.printStackTrace();
				}
			}	
		}

//********************************BEGIN ROOM IMPORT	
		try{
			reader = new BufferedReader(new FileReader(roomCSV));
			x = 0;
			while ((line = reader.readLine()) != null){
				String[] splitter = line.split(split);
			
				for (y=0; y<3;y++)
					roomArray[x][y] = splitter[y];
				
				x++;
			}
		
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			if (reader != null){
				try {
					reader.close();	
				} catch (IOException e){
					e.printStackTrace();
				}
			}
		}
		for (x=0;x<18;x++)
			roomArray[x][3] = "2359";
		for (x=0;x<18;x++)
			roomArray[x][4] = "0000";
		sort(classArray, roomArray);
	}

	/*
	 * THIS IS THE START OF THE ALGORITHM
	 */
public void sort(String[][] classes, String[][] rooms){
	int counter = 0;
	int rc=0;

	int sizeTestC, sizeTestR, timeTestSC, timeTestSR, timeTestEC, timeTestER;
	//tests for comparisons between the integers in the array SC = start class EC = end class
	while (counter<127){
		//through each class
		while (classes[counter][12] == null){
		//until the class is assigned a room
			sizeTestC = Integer.parseInt(classes[counter][1]);
			sizeTestR = Integer.parseInt(rooms[rc][1]);
			timeTestSC = Integer.parseInt(classes[counter][4]); 

			timeTestSR = Integer.parseInt(rooms[rc][3]);
			timeTestEC = Integer.parseInt(classes[counter][5]);
			timeTestER = Integer.parseInt(rooms[rc][4]);
			//putting into integers
			int sizecmp = Integer.compare(sizeTestC, sizeTestR);
			int timecmpS = Integer.compare(timeTestSC, timeTestER);
			int timecmpE = Integer.compare(timeTestEC, timeTestSR);
			//comparing the times and sizes
			
			if (sizecmp <= 0 && rooms[rc][2].equals(classes[counter][11]) == true && (classes[counter][6].equals("1") || classes[counter][8].equals("1") || classes[counter][10].equals("1")) && (timecmpS == -1 || timecmpE == -1)){		
				//first is capacity, second is lec/lab, third is class end comes before rooms start, fourth is class start comes after rooms end
				// this is how I was trying to sort the file
				classes[counter][12] = rooms[rc][0];
					
				if (timecmpS == -1){
					rooms[rc][3] = classes[counter][5];
				} else {
					rooms[rc][4] = classes[counter][4];
				}
					
	//			System.out.println("The class: " + classes[counter][0] + " is in room " + classes[counter][12] + " which meets on " + classes[counter][6] +  classes[counter][7] +  classes[counter][8] +  classes[counter][9] + classes[counter][10] + " from "   + classes[counter][4] + " to " + classes[counter][5] + " and is a " + classes[counter][11]);
			
			} else if (sizecmp <= 0 && rooms[rc][2].equals(classes[counter][11]) == true && (classes[counter][7].equals("1") || classes[counter][9].equals("1")) && (timecmpS == -1 || timecmpE == -1)){
				
				classes[counter][12] = rooms[rc][0];
				
				if (timecmpS == -1){
					rooms[rc][3] = classes[counter][5];
				} else {
					rooms[rc][4] = classes[counter][4];
				}
				
		//		System.out.println("The class: " + classes[counter][0] + " is in room " + classes[counter][12] + " which meets on " + classes[counter][6] +  classes[counter][7] +  classes[counter][8] +  classes[counter][9] + classes[counter][10] + " from "   + classes[counter][4] + " to " + classes[counter][5] + " and is a " + classes[counter][11]);
				
			}else{
				rc++;
			
			} 
		}
		rc = 0;
		counter++;
		}
	print(classes, rooms);
	}
	public void print(String[][] classes, String[][] rooms){	
		for (int x = 0; x < 127; x++){
			for (int y = 0; y < 13; y++){
				System.out.print(classes[x][y] + " ");
			}
			System.out.println();
		}
	
	/*	for (int x = 0; x < 18; x++){
			for (int y = 0; y < 3; y++){
				System.out.print(rooms[x][y] + " ");
			}
			System.out.println();
		}*/
	}
}
