package task11;
class Cafeteria {
    private int totalSeats;

    public Cafeteria(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public synchronized void bookTable(int numberOfSeats) {
        if (totalSeats >= numberOfSeats) {
            System.out.println(numberOfSeats + " seats booked successfully");
            totalSeats -= numberOfSeats;
            System.out.println("Remaining seats: " + totalSeats);
        } else {
            System.out.println("Sorry, all tables are booked.");
        }
    }
}
public class task1 extends Thread{

	
	    private Cafeteria cafeteria;
	    private int numberOfSeats;

	    public task1(Cafeteria cafeteria, int numberOfSeats) {
	        this.cafeteria = cafeteria;
	        this.numberOfSeats = numberOfSeats;
	    }

	    public void run() {
	        cafeteria.bookTable(numberOfSeats);
	    }

	    public static void main(String[] args) {
	        Cafeteria cafeteria = new Cafeteria(5);

	        task1 customer1 = new task1(cafeteria, 3);
	        task1 customer2 = new task1(cafeteria, 2);
	        task1 customer3 = new task1(cafeteria, 1);

	        customer1.start();
	        customer2.start();
	        customer3.start();
	    }
	}


