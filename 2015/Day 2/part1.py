#for some reason I must run this code from the .exe file because it won't find the input.txt file if run from the IDE.

#initialize lines list
lines = []

#Open the file and read the lines, placing each line into the list
with open(r'c:\Users\James\Documents\GitHub\Advent-of-Code---2021\2015\Day 2\input.txt') as f:
    lines = f.readlines()

#close the file, it is no longer needed (apparently the with statement does this already)

#print lines
number = 0
for line in lines:
    split_string = line.split('x')
    a = int(split_string[0])
    b = int(split_string[1])
    c = int(split_string[2])
    
    #calculate slack
    if (a >= b and a >= c):
        slack = b*c
    elif (b >= a and b >= c):
        slack = a*c
    elif (c >= b and c >= a):
        slack = b*a
        

    number += 2*( (a*b) + (b*c) + (c*a) ) + slack

print(number)
