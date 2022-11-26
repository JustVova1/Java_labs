
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args)  {

        Stack<String> stack = new Stack<>();
        try (Scanner scan = new Scanner(new File("input.txt"));
             FileWriter writer = new FileWriter(("output.txt"))) {

            while (scan.hasNextLine()) {
                stack.push(scan.nextLine());
            }

            for (int i = 0; i < stack.size(); i++) {
                writer.write(stack.pop() + "\n");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }



    }

}

//2
//        Scanner scan2 = new Scanner(System.in);
//        int a = scan2.nextInt();
//        Stack<Integer> number = new Stack<>();
//        List<Integer> numers = new ArrayList<>();
//        while (a != 0) {
//            numers.add(a % 10);
//            a /= 10;
//        }
//        for (Integer numer : numers) {
//            number.push(numer);
//        }
//        System.out.println(number);
//
//        //3