import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (n == 0) {
            n = scanner.nextInt();
        }

        int maxElement = 0;
        boolean isFirstEntry = true;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            if (isFirstEntry) {
                maxElement = array[i];
                isFirstEntry = false;
            } else {
                if (maxElement < array[i]) {
                    maxElement = array[i];
                }
            }
        }

        int firstIndexMaxElem = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == maxElement) {
                firstIndexMaxElem = i;
                break;
            }
        }
        System.out.println(firstIndexMaxElem);

    }
}
