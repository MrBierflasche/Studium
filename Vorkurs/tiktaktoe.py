import time
def winner (spielfeld) :
    if(middleWinner(spielfeld)):
        print(f"Spieler: {spielfeld[1][1]} hat gewonnen")
        return True
    
    if (RowWinner(spielfeld)): 
        return True
    return ColumnWinner(spielfeld)
    
def middleWinner(spielfeld):
    currentMiddleSign = spielfeld[1][1]
    if(currentMiddleSign == "-"):
        return False
    # oben links und unten rechts
    if(currentMiddleSign == spielfeld[ 0][0] and currentMiddleSign == spielfeld[2][2]):
        return True
    # oben rechts und unten links 
    if(currentMiddleSign == spielfeld[ 0][2] and currentMiddleSign == spielfeld[0][2]):
        return True 
    
    return False

def RowWinner(spielFeld):
    for row in spielFeld:
        if (row[0] == "-"):
            continue
        if(row[0] == row[1] and row[0] == row[2]):
            print(f"Spieler: {row[0]} hat gewonnen")
            return True
    return False

def ColumnWinner(spielfeld):
    # 1.Säule
    if(spielfeld[0][0] != "-" and spielfeld[0][0] == spielfeld[1][0] and spielfeld[0][0] == spielfeld[2][0] ):
        print(f"Spieler: {spielfeld[0][0]} hat gewonnen")
        return True
    # 2.Säule
    if(spielfeld[0][1] != "-" and spielfeld[0][1] == spielfeld[1][1] and spielfeld[0][1] == spielfeld[2][1] ):
        print(f"Spieler: {spielfeld[0][1]} hat gewonnen")
        return True
    # 3.Säule
    if(spielfeld[0][2] != "-" and spielfeld[0][2] == spielfeld[1][2] and spielfeld[0][2] == spielfeld[2][2] ):
        print(f"Spieler: {spielfeld[0][2]} hat gewonnen")
        return True
    
    return False
def spielfeldZeichnen(spielfeld) :
    for row in spielfeld:
        columns = ""
        for column in row:
            columns += f"{column} "
        
        print(columns + "\n")

def eingabeSpieler(currentPlayer, spielfeld):
    print(f"CurrentPlayer: {currentPlayer}")
    eingabeColumn = int(input("Enter Column: (0,1,2)")) 
    eingabeRow = int(input("Enter Row: (0,1,2)"))
    spielfeld[eingabeRow][eingabeColumn] = currentPlayer
    
    if(currentPlayer == "X"):
        return "O"
    return "X"
    
def main():
    spielfeld = [["-", "-", "-"], ["-", "-", "-"], ["-", "-", "-"]]
    gameOver = False
    currentPlayer = "X"
    
    while not gameOver:
        spielfeldZeichnen(spielfeld)
        currentPlayer = eingabeSpieler(currentPlayer, spielfeld)
        gameOver = winner(spielfeld)
    spielfeldZeichnen(spielfeld)

if __name__ == "__main__":
    main()
    


