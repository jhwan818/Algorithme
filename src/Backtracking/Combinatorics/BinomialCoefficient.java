package Backtracking.Combinatorics;

import java.util.Arrays;

public class BinomialCoefficient {
    int[][] cache;

    public int get(int n, int r){
        //Is impossible to choose more items than given.
        if (r > n) return 0;

        //Initiate cache to -1.
        cache = new int[n + 1][r + 1];
        for (int[] row : cache) Arrays.fill(row, -1);

        //Calculate coefficient by choosing all possible items.
        return choose(0, 0, n, r);
    }
    public int getInterval(int n, int rm, int rM){
        if(rm > rM){
            int tmp = rm;
            rm = rM;
            rM = rm;
        }
        //Is impossible to choose more items than given.
        if (rm > n) return 0;

        //Initiate cache to -1.
        cache = new int[n + 1][rM + 1];
        for (int[] row : cache) Arrays.fill(row, -1);

        //Calculate coefficient by choosing all possible items.

        return chooseInterval(0, 0, n, rm, rM);
    }
    public int getIntervalMinor(int n, int r){
        return getInterval(n, 0, r);
    }
    public int getIntervalMajor(int n, int r){
        return getInterval(n, r, n);
    }
    public int[] getAll(int n){
        int[] arr = new int[n + 1];
        for (int i = 0; i < arr.length; i++)
            arr[i] = get(n, i);
        return arr;
    }

    private int choose(int pos, int chosen, int n, int r){
        //If we selected all possibilities.
        if (pos == n)
            //In case we chose the exact number of choices.
            return chosen == r ? 1 : 0;
        //If we chose more than the required number of objects.
        else if (chosen > r)
            return 0;
        //If the current cache is not calculated yet.
        else if (cache[pos][chosen] == -1)
            cache[pos][chosen] = choose(pos + 1, chosen, n, r) + choose(pos + 1, chosen + 1, n, r);
        //Return
        return cache[pos][chosen];
    }
    private int chooseInterval(int pos, int chosen, int n, int rm, int rM) {
        //If we selected all possibilities.
        if (pos == n)
            //In case we chose the exact number of choices.
            return chosen >= rm && chosen <= rM ? 1 : 0;
            //If we chose more than the required number of objects.
        else if (chosen > rM)
            return 0;
            //If the current cache is not calculated yet.
        else if (cache[pos][chosen] == -1)
            cache[pos][chosen] = chooseInterval(pos + 1, chosen, n, rm, rM) + chooseInterval(pos + 1, chosen + 1, n, rm, rM);
        //Return
        return cache[pos][chosen];
    }

    public void makeCombinatorics(int[] arr, int[] res, boolean[] used, int pos, int sel, int r){
        if(r == 0) System.out.println(0);
        else if(sel == r){
            for (int i = 0; i < res.length; i++) {
                if(used[i])
                    System.out.print(res[i] + " ");
            }
            System.out.print("\n");
        } else {
            for (int i = pos; i < arr.length; i++) {
                if(!used[i]){
                    used[i] = true;
                    res[i] = arr[i];
                    makeCombinatorics(arr, res, used, i + 1, sel + 1, r);
                    used[i] = false;
                }
            }
        }
    }
    public void makeAllCombinatorics(int[] arr, int[] res, boolean[] used){
        for (int r = 0; r <= arr.length; r++)
            makeCombinatorics(arr, res, used, 0, 0, r);
    }
}
