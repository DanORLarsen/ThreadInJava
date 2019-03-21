import jdk.jshell.Snippet;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Main {
    private final static int GENTAGELSER = 1000;
    private final static int LinjeLaengde = 80;
    private final static int antalThreads = 200;


    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        String[] bogstaver = {"a","b","n","d","e","f","g"};

        for (int i = 0; i < antalThreads; i++) {
            threads.add(new Thread(new Opgave(i,bogstaver[(int) (Math.random()*6)],bogstaver[(int) (Math.random()*6)],bogstaver[(int) (Math.random()*6)])));

        }
        for (int i = 0; i < threads.size()-1; i++) {
           /* if (i - 1 != -1)
            {
            try {
                threads.get(i).join(threads.get(i-1).getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}*/
            threads.get(i).start();

        }


        /*Opgave dan =  new Opgave(100,"A","B","C");
        Opgave daemon =  new Opgave(10000,"T","es","t");

        Thread et = new Thread(dan);
        Thread to = new Thread(daemon);
        to.setDaemon(true);
        et.start();
        to.start();*/




        System.out.println();
        threadExtend aa = new threadExtend("----AA tråden lykkes med extend----");
        aa.setPriority(1);
        aa.start();

        threadExtend oe = new threadExtend("----OE tråden lykkes med extend----");
        oe.setPriority(1);
        oe.start();
    }



    public static class Opgave implements Runnable{
        StringBuilder printText = new StringBuilder();

        int tal;



        public Opgave(int tal, String bogstav1, String bogstav2, String bogstav3) {
            this.tal = tal;
            printText.append("-\"");
            printText.append("ID: "+tal+" - ");
            printText.append(bogstav1);
            printText.append(bogstav2);
            printText.append(bogstav3);
            printText.append("\" ");
        }

        @Override
        public void run() {
            for (int i = 0; i < tal ; i++) {
                System.out.println(printText + "nr "+ (i+1) + " gentagelse-");
            }
        }
    }
    public static class threadExtend extends Thread{
        public String letter;

        public threadExtend(String letter) {
            super();
            this.letter = letter;
        }

        public void run() {
            System.out.println(letter);
        }
    }
}
