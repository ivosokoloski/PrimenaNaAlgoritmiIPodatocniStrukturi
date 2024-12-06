package VovedniZadaciIAlgoritmi;//Дадени се Н цифри. Да се напише алгоритам кој ќе го даде најголемиот можен број составен од тие цифри.
//Влез: Првиот број од влезот е бројот на цифри N, а потоа во следниот ред се цифрите.
//Излез: Најголемиот број кој може да се состави од тие цифри
//We are given N digits. Write an algorithm that composes the largest possible number from those digits.
//Input: The first number in the input is the number of digits N, then in the next line are the given digits.
//Output: The maximum possible number containing those digits


import java.util.Scanner;

public class Exercise6 {

    public void NajgolemBroj(int [] numbers){
        for (int i=0;i<numbers.length-1;i++){
            for (int j=i;j<numbers.length;j++){
                if(numbers[i]<numbers[j]){
                    int tmp= numbers[i];
                    numbers[i]=numbers[j];
                    numbers[j]=tmp;
                }
            }
        }
        for (int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]);
        }
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n= input.nextInt();
        int [] numbers= new int[n];
        for (int i=0;i<n;i++){
            numbers[i]=input.nextInt();
        }
        Exercise6 result= new Exercise6();
        result.NajgolemBroj(numbers);
    }
}
