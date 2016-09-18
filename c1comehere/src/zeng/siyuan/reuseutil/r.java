package zeng.siyuan.reuseutil;

/**
 * Created by SiyuanZeng's on 9/14/2016.
 */
public class r {

    public final static String INTEXT_HYPHEN = "intext:";
    public static final String PLUGS = "+";
    public static final String SPACE = " ";

    public static void resetfiles() {
        String inntuitive = "";
        inntuitive +=  "datatypeps:(";
        inntuitive +=  "\n";
        inntuitive +=  "I dont want&";
        inntuitive +=  "\n";
        inntuitive +=  "parameters$";
        inntuitive +=  "\n";
        inntuitive +=  "variables#";
        inntuitive +=  "\n";
        inntuitive +=  "actions%";
        inntuitive +=  "\n";
        inntuitive +=  "impport*";
        inntuitive +=  "\n";
        inntuitive +=  "(optionalstackoverflow)First step 1:c1cometome:this is what yourwelcome want";
        inntuitive +=  "\n";
        inntuitive +=  "(optional documentation)First step 1:c1cometome:this is what yourwelcome want";
        inntuitive +=  "\n";
        inntuitive +=  "(optional everywhere)First step 1:c1cometome:this is what yourwelcome want";
        //  textArea.setText(inntuitive);
    }


/*


    String textStr[] = textTrs.split("\\r\\n|\\n|\\r");
    String intext = "+intext";
    String datatypes = textStr[0].trim().replace("datatypeps:(", "intext").replace(SPACE, "+AND"+intext);
    String idontwant = textStr[1].trim().replace("I dont want&", "+-").replace(SPACE, "+AND"+"+-");
    String datatypes1 = textStr[2].trim().replace("parameters$", intext).replace(SPACE, "+AND"+intext);
    String datatypes2 = textStr[3].trim().replace("variables#", intext).replace(SPACE, "+AND"+intext);
    String datatypes3 = textStr[4].trim().replace("actions%", intext).replace(SPACE, "+AND"+intext);
    String iomport = textStr[5].trim().replace("impport*", intext).replace(SPACE, "+AND"+intext);
    String c1cometome1 = textStr[6].trim().replace("how to","").replace("How to", "").replace("(optionalstackoverflow)First step 1:c1cometome:this is what yourwelcome want", "intext").replace(SPACE, "+AND"+intext);
    String c1cometome2 = textStr[7].trim().replace("how to","").replace("How to", "").replace("(optional documentation)First step 1:c1cometome:this is what yourwelcome want", "intext").replace(SPACE, "+AND"+intext);
    String c1cometome3 = textStr[8].trim().replace("how to","").replace("How to", "").replace("(optional everywhere)First step 1:c1cometome:this is what yourwelcome want", "intext").replace(SPACE, "+AND"+intext);


*/


    public static boolean isNotNullOrEmpty(String s){
        if(null==s){
            return false;
        }
        return !s.isEmpty();
    }
    public static final String plusANDplus = "+AND+";
    public static final String plusANDplusintextcolon = "+AND+intext:";
    public static final String plus= "+";

    public static String splitStringandAddOnebyone(String str){
        StringBuilder result = new StringBuilder();

        for(String s: str.split(" ")){
                if(result.length()> 0){
                    result.append(plusANDplusintextcolon);
                }
            result.append(s);
        }
        return result.toString();
    }


    public static String splitStringandAddOnebyoneonlyplussign(String str){


        StringBuilder result = new StringBuilder();

        for(String s: str.split(" ")){
                if (result.length() > 0) {
                    result.append(plus);
                }

                result.append(s);

            }
        return result.toString();

    }




    public static String generate(String str) {
        String textStr[] = str.split("\\r\\n|\\n|\\r");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < textStr.length; i++) {
            String s  = textStr[i];

            if (s.split(":").length >1 && s.split(":")[1].trim().isEmpty()!=true) {
                if(stringBuilder.length()> 0){
                    stringBuilder.append(plus);
                }

                String keyword = s.split(":")[0];
                String keysearchstring = s.split(":")[1];

                switch (s.split(":")[0]) {
                    case "filetype": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "Restrict a search to a given type of file": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "link": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "related": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "info": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "define": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "site": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "allintitle": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "intitle": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "allintext": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "allinurl": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "inurl": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "OR": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "+": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "-": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "~": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "*": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "[#]...[#]": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "daterange": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "\"\"": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, r.INTEXT_HYPHEN)); break;
                    case "date": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "safesearch": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "cache": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                    case "stocks": stringBuilder.append(generateStringSplitAndCombine(keysearchstring, keyword)); break;
                }
        }
    }
        return String.format("http://www.google.com/#tbs=li:1&q=%s", stringBuilder.toString());
}

    private static String generateStringSplitAndCombine(String s, String keyword) {
            StringBuilder result = new StringBuilder();
            result.append(keyword);

        for (int i = 0; i < s.trim().split(" ").length; i++) {
                result.append(s.trim().split(" ")[i]);

            if(i<s.trim().split(" ").length-1)
            result.append(plusANDplus+keyword);

            }
            return result.toString();
    }
}
