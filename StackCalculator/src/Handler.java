public class Handler extends Calculate {

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void checkInput(String str, Calculate st) {

        char[] strToArray = str.toCharArray();
        if (strToArray[0] == '#') return;

        else {
            String[] subStr = str.split(" ");

            if (subStr[0].equals("POP")) st.popNum();
            if (subStr[0].equals("PUSH")) {
                if (isNumeric(subStr[1])) st.pushNum(Double.parseDouble(subStr[1]));
                else st.pushNum(st.getMap().get(subStr[1]));
            }
            if (subStr[0].equals("+")) st.addNum();
            if (subStr[0].equals("-")) st.subNum();
            if (subStr[0].equals("*")) st.mulNum();
            if (subStr[0].equals("/")) st.divNum();
            if (subStr[0].equals("SQRT")) st.sqrtNum();
            if (subStr[0].equals("PRINT")) st.printNum();
            if (subStr[0].equals("DEFINE")) st.defineNum(subStr[1], Double.parseDouble(subStr[2]));
        }

    }

}
