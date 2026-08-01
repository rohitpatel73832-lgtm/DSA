class Solution {
    public List<Integer> getRow(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= numRows; i++) {

            List<Integer> adj = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    adj.add(1);
                } else {
                    int a = ans.get(i - 1).get(j - 1);
                    int b = ans.get(i - 1).get(j);
                    adj.add(a + b);
                }
            }

            ans.add(adj);
        }
        return ans.get(numRows);
    }
}