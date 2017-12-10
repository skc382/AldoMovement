package shree.exp.SortingSearching;

import java.util.*;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/8/17.
 */
class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);

        System.out.println(result);

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);

            List<String> val = map.get(chars);
            if (val == null) {
                val = new ArrayList<String>();
                val.add(strs[i]);
                map.put(String.valueOf(chars), val);
            } else {
                val.add(strs[i]);
            }
        }

        List<List<String>> toReturn = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> val = entry.getValue();
            toReturn.add(val);
        }

        return toReturn;
    }
}
