class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Find pivot index
        int PI = -1;

        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                PI = i - 1;
                break;
            }
        }

        // If no pivot exists, reverse the whole array
        if (PI == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Find next greater element and swap
        for (int i = n - 1; i > PI; i--) {
            if (nums[i] > nums[PI]) {
                int temp = nums[PI];
                nums[PI] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        // Reverse all elements after pivot
        reverse(nums, PI + 1, n - 1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}