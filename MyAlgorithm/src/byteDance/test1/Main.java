package byteDance.test1;

import com.sun.deploy.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final String AIM_PRE = "type=aim&aim=";

    public static void main(String[] args){
//        List<String> as = new ArrayList<>();
//        as.add("11");
//        as.add("22");
//        as.add("33");
//        System.out.println(Arrays.toString(as.toArray(new String[0])));
//        String str = "3米,3米,DP4线【8K】,DP4线【8K】";
//        Set<String> set = new HashSet<>(Arrays.asList(str.split(",")));

//        String res = StringUtils.join(Arrays.asList(set.toArray()), ",");
//        System.out.println(StringUtils.join(set, ","));
//        Scanner sc = new Scanner(System.in);
//        List<String> input = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            input.add(sc.nextLine());
//        }
//        System.out.println(func(input.get(0), input.get(1)));
//        LocalDate parse = LocalDate.parse("2022-09-09");
//        System.out.println(parse);
//        BigDecimal sixty = new BigDecimal(60).setScale(2, RoundingMode.HALF_UP);
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime of = LocalDateTime.of(2022, 9, 8, 10, 9, 40);
//        Duration between = Duration.between(now, of);
//        System.out.println(between.getSeconds());
//        BigDecimal divide = new BigDecimal(between.getSeconds()).setScale(2,RoundingMode.HALF_UP);
//        BigDecimal res = divide.divide(sixty, RoundingMode.HALF_UP).divide(sixty, RoundingMode.HALF_UP);
//        System.out.println(res);
        BigDecimal divide = new BigDecimal(3).multiply(new BigDecimal("100")).divide(new BigDecimal(2), 2, RoundingMode.HALF_UP);
        if (divide.compareTo(new BigDecimal("100.00")) > 0) {
            divide = new BigDecimal("100");
        }
        System.out.println(divide);
    }

    public String func(String param1, String param2) {
        if (param2 == null || param2.isEmpty()) {
            return param1;
        }
        List<String> collect = Arrays.stream(param1.split(" ")).map(String::toLowerCase).collect(Collectors.toList());
        List<String> collect1 = Arrays.stream(param2.split(" ")).map(String::toLowerCase).collect(Collectors.toList());
        Map<String, Integer> dist = new HashMap<>();
        collect1.forEach(i -> {
            if (!dist.containsKey(i)) {
                dist.put(i, collect1.indexOf(i));
            } else {
                dist.put(i, dist.get(i) + 1);
            }
        });
        StringBuilder res = new StringBuilder();
        collect.forEach(i -> {
            if (dist.containsKey(i)) {
                res.append(dist.get(i));
            } else {
                res.append(i);
            }
            res.append(" ");
        });
        return res.toString();
    }

    private static String test1(String params) {
        params = params + "1111";
        return "ok";
    }

    private static boolean test(boolean a) {
        a = true;
        return a;
    }


    /**
     *
     * 数组中都是1-9的数字，返回由数组中的元素组成的小于target的最大数
     * 如 array = {1,2,4,5,6}  target = 9
     * 组成满足条件的组合有：{1,2,4} {1,2,5} {1,4} {1,5} {1,6} {2,4} {2,5} {2,6} 最大长度是3
     *
     * @param array 输入数组
     * @param target 输入的目标值
     * @return 返回一个最大值
     */
    public static int getMaxLengthFromArray(int [] array, int target) {
        int i = 0, j = 1;
        int max = 0, len = 0;
        int length = array.length;
        for (; i < length; i++) {
            if (array[i] + array[j] < target) {
                len += 2;
            }
        }


        return  0;
    }

    /**
     * 求和为target的所有组合 DFS递归+剪枝
     *
     * @param candidates 输入数组
     * @param target 目标数
     * @return 返回集合
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;

        Arrays.sort(candidates);

        dfs(candidates, 0, target, new LinkedList<>(), ans);
        return null;
    }

    private static void dfs(int[] candidates, int index, int rest, LinkedList<Integer> path, List<List<Integer>> ans) {
        //找到了答案
        if (rest == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        //中途发现rest < 0直接剪枝

    }
}

