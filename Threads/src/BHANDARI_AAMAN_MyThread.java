import java.io.*; //import required java libraries
import java.util.*;

public class BHANDARI_AAMAN_MyThread extends Thread {

    public BHANDARI_AAMAN_MyThread(String str)
    {
        super(str);
    }

    public void run ()
    {
        try
        {
            System.out.println("MyThread[" + getName() + "]: BEGIN!");

            /**
             * The below code opens the respective student file
             * calculates average and writes the average in different files.
             */
            String filename = "in.txt";

            Scanner in = new Scanner(new File(filename));

            in.nextLine();
            String[] line2 = in.nextLine().substring(1).trim()
                                         .split(" ");
            in.close();

            Scanner in1 = new Scanner(new File(line2[Integer.parseInt(getName())].trim()));
            double sum = 0;
            double noItem = 0;
            while(in1.hasNextLine())
            {
                int item = Integer.parseInt(in1.nextLine().trim());
                sum+=item;
                noItem++;
            }
            in1.close();

            double avg = sum/noItem;
            PrintWriter out = new PrintWriter(new FileWriter("thread"+getName()+"_out.txt"));

            out.println("Thread["+getName()+"]: "+avg);
            out.close();


            System.out.println("MyThread[" + getName() + "]: END!");
        }

        catch(Exception e)
        {
            System.out.println("The file doesn't exist or can't be opened!!");
        }
    }



}
