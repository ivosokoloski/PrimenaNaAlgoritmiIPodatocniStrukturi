package VovedniZadaciIAlgoritmi;//За дадена низа од случајни броеви кои се внесуваат од стандарден влез,
//да се направи преместување на сите нули на почеток на низата.
//На стандарден излез да се испечати трансформираната низа.

import java.util.Scanner;

public class Exercise1
{
    static void pushZerosToBeginning(int[] arr, int n)
    {
        int[] arr2 = new int[100];
        int j=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                arr2[j]=arr[i];
                j++;
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                arr2[j]=arr[i];
                j++;
            }
        }
        System.out.println("Transformiranata niza e: ");
        for (int i=0;i<n;i++){
            System.out.print(arr2[i]+" ");
        }

    }

    public static void main (String[] args)
    {


        int[] arr=new int[100];

        Scanner input=new Scanner(System.in);
        int n = input.nextInt();
        for (int i=0;i<n;i++){
            arr[i]=input.nextInt();
        }
        pushZerosToBeginning(arr,n);



    }
}