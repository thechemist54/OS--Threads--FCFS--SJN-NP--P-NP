/**
 * Name: Aaman Bhandari
 * Due Date: 28 Mar 2019
 * Program: Simulate OS algorithms
 */

import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
public class CPU_Sched {
    public static void main(String[] args) {
       try
       {
           Map<Integer, Integer> mpp1 = new HashMap<>() ; //create maps for ease of use
           Map<Integer, Integer> mpp2 = new HashMap<>();  // for the algorithms
           Map<Integer, Integer> mpp6 = new HashMap<>();
            String filename = "in.txt";
            Scanner inp = new Scanner(new File(filename));
            String[] algo = inp.nextLine().split(" ");
            String algoPSim = algo[0];
            String schelalgo = algo[1].trim();
           System.out.println(schelalgo.trim());


           /**
            * Read input file and pass to respective algorithms
            */
           while(inp.hasNextLine())
            {

                String item = inp.nextLine();
                String[] itmarr = item.split(" ");
                String p = itmarr[0];

                int pid = Integer.parseInt(itmarr[1]);
                int timeStamp = Integer.parseInt(itmarr[2]);
                int cpuBurst = Integer.parseInt(itmarr[3]);
                if(itmarr.length >= 5)
                {
                    int prior = Integer.parseInt(itmarr[4]);
                    mpp6.put(pid, prior);
                }

                mpp1.put(pid,timeStamp);

                mpp2.put(pid,cpuBurst);






            }
            inp.close();

            if(schelalgo.trim().equals("fcfs"))
            {
                Fcfs sol=new Fcfs(mpp1,mpp2,schelalgo);
                sol.fileString();
            }

            else if(schelalgo.trim().equals("sjnnp"))
            {
                Sjnp sol1 = new Sjnp(mpp1, mpp2, schelalgo);
                sol1.fileString();
            }

            else if(schelalgo.trim().equals("pnp"))
            {
                pnp sol2 = new pnp(mpp1, mpp2, mpp6, schelalgo);
                sol2.fileString();
            }



       }
       catch (Exception e) //Exception handling
       {
           System.out.println("File can't be OPENED/READ");

       }
    }
}
