import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.stream.*;
import com.mpatric.mp3agic.*;
import java.util.Scanner;

import src.BetterDirectory;
import src.BetterFile;
import src_prop.Song;

public class Mp3AutoEncoder{
    public static void main(String args[]) throws IOException, InterruptedException, UnsupportedTagException, InvalidDataException, NotSupportedException
    {
      //Input directory
      String dir_input;
      if(args.length<1){
        Scanner reader = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("(CAUTION) Directory of Music:");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        dir_input = reader.nextLine();
        reader.close();
      }else{
        dir_input = args[0];
      }

      //Execution
      BetterDirectory bttdir_input = new BetterDirectory(dir_input);
      String[] dir_all_files = bttdir_input.dir_of_all_files_in_dir();
      Song actual_song;
      for(int i=0; i<dir_all_files.length; i++)
      {
		    System.out.println(dir_all_files[i]);
        actual_song = new Song(dir_all_files[i]);
        actual_song.rencodeSong();
      }
      System.out.println("ENCODE TERMINATED WITH SUCCESS");
    }
}
