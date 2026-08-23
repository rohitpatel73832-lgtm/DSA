class Solution {
    public int minSwaps(String s) {
        Stack<Character> st= new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
             if(st.size() > 0 && st.peek() == '[' && ch == ']') {
                st.pop();
            } else {
                st.push(ch);
            }
            
        }
        int count=0;
        while(st.size()>0){
            if(st.peek()==']'){
                count++;
                st.pop();
            }
            else{
                st.pop();
            }
        }
        return (count+1)/2;
    }
}