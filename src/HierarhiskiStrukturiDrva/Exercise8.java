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
//        Објаснување
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
import HierarhiskiStrukturiDrva.HierarhiskiStrukturiDrva_PomosniStrukturi.BNode;
import HierarhiskiStrukturiDrva.HierarhiskiStrukturiDrva_PomosniStrukturi.BinarySearchTree;

import java.util.Scanner;

public class Exercise8{
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int Q= input.nextInt();
        int N= input.nextInt();
        int n= N+Q;
        BinarySearchTree<Integer> tree= new BinarySearchTree<>();
        input.nextLine();
        for (int i=0;i<n;i++){
            String []str= input.nextLine().split(" ");
            if(str[0].equals("insert")){
                tree.insert(Integer.parseInt(str[1]));
            }else if(str[0].equals("ask")){
                mainFunction(tree.getRoot(),Integer.parseInt(str[1]),1);
            }
        }
    }
    public static void mainFunction(BNode<Integer> node, int elem, int level){
        if (node!=null){
            if(node.info==elem){
                System.out.println(level);
            }else{
                mainFunction(node.left,elem,level+1) ;
                mainFunction(node.right,elem,level+1);
            }
        }
    }
}

