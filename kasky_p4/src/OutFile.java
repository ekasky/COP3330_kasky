import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class OutFile {

    static Scanner input = new Scanner(System.in);
    private String file;


    public void getFile() {

        System.out.print("Enter file name: ");
        this.file = input.next();

    }

    public void writeToFile(TaskList list) {

        getFile();
        File fileName = new File(file);

        try {

            FileWriter fileWriter = new FileWriter(fileName);
            Writer output = new BufferedWriter(fileWriter);

            for(int i = 0; i < list.getTaskList().size(); i++) {
                output.write(list.getTaskList().get(i).toString() + " ?" + list.getTaskList().get(i).getComplete() + "\n");
            }

            output.close();

        }
        catch(Exception e) {

            System.out.println("WARNING: Cannot Create file. List not saved");

        }

    }

}
