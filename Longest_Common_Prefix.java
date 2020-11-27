package algorithms;

public class Longest_Common_Prefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight", "flem", "flam", "fly"};
////		minLenght = Arrays.asList(strs).stream().map(val -> val.length()).collect(Collectors.toList()).stream().min(Integer::compare).get();
////		System.out.println(Arrays.asList(strs).stream().reduce((str1, str2) -> str1.length() < str2.length() ? str1 : str2).get());
////        minLenght = Arrays.asList(strs).stream().map(String::length).min(Integer::compareTo).get();
////		System.out.println(minLenght);
//        if (strs.length == 0 || strs == null) System.out.println("");
//        ;
//        if (strs.length == 1) System.out.println(strs[0]);
//        String prefix = "";
//        int minLenght = 0;
//        HashSet<String> chars = new HashSet<>();
//        minLenght = Arrays.asList(strs).stream().map(String::length).min(Integer::compareTo).get();
//        for (int i = 0; i < minLenght; i++) {
//            for (String inputVal : strs) {
//                chars.add(Character.toString(inputVal.charAt(i)));
//            }
//            if (chars.size() == 1) {
//                prefix += String.join("", chars);
//            } else {
//                break;
//            }
//            chars.clear();
//        }
//        System.out.println(prefix);

        longestCommonPrefix(strs);

    }

    // Horizontal Scanning
    //flower, flowe, flow, flo, fl
    public String longestCommonPrefixH(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    // Vertical Scanning
    //takes length of first string in array and iterates for that length. takes one character at a time for that string
    //and checks if the length of that first string matches any other string int he array or if the current character is not matching the current
    //character of remaining string. if yes send substring from 0 to that index
    public String longestCommonPrefixV(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    //Approach 3: Divide and conquer
    public String longestCommonPrefixdiv(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private static String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    static String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    //Approach 4: Binary search
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }
}
