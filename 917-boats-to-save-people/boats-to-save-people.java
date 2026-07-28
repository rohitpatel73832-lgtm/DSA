class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n=people.length;
        int boat=0;
        //int minBoat=Integer.MAX_VALUE;
        Arrays.sort(people);
        int i=0; 
        int j=n-1;
        while(i<=j){
            if(people[i]+people[j]<=limit){
                i++;
            }
            boat++;
            j--;
            
        }
        return boat;
    }
}