package Ex0712_13_14;

public class SequenceApp {
    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 9, 16, 9, 7, 4, 9, 11};
        //int[] a = new int[]{11, 11, 7, 9, 16, 4, 1};
        Sequence seq = new Sequence(a);
        int[] b = new int[]{11, 1, 4, 9, 16, 9, 7, 4, 9};
        //int[] b = new int[]{1, 4, 9, 16, 9, 7, 4, 9, 11};

        Sequence seq1 = new Sequence(b);
        seq.equals(seq1);
        seq.isPermutationOf(seq1);

        System.out.println("Is a the same as b: " + seq.equals(seq1));
        System.out.println("a has the same values as b: " + seq.sameValues(seq1));
        System.out.println("Is b a permutation of a: " +  seq.isPermutationOf(seq1));
    }
}
