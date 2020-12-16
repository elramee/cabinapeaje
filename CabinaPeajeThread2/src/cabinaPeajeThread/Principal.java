package cabinaPeajeThread;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			Peaje peaje= new Peaje();  //establezco una sola instancia de peaje y se la paso a los thread luego, para que todos usen la misma
			
			Thread t1= new Thread(peaje);//inicio los threads
			
			t1.start();
			
			Thread t2= new Thread(peaje);
			
			t2.start();
			
			Thread t3= new Thread(peaje);
			
			t3.start();
			
			Thread t4= new Thread(peaje);
			
			t4.start();
			
			Thread t5= new Thread(peaje);
			
			t5.start();
			
			Thread t6= new Thread(peaje);
			
			t6.start();
			
			Thread t7= new Thread(peaje);
			
			t7.start();

	}

}
