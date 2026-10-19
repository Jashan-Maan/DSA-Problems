class Solution {
    // Anagrams share the same sorted string → use as HashMap key.
    // Sort each word → O(k log k) per word → group by sorted key.
    // Optimization: frequency array key avoids sort → O(k) per word.
    // "#" separator in freq key prevents "12#" vs "1#2#" collision.
    // O(n×k log k) time, O(n×k) space.
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sortedArr = new String(charArr);

            if (map.containsKey(sortedArr)) {
                map.get(sortedArr).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sortedArr, list);
            }
        }

        for (String str : map.keySet()) {
            ans.add(new ArrayList<>(map.get(str)));
        }

        return ans;
    }
}