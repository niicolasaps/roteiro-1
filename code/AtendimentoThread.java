public class AtendimentoThread extends Thread {
    int idCliente;


    public AtendimentoThread(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public void run() {
        System.out.println(getName() + " atendendo cliente " + idCliente);
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Iniciando atendimentos (Parte A)...");
        long tempoInicio = System.currentTimeMillis();

     
        for (int i = 1; i <= 5; i++) {
            var t = new AtendimentoThread(i);
            t.start(); 
            t.join();  
        }

        long tempoFim = System.currentTimeMillis();
        System.out.println("Tempo total: " + (tempoFim - tempoInicio) / 1000 + " segundos");
    }
}