//На автобуската станица во ФинТаун имало N возрасни и M деца кои што сакале да патуваат заедно за соседниот град МинТаун. Цената на еден билет е 100 денари. Ако некој возрасен сака да патува со K деца,
//треба да плати еден билет за него и K-1 билети за децата (за едно дете не мора да плаќа билет).
//Исто така, возрасен може да се вози и сам, во тој случај ќе си плати еден билет за него.
//Дополнително знаеме дека децата не можат да се возат без да се придружени од некој возрасен.
//Во првиот ред од влезот е даден бројот N. Во вториот ред е даден бројот M. Потребно е да
//пресметате колкав е минималниот и максималниот број на денари што може да ги платат
//патниците за билети и да ги испечатите во две линии. Во автобусот ќе има најмалку еден возрасен.


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exercise6 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        int max=0;
        int min=0;
        if(M!=0){
            max=(N*100)+((M-1)*100);
        }else{
            max=(N*100);
        }

        while (N>0){
            if(M!=0){
                min += 100;
                N--;
                M--;
            }else{
                min+=100;
                N--;
            }
        }
        if(M!=0){
            min+=M*100;
        }
        System.out.println(min);
        System.out.println(max);



    }

}
