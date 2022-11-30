import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void showGuideLine() {
        System.out.println(Constants.argumentError);
        System.out.println(Constants.list);
        System.out.println(Constants.a);
        System.out.println(Constants.r);
        System.out.println(Constants.addX);
        System.out.println(Constants.askX);
    }

    public static String getString() {
        String line = Constants.empty;
        try {
            BufferedReader bufferReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(Constants.file)));
            line = bufferReader.readLine();
            bufferReader.close();
        } catch (IOException E) {

        }
        return line;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            showGuideLine();
        }
//		Check arguments
        else if (args[0].equals(Constants.showAll)) {
            System.out.println(Constants.loading);

            String names[] = getString().split(Constants.delimator);
            for (String name : names) {
                System.out.println(name);
            }
            System.out.println(Constants.loaded);
        } else if (args[0].equals(Constants.random)) {
            System.out.println(Constants.loading);
            String names[] = getString().split(Constants.delimator);
            Random newRandom = new Random();
            System.out.println(names[newRandom.nextInt(names.length)]);
            System.out.println(Constants.loaded);
        } else if (args[0].contains(Constants.plus)) {
            System.out.println(Constants.loading);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter(Constants.file, true));  // Improvement BufferWriter
                bufferedWriter.write(Constants.delimator + args[0].substring(1) + Constants.update + new SimpleDateFormat(Constants.dateFormat).format(new Date()));
                bufferedWriter.close();
            } catch (Exception e) {
            }

            System.out.println(Constants.loaded);
        } else if (args[0].contains(Constants.questionMark)) {
            System.out.println(Constants.loading);
            String names[] = getString().split(Constants.delimator);
            String substring = args[0].substring(1);
            for (int indexnumber = 0; indexnumber < names.length; indexnumber++) {
                if (names[indexnumber].equals(substring)) {
                    System.out.println(Constants.found);
                    break;
                }
            }
            System.out.println(Constants.loaded);
        } else if (args[0].contains(Constants.count)) {
            System.out.println(Constants.loading);
            String line = getString(); // Improvement Line
            int count = 1;
            for (Character charind : line.toCharArray()) {
                if (charind == Constants.space) {
                    count++;
                }
            }
            System.out.println(count + Constants.wordsFound + line.length());
            System.out.println(Constants.loaded);
        } else {
            showGuideLine();
        }
    }
}