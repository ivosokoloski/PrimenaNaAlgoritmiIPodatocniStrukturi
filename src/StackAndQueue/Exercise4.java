package StackAndQueue;//Даден е код на модифициран програмски јазик каде функциите се претставени со отворен
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

import java.util.LinkedList;
import java.util.Scanner;

public class Exercise4 {
    public void funkcija(LinkedList<String> glavenstek){
        LinkedList<String> bezend = new LinkedList<>();
        LinkedList<String> soend= new LinkedList<>();
        while (!glavenstek.isEmpty()){
            String zbor= glavenstek.getFirst();
            glavenstek.removeFirst();
            if(zbor.contains("end")){
                soend.add(zbor);
            }else{
                bezend.add(zbor);
            }
        }
        if(bezend.size()!=soend.size()){
            System.out.println("Invalid");
            return;
        }
        LinkedList<String> tmp = new LinkedList<>();
        while (!soend.isEmpty()){
            String zbor=soend.getFirst();
            soend.removeFirst();
            boolean pripajdza=false;
            while (!bezend.isEmpty()){
                String vtorzbor = bezend.getFirst();
                tmp.add(bezend.getFirst());
                bezend.removeFirst();
                if(zbor.contains(vtorzbor)){
                    pripajdza=true;
                }
            }
            if(!pripajdza){
                System.out.println("Invalid");
                return;
            }
            while (!tmp.isEmpty()){
                bezend.add(tmp.getFirst());
                tmp.removeFirst();
            }
        }
        System.out.println("Valid");
    }


    public static void main(String[] args) {
        LinkedList<String> glavenstek= new LinkedList<>();
        Scanner input= new Scanner(System.in);
        for (int i=0;i<100;i++){
            String str= input.next();
            if(str.equals("x")){
                break;
            }else {
                glavenstek.push(str);
            }
        }
        Exercise4 result = new Exercise4();
        result.funkcija(glavenstek);

    }
}
