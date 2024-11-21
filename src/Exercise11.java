//Задача 2. Молекула на вода
//Да се напише алгоритам со коj ´ке се имплементира играта “Направи молекула
//на вода”. Во оваа игра на располагање имате два типа атоми (H-водород, и Oкислород).
//За да се направи молекула на вода (H2O) потребно е да имате два
//атоми на водород и еден атом на кислород. На почеток се генерира една случаjна
//секвенца од атоми. Ваша задача е од тоj влез, како доа´гаат атомите да генерирате
//молекули и да кажете колку такви молекули се креирале, и кои атоми останале
//несврзани.
//Влез: Во влезот е дадена секвенца од случаjни атоми
//Излез: На излез треба да се испечати броjот на молекули H2O, и несврзаните
//атоми од водород и кислород.
//Пример:
//Влез:
//H H O H H O H H O H H H H H O H O H O O H O O H H H
//Излез:
//8
//H

import java.util.Scanner;
import java.util.Stack;

public class Exercise11 {
    public void funkcija(String str){
        Stack<Character> vodorodstek = new Stack<>();
        Stack<Character> kislorodstek = new Stack<>();
        int counter=0;
        int j=0;
        for (int i=0;i<str.length();i++){
            Character c= str.charAt(i);
            if(c.equals(' ')){
                continue;
            }else if(c.equals('H')){
                j=i;
                vodorodstek.push(c);
                if(vodorodstek.size()>1&&!kislorodstek.isEmpty()){
                    vodorodstek.pop();
                    vodorodstek.pop();
                    kislorodstek.pop();
                    counter++;

                }


            }else{
                kislorodstek.push(c);
                j=i;
            }
        }


        System.out.println(counter);
        for (int i=j;i<str.length();i++){
            System.out.print(str.charAt(i));
        }


    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String str= "H H O H H O H H O H H H H H O H O H O O H O O H H H";
        Exercise11 result = new Exercise11();
        result.funkcija(str);
    }
}
