package zeng.siyuan.onceaday.link.onceaday.document.onceaday;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by SiyuanZeng's on 9/1/2016.
 */
public class peoplequesiton {
    public static final String PERSON_QUESTION1 = "doc";
    Cluster cluster;
    static Session session;
    MappingManager manager;
    static Mapper<person_question> mapper;


    //todo bakup data


    public peoplequesiton() {
        cluster = Cluster.builder().addContactPoint("127.0.0.1").withPort(9042).build();
        session = cluster.connect("keyspace1");
        manager = new MappingManager(session);
        mapper = manager.mapper(person_question.class);
    }

    public static List<person_question> getlatest() {
        List<person_question> set = new ArrayList<person_question>();
        person_question ps = new person_question();
        ResultSet results = session.execute("SELECT * FROM keyspace1." + PERSON_QUESTION1);
        Result<person_question> users = mapper.map(results);
        for (person_question e : users) {
            set.add(e);
        }

        return set;
    }

    public static void deleteTask(UUID s) {
        System.out.println("delete task: " + s.toString());
        session.execute(String.format("delete from keyspace1." + PERSON_QUESTION1 + " WHERE id=%s", s));
    }

    public static void store(person_question s) {
        System.out.println("add p: " + s.getJavauid().toString() + " : " + s.getText());
        mapper.save(s);
    }

    public static void main(String[] args) {
        peoplequesiton pq = new peoplequesiton();
        person_question p = new person_question("25) If you could wake up tomorrow in the body of someone else, who would you pick and what would you do?\n", "Person_Quesiton", new Date());
        pq.store(p);
        System.exit(0);
    }


}
