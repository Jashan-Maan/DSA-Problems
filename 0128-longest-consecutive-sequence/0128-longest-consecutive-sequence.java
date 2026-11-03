class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        //    HashSet approach
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }
            set.add(num);
        }

        // Find start of sequence array
        int ans = 1;

        for (int key : set) {
            if (!set.contains(key - 1)) {
                int curr = key;
                int longest = 1;
                while (set.contains(curr + 1)) {
                    longest++;
                    curr = curr + 1;
                }
                ans = Math.max(longest, ans);
            }
        }

        return ans;
    }
}