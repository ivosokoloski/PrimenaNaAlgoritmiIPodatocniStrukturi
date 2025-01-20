package HashTabeli;
//На влез во оваа задача ќе ви бидат дадени редови како следниот формат:
//Ime Prezime budzhet ip_adresa vreme grad cena
//        Пример
//Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
//Кое што значи дека лицето со Име и Презиме Jovan Todorov, има буџет од 1000 денари,
// има IP адреса со мрежа 10.73.112 и домаќин (host number) 200, и се приклучил во 15:30
// часот за да купи билет кон Bitola кој што чини 760 денари.
//Ќе ви бидат дадени N такви редови, по што ќе следи празен ред па уште M редови од
// истиот формат, кои ќе ги користиме за тестирање.
//Од сите N лица на влез, кои што се поврзуваат со истата мрежа (од било кој домаќин во мрежата)
//колку од нив се вклучиле подоцна од 11:59; и
//од овие, кој од нив се вклучил најрано?
//(погледнете го тест примерот!)
//(доколку има повеќе со исто најмало време тогаш кој е првиот таков во влезот?) (секогаш ќе постои барем еден таков)

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n= input.nextInt();
        CBHT<String,Person2> tabela= new CBHT<>(n);
        for (int i=0;i<n;i++){
            Person2 p= new Person2(input.next().concat(" ").concat(input.next()),
                    input.nextInt(), input.next(), input.next(), input.next(), input.nextInt());
            if(p.actualvreme>=12){
                if(tabela.search(p.actualip)!=null){
                    if(tabela.search(p.actualip).element.value.bigest.actualvreme>p.actualvreme){
                        p.bigest=p;
                    }else {
                        p.bigest=tabela.search(p.actualip).element.value.bigest;
                    }
                    p.n=tabela.search(p.actualip).element.value.n+1;
                    tabela.insert(p.actualip,p);
                }else{
                    p.n=1;
                    p.bigest=p;
                    tabela.insert(p.actualip,p);
                }
            }

        }
        int m= input.nextInt();
        for (int i=0;i<m;i++){
            Person2 p= new Person2(input.next().concat(" ").concat(input.next()),
                    input.nextInt(), input.next(), input.next(), input.next(), input.nextInt());
            if(tabela.search(p.actualip)!=null){
                System.out.println("IP network: "+p.actualip+" has the following number of users:");
                System.out.println(tabela.search(p.actualip).element.value.n);
                System.out.println("The user who logged on earliest after noon from that network is:");
                System.out.println(tabela.search(p.actualip).element.value.bigest);
                System.out.println();
            }
        }
    }
}

class Person2{
    Person2 bigest;
    int n;
    String ime;
    int budjet;
    String ip;
    String actualip;
    String vreme;
    String grad;
    int actualvreme;
    int cena;

    public Person2(String ime, int budjet, String ip, String vreme, String grad, int cena) {
        this.ime = ime;
        this.budjet = budjet;
        this.ip = ip;
        this.actualip = ip.split("\\.")[0].concat(".").concat(ip.split("\\.")[1]).concat(".").concat(ip.split("\\.")[2]);
        this.vreme = vreme;
        this.actualvreme=Integer.parseInt(vreme.split("\\:")[0]);
        this.grad = grad;
        this.cena = cena;
    }

    @Override
    public String toString() {
        return ime+" with salary "+budjet+" from address "+ip+" who logged in at "+vreme;
    }
}

