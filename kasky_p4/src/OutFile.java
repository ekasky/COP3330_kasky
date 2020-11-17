import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OutFile {

    public void outFile (TaskList list) {

        Scanner input = new Scanner(System.in);
        System.out.print("File Name: ");
        String fileName = input.next();

        try {

            FileWriter writer = new FileWriter(fileName);

            for(int i = 0 ; i < list.getList().size(); i++) {
                writer.write(list.getItemDate(i) + "\n");
                writer.write(list.getItemTitle(i) + "\n");
                writer.write(list.getItemDescription(i) + "\n");
                writer.write(Boolean.toString(list.getList().get(i).isComplete()) + "\n");
            }

            writer.close();

        }
        catch (IOException e) {
            System.out.println("\nWARNING: Could not write to file\n");
        }

    }

}
