package Threads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author shivanidwivedi on 25/08/20
 * @project JavaProgramming
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception{
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }

    public static void main(String[] s){

        //Get ExecutorService from Executors utility class, thread pool size is 10
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //create a list to hold the Future object associated with Callable
        List<Future<String>> list = new ArrayList<>();
        //Create MyCallable instance
        Callable<String> callable = new MyCallable();
        for(int i = 0; i < 100; i++){
            //submit Callable tasks to be executed by thread pool
            Future<String> future = executorService.submit(callable);
            //add Future to the list, we can get return value using Future
            list.add(future);
        }
        for (int i = 0; i < list.size(); i++){
            try{
                //print the return value of Future, notice the output delay in console
                // because Future.get() waits for task to get completed
                System.out.println(new Date()+ "" + list.get(i));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
