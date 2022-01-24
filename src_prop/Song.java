package src_prop;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.stream.*;
import com.mpatric.mp3agic.*;

import src.BetterDirectory;
import src.BetterFile;

public class Song{

    public Mp3File mp3file;
    public ID3v1 id3v1Tag;
    public BetterFile assoc_btf;
    public String artist;
    public String album;


    //only absolute directory in input
    public Song(String dir_complete) throws IOException, InterruptedException, UnsupportedTagException, InvalidDataException, NotSupportedException
    {
      this.mp3file = new Mp3File(dir_complete);
      this.assoc_btf = new BetterFile(dir_complete);
    }

    public void getAlbumAndArtist() throws IOException, InterruptedException, UnsupportedTagException, InvalidDataException, NotSupportedException
    {
      this.assoc_btf.partial_dir.generate_arr_dir();
      int arr_len = this.assoc_btf.partial_dir.arr_dir.length;

      this.album = this.assoc_btf.partial_dir.arr_dir[arr_len-1];
      this.artist = this.assoc_btf.partial_dir.arr_dir[arr_len-2];
    }

    public void remove_all_tags() throws IOException, InterruptedException, UnsupportedTagException, InvalidDataException, NotSupportedException
    {
      if (this.mp3file.hasId3v1Tag()) {
  		  this.mp3file.removeId3v1Tag();
  		}
  		if (this.mp3file.hasId3v2Tag()) {
  		  this.mp3file.removeId3v2Tag();
  		}
  		if (this.mp3file.hasCustomTag()) {
  		  this.mp3file.removeCustomTag();
  		}
    }

    public void create_new_tags() throws IOException, InterruptedException, UnsupportedTagException, InvalidDataException, NotSupportedException
    {
      this.id3v1Tag = new ID3v1Tag();
  		this.mp3file.setId3v1Tag(this.id3v1Tag);
    }

    public void initialize_tags() throws IOException, InterruptedException, UnsupportedTagException, InvalidDataException, NotSupportedException
    {
      this.remove_all_tags();
      this.create_new_tags();
      this.getAlbumAndArtist();
    }

    public void setParameters() throws IOException, InterruptedException, UnsupportedTagException, InvalidDataException, NotSupportedException
    {
      this.id3v1Tag.setTitle(this.assoc_btf.filename_no_ext);
      this.id3v1Tag.setAlbum(this.album);
  		this.id3v1Tag.setArtist(this.artist);
    }

    public void saveFile() throws IOException, InterruptedException, UnsupportedTagException, InvalidDataException, NotSupportedException
    {
      //after this method the object song is destroyed / corrupted
      String dir_tmp_file = this.assoc_btf.partial_dir.complete_dir+"\\"+"tmp.tmp";
      this.mp3file.save(dir_tmp_file);
      this.assoc_btf.std_file.delete();
      BetterFile btf_tmp = new BetterFile(dir_tmp_file);
      btf_tmp.renameFile(assoc_btf.filename);
    }

    public void rencodeSong() throws IOException, InterruptedException, UnsupportedTagException, InvalidDataException, NotSupportedException
    {
      this.assoc_btf = this.assoc_btf.renameFile_validName();
      this.mp3file = new Mp3File(this.assoc_btf.complete_dir);
      this.initialize_tags();
      this.setParameters();
      this.saveFile();
    }

    public static void main(String args[]) throws IOException, InterruptedException, UnsupportedTagException, InvalidDataException, NotSupportedException
    {
    }
}
