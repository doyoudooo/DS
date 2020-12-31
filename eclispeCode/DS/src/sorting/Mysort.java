package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;


public class Mysort {
public static void bubble_sort(int[] a,int n) {
	/*
	 * 冒泡排序：
	 * 主要就是两层循环
	 * 第一层
	 */
	/*
	 * 在进行冒泡排序的同时统计在排序过程中对关键字的比较次数和移动次数，并输出统计结果。
	 */
	int compare = 0,movement=0;
	for (int i = 0; i < n; i++) {
		/*
		 * 在内外层之间加一个标签组
		 */
		
		compare++;

		boolean tag=false;
		for (int j = 0; j < n-i-1; j++) {
			if (a[j]>a[j+1]) {
				swap(a, j, j+1);
				tag=true;
				movement++;
			}
		}
		if (!tag) {
			break;
		}

	}
//	System.out.println(Arrays.toString(a));//打印数组a
	/*如果仅仅是用双层循环来进行排序，当数组排完之后，她还会继续查看是否进行交换，因此浪费了一些空间
	 * 所以加上一个标签tag用来标记
	 * 当内层循环进行了交换时tag=ture
	 * 所以判断交换不为
	 * 
	 */
//System.out.println(Arrays.toString(a));//打印数组a
//System.out.println("compare  "+compare);
//System.out.println("movement  "+movement);

}
public static void swap(int[]a,int i,int j) {
	int temp=a[i];
	a[i]=a[j];
	a[j]=temp;
}
public static void insert_sort(int[]a ,int n) {
	/*
	 * 直接插入排序
	 * 就想抽扑克牌
	 *先将所有数放到一个{ }中，再定义一个空{}，
	 *先随便将一个数放进去，默认为a[0]
	 *在从下标为1，第二个元素的数开始比较,设为temp（后面要将他与前面的元素比大小），比较n-2次所以第一层循环到[1~n)
	 *先比较i-1与temp的大小，直到j=0；
	 *插入的时候要在排完序后进行插入，查到j+1位置上
	 */
	
	/*
	 * 在进行直接插入排序的同时统计在排序过程中对关键字的比较次数和移动次数，并输出统计结果。
	 */
	int compare = 0,movement=0;
	int j=0;
	for (int i = 1; i < n; i++) {//第一层循环 ，先抽一张牌
		int temp=a[i];
			for ( j = i-1; j >=0 ; j--) {//在第二层循环中，先将temp与左边排完序的数组进行比较
			compare++;
			if (a[j]>temp) {
				a[j+1]=a[j];
				movement++;				
//				a[i]=temp; 插入要在排完之后插
			}else {
				break;
		//因为左边的集合已经是排完顺序的了，如果temp比刚开始的[i-1]都大，就没有交换必要，直接跳出循环
			}
		}
//		movement++;
		a[j+1]=temp;//j=-1时=-=
	}
//	System.out.println(Arrays.toString(a));
//	System.out.println("compare  "+compare);
//	System.out.println("movement  "+movement);

}
public static void shell_sort(int[]a,int n) {
	/*
	 * shellsort又名缩小增量排序
	 * 划分增量
	 */
//	int increament=n/2;
	int compare = 0,movement=0;
	
	int i,j;
	int temp=0;
	for (int increament=n/2;  increament> 0;increament/=2) {
		for ( i = increament; i < n; i++) {
			temp=a[i];
			for (j = i;  j>= increament; j-=increament) {
				compare++;
				//前后记录位置的增量是increament
				if (a[j-increament]>temp) {
					a[j]=a[j-increament];
					movement++;
				}
				else {
					break;
				}
//				a[j-increament]=temp;

			}
			a[j]=temp;
		}
	}
//	System.out.println(Arrays.toString(a));
//	System.out.println("compare  "+compare);
//	System.out.println("movement  "+movement);
}
//public static void quick_sort(int [] a,int n) {
//	
//}
//protected int parttion(int low,int high) {
//	
//}

public static void select_sort(int[]a,int n) {
	/*
	 * 简单选择排序
	 * 首先选出关键字最小的元素放在第一个位置，在选择出第二小的元素放在第二个元素，以此类推直到选出第n-1个元素
	 */
	/*
	 * 在进行简单选择排序的同时统计在排序过程中对关键字的比较次数和移动次数，并输出统计结果。
	 */
	int compare = 0,movement=0;

	if (n<=1) {
		return;
	}
	for (int i = 0; i < n-1; ++i) {
//		compare++;
		int minIndex=i;
		for (int j = i+1; j < n; ++j) {
			compare++;
			if (a[j]<a[minIndex]) {
				minIndex=j;
				
			}
			
		}//交换
		movement++;
		int temp=a[i];
	a[i]=a[minIndex];
	a[minIndex]=temp;
	
	}
//	System.out.println(Arrays.toString(a));
//	System.out.println("compare  "+compare);
//	System.out.println("movement  "+movement);
	
}










public static void mergesort(int[]a,int left,int right) {
	/*
	 * 二路归并算法  >=<分治法
	 * 1.分，直到分成有序单个数
	 * 2.治 ，此步骤已经完成
	 * 3.合，
	 */
	if (a==null) {
		return ;
	}
	if (left<right) {
		//先找中间位置
		int mid=(left+right)/2;
		//对左子序列进行递归归并排序
		mergesort(a, left, mid);
		//对右子序列进行递归归并排序
		mergesort(a, mid+1, right);
		//“合”，进行合并
		merge(a, left, mid, right);
	}
}
//对一个数组划分为两部分进行，归并排序
public static void merge(int[]a,int left,int mid,int right) {
	int []temp= {a.length};
	int leftstat=left;
	int rightstart=mid+1;
	int tempindex=left;
	while (leftstat<=mid&&rightstart<=right) {
		if (a[leftstat]<a[rightstart]) {
			temp[tempindex++]=a[leftstat++];
		}else {
			temp[tempindex++]=a[rightstart++];
		}
	}
	while (leftstat<=mid) {
		temp[tempindex++]=a[leftstat++];
	}
	while (rightstart<=right) {
		temp[tempindex++]=a[rightstart++];
	}
	/*
	 * 前面将一个数组划分为left(ls),mid,(rs)right
	 * 然后相互比较数组位序为ls，rs大小
	 * 放到辅助数组temp中，
	 * 排完之后，下面将临时空间的数组迁移回a[]
	 */
	while (left<right) {
		a[left]=temp[left++];
	}
	
	
}
//public void merge_sort(int []a,int n) {
//	int left=0;
//	int right=a.length-1;
//	mergesort(a, left, right);
//	
//}

public static  void quicksort (int []a,int left,int right) {
	int pivot;//中心点
	if (right-left<2) {
		return ;
	}
	pivot=median3(a,left,right);//?
	int i=left;
	int j=right-1;
	while (true) {
	while (a[++i]<pivot); 
	while (a[--j]>pivot);
			if (i<j) {
				swap(a, i, j);
			}else {
				break; 
			}
			
	}
	swap(a, i, right-1);
	quicksort(a, left, i-1);
	quicksort(a, i+1, right);
}
public static void qucick_sort(int []a,int n) {
quicksort(a, 0, n-1);
}
public static int median3(int a[],int left,int right) {
	int center=(left+right)/2;
	if (a[left]>a[center]) {
		swap(a, left, center);
		
	}
	if (a[left]>a[right]) {
		swap(a, left, right);
	}
	if (a[center]>a[right]) {
		swap(a,center, right);
	}
	swap(a, center, right-1);
	return a[right-1];
}
public static void heapsort(int []arr) {
	if (arr.length<=1) {
	return;
	}
	buildheap(arr);
}
public static void buildheap(int []arr) {
	for (int i = (arr.length-1)/2; i >=0; i--) {
		heapify(arr,arr.length-1,i);
	}
}
public static void heapify(int []arr,int n,int i) {
	while (true) {
		int maxpos=i;
		if (i*2+1<=n&&arr[i]<arr[i*2+1]) {
			maxpos=i*2+2;
		}
		if (i*2+2<=n&&arr[maxpos]<arr[i*2+2]) {
			maxpos=i*2+2;
		}
	}
	
}
public static  int[] randomInt(int n,int size){
	int [] temp=new int[size];
	Random rand=new Random();
	for(int i=0;i<size;i++){
		temp[i]=rand.nextInt(n);
	}
	return temp;
}
//数组元素打印输出
public static void print(int[] value)
{
	for(int i=0;i<value.length;i++){
		System.out.print(" "+value[i]);
	}
	System.out.println();
}
/// 归并排序（Java-递归版）
static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
    if (start >= end)
        return;
    int len = end - start, mid = (len >> 1) + start;
    int start1 = start, end1 = mid;
    int start2 = mid + 1, end2 = end;
    merge_sort_recursive(arr, result, start1, end1);
    merge_sort_recursive(arr, result, start2, end2);
    int k = start;
    while (start1 <= end1 && start2 <= end2)
        result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
    while (start1 <= end1)
        result[k++] = arr[start1++];
    while (start2 <= end2)
        result[k++] = arr[start2++];
    for (k = start; k <= end; k++)
        arr[k] = result[k];
}

public static void merge_sort(int[] arr) {
    int len = arr.length;
    int[] result = new int[len];
    merge_sort_recursive(arr, result, 0, len - 1);
}
//归并排序（Java-迭代版）
public static void merge_sort1(int[] arr) {
 int len = arr.length;
 int[] result = new int[len];
 int block, start;

 // 原版代码的迭代次数少了一次，没有考虑到奇数列数组的情况
 for(block = 1; block < len*2; block *= 2) {
     for(start = 0; start <len; start += 2 * block) {
         int low = start;
         int mid = (start + block) < len ? (start + block) : len;
         int high = (start + 2 * block) < len ? (start + 2 * block) : len;
         //两个块的起始下标及结束下标
         int start1 = low, end1 = mid;
         int start2 = mid, end2 = high;
         //开始对两个block进行归并排序
         while (start1 < end1 && start2 < end2) {
         result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
         }
         while(start1 < end1) {
         result[low++] = arr[start1++];
         }
         while(start2 < end2) {
         result[low++] = arr[start2++];
         }
     }
 int[] temp = arr;
 arr = result;
 result = temp;
 }
 result = arr;       
}
public static void main(String[] args) {
//	int[]a= {1,2,3,4,5};
//	int[]a= {5,8,3,6,5};
//	int[]a= { 5,4,3,2,1};
//	int n=a.length;
//	System.out.println("冒泡排序");
////	bubble_sort(a, n);
//	System.out.println("直接插入排序");
//	System.out.println("输入数组："+Arrays.toString(a));
//	insert_sort(a, n);
//	insertion_sort(a, n);
//	System.out.println("希尔排序："+Arrays.toString(a));
//	shell_sort(a, n);
//	System.out.println("简单选择排序");
//	select_sort(a, n);
//	selection_sort(a, n);
	int []arr1=Mysort.randomInt(100, 10010);
	int n=arr1.length;
	int []a = arr1;
	int []b=arr1;
	int []c=arr1;
	int []d=arr1;
	int []e=arr1;

//merge_sort(a);
//Mysort.print(a);

//System.out.println(" ");
//merge_sort1(arr1);
//Mysort.print(arr1);

System.out.println("关键字序列：");	
	Mysort.print(arr1);

	long starttime=System.currentTimeMillis();
	Mysort.bubble_sort(arr1, n);		
	long endtime=System.currentTimeMillis();
	System.out.println("冒泡时间:" + (endtime-starttime)+"ms");

	long starttime1=System.currentTimeMillis();
insert_sort(a, n);
long endtime1=System.currentTimeMillis();
	System.out.println("直接插入时间:" + (endtime1-starttime1)+"ms");

	long starttime2=System.currentTimeMillis();
	select_sort(b, n);
	long endtime2=System.currentTimeMillis();
	System.out.println("简单选择排序时间:" + (endtime2-starttime2)+"ms");

	long starttime3=System.currentTimeMillis();
shell_sort(c, n);
long endtime3=System.currentTimeMillis();
	System.out.println("shell排序时间:" + (endtime3-starttime3)+"ms");

	long starttime4=System.currentTimeMillis();
qucick_sort(d, n);
long endtime4=System.currentTimeMillis();
	System.out.println("快排时间:" + (endtime4-starttime4)+"ms");
	
	long starttime5=System.currentTimeMillis();
merge_sort(e);
long endtime5=System.currentTimeMillis();
	System.out.println("二路并归时间:" + (endtime5-starttime5)+"ms");
	
}
}
