import Backtracking.Combinatorics.BinomialCoefficient;

public class Main {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4};
        int[] res = new int[arr.length];
        boolean[] used = new boolean[arr.length];
        BinomialCoefficient coefficient = new BinomialCoefficient();
        System.out.println("Binomial Coefficients:");
        for (int i : coefficient.getAll(4))
            System.out.println(i);
        System.out.println("All combinatorics of Binomial Coefficients:");
        coefficient.makeAllCombinatorics(arr, res, used);
    }
}
