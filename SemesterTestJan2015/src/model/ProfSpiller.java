package model;

import java.util.ArrayList;

public class ProfSpiller extends Spiller {
    private double gameRate;

    public ProfSpiller(String name, int year, double gameRate) {
        super(name, year);
        this.gameRate = gameRate;
    }

    public double getGameRate() {
        return gameRate;
    }

    @Override
    public double kampHonorar() {
        double participationPercent = 0;
        return super.kampHonorar();
    }
    public int linearSearchList(ArrayList<String> list, String target) {
        int indeks = -1;
        int i = 0;
        while (indeks == -1 && i < list.size()) {
            String k = list.get(i);
            if (k.equals(target))
                indeks = i;
            else
                i++;
        }
        return indeks;
    }

    public int binarySearchArray(int[] arr, int target) {
        int indeks = -1;
        int left = 0;
        int right = arr.length-1;
        while (indeks == -1 && left <= right) {
            int middle = (left + right) / 2;
            int k = arr[middle];
            if (k == target)
                indeks = middle;
            else if (k > target)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return indeks;
    }

    public ArrayList<Integer> totalMerge(int[] s1, int[] s2) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        // merge till one or both Arrays are empty
        int i1 = 0;
        int i2 = 0;
        while (i1 < s1.length && i2 < s2.length) {
            if (s1[i1] < s2[i2]) {
                // s1 number is lowest
                result.add(s1[i1]);
                i1++;
            }
            else {
                // s2 number is lowest
                result.add(s2[i2]);
                i2++;
            }
        }

        // empty the remaning Array
        while (i1 < s1.length) {
            result.add(s1[i1]);
            i1++;
        }
        while (i2 < s2.length) {
            result.add(s2[i2]);
            i2++;
        }

        return result;
    }

}
