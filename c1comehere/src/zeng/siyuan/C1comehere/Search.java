package zeng.siyuan.C1comehere;

import javax.swing.*;
import java.net.URI;
import java.net.URL;

/**
 * Created by SiyuanZeng's on 8/24/2016.
 */
public class Search {
    public static final String SPACE = " ";
    public static final String EMPTY_STRING = "";
    private JTextArea textArea;
    public String searchEngine;
    public String spaceHolder;
    public String searchName;
    public String key;
    public String keywords;
    public URI URI;
    public String textTrs;

    public Search(String searchName, String key, String searchEngine, String spaceHolder, String textStr) {
        this.searchName = searchName;
        this.key = key;
        this.searchEngine = searchEngine;
        this.spaceHolder = spaceHolder;
        this.textTrs = textStr;
    }

    public Search(String searchName, String key, String searchEngine, String spaceHolder) {
        this.searchName = searchName;
        this.key = key;
        this.searchEngine = searchEngine;
        this.spaceHolder = spaceHolder;
    }

    public Search(JTextArea textArea, String searchName, String key, String searchEngine, String spaceHolder, String textStr) {
        this.searchName = searchName;
        this.key = key;
        this.searchEngine = searchEngine;
        this.spaceHolder = spaceHolder;
        this.textTrs = textStr;
        this.textArea=textArea;
    }

    public URI getURI() {
        return URI;
    }

    public String getURIString() {
        return URI.toString();
    }

    public void setURI(String keywords) {
        try {
            String normalized = keywords.replace(key, EMPTY_STRING);
            this.keywords = normalized;
            URI = new URL(String.format(searchEngine, normalized.replace(SPACE, "+"))).toURI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
multiple steps
lonrepeative questy impossivble to wriete


 */
    public URI getURIforgethebsetresultexample() {
        /*

1
datatypeps:(2
parameters$3
variables#4
actions%5
I dont want&6
https://www.google.com//#tbs=li:1&q=impport*++intext:+intext:2++intext:+intext:3++intext:+intext:4++intext:+intext:5++intext:+intext:6

impport*1 0
datatypeps:(2 0
parameters$3 0
variables#4 0
actions%5 0
I dont want&6 0








impport*
java
datatypeps:(arraylist
parameters$String
variables#str
actions%return
I dont want&50


impport*
java
datatypeps:(arraylist
parameters$String
variables#str
actions%return
I dont want&50
         */
        String textStr[] = textTrs.split("\\r\\n|\\n|\\r");
        String intext = "+intext:";
        String c1cometome = textStr[0].trim().replace("how to","").replace("How to", "").replace("(optional)First step 1:c1cometome:this is what yourwelcome want:", "intext:").replace(SPACE, "+AND"+intext);
        String datatypes = textStr[1].trim().replace("datatypeps:(", "intext:").replace(SPACE, "+AND"+intext);
        String idontwant = textStr[2].trim().replace("I dont want&", "+-").replace(SPACE, "+AND"+"+-");
        String datatypes1 = textStr[3].trim().replace("parameters$", intext).replace(SPACE, "+AND"+intext);
        String datatypes2 = textStr[4].trim().replace("variables#", intext).replace(SPACE, "+AND"+intext);
        String datatypes3 = textStr[5].trim().replace("actions%", intext).replace(SPACE, "+AND"+intext);
        String iomport = textStr[6].trim().replace("impport*", intext).replace(SPACE, "+AND"+intext);

        String combinedstring = iomport + datatypes + datatypes1 + datatypes2 + datatypes3 + idontwant;

        try {
            if (!c1cometome.equalsIgnoreCase("intext:")){
                //"http://www.google.com/#tbs=li:1&q=related:www.github.com+AND+site:www.github.com+AND+intext:public+AND+intext:class+%s"
                searchEngine= "http://www.google.com/#tbs=li:1&q=site:www.stackoverflow.com+AND+intext:documentation+AND+%s";


                String  inntuitive = "(optional)First step 1:c1cometome:this is what yourwelcome want:";
                inntuitive += "\n";
                inntuitive += "datatypeps:(";
                inntuitive += "\n";
                inntuitive += "I dont want&";
                inntuitive += "\n";
                inntuitive += "parameters$";
                inntuitive += "\n";
                inntuitive += "variables#";
                inntuitive += "\n";
                inntuitive += "actions%";
                inntuitive += "\n";
                inntuitive += "impport*";
                textArea.setText(inntuitive);




                return new URL(String.format(searchEngine, c1cometome)).toURI();
            } else {
                textArea.setText("");
                //"http://www.google.com/#tbs=li:1&q=related:www.github.com+AND+site:www.github.com+AND+intext:public+AND+intext:class+%s"
                return new URL(String.format(searchEngine, combinedstring)).toURI();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


