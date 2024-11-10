package EdnostranoIDvostranoPovrzaniListi;
//Дадена е двострано поврзана листа од цели броеви. Дополнително, дадени се и уште еден цел
//број M и еден природен број k. Треба да се најде првото појавување на M во листата и тој
//број да се помести k места на десно.
//Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните
//следниот ред самите елементи одделени со празно место. На крај, во последните два реда дадени се
//целиот број M и природниот број k.
//Излез: На излез треба да се испечати листата пред и после промената.


import java.util.Scanner;

public class Exercise9{

    public void funkcija(DLL<Integer> lista, int l, int m){
        DLLNode<Integer> current=lista.getFirst();

        DLLNode<Integer> brisi=null;
        int counter=0;
        for (int i=0;i< lista.getSize();i++){
            if(current.element==l) {
                counter++;
                brisi=current;
                boolean pomina=false;
                for (int k=0;k<m;k++){
                    if(current.succ!=null){
                        current=current.succ;

                    }else{
                        current=lista.getFirst();
                        pomina=true;
                    }
                }
                if(pomina){
                    lista.insertBefore(brisi.element, current);
                    lista.delete(brisi);
                    break;
                }lista.insertAfter(brisi.element, current);


                lista.delete(brisi);
                break;

            }else {
                current = current.succ;
            }

        }
        if(counter==0){
            System.out.println("Elementot ne postoi vo listata");
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
        int m=input.nextInt();
        Exercise9 result= new Exercise9();
        System.out.println(lista);
        result.funkcija(lista,l,m);
        System.out.println(lista);

    }
}
