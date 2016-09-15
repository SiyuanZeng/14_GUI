package zeng.siyuan.betteresearchennebetterthangoogleandfindweehtehrething.findessentioal;

import zeng.siyuan.C1comehere.Search;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by SiyuanZeng's on 9/8/2016.
 */
public class findthebestexample {


    /*

    waht is the toipci


    what are you trying todo?


    What is the scenairo?

    whta other apratertes are thery

    what is it use?

    what are you tring to do?

    wtha langeuge?

    what atools are you using?


    what opitions are available?


    o you know the opictions?


    wht are thekeys wordlks?

    do kyou konw tha tto use?

    do you know all th ealternatives

    do you konw there are betetr solutions
    what so are required solutions

    what are opitons aband better field ds


    hwo to strcure my search?



    hwo many workds do ni need to sue


    how ot grab information and make beter search

    how to get infrmakoktno fro the m page and do better search


    how to

    waht website do oyou want to search


    do you use the default ewebsite


    where do you wnat to aserch url or text


    what consdieration s i need to make before search


    oliketitle url and site



    what o fucntionality are avaialblei in the world site to use



    what are the best combineation to use

    what kind of doucmentations am i looking for


    can i search a chunk of code



    whta t would be the easisest thing to do


    how to mininmze teh search time


    how to make it batter and better


    i just want to use one clien and i dont' want to use aall the foms

    how to sturctuer the search and make ti searcharble


    waht parameters do i need to define


    what are the wyas of thinking and how to struvteure it


    whta t steps to do the search


    wha tis th routine



    whta t is the ultimate andwer search quesity to use


    wha ti sth eultimate search to find the thing i wnat

    so many tqueistonso what shoauld i do


    i don't need to maket it clearn this is sa a history and i can wriet eht efierele as long as i want o




    i don't care i can even doment everything here whey shoul di



    how to make the bester odcuemntaiton in thjava



    fro example
    iwna tto t find the exmapele autocomepte ettxt in teh word so that i cadon't ahve to type

    i want to know the layout template code


    i want to search in all the datebase string and find the mater record


    i want to get whatever i nedd tfrom the internet instead of building on my own



    i wnat cand do thi better and amzing



    i can't wait





    i know everyghin so i don't neded to so do ti

how to do the synonym

// what are the signatures public class





documentation,

     */







/*


    example https://www.google.com/#q=related:www.github.com+site:www.github.com+intext:public+intext:class+

    intext:java

    keywords, public class,
    filetype:public class


    impport:
    datatypes, Arraylist
    parameters$
    variables#
    actions%


    related:www.github.com
    site:www.github.com


    Questions
        &tbs=li:1 - Verbatim
        ()
        -
        |
        can i search a chunk of code


    how to combine all the parameters


    noneused
        what kind of doucmentations am i looking for
        waht do i want to do:
        pattern names:
        String wahtdodesdanienlwantodo = textStr[1].replace("what does daniel want todo^", "");


 */


/*
 :.

Using allintext: hacker news ycombinator looks for results with all three words in the on-page text content.
You can use hacker news intext:ycombinator to get results with ycombinator in the text and hacker or news appearing anywhere on the page.



 */


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
                searchEngines = new Search(textArea, "Google", "sg ", "http://www.google.com/#tbs=li:1&q=related:www.github.com+AND+site:www.github.com+AND+intext:public+AND+intext:class+%s", "+", textArea.getText().trim());
                // https://www.google.com/#tbs=li:1&q=related:www.github.com+site:www.github.com+intext:public+intext:class+
                Desktop.getDesktop().browse(searchEngines.getURIforgethebsetresultexample());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //bombine things when there are multiple instance and class rleatived activity the class  tieh the owern er ot he actitiviets


    }
    public static void resetfiles() {
        String  inntuitive = "";
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
        inntuitive += "\n";
        inntuitive += "(optionalstackoverflow)First step 1:c1cometome:this is what yourwelcome want:";
        inntuitive += "\n";
        inntuitive += "(optional documentation)First step 1:c1cometome:this is what yourwelcome want:";
        inntuitive += "\n";
        inntuitive += "(optional everywhere)First step 1:c1cometome:this is what yourwelcome want:";
        textArea.setText(inntuitive);
    }
    public static JTextArea textArea;

    public findthebestexample(JTextArea textArea) {
        this.textArea = textArea;
    }

    //find example
    // group layout example
    //
}
