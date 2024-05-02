package presenter;

import java.io.File;
import java.util.Scanner;

import model.FamilyTree;
import model.Human;
import view.View;

import model.FileHandler;


public class Presenter<T extends Human>{
    View view;
    FamilyTree familyTree;

    public Presenter(View view, FamilyTree familyTree) {
        this.view = view;
        this.familyTree = familyTree;

    }
    public void getAllHuman(){
        String allHumans = familyTree.getAllHuman().toString();
        System.out.println(allHumans);
    }

    public void getHumanByName(String nameOfHuman) {
        Human foundHuman = familyTree.getHumanByName(nameOfHuman);
        if (foundHuman != null) {
            System.out.println(foundHuman.toString());
        } else {
            System.out.println("Человек с таким именем не найден.");
        }
    }


    public void sortByAge(){

        familyTree.sortByAge();
        System.out.println(familyTree.getAllHuman());
    }

    public void sortByName(){
        familyTree.sortByName();
        System.out.println(familyTree.getAllHuman());
    }
    public void save(){
        FileHandler fh = new FileHandler();
        fh.setFilename("tree.dat");
        fh.save(familyTree);
    }
    public FamilyTree read(){
        FileHandler fh = new FileHandler();
        fh.setFilename("tree.dat");
        FamilyTree<T> ft = fh.read();
        return ft;
    }
    public void add(){
        FileHandler fh = new FileHandler();
        fh.setFilename("tree.dat");
        FamilyTree<Human> ft = fh.read();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Введите имя");
        String newName = sc1.nextLine();
        System.out.println("Введите год рождения");
        int newYob = sc1.nextInt();
        System.out.println("Введите пол");
        Scanner sc3 = new Scanner(System.in);
        String newGender = sc3.nextLine();
        sc1.close();
        sc3.close();
        Human newHuman = new Human(newName, newYob, newGender, null, null);
        ft.addHuman(newHuman);
        FileHandler fh1 = new FileHandler();
        fh1.setFilename("tree.dat");
        fh1.save(ft);
        System.out.println(ft.humanList);
    }

}


