import static javax.sound.sampled.AudioSystem.getAudioInputStream;

import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip; 
 
/* 
    To compile: javac SpotifyLikeApp.java 
    To run: java SpotifyLikeApp 
 */ 
 
// declares a class for the app 
public class SpotifyLikeApp { 
 
    private static final boolean Favorite = false;
    private static final boolean IsFavorite = false;
    // global variables for the app 
    String status; 
    Long position; 
    static Clip audioClip; 
    static String song = "./Music/Checkie Brown.wav"; 
    static Boolean Playing = false; 
    //private static Clip clip; 
   // private static Object name; 
    //private static Object artist; 
    //private static Object image; 
 
    // "main" makes this class a java app that can be executed 
    public static void main(final String[] args) { 
 
        // create a scanner for user input 
        Scanner input = new Scanner(System.in); 
        String userInput = ""; 
 
        while (!userInput.equals("q")) { 
 
            menu(); 
 
            // get input 
            userInput = input.nextLine(); 
            // accept upper or lower case commands 
            userInput.toLowerCase(); 
            // do something 
            handleMenu(userInput); 
 
        } 
 
        // close the scanner 
        input.close(); 
 
    } 
 
    /* 
     * displays the menu for the app 
     */ 
    public static void menu() { 
 
        System.out.println("---- SpotifyLikeApp ----"); 
        System.out.println("[H]ome"); 
        System.out.println("[S]earch by title"); 
        System.out.println("[L]ibrary"); 
        System.out.println("[P]lay"); 
        System.out.println("[Q]uit"); 
        System.out.println("[F]avorite");
        System.out.print("Enter q to quit:"); 
 
    } 
 
    /* 
     * handles the user input for the app 
     */ 
    public static void handleMenu(String userInput) { 
 
        switch(userInput) { 
 
            case "h": 
                System.out.println("-->Home<--"); 
                break; 
 
            case "s": 
                System.out.println("-->Search by title<--"); 
                Search(); 
                break; 
 
            case "l": 
                System.out.println("-->Library<--"); 
                break; 
                 
            case "p": 
                System.out.println("-->Play<--"); 
                play(song); 
                break; 
            case "f":
                System.out.println("-->Favorite<--");
                Search();
            case "q": 
                System.out.println("-->Quit<--"); 
                break; 
             
            default: 
                break; 
        } 
 
    } 
 
    /* 
     * plays an audio file 
     */ 
    public static void play(String song) { 
        // open the audio file 
        File file = new File(song); 
        try { 
             if (Playing == true) 
             { 
                 audioClip.stop(); 
               Playing = false; 
              
            }
     // create clip  
     audioClip = AudioSystem.getClip(); 
     // get input stream 
     final AudioInputStream in = getAudioInputStream(file); 
     audioClip.open(in); 
     audioClip.setMicrosecondPosition(0); 
     audioClip.loop(Clip.LOOP_CONTINUOUSLY); 
     Playing = true; 
 } catch(Exception e) { 
     e.printStackTrace();
 }  
  
 } 

    public static void Rewind()  
    { 
        Scanner input = new Scanner(System.in); 
        audioClip.stop(); 
        System.out.println(audioClip.getMicrosecondPosition()); 
        System.out.println("How far back would you like to go? + \n");


Long Rewound = (input.nextLong()*1000); 
        Long CurrentTime = audioClip.getMicrosecondPosition(); 
        Long NewTime = CurrentTime - Rewound; 
        audioClip.setMicrosecondPosition(NewTime); 
        audioClip.loop(Clip.LOOP_CONTINUOUSLY); 
        System.out.println(audioClip.getMicrosecondPosition()); 
    } 
 
    public static void Search() { 
        String[] Songlist; 
        Songlist = new String[10]; 
        Songlist[0] = "./Music/Checkie Brown.wav";
        Songlist[1] = "./Music/Dee_Yan-Key_-_10_-_vacaciones_salsa.wav"; 
        Songlist[2] = "./Music/Bisou_-_04_-_Journey_of_King.wav";
        Songlist[3] = "./Music/Mid-Air_Machine_-_Burn_It_Down.wav";
        Songlist[4] = "./Music/Scott_Holmes_-_Storybook.wav";
        Songlist[5] = "./Music/Ava_Luna_-_02_-_Cement_Lunch.wav";
        Songlist[6] = "./Music/The_Dubbstyle_-_05_-_Zumbido.wav";
        Songlist[7] = "./Music/Shot Full of Love(Don Williams)Lyrics.wav";
        Songlist[8] = "./Music/Kitkat_Club_-_02_-_Welcome.wav";
        Songlist[9] = "./Music/Kathleen_Martin_-_02_-_El_Preso_Numero_Nueve.wav";
 
        for(int k = 0; k < Songlist.length; k++) 
        { 
            int a = k+1; 
            System.out.println(a + Songlist[k]); 
        } 
         
        System.out.println("Please choose a song"); 
        Scanner Selection = new Scanner(System.in); 
        int Choice; 
        Choice = Selection.nextInt() - 1; 
        song = Songlist[Choice]; 
         
    } 
 
 
 
 
}

