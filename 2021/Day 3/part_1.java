//Advent of Code 12/3/2021 - Day 3
//Part 1
import java.io.*;
import java.util.ArrayList;

public class part_1
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
		
		int num_1 = 0;
		int num_0 = 0;
		String str_gamma_rate = "";
		String str_epsilon_rate = "";
		
		//Compute the most common value and the least common value, save each to a new array.
		//For each column ( _i ) we want to iterate through each number and find the most common value.
			
		for (int _j = 0; _j < whole_array.get(0).size(); _j++) 
		{	
			//Get the size of the whole array (_i=0;_i<size)
			for (int _i = 0; _i < whole_array.size(); _i++) 
			{	
				int num = whole_array.get(_i).get(_j);
				
				if (num == 1)
					num_1++;
				else 
					num_0 ++;
			}
			
			//If the most common bit is 1..
			if (num_1 > num_0)
			{
				str_gamma_rate += "1";
				str_epsilon_rate += "0";
			}
			else
			{
				str_gamma_rate += "0";
				str_epsilon_rate += "1";
			}
			
			//Reset numbers
			num_1 = 0;
			num_0 = 0;
		}
		
		//Convert from String Binary to Decimal.
		int gamma_rate = Integer.parseInt(str_gamma_rate,2);
		int epsilon_rate = Integer.parseInt(str_epsilon_rate,2);
		
		System.out.printf("Gamma rate: %d, Epsilon rate: %d. Answer: %d",gamma_rate,epsilon_rate,gamma_rate*epsilon_rate);
	}
}