package designpattern.u18;

import Ch_1_4._Stopwatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by HuGuodong on 12/13/19.
 */
public class TestAtomic {

  public static void main(String[] args) throws Exception {

    ExecutorService service = Executors.newFixedThreadPool(1000);

    final int NUM = 1000000;
    AtomicLong cnt = new AtomicLong();
    _Stopwatch time = new _Stopwatch();
    for (int i = 0; i < NUM; i++) {
      Runnable r = new Runnable() {
        @Override
        public void run() {
          long i = cnt.incrementAndGet();
        }
      };
      service.execute(r);
    }

    service.shutdown();
    service.awaitTermination(1, TimeUnit.MINUTES);
    System.out.println(time.elapsedTime());
    System.out.println(cnt.get());
  }
}
