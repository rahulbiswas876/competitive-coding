/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeapPriorityQueue;

/**
 *
 * @author Naveen
 */
 class PriorityQueue {
    private static final int UNDEFINED = -5;
    
    private int[] elements;
    private int queueLength = 0;
    
    public PriorityQueue(int maxCapacity){
        //we are implementing priority queue with 1 indexing . therefore it size is maxCapacity + 1.
        this.elements = new int[maxCapacity + 1];
    }
    
    public boolean isFull(){
        if(queueLength == elements.length -1)
            return true;
        return false;
    }
    
    //insert new value to priorityqueue
    public void insertElement(int value) throws Exception{
        if(isFull()){
            throw new Exception("Queue is full");
        }
        
        int insertAt = queueLength + 1;
        queueLength += 1;
        elements[insertAt] = UNDEFINED;
        increaseElementValue(insertAt , value);
    }
    
    //this method set the existing element at given index to give value
    public void increaseElementValue (int index , int value)throws Exception{
        if(elements[index] > value){
            throw new Exception("Value at specified index is greater than given value");
        }
        
        elements[index] = value;
        
        while(index > 1 && elements[index/2] < elements[index]){
            //swap [index/2] and [index]
            int temp = elements[index/2];
            elements[index/2] = elements[index];
            elements[index] = temp;
            index = index / 2;
        }
    }
    
    public int maximum() throws Exception{
        if(queueLength == 0){
            throw new Exception("Queue is empty");
        }
        
        return elements[1];
    }
    
    
}
