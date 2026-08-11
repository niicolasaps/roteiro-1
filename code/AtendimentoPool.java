import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AtendimentoPool {
    public static void main(String[] args) {
        System.out.println("Iniciando pool de threads (Parte D)...");
        long tempoInicio = System.currentTimeMillis();


        ExecutorService pool = Executors.newFixedThreadPool(4);


        for (int i = 1; i <= 10; i++) {
            int idCliente = i;
            pool.submit(() -> {
          
                System.out.println(Thread.currentThread().getName() + " atendendo cliente " + idCliente);
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


        pool.shutdown();
        
        try {

            pool.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long tempoFim = System.currentTimeMillis();
        System.out.println("Tempo total: " + (tempoFim - tempoInicio) / 1000 + " segundos");
    }
}