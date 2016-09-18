package zeng.siyuan.betteresearchennebetterthangoogleandfindweehtehrething.findessentioal;

import zeng.siyuan.C1comehere.Search;
import zeng.siyuan.reuseutil.r;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

/**
 * Created by SiyuanZeng's on 9/8/2016.
 */
public class findtheshortcut {


    public void returnshowsearchquetsry() {

        /*
               String iomport = textStr[0].trim().replace("impport*", intext).replace(SPACE, "+" + intext) + "+" + intext;
        String datatypes = textStr[1].trim().replace("datatypeps:(", intext).replace(SPACE, "+" + intext) + "+" + intext;
        String datatypes1 = textStr[2].trim().replace("parameters$", intext).replace(SPACE, "+" + intext) + "+" + intext;
        String datatypes2 = textStr[3].trim().replace("variables#", intext).replace(SPACE, "+" + intext) + "+" + intext;
        String datatypes3 = textStr[4].trim().replace("actions%", intext).replace(SPACE, "+" + intext) + "+" + intext;
        String idontwant = textStr[5].trim().replace("I dont want&", intext).replace(SPACE, "-");

         */

        resetfiles();
    }


    public void gogolesearchgsearch() {
        try {
            Search searchEngines = null;
            if (null != textArea && !("".equalsIgnoreCase(textArea.getText().trim()))) {
                Desktop.getDesktop().browse(new URI(generate(textArea.getText().trim())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //bombine things when there are multiple instance and class rleatived activity the class  tieh the owern er ot he actitiviets


    }
    public static void resetfiles() {
        String  inntuitive = "";
        inntuitive += "subjects(why does):";
        inntuitive += "\n";
        inntuitive += "subjects(what is):";
        inntuitive += "\n";
        inntuitive += "subjects(how to):";
        inntuitive += "\n";
        inntuitive += "operation:";
        inntuitive += "\n";
        inntuitive += "os:";
        inntuitive += "\n";
        inntuitive += "filetype:";
        textArea.setText(inntuitive);
    }

    public static String predefined = "shortcut keyboard";

    public static JTextArea textArea;

    public findtheshortcut(JTextArea textArea) {
        this.textArea = textArea;
    }




    public static String generate(String str) {
        String textStr[] = str.split("\\r\\n|\\n|\\r");
        StringBuilder stringBuilder = new StringBuilder();

        // fin dthe first tone that doesn't have content


        for (int i = 0; i < textStr.length; i++) {
            String s  = textStr[i];
            if(s.split(":").length>1 ){
                if (s.split(":")[1].trim().isEmpty()!=true) {
                if(stringBuilder.length() > 0 ){
                    stringBuilder.append(r.plusANDplus);
                }
                switch (s.split(":")[0]) {
                    case "subjects(why does)": stringBuilder.append(r.INTEXT_HYPHEN + s.split(":")[1].trim().replace(r.SPACE, r.plusANDplusintextcolon)); break;
                    case "subjects(what is)": stringBuilder.append(r.INTEXT_HYPHEN + s.split(":")[1].trim().replace(r.SPACE, r.plusANDplusintextcolon)); break;
                    case "subjects(how to)": stringBuilder.append(r.INTEXT_HYPHEN + s.split(":")[1].trim().replace(r.SPACE, r.plusANDplusintextcolon)); break;
                    case "operation": stringBuilder.append(r.INTEXT_HYPHEN+s.split(":")[1].trim().replace(r.SPACE, r.plusANDplusintextcolon)); break;
                    case "os": stringBuilder.append(r.INTEXT_HYPHEN+s.split(":")[1].trim().replace(r.SPACE,  r.plusANDplusintextcolon)); break;
                    case "filetype": stringBuilder.append(s); break;
                }
            }}
        }

        stringBuilder.append(r.plusANDplusintextcolon+r.splitStringandAddOnebyone(predefined));

        return String.format("http://www.google.com/#tbs=li:1&q=%s", stringBuilder.toString());
    }

}
