import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Path dir = new File("Z:\\Baseball\\Data\\BSON\\Body29\\BTC BSONs").toPath();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry: stream) {
                File file = entry.toFile();
                System.out.println(file.getName());
                Pattern p = Pattern.compile("([0-9]{15})(.*?)(\\.bson)");
                Matcher m = p.matcher(file.getName());
                if(m.matches()){
                    String renamedFileString = m.group(1) +".bson";
                    System.out.println(renamedFileString);
                    File renamedFile = new File(file.getParentFile() + "/" + renamedFileString);
                    System.out.println(renamedFile);
                   if( file.renameTo(renamedFile)){
                       System.out.println("Successfully renamed");
                   } else {
                       System.out.println("Files renamed");
                   }
                }
            }
        }catch (IOException e) {

        }

    }

    }
