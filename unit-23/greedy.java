import java.util.*;

public class greedy{

    public static void activityselection(){

        int start[]={1,3,0,5,8,5};
        int end[]=  {2,4,6,7,9,9};

        // sorting //
         int activities[][]=new int[start.length][3];
         for(int i=0;i<start.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
         }

         //lambda function -> short form of a big function  //
         Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));

        // end time basis sorted//
        int maxAct=0;
        ArrayList<Integer>ans=new ArrayList<>();

        //1st activity //
        maxAct=1;
        ans.add(activities[0][0]);
        int lastEnd=activities[0][2];

        for(int i=0;i<end.length;i++){
            if(activities[i][1]>=lastEnd){
                // activity select//
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd=activities[i][2];
            }
        }

        System.out.println("max activities ="+ maxAct);

        for(int i=0;i<ans.size();i++){
            System.out.println("A"+ans.get(i));
        }

        System.out.println();
    }
    
    public static void fractional_knapsack(){

        int val[]={60,100,120};
        int weight[]={10,20,30};
        int w=50;

        double ratio[][]=new double[val.length][2];
        // 0th col => idx; 1st col=>ratio//
        for(int i=0;i<val.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)weight[i];
        }

        // ascending order //
        Arrays.sort(ratio,Comparator.comparingDouble(o -> o[1]));

        int Capacity=w;
        int finalVal=0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(Capacity>=weight[idx]){ // include full iteam//
                finalVal+=val[idx];
                Capacity-=weight[idx];
            }else{
                // incldue fractional iteam //
                finalVal +=(ratio[i][1]*Capacity);
                Capacity=0;
                break;
            }
        }
        System.out.println("final value="+finalVal);
    }

    public static void min_absolute_diff_pair(){
        int A[]={1,2,3};
        int B[]={2,1,3};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff=0;

        for(int i=0;i<A.length;i++){
            minDiff+=Math.abs(A[i]-B[i]);
        }

        System.out.println("min absolute difference ="+minDiff);
    }

    public static void max_length_chain_of_pair(){

        int pair[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};
        Arrays.sort(pair,Comparator.comparingDouble(o->o[1]));

        int ans=1;
        int pairEnd=pair[0][1];// Last selected pair end //

        for(int i=1;i<pair.length;i++){
            if(pair[i][0]>pairEnd){
                ans++;
                pairEnd=pair[i][1];
            }
        }
        System.out.println("max length of chain ="+ ans);

    }

    public static void indian_coin_conical_system(){
        Integer coins[]={1,2,5,10,20,50,100,500,2000};

        Arrays.sort(coins,Comparator.reverseOrder());

        int count=0;
        int amount=590;
        ArrayList<Integer>ans=new ArrayList<>();

        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                while(coins[i]<=amount){
                    count++;
                    ans.add(coins[i]);
                    amount-=coins[i];
                }
            }
        }

        System.out.println("total (min) coins used ="+ count);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }

    public static class Job{
        int deadline;
        int profit;
        int id;

        public Job(int i,int d,int p){
            id=i;
            deadline=d;
            profit=p;
        }
    }

    public static void job_sequencing_problem(){

        System.out.println(); 

        int jobsInfo[][]={{4,20},{1,10},{1,40},{1,30}};

        ArrayList<Job> jobs=new ArrayList<>();

        for(int i=0;i<jobsInfo.length;i++){
            jobs.add(new Job(i,jobsInfo[i][0],jobsInfo[i][1]));
        }

        // Collection.sort(jobs,(a,b)->a.profit-b.profit);// ascending order //
        Collections.sort(jobs,(a,b)->b.profit-a.profit); // descending order //

        ArrayList<Integer> seq=new ArrayList<>();
        int time=0;
        for(int i=0;i<jobs.size();i++){
            Job curr=jobs.get(i);
            if(curr.deadline>time){
                seq.add(curr.id);
                time++;
            }
        }

        // print sequence //
        System.out.println("max jobs ="+seq.size());
        for(int i=0;i<seq.size();i++){
            System.out.println(seq.get(i)+" ");
        }
    }

    public static void chocola_problem(){
        int n=4,m=6;
        Integer costVer[]={2,1,3,1,4};// n-1 //
        Integer costHor[]={4,1,2};  // m-1 //
  
        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costHor,Collections.reverseOrder());

        int h=0,v=0;
        int hp=1,vp=1;
        int cost=0;

        while(h<costHor.length && v<costVer.length){
            if(costVer[v]<=costHor[h]){ // horizontal cut //
                cost+=(costHor[h]*vp);
                hp++;
                h++;
            }else{ // vertical cut //
                 cost+=(costVer[v]*hp);
                 vp++;
                 v++;
            }
        }

        while(h<costHor.length){
                cost+=(costHor[h]*vp);
                hp++;
                h++;
        }

        while( v<costVer.length){
            cost+=(costVer[v]*hp);
            vp++;
            v++;
        }

        System.out.println("min cost of cuts="+cost);

    }

    public static void main(String args[]){
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};

        // sorting //
         int activities[][]=new int [start.length][3];
         for(int i=0;i<start.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
         }


        // end time basis sorted//
        int maxAct=0;
        ArrayList<Integer>ans=new ArrayList<>();

        //1st activity //
        maxAct=1;
        ans.add(0);
        int lastEnd=end[0];

        for(int i=0;i<end.length;i++){
            if(start[i]>=lastEnd){
                // activity select//
                maxAct++;
                ans.add(i);
                lastEnd=end[i];
            }
        }
        System.out.println("max activities ="+ maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.println("A"+ans.get(i));
        }
        System.out.println();

        activityselection();
        fractional_knapsack();
        min_absolute_diff_pair();
        max_length_chain_of_pair();
        indian_coin_conical_system();
        job_sequencing_problem();
        chocola_problem();

    }
}