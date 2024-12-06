
//Во оваа задача ќе работите со два објекти „Вработени“ и „Проекти“.
//Еден вработен е дефиниран со 2 вредности: Име (String), Возраст (цел број).
//Еден проект е дефиниран со 2 вредности: Работно Време (цел број), Плата по час (цел број).
//За даден проект вкупната плата се пресметува како производ на работното време и платата по час.
//Вработените ќе добиваат понудени проекти, и треба да го изберат проектот од кој ќе добијат
//најголема плата (доколку имаат избор од повеќе проекти со иста најголема плата, тогаш првиот таков).
//Ваша задача ќе биде да им помогнете на вработените со тоа што ќе искористите CBHT со 10 кофички
//каде што за секој вработен ќе ја чувате неговата најдобра понуда.
//За хеш функција користете производ од возраста на вработениот и ASCII вредноста на првата буква
//од името на вработениот.
//
//Влез:
//Во првиот ред е даден еден цел број N кој го означува бројот на понуди. Потоа во следните N редови
//се дадени по 4 вредности, информациите за понудите, името и возраста на вработениот
//и работното време и платата од час на проектот соодветно:
//N
//name_1 age_1 time_1 rate_1
//name_2 age_2 time_2 rate_2
//...
//name_N age_N time_N rate_N
//Излез:
//Отпечатете ја целата табела (со готовиот toString метод).
//Секој вработен да се печати во формат "<name, age>" каде на местото на name и age треба да
//стои името и возраста на вработениот соодветно (имплементирајте го ова во toString метод)
//Секој проект да се печати во формат "<time, rate>" каде на местото на time и rate треба да стои
//работното време и платата по час на проектот соодветно (имплементирајте го ова во toString метод)
//
//Пример:
//Влез:
//5
//Martin 25 3 100
//Jana 26 4 90
//Martin 25 5 120
//Jana 26 2 95
//Nenad 20 6 80
//Излез:
//0:<<Nenad, 20>,<6, 80>>
//1:
//2:
//3:
//4:<<Jana, 26>,<4, 90>>
//5:<<Martin, 25>,<5, 120>>
//6:
//7:
//8:
//9:

package HashTabeli;

import java.util.Objects;
import java.util.Scanner;

class Person implements Comparable<Person> {
    String ime;
    int vozrast;

    public Person(String ime, int vozrast) {
        this.ime = ime;
        this.vozrast = vozrast;
    }

    @Override
    public String toString() {
        return "<" + ime + ", " + vozrast + ">";
    }

    @Override
    public boolean equals(Object o) {
        Person person = (Person) o;
        return this.hashCode()==o.hashCode()&& Objects.equals(person.ime, this.ime);  }
    @Override
    public int hashCode() {
        Character c=ime.charAt(0);
        return vozrast*(int)c;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.vozrast, o.vozrast);        }
}

class Project {
    int rabotnovreme;
    int plata;

    public Project(int rabotnovreme, int plata) {
        this.rabotnovreme = rabotnovreme;
        this.plata = plata;
    }

    @Override
    public String toString() {
        return "<" + rabotnovreme + ", " + plata + ">";
    }
    public void compareTo(Project o) {
        if(this.rabotnovreme*plata>o.rabotnovreme*plata){
            o.rabotnovreme=this.rabotnovreme;
            o.plata=this.plata;
        }
    }
}

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n=input.nextInt();
        CBHT<Person,Project> table = new CBHT<Person, Project>(10);
        int max=0;

        for (int i=0;i<n;i++){
            Person p=new Person(input.next(),input.nextInt());
            Project pr=new Project(input.nextInt(), input.nextInt());
            if(table.search(p)==null){
                table.insert(p,pr);
            }else{
                pr.compareTo(table.search(p).element.value);
            }
        }
        System.out.println(table);
    }
}

