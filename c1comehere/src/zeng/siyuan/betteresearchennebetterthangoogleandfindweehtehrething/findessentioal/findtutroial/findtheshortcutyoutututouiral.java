package zeng.siyuan.betteresearchennebetterthangoogleandfindweehtehrething.findessentioal.findtutroial;

import zeng.siyuan.C1comehere.Search;
import zeng.siyuan.reuseutil.r;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

/**
 * Created by SiyuanZeng's on 9/8/2016.
 */
public class findtheshortcutyoutututouiral {


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
        inntuitive += "subjects:";
        inntuitive += "\n";
        inntuitive += "operation:";
        inntuitive += "\n";
        inntuitive += "os:";
        inntuitive += "\n";
        inntuitive += "filetype:";
        textArea.setText(inntuitive);
    }

    public static String predefined = "";

    public static JTextArea textArea;

    public findtheshortcutyoutututouiral(JTextArea textArea) {
        this.textArea = textArea;
    }




    public static String generate(String str) {
        String textStr[] = str.split("\\r\\n|\\n|\\r");
        StringBuilder stringBuilder = new StringBuilder();


        for (int i = 0; i < textStr.length; i++) {
            String s  = textStr[i];
            if (s.split(":").length > 1 && r.isNotNullOrEmpty(s.split(":")[1])) {
                if(stringBuilder.length() > 0){
                    stringBuilder.append(r.plus);
                }
                String trim = s.split(":")[1].trim();
                switch (s.split(":")[0]) {
                    case "subjects": stringBuilder.append(r.plus+r.splitStringandAddOnebyoneonlyplussign(trim)); break;
                    case "operation": stringBuilder.append(r.plus+r.splitStringandAddOnebyoneonlyplussign(trim)); break;
                    case "os": stringBuilder.append(r.plus+r.splitStringandAddOnebyoneonlyplussign(trim)); break;
                    case "filetype": stringBuilder.append(r.plus+ trim); break;
                }

            }
        }

        stringBuilder.append("+"+r.splitStringandAddOnebyoneonlyplussign(predefined));

        return String.format("https://www.youtube.com/results?search_query=%s", stringBuilder.toString());
    }

}
