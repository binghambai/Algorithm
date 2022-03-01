package String;

public class StringTest {
    public static void main(String[] args) {

        long t1 = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 40000; i++) {
            str += i;
        }
        System.out.println("string耗时:" + (System.currentTimeMillis() - t1));

        long t2 = System.currentTimeMillis();
        StringBuffer str2 = new StringBuffer();
        for (int i = 0; i < 40000; i++) {
            str2.append(i);
        }
        System.out.println("stringBuffer耗时:" + (System.currentTimeMillis() - t2));

        long t3 = System.currentTimeMillis();
        StringBuilder str3 = new StringBuilder();
        for (int i = 0; i < 40000; i++) {
            str3.append(i);
        }
        System.out.println("stringBuilder耗时:" + (System.currentTimeMillis() - t3));

    }
}
