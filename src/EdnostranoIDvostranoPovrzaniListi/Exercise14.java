//Дадена е двојно поврзана листа од двојно поврзани листи. Да се најде сума на секоја од подлистите, а потоа производ на овие суми
//Влез:
//Број N кој кажува колку листи има
//Број М кој кажува колку елементи има во секоја листа
//Во следните М линии се податоците 1<=A<=1000 за секоја од листите
//Излез:
//Еден број што е производот на сумите од листите.

package EdnostranoIDvostranoPovrzaniListi;
import java.util.Scanner;
public class Exercise14 {

    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        DLLNode<DLL<Integer>> currentlist= list.getFirst();
        long[] sums= new long[100];
        int i=0;
        while (currentlist!=null){
            DLLNode<Integer> current=currentlist.element.getFirst();
            while (current!=null){
                sums[i]+=current.element;
                current=current.succ;
            }
            currentlist=currentlist.succ;
            i++;
        }
        long magicnumber=1;
        for (int j=0;j<i;j++){
            magicnumber*=sums[j];
        }
        return magicnumber;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<Integer>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(in.nextInt());
            }
            list.insertLast(tmp);
        }
        in.close();
        System.out.println(findMagicNumber(list));
    }

}