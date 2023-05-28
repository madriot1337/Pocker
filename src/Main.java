import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Integer> cubes = new ArrayList<>();
    static int cube_1;
    static int cube_2;
    static int cube_3;
    static int cube_4;
    static int cube_5;


    public static void main(String[] args) {
        menu();

    }




    // ход пользователя

    // ход компьютера
    //проверка хода
    //подсчет очков


    public static void menu() {
        System.out.println("Добро пожаловать в покер! Для начала игры введите 1, для выхода введите 0");
        do {
            String inputStart = scanner.nextLine();
            if (inputStart.equals("1")) {
                roll();
                changeValuePlayer();
                break;
            } else if (inputStart.equals("0")) {
                System.exit(0);
            } else {
                System.out.println("Некорректный ввод! Пожалуйста введите одно из значений 1 или 0");
            }
        } while (true);
    }

    public static void roll() {
        int count = 1;

        cubes.add(cube_1);
        cubes.add(cube_2);
        cubes.add(cube_3);
        cubes.add(cube_4);
        cubes.add(cube_5);

        for (Integer cubeCount : cubes) {
            cubeCount = getRandomDiceNumber();
            System.out.println(" [" +  count + "]");
            printCubes(cubeCount);
            System.out.println();
            System.out.println();
            count++;
        }
    }

    public static int getRandomDiceNumber() {
        return (int) (Math.random() * 6) + 1;
    }

    public static void printCubes(int count){
        switch (count){
            case 1:
                System.out.println(" ___");
                System.out.println("| * |");
                System.out.println("|___|");
                break;
            case 2:
                System.out.println(" ___");
                System.out.println("| * |");
                System.out.println("|_*_|");
                break;
            case 3:
                System.out.println(" ___");
                System.out.println("|* *|");
                System.out.println("|_*_|");
                break;
            case 4:
                System.out.println(" ___");
                System.out.println("|* *|");
                System.out.println("|*_*|");
                break;
            case 5:
                System.out.println(" ___");
                System.out.println("|***|");
                System.out.println("|*_*|");
                break;
            case 6:
                System.out.println(" ___");
                System.out.println("|***|");
                System.out.println("|***|");
                break;
        }
    }

    public static void changeValuePlayer(){
        String exit = "Чтобы закончить ввод нажмите ENTER еще раз";
        String change = "Вы изменили значение кубика ";
        System.out.println("Введите порядковые номера кубиков, значение которые вы хотели бы изменить через ENTER:");
        ArrayList<Integer> inputList = new ArrayList<>();
        int count = 0;
        int intValue;
        do {
            String value = scanner.nextLine();


            if(value.equals("")){
                printCubes(cube_1);
                printCubes(cube_2);
                printCubes(cube_3);
                printCubes(cube_4);
                printCubes(cube_5);
                break;
            }

            intValue = Integer.parseInt(value);


            for(Integer inputedValue : inputList){
                if (inputedValue == intValue){
                    count++;

                }
            }
            if (count > 0){
                System.out.println("Значение этого кубика вы уже меняли в этом ходу");
            } else {
                if (intValue == 1) {
                    cube_1 = getRandomDiceNumber();
                    System.out.println(change + intValue);
                    System.out.println(exit);
                } else if (intValue == 2) {
                    cube_2 = getRandomDiceNumber();
                    System.out.println(change + intValue);
                    System.out.println(exit);
                } else if (intValue == 3) {
                    cube_3 = getRandomDiceNumber();
                    System.out.println(change + intValue);
                    System.out.println(exit);
                } else if (intValue == 4) {
                    cube_4 = getRandomDiceNumber();
                    System.out.println(change + intValue);
                    System.out.println(exit);
                } else if (intValue == 5) {
                    cube_5 = getRandomDiceNumber();
                    System.out.println(change + intValue);
                    System.out.println(exit);
                } else {
                    System.out.println("Введите корректный номер кубика, значение которого хотите заменить и нажмите ENTER");
                }

                if (1 <= intValue && intValue <= 5) {
                    inputList.add(intValue);
                }
            }
            count = 0;
        } while (true);

    }




    public static void checkCombinations() {

    }

}
