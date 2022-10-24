import java.util.*;

public class Grafo {
    public static void main(String[] args) {
        Hashtable<String, ArrayList<String>> tabela =
                new Hashtable<String, ArrayList<String>>();

        ArrayList<String> caminhoJuan
                = new ArrayList<String>();
        caminhoJuan.add("Maria");


        ArrayList<String> caminhoMilena
                = new ArrayList<String>();
        caminhoMilena.add("Juan");
        caminhoMilena.add("Maria");

        ArrayList<String> caminhoAndres
                = new ArrayList<String>();
        caminhoAndres.add("Maria");

        ArrayList<String> caminhoJavier
                = new ArrayList<String>();
        caminhoJavier.add("Milena");
        caminhoJavier.add("Juan");
        caminhoJavier.add("Maria");


        tabela.put("Juan", caminhoJuan);
        tabela.put("Milena", caminhoMilena);
        tabela.put("Andres", caminhoAndres);
        tabela.put("Javier", caminhoJavier);

        showData(tabela);

        System.out.println(pesquisaEmLargura(tabela, "Juan"));
    }

    private static String pesquisaEmLargura(Hashtable<String, ArrayList<String>> tabela, String verticeInicial){
        Queue<String> fila = new LinkedList<String>();
        ArrayList<String> verificados = new ArrayList<String>();

        fila = enfileirar(fila, (ArrayList<String>)tabela.get(verticeInicial));

        while(fila.size() > 0){
            String pessoa = fila.poll();

            if ("Maria".equals(pessoa))
                return "Maria foi encontrada!";

            if (verificados.contains(pessoa))
                continue;

            fila = enfileirar(fila, (ArrayList<String>)tabela.get(pessoa));
            verificados.add(pessoa);
        }

        return "Maria não foi encontrada!";
    }

    private static Queue<String> enfileirar(Queue<String> fila, ArrayList<String> lista){
        if (lista == null)
            return fila;

        for (String item : lista){
            fila.offer(item);
        }

        return fila;
    }

    private static void showData(Hashtable<String, ArrayList<String>> tabela){
        for (Map.Entry<String, ArrayList<String>> entry : tabela.entrySet()){
            String chave = entry.getKey();
            ArrayList<String> dados = entry.getValue();

            System.out.println("Caminho: " + chave + " Encontra: " + dados);
        }
    }
}