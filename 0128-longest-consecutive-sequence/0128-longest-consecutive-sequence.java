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
        ArrayList<Integer> list = new ArrayList<>();
        for (int key : set) {
            if (!set.contains(key - 1)) {
                list.add(key);
            }
        }

        int ans = 1;
        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            int longest = 1;
            while (!set.isEmpty()) {
                if (set.contains(curr + 1)) {
                    longest++;
                    curr = curr + 1;
                    set.remove(curr);
                } else {
                    break;
                }
            }
            ans = Math.max(longest, ans);
        }

        return ans;
    }
}