import java.util.HashSet;

// Узел списка хранит число и ссылку на следующий узел
class ListNode {
    int val;          // число в узле
    ListNode next;    // следующий узел

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        // Здесь запоминаем узлы в которых уже были
        HashSet<ListNode> visited = new HashSet<>();

        // по списку пока не дойдём до конца
        while (head != null) {
            // Уже были в этом узле значит ходим по кругу
            if (visited.contains(head)) {
                return true;
            }
            visited.add(head);
            head = head.next;
        }

        // Дошли до конца а значит цикла нет
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаём список 3 -> 2 -> 0 -> -4
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);
        a.next = b;
        b.next = c;
        c.next = d;

        // Делаем цикл: после -4 снова идёт 2
        d.next = b;

        // Проверяем: должно вывести true
        System.out.println(new Solution().hasCycle(a));

        // Создаём список без цикла: 1 -> 2
        ListNode x = new ListNode(1);
        x.next = new ListNode(2);

        // Проверяем: должно вывести false
        System.out.println(new Solution().hasCycle(x));
    }
}
