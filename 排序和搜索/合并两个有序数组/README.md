# 合并两个有序数组

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/8/sorting-and-searching/52/

给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

* 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
* 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:
```
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
```
### 思路分析
思路跟之前有道题类似，设置2个指针分别对应2个数组，遇到数字小的把它放进一个m+n长度的临时数组中，然后对应的指针前进，大的那个指针不动，知道填充完临时数组。

### 代码展示
我的代码：
```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    if(n == 0 || nums2.length == 0 || nums1.length == 0) return;
    int[] a = new int[m+n];
    int i=0, j=0, k=0;

    while(k<a.length) {
        if(j == m) {
            a[k] = nums2[i];
            i++;
            k++;
            continue;
        }
        if(i == n) {
            a[k] = nums1[j];
            j++;
            k++;
            continue;
        }
        if(nums1[j] > nums2[i]) {
            a[k] = nums2[i];
            i++;
            k++;
            continue;
        }
        if(nums1[j] <= nums2[i]) {
            a[k] = nums1[j];
            j++;
            k++;
            continue;
        }
    }

    for(i=0; i<a.length; i++) {
        nums1[i] = a[i];
    }
}

```

