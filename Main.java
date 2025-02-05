import java.util.Random;

public class Main {
    public static void main(String[] args){
      
      Thread t1 = new Thread(new ExecOne());
      Thread t2 = new Thread(new ExecTwo());

      t1.start();
      t2.start();
      new Thread(new ExecThree()).start();

      /* 
          [ Multithreading ] คือการทำให้โปรแกรมในแต่ละส่วนสามารถรันพร้อมกันๆได้ ซึ่งสามารถนำมาใช้ในการแบ่งงานหนึ่งเป็นหลายๆส่วนแล้วทำพร้อมกันเพื่อเพิ่มประสิทธิภาพ

          >> Initial behaivior
            -> Threads ทั้งสามจะทำงานพร้อมๆกันทำให้ใน terminal แสดงผลปนกันไป

          >> After adding thread.sleep()
            -> Threads แสดงค่าปนกันเหมือนเดิมแต่ลำดับจะไม่แน่นอนมากขึ้น
                - เช่นเมื่อไม่ได้ใส่ sleep ในหนึ่งช่วงจะมี threads ทั้งสามเลขปนกันไปเพราะทั้งสามตัวจะมีจังหวะทำงานพร้อมๆกัน
                - แต่เมื่อมี sleep ในหนึ่งช่วงอาจเหลือเพียงแค่สองThreadหรือThreadเดียวได้เพราะ ThreadใดThreadหนึ่งอาจสุ่มได้ค่า sleep เยอะ
      */
    }
}

class ExecOne implements Runnable {
  public void run() {
    Random rand = new Random();
    for (int i = 0; i < 50; i++) {
      try{
        Thread.sleep(rand.nextInt(2000 - 51) + 50);
      } catch (InterruptedException e){
        e.printStackTrace();
      }
      System.out.println("thread #1: " + i);
    }
  }
}
class ExecTwo implements Runnable {
  public void run() {
    Random rand = new Random();
    for (int i = 0; i < 50; i++) {
      try{
        Thread.sleep(rand.nextInt(2000 - 51) + 50);
      } catch (InterruptedException e){
        e.printStackTrace();
      }
      System.out.println("thread #2: " + i);
    }
  }
}
class ExecThree implements Runnable {
  public void run() {
    Random rand = new Random();
    for (int i = 0; i < 50; i++) {
      try{
        Thread.sleep(rand.nextInt(2000 - 51) + 50);
      } catch (InterruptedException e){
        e.printStackTrace();
      }
      System.out.println("thread #3: " + i);
    }
  }
}
