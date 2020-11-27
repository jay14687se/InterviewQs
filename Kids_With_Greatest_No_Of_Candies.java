package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Kids_With_Greatest_No_Of_Candies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> output = new ArrayList<>();
        if(candies == null || candies.length == 0) return output;
        if(candies.length == 1){
            output.add(true);
            return output;
        }
        int maxInt = 0;
        for(int i : candies){
            if(maxInt<i){
                maxInt = i;
            }
        }
        for(int candy : candies){
            output.add((candy + extraCandies) >= maxInt);
        }
        return output;
    }

    public static void main(String[] args){
        int[] candies = {1,2,5,3,3,7};
        System.out.println(kidsWithCandies(candies, 3));
    }
}
