class Teste{
    public static void main(String[] args){
	int[] a = new int[10];
	a[1]+=1;
	System.out.println(a[1]);
	int[] b = a;
	System.out.println(b[1]);
    }
}
