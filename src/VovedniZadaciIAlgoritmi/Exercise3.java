package VovedniZadaciIAlgoritmi;
//За потребите на софтвер за евиденција на приходите остварени од вработените во одделот за
//продажба, да се дефинира класа VovedniZadaci.QuarterlySales во која се чуваат бројот на продажби
//остварени во одреден квартал, приходот добиен од секоја продажба и бројот на кварталот.
//Потоа, да се дефинира друга класа VovedniZadaci.SalesPerson за кој се чува име (string) и низа од квартали (точно 4).
//За класите да се имплементираат соодветните конструктори и методи за правилно извршување на програмата.
//Да се имплементираат следните барања:
//• Метод int sumSales(VovedniZadaci.SalesPerson sp) кој ќе врати сума од сите приходи остварени од дадениот вработен во
//одделот за продажба во сите квартали.
//• Метод VovedniZadaci.SalesPerson salesChampion(VovedniZadaci.SalesPerson [] arr) кој за дадената низа од работници ќе го врати
//работникот со најголем остварен приход (од сите квартали).
//• Да се дополни main методот во кој ќе се иницијализира низа од вработени во одделот за продажба и
//квартали согласно влезните тест примери. Во првиот ред се чита број на вработени, а понатаму прво во
//еден ред се чита името, па за секој квартал во еден ред бројот на продажби, и во следниот ред приходот
//добиен од секоја од тие продажби.
//• На стандарден излез да се испечати низата од вработени во одделот за продажба со помош на методата
//void table(VovedniZadaci.SalesPerson [] arr) која за низата од вработени ќе отпечати приказ во следниот формат
//    (за простор при печатење се користат три празни места):


import java.util.Scanner;

class QuarterlySales {

    private int numOfSales;
    private int [] revenues;
    private int quarterNo;

    public QuarterlySales(int numOfSales, int[] revenues) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }
    public int Sum(){
        int sum=0;
        int size=revenues.length;
        for(int i=0;i<size;i++){
            sum+=revenues[i];
        }
        return sum;
    }

    public int getNumOfSales() {
        return numOfSales;
    }

    public int[] getRevenues() {
        return revenues;
    }

    public int getQuarterNo() {
        return quarterNo;
    }
}

class SalesPerson {

    private String name;
    private QuarterlySales [] quarters;

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }
    int sumSales(){
        int sum=0;
        for(int i=0;i<quarters.length;i++){
            sum+=quarters[i].Sum();
        }
        return sum;
    }

    public QuarterlySales[] getQuarters() {
        return quarters;
    }

    public String getName() {
        return name;
    }
    public void Pecati(){
        System.out.print(name+"   ");
        for (int i=0;i<4;i++){

            System.out.print(quarters[i].Sum() + "   ");

        }
        System.out.println(sumSales());
    }
}



public class Exercise3 {

    public static SalesPerson salesChampion(SalesPerson [] arr)
    {
        int max=0;
        int j=0;
        for (int i=0;i<arr.length;i++){
            if(max<arr[i].sumSales()){
                max=arr[i].sumSales();
                j=i;
            }
        }
        return arr[j];

    }
    public static void table(SalesPerson [] arr)
    {
        System.out.println("SP   1   2   3   4   Total");
        for (int i=0;i<arr.length;i++){
            arr[i].Pecati();
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        input.nextLine(); // Додадено за да се фати новиот ред по внес на број

        SalesPerson[] arr = new SalesPerson[n];
        for (int i = 0; i < n; i++) {
            String name = input.nextLine(); // Читање на името
            QuarterlySales[] kvartalite = new QuarterlySales[4];
            for (int j = 0; j < 4; j++) {
                int kolkucebida = input.nextInt(); // Внес на број на продажби
                int[] prodazbite = new int[kolkucebida];
                for (int k = 0; k < kolkucebida; k++) {
                    int tie = input.nextInt(); // Внес на поединечни продажби
                    prodazbite[k] = tie;
                }
                kvartalite[j] = new QuarterlySales(kolkucebida, prodazbite);
            }
            input.nextLine(); // Додадено за да се фати новиот ред пред да се премине на следниот внес
            arr[i] = new SalesPerson(name, kvartalite);
        }

        table(arr);
        System.out.println("SALES CHAMPION: " + salesChampion(arr).getName());

    }
}
