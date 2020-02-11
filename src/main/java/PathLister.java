import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/** List all files and directories from a specific path.
 *  Input (example):
 *  /users/andrei/IdeaProjects
 *  Output:
 *  exception-handling
 *  .IntelliJ
 *  notes.txt
 */

public class PathLister {

//  Method to list all files and directories from a given path:
    public static void listContent(String searchPath) {

//      Initializing a null List of Paths:
        List<Path> allContent = null;
        try {
//          Initializing a Path object by passing it the method's path string parameter:
            Path filePath = Paths.get(searchPath);
//          Adding ("collecting") directories and files from the given path to the List of Paths:
            allContent = Files.list(filePath).collect(Collectors.toList());

//      If path cannot be found:
        } catch (IOException e) {
            e.printStackTrace();
        }

//      Method's end result - printing out the names of de directories and files:
        for (int i = 0; i < allContent.size(); i++) {
            Path entry = allContent.get(i).getFileName();
            System.out.println(entry);

        }
    }


    public static void main(String[] args) {

//      Calling the listContent static method on the "resources'" path string:
        PathLister.listContent("src/main/resources");

    }
}