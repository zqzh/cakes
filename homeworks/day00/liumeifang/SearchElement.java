/**
 * 使用二分查找，查找数组中的元素
 * 例：int[]{1,2,4,6,1,4,5,6,9,3}，查找3
 * 要求：考虑健壮性
 * --已完成
 *
 * 思路：先用插入排序方法排序然后再使用二分法查找元素，但是如果数组中有两个相同的3就只能找到一个，目前还没有解决这个问题
 * 本来写完了然后不小心用之前的文件覆盖了，然后在编译后的文件里面拷回来了，发现代码被优化很多：），然后就留着被优化后的代码了

*/


public class SearchElement {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 6, 1, 4, 5, 6, 9, 3};
        int[] b = sort(a);

        for(int i:b ) {
            System.out.println("排序后的数字：" + i);
        }
        int c = searchElement(b, 3);
        System.out.println("数字3在数组中的下标是：" + c);
    }

    private static int searchElement(int[] m, int n) {
        int i = -1;
        int low = 0;
        int high = m.length - 1;

        if (m.length < 1) {
            return i;
        } else if (m.length == 1) {
            return m[0] == 3 ? 1 : i;
        } else {
            while(low <= high) {
                int mid = low + (high - low) / 2;
                if (m[mid] == n) {
                    return mid;
                }

                if (m[mid] < n) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return i;
        }
    }

    private static int[] sort(int[] a) {
        for(int j = 1; j < a.length; ++j) {
            int value = a[j];

            int k;
            for(k = j - 1; k > 0 && a[k] > value; --k) {
                a[k + 1] = a[k];
            }

            a[k + 1] = value;
        }

        return a;
    }
}
