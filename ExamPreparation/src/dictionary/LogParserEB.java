package dictionary;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogParserEB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<String>>> projectErrorsMessages = new HashMap<>();
        Pattern pattern = Pattern.compile("\\{\"Project\": \\[\"(.*)\"\\], \"Type\": \\[\"(.*)\"\\], \"Message\": \\[\"(.*)\"\\]\\}");

        String input;
        while (!(input = scanner.nextLine()).equals("END")) {
            Matcher matcher = pattern.matcher(input);
            matcher.find();
            String projectName = matcher.group(1)
                                        .trim();
            String errorType = matcher.group(2)
                                      .trim();
            String errorMessage = matcher.group(3)
                                         .trim();
            if (!projectErrorsMessages.containsKey(projectName)) {
                projectErrorsMessages.put(projectName, new HashMap<>());
                projectErrorsMessages.get(projectName)
                                     .put("Critical", new ArrayList<>());
                projectErrorsMessages.get(projectName)
                                     .put("Warning", new ArrayList<>());
            }

            projectErrorsMessages.get(projectName)
                                 .get(errorType)
                                 .add(errorMessage);
        }
        Map result = sortByCountOfErrorsDescendingAndThanByProjectName(projectErrorsMessages);
        printResult(result);
    }

    private static Map sortByCountOfErrorsDescendingAndThanByProjectName(Map map) {
        Comparator<Map.Entry<String, Map<String, List<String>>>> customComparator = new Comparator<Map.Entry<String, Map<String, List<String>>>>() {
            @Override public int compare(Map.Entry<String, Map<String, List<String>>> o1, Map.Entry<String, Map<String, List<String>>> o2) {

                Integer o1Size = o1.getValue()
                                   .keySet()
                                   .stream()
                                   .mapToInt(error -> o1.getValue()
                                                        .get(error)
                                                        .size())
                                   .sum();
                Integer o2Size = o2.getValue()
                                   .keySet()
                                   .stream()
                                   .mapToInt(error -> o2.getValue()
                                                        .get(error)
                                                        .size())
                                   .sum();
                Integer result = o2Size.compareTo(o1Size);
                if (result == 0) {
                    return o1.getKey()
                             .compareTo(o2.getKey());
                }
                return result;
            }

        };
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, customComparator);

        Map result = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    private static void printResult(Map<String, Map<String, List<String>>> projectErrorMessage) {
        Comparator<String> orderAcscendingByLength = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer o1Size = o1.length();
                Integer o2Size = o2.length();
                Integer result = o1Size.compareTo(o2Size);
                if (result == 0) {
                    return o1.compareTo(o2);
                }
                return result;
            }
        };

        StringBuilder output = new StringBuilder();
        for (String projectName : projectErrorMessage.keySet()) {
            output.append(String.format("%s:", projectName))
                  .append(System.getProperty("line.separator"));
//            System.out.printf("%s:", projectName)
//                      .println();
            Integer errorSum = projectErrorMessage.get(projectName)
                                                  .keySet()
                                                  .stream()
                                                  .mapToInt(error -> projectErrorMessage.get(projectName)
                                                                                        .get(error)
                                                                                        .size())
                                                  .sum();
            output.append(String.format("Total Errors: %d", errorSum))
                  .append(System.getProperty("line.separator"));
//            System.out.printf("Total Errors: %d", errorSum)
//                      .println();

            Integer criticalErrorMessageCount = projectErrorMessage.get(projectName)
                                                                   .get("Critical")
                                                                   .size();
            Integer waringErrorMessageCount = projectErrorMessage.get(projectName)
                                                                 .get("Warning")
                                                                 .size();
            output.append(String.format("Critical: %d", criticalErrorMessageCount))
                  .append(System.getProperty("line.separator"));
            output.append(String.format("Warnings: %d", waringErrorMessageCount))
                  .append(System.getProperty("line.separator"));
//            System.out.printf("Critical: %d", criticalErrorMessageCount)
//                      .println();
//            System.out.printf("Warnings: %d", waringErrorMessageCount)
//                      .println();
            output.append("Critical Messages:")
                  .append(System.getProperty("line.separator"));
//            System.out.println("Critical Messages:");
            if (criticalErrorMessageCount == 0) {
                output.append("--->None")
                      .append(System.getProperty("line.separator"));
//                System.out.println("--->None");
            }
            else {
                String result = projectErrorMessage.get(projectName)
                                                   .get("Critical")
                                                   .stream()
                                                   .sorted(orderAcscendingByLength)
                                                   .map(message -> String.format("--->%s", message))
                                                   .collect(Collectors.joining("\n"));
                output.append(result)
                      .append(System.getProperty("line.separator"));
//                System.out.println(result);
            }
            output.append("Warning Messages:")
                  .append(System.getProperty("line.separator"));
//            System.out.println("Warning Messages:");
            if (waringErrorMessageCount == 0) {
                output.append("--->None")
                      .append(System.getProperty("line.separator"));
//                System.out.println("--->None");
            }
            else {
                String result = projectErrorMessage.get(projectName)
                                                   .get("Warning")
                                                   .stream()
                                                   .sorted(orderAcscendingByLength)
                                                   .map(message -> String.format("--->%s", message))
                                                   .collect(Collectors.joining("\n"));
                output.append(result)
                      .append(System.getProperty("line.separator"));
//                System.out.println(result);
            }
            output.append(System.getProperty("line.separator"));
//            System.out.println();
        }
        System.out.println(output.toString()
                                 .trim());
    }

}
