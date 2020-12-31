package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;


public class Mysort {
public static void bubble_sort(int[] a,int n) {
	/*
	 * ð������
	 * ��Ҫ��������ѭ��
	 * ��һ��
	 */
	/*
	 * �ڽ���ð�������ͬʱͳ������������жԹؼ��ֵıȽϴ������ƶ������������ͳ�ƽ����
	 */
	int compare = 0,movement=0;
	for (int i = 0; i < n; i++) {
		/*
		 * �������֮���һ����ǩ��
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
//	System.out.println(Arrays.toString(a));//��ӡ����a
	/*�����������˫��ѭ�����������򣬵���������֮������������鿴�Ƿ���н���������˷���һЩ�ռ�
	 * ���Լ���һ����ǩtag�������
	 * ���ڲ�ѭ�������˽���ʱtag=ture
	 * �����жϽ�����Ϊ
	 * 
	 */
//System.out.println(Arrays.toString(a));//��ӡ����a
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
	 * ֱ�Ӳ�������
	 * ������˿���
	 *�Ƚ��������ŵ�һ��{ }�У��ٶ���һ����{}��
	 *����㽫һ�����Ž�ȥ��Ĭ��Ϊa[0]
	 *�ڴ��±�Ϊ1���ڶ���Ԫ�ص�����ʼ�Ƚ�,��Ϊtemp������Ҫ������ǰ���Ԫ�رȴ�С�����Ƚ�n-2�����Ե�һ��ѭ����[1~n)
	 *�ȱȽ�i-1��temp�Ĵ�С��ֱ��j=0��
	 *�����ʱ��Ҫ�����������в��룬�鵽j+1λ����
	 */
	
	/*
	 * �ڽ���ֱ�Ӳ��������ͬʱͳ������������жԹؼ��ֵıȽϴ������ƶ������������ͳ�ƽ����
	 */
	int compare = 0,movement=0;
	int j=0;
	for (int i = 1; i < n; i++) {//��һ��ѭ�� ���ȳ�һ����
		int temp=a[i];
			for ( j = i-1; j >=0 ; j--) {//�ڵڶ���ѭ���У��Ƚ�temp������������������бȽ�
			compare++;
			if (a[j]>temp) {
				a[j+1]=a[j];
				movement++;				
//				a[i]=temp; ����Ҫ������֮���
			}else {
				break;
		//��Ϊ��ߵļ����Ѿ�������˳����ˣ����temp�ȸտ�ʼ��[i-1]���󣬾�û�н�����Ҫ��ֱ������ѭ��
			}
		}
//		movement++;
		a[j+1]=temp;//j=-1ʱ=-=
	}
//	System.out.println(Arrays.toString(a));
//	System.out.println("compare  "+compare);
//	System.out.println("movement  "+movement);

}
public static void shell_sort(int[]a,int n) {
	/*
	 * shellsort������С��������
	 * ��������
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
				//ǰ���¼λ�õ�������increament
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
	 * ��ѡ������
	 * ����ѡ���ؼ�����С��Ԫ�ط��ڵ�һ��λ�ã���ѡ����ڶ�С��Ԫ�ط��ڵڶ���Ԫ�أ��Դ�����ֱ��ѡ����n-1��Ԫ��
	 */
	/*
	 * �ڽ��м�ѡ�������ͬʱͳ������������жԹؼ��ֵıȽϴ������ƶ������������ͳ�ƽ����
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
			
		}//����
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
	 * ��·�鲢�㷨  >=<���η�
	 * 1.�֣�ֱ���ֳ����򵥸���
	 * 2.�� ���˲����Ѿ����
	 * 3.�ϣ�
	 */
	if (a==null) {
		return ;
	}
	if (left<right) {
		//�����м�λ��
		int mid=(left+right)/2;
		//���������н��еݹ�鲢����
		mergesort(a, left, mid);
		//���������н��еݹ�鲢����
		mergesort(a, mid+1, right);
		//���ϡ������кϲ�
		merge(a, left, mid, right);
	}
}
//��һ�����黮��Ϊ�����ֽ��У��鲢����
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
	 * ǰ�潫һ�����黮��Ϊleft(ls),mid,(rs)right
	 * Ȼ���໥�Ƚ�����λ��Ϊls��rs��С
	 * �ŵ���������temp�У�
	 * ����֮�����潫��ʱ�ռ������Ǩ�ƻ�a[]
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
	int pivot;//���ĵ�
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
//����Ԫ�ش�ӡ���
public static void print(int[] value)
{
	for(int i=0;i<value.length;i++){
		System.out.print(" "+value[i]);
	}
	System.out.println();
}
/// �鲢����Java-�ݹ�棩
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
//�鲢����Java-�����棩
public static void merge_sort1(int[] arr) {
 int len = arr.length;
 int[] result = new int[len];
 int block, start;

 // ԭ�����ĵ�����������һ�Σ�û�п��ǵ���������������
 for(block = 1; block < len*2; block *= 2) {
     for(start = 0; start <len; start += 2 * block) {
         int low = start;
         int mid = (start + block) < len ? (start + block) : len;
         int high = (start + 2 * block) < len ? (start + 2 * block) : len;
         //���������ʼ�±꼰�����±�
         int start1 = low, end1 = mid;
         int start2 = mid, end2 = high;
         //��ʼ������block���й鲢����
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
//	System.out.println("ð������");
////	bubble_sort(a, n);
//	System.out.println("ֱ�Ӳ�������");
//	System.out.println("�������飺"+Arrays.toString(a));
//	insert_sort(a, n);
//	insertion_sort(a, n);
//	System.out.println("ϣ������"+Arrays.toString(a));
//	shell_sort(a, n);
//	System.out.println("��ѡ������");
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

System.out.println("�ؼ������У�");	
	Mysort.print(arr1);

	long starttime=System.currentTimeMillis();
	Mysort.bubble_sort(arr1, n);		
	long endtime=System.currentTimeMillis();
	System.out.println("ð��ʱ��:" + (endtime-starttime)+"ms");

	long starttime1=System.currentTimeMillis();
insert_sort(a, n);
long endtime1=System.currentTimeMillis();
	System.out.println("ֱ�Ӳ���ʱ��:" + (endtime1-starttime1)+"ms");

	long starttime2=System.currentTimeMillis();
	select_sort(b, n);
	long endtime2=System.currentTimeMillis();
	System.out.println("��ѡ������ʱ��:" + (endtime2-starttime2)+"ms");

	long starttime3=System.currentTimeMillis();
shell_sort(c, n);
long endtime3=System.currentTimeMillis();
	System.out.println("shell����ʱ��:" + (endtime3-starttime3)+"ms");

	long starttime4=System.currentTimeMillis();
qucick_sort(d, n);
long endtime4=System.currentTimeMillis();
	System.out.println("����ʱ��:" + (endtime4-starttime4)+"ms");
	
	long starttime5=System.currentTimeMillis();
merge_sort(e);
long endtime5=System.currentTimeMillis();
	System.out.println("��·����ʱ��:" + (endtime5-starttime5)+"ms");
	
}
}