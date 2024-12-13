//Во следната задача треба да изградите бинарно дрво со N јазли,
//за кое ќе треба да одговорите на Q прашања од видот „колку внатрешни јазли има во поддрвото на избран јазол“.
//Секој јазол ќе има уникатно име. Името на коренот на дрвото секогаш ќе ви биде дадено прво.
//Влезот ќе содржи N+Q редови од видот
//root ime - Треба да го поставите коренот на дрвото да биде јазелот со име ime
//add parent_name child_name - Треба да додадете дете јазел со име child_name на јазелот со име parent_name
//ask node_name - Треба да го одговориме прашањето за поддрвото на јазелот со име node_name
//Пример и структура на влезот:
//Влез
//Објаснување
//Излез
//11 9
//root bravo
//add bravo echo LEFT
//add echo beard LEFT
//ask beard
//ask bravo
//add bravo foxtrot RIGHT
//add beard hotel LEFT
//add beard india RIGHT
//ask echo
//add foxtrot golf LEFT
//add golf juliet RIGHT
//add india sierra RIGHT
//ask foxtrot
//ask bravo
//ask beard
//add echo mike RIGHT
//add foxtrot tango RIGHT
//ask echo
//ask bravo
//ask foxtrot
//Прикажано е изгледот на дрвото при секоја од 4те групи прашања во влезот
//0
//2
//2
//2
//6
//2
//3
//6
//2

package HierarhiskiStrukturiDrva;
import HierarhiskiStrukturiDrva.HierarhiskiStrukturiDrva_PomosniStrukturi.BNode;
import HierarhiskiStrukturiDrva.HierarhiskiStrukturiDrva_PomosniStrukturi.BTree;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int N=input.nextInt();
        int Q=input.nextInt();
        int n=N+Q;
        input.nextLine();
        BTree<String> tree= new BTree<>();
        Map<String, BNode<String>>map= new HashMap<>();
        for (int i=0;i<n;i++){
            String []str=input.nextLine().split(" ");
            if(str[0].equals("root")){
                tree.makeRoot(str[1]);
                map.put(str[1],tree.root);
            }else if(str[0].equals("add")){
                if(str[3].equals("LEFT")){
                    BNode<String> node = tree.addChild(map.get(str[1]), BNode.LEFT, str[2]);
                    map.put(str[2],node);
                }else{
                    BNode<String> node = tree.addChild(map.get(str[1]), BNode.RIGHT, str[2]);
                    map.put(str[2],node);
                }
            }else if (str[0].equals("ask")) {

                BNode<String> stringBNode = map.get(str[1]);
                System.out.println(myask(stringBNode));

            }
        }
    }

    private static int myask(BNode<String> node) {
        if (node == null) {
            return 0;
        }
        if ((node.left == null)&&(node.right == null)) {
            return 0;
        }
        return 1 + myask(node.left)+ myask(node.right);
    }
}

