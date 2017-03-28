/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Naveen
 */
public class SortSingleLoop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] nums = new int[]{5,4,1,10,20,30};
        for (int i = 0; i < nums.length; i++) {
            int minNumIndex = findMin(i, nums.length-1, nums);
            swap(i, minNumIndex, nums);
        }
        
        for(int num: nums)
        System.out.println(num);
    }
        
    public static int findMin(int index, int last, int [] nums){
        //int uptoMin;
        if(index == last)
            return index;
        else{
            int childindex = findMin(index+1, last, nums);
            return nums[childindex] < nums[index]? childindex : index;
        }
    }
    
    public static void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
