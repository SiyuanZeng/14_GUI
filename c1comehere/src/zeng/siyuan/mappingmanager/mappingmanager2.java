package zeng.siyuan.mappingmanager;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;
import zeng.siyuan.howt2forgert.Ebbinghaus;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by SiyuanZeng's on 9/1/2016.
 */
public class mappingmanager2 {
    Cluster cluster;
    static Session session;
    MappingManager manager;
    Mapper<Ebbinghaus> mapper;


    //todo bakup data


    public mappingmanager2() {
        cluster = Cluster.builder().addContactPoint("127.0.0.1").withPort(9042).build();
        session = cluster.connect("keyspace1");
        manager = new MappingManager(session);
        mapper = manager.mapper(Ebbinghaus.class);
    }

    public Set<Ebbinghaus> get() {
        Set<Ebbinghaus> set = new HashSet<Ebbinghaus>();
        ResultSet results = session.execute("SELECT * FROM keyspace1.ebbinhance6;");
        Result<Ebbinghaus> users = mapper.map(results);
        for(Ebbinghaus e : users) {
            set.add(e);
        }
        return set;
    }

    public static void deleteTask(UUID s) {
        System.out.println("delete task: " + s.toString());
        session.execute(String.format("delete from keyspace1.ebbinhance6 WHERE id=%s", s));
    }

    public void store(Ebbinghaus s) {
        System.out.println("add task: " + s.getJavauid().toString()+" : " + s.getQuestion());
        mapper.save(s);
    }

    public static void main(String[] args) {
        mappingmanager2 m = new mappingmanager2();
        m.deleteTask(UUID.fromString("43abb0cf-b0fa-4cff-82ff-ee2b6b0cc682"));
    }


}
