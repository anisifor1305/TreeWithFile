package view;


public class CommandSaveFamilyTree implements Commandable {
    View view;

    public CommandSaveFamilyTree(View view){
        this.view = view;
    }
    @Override
    public void execute() {
        view.saveFamilyTree();

    }
    @Override
    public String description() {
        return "Сохранение дерева";
    }
}





