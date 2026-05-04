public class B3 {

    static int SIZE = 7; // hash table size
    static Integer[] table = new Integer[SIZE];

    // hash function
    public static int hash(int key) {
        return key % SIZE;
    }

    // insert using linear probing
    public static void insert(int key) {

        int index = hash(key);
        int start = index; // 防止死循环

        // 找空位
        while (table[index] != null) {
            index = (index + 1) % SIZE;

            // 如果回到原点，说明满了
            if (index == start) {
                System.out.println("Cannot insert " + key + " (table full)");
                return;
            }
        }

        table[index] = key;
        System.out.println("Inserted " + key + " at index " + index);
    }

    // print table
    public static void printTable() {
        System.out.println("\nFinal Hash Table:");
        for (int i = 0; i < SIZE; i++) {
            System.out.println(i + " -> " + table[i]);
        }
    }

    public static void main(String[] args) {

        int[] data = {67, 25, 95, 40, 71, 88, 55, 82, 29, 60};

        for (int num : data) {
            insert(num);
        }

        printTable();
    }
}
