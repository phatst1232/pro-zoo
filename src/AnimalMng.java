
import animalpkg.AnimalList;
import animalpkg.AnimalType;
import animalpkg.AnimalTypeList;
import animalpkg.Menu;
import animalpkg.MyScanner;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author phats
 */
public class AnimalMng {

    public static void main(String[] args) {
        String fileTypes = "AnimalTypes.txt";
        String fileAnimals = "Animals.txt";
        Menu mainmenu = new Menu("Managing animals-Main menu:");
        mainmenu.add("Add new animal");
        mainmenu.add("Update animal");
        mainmenu.add("Delete animal");
        mainmenu.add("Search animal");
        mainmenu.add("Show animal list");
        mainmenu.add("Store data to file");
        int mainChoice;
        Menu searchMenu = new Menu("Choose search options:");
        searchMenu.add("Search by name");
        searchMenu.add("Search by type");
        Menu showMenu = new Menu("Choose show options:");
        showMenu.add("Show by type");
        showMenu.add("Show all");
        int subChoice;
        AnimalTypeList typeList = new AnimalTypeList();
        typeList.loadFromFile(fileTypes);
        AnimalList aList = new AnimalList(typeList);
        aList.loadFromFile(fileAnimals);
        boolean changed = false;
        do {
            System.out.println("-------------------------");
            mainChoice = mainmenu.getUserChoice();
            System.out.println("-------------------------");
            switch (mainChoice) {
                case 1:
                    aList.add();
                    changed = true;
                    break;
                case 2:
                    aList.update();
                    changed = true;
                    break;
                case 3:
                    aList.delete();
                    changed = true;
                    break;
                case 4:
                    do {
                        System.out.println("---------------------");
                        subChoice = searchMenu.getUserChoice();
                        System.out.println("---------------------");
                        switch (subChoice) {
                            case 1:
                                aList.printByName();
                                break;
                            case 2:
                                aList.printByType();
                                break;
                        }
                    } while (subChoice > 0 && subChoice <= searchMenu.size());
                    break;
                case 5:
                    do {
                        System.out.println("---------------------");
                        subChoice = showMenu.getUserChoice();
                        System.out.println("---------------------");
                        switch (subChoice) {
                            case 1:
                                aList.printByType();
                                break;
                            case 2:
                                Collections.sort(aList);
                                aList.showAll();
                                break;
                        }
                    } while (subChoice > 0 && subChoice <= showMenu.size());
                    break;
                case 6:
                    aList.writeToFile(fileAnimals);
                    changed = false;
                    break;
                default:
                    if (changed) {
                        boolean response = MyScanner.getBoolean("Save changes to file?");
                        if (response == true) {
                            aList.writeToFile(fileAnimals);
                        }
                    }
            }
        } while (mainChoice > 0 && mainChoice <= mainmenu.size());
    }
}
