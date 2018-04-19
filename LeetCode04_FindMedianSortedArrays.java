package leetcode;

public class LeetCode04_FindMedianSortedArrays {
    //寻找两个排序数组的中位数
    public static void main(String[] args) {
        LeetCode04_FindMedianSortedArrays leetCode04 = new LeetCode04_FindMedianSortedArrays();
        double median = leetCode04.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(median);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //nums1的长度
        int n1=nums1.length;
        //nums2的长度
        int n2=nums2.length;
        //以长度最小的数组进行二分查找，这样可以减少查找的次数
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        //第一个切点的位置,第一个数组左边有多少个元素
        int cut1=0;
        //第二个切点的位置,第二个数组左边有多少个元素
        int cut2=0;
        //第一个切点的浮动范围(0-n1),cutL表示左边范围，cutR表示右边范围,便于二分查找
        int cutL=0;
        int cutR=n1;
        //总数组的长度
        int len=n1+n2;
        while (cutL <= cutR) {
            cut1=(cutR-cutL)/2+cutL;
            cut2=len/2-cut1;
            //nums1中切点的左边的数
            int L1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            //nums1中切点的右边的数
            int R1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            //nums2中切点的左边的数
            int L2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            //nums2中切点的右边的数
            int R2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2) {
                cutR = cut1 - 1;
            } else if (L2 > R1) {
                cutL = cut1 + 1;
            }else{
                if (len % 2 == 0) {
                    int l = L1 > L2 ? L1 : L2;
                    int r = R1 < R2 ? R1 : R2;
                    double k = (double)(l + r) / 2;
                    return k;
                }else{
                    return R1 < R2 ? R1 : R2;
                }
            }
        }
        return -1;
    }
}
