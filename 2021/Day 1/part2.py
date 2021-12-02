#Advent of Code - 12/1/2021 - Day 1
_input = open("input.txt");

#--Part 2--
print("Part 2");

input_lines = _input.readlines();
input_lines_length = len(input_lines)-1;
last_sum = 0;
current_sum = 0;
count = 0;
_i = 0;

while(_i < input_lines_length):
    if (_i+2 > input_lines_length):
        #We're done here
        print("Done!");
        break;
    else:
        first = int(input_lines[_i]);
        second = int(input_lines[_i+1]);
        third = int(input_lines[_i+2]);
        print(first+second+third);

        current_sum = (first+second+third);

        if (current_sum > last_sum and last_sum != 0):
            count += 1;
            print("count!");

        last_sum = current_sum;

    _i += 1;

print(count);
