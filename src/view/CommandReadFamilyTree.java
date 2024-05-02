package view;


public class CommandReadFamilyTree implements Commandable {
    View view;

    public CommandReadFamilyTree(View view){
        this.view = view;
    }
    @Override
    public void execute() {
        view.readFamilyTree();

    }
    @Override
    public String description() {
        return "Чтение дерева";
    }
}





