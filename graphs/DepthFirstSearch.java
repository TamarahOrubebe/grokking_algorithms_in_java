import java.io.File;

public class DepthFirstSearch {

    public static void printNames(String path) {
        File startFile = new File(path);

        for(File f: startFile.listFiles()){

            if(f.isDirectory()) 
                printNames(f.getAbsolutePath());
             else 
               System.out.println(f.getName());
        }

    }


    public static void main(String[] args) {
        String path = "/home";
        printNames(path);
    }

}

