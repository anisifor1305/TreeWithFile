
import FamilyTree.FamilyTree;
import Human.Human;
import Writer.FileHandler;
import Human.Gender;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import Dogs.Dog;


public class Main {
    public static void main(String[] args) {
        FamilyTree humanTree = new FamilyTree();
        FamilyTree dogTree = new FamilyTree();

        Human human1 = new Human("Алексей", Gender.Мужской, LocalDate.of(1982, 5, 13));
        Human human2 = new Human("Федор", Gender.Мужской, LocalDate.of(1999, 10, 13));
        Human human3 = new Human("Артём", Gender.Мужской, LocalDate.of(1991, 12, 15));
        Human human4 = new Human("Сергей", Gender.Мужской, LocalDate.of(1993, 11, 9));
        Human human5 = new Human("Петр", Gender.Мужской, LocalDate.of(1995, 2, 20));
        Human human6 = new Human("Александр", Gender.Мужской, LocalDate.of(1993, 3, 10));


        human1.setDod(LocalDate.of(2013, 10, 19));
        human3.setFather(human1);
        human3.setMother(human2);
        human4.setFather(human3);
        human5.setMother(human2);
        human1.addChildren(human3);
        human2.addChildren(human5);
        human3.addSpouse(human5);


        humanTree.addMembertoTree(human1);
        humanTree.addMembertoTree(human2);
        humanTree.addMembertoTree(human3);
        humanTree.addMembertoTree(human4);
        humanTree.addMembertoTree(human5);
        humanTree.addMembertoTree(human6);
        System.out.println(humanTree);
        List<String>NameList = new ArrayList<>();

        for (Object element : humanTree) {
            if (element instanceof Human) {
                Human humanElement = (Human) element;
                NameList.add(humanElement.getName());
            }
        }


        Dog dog1 = new Dog("Боб", Dogs.Gender.Мужской, LocalDate.of(1982, 5, 13));
        Dog dog2 = new Dog("Бобби", Dogs.Gender.Мужской, LocalDate.of(1999, 10, 13));
        Dog dog3 = new Dog("Бобик", Dogs.Gender.Мужской, LocalDate.of(1991, 12, 15));
        Dog dog4 = new Dog("Роберт", Dogs.Gender.Мужской, LocalDate.of(1993, 11, 9));
        Dog dog5 = new Dog("Берт", Dogs.Gender.Мужской, LocalDate.of(1995, 2, 20));

        dog4.setFather(dog1);
        dog4.setMother(dog2);
        dog5.setFather(dog3);
        dog1.addChildren(dog4);
        dog4.addSpouse(dog5);


        dogTree.addMembertoTree(dog1);
        dogTree.addMembertoTree(dog2);
        dogTree.addMembertoTree(dog3);
        dogTree.addMembertoTree(dog4);
        dogTree.addMembertoTree(dog5);

        dogTree.sortByName();
        dogTree.sortByDateOfBirth();
        System.out.println(dogTree);

        }
    }
