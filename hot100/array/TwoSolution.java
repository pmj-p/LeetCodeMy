package LeetCodeMy.hot100.array;
import java.util.*;

/*
 * 字母异位词分组：重新排列源单词的所有字母得到的一个新单词
 * 
 * tag：数组、哈希表、字符串
 */

public class TwoSolution {

    /*
     * 对每个字符串进行排序，排序后的顺序一样
     */
    public List<List<String>> groupAnagrams(String[] strs) {
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
        System.out.println(result);
        return result;
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
        twoSolution.groupAnagrams(str);
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.println(str[i]);
        }
        sc.close();
    }
}
