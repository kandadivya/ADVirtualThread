import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Main implements Callable<Integer> {
    public static long startTime;
    public static long endTime;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Callable<Integer> callable = new Main();
        Integer resultingInteger = new Integer(0);
        for(int i=0; i< 100; i++) {
            Future<Integer> future = executor.submit(callable);
            resultingInteger += future.get();
        }
        endTime= System.currentTimeMillis();
        System.out.println("Time Taken is "+(endTime - startTime)+" milliseconds.");

        executor.shutdown();

        System.out.println("The final answer: "+resultingInteger);
    }

    @Override
    public Integer call() throws Exception {
        Integer fin = new Integer(0);
        for(int i = 0; i < 1000000; i++)
        {
            fin++;
        }
        return fin;
    }

}
