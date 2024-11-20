//Даден е код на модифициран програмски јазик каде функциите се претставени со отворен
//и затворен таг ("imeFunkcija" и "endimeFunkcija"). Ваша задача е да дефинирате дали даден
//програмски код е валиден.
//Пример валиден код:
//func1
//func2
//endfunc2
//func3
//endfunc3
//endfunc1
//Пример невалиден код (испуштен е затворен таг за func3):
//func1
//func2
//endfunc2
//func3
//endfunc1
//Влез: Код со модифициран програмски јазик, каде секој таг е напишан во нов ред. Се внесуваат тагови се додека не се внесе "x".
//Излез: "Valid" - доколку е валиден кодот, "Invalid" - доколку не е валиден кодот.
///
//We are given code in a modified programming language is given, where functions are represented
//by an opening and closing tag ("functionName" and "endfunctionName").
//Your task is to determine whether the given code is valid.
//Example of valid code:
// func1
//func2
//endfunc2
//func3
//endfunc3
//endfunc1
//Example of invalid code (missing closing tag for func3):
//func1
//func2
//endfunc2
//func3
//endfunc1
//Input: Code in a modified programming language, where each tag is written in a new line. Tags are entered until "x" is entered.
//Output: "Valid" if the code is valid, "Invalid" if the code is not valid.

import java.util.Scanner;
import java.util.Stack;

public class Exercise9 {

    public boolean funkcija( Stack<String> stek){
        Stack<String> endstek= new Stack<>();
        Stack<String> otherstek= new Stack<>();
        while(!stek.isEmpty()){
            String zbor= stek.pop();
            if(zbor.contains("end")){
                endstek.push(zbor.substring(3));
            }else{
                otherstek.push(zbor);
            }
        }
        if(endstek.size()!=otherstek.size()){
            return false;
        }

        while(!endstek.isEmpty()){
            String zbor= endstek.pop();
            if(!otherstek.contains(zbor)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Stack<String> stek= new Stack<>();
        Scanner input= new Scanner(System.in);
        for (int i=0;i<1000;i++){
            String zbor= input.next();
            if (zbor.equals("x")){
                break;
            }
            stek.push(zbor);
        }
        Exercise9 result= new Exercise9();
        if(result.funkcija(stek)){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }

    }
}
