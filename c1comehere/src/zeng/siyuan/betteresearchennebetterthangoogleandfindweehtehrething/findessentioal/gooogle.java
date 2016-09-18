package zeng.siyuan.betteresearchennebetterthangoogleandfindweehtehrething.findessentioal;

import zeng.siyuan.reuseutil.r;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

/**
 * Created by SiyuanZeng's on 9/14/2016.
 */
public class gooogle {




    public static void resetfiles() {
        String  inntuitive = "";
        inntuitive += "site:"; inntuitive += "\n"; inntuitive += "Restrict a search to a single site"; inntuitive += "\n\n";
        inntuitive += "related:"; inntuitive += "\n"; inntuitive += "List pages which Google consider to be related to another"; inntuitive += "\n\n";
        inntuitive += "\"\":"; inntuitive += "\n"; inntuitive += "Restrict a search so that the keywords must appear consecutively in a phrase";
        inntuitive += "intext:"; inntuitive += "\n"; inntuitive += "Restrict a search so that some keywords must appear in the page text"; inntuitive += "\n\n";
        inntuitive += "inurl:"; inntuitive += "\n"; inntuitive += "Restrict a search so that some keywords must appear in the page address"; inntuitive += "\n\n";
        inntuitive += "intitle:"; inntuitive += "\n"; inntuitive += "Restrict a search so that some of the keywords must appear in the title"; inntuitive += "\n\n";
        inntuitive += "-"; inntuitive += "\n"; inntuitive += "Insist that the search engine omits pages which match a given keyword in the search results"; inntuitive += "\n\n";
        inntuitive += "filetype:"; inntuitive += "\n"; inntuitive += "Restrict a search to a given type of file";  inntuitive += "\n\n";
        inntuitive += "~"; inntuitive += "\n"; inntuitive += "Enhance a search to include synonyms for a given keyword"; inntuitive += "\n\n";
        inntuitive += "*"; inntuitive += "\n"; inntuitive += "Include a wildcard match in your search results"; inntuitive += "\n\n";
        inntuitive += "define:"; inntuitive += "\n"; inntuitive += "Show Google's glossary definition for a term"; inntuitive += "\n\n";
        inntuitive += "safesearch:"; inntuitive += "\n"; inntuitive += "Restrict a search to exclude adult-content"; inntuitive += "\n\n";
        inntuitive += "daterange:"; inntuitive += "\n"; inntuitive += "Restrict a search to any timeframe"; inntuitive += "\n\n";
        inntuitive += "date:"; inntuitive += "\n"; inntuitive += "Restrict a search to a recent timeframe"; inntuitive += "\n\n";
        inntuitive += "[#]...[#]"; inntuitive += "\n"; inntuitive += "Search a range of numbers as a keyword"; inntuitive += "\n\n";
        inntuitive += "allintitle:"; inntuitive += "\n"; inntuitive += "Restrict a search so that all the keywords must appear in the title"; inntuitive += "\n\n";
        inntuitive += "allintext:"; inntuitive += "\n"; inntuitive += "Restrict a search so that all of the keywords must appear in the body text"; inntuitive += "\n\n";
        inntuitive += "allinurl:"; inntuitive += "\n"; inntuitive += "Restrict a search so that all of the keywords must appear in the page address"; inntuitive += "\n\n";
        inntuitive += "OR"; inntuitive += "\n"; inntuitive += "List pages which have at least some of the keywords"; inntuitive += "\n\n";
        inntuitive += "+"; inntuitive += "\n"; inntuitive += "Insist that the search engine includes a given keyword in the search results"; inntuitive += "\n\n";
        inntuitive += "link:"; inntuitive += "\n"; inntuitive += "List pages which link to a page"; inntuitive += "\n\n";
        inntuitive += "info:"; inntuitive += "\n"; inntuitive += "Find one specific URL in the search database"; inntuitive += "\n\n";
        inntuitive += "cache:"; inntuitive += "\n"; inntuitive += "Show the cached snapshot of a page"; inntuitive += "\n\n";
        inntuitive += "stocks:"; inntuitive += "\n"; inntuitive += "Show American stockmarket information for a given ticker symbol"; inntuitive += "\n\n";
        textArea.setText(inntuitive);
    }
    public static JTextArea textArea;

    public gooogle(JTextArea textArea) {
        this.textArea = textArea;
    }




    public void gogolesearchgsearch() {
        try {
            if (null != textArea && !("".equalsIgnoreCase(textArea.getText().trim()))) {
                Desktop.getDesktop().browse(new URI(r.generate(textArea.getText())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //bombine things when there are multiple instance and class rleatived activity the class  tieh the owern er ot he actitiviets


    }

    public void returnshowsearchquetsry() {
        resetfiles();
    }


}
