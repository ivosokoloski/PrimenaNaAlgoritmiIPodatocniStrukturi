//Дадена е еднострана поврзана листа од броеви со дупликати. За дадена вредност на info поле во листата, да се обезбеди бројот на повторувања на тој број да биде парен. Доколку за дадената вредност на инфо полето, бројот на елементи со таа вредност е непарен,
//треба да се додаде истиот елемент пред првото појавување на елементот со таа вредност  во листата.
//Забелешка: 0 е парен број.
//Влез:
//Во првиот ред се внесуваат бројот на елементи во листата, па потоа самите елементи,
//а на крај се внесува бројот (вредноста) кој ќе се осигураме дека се појавува парен број на пати.
//Излез:
//Листата со парен број на дупликати за дадената вредност

package EdnostranoIDvostranoPovrzaniListi;
import java.util.Scanner;
public class Exercise13 {

    public static void change(SLL<Integer> list, int br) {
        SLLNode<Integer> current= list.getFirst();
        int counter=0;
        while (current!=null){
            if(current.element==br){
                counter++;
            }
            current=current.succ;
        }
        if(counter%2!=0){
            current= list.getFirst();
            while (current!=null){
                if(current.element==br){
                    list.insertBefore(br,current);
                    break;
                }
                current=current.succ;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, broj;
        SLL<Integer> list1 = new SLL<Integer>();
        n = scan.nextInt();
        for(int i = 0; i<n; i++) {
            list1.insertLast(scan.nextInt());
        }
        int br = scan.nextInt();
        change(list1,br);
        System.out.println(list1);


    }
}
