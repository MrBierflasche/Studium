import math
outputs = []
counter = 0
stopp = input("Bitte geben Sie ein Wort ein. ")
while ( stopp != "stopp"):
    outputs.append( stopp )
    counter = counter +1 
    print( f"Es wurde {counter} nicht Stopp ausgegeben.")
    for i in outputs:
         print(i)
            
    stopp = input("Bitte geben Sie ein Wort ein. ")
    


