#Advent of Code - 12/1/2021 - Day 1
_input = open("input.txt");

#--Part 1--
count = 0;
last_number = int(_input.readline());

for _s in _input:
    if (int(_s) > last_number):
        count += 1;

    last_number = int(_s);

print("Count: ");
print(count);

        
    
