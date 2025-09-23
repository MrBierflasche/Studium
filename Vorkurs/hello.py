import math

zahl = int(input("Bitte gebe eine Zahl ein"))
test = False
for i in range (2, zahl):
    for j in range (2, i):
        m = i % j
        if i % j == 0:
            test = True
            break
    if  not test:
     print(i)



