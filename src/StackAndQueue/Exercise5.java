package StackAndQueue;

import java.util.NoSuchElementException;

//
//Студентската служба на факултет работи со студенти од
//09:00 до 12:00. Ако знаеме за секој студент од редицата
//колку време е потребно за студентската служба да го
//опслужи, да се одреди кој студент ќе биде првиот студент
//кој нема да биде опслужен и колку студенти што чекале во
//редицата за тој ден не се опслужени.
//
public class Exercise5 {
    public void studentikoisefrakja(ArrayQueue<Students> studenti){
        int min = 180;
        for (int i=0;i<100;i++){
            Students s=studenti.peek();
            if(min-s.minuti>0){
                min-=s.minuti;
                studenti.dequeue();
            }else{
                break;
            }
        }
    }
    public static void main(String[] args){
        ArrayQueue<Students> stuednti= new ArrayQueue<>(100);
        stuednti.enqueue(new Students(233542,40));
        stuednti.enqueue(new Students(269622,40));
        stuednti.enqueue(new Students(245822,10));
        stuednti.enqueue(new Students(224822,20));
        stuednti.enqueue(new Students(299922,30));
        stuednti.enqueue(new Students(236662,50));
        stuednti.enqueue(new Students(222222,40));
        stuednti.enqueue(new Students(211122,40));
        Exercise5 result= new Exercise5();
        result.studentikoisefrakja(stuednti);
        while (!stuednti.isEmpty()){
            System.out.println(stuednti.dequeue());
        }
    }
}

class ArrayQueue<E> {
    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Ako length > 0, togash elementite na redicata se zachuvani vo elems[front...rear-1]
    // Ako rear > front, togash vo  elems[front...maxlength-1] i elems[0...rear-1]
    E[] elems;
    int length, front, rear;

    // Konstruktor ...

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size() {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek() {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    public void clear() {
        // Ja prazni redicata.
        length = 0;
        front = rear = 0;  // arbitrary
    }

    public void enqueue(E x) {
        // Go dodava x na kraj od redicata.
        if (length == elems.length)
            throw new NoSuchElementException();
        elems[rear++] = x;
        if (rear == elems.length) rear = 0;
        length++;
    }

    public E dequeue() {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length) front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}
class Students{
    int index;
    int minuti;

    public Students(int index, int minuti) {
        this.index = index;
        this.minuti = minuti;
    }

    @Override
    public String toString() {
        return "{" + index+" "+ minuti + '}';
    }
}
