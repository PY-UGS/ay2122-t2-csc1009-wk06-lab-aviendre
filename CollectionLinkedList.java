import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CollectionLinkedList{
    public static void addAndSort(LinkedList<Integer> list, int value){
        //Checks to see if the list is empty before hand
        if(list.size() == 0){
            list.add(value);
        }
        //If the first item in the list is greater than the value, insert before
        else if(list.get(0) > value){
            list.add(0,value);
        }
        //If the item in the last index is smaller than the value, insert after
        else if(list.get(list.size() - 1) < value){
            list.add(list.size(),value);
        }
        //Traverse the array one value at a time. O(n)
        else{
            int i = 0;
            while (list.get(i) < value){
                i++;
            }
            list.add(i,value);
        }
    }

    public static void swapValues(LinkedList<Integer> list, int index1, int index2){
        int temp;
        //Normal swapping of two items around using get and set
        temp = list.get(index1);
        list.set(index1,list.get(index2));
        list.set(index2,temp);
    }

    public static LinkedList<Integer> generateList(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        int x = 0;
        while(x < 500){
            //This approach of randomizing numbers has the advantage of not needing to explicitly initialize a java.util.Random instance
            //Numbers are completely random and cant be controlled by a seed
            list.add(ThreadLocalRandom.current().nextInt(1000, 9999));
            x++;
        }
        return list;
    }

    //Traverse the array one item at a time due to it being an unsorted array. O(n)
    //Return index of search value in list or -1
    public static double findValue(LinkedList<Integer> list, int searchVal){
        int x = 0;
        while (x < list.size()-1){
            if(list.get(x) == searchVal){
                return x;
            }
            else{
                x++;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        LinkedList<Integer> myList = new LinkedList<Integer>();
        myList.add(1);
        myList.add(3);
        myList.add(5);
        myList.add(7);
        myList.add(9);
        myList.add(11);

        //Question 1
        System.out.println("List before change: " + myList);
        System.out.print("Key in a value: ");
        addAndSort(myList,input.nextInt());
        System.out.println("List after change: " + myList);

        //Question 2
        System.out.print("\nKey in index one to swap: ");
        int x = input.nextInt();
        System.out.print("Key in index two to swap: ");
        swapValues(myList, x, input.nextInt());
        System.out.println("List after swap: " + myList);

        //Question 3
        myList.clear();
        myList = generateList();
        System.out.println("\nSize of List is " + myList.size()+ "\n500 Random Integers: " + myList); 
        int searchVal = ThreadLocalRandom.current().nextInt(1000,9999);
        System.out.println("Searching for " + searchVal); 
        System.out.println("Results: " + findValue(myList,searchVal));
    }
}
