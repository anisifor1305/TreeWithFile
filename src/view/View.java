package view;

import presenter.Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;

import model.FamilyTree;

public class View {

    Scanner scanner = new Scanner(System.in);
    Presenter presenter;

    public void view() {

        List<Commandable> commandList = new ArrayList<>();

        commandList.add(new CommandGetAllHuman(this));
        commandList.add(new CommandSortByName(this));
        commandList.add(new CommandSortByAge(this));
        commandList.add(new CommandGetHumanByName(this));
        commandList.add(new CommandSaveFamilyTree(this));
        commandList.add(new CommandReadFamilyTree(this));
        commandList.add(new CommandAddMember(this));

        for (int i = 0; i < commandList.size(); i++) {
            System.out.println(i + ": " + commandList.get(i).description());
        }

        Scanner scanner = new Scanner(System.in);
        int menuItem = scanner.nextInt();
        commandList.get(menuItem).execute();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void getHumanByName() {
        System.out.println("Введите имя: ");
        Scanner scanner2 = new Scanner(System.in);
        String nameOfHuman = scanner2.nextLine();
        presenter.getHumanByName(nameOfHuman);
    }

    public void getAllHuman() {
        presenter.getAllHuman();
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void saveFamilyTree() {
        presenter.save();
    }
    public void readFamilyTree() {
        FamilyTree tree = presenter.read();
        System.out.println(tree.humanList);
    }
    public void addFTMember() {
        presenter.add();
    }
    
}

