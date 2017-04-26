package command;

import interfaces.ICommand;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class Calculator {

    private List<ICommand> listaCommands = new ArrayList<>();
    private Integer resultado = 0;
    private Integer index = 0;

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }

    public void somar(Integer valor) {
        if(verificaIndice()) {
            atualizaLista();
        }
        listaCommands.add(new CommandSoma(this, valor));
        listaCommands.get(index++).redo();
    }

    public void subtrair(Integer valor) {
        if(verificaIndice()) {
            atualizaLista();
        }
        listaCommands.add(new CommandSubtracao(this, valor));
        listaCommands.get(index++).redo();
    }

    public void dividir(Integer valor) {
        if(verificaIndice()) {
            atualizaLista();
        }
        listaCommands.add(new CommandDivisao(this, valor));
        listaCommands.get(index++).redo();
    }

    public void multiplicar(Integer valor) {
        if(verificaIndice()) {
            atualizaLista();
        }
        listaCommands.add(new CommandMultiplicacao(this, valor));
        listaCommands.get(index++).redo();
    }

    public void retornar() {
        Integer posicao = index - 1;
        if (posicao >= 0) {
            listaCommands.get(posicao).undo();
            index--;
        }
    }

    public void avancar() {
        if (listaCommands.size() > 0 && index < listaCommands.size()) {
            listaCommands.get(index++).redo();
        }
    }
    
    private boolean verificaIndice() {
        if(index <= listaCommands.size() - 1) {
            return true;
        }
        return false;
    }
    
    private void atualizaLista() {
        for (int i = index; i < listaCommands.size(); i++) {
            listaCommands.remove(i);
        }
    }

}
