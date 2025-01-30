import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Mars {
    public static void main(String[] args) {
        /* PRE- COMMITS
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
         */

        /* LEVEL 0. Rename, Greet, Exit
        System.out.println("____________________________________________________________\n" +
                " Hello! I'm Mars\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n" +
                " Bye. Hope to see you again soon!\n" +
                "____________________________________________________________"); */
        Mars mars = new Mars();
        // mars.echo();
        mars.store();
    }

    /*Level 1. Echo*/
    private void echo(){
        System.out.println(" Hello! I'm Mars\n What can I do for you?");
        Scanner reader = new Scanner(System.in);
        String n = reader.nextLine();

        while(!n.equals("bye")){
            System.out.println("____________________________________________________________\n" +
                                n +
                                "\n____________________________________________________________\n");
            n = reader.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
        reader.close();
    }

    /*Level 2. Add, List */
    private void store(){
        List<String> arrayList = new ArrayList<String>();
        System.out.println(" Hello! I'm Mars\n What can I do for you?\n");
        Scanner reader = new Scanner(System.in);
        String n = reader.nextLine();
        while(!n.equals("bye")){
            if(n.equals("list")){
                Mars.list(arrayList);
            }
            else {
                arrayList.add(n);
                String output = "____________________________________________________________\n" +
                        "added: " + n +
                        "\n____________________________________________________________\n";
                System.out.println(output);
            }
            n = reader.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
        reader.close();
    }

    private static void list(List<String> lst){
        Object[] strArray = lst.toArray();
        System.out.println("____________________________________________________________\n");
        int i = 1;
        while(i <= strArray.length){
            System.out.println(i + "." + strArray[i-1]);
            i += 1;
        }
        System.out.println("____________________________________________________________\n");
    }
}
