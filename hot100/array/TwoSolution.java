package LeetCodeMy.hot100.array;
import java.util.*;

/*
 * 字母异位词分组：重新排列源单词的所有字母得到的一个新单词
 * 
 * tag：数组、哈希表、字符串
 */

public class TwoSolution {

    /*
     * 排序法：对每个字符串进行排序，排序后的顺序一样
     * 时间复杂度：O(N∗K∗Log(K))  空间复杂度：O(N∗K)
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str: strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        result = new ArrayList<List<String>>(map.values());
        // System.out.println(result);
        return result;
    } 

    /*
     * 计数法：字母异位词的两个字符串包含的字母相同，因此两个字符串中的相同字母出现的次数一定是相同的
     * 时间复杂度：O(N∗K) 空间复杂度：O(N∗K)
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str: strs) {
            int[] counts = new int[26];
            int len = str.length();
            for(int i = 0; i < len; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于0的字母和出现次数按顺序拼接成字符串，作为哈希键
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < 26; i++) {
                if(counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str[] = new String[n];
        str[0] = sc.nextLine();  // 读取下一个输入，但这里会有一个换行操作，会读取进来
        for(int i = 0; i < n; i++) {
            str[i] = sc.nextLine();
        }
        TwoSolution twoSolution = new TwoSolution();
        twoSolution.groupAnagrams2(str);
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.println(str[i]);
        }
        sc.close();
    }
}
