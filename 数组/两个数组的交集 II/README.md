# 两个数组的交集 II

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/26/

给定两个数组，编写一个函数来计算它们的交集。

示例 1:
```
输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
```
示例 2:
```
输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
```
说明：

* 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
* 我们可以不考虑输出结果的顺序。

进阶:

* 如果给定的数组已经排好序呢？你将如何优化你的算法？
* 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
* 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

### 思路分析
先不看进阶的内容，单单原题我想了一个借助 Hashmap 的方案，先统计长度较长的数组的数字频率：
```
例如 [1,2,2,1]
map.get(1) == 2
map.get(2) == 2
```
然后遍历小的数组判断值是否存在于map中，如果存在且值大于0，则取出来放在list里，然后map中值-1，相当于拿走了一个。
虽然代码是遍历了2个数组，复杂度是 O(N)，但是看了提交结果还是不理想，速度偏慢。
现在回头看到进阶的内容，其实已经有提示了一点，就是排序的问题，如果2个数组都是排序好的，那我们可以通过2个指针的方式去解决。设定2个指针分别开始遍历2个数组，如果当前a指针索引对应的值大于b指针对应的值，那么b前进，反之a前进，相等的话就塞入list。


### 代码展示
我的代码：
```java
public int[] intersect(int[] nums1, int[] nums2) {
    java.util.List<Integer> result = new java.util.ArrayList<>();
    java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
    int i = 0;
    if(nums1.length > nums2.length) {
        int[] tmp = nums1;
        nums1 = nums2;
        nums2 = tmp;
    }
    for(; i<nums2.length; i++) {
        int value = 1;
        if(map.containsKey(nums2[i])) {
            value = map.get(nums2[i]) + 1;
        }
        map.put(nums2[i], value);
    }
    for(i=0; i<nums1.length; i++) {
        if(map.containsKey(nums1[i]) && map.get(nums1[i]) > 0) {
            result.add(nums1[i]);
            map.put(nums1[i], map.get(nums1[i]) - 1);
        }
    }
    
    return result.stream().mapToInt(j->j).toArray();
}
```
双指针方法：
```java
public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    List<Integer> tmp = new ArrayList<>();
    int i = 0;
    int j = 0;

    while (i < nums1.length && j < nums2.length) {
        if (nums2[j] > nums1[i]) {
            i++;
        } else if (nums2[j] < nums1[i]) {
            j++;
        } else {
            tmp.add(nums1[i]);
            i++;
            j++;
        }
    }
    
    return tmp.stream().mapToInt(j->j).toArray();
}
```
