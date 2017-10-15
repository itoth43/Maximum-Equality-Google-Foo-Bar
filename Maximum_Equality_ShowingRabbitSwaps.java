import java.util.ArrayList;

/*If the total # of rabbits cant be evenly distributed among the total
# of train cars then the amount of equally distributed car loads will be
the total # of cars - 1*/

/*Train Class*/
public class MyTrain {
    ArrayList<Integer> trainArr = new ArrayList();

    /*Train Constructor*/
    public MyTrain(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            trainArr.add(arr[i]);
        }
    }

    /*Finds sum of all elements in array (total number of rabbits on the train).*/
    public int sumOfArr() {
        int sum = 0;
        for(int i = 0; i < trainArr.size(); i++) {
            sum += trainArr.get(i);
        }
        return sum;
    }

    /*Returns true if the number of actual equal train cars matches the number
    of expected equal train cars.*/
    public boolean isBalanced(){
        int perCar = sumOfArr() / trainArr.size();
        int carCount = 0;
        int expCount = 0;
        boolean retVal = false;


        /*calculating expected equal car count*/
        if(sumOfArr() % trainArr.size() == 0) {
            expCount = trainArr.size();
        }
        else {
            expCount = trainArr.size() - 1;
        }

        /*counting number of cars matching the value to expected to be in each car*/
        for(int i = 0; i < trainArr.size(); i++){
            if(trainArr.get(i) == perCar) {
                carCount++;
            }
        }

        /*compares expected and actual car count*/
        if(carCount == expCount) {
            retVal = true;
        }
        else {
            retVal = false;
        }
        return retVal;
    }

    /*prints the whole train*/
    public void printTrain() {
        System.out.print("Rabbit Train: ");
        for(int i = 0; i < trainArr.size(); i++) {
            System.out.print("[" + trainArr.get(i) + "]");
        }
        System.out.println();
    }

    /*swaps rabbits until the total number of rabbits are balanced among the train cars*/
    public void reorder(int flag) {
        /*if flag == 1, bunnies can be evenly distributed among cars*/
        if(flag == 1) {
            int perCar = sumOfArr() / trainArr.size();
            System.out.println("RabbitsPerCar: " + perCar);
            /*runs until train is balanced*/
            while(!isBalanced()) {
                for(int i = 0; i < trainArr.size() - 1; i++) {
                    printTrain();
                    /*swaps rabbits if the number in the car is greater than the expected*/
                    if(trainArr.get(i) > perCar) {
                        trainArr.set(i, Integer.valueOf(trainArr.get(i))-1);
                        trainArr.set(i + 1, Integer.valueOf(trainArr.get(i+1))+1);
                    }
                    else if(trainArr.get(i) < perCar && (trainArr.get(i) < trainArr.get(i+1))) {
                        trainArr.set(i, Integer.valueOf(trainArr.get(i)+1));
                        trainArr.set(i + 1, Integer.valueOf(trainArr.get(i+1))-1);
                    }
                    else {
                        continue;
                    }
                }
            }
        }
        /*if flag == 0, bunnies can't be evenly distributed among cars*/
        if(flag == 0) {
            int perCar = sumOfArr() / trainArr.size();

            System.out.println("RabbitsPerCar: " + perCar);
            /*runs until train is balanced*/
            while(!isBalanced()) {
                for(int i = 0; i < trainArr.size() - 1; i++) {
                    printTrain();
                    /*swaps rabbits if the number in the car is greater than the expected*/
                    if(trainArr.get(i) > perCar) {
                        trainArr.set(i, Integer.valueOf(trainArr.get(i))-1);
                        trainArr.set(i + 1, Integer.valueOf(trainArr.get(i+1))+1);
                    }
                    else if(trainArr.get(i) < perCar && (trainArr.get(i) < trainArr.get(i+1))) {
                        trainArr.set(i, Integer.valueOf(trainArr.get(i)+1));
                        trainArr.set(i + 1, Integer.valueOf(trainArr.get(i+1))-1);
                    }
                    else {
                        continue;
                    }
                }
            }
        }
    }
    public int equalCarrCars() {
        int retVal = 0;
        if(sumOfArr() % trainArr.size() == 0) {
            System.out.println("equally distributed.");
            reorder(1);
            retVal = trainArr.size();
        }
        else {
            System.out.println("not equally distributed.");
            reorder(0);
            retVal = trainArr.size() - 1;
        }
        printTrain();
        return retVal;
    }
    public static void main(String args[]) {
        int arr[] = {4, 8, 2};
        MyTrain train = new MyTrain(arr);
        System.out.print("number of equal cars.");
        System.out.print(train.equalCarrCars());
    }
}
