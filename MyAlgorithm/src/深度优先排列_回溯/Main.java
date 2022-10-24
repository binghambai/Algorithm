package 深度优先排列_回溯;

import 深度优先排列_回溯.全排列.QuanPailie;
import 深度优先排列_回溯.全排列2.QuanPailie2;
import 深度优先排列_回溯.组合总和.ZuHeZongHe;
import 深度优先排列_回溯.组合总和2.ZuHeZongHe2;

public class Main {
    public static void main(String[] args) {
        //全排列
        int [] nums = new int[]{1,2,3};
        QuanPailie quanPailie = new QuanPailie();
        System.out.println(quanPailie.all(nums));
        //深度优先排列_回溯.全排列2  需要去重展示所有排列
        int [] nums2 = new int[]{1,1,2};
        QuanPailie2 quanPailie2 = new QuanPailie2();
        System.out.println(quanPailie2.fullPermutation2(nums2));

        //组合总和
        int [] candidates = new int[]{2,3,6,7};
        ZuHeZongHe zuHeZongHe = new ZuHeZongHe();
        System.out.println(zuHeZongHe.candidates(candidates, 7));

        //组合总和2
        //1,1,2,5,6,7,10
        int [] candidates2 = new int[]{1,2,2,2,5};
        int target = 5;
        ZuHeZongHe2 zuHeZongHe2 = new ZuHeZongHe2();
        System.out.println(zuHeZongHe2.candidates(candidates2, target));
        System.out.println(zuHeZongHe2.candidates2(candidates2, target));
    }
}
