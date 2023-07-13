public class MaxProfit {

    public  static int maxProfit(int [] prices){
        int min_value=Integer.MAX_VALUE;
        int max_profit=0;

        for(int i=0; i<prices.length; i++){
            //
            if(prices[i]<min_value){
                min_value=prices[i];
            }else if(prices[i]-min_value>max_profit){
                max_profit=prices[i]-min_value;

            }
        }
        return  max_profit;
    }
    public static void main(String[] args) {
        int [] arr={7,1,5,3,6,4};
        maxProfit(arr);
    }
}
