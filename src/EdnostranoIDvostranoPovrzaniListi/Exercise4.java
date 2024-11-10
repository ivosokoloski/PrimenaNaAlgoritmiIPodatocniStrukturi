package EdnostranoIDvostranoPovrzaniListi;//Дадена е еднострана поврзана листа чии што јазли содржат по еден String. Дополнително,
//даден е и уште еден природен број L. Во дадената листа потребно е сите јазли коишто содржат
//String со должина L да се поместат на крај на листата, задржувајќи го и оригиналниот распоред на елементите.
//Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните N
//редови се дадени самите елементи (String-ови) од листата. На крај, во последниот ред е даден бројот L.
//Излез: На излез треба да се испечати листата пред и после промената.

import java.util.Scanner;

public class Exercise4{

    public void funkcija(SLL<String> lista, int l){
        SLLNode<String>current=lista.getFirst();
        SLLNode<String>brisi=null;
        for (int i=0;i<lista.size();i++){
            if(current.element.length()==l){
                brisi=current;
                lista.insertLast(current.element);
                lista.delete(brisi);
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
        Exercise4 result= new Exercise4();
        System.out.println(lista);
        result.funkcija(lista,l);
        System.out.println(lista);

    }
}
