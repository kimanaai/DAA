// Узел списка хранит число и ссылку на следующий узел
class ListNode {
    int val;          // число в узле
    ListNode next;    // следующий узел

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Пустой узел-заглушка к нему будем цеплять ответ
        ListNode dummy = new ListNode(0);
        // tail всегда стоит на последнем узле ответа
        ListNode tail = dummy;

        // Пока в обоих списках есть числа
        while (list1 != null && list2 != null) {
            // Сравниваем числа и берём меньшее
            if (list1.val <= list2.val) {
                tail.next = list1;    // добавляем узел из list1
                list1 = list1.next;   // в list1 идём дальше
            } else {
                tail.next = list2;    // добавляем узел из list2
                list2 = list2.next;   // в list2 идём дальше
            }
            tail = tail.next;         // сдвигаем конец ответа
        }

        // Один список закончился ид добавляем остаток другого
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // Ответ начинается после заглушки
        return dummy.next;
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаём первый список 1 - 2 - 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // Создаём второй список 1 -3 - 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // Соединяем списки
        ListNode result = new Solution().mergeTwoLists(list1, list2);


        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
