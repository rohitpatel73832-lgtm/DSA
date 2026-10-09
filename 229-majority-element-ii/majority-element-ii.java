class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> ans= new ArrayList<>();
        for (int ele : nums) {
            if (mp.containsKey(ele)) {
                mp.put(ele, mp.get(ele) + 1);
            } else {
                mp.put(ele, 1);
            }
        }
        for (int ele : mp.keySet()) {
            if (mp.get(ele) > n / 3) {
                ans.add(ele);
            }
        }
        return ans;

    }
}