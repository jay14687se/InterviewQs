package algorithms;

import java.util.*;

public class NewHeir3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String founder = sc.next();
        HashMap<String, List<String>> familyTree = new HashMap<>();
        for(int i = 0; i < n; i++){
            sc.nextLine();
            String child = sc.next();
            String parent1 = sc.next();
            String parent2 = sc.next();
            if(familyTree.containsKey(parent1)){
                familyTree.get(parent1).add(child);
            } else {
                List<String> parent1Children = new ArrayList<>();
                parent1Children.add(child);
                familyTree.put(parent1, parent1Children);
            }
            if(familyTree.containsKey(parent2)){
                familyTree.get(parent2).add(child);
            } else {
                List<String> parent2Children = new ArrayList<>();
                parent2Children.add(child);
                familyTree.put(parent2, parent2Children);
            }
        }
        HashMap<String, Double> bloodRel = new HashMap<>();
        List<HashMap<String, Double>> nextInLine = new ArrayList<>();
        HashMap<String, Double> current = new HashMap<>();
        current.put(founder, 1.0);
        nextInLine.add(new HashMap<>(current));
        current.clear();
        while(nextInLine.size() > 0){
            current = nextInLine.get(0);
            nextInLine.remove(0);
            String currHeir = "";
            Double blood = 0.0;
            for(Map.Entry<String, Double> entry : current.entrySet()){
                currHeir = entry.getKey();
                blood = entry.getValue();
            }
            if(bloodRel.containsKey(currHeir)){
                bloodRel.put(currHeir, bloodRel.get(currHeir) + blood);
            } else {
                bloodRel.put(currHeir, blood);
            }
            current.clear();
            if(familyTree.containsKey(currHeir)){
                for(String children : familyTree.get(currHeir)){
                    current.put(children, blood/2);
                    nextInLine.add(new HashMap<>(current));
                    current.clear();
                }
            }
        }
        String heir = "";
        Double currBlood = 0.0;
        for(int i = 0; i < m; i++){
            sc.nextLine();
            String claimant = sc.next();
            if(bloodRel.containsKey(claimant) && bloodRel.get(claimant) > currBlood){
                currBlood = bloodRel.get(claimant);
                heir = claimant;
            }
        }
        sc.close();
        System.out.println(heir);
    }
}
