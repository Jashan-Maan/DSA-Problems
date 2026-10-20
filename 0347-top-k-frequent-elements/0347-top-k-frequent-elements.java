class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       int[] ans = new int[k];

        // Count frequceny of each the element of arr.
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            if (freq.containsKey(n)) {
                freq.put(n, freq.get(n) + 1);
            } else {
                freq.put(n, 1);
            }
        }

        // now we have to sort the top K highest frequency count element from the map. we have to
        // option to do:- 1. Using Heap (PQ) OR 2. Greedy Algo (Matrix Sorting stuff)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] > b[1]) {
                return -1;
            } else {
                return +1;
            }
        });

        // Adding element to PQ
        for (int key : freq.keySet()) {
            pq.add(new int[] {key, freq.get(key)});
        }

        // Removing element from PQ
        int i = 0;
        while (k > 0) {
            int[] elem = pq.remove();
            ans[i] = elem[0];
            i++;
            k--;
        }
        return ans;
    }
}