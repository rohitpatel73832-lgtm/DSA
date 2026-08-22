class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] parts = path.split("/");
        for(String s:parts){
            if(s.equals("")|| s.equals(".")){
                continue;
            }else if(s.equals("..")){
                if(st.size()>0){
                    st.pop();
                }
            }else{
                st.push(s);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(st.size()>0){
            ans.insert(0, "/" + st.pop());
        }
        if (ans.length()==0) return "/";
        else return ans.toString();
    }
}