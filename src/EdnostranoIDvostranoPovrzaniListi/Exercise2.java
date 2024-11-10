package EdnostranoIDvostranoPovrzaniListi;//Дадена е еднострана поврзана листа чии што јазли содржат по еден String.
//Дополнително, даден е и уште еден природен број L. Во дадената листа после секој јазол
//којшто содржи String со должина L да се вметне нов јазол со вредност "Target".
//Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните
//N редови се дадени самите елементи (String-ови) од листата. На крај, во последниот ред е даден бројот L.
//Излез: На излез треба да се испечати листата пред и после промената.

import java.util.Scanner;

public class Exercise2{

    public void funkcija(SLL<String> lista, int l){
        SLLNode<String> current=lista.getFirst();
        while (current!=null){
            if(current.element.length()==l){
                lista.insertAfter("Target",current);
                current=current.succ;
            }
            current=current.succ;
        }

    }
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        int n=input.nextInt();
        SLL<String> lista= new SLL<String>();
        for (int i=0;i<n;i++){
            lista.insertLast(input.next());
        }
        int l=input.nextInt();
        Exercise2 result= new Exercise2();
        System.out.println(lista);
        result.funkcija(lista,l);
        System.out.println(lista);

    }
}
