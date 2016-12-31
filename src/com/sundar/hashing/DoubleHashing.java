package com.sundar.hashing;

import java.util.Scanner;

class HashEntry{
	int key;
	String name;
	
	public HashEntry(int key, String name){
		this.key = key;
		this.name = name;
	}
}

class HashTable
{
    
	private int TABLE_SIZE;
    private int size; 
    private HashEntry[] table;
    private int primeSize;
	public HashTable(int tABLE_SIZE) {
		super();
		size = 0;
		TABLE_SIZE = tABLE_SIZE;
		table = new HashEntry[tABLE_SIZE];
		for(int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
		primeSize = getPrime();
	}
 
    public int getPrime(){
    	int flag,m;
    	for(int i = TABLE_SIZE - 1 ; i <= 2; i++){
			flag = 0;
			m = i/2;
			for(int j = 2; j <= m; j++){
				if(i % j == 0){
					/*The no i has been divided by j so its not a prime no */
					flag = 1;
					break;
				}
			}
			
			if(flag == 0){
				return i;
			}
			
		}
    	return 3;
    }
    
    public int getSize()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public int myHash1(int key){
    	int hash = key;
    	hash %= TABLE_SIZE;
    	if (hash < 0)
            hash += TABLE_SIZE;
    	return hash;
    }
    
    public int myHash2(int key){
    	/*int hash = key;
    	hash %= TABLE_SIZE;
    	if (hash < 0)
            hash += TABLE_SIZE;*/
    	return primeSize - (key % primeSize);
    }
    
    public void insert(int key, String name){
    	
    	if (size == TABLE_SIZE)
        {
            System.out.println("Table full"); 
            return;
        }   
    	
    	int hash1 = myHash1(key);
    	int hash2 = myHash2(key);
    	
    	while(table[hash1] != null){
    		hash1 += hash2;
    		hash1 %= TABLE_SIZE;
    	}
    	table[hash1] = new HashEntry(key, name);
    	size ++;
    }
    
    public void makeEmpty()
    {
        size = 0;
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }
    
    public String get(int key){
    	
    	int hash1 = myHash1(key);
    	int hash2 = myHash2(key);
    	
    	if(table[hash1].key == key ){
    		if(table[hash1] != null)
    			return table[hash1].name;
    		return "This key doesn't have a name";
    	}else{
    		
    		while(table[hash1].key != key){
    			hash1 += hash2;
        		hash1 %= TABLE_SIZE;
      		}
    		if(table[hash1] != null)
    			return table[hash1].name;
    		return "This key doesn't have a name";
    		
    	}
    	
    }
    
    public void remove(int key) 
    {
    	int hash1 = myHash1(key);
    	int hash2 = myHash2(key);      
        while (table[hash1] != null && table[hash1].key != key)
        {
            hash1 += hash2;
            hash1 %= TABLE_SIZE;
        }
        table[hash1] = null;
        size--;
    }
    
    /* Function to print hash table */
    public void printHashTable()
    {
        System.out.println("\nHash Table");
        for (int i = 0; i < TABLE_SIZE; i++)
            if (table[i] != null)
                System.out.println(table[i].key +" "+table[i].name);
    }
}

public class DoubleHashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size");
        /* Make object of HashTable */
        HashTable ht = new HashTable(scan.nextInt() );
 
        char ch;
        /*  Perform HashTable operations  */
        do    
        {
            System.out.println("\nHash Table Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. remove");
            System.out.println("3. get");       
            System.out.println("4. check empty");     
            System.out.println("5. clear");
            System.out.println("6. size");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter key and value");
                ht.insert(scan.nextInt(), scan.next() ); 
                break;                          
            case 2 :                 
                System.out.println("Enter key");
                ht.remove( scan.nextInt() ); 
                break;                        
            case 3 : 
                System.out.println("Enter key");
                System.out.println("Value = "+ ht.get( scan.nextInt() )); 
                break;                                   
            case 4 : 
                System.out.println("Empty Status " +ht.isEmpty());
                break;
            case 5 : 
                ht.makeEmpty();
                System.out.println("Hash Table Cleared\n");
                break;
            case 6 : 
                System.out.println("Size = "+ ht.getSize() );
                break;         
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /* Display hash table */
            ht.printHashTable();  
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  

	}

}
