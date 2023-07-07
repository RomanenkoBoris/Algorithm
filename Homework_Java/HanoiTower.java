public class HanoiTower {


    public static void main(String[] args) {

        hanoi(3, 1, 2);

    }
    public static void hanoi (int n, int i, int k){
        if (n == 1){
            System.out.println("Move disk 1 from pin " + i + " to pin " + k);
        } else {
            int tmp = 6 - i - k;
            hanoi(n-1, i, tmp);
            System.out.println("Move disk " + n + " from pin " + i + " to pin " + k);
            hanoi(n-1, tmp, k);
        }
    }
}
