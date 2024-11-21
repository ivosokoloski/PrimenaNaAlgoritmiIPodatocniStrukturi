package EdnostranoIDvostranoPovrzaniListi;

//Дадена е еднострана поврзана листа со цели броеви. Ваша задача е да бришете
//jазли т.ш. прво ´ке оставите еден jазол, еден ´ке бришете, па ´ке оставите 2 jазли
//еден ´ке бришете, па ´ке оставите 3 jазли па еден ´ке бришете итн... Односно од вас
//се бара да бришете преку 1, па преку 2, па преку 3 jазли итн... додека е возможно
//да се брише.
//Влез: Во првата линиjа е даден броjот на елементи n. Во втората линиjа се
//даваат броевите во листата одделени со празно место.
//Излез: Резултатната листа. Доколку листата е празна испечатете: Prazna
//lista
//Пример.
//Влез:
//9
//4 6 8 3 1 3 5 7 2
//Излез:
//4->8->3->3->5->7

import java.util.Scanner;

public class Exercise16 {
    public void funkcija(SLL<Integer> lista){
        SLLNode<Integer> current= lista.getFirst();
        SLL<Integer> resultlista= new SLL<>();
        int counter=1;
        while (current!=null){
            int i=0;
            while (i!=counter){
                resultlista.insertLast(current.element);
                i++;
                current=current.succ;
            }
            counter++;
            current=current.succ;
        }
        System.out.println(resultlista);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n= input.nextInt();
        SLL<Integer> lista= new SLL<>();
        for (int i=0;i<n;i++){
            lista.insertLast(input.nextInt());
        }
        Exercise16 result = new Exercise16();
        result.funkcija(lista);
    }
}
