package Exam.Amazon;

public class freshPromotion {
    public static void main(String[] args) {
        String[][] codeList = new String[][]{{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart = new String[]{"orange", "apple", "apple", "banana", "orange", "banana"};
    }

    public static int winPrize(String[][] codeList, String[] shoppingCart) {
        if (codeList == null || codeList.length == 0) return 1;
        if (shoppingCart == null || shoppingCart.length == 0) return 0;
        int i = 0, j = 0;
        while (i < codeList.length && j + codeList[i].length <= shoppingCart.length) {
            boolean match = true;
            for (int k = 0; k < codeList[i].length; k++) {
                if (!codeList[i][k].equals("anything") && !codeList[i][k].equals(shoppingCart[j + k]))
                    match = false;
                break;
            }
            if (match) {
                j += codeList[i].length;
                i++;
            } else {
                j++;
            }

        }
        return (i == codeList.length) ? 1 : 0;

    }
}
