package arrays;

import java.util.*;

public class CommandEnterpreterKatya {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(scanner.nextLine()
                                                                         .split("\\s+")));
        //System.out.println(strings);
        String inputLine;
        while (!(inputLine = scanner.nextLine()).equals("end")) {
            String[] commands = inputLine.split(" ");
            if (commands[0].equals("reverse") || commands[0].equals("sort")) {
                int start = Integer.parseInt(commands[2]);
                int count = Integer.parseInt(commands[4]);
                int end = start + count - 1;
                if (start < 0 || start >= strings.size() || count < 0 || end >= strings.size()) {
                    System.out.println("Invalid input parameters.");
                    continue;
                }

                ArrayList<String> part = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    part.add(strings.get(i));
                }
                if (commands[0].equals("reverse")) {
                    Collections.reverse(part);
                }
                else if (commands[0].equals("sort")) {
                    //Collections.sort(part, String.CASE_INSENSITIVE_ORDER);
                    //[12:55:03] Katya Marincheva: защото C# сортира a A b B c C
                    //[12:55:18] Katya Marincheva: а Java: A B C a b c
                    sortListOfStrings(part);
                }
                for (int i = start; i <= end; i++) {
                    strings.set(i, part.get(i - start));
                }
            }
            else if (commands[0].equals("rollLeft") || commands[0].equals("rollRight")) {
                int rolls = (int) (Long.parseLong(commands[1])) % strings.size();

                if (rolls < 0) {
                    System.out.println("Invalid input parameters.");
                    continue;
                }
                if (commands[0].equals("rollLeft")) {
                    ArrayList<String> part = new ArrayList(strings.subList(0, rolls));
                    strings = new ArrayList(strings.subList(rolls, strings.size()));
                    strings.addAll(part);
                }
                else if (commands[0].equals("rollRight")) {
                    ArrayList<String> part = new ArrayList(strings.subList(0, strings.size() - rolls));
                    strings = new ArrayList(strings.subList(strings.size() - rolls, strings.size()));
                    strings.addAll(part);
                }
            }
            //System.out.println(strings);
        }
        System.out.println(strings);
    }

    // custom Sort from Katya
    public static void sortListOfStrings(List<String> list)
    {
        for(int j=0; j< list.size();j++)
        {
            for (int i=j+1 ; i< list.size(); i++)
            {
                if(list.get(i).compareToIgnoreCase(list.get(j))<0
                        || (list.get(i).compareToIgnoreCase(list.get(j))==0 && list.get(i).compareTo(list.get(j))>0))
                {
                    String temp= list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, temp);
                }
            }
        }
    }
}