package EdnostranoIDvostranoPovrzaniListi;//Дадена е еднострана поврзана листа чии што јазли содржат по еден String. Дополнително,
//даден е и уште еден природен број L. Од дадената листа потребно е да се најде последниот
//јазел којшто содржи String со должина L и да се премести на почеток на листата.
//Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните N редови
//се дадени самите елементи (String-ови) од листата. На крај, во последниот ред е даден бројот L.
//Излез: На излез треба да се испечати листата пред и после промената.


import java.util.Scanner;

public class Exercise5{

    public void zamena(SLL<String> niza, int k){
        if(niza.size()<2){
            return;
        }
        SLLNode<String> current= niza.getFirst();
        SLLNode<String> last= null;
        SLLNode<String> cuva= null;

        while(current!=null){
            if(current.element.length()==k){
                last=current;
                cuva=current;
            }
            current=current.succ;
        }
        if(last==null) {
            return;
        }
        niza.insertFirst(last.element);
        niza.delete(cuva);


    }
    public static void main(String[] args){
        SLL<String> niza =new SLL<>();
        Scanner input= new Scanner(System.in);
        int n= input.nextInt();
        for (int i=0;i<n;i++){
            niza.insertLast(input.next());
        }
        int k=input.nextInt();
        Exercise5 rez= new Exercise5();
        System.out.println(niza);
        rez.zamena(niza,k);
        System.out.println(niza);
    }


}
