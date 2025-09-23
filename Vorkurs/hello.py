import math
eingabe = float(input ("Geben Sie eine Zahl ein"))

for i in range(1, 11):
    print(f"{i} * {eingabe} = {(eingabe * i) / (11 - i)} * {11-i}")

