package arrays_matrices;

public class FirstUniqChar {
    public int FirstNotRepeatingChar(String str) {
        // write code here
        int[] count = new int[128];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if(count[str.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }
}
