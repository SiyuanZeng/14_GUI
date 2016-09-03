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

/**
 * Created by SiyuanZeng's on 9/1/2016.
 */
public class mappingmanager {
    Cluster cluster;
    Session session;
    MappingManager manager;
    Mapper<Ebbinghaus> mapper;

    public mappingmanager() {
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

    public void update(Ebbinghaus s) {
        deleteTask(s);
        store(s);
    }

    public void deleteTask(Ebbinghaus s) {
        session.execute(String.format("delete from keyspace1.ebbinhance6 WHERE id=%s", s.getJavauid()));
    }

    public void store(Ebbinghaus s) {
        mapper.save(s);
    }
}