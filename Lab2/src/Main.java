import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n =0;
        while (true){
            System.out.println("Input number of rows");
            Scanner scn1 = new Scanner(System.in);
            try {
                n= scn1.nextInt();
                break;
            }
            catch (InputMismatchException fg){
                System.out.println("You did not enter a number");
            }
        }
        String[] str = new String[n];
        Scanner scn2 = new Scanner(System.in);

        for(int i=0 ; i < n ; i++) {
            System.out.println("Input row №" +(i+1));
            str[i] = scn2.nextLine();
        }
        int f=0;
        for(int i=0 ; i < str.length ; i++){

            for (int j=i+1 ; j<str.length; j++){
                if(str[i].length() < str[j].length()){
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
            f=f+1;
        }

        for(int i=0 ; i < str.length ; i++){
            if(str[i].length() == str[f-1].length()){
                System.out.println("shortest row = " + str[i] + " length = " +str[i].length());
            }
        }

    }
}