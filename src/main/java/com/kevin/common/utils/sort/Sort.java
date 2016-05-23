package com.kevin.common.utils.sort;

public class Sort {
    
    private static int count = 0;

    public static void main(String[] args) {

        int a[] = { 12, 56, 95, 35, 88, 102, 89, 63, 154 };
//        String sa = mpSort(a);
//        System.out.println("数组A的排序结果是：" + sa);

        int b[] = { 32, 55, 175, 75, 82, 111, 26, 159 };
        String sb = ksSort(b);
        System.out.println("数组B的排序结果是：" + sb);
        System.out.println(count);

        int c[] = { 137, 555, 186, 45, 92, 150, 48, 360 };
//        String sc = crSort(c);
//        System.out.println("数组C的排序结果是：" + sc);
    }

    // 不排序
    public static String noSort(int arr[]) {
        String s = " ";
        for (int i = 0; i < arr.length; i++) {
            s = s + arr[i] + " ";
        }
        return s;
    }

    // 冒泡排序
    public static String mpSort(int arr[]) {
        String s = " ";
        int temp; // temp 为交换时的暂存数据
        boolean move; // move 判断是否有过交换
        for (int i = 1; i < arr.length; i++) // i 表示趟数，共arr.length-1趟
        {
            move = false;
            for (int j = arr.length - 1; j >= i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    move = true;
                }
            }
            if (!move) break;
        }
        for (int i = 0; i < arr.length; i++) {
            s = s + arr[i] + " ";
        }
        return s;
    }

    // 快速排序
    public static String ksSort(int arr[]) {
        String s = " ";
        quicksort(arr, 0, arr.length - 1); // 初始以arr[0]为最低位，arr[arr.length-1]为最高位
        for (int i = 0; i < arr.length; i++) {
            s = s + arr[i] + " ";
        }
        return s;
    }

    // 快速排序的分区算法，返回基准数据的下标
    private static int partition(int arr[], int low, int high) {
        int key = arr[low]; // 基准值赋给岗哨
        while (low < high) {
            if (low < high && arr[high] >= key) high--;
            arr[low] = arr[high]; count++;
            if (low < high && arr[low] <= key) low++;
            arr[high] = arr[low]; count++;
        }
        arr[low] = key; // 空位填上基准值
        count++;
        return low;
    }
    
    private static int newPartition(int arr[], int low, int high) {
        int key = arr[low]; // 基准值赋给岗哨
        int tmp;
        while (low < high) {
            while (low < high && arr[high] >= key) high--;
            if (low < high) {
                tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
                count+=2;
            }
            while (low < high && arr[low] <= key) low++;
            if (low < high) {
                tmp = arr[high];
                arr[high] = arr[low];
                arr[low] = tmp;
                count+=2;
            }
        }
        return low;
    }

    // 真正的快速排序：一种递归算法
    private static void quicksort(int arr[], int low, int high) {
        if (low < high) {
            int result = newPartition(arr, low, high);
            quicksort(arr, low, result - 1);
            quicksort(arr, result + 1, high);
        }
    }

    // 插入排序
    public static String crSort(int arr[]) {
        String s = " ";
        int key; // key 表示岗哨，记录新增的数据
        for (int i = 2; i <= arr.length; i++) // i 表示有序区长度，从2开始递增，直到arr.length结束
        {
            if (arr[i - 1] < arr[i - 2]) // 新增数据小于上一轮有序区最后一位
            {
                key = arr[i - 1];
                for (int j = i - 2; j >= 0; j--) {
                    if (j > 0) {
                        if (arr[j] > key) {
                            arr[j + 1] = arr[j]; // 大于新增数据，则后移一位
                        } else {
                            arr[j + 1] = key; // 小于等于新增数据，则空位填上新增数据
                            break;
                        }
                    } else // 如果新增数据一直比较到arr[0]，需要特殊处理
                    {
                        if (arr[0] > key) {
                            arr[1] = arr[0];
                            arr[0] = key;
                        } else arr[1] = key;
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            s = s + arr[i] + " ";
        }
        return s;
    }
}
