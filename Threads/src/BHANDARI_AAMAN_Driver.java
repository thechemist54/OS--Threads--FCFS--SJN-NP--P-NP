/**
 * Name: Aaman Bhandari
 * Class: Operating Systems
 * CWID: 30084930
 * Due Date: 14th Feb 2019
 */

import java.io.*;    //import the necessary java libraries
import java.util.*;

public class BHANDARI_AAMAN_Driver {

    public static void main (String[] args)
    {
        try
        {
            List<Thread> lii = new ArrayList<>();  // List to keep all thread objects in main method
            System.out.println("Driver: BEGIN!");
            String filename = "in.txt";

            Scanner in = new Scanner(new File(filename)); //open file to read each student's file
            String line1 = in.nextLine();                //and determine number of threads
            in.close();
            String[] line11 = line1.split(" ");
            int no_of_threads = Integer.parseInt(line11[1]);


            for(int i =0; i<no_of_threads; i++)
            {
                BHANDARI_AAMAN_MyThread c1 = new BHANDARI_AAMAN_MyThread(""+i); //start the threads
                c1.start();
                lii.add(c1);
            }

            /**
             * Below for loop will not stop execution of any
             * thread, it will come out of it when all threads are
             * executed.
             * join() allows one thread to wait until another thread
             * completes its execution
             */
            for(int i = 0;i<no_of_threads;i++)
            {
                lii.get(i).join();
            }

            String outp = "";

            /**
             * The code below reads from the respective output files and writes average
             * in one file.
             */
            for (int i = 0; i < no_of_threads; i++)
            {
                Scanner infile = new Scanner(new File("thread" + i + "_out.txt"));
                outp += infile.nextLine().trim() + "\n";
                infile.close();
            }

            PrintWriter out = new PrintWriter(new FileWriter("out.txt"));
            out.println(outp.trim());
            out.close();






            System.out.println("Driver: END!");

        }
        catch (Exception  e)
        {
            System.out.println("The file doesn't exist or can't be opened!!");
        }
    }



}