//Дадена е еднострано поврзана листа чии што jазли содржат по еден природен
//броj. Во дадената листа треба да се пронаjдат елементите со наjмала и наjголема вредност
//и потоа листата треба да се подели на две резултантни еднострано
//поврзани листи, т.ш. во првата листа треба да се сместат сите jазли кои содржат
//броеви поблиски до наjмалиот елемент отколку до наjголемиот елемент, а во втората
//сите jазли кои содржат броеви поблиски до наjголемиот елемент отколку
//до наjмалиот. Доколку елементот е на исто растоjание од наjмалиот и наjголемиот елемент
//тогаш се сместува во листата на елементи поблиски до наjмалот
//елемент. Jазлите во резултантните листи се додаваат според редоследот по коj
//се поjавуваат во дадената листа. (Помош: броjот 3 е на растоjание 2 од броjот
//1 и на растоjание 4 од броjот 7. Следува дека броjот 3 е поблиску до броjот 1
//отколку до броjот 7).
//Влез: Во првата линиjа е даден броjот на елементи n. Во втората линиjа се
//даваат броевите во листата одделени со празно место.
//Излез: На излез во првиот ред треба да се испечатат jазлите по редослед на
//првата резултантната листа (коjа содржи елементи кои се поблиску до наjмалиот
//елемент). Во вториот ред треба да се испечатат jазлите на по редослед на втората
//резултантната листа (коjа содржи елементи кои се поблиску до наjголемиот
//елемент).
//Пример.
//Влез:
//9
//1 5 7 3 2 9 4 8 6
//Излез:
//1->5->3->2->4
//7->9->8->6
package EdnostranoIDvostranoPovrzaniListi;
import java.util.Scanner;

public class Exercise15 {
    public void funkcija(SLL<Integer> lista){
        SLLNode<Integer> current= lista.getFirst();
        SLL<Integer> najmal= new SLL<>();
        SLL<Integer> najgolem= new SLL<>();
        int min=100000000;
        int max=0;
        while (current!=null){
            if(min>current.element){
                min= current.element;
            }else if(current.element>max){
                max=current.element ;
            }
            current=current.succ;
        }
        current=lista.getFirst();
        while (current!=null){
            if(Math.abs(current.element-min)<=Math.abs(current.element-max)){
                najmal.insertLast(current.element);
            }else{
                najgolem.insertLast(current.element);
            }
            current=current.succ;
        }
        System.out.println(najmal);
        System.out.println(najgolem);


    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n= input.nextInt();
        SLL<Integer> lista= new SLL<>();
        for (int i=0;i<n;i++){
            lista.insertLast(input.nextInt());
        }
        Exercise15 result = new Exercise15();
        result.funkcija(lista);
    }
}
