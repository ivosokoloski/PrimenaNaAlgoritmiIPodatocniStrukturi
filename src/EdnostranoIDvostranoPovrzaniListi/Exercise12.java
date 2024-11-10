package EdnostranoIDvostranoPovrzaniListi;//За дадена двојно поврзана листа од N цели броеви, треба да се најде бројот на
//елементи такви што просекот на елементите од пред него во листата е поголем од
//просекот на елементи после него во листата.
//Влез: Првиот број од влезот е бројот на елементи во листата N, а потоа во следниот
//ред се дадени самите елементи одделени со празно место.
//Излез: Бројот на елементи што го задоволуваат условот.

import java.util.Scanner;

public class Exercise12<E>{
    public int prosek(DLL<Integer> lista){
        DLLNode<Integer> current=lista.getFirst().succ;
        int result=0;

        while (current.succ!=null){
            DLLNode<Integer> tmpBefore=lista.getFirst();
            DLLNode<Integer> tmpAfter=current.succ;
            float nbefore=0;
            float nafter=0;
            int sumBefore=0;
            int sumAfter=0;
            while (tmpBefore!=current){
                sumBefore+=tmpBefore.element;
                nbefore++;
                tmpBefore=tmpBefore.succ;
            }
            while (tmpAfter!=null){
                sumAfter+=tmpAfter.element;
                tmpAfter=tmpAfter.succ;
                nafter++;
            }
            float prosekbefore=sumBefore/nbefore;
            float prosekafter=sumAfter/nafter;
            if(prosekbefore>prosekafter){
                result++;
            }
            current=current.succ;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        DLL<Integer> lista= new DLL<>();
        int n=input.nextInt();
        for (int i=0;i<n;i++){
            lista.insertLast(input.nextInt());
        }
        Exercise12<Integer> result=new Exercise12<>();
        System.out.println(result.prosek(lista));
    }


}
