package EdnostranoIDvostranoPovrzaniListi;//Дадена е двострано поврзана листа од цели броеви. Дополнително, даден е и уште еден природен
//број k. Елементите во листата треба да се ротираат k пати на лево.
//Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните
//следниот ред самите елементи одделени со празно место. На крај, во последниот ред даден е и природниот број k.
//Излез: На излез треба да се испечати листата пред и после промената.


import java.util.Scanner;

public class Exercise7{

    public void funkcija(DLL<String> lista, int l){
        DLLNode<String> current=lista.getFirst();
        DLLNode<String> brisi=null;
        for (int i=0;i<l;i++){
            brisi=current;
            lista.insertLast(current.element);
            lista.delete(brisi);
            current=current.succ;
        }
    }
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        int n=input.nextInt();
        DLL<String> lista= new DLL<String>();
        for (int i=0;i<n;i++){
            lista.insertLast(input.next());
        }
        int l=input.nextInt();
        Exercise7 result= new Exercise7();
        result.funkcija(lista,l);
        System.out.println(lista);

    }
}
