import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void showGuideLine() {
        System.out.println("Argument List: ");
        System.out.println("r = print random studnt list");
        System.out.println("+x = add studnent with name x in the list");
        System.out.println("+X :  add student with name X in the list");
        System.out.println("?X :  search for student named X in the list");
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            showGuideLine();
        }
//		Check arguments
        else if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = bufferedReader.readLine();
                String names[] = line.split(", ");
                for (String name : names) {
                    System.out.println(name);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = bufferedReader.readLine();
                String names[] = line.split(", ");
                Random newRandom = new Random();
                int nextInt = newRandom.nextInt(names.length);
                System.out.println(names[nextInt]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter("students.txt", true));
                String time = args[0].substring(1);
                Date date = new Date();
                String dateformate = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(dateformate);
                String formateDate = dateFormat.format(date);
                bufferedWriter.write(", " + time + "\nList last updated on " + formateDate);
                bufferedWriter.close();
            } catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = bufferedReader.readLine();
                String names[] = line.split(", ");
                boolean done = false;
                String substring = args[0].substring(1);
                for (int indexnumber = 0; indexnumber < names.length && !done; indexnumber++) {
                    if (names[indexnumber].equals(substring)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String readLine = bufferedReader.readLine();
                char toCharArray[] = readLine.toCharArray();
                boolean in_word = true;
                int count = 1;
                int charword = 0;
                for (char charindex : toCharArray) {
                    if (charindex == ' ') {
                        if (in_word) {
                            count++;
                            in_word = false;
                        }
                    } else {
                        if (charindex != ',') {
                            charword++;
                            in_word = true;
                        }
                    }
                }
                System.out.println(count + " word(bufferedReader) found " + charword);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else {
            showGuideLine();
        }
    }
}