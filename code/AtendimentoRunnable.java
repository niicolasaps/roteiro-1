public class AtendimentoRunnable implements Runnable {
    int idCliente;


    public AtendimentoRunnable(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public void run() {
        System.out.println("atendendo cliente " + idCliente);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Iniciando atendimentos (Parte B)...");
        

        Runnable r = new AtendimentoRunnable(1);
        

        Thread t = new Thread(r, "Atendente-1");
        

        t.start();
    }
}