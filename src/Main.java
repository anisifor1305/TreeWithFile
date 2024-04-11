
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();


        Human human1 = new Human("Алексей", Gender.Мужской, LocalDate.of(1982, 5, 13));
        Human human2 = new Human("Федор", Gender.Мужской, LocalDate.of(1999, 10, 13));
        Human human3 = new Human("Артём", Gender.Мужской, LocalDate.of(1991, 12, 15));
        Human human4 = new Human("Сергей", Gender.Мужской, LocalDate.of(1993, 11, 9));
        Human human5 = new Human("Петр", Gender.Мужской, LocalDate.of(1995, 2, 20));
        Human human6 = new Human("Александр", Gender.Мужской, LocalDate.of(1993, 3, 10));

        human1.setDod(LocalDate.of(2024, 1, 1));
        human3.setFather(human1);
        human3.setMother(human2);
        human4.setFather(human3);
        human5.setFather(human2);
        human1.addChildren(human3);
        human2.addChildren(human3);
        human3.addSpouse(human5);


        tree.addHumantoTree(human1);
        tree.addHumantoTree(human2);
        tree.addHumantoTree(human3);
        tree.addHumantoTree(human4);
        tree.addHumantoTree(human5);
        tree.addHumantoTree(human6);

        String filePath = "MyFamilyTree.txt";
        FileHandler fileHandler = new FileHandler();
        boolean saveResult = fileHandler.save(tree, filePath);
        if (saveResult) {
            System.out.println("Все сохранено успешно");
        } else {
        System.out.println("Что-то пошло не так");
        }

        FamilyTree readResult = fileHandler.read(filePath);
        if (readResult != null) {
            System.out.println("Объект успешно прочитан из файла");
            System.out.println(readResult);
        } else {
            System.out.println("Ошибка при чтении объекта из файла");
        }




    }




}