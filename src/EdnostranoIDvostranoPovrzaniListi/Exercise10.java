package EdnostranoIDvostranoPovrzaniListi;
//Дадена е двострано поврзана листа од цели броеви. Дополнително, даден е и уште еден
//природен број k. Последните k елементи од листата треба да се поместат на почетокот
//на листата, во истиот редослед.
//Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните
//следниот ред самите елементи одделени со празно место. На крај, во последниот ред даден
//е и природниот број k. (k<=N)
//Излез: На излез треба да се испечати листата пред и после промената.

import java.util.Scanner;

public class Exercise10{

    public void funkcija(DLL<Integer> lista, int l){
        DLLNode<Integer> brisi=null;
        for (int i=0;i<l;i++){
            DLLNode<Integer> current=lista.getLast();
            brisi=current;
            lista.insertFirst(current.element);
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
        Exercise10 result= new Exercise10();
        System.out.println(lista);
        result.funkcija(lista,l);
        System.out.println(lista);

    }
}
