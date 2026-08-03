class Solution {
    public void helper(int index, String digits,HashMap<Character, String> map, StringBuilder s,List<String> ans) {

        // Base Case
        if (s.length() == digits.length()) {
            ans.add(s.toString());
            return;
        }
        //choices
        char c=digits.charAt(index);
        String choices=map.get(c);
        for(char ch:choices.toCharArray()){
            s.append(ch);
            helper(index+1,digits,map,s,ans);
            s.deleteCharAt(s.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0)
            return ans;

        HashMap<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        helper(0, digits, map, new StringBuilder(), ans);

        return ans;
    }
}