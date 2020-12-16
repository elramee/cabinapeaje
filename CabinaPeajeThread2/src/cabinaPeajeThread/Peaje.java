package cabinaPeajeThread;

public class Peaje implements Runnable{
	
	static private int cont=0;//contador hasta 5
	
	static private int contTotal=0;//contador de todos los autos que entran

	public void run() {
		// TODO Auto-generated method stub
		try {
			ejecutarPeaje();//ejecuto el metodo
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void ejecutarPeaje() throws InterruptedException {
		
		contTotal++;
		
		int contTotal2 = contTotal;//asigno a variable de instancia el valor de la variable de clase para identificar auto 1, 2, etc.
		
		int segundos;
		
		while((cont+1)>5) {//para ver que ya no haya cinco autos en el peaje
			
				System.out.println("Esperando "+contTotal2+" ...");
			
				Thread.sleep(20000); //duermo para que no aparezcan miles de esperando hasta que se desocupen las cabinas
	
		}
		
		cont++; //entra auto en caso de no haber cinco autos en el peaje
		
		System.out.println("Entra auto " + contTotal2 +" a atenderse");
		
		do {
			
			segundos=(int)(Math.random()*100000);//uso random para sacar un numero, lo multiplo por 100000 para hacer mas segundos y lo casteo a int para que sea entero, y lo hago hasta que ste entre 20 y 40 segundos
			
		} while(segundos<20000 || segundos>40000);
		
		Thread.sleep(segundos);//lo duermo entre 20 y 40 seg
		
		System.out.println("Auto "+ contTotal2 + " atendido");
		
		cont--;//le quito -1 al desocupar una cabina y cuando se revise el while de arriba, ya no se va a cumplir y va va a poder entrar en el proceso
		
	}
	
	//el syncrhonized no es necesario porque te acepta de a 1, no de a 5
	//en caso de usar el wait y el notify con el respectivo syncrhonized, tengo que solo tener una instancia de la clase donde se encuentra el syncrhonized del metodo o de la variable para todos los threads que haga
	//sino el notify no va a avisar al wait, porque el 1 le pide al 1 que despierte, y el 2 al 2, si hago mas instancia entonces el 2 le pide al 2, no al 1 que es donde estaria el wait()
	//se puede hacer entonces: en la clase implementar runnable y poner el metodo o variable que se sincronizará ahi, y luego se pasa ese runnable a los thread en el main 
	//otra manera es: poniendo el metodo o variable a sincronizar en otro metodo, y pasarle ese unico objeto que se instanciará a los thread que se van a declarar, y dentro de ese thread (extends thread), en el run() se agarrará ese objeto y se ejecutarán los métodos sincronizados, de es manera se tiene un solo metodo instanciado para todos los thread
	
	

}
