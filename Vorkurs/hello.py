import time

def eingabe() :
    return int(input("Bitte Zahl eingeben! "))

def mathe(zahl):
    for i in range(1, zahl +1 ):  
     print(f"{i}^2 = {i * i}")     
   

def main():
    
    zahl = eingabe()
    start = time.time()
    mathe(zahl)
    end = time.time()
    print(end - start)

if __name__ == "__main__":
    main()

