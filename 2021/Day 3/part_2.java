//Advent of Code 12/3/2021 - Day 3
//Part 2
import java.io.*;
import java.util.ArrayList;

public class part_2
{	
	public static void main(String[] args) throws Exception
	{	
		//-- initialize
		FileReader fr = new FileReader( "C:\\Users\\james\\Documents\\GitHub\\Advent-of-Code---2021\\2021\\Day 3\\input.txt" );
		
		int i;
		int _char;
		int array_index_1d = -1; //Offset to be 0 during the first iteration. The current index of the first dimension of our dyanmic array.
		ArrayList<ArrayList<Integer>> whole_array = new ArrayList<>();
		ArrayList<Integer> _a = new ArrayList<>(); //A temporary array
		
		while ((i = fr.read()) != -1)
		{	
			int _char_as_int = Character.getNumericValue(i);
			
			if (_char_as_int == -1)
			{
				continue;
			}
			
			//System.out.print(_char_as_int);
			_a.add(_char_as_int);
			
			if (_a.size() >= 12)
			{
				//Copy the contents of the temp list into a new list for storage.
				ArrayList<Integer> partial_array = new ArrayList<>();
				for (int x : _a) partial_array.add(x);
				
				//Add our completed array to the whole array
				whole_array.add(partial_array);
			
				//Reuse the old list
				_a.clear();
			}
		}
	
		String str_ox = "";
		String str_co = "";
		
		for (int z = 0; z < 2; z++)
		{
			ArrayList<ArrayList<Integer>> whole_array_2 = new ArrayList<>();
			for (ArrayList<Integer> x : whole_array) whole_array_2.add(x);
			
			for (int _j = 0; _j < whole_array_2.get(0).size(); _j++) 
			{	
				int num_1 = 0;
				int num_0 = 0;
				int flag_delete = 0;
		
				//Get the size of the whole array (_i=0;_i<size)
				for (int _i = 0; _i < whole_array_2.size(); _i++) 
				{	
					int num = whole_array_2.get(_i).get(_j);
					
					if (num == 1)
						num_1++;
					else 
						num_0++;
				}
				
				if (z == 0)
				{
					//If the most common bit is 1..
					if ((num_1 > num_0))
					{
						//Flag Eliminate numbers with a 0 at position _i
						flag_delete = 0;
						str_ox += "1";
					}
					else if (num_1 == num_0)
					{
						flag_delete = 0;
						str_ox += "1";
					}
					else
					{
						//Flag to Eliminate numbers with a 1 at position _i
						flag_delete = 1;
						str_ox += "0";
					}
				}
				else
				{
					//If the most common bit is 1..
					if ((num_1 > num_0))
					{
						//Flag Eliminate numbers with a 0 at position _i
						flag_delete = 0;
						str_co += "0";
					}
					else if (num_1 == num_0)
					{
						flag_delete = 1;
						str_co += "0";
					}
					else
					{
						//Flag to Eliminate numbers with a 1 at position _i
						flag_delete = 0;
						str_co += "1";
					}	
				}
				
				
				//--- Trim the array and continue. --
				for (int _i = 0; _i < whole_array_2.size(); _i++) 
				{	
					int num = whole_array_2.get(_i).get(_j);
					
					if (num == flag_delete)
					{
						//Eliminate numbers with a 0 at position _j;
						whole_array_2.remove(_i);
						_i = 0;
					}
				}
			}
		}
		
		System.out.println();
		int ox = Integer.parseInt(str_ox,2);
		int co = Integer.parseInt(str_co,2);
		System.out.printf("\nOxygen_str: %s, C02_str: %s\n",str_ox,str_co);
		System.out.printf("Oxygen: %d, C02: %d. Answer: %d",ox,co,ox*co);
	}
}