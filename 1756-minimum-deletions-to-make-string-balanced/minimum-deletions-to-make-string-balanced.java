class Solution {
    public int minimumDeletions(String s) {

        // int b = 0;
        // int count = 0;

        // for (int i = 0; i < s.length(); i++) {

        //     char ch = s.charAt(i);

        //     if (ch == 'b') {
        //         b++;
        //     }
        //     else {
        //         if (b > 0) {
        //             count++;
        //             b--;
        //         }
        //     }
        // }

        //return count;



        //2nd approach

        Stack<Character> st= new Stack<>();
        int n=s.length();
        int count=0;
        for(int i=0; i<n;  i++){
            char ch=s.charAt(i);
            if(st.size()==0){
                st.push(ch);
            }
             else if(st.peek()=='b' && ch=='a'){
                count++;
                st.pop();
            }else{
                st.push(ch);
            }
        }
        return count;
    }
}