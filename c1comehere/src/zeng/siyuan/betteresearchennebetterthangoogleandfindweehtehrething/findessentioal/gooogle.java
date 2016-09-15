package zeng.siyuan.betteresearchennebetterthangoogleandfindweehtehrething.findessentioal;

import javax.swing.*;

/**
 * Created by SiyuanZeng's on 9/14/2016.
 */
public class gooogle {




    public static void resetfiles() {
        String  inntuitive = "";

        inntuitive += "filetype:";
        inntuitive += "\n";

        inntuitive += "Restrict a search to a given type of file";
        inntuitive += "\n";

        inntuitive += "link:";
        inntuitive += "\n";
        inntuitive += "List pages which link to a page";
        inntuitive += "\n";

        inntuitive += "related:";
        inntuitive += "\n";
        inntuitive += "List pages which Google consider to be related to another";
        inntuitive += "\n";

        inntuitive += "info:";
        inntuitive += "\n";
        inntuitive += "Find one specific URL in the search database";

        inntuitive += "\n";
        inntuitive += "define:";
        inntuitive += "\n";
        inntuitive += "Show Google's glossary definition for a term";

        inntuitive += "\n";
        inntuitive += "site:";
        inntuitive += "\n";
        inntuitive += "Restrict a search to a single site";

        inntuitive += "\n";
        inntuitive += "allintitle:";
        inntuitive += "\n";
        inntuitive += "Restrict a search so that all the keywords must appear in the title";

        inntuitive += "\n";
        inntuitive += "intitle:";
        inntuitive += "\n";
        inntuitive += "Restrict a search so that some of the keywords must appear in the title";

        inntuitive += "\n";
        inntuitive += "allintext:";
        inntuitive += "\n";
        inntuitive += "Restrict a search so that all of the keywords must appear in the body text";

        inntuitive += "\n";
        inntuitive += "allinurl:";
        inntuitive += "\n";
        inntuitive += "Restrict a search so that all of the keywords must appear in the page address";

        inntuitive += "\n";
        inntuitive += "inurl:";
        inntuitive += "\n";
        inntuitive += "Restrict a search so that some keywords must appear in the page address";

        inntuitive += "\n";
        inntuitive += "OR";
        inntuitive += "\n";
        inntuitive += "List pages which have at least some of the keywords";

        inntuitive += "\n";
        inntuitive += "+";
        inntuitive += "\n";
        inntuitive += "Insist that the search engine includes a given keyword in the search results";

        inntuitive += "\n";
        inntuitive += "-";
        inntuitive += "\n";
        inntuitive += "Insist that the search engine omits pages which match a given keyword in the search results";

        inntuitive += "\n";
        inntuitive += "~";
        inntuitive += "\n";
        inntuitive += "Enhance a search to include synonyms for a given keyword";

        inntuitive += "\n";
        inntuitive += "*";
        inntuitive += "\n";
        inntuitive += "Include a wildcard match in your search results";

        inntuitive += "\n";
        inntuitive += "[#]...[#]";
        inntuitive += "\n";
        inntuitive += "Search a range of numbers as a keyword";

        inntuitive += "\n";
        inntuitive += "daterange:";
        inntuitive += "\n";
        inntuitive += "Restrict a search to any timeframe";

        inntuitive += "\n";
        inntuitive += "\"\"";
        inntuitive += "\n";
        inntuitive += "Restrict a search so that the keywords must appear consecutively in a phrase";

        inntuitive += "\n";
        inntuitive += "date:";
        inntuitive += "\n";
        inntuitive += "Restrict a search to a recent timeframe";

        inntuitive += "\n";
        inntuitive += "safesearch:";
        inntuitive += "\n";
        inntuitive += "Restrict a search to exclude adult-content";

        inntuitive += "\n";
        inntuitive += "cache:";
        inntuitive += "\n";
        inntuitive += "Show the cached snapshot of a page";

        inntuitive += "\n";
        inntuitive += "stocks:";
        inntuitive += "\n";
        inntuitive += "Show American stockmarket information for a given ticker symbol";
        inntuitive += "\n";
        textArea.setText(inntuitive);
    }
    public static JTextArea textArea;

    public gooogle(JTextArea textArea) {
        this.textArea = textArea;
    }



    public void returnshowsearchquetsry() {
        resetfiles();
    }


}
