class Counter{
  int cnt=0;
  public synchronized void increment(){
    cnt++;
  }
}

public class Threads{
  public static void main(String[] args) throws InterruptedException {
    Counter c=new Counter(); 

    Runnable a = ()->{
      for(int i=0;i<100000;i++){
        c.increment();
      }
    };

    Runnable b = ()->{
      for(int i=0;i<100000;i++){
        c.increment();
      }
    };

    Thread t1=new Thread(a);
    Thread t2=new Thread(b);

    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println(c.cnt);
  }
}
