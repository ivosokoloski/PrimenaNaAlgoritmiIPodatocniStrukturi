package HierarhiskiStrukturiDrva;
//Во следната задача треба да изградите неподредено (општо) дрво со N јазли,
// за кое ќе треба да одговорите на Q прашања од видот „колку лисја има поддрвото на избран јазол“.
// Секој јазол ќе има уникатен индекс од 1 до N. Коренот на дрвото
// секогаш ќе има индекс 1. Сите деца ќе имаат индекси поголеми од индексите на родителите.
// Влезот ќе содржи N+Q редови од видот
// root 1 - Треба да го поставите коренот на дрвото да биде јазелот со индекс 1
// add parent_index child_index - Треба да додадете дете јазел со
// индекс child_index на јазелот со индекс parent_index
// ask node_index - Треба да одговорите колку листови има во поддрвото на јазелот со индекс node_index
// Пример и структура на влезот:
// Влез
// Објаснување
// Излез
// 11 5
// root 1
// add 1 2
// add 2 3
// ask 1
// add 1 4
// add 2 5
// add 3 6
// ask 2
// add 3 7
// ask 1
// add 1 8
// add 4 9
// add 2 10
// add 4 11
// ask 2
// ask 1
// Прикажано е изгледот на дрвото при секое од 5те прашања во влезот
// прашање 1
// прашање 1: ask 1: Во поддрвото на јазелот 1 има 1 лист.
// прашање 2: ask 2: Во поддрвото на јазелот 2 има 2 листови.
// прашање 3: ask 1: Во поддрвото на јазелот 1 има 4 листови.
// прашање 4: ask 2: Во поддрвото на јазелот 2 има 4 листови
// прашање 5: ask 1: Во поддрвото на јазелот 1 има 7 листови


import HierarhiskiStrukturiDrva.HierarhiskiStrukturiDrva_PomosniStrukturi.SLLTree;
import HierarhiskiStrukturiDrva.HierarhiskiStrukturiDrva_PomosniStrukturi.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        SLLTree<Integer> tree= new SLLTree<Integer>();
        Scanner input = new Scanner(System.in);
        int m= input.nextInt();
        int M= input.nextInt();
        int n=m+M;
        input.nextLine();
        Map<Integer, Tree.Node<Integer>> map=new HashMap<>();
        for (int i=0;i<n;i++){
            String []str= input.nextLine().split(" ");
            if(str[0].equals("root")){
                int elem = Integer.parseInt(str[1]);
                tree.makeRoot(elem);
                map.put(elem,tree.root());
            }else if(str[0].equals("add")){
                int elem = Integer.parseInt(str[1]);
                Tree.Node<Integer>node;
                node= tree.addChild(map.get(elem), Integer.parseInt(str[2]));
                map.put(Integer.parseInt(str[2]),node);
            }else if (str[0].equals("ask")) {
                int elem = Integer.parseInt(str[1]);
                System.out.println(countLeaves(tree,map.get(elem)));
            }

        }


    }
    public static <E> int countLeaves(SLLTree<E> tree, Tree.Node<E> node){
        int count = 0;
        if (tree.childCount(node) == 0) {
            return 1;
        }
        for(Tree.Node<E> childNode : tree.childrenNodes(node)){
            count += countLeaves(tree, childNode);
        }
        return count;
    }

}


