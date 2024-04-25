package presenter;

import model.FamilyTree;
import model.FileHandler;
import model.Human;
import view.View;
import java.io.Serializable;

public class Main implements Serializable{
    public static void main(String[] args){
        View view = new View();
        FamilyTree<Human> familyTree = new FamilyTree<>();
        Presenter <Human>presenter = new Presenter<>(view, familyTree);

        familyTree.addHuman(new Human("Татьяна", 1951, "f", null, null));
        familyTree.addHuman(new Human("Алексей", 1950, "m", null, null));
        familyTree.addHuman(new Human("Ирина", 1974, "f", null, null));
        familyTree.addHuman(new Human("Александра", 1945, "f"));
        familyTree.addHuman(new Human("Тимофей", 1991, "m", null, null));
        familyTree.addHuman(new Human("Аля", 2003, "f"));
        familyTree.addHuman(new Human("Богдан", 2012, "m", null, null));


        view.setPresenter(presenter);
        view.view();

    }
}
