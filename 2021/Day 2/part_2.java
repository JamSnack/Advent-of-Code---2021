//Advent of Code 12/2/2021 - Day 2
//Part 2
import java.io.*;
import java.util.ArrayList;

public class part_2
{
	public static void main(String[] args) throws Exception
	{
		
		//--Initialize--
		int h_pos = 0;
		int depth = 0;
		int aim = 0;
		ArrayList<String> directions = new ArrayList<String>(3);
		directions.add("forward ");
		directions.add("down ");
		directions.add("up ");
		
        FileReader fr = new FileReader(
            "C:\\Users\\james\\Documents\\GitHub\\Advent-of-Code---2021\\2021\\Day 2\\input.txt");
 
        // Declaring loop variable
        int i;
		String _str = "";
		char _char = 0;
        // Holds true till there is nothing to read
        while ((i = fr.read()) != -1) //Interesting code magic. We set i to fr.read() and check that value in the same line.
		{
			_char = (char)i;
			
			//If we have found a digit, then assume a command has also been found and iterate upon that.
			//Else, continue building the _str;
			
			if (Character.isDigit(_char) || (_char == '\n'))
			{
				if (directions.contains(_str))
				{
					int _amt = Character.getNumericValue(_char);
					
					switch(_str)
					{
						case "down ":
							aim += _amt;
							break;
						
						case "up ":
							aim -= _amt;
							break;
						
						case "forward ":
							h_pos += _amt;
							depth += aim*_amt;
							break;
					}
					
					System.out.printf("H-Pos: %d, Aim: %d, Depth: %d. Direction: %s\n",h_pos,aim,depth,_str);
				}
				
				_str = "";
			}
			else
			{
				_str += _char;
			}
		}
		
		System.out.printf("H-Pos: %d, Depth: %d. Answer: %d",h_pos,depth,h_pos*depth);
	}
}