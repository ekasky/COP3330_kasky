import java.io.File;
import java.util.Scanner;

public class OutFile {

    static Scanner input = new Scanner(System.in);
    private String fileName;
    private String path;

    public void getFileName() {
        System.out.print("Enter the filename to save as: ");
        this.fileName = input.nextLine();
    }

    public void getPath() {

        getFileName();
        this.path = "/kasky_p4/Lists/" + fileName + ".txt";

    }




}
