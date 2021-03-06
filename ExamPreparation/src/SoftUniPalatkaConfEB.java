import java.util.Scanner;

public class SoftUniPalatkaConfEB {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int peopleNumber = Integer.parseInt(input.nextLine());
        int numberOfEntries = Integer.parseInt(input.nextLine());
        int roomsQuantity = 0;
        int bedsQuantity = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            String[] inputInfo = input.nextLine()
                                      .trim()
                                      .split("\\W+");
            // The input you receive will be in format {tents/food/rooms} {quantity} {type}.
            String tentsFoodRooms = inputInfo[0];
            int quantity = Integer.parseInt(inputInfo[1]);
            String type = inputInfo[2];
            if (tentsFoodRooms.equals("tents") || tentsFoodRooms.equals("rooms")) {
                roomsQuantity += getBedsQuantity(tentsFoodRooms, quantity, type);
            }
            if (tentsFoodRooms.equals("food")) {
                bedsQuantity += getFoodQuantity(quantity, type);
            }
        }
        String otuput = getBalance(peopleNumber, roomsQuantity, bedsQuantity);
        System.out.println(otuput);
    }

    private static int getFoodQuantity(int quantity, String type) {
        // The musaka can feed two, while the zakuska is enough for 0.
        if (type.equals("musaka")) {
            return quantity * 2;
        }
        if (type.equals("zakuska")) {
            return 0;
        }
        return -1;
    }

    private static int getBedsQuantity(String tentsFoodRooms, int quantity, String type) {
        if (tentsFoodRooms.equals("tents")) {
            // normal and firstClass -> for two and three people
            if (type.equals("normal")) {
                return quantity * 2;
            }
            if (type.equals("firstClass")) {
                return quantity * 3;
            }
        }
        if (tentsFoodRooms.equals("rooms")) {
            // Rooms are single, double and triple -> for 1, 2 and 3 people.
            if (type.equals("single")) {
                return quantity * 1;
            }
            if (type.equals("double")) {
                return quantity * 2;
            }
            if (type.equals("triple")) {
                return quantity * 3;
            }
        }
        return -1;
    }

    private static String getBalance(int peopleNumber, int bedsQuantity, int foodQuanity) {
//        �	There are two lines of output. On the first line, print either:
//          o	Everyone is happy and sleeping well. Beds left: {number of beds left}
//          o	Some people are freezing cold. Beds needed: {number of beds needed}
//        �	On the second line, one of two choices:
//          o	Nobody left hungry. Meals left: {number of meals left}
//          o	People are starving. Meals needed: {number of meals needed}
        int bedsLeft = bedsQuantity - peopleNumber;
        int mealsLeft = foodQuanity - peopleNumber;
        StringBuilder output = new StringBuilder();
        if (bedsLeft < 0) {
            output.append(String.format("Some people are freezing cold. Beds needed: %d", Math.abs(bedsLeft)))
                  .append(System.getProperty("line.separator"));
        }
        else {
            output.append(String.format("Everyone is happy and sleeping well. Beds left: %d", bedsLeft))
                  .append(System.getProperty("line.separator"));
        }
        if (mealsLeft < 0) {
            output.append(String.format("People are starving. Meals needed: %d", Math.abs(mealsLeft)))
                  .append(System.getProperty("line.separator"));
        }
        else {
            output.append(String.format("Nobody left hungry. Meals left: %d", mealsLeft))
                  .append(System.getProperty("line.separator"));
        }
        return output.toString();
    }
}

