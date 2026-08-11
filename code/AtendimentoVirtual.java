import java.util.concurrent.Executors;

public class AtendimentoVirtual {
    public static void main(String[] args) {
        System.out.println("Iniciando Virtual Threads (Parte E)...");
        
        int total = 100_000;
        
       
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < total; i++) {
                executor.submit(() -> {
                    try {
                       
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } 
        
        System.out.println("As 100.000 tarefas foram processadas sem estourar a memória (Sem OutOfMemoryError)!");
    }
}