package kdu.questhree;

import kdu.ConsoleLogger;

public class Main {
    public static <T> void exchange(T[] arr, int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    public static void main(String[] args){
        Integer[] integerArray = {1,2,3,4,5};
        String[] stringArray = {"abc","def","ghj","ijk","lmn"};
        Float[] floatArray = {1.1F,2.2F,3.3F,4.4F,5.5F};

        exchange(integerArray,2,4);
        exchange(stringArray,2,4);
        exchange(floatArray,2,4);

        ConsoleLogger.infoMethod("Integer Array after exchange:");
        for(int i=0;i<5;i++){
            ConsoleLogger.infoMethod(""+integerArray[i]);
        }

        ConsoleLogger.infoMethod("String Array after exchange:");
        for(int i=0;i<5;i++){
            ConsoleLogger.infoMethod(stringArray[i]);
        }

        ConsoleLogger.infoMethod("Float Array after exchange:");
        for(int i=0;i<5;i++){
            ConsoleLogger.infoMethod(""+floatArray[i]);
        }

    }
}
