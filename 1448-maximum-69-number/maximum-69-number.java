class Solution {
    public int maximum69Number (int num) {
        String str = String.valueOf(num);

        int[] arr = new int[str.length()];

        for(int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i]!=9){
                arr[i]=9;
                break;
            }
        }
        int ans = 0;

        for(int i = 0; i < arr.length; i++) {
            ans = ans * 10 + arr[i];
        }
        return ans;
    }
}