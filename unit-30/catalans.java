public class catalans {

    public static int catalanRec(int n){

        if(n==0 || n==1){
            return 1;
        }

        int ans=0;
        for (int i = 0; i < n; i++) {
            ans+=catalanRec(i)*catalanRec(n-i-1);
        }
        return ans;

    }

    public static int catalan(int n,int cat[]){
        
        if(n==0||n==1){
            return cat[n]=1;
        }

        if(cat[n]!=0){
            return cat[n];
        }

        int ans=0;
        for (int i = 0; i < n; i++) {
            ans+=catalan(i,cat)*catalan(n-i-1, cat);
        }
        return cat[n]=ans;

    } 

    public static int catalantablutaion(int n){
        
        int catalan[]=new int[n+1];
        catalan[0]=1;
        catalan[1]=1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                catalan[i]+=catalan[j]*catalan[i-j-1];
            }
        }
        return catalan[n];
    }

    public static int bstways(int n){
        
        int tree[]=new int[n+1];
        tree[0]=1;
        tree[1]=1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                int left=tree[j];
                int right=tree[i-j-1];
                tree[i]+=left*right;
            }
        }
        return tree[n];
        
    }

    public static void main(String[] args) {
        int n=5;
        System.out.println(catalanRec(n));

        int m=5;
        int cat[]=new int[m+1];
        System.out.println(catalan(m,cat));
        System.out.println(catalantablutaion(5));
    }
}
