public class MyTrain {
    public static int sumOfArr(int arr[]) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public static int equalCarrCars(int train[]) {
        int retVal = 0;
        if(sumOfArr(train) % train.length == 0) {
            retVal = train.length;
        }
        else {
            retVal = train.length - 1;
        }
        return retVal;
    }
    public static void main(String args[]) {
        int arr[] = {1, 4, 1};
        System.out.print(equalCarrCars(arr));
    }
}
