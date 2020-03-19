package com.UtilsTest;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Map;

public class ArrayUtilsTest {

    public static void main(String[] args) {
        // 1.add():将给定的数据添加到指定的数组中，返回一个新的数组。
        int[] arr = {1, 2, 3};
        int[] newArr = ArrayUtils.add(arr, 4); // new新数组长度比旧数组大1,copy旧数组到新数组,把元素赋值到最后一位
        System.out.println(ArrayUtils.toString(newArr)); // {1,2,3,4}

        // 2.addAll():合并两个数组。
        int[] arr2 = {4, 5, 6};
        int[] newArr0 = ArrayUtils.addAll(arr, arr2);
        System.out.println(ArrayUtils.toString(newArr0)); // {1,2,3,4,5,6}

        int[] clone = ArrayUtils.clone(arr); // 调用arr.clone()
        System.out.println(ArrayUtils.toString(clone)); // {1,2,3}

        // 3.contains():检查该数据在该数组中是否存在，返回一个boolean值。
        boolean contains = ArrayUtils.contains(arr, 2); // 遍历判断相等
        System.out.println(contains); // true

        // 4.getLength():返回该数组长度。
        int length = ArrayUtils.getLength(arr); // 调用Array.getLength(arr)
        System.out.println(length); // 3

        // 5.indexOf():从数组的第一位开始查询该数组中是否有指定的数值，存在返回index的数值，否则返回-1。
        int indexOf = ArrayUtils.indexOf(arr, 2); // 遍历判断相等
        System.out.println(indexOf); // 1

        // 6.lastIndexOf():从数组的最后一位开始往前查询该数组中是否有指定的数值，存在返回index的数值，否则返回-1。
        int lastIndexOf = ArrayUtils.lastIndexOf(arr, 2); // 遍历判断相等
        System.out.println(indexOf); // 1

        // 7.Insert():向指定的位置往该数组添加指定的元素，返回一个新的数组。
        int[] newArr1 = ArrayUtils.insert(2, arr, arr2); // new新数组长度是源数组和目标数组的长度和,再把源数组和目标数组arraycopy到新数组
        System.out.println(ArrayUtils.toString(newArr1)); // {1,2,4,5,6,3}

        // 扩展 System.arraycopy()方法
        // public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
        // 其中:src表示源数组，srcPos表示源数组要复制的起始位置，desc表示目标数组，length表示要复制的长度。
        // 参考:https://blog.csdn.net/qq_32440951/article/details/78357325

        // 8.isEmpty():判断该数组是否为空，返回一个boolean值。
        boolean isEmpty = ArrayUtils.isEmpty(arr); // 调用getLength(array) == 0;
        System.out.println(isEmpty); // false

        int[] arr3 = {1, 2, 3};
        boolean isEquals = ArrayUtils.isEquals(arr, arr3); // 不推荐使用,建议使用Arrays.equals(arr, arr3)
        System.out.println(isEquals); // true
        boolean equals = Arrays.equals(arr, arr3);
        System.out.println(equals); // true

        // 9.isNotEmpty():判断该数组是否为空，而不是null。
        boolean isNotEmpty = ArrayUtils.isNotEmpty(arr);
        System.out.println(isNotEmpty); // false

        // 10.isSameLength():判断两个数组的长度是否一样，当数组为空视长度为0。返回一个boolean值。
        boolean isSameLength = ArrayUtils.isSameLength(arr, arr3); // 调用getLength(arr) == getLength(arr3)
        System.out.println(isSameLength); // true

        // 11.isSameType():判断两个数组的类型是否一样，返回一个boolean值。
        boolean isSameType = ArrayUtils.isSameType(arr, arr3); // 调用array1.getClass().getName().equals(array2.getClass().getName())
        System.out.println(isSameType); // true

        // 12.isSorted():判断该数组是否按照自然排列顺序排序，返回一个boolean值。
        boolean isSorted = ArrayUtils.isSorted(arr); // 使用Comparator实现
        System.out.println(isSorted); // true

        // 13.nullToEmpty():
        int[] nullArr = null;
        int[] nullToEmpty = ArrayUtils.nullToEmpty(nullArr); // 如果arr为null,返回new int[0]
        System.out.println(ArrayUtils.toString(nullToEmpty)); // {}

        // 14.remove():删除该数组指定位置上的元素，返回一个新的数组。
        int[] newArr2 = ArrayUtils.remove(arr, 0);
        System.out.println(ArrayUtils.toString(newArr2)); // {2,3}

        // 15.removeAll():删除指定位置上的元素，返回一个新的数组。
        int[] newArr3 = ArrayUtils.removeAll(arr, 0, 1);
        System.out.println(ArrayUtils.toString(newArr3)); // {3}

        // 16.removeAllOccurences():从该数组中删除指定的元素，返回一个新的数组。
        int[] newArr4 = ArrayUtils.removeAllOccurences(arr, 2); // 遍历使用indexOf()找出所有指定元素,在执行removeAll()
        System.out.println(ArrayUtils.toString(newArr4)); // {1,3}

        // 17.removeElement():从该数组中删除第一次出现的指定元素，返回一个新的数组。
        int[] newArr5 = ArrayUtils.removeElement(arr, 2); // 使用indexOf()找出第一次出现的指定元素,在执行remove()
        System.out.println(ArrayUtils.toString(newArr5)); // {1,3}

        // 18.removeElements():从该数组中删除指定数量的元素，返回一个新的数组。
        int[] newArr6 = ArrayUtils.removeElements(arr, 1, 2);
        System.out.println(ArrayUtils.toString(newArr6)); // {3}

        // 19.reverse():数组反转。也可以指定开始和结束的反转位置。
        ArrayUtils.reverse(arr); //  首尾对称交换
        System.out.println(ArrayUtils.toString(arr)); // {3,2,1}

        // 移位
        ArrayUtils.shift(arr, 2);
        System.out.println(ArrayUtils.toString(arr)); // {3,2,1}

        // 打乱
        ArrayUtils.shuffle(arr);
        System.out.println(ArrayUtils.toString(arr));

        // 20.subarray():截取数组（包头不包尾），返回一个新的数组
        int[] subarray = ArrayUtils.subarray(arr, 0, 2);
        System.out.println(ArrayUtils.toString(subarray)); // {1,2}

        // 21.swap():指定该数组的两个位置的元素交换或者指定两个位置后加len的长度元素进行交换。
        ArrayUtils.swap(arr, 0, 1);
        System.out.println(ArrayUtils.toString(arr)); // {2,1,3}

        // 22.toMap():将数组转换成Map,返回一个map的Object的集合。
        String[][] strArr = {{"RED", "#FF0000"}, {"GREEN", "#00FF00"}, {"BLUE", "#0000FF"}};
        Map colorMap = ArrayUtils.toMap(strArr);
        System.out.println(colorMap);

        // 23.toObject():将原始数据类型的数组转换成包装类数组。
        ArrayUtils.toObject(arr); // 遍历转换
        System.out.println(ArrayUtils.toString(arr)); // Integer类型

        // 24.toPrimitive():将包装类数组转换成原始数据类型数组。
        ArrayUtils.toPrimitive(arr);
        System.out.println(ArrayUtils.toString(arr)); // int类型

        // 25.toString():将数组输出为Stirng,返回一个字符串。
        String str = ArrayUtils.toString(arr);
        System.out.println(ArrayUtils.toString(str));

        // 26.toStringArray():将Object数组转换为String数组类型。
        String[] strArr2 = ArrayUtils.toStringArray(new Object[]{"1", "2"});
        System.out.println(ArrayUtils.toString(strArr2)); // {1,2}
    }

}
