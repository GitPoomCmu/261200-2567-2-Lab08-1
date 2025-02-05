public class Main {
    public static void main(String[] args){
      Thread t1 = new Thread(new ExecOne());
      Thread t2 = new Thread(new ExecTwo());

      t1.start();
      t2.start();
      new Thread(new ExecThree()).start();

      /* 
          [ Initial behaivior ]
            -> Threads ทั้งสามจะทำงานพร้อมๆกันทำให้ใน terminal แสดงผลปนกันไป

          [ After adding thread.sleep() ]
            -> Threads แสดงค่าปนกันเหมือนเดิม แต่ลำดับจะขึ้นอยู่กับระยะการ sleep ของ Thread แต่ละตัว
                -> โดย Threads ที่มีค่า sleep น้อยจะแสดงค่าขึ้นมาถี่กว่า
      */
    }
}

class ExecOne implements Runnable {
  public void run() {
    for (int i = 0; i < 50; i++) {
      try{
        Thread.sleep(500); // 0.5 second
      } catch (InterruptedException e){
        e.printStackTrace();
      }
      System.out.println("thread #1: " + i);
    }
  }
}
class ExecTwo implements Runnable {
  public void run() {
    for (int i = 0; i < 50; i++) {
      try{
        Thread.sleep(1000); // 1 second
      } catch (InterruptedException e){
        e.printStackTrace();
      }
      System.out.println("thread #2: " + i);
    }
  }
}
class ExecThree implements Runnable {
  public void run() {
    for (int i = 0; i < 50; i++) {
      try{
        Thread.sleep(1500); // 1.5 seconds
      } catch (InterruptedException e){
        e.printStackTrace();
      }
      System.out.println("thread #3: " + i);
    }
  }
}
