class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> st1=new Stack<>();
        Stack<Character> st2=new Stack<>();
        int n=s.length();

        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            if(st2.size()==0 && ch==')'){
                continue;
            }

            else if(ch==')' && st2.peek()=='('){
                st1.push(ch);
                st2.pop();
            }

            else if(ch=='('){
                st1.push(ch);
                st2.push(ch);
            }else{
                st1.push(ch);
            }
            
        }

        Stack<Character> st3 = new Stack<>();

        while (st1.size() > 0) {
            char ch = st1.pop();

            if (ch == '(' && st2.size() > 0) {
                st2.pop();
            }
            else {
                st3.push(ch);
            }
        }

        //StringBuilder sb= new StringBuilder("");
        // if(st1.size()==st2.size()) return new StringBuilder("").toString();
        // while(st1.size()>0){
        //     sb.append(st1.pop());
        // }
        // return sb.reverse().toString();

        StringBuilder sb = new StringBuilder();

        while (st3.size() > 0) {
            sb.append(st3.pop());
        }

        return sb.toString();
    }
}