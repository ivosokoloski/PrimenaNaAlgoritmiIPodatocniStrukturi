package VovedniZadaciIAlgoritmi;//За даден збор кој се внесува од стандарден влез, да се испечати истиот превртен.
//На влез во првиот ред се дава број на зборови кои ќе се внесуваат.
//Во наредните линии се внесуваат самите зборови.

import java.util.Scanner;

public class Exercise2{

    public static void printReversed(String word) {
        char [] bukvi=new char[word.length()];
        for(int i=0;i<word.length();i++){
            bukvi[i]=word.charAt(i);
        }
        for(int i=word.length()-1;i>=0;i--){
            System.out.print(bukvi[i]);
        }
    }

    public static void main(String[] args) {
        int number;
        Scanner input=new Scanner(System.in);
        number=input.nextInt();
        input.nextLine();
        for (int i=0;i<number;i++){
            String word=input.nextLine();
            printReversed(word);
            System.out.println();
        }
    }
}