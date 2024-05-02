package view;


public class CommandAddMember implements Commandable {
    View view;

    public CommandAddMember(View view){
        this.view = view;
    }
    @Override
    public void execute() {
        view.addFTMember();

    }
    @Override
    public String description() {
        return "Добавить человека";
    }
}



