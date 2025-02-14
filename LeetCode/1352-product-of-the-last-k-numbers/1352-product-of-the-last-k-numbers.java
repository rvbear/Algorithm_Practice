import java.util.*;

class ProductOfNumbers {
    int prev;
    List<Integer> arr;
    
    public ProductOfNumbers() {
        arr = new ArrayList<>();
        prev = 1;
        arr.add(1);
    }
    
    public void add(int num) {
        if (num > 0) {
            prev *= num;
            arr.add(prev);
        } else {
            arr = new ArrayList<>();
            arr.add(1);
            prev = 1;
        }
    }
    
    public int getProduct(int k) {
        int n = arr.size();
        return k < n ? prev / arr.get(n-1-k) : 0;
    }
}
