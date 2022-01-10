_input = open("aoc_input.txt",'r');

floor_number = 0;
basement_found = False;
i = 0;

for x in _input.read():
    i += 1;
    if basement_found == False:
        if (x == '(' ):
            floor_number += 1
        else:
            floor_number -= 1

        if (floor_number == -1):
            basement_found = True;
            print(i);


