package EdnostranoIDvostranoPovrzaniListi;
//Дадена е двострано поврзана листа од цели броеви. Дополнително, даден е и уште
//еден природен број k. Потребно е првите k елементи од листата да се преместат на
//крај, во истиот редослед.
//Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во
//следните следниот ред самите елементи одделени со празно место. На крај,
////во последниот ред даден е и природниот број k. (k<=N)
//Излез: На излез треба да се испечати листата пред и после промената.

import java.util.Scanner;

public class Exercise11{

    public void funkcija(DLL<Integer> lista, int l){
        DLLNode<Integer> brisi=null;
        for (int i=0;i<l;i++){
            DLLNode<Integer> current=lista.getFirst();
            brisi=current;
            lista.insertLast(current.element);
            lista.delete(brisi);
        }

    }
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        int n=input.nextInt();
        DLL<Integer> lista= new DLL<Integer>();
        for (int i=0;i<n;i++){
            lista.insertLast(input.nextInt());
        }
        int l=input.nextInt();
        Exercise11 result= new Exercise11();
        System.out.println(lista);
        result.funkcija(lista,l);
        System.out.println(lista);

    }
}
