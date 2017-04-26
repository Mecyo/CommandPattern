package command;

import interfaces.ICommand;

/**
 *
 * @author aluno
 */
public class CommandSoma implements ICommand{

    private final Calculator receiver;
    private Integer valor = 0;
    private Integer valorOld = 0;

    public CommandSoma(Calculator receiver, Integer valor) {
        this.receiver = receiver;
        this.valorOld = receiver.getResultado();
        this.valor = valor;
    }
    
    @Override
    public void undo() {
        this.receiver.setResultado(this.receiver.getResultado() - this.valor);
    }

    @Override
    public void redo() {
        this.receiver.setResultado(this.receiver.getResultado() + this.valor);
    }
    
}
