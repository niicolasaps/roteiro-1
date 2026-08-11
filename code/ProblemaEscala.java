public class ProblemaEscala {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Iniciando teste de limite do Sistema Operacional...");
        
        int total = 10_000; 
        Thread[] threads = new Thread[total];
        
        for (int i = 0; i < total; i++) {
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        
        // Aguardando todas terminarem
        for (Thread t : threads) {
            if (t != null) {
                t.join();
            }
        }
        
        System.out.println("Finalizou as 10.000 threads!");
    }
}