package algorithms;

import java.text.DecimalFormat;
import java.util.*;

public class RecipeCal {
    static DecimalFormat df = new DecimalFormat("#.#");
    public static void main(String[] args){
        List<List<String>> recipes = new ArrayList<>();
        int noOfPortions = 0, noOfDesiredPortions = 0;
        Scanner scl =  new Scanner(System.in);
        int noOfCases = scl.nextInt();
        for(int i = 0; i < noOfCases; i++) {
            scl.nextLine();
            int noOfIngredients = scl.nextInt();
            noOfPortions = scl.nextInt();
            noOfDesiredPortions = scl.nextInt();
            List<String> recipe = new ArrayList<>();
            for (int j = 0; j < noOfIngredients; j++) {
                scl.nextLine();
                recipe.add(scl.next());
                recipe.add(Double.toString(scl.nextDouble()));
                recipe.add(Double.toString(scl.nextDouble()));
            }
            recipe.add(Integer.toString(noOfPortions));
            recipe.add(Integer.toString(noOfDesiredPortions));
            recipes.add(recipe);
        }
        scl.close();
        recipeCal(recipes);
    }

    public static void recipeCal(List<List<String>> recipes){
        char[] chars = new char[40];
        Arrays.fill(chars, '-');
        String dashes = new String(chars);
        if(recipes.size() != 0) {
            int i = 1;
            for (List<String> recipe : recipes) {
                double mainIngredientWeight = 0;
                for (int j = 2; j < recipe.size() - 2; j=j+3) {
                    if(j%3 != 0 && Double.parseDouble(recipe.get(j)) == 100){
                        mainIngredientWeight = Double.parseDouble(recipe.get(j-1));
                        break;
                    }
                }
                int noOfPortion = Integer.parseInt(recipe.get(recipe.size() - 2));
                int noOfDesiredPortions = Integer.parseInt(recipe.get(recipe.size() - 1));
                double desiredPortionMainWeight = mainIngredientWeight * ((double) noOfDesiredPortions / noOfPortion);
                System.out.println("Recipe # " + i++);
                for (int j = 0; j < recipe.size()-2; j=j+3) {
                    System.out.println(recipe.get(j) + " " + df.format(Double.parseDouble(recipe.get(j+2)) * desiredPortionMainWeight / 100));
                }
                System.out.println(dashes);
            }
        }
    }
}
