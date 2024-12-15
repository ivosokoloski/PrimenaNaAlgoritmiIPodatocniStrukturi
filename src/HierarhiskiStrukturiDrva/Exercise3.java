package HierarhiskiStrukturiDrva;

//Дадено ви е бинарно пребарувачко дрво со N цели броеви.
//Напишете функција со која за бинарно пребарувачко дрво и избран елемент Т од дрвото:
//ќе најдете на која длабочина се наоѓа елементот T во дрвото
//Ќе треба да ја искористите таа функција Q пати при градењето на дрвото.
//Влезот ќе содржи N+Q редови од видот
//insert value - Треба да ја вметнете вредноста value во дрвото.
//ask value - Треба да одговорите на која длабочина во дрвото се наоѓа јазелот со вредност value
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
//2
//1
//2
//3
//4
//3
//4
//

import HierarhiskiStrukturiDrva.HierarhiskiStrukturiDrva_PomosniStrukturi.BNode;
import HierarhiskiStrukturiDrva.HierarhiskiStrukturiDrva_PomosniStrukturi.BinarySearchTree;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N= input.nextInt();
        int Q= input.nextInt();
        int n= N+Q;
        BinarySearchTree<Integer> tree= new BinarySearchTree<>();
        input.nextLine();
        for(int i=0;i<n;i++){
            String[] src= input.nextLine().split(" ");
            if(src[0].equals("insert")){
                int elem= Integer.parseInt(src[1]);
                tree.insert(elem);
            }else if(src[0].equals("ask")){
                int elem= Integer.parseInt(src[1]);
                int counter=1;
                System.out.println(findcount(elem,tree.getRoot(),counter));
            }
        }
    }

    public static int findcount(int x, BNode<Integer> t, int counter){
        if (t == null)
            return counter;
        if (x<(t.info)) {
            return findcount(x, t.left,counter+1);
        } else if (x>(t.info)) {
            return findcount(x, t.right,counter+1);
        } else {
            return counter;
        }
    }

}
