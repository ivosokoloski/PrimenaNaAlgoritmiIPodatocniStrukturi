package HierarhiskiStrukturiDrva;
//Дадено ви е бинарно пребарувачко дрво со N цели броеви.
//Напишете функција со која за бинарно пребарувачко дрво и избран елемент Т од дрвото:
//ќе најдете колку елементи во дрвото се поголеми од T
//Ќе треба да ја искористите таа функција Q пати при градењето на дрвото.
//Влезот ќе содржи N+Q редови од видот
//insert value - Треба да ја вметнете вредноста value во дрвото.
//ask value - Треба да одговорите колку елементи во дрвото имаат вредност поголема од value
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
import HierarhiskiStrukturiDrva.HierarhiskiStrukturiDrva_PomosniStrukturi.BTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int Q= input.nextInt();
        int N= input.nextInt();
        int n= N+Q;
        BTree<String> tree=new BTree<>();
        Map<String,BNode<String>> map= new HashMap<>(n);
        input.nextLine();
        for (int i=0 ;i<n;i++){
            String []str= input.nextLine().split(" ");
            if(str[0].equals("root")){
                tree.makeRoot(str[1]);
                map.put(str[1],tree.root);
            }else if(str[0].equals("add")){
                if(str[3].equals("LEFT")){
                    BNode<String> stringBNode = tree.addChild(map.get(str[1]), BNode.LEFT, str[2]);
                    map.put(str[2],stringBNode);
                }else{
                    BNode<String> stringBNode =tree.addChild(map.get(str[1]),BNode.RIGHT,str[2]);
                    map.put(str[2],stringBNode);
                }
            }else if(str[0].equals("ask")){
                System.out.println(mainFunction(map.get(str[1])));
            }

        }
    }
    public static int mainFunction(BNode<String> node) {
        int num=0;
        if(node.left!=null){
            num+=mainFunction(node.left)+1;
        }
        if(node.right!=null){
            num+=mainFunction(node.right)+1;
        }
        return num;
    }
}