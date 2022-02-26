import java.security.KeyStore.Entry;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CollectionHashTable {

    //Iterate through the hashtable to print out the data
    public static void printHashtable(Hashtable<Integer,Integer> hash) {
        for (int i=0;i<hash.size();i++){
            System.out.print(hash.get(i) + " ");
        }
        System.out.println();
    }

    //Uses the list sort function to add a value and re-iterate into the hashtable
    public static void addAndSort(Hashtable<Integer, Integer> hash, int value){
        hash.put(hash.size(),value);
        LinkedList<Integer> list = new LinkedList<Integer>(hash.values());
        list.sort(null);
        for(int i = 0; i < list.size(); i++){
            hash.put(i,list.get(i));
        }
    }

    //Swaps the hashtable values base on key
    public static void swapValue(Hashtable<Integer, Integer> hash, int index1, int index2){
        int val1 = hash.get(index1), val2 = hash.get(index2);
        if(val1 == val2){
            return;
        }
        hash.put(index1,val2);
        hash.put(index2,val1);
    }

    //Randomises 500 different value and one search value to find the key based on the data
    public static int findIndexHash(Hashtable<Integer,Integer> hash){
        int x = 0;
        while(x < 500){
            hash.put(x,ThreadLocalRandom.current().nextInt(1000, 9999));
            x++;
        }
        int checkVal = ThreadLocalRandom.current().nextInt(1000, 9999);
        System.out.println("Current Hashtable: ");
        printHashtable(hash);
        System.out.println("Searching for: " + checkVal);
        for(Map.Entry<Integer,Integer> entry: hash.entrySet()){
            if(checkVal == entry.getValue()){
                return entry.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args){
        Hashtable<Integer, Integer>myHashtable = new Hashtable<Integer,Integer>();
        myHashtable.put(0,1);
        myHashtable.put(1,3);
        myHashtable.put(2,5);
        myHashtable.put(3,7);
        myHashtable.put(4,9);
        myHashtable.put(5,11);
        Scanner reader = new Scanner(System.in);

        //Question 4
        System.out.print("Hashmap before change: ");
        printHashtable(myHashtable);
        System.out.print("Please add a number to add: ");
        addAndSort(myHashtable,reader.nextInt());
        System.out.print("Hashmap after change: ");
        printHashtable(myHashtable);

        //Question 5
        System.out.print("Please add index one to swap: ");
        int temp = reader.nextInt();
        System.out.print("Please add index two to swap: ");
        swapValue(myHashtable, temp, reader.nextInt());
        System.out.print("Hashmap after change: ");
        printHashtable(myHashtable);

        //Question 6
        System.out.println("Index: " + findIndexHash(myHashtable));
    }
}
