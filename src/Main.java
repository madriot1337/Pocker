import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int[] cubes = new int[5];


    public static void main(String[] args) {
        playerMove();


    }


// сделать рнадомайзер для номеров кубиков, а не только для чисел на них. Доделать ход компа [переделать рандомизацию ходов и доделать до конца]

    // ход компьютера
    //проверка хода
    //подсчет очков


    public static void menu() {
        System.out.println("Добро пожаловать в покер! Для начала игры введите 1, для выхода введите 0");
        do {
            String inputStart = scanner.nextLine();
            if (inputStart.equals("1")) {

                break;
            } else if (inputStart.equals("0")) {
                System.exit(0);
            } else {
                System.out.println("Некорректный ввод! Пожалуйста введите одно из значений 1 или 0");
            }
        } while (true);
    }


    public static void playerMove() {
        roll();
        changeValuePlayer();
        checkCombinations();
    }

    public static void computerMove() {
        roll();
        changeValueComputer();
        checkCombinations();

    }


    public static void roll() {
        int count = 1;

        for (int cubeCount : cubes) {
            cubeCount = getRandomDiceValue();
            cubes[count - 1] = cubeCount;
            System.out.println(" [" + count + "]");
            printCubes(cubeCount);
            System.out.println();
            System.out.println();
            count++;
        }
    }


    public static int getRandomDiceValue() {
        return (int) (Math.random() * 6) + 1;
    }

    public static int getRandomQuantity() {
        return (int) (Math.random() * 5);
    }


    public static void printCubes(int count) {
        switch (count) {
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


    public static void changeValuePlayer() {
        String exit = "Чтобы закончить ввод нажмите ENTER еще раз";
        String change = "Вы изменили значение кубика ";
        System.out.println("Введите порядковые номера кубиков, значение которые вы хотели бы изменить через ENTER:");
        ArrayList<Integer> inputList = new ArrayList<>();
        int count = 0;
        int intValue;
        do {
            String value = scanner.nextLine();


            if (value.equals("")) {
                System.out.println(" [1]");
                printCubes(cubes[0]);
                System.out.println();
                System.out.println(" [2]");
                printCubes(cubes[1]);
                System.out.println();
                System.out.println(" [3]");
                printCubes(cubes[2]);
                System.out.println();
                System.out.println(" [4]");
                printCubes(cubes[3]);
                System.out.println();
                System.out.println(" [5]");
                printCubes(cubes[4]);
                break;
            }

            intValue = Integer.parseInt(value);


            for (Integer inputedValue : inputList) {
                if (inputedValue == intValue) {
                    count++;

                }
            }
            if (count > 0) {
                System.out.println("Значение этого кубика вы уже меняли в этом ходу");
            } else {
                if (intValue == 1) {
                    cubes[0] = getRandomDiceValue();
                    System.out.println(change + intValue);
                    System.out.println(exit);
                } else if (intValue == 2) {
                    cubes[1] = getRandomDiceValue();
                    System.out.println(change + intValue);
                    System.out.println(exit);
                } else if (intValue == 3) {
                    cubes[2] = getRandomDiceValue();
                    System.out.println(change + intValue);
                    System.out.println(exit);
                } else if (intValue == 4) {
                    cubes[3] = getRandomDiceValue();
                    System.out.println(change + intValue);
                    System.out.println(exit);
                } else if (intValue == 5) {
                    cubes[4] = getRandomDiceValue();
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

    public static void changeValueComputer() {
        System.out.println("Компьютер выбрал и перебросил кубики \n");
        int changesValue = getRandomQuantity(); // количество исправлений
        int number = getRandomQuantity(); // исправляемый кубик
        int[] cubesNumbersArray = new int[changesValue];
        for (int i = 0; i < changesValue; i++) {
            for (int j = 0; j < changesValue; j++) {
                if (number == cubesNumbersArray[j]) {
                    do {
                        number = getRandomQuantity();
                    } while (number == cubesNumbersArray[j]);
                }
            }
            cubesNumbersArray[i] = number;
        }
        for (int i = 0; i < changesValue; i++) {
            cubes[cubesNumbersArray[i]] = getRandomQuantity();
        }
        System.out.println(" [1]");
        printCubes(cubes[0]);
        System.out.println();
        System.out.println(" [2]");
        printCubes(cubes[1]);
        System.out.println();
        System.out.println(" [3]");
        printCubes(cubes[2]);
        System.out.println();
        System.out.println(" [4]");
        printCubes(cubes[3]);
        System.out.println();
        System.out.println(" [5]");
        printCubes(cubes[4]);

    }


    public static void checkCombinations() {
        int count;
        int value = 0;
        int points = 0;


        //легкие коминации (по значниям)
        for (int i = 0; i < cubes.length; i++) {
            count = 0;
            for (int j = 0; j < cubes.length; j++) {

                if (cubes[i] == cubes[j] && i != j) {
                    count++;
                    value = cubes[i];
                }
            }
            points += count * value;
        }
        System.out.println(points);


    }

}
