import math

zahl1 = float(input("1. Zahl"))
operator = input("Operator")
zahl2 = float (input("2. Zahl"))

match operator:
    case "+":
        print(f"{zahl1 + zahl2}")
    case "-":
         print(f"{zahl1 - zahl2}")
    case "*":
        print(f"{zahl1 * zahl2}")
    case "/":
        print(f"{zahl1 / zahl2}")




