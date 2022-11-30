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

            String line = getString();
            String names[] = line.split(Constants.delimator);
            for (String name : names) {
                System.out.println(name);
            }
            System.out.println(Constants.loaded);
        } else if (args[0].equals(Constants.random)) {
            System.out.println(Constants.loading);
            String line = getString();
            String names[] = line.split(Constants.delimator);
            Random newRandom = new Random();
            int nextInt = newRandom.nextInt(names.length);
            System.out.println(names[nextInt]);
            System.out.println(Constants.loaded);
        } else if (args[0].contains(Constants.plus)) {
            System.out.println(Constants.loading);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter(Constants.file, true));
                String time = args[0].substring(1);
                Date date = new Date();
                String dateformate = Constants.dateFormat;
                DateFormat dateFormat = new SimpleDateFormat(dateformate);
                String formateDate = dateFormat.format(date);
                bufferedWriter.write(Constants.delimator + time + Constants.update + formateDate);
                bufferedWriter.close();
            } catch (Exception e) {
            }

            System.out.println(Constants.loaded);
        } else if (args[0].contains(Constants.questionMark)) {
            System.out.println(Constants.loading);
            String line = getString();
            String names[] = line.split(Constants.delimator);
            boolean done = false;
            String substring = args[0].substring(1);
            for (int indexnumber = 0; indexnumber < names.length && !done; indexnumber++) {
                if (names[indexnumber].equals(substring)) {
                    System.out.println(Constants.found);
                    done = true;
                }
            }
            System.out.println(Constants.loaded);
        } else if (args[0].contains(Constants.count)) {
            System.out.println(Constants.loading);
            String readLine = getString();
            char toCharArray[] = readLine.toCharArray();
            boolean in_word = true;
            int count = 1;
            int charword = 0;
            for (char charindex : toCharArray) {
                if (charindex == Constants.space) {
                    if (in_word) {
                        count++;
                        in_word = false;
                    }
                } else {
                    if (charindex != Constants.charDelimator) {
                        charword++;
                        in_word = true;
                    }
                }
            }
            System.out.println(count + Constants.wordsFound + charword);
            System.out.println(Constants.loaded);
        } else {
            showGuideLine();
        }
    }
}