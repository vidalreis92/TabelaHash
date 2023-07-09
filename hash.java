public class HashTable {

    private BinarySearchTree<?> buckets[];

    public HashTable() {
        this.buckets = new BinarySearchTree<?>[3];
        for (int i = 0; i < this.buckets.length; i++) {
            this.buckets[i] = new BinarySearchTree<Pair>();
        }
    }

    private int hashFunction(int key) {
        return key % this.buckets.length;
    }

    public void put(int key, String value) {
        int bucketIndex = this.hashFunction(key);
        BinarySearchTree<Pair> bucket = this.buckets[bucketIndex];
        Pair pair = new Pair(key, value);
        bucket.insert(pair);
    }

    public String get(int key) {
        int bucketIndex = this.hashFunction(key);
        BinarySearchTree<Pair> bucket = this.buckets[bucketIndex];
        Pair pair = new Pair(key, null);
        Pair result = bucket.find(pair);
        if (result != null) {
            return result.getValue();
        }
        return null;
    }

    @Override
    public String toString() {
        String output = "{\n";
        for (int i = 0; i < this.buckets.length; i++) {
            output += "\t" + this.buckets[i].toString() + "\n";
        }
        return output + "}";
    }

    public static void main(String[] args) {

        HashTable hashTable = new HashTable();
        System.out.println(hashTable.toString());
        hashTable.put(0, "a");
        System.out.println(hashTable.toString());
        hashTable.put(1, "b");
        System.out.println(hashTable.toString());
        hashTable.put(2, "c");
        System.out.println(hashTable.toString());
        hashTable.put(3, "d");
        System.out.println(hashTable.toString());
        hashTable.put(4, "e");
        System.out.println(hashTable.toString());
        hashTable.put(5, "f");
        System.out.println(hashTable.toString());

        System.out.println(hashTable.get(2));
        System.out.println(hashTable.get(10));
    }
}
