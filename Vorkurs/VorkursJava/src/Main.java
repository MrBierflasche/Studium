import java.util.Scanner;
void main() {
    Scanner input =new Scanner(System.in);
    IO.println(String.format("Bitte geben Sie eine Zahl ein!"));
    String zahl = input.nextLine()  ;
    for (int i = 1; i <= 5; i++) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        IO.println("i = " + i);
    }
}
