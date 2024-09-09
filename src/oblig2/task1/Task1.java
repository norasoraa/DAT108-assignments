package oblig2.task1;

public class Task1 {

  public static void main(String[] args) {

    Message message = new Message("Hallo verden!");
    Thread sender = new Sender(message);
    Thread receiver = new Receiver(message);
    
    sender.start();
    receiver.start();
  }
}
