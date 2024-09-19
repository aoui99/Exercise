import java.util.*;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.getAge()) {
            return 1;
        }
        if (this.age < o.getAge()) {
            return -1;
        }
        return 0;
    }
    public static void main(String[] args) {
        /*TreeMap<Person, String> pdata = new TreeMap<>();
        pdata.put(new Person("张三", 30), "zhangsan");
        pdata.put(new Person("李四", 20), "lisi");
        pdata.put(new Person("王五", 10), "wangwu");
        pdata.put(new Person("小红", 5), "xiaohong");
        // 得到key的值的同时得到key所对应的值
        Set<Person> keys = pdata.keySet();
        for (Person key : keys) {
            System.out.println(key.getAge() + "-" + key.getName());

        }*/

        /*ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println("原始数组:");
        System.out.println(arrayList);
        // void reverse(List list)：反转
        Collections.reverse(arrayList);
        System.out.println("Collections.reverse(arrayList):");
        System.out.println(arrayList);

        // void sort(List list),按自然排序的升序排序
        Collections.sort(arrayList);
        System.out.println("Collections.sort(arrayList):");
        System.out.println(arrayList);
        // 定制排序的用法
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("定制排序后：");
        System.out.println(arrayList);*/


        //创建TreeSet集合的对象
        TreeSet<String> set = new TreeSet<>();

        //添加元素
        set.add("小希");
        set.add("小空");
        set.add("小丽");
        set.add("小光");
        set.add("小亚");
        set.add("小阳");
        set.add("小张");
        set.add("xxx");
        set.add("yyy");
        set.add("zzz");

        //获取元素个数
        int size = set.size();
        System.out.println("获取元素个数：" + size);//10

        TreeSet<String> newSet1 = new TreeSet<>();
        Collections.addAll(newSet1, "aaa","bbb","ccc","ccc");//利用Collections工具类给集合做批量添加
        set.addAll(newSet1);//将newSet1中所有的元素添加到set集合的末尾

        //清空集合中所有的元素
        //set.clear();

        System.out.println("判断集合中是否包含指定元素：" + set.contains("雪儿"));//true
        System.out.println("判断集合中是否包含子集合中所有的元素：" + set.containsAll(newSet1));//true

        System.out.println("判断集合中是否没有元素：" + set.isEmpty());//false

        set.remove("小光");//根据元素删除元素
        set.removeAll(newSet1);//删除set中包含newset1的元素（去除交集）

        TreeSet<String> newSet2 = new TreeSet<>();
        Collections.addAll(newSet2, "xxx","yyy","zzz","zzz");//利用Collections工具类给集合做批量添加
        set.retainAll(newSet2);//保留set中包含newset2的元素（保留交集）

        //将集合转成数组
        Object[] objs = set.toArray();
        System.out.println(Arrays.toString(objs));

        //将集合转成数组
        String[] ss = new String[set.size()];
        set.toArray(ss);
        System.out.println(Arrays.toString(ss));

        System.out.println("--------------------------------");

        //遍历数据 -- foreach
        for (String element : set) {
            System.out.println(element);
        }

        System.out.println("--------------------------------");

        //遍历数据 -- Iterator
        Iterator<String> it = set.iterator();
        while(it.hasNext()){//判断是否有可迭代的元素

            String element = it.next();//返回下一个元素
            System.out.println(element);
        }
    }

}
