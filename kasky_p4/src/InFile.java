import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class InFile {

    static Scanner in = new Scanner(System.in);
    private String fileName;

    private void getFileName() {

        System.out.print("File Name: ");
        this.fileName = in.next();

    }

    public boolean readFile(TaskList list) {

        int i;
        String date = "";
        String title = "";
        String description = "";
        String complete = "";
        String inputString;
        ArrayList<TaskItem> copyList = new ArrayList<>();

        getFileName();

        try {

            BufferedReader input = new BufferedReader(new FileReader(fileName));

            if(!input.ready()) {
                throw new IOException();
            }

            while((inputString = input.readLine()) != null) {

                i = 0;
                date = "";
                title = "";
                description = "";
                complete = "";
                TaskItem task = new TaskItem();

                char[] arr = inputString.toCharArray();

                while(arr[i] != ']') {

                    if(!(arr[i] == '[' || arr[i] == ']')) {
                        date += arr[i];
                    }

                    i++;

                }

                i++;

                while(arr[i] != ':') {

                    i++;

                    if(!(arr[i] == ':')) {
                        title += arr[i];
                    }

                }

                i++;

                while(arr[i] != '?') {

                    i++;

                    if(!(arr[i] == '?')) {
                        description += arr[i];
                    }



                }

                for(int j = i + 1; j < arr.length; j++) {

                    complete += arr[j];

                }


                System.out.println(date);
                System.out.println(title);
                System.out.println(description);
                System.out.println(complete);

                task.setDate(date);
                task.setTitle(title);
                task.setDescription(description);
                task.setComplete(Boolean.parseBoolean(complete));


                copyList.add(task);

            }

            input.close();

            list.setTaskList(copyList);

        }
        catch (IOException e) {
            System.out.println("WARNING: Could not read file");
            return false;
        }

        return true;

    }

}
