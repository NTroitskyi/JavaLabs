
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
            String halfsplit[] = numbers.split("\n");

            delimiter = Del(numbers);
            String nums[] = halfsplit[1].split(delimiter);
            sum = LoopSumCalc(nums);
        }
        return sum;
    }



    private static int LoopSumCalc(String[] numbers) throws CustomException
    {
        int sum = 0;
        String negatives = "";
        for (int i = 0; i<numbers.length; i++)
        {
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
        String delimiter = ",|\n";
        int index_st = 0;
        while (true) {
            index_st = numbers.indexOf("[", index_st) + 1;
            if (index_st == 0) {
                break;
            }
            int index_ed = numbers.indexOf("]", index_st);
            delimiter += "|" + numbers.substring(index_st, index_ed);
        }
        return delimiter;
    }

    public static void main(String[] args) throws CustomException {
        /*example*/
        System.out.println(StringCalculator.add("//[x][yy]\n1x2yy4,1000"));
    }
}
