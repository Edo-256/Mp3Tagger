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
      Scanner reader = new Scanner(System.in);
      System.out.println("-----------------------------------------------------------------------------------------------------------------------");
      System.out.println("Prima di avviare questo sistemare per bene i nomi e le estensioni delle canzoni, e metterli opportune directory");
      System.out.println("Questo prog corregge automaticam nomi invalidi ma x evitare troppi _ correggerli un attimo a occhio prima");
      System.out.println("Anche perchè ricordiamo che nome file diventerà titolo della canzone");
      System.out.println("-----------------------------------------------------------------------------------------------------------------------");
      System.out.println("Directory nella quale verrano encodati tutti file automaticamente");
      System.out.println("-----------------------------------------------------------------------------------------------------------------------");
      String dir_input = reader.nextLine();
      reader.close();

      BetterDirectory bttdir_input = new BetterDirectory(dir_input);
      String[] dir_all_files = bttdir_input.dir_of_all_files_in_dir();
      Song actual_song;

      for(int i=0; i<dir_all_files.length; i++)
      {
		System.out.println(dir_all_files[i]);
        actual_song = new Song(dir_all_files[i]);
        actual_song.rencodeSong();
      }

      System.out.println("ENCODE TERMINATO CON SUCCESSO");
    }
}
