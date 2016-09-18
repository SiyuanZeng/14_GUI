package zeng.siyuan.howt2forgert;

import zeng.siyuan.solr.test.param.dao.SolrDataDAO;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by SiyuanZeng's on 9/18/2016.
 */
public class loadolr extends Thread {
    Set<Ebbinghaus> es;

    public loadolr(Set<Ebbinghaus> e) {
        this.es = e;
    }

    boolean open = false;


    public boolean open() {
        return open;
    }

    @Override
    public void run() {
        //solr

        SolrDataDAO solrDataDAO = null;
        try {
            solrDataDAO = new SolrDataDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Task> tasks = new ArrayList<Task>();
        for (Ebbinghaus e : es) {
            try {
                solrDataDAO.addData(e.javauid, e.getQuestion());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            if (e.getQuestion().replace("ufgt", "").trim().isEmpty()) {
            } else {
                Set<Task> t = e.tasks;
                for (Task task : t) {
                    tasks.add(task);
                }
            }
        }
    }

}
