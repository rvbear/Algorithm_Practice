import java.util.*;

public class Main{
    public static void main(String[] args) {
        /* 병사 배치하기 */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //병사의 수 입력
        int[] power = new int[n];   //각 병사들의 전투력 배열
        int[] dp = new int[n];  //i번째일 때 최장 증가 부분수열 길이 저장
        
        for(int i=n-1;i>=0;i--){
            power[i] = sc.nextInt();    //전투력 거꾸로 입력받기
            dp[i] = 1;  //부분 수열 길이 초기화
        }
            
        /*
        for(int i=0;i<n;i++){
           System.out.print(power[i]+" ");
        }
        */

        //LIS 알고리즘 적용
        for(int i=1;i<n;i++){
            //i 앞의 모든 값들에 대해
            for(int j=0;j<i;j++){
                if(power[j]<power[i]){
                    //i번째 값에 대한 가장 긴 증가 부분 수열 길이 구하기
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    //System.out.println(i+" 일 때    "+ dp[i]);
                }
            }
        }

        //dp[]에서 최댓값 구하기
        int max = dp[0];
        for(int i=1;i<n;i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(n-max);
    }
}