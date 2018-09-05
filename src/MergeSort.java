import java.util.Arrays;

public class MergeSort {
	
	static void mergeSort(Comparable[] a,int start,int end) {
		if(start==end) {
			return;
		}
		int middle=(start+end)/2;
		mergeSort(a,start,middle);
		mergeSort(a,middle+1,end);
		merge(a,start,middle,end);
	}
	
	static void merge(Comparable[] a,int start,int middle,int end) {
		int length=end-start+1;
		Comparable[] temp=new Comparable[length];
		int i=0;
		int index1=start;
		int index2=middle+1;
		
		while(index1<=middle && index2<=end) {
			if(a[index1].compareTo(a[index2])<0) {
				temp[i++]=a[index1++];
			}
			else
				temp[i++]=a[index2++];
		}
		while(index1<=middle) {
			temp[i++]=a[index1++];
		}
		while(index2<=end) {
			temp[i++]=a[index2++];
		}
		for(i=0;i<temp.length;++i) {
			a[start+i]=temp[i];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a= {31,3,65,73,8,11,20,29,48,15};	
		System.out.println(Arrays.toString(a));
		mergeSort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));

		//String
		System.out.println("-----------String-----------");
		
		String[] sa="Pizza Chicken Hamburger FrenchFries Stake".split(" ");
		System.out.println(Arrays.toString(sa));
		mergeSort(sa,0,sa.length-1);
		System.out.println(Arrays.toString(sa));
		
		//Person
		System.out.println("-----------Person-Before-----------");
		
		String[] data="Minsu Chulsu Junghee Minhee Gyeongsu Jaein Myungho Jaehee Jaehyun Jaeseok".split(" ");
		Person[] p=new Person[data.length];
		for(int i=0;i<p.length;i++) {
			p[i]=new Person(data[i]);
		}
		
		for(Person aP:p)
			System.out.println(aP.name);
		
		System.out.println("-----------Person-After-----------");
		mergeSort(p,0,p.length-1);
		
		for(Person aP:p)
			System.out.println(aP.name);
	}
	
	static class Person implements Comparable{
		String name;
		
		public Person(String name) {
			this.name=name;
		}
		@Override
		public int compareTo(Object o) {
			return name.compareTo(((Person)o).name);
		}
	}
}
