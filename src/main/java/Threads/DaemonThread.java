package Threads;

/**
 * @author shivanidwivedi on 25/08/20
 * @project JavaProgramming
 */
public class DaemonThread extends Thread{
    @Override
    public void run(){
        System.out.println("Running daemon thread");
    }

    public static void main(String[] s){

        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true); // successfully executed
        daemonThread.start();
        daemonThread.setDaemon(true); // throws IllegalThreadStateException, should mark it before start method
    }
}
