package zeng.siyuan.reuseutil;

/**
 * Created by SiyuanZeng's on 9/14/2016.
 */
public class r {

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


    public static boolean isNotEmpty(String s ){
        return !s.isEmpty();
    }


    public static String generate(String str) {
        String textStr[] = str.split("\\r\\n|\\n|\\r");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < textStr.length; i++) {
            String s  = textStr[i];
            if(stringBuilder.length()> 0){
                stringBuilder.append("+");
            }

            switch (s.split("")[0]) {
                case "filetype": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "Restrict a search to a given type of file": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "link": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "related": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "info": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "define": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "site": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "allintitle": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "intitle": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "allintext": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "allinurl": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "inurl": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "OR": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "+": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "-": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "~": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "*": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "[#]...[#]": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "daterange": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "\"\"": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "date": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "safesearch": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "cache": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
                case "stocks": if (s.split("")[1].trim().isEmpty()!=true)stringBuilder.append(s); break;
            }
        }

        return String.format("http://www.google.com/#tbs=li:1&q=%s", stringBuilder.toString());
    }


}
