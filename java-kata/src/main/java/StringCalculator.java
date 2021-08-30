
public class StringCalculator {

    public int calculate(String string) {
        if (string.isEmpty()) {
            return 0;
        } else {
            var tokens = string.split(",|\\n");

            return sumFromTokens(tokens);
        }
    }

    private int sumFromTokens(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            var summand = Integer.parseInt(token);
            
            validateInput(summand);
                
            if(summand <= 1000)
                sum += summand;
        }
        return sum;
    }


    private void validateInput(int input)
    {
        if(input < 0)
            throw new IllegalArgumentException("Number must not be negative.");
    }
}
