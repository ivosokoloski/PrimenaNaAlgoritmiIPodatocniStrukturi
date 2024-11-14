import java.util.NoSuchElementException;
import java.util.Stack;
//Да се провери коректноста на заградите во еден израз.
//• Еден израз има коректни загради ако:
//– За секоја лева заграда, подоцна следува соодветна десна заграда
//– За секоја десна заграда претходно постои лева заграда
//– Секој под-израз меѓу пар од две загради содржи коректен број на
//загради
//• Примери на изрази со некоректни загради:
//s(s – a)(s – b (s – c)

public class Exercise5 {
    public boolean funkcija(String str){
        ArrayStack<Character> stek=new ArrayStack<>(100);
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)=='{'||str.charAt(i)=='('||str.charAt(i)=='['){
                stek.push(str.charAt(i));
            }else if(str.charAt(i)=='}'||str.charAt(i)==')'||str.charAt(i)==']'){
                if(!stek.isEmpty()){
                    if(str.charAt(i)=='}'&&stek.peek()!='{'||str.charAt(i)==')'&&stek.peek()!='('||str.charAt(i)==']'&&stek.peek()!='['){
                        return false;
                    }
                }
            }
        }
        if(!stek.isEmpty()) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String str= "s(s – a)(s – b (s – c)";
        Exercise5 result = new Exercise5();

        System.out.println(result.funkcija(str));
    }
}

class ArrayStack<E> extends Stack<E> {
    private E[] elems; //elems[0...depth-1] se negovite elementi.
    private int depth; //depth e dlabochinata na stekot

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }

    public E peek() {
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth - 1];
    }

    public void clear() {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++) elems[i] = null;
        depth = 0;
    }

    public E push(E x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = x;
        return x;
    }

    public int size() {
        // Ja vrakja dolzinata na stack-ot.
        return depth;
    }

    public E pop() {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}
