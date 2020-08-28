package Threads;

/**
 * @author shivanidwivedi on 25/08/20
 * @project JavaProgramming
 *
 * Synchronization problem, actual output with method as synchronized: 5,10,15,20,25,100,200,300,400,500
 */
public class SynchronizationProblem {
    synchronized void printTable(int n){//synchronized method, if we not make the method synchronized, the output would be 5,100,10,200,15,300,20,400,25,5000
        for(int i=1;i<=5;i++){
            System.out.println(n*i);
            try{
                Thread.sleep(400);
            }catch(Exception e){System.out.println(e);}
        }

    }
}
class MyThread1 extends Thread{
    SynchronizationProblem t;
    MyThread1(SynchronizationProblem t){
        this.t=t;
    }
    public void run(){
        t.printTable(5);
    }

}
class MyThread2 extends Thread{
    SynchronizationProblem t;
    MyThread2(SynchronizationProblem t){
        this.t=t;
    }
    public void run(){
        t.printTable(100);
    }
}

class TestSynchronization2{
    public static void main(String args[]){
        SynchronizationProblem obj = new SynchronizationProblem();//only one object
        MyThread1 t1=new MyThread1(obj);
        MyThread2 t2=new MyThread2(obj);
        t1.start();
        t2.start();
    }
}