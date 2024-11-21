package EdnostranoIDvostranoPovrzaniListi;
//Дадени се две двоjно поврзани листи чии што jазли содржат по една природен
//броj. Од првата листа треба да се избришат сите поjавувања на втората листа
//(поjавување на една листа во друга значи првата листа да е подлиста на втората).
//Jазлите што ´ке останат во првата листа треба да се прикажат на излез. Ако не
//остане ниту еден jазел се печати Prazna lista.
//Влез: Во првиот ред од влезот е даден броjот на jазли на првата листа, потоа
//во вториот ред се дадени броевите од кои се составени jазлите по редослед во
//првата листа разделени со празно место. Во третиот ред е даден броjот на jазли
//на втората листа, а во четвртиот ред броевите од кои се составени jазлите по
//редослед во втората листа.
//Излез: На излез треба да се испечатат jазлите по редослед во резултантната
//(првата) листа. Ако не остане ниту еден jазел се печати Prazna lista.
//Пример.
//Влез:
//22
//1 2 3 4 5 6 1 2 3 4 5 6 1 2 6 5 1 3 4 1 5 2
//3
//4 5 6 Излез:
//1 2 3 1 2 3 1 2 6 5 1 3 4 1 5 2


import java.util.Scanner;
public class Exercise17 {
    public void funkcija(DLL<Integer> lista,DLL<Integer> lista2){
        DLLNode<Integer> current= lista.getFirst();
        DLLNode<Integer> current2= lista2.getFirst();
        DLL<Integer> resultlista= new DLL<>();
        while (current!=null){
            current2=lista2.getFirst();
            DLLNode<Integer> tmp=current;
            if(!current.element.equals(current2.element)){
                resultlista.insertLast(current.element);
                current=current.succ;
            }
            else{
                boolean istise=true;
                while (current2!=null){
                    if(!current.element.equals(current2.element)){
                        istise=false;
                    }
                    current=current.succ;
                    current2=current2.succ;
                }

                if(!istise){
                    current=tmp;
                    current2=lista2.getFirst();
                    while (current.element.equals(current2.element)){
                        resultlista.insertLast(current.element);
                        current=current.succ;
                        current2=current2.succ;
                    }

                }
            }
        }
        System.out.println(resultlista);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n= input.nextInt();
        DLL<Integer> lista= new DLL<>();
        for (int i=0;i<n;i++){
            lista.insertLast(input.nextInt());
        }
        int m= input.nextInt();
        DLL<Integer> lista2= new DLL<>();
        for (int i=0;i<m;i++){
            lista2.insertLast(input.nextInt());
        }
        Exercise17 result = new Exercise17();
        result.funkcija(lista,lista2);
    }
}

