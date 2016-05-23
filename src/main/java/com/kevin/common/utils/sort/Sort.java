package com.kevin.common.utils.sort;

public class Sort {
    
    private static int count = 0;

    public static void main(String[] args) {

        int a[] = { 12, 56, 95, 35, 88, 102, 89, 63, 154 };
//        String sa = mpSort(a);
//        System.out.println("����A���������ǣ�" + sa);

        int b[] = { 32, 55, 175, 75, 82, 111, 26, 159 };
        String sb = ksSort(b);
        System.out.println("����B���������ǣ�" + sb);
        System.out.println(count);

        int c[] = { 137, 555, 186, 45, 92, 150, 48, 360 };
//        String sc = crSort(c);
//        System.out.println("����C���������ǣ�" + sc);
    }

    // ������
    public static String noSort(int arr[]) {
        String s = " ";
        for (int i = 0; i < arr.length; i++) {
            s = s + arr[i] + " ";
        }
        return s;
    }

    // ð������
    public static String mpSort(int arr[]) {
        String s = " ";
        int temp; // temp Ϊ����ʱ���ݴ�����
        boolean move; // move �ж��Ƿ��й�����
        for (int i = 1; i < arr.length; i++) // i ��ʾ��������arr.length-1��
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

    // ��������
    public static String ksSort(int arr[]) {
        String s = " ";
        quicksort(arr, 0, arr.length - 1); // ��ʼ��arr[0]Ϊ���λ��arr[arr.length-1]Ϊ���λ
        for (int i = 0; i < arr.length; i++) {
            s = s + arr[i] + " ";
        }
        return s;
    }

    // ��������ķ����㷨�����ػ�׼���ݵ��±�
    private static int partition(int arr[], int low, int high) {
        int key = arr[low]; // ��׼ֵ��������
        while (low < high) {
            if (low < high && arr[high] >= key) high--;
            arr[low] = arr[high]; count++;
            if (low < high && arr[low] <= key) low++;
            arr[high] = arr[low]; count++;
        }
        arr[low] = key; // ��λ���ϻ�׼ֵ
        count++;
        return low;
    }
    
    private static int newPartition(int arr[], int low, int high) {
        int key = arr[low]; // ��׼ֵ��������
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

    // �����Ŀ�������һ�ֵݹ��㷨
    private static void quicksort(int arr[], int low, int high) {
        if (low < high) {
            int result = newPartition(arr, low, high);
            quicksort(arr, low, result - 1);
            quicksort(arr, result + 1, high);
        }
    }

    // ��������
    public static String crSort(int arr[]) {
        String s = " ";
        int key; // key ��ʾ���ڣ���¼����������
        for (int i = 2; i <= arr.length; i++) // i ��ʾ���������ȣ���2��ʼ������ֱ��arr.length����
        {
            if (arr[i - 1] < arr[i - 2]) // ��������С����һ�����������һλ
            {
                key = arr[i - 1];
                for (int j = i - 2; j >= 0; j--) {
                    if (j > 0) {
                        if (arr[j] > key) {
                            arr[j + 1] = arr[j]; // �����������ݣ������һλ
                        } else {
                            arr[j + 1] = key; // С�ڵ����������ݣ����λ������������
                            break;
                        }
                    } else // �����������һֱ�Ƚϵ�arr[0]����Ҫ���⴦��
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
