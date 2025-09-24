import time

def eingabe() :
    return int(input("Bitte Zahl eingeben! "))

def größte(zahlen):
    rückgabe = zahlen[0]
    for i in zahlen:
        if i > rückgabe:
            rückgabe = i
            
    print (rückgabe)

def kleinste(zahlen):
    rückgabe = zahlen[0]
    for i in zahlen:
        if i < rückgabe:
            rückgabe = i
            
    print (rückgabe)
def main():
    
    zahlen = [] 
    for i in range(0,3):
        zahlen.append(eingabe())
    start = time.time()
    größte(zahlen)
    kleinste(zahlen)
    end = time.time()
    print(end - start)

if __name__ == "__main__":
    main()

