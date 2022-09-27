class CustomException extends Exception{
    public CustomException(String msg){
        super(msg);
    }
}

public class StringCalculator {
    public static int add(String numbers) throws CustomException
    {
        int flag = 0;
        String delimiter = ",|\n";
        if (numbers.length() == 0)
            return 0;
        else if (numbers.contains(",\n")||numbers.contains("\n,"))
        {
            throw new CustomException("NLS with comma.");
        }
        else if (numbers.startsWith("//"))
        {
            flag = 1;
        }


        int sum;
        if (flag == 0)
        {
            String nums[] = numbers.split(delimiter);
            sum = LoopSumCalc(nums);
        }
        else
        {
            String halfsplit[] = numbers.split("\n",2);
            delimiter = Del(halfsplit[0]);
            String nums[] = halfsplit[1].split(delimiter);
            sum = LoopSumCalc(nums);
        }
        return sum;
    }



    private static int LoopSumCalc(String[] numbers) throws CustomException
    {
        int sum = 0;
        String negatives = "";
        for (int i = 0; i<numbers.length; i++) {
            if (Integer.parseInt(numbers[i])<0)
                negatives += numbers[i] + ",";
            else if (Integer.parseInt(numbers[i])<1000)
                sum += Integer.parseInt(numbers[i]);
        }
        if (negatives.length() != 0)
            throw new CustomException("Negatives are not allowed: " + negatives);
        return sum;
    }
    private static String Del(String numbers) throws CustomException {
        String delimiter = ",|\\n|";
        int flag = 0;
        for (int i = 0; i<numbers.length(); i++) {
            if (numbers.charAt(i) == ']') {
                flag = 0;
                if (i<(numbers.length()-1))
                    delimiter += "|";
            }
            if (flag == 1) {
                if (Character.isDigit(numbers.charAt(i)))
                    delimiter += numbers.substring(i, i+1);
                else if (Character.isLetter(numbers.charAt(i)))
                    delimiter += numbers.substring(i, i+1);
                else
                    delimiter += "\\" + numbers.substring(i, i+1);
            }
            if (numbers.charAt(i) == '[') {
                flag = 1;
            }

        }
        /*sort delimiters*/
        System.out.println("before: " + delimiter);
        String strList[] = delimiter.split("\\|");
        delimiter = "";
        for (int j=1; j<strList.length; j++){
            for (int i=0; i<strList.length; i++) {
                if (strList[j].length() > strList[i].length()) {
                    String temp = strList[i];
                    strList[i] = strList[j];
                    strList[j] = temp;
                }
            }
        }
        delimiter += strList[0];
        for (int i = 1; i<strList.length; i++){
            delimiter +=  "|" + strList[i];
        }
        System.out.println("after: " + delimiter);
        return delimiter;
    }

    public static void main(String[] args) throws CustomException {
        /*example*/
        System.out.println(StringCalculator.add("//[aa][aaa]\n2aaa8aa10"));
    }
}