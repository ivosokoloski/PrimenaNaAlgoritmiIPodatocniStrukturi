package HierarhiskiStrukturiDrva;
//Дадено ви е бинарно пребарувачко дрво со N цели броеви.
//Напишете функција со која за бинарно пребарувачко дрво и избран елемент Т од дрвото:
//ќе најдете колку елементи во дрвото се помали од T
//Ќе треба да ја искористите таа функција Q пати при градењето на дрвото.
//Влезот ќе содржи N+Q редови од видот
//insert value - Треба да ја вметнете вредноста value во дрвото.
//ask value - Треба да одговорите колку елементи во дрвото имаат вредност помала од value
//Пример и структура на влезот:
//Влез
//Објаснување
//Излез
//10 7
//insert 6
//insert 3
//insert 7
//ask 3
//ask 6
//insert 4
//insert 1
//insert 2
//insert 5
//insert 9
//ask 3
//ask 9
//insert 8
//insert 10
//ask 8
//ask 4
//ask 5
//Прикажано е изгледот на дрвото при секое од 7те прашања во влезот
//0
//1
//2
//7
//7
//3
//4
//

import HierarhiskiStrukturiDrva.HierarhiskiStrukturiDrva_PomosniStrukturi.BNode;
import HierarhiskiStrukturiDrva.HierarhiskiStrukturiDrva_PomosniStrukturi.BinarySearchTree;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N= input.nextInt();
        int Q= input.nextInt();
        int n= N+Q;
        BinarySearchTree<Integer> tree= new BinarySearchTree<Integer>();
        input.nextLine();
        for(int i=0;i<n;i++){
            String[] src= input.nextLine().split(" ");
            if(src[0].equals("insert")){
                int elem= Integer.parseInt(src[1]);
                tree.insert(elem);
            }else if(src[0].equals("ask")){
                int elem= Integer.parseInt(src[1]);
                int counter=0;
                System.out.println(findBigger(tree.getRoot(),elem));
            }
        }
    }

    private static int findBigger(BNode<Integer> t, int x) {
        if(t==null){
            return 0;
        }
        if(t.info<x){
            return 1+ findBigger(t.left,x)+findBigger(t.right,x);
        }else{
            return findBigger(t.left,x)+findBigger(t.right,x);
        }
    }

}

