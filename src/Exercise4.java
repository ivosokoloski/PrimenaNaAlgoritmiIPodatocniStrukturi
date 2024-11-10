//Дадена е сортирана низа од N броеви и број М кој го бараме во таа низа. Со помош на методата
//„раздели па владеј“ да се имплементира бинарно пребарување, да се најде бараниот број во таа низа и
//да се испечати неговата позиција. Доколку бројот не е во низата да е испечати "Ne postoi".
//Влез: Првиот број од влезот е големината на низата N и бараниот број М, а потоа во следниот ред се елементите на низата.
//Излез: Позицијата на која се наоѓа бараниот број, или "Ne postoi" доколку бројот не се наоѓа во низата.
//We are given an array of N numbers. Using the method "divide and conquer" write a binary search algorithm that searches for a given number M. If the number is found, print the position of the number in the array. If the number is not in the array, print "Ne postoi".
//Input: The first number in the input is the size of the array N, and the number we are searching M. Then in the next line are the array elements.
//Output: The position of the number we are searching, or "Ne postoi" if no such number exists in the array.

import java.util.Scanner;

public class Exercise4 {

    int razdeliivladej(int[] niza, int m,  int l, int r, int mid){
        if(mid==1||mid==niza.length-1){
            if(niza[0]==m){
                return 0;
            }
            if(niza[mid]==m){
                return mid;
            }else{
                return -1;
            }
        }
        if(m<=niza[mid]){
            if(niza[mid]==m){
                return mid;
            }else{
                return razdeliivladej(niza,m,l,mid,(l+r-1)/2);
            }
        }
        return razdeliivladej(niza,m,mid,r,(mid+r+1)/2);

    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n= input.nextInt();
        int m= input.nextInt();
        int[] niza= new int[n];
        for (int i=0;i<n;i++){
            niza[i]=input.nextInt();
        }
        Exercise4 result = new Exercise4();
        int l=0;
        int r= n-1;
        int mid =l+r/2;
        if(result.razdeliivladej(niza,m,l,r,mid)==-1){
            System.out.println("Ne postoi");
        }else{
            System.out.println(result.razdeliivladej(niza,m,l,r,mid));
        }

    }


}