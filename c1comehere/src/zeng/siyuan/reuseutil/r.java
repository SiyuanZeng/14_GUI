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
            if(result.length()> 0){
                result.append("+");
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

            if (s.split("")[1].trim().isEmpty()!=true) {
                if(stringBuilder.length()> 0 && i < textStr.length-1){
                    stringBuilder.append(plus);
                }
                switch (s.split("")[0]) {
                    case "filetype": stringBuilder.append(s); break;
                    case "Restrict a search to a given type of file": stringBuilder.append(s); break;
                    case "link": stringBuilder.append(s); break;
                    case "related": stringBuilder.append(s); break;
                    case "info": stringBuilder.append(s); break;
                    case "define": stringBuilder.append(s); break;
                    case "site": stringBuilder.append(s); break;
                    case "allintitle": stringBuilder.append(s); break;
                    case "intitle": stringBuilder.append(s); break;
                    case "allintext": stringBuilder.append(s); break;
                    case "allinurl": stringBuilder.append(s); break;
                    case "inurl": stringBuilder.append(s); break;
                    case "OR": stringBuilder.append(s); break;
                    case "+": stringBuilder.append(s); break;
                    case "-": stringBuilder.append(s); break;
                    case "~": stringBuilder.append(s); break;
                    case "*": stringBuilder.append(s); break;
                    case "[#]...[#]": stringBuilder.append(s); break;
                    case "daterange": stringBuilder.append(s); break;
                    case "\"\"": stringBuilder.append(s); break;
                    case "date": stringBuilder.append(s); break;
                    case "safesearch": stringBuilder.append(s); break;
                    case "cache": stringBuilder.append(s); break;
                    case "stocks": stringBuilder.append(s); break;
                }
        }
    }
        return String.format("http://www.google.com/#tbs=li:1&q=%s", stringBuilder.toString());
}}
