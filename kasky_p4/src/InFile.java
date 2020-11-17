import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InFile {

    public void inFile(TaskList list) {

        Scanner in = new Scanner(System.in);
        String fileName;
        String line = null;

        System.out.print("File Name: ");
        fileName = in.nextLine();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            if(!reader.ready()) {
                throw new IOException();
            }

            ArrayList<String> tempList = new ArrayList<>();
            ArrayList<TaskItem> newList = new ArrayList<>();

            while((line = reader.readLine()) != null){

                tempList.add(line);

            }

            reader.close();


            for(int i = 0; i < tempList.size(); i = i + 4) {

                list.addItemToList(tempList.get(i+1), tempList.get(i+2), tempList.get(i), Boolean.parseBoolean(tempList.get(i+3)));

            }


        }
        catch (IOException e) {

            System.out.println("WARNING: Could not load list");

        }

    }

}
