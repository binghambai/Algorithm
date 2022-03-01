package Lambda;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionInterfaceDemo {
    /**
     * 函数式接口，只有一个抽象方法，参数为泛型
     * @param <T>
     */
    @FunctionalInterface
    public interface Panduan<T> {
        boolean test(T t);
    }

    /**
     * 执行函数式的判断
     * @param age 年龄
     * @param panduan 函数式接口
     * @return boolean判断结果
     */
    public static boolean doPanduan(int age, Panduan<Integer> panduan) {
        return panduan.test(age);
    }

    public static void main(String [] args) {
//        System.out.println(doPanduan(17, x-> x >= 18));


        List<Person> persons = new ArrayList<Person>(){
            {
                add(new Person("wang", "ai", "python", 22, "male", 2000.0));
                add(new Person("zhang", "lin", "python", 33, "male", 9000.0));
                add(new Person("ang", "fang", "python", 30, "female", 12000.0));
                add(new Person("lin", "bai", "python", 28, "female", 19000.0));
                add(new Person("yang", "he", "python", 29, "female", 18000.0));
                add(new Person("li", "xu", "python", 25, "male", 4000.0));
                add(new Person("liu", "zhen", "python", 26, "male", 7000.0));

            }
        };

        Map<String, String > map = new HashMap<String, String>() {
            {
                put("1", "wang");
                put("2", "lan");
                put("3", "zhang");
                put("4", "han");
                put("5", "fang");
                put("6", "o");
                put("7", "li");
                put("8", "liang");
            }
        };
       List<String> list = new ArrayList<>(map.values());
        List<String> collect2 = map.values().stream().map(String::toString).filter(x -> !x.startsWith("l")).collect(Collectors.toList());
        System.out.println(collect2);
//        map.forEach((k,v) -> System.out.println(k + v));
//        map.keySet().forEach(k -> System.out.println(k + map.get(k)));
        List<String> collect = map.keySet().stream().map(String::toString).collect(Collectors.toList());
        System.out.println(collect);
        List<String> collect1 = map.keySet().stream().map(map::get).sorted(String::compareTo).limit(3).collect(Collectors.toList());
        System.out.println(collect1);
        Predicate<Person> agePredicate = (p) -> p.getAge() >= 25;
        Predicate<Person> sexPredicate = (p) -> "female".equals(p.getSex());

        persons.stream().filter(agePredicate).filter(sexPredicate).sorted(Comparator.comparingInt(Person::getAge)).map(Person::getAge).forEach(System.out::println);

        String res = persons.stream().map(Person::getFirstName).collect(Collectors.joining(";"));
        System.out.println(res);
        Set<String> set = persons.stream().map(Person::getLastName).collect(Collectors.toSet());
        System.out.println(set);

        double sum = persons.parallelStream().mapToDouble(Person::getSalary).sum();

        List<String> testList = new ArrayList<>(Arrays.asList("aa","bb"));
        System.out.println(testList);

        DoubleSummaryStatistics statistics = persons.parallelStream().mapToDouble(Person::getSalary).summaryStatistics();
        System.out.println(statistics.getMax());
        double average = statistics.getAverage();
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        System.out.println(decimalFormat.format(average));
        System.out.println(statistics.getSum());
        System.out.println(sum);


        Deque<String> queue = new LinkedList<String>();
        queue.push("a");
        queue.push("b");
        queue.push("c");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        List<String> list1 = new ArrayList<>(Arrays.asList("a","b", "c"));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        Collections.sort(list1, (a,b)->a.compareTo(b));
        list2.sort((a, b) -> b.compareTo(a));

        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(4);
        list3.add(5);
        list3.add(7);

        System.out.println(list3);
        Collections.rotate(list3, 2);
        System.out.println(list3);
    }
}
