import org.redisson.Redisson;
import org.redisson.RedissonScoredSortedSet;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import java.util.Date;

import static java.lang.System.out;

public class LoadDB {
    private RedissonClient redisson;
    private RKeys rKeys;
    private RScoredSortedSet<String> users;
    private final static String KEY = "ONLINE_USERS";

    private double getTs() {
        return new Date().getTime() / 1000;
    }
//("redis://127.0.0.1:6379")
    public void connect() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            out.println("Не удалось подключиться к Redis");
            out.println(Exc.getMessage());
        }
        rKeys = redisson.getKeys();
        users = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }

    public void shutdown() {
        redisson.shutdown();
    }

    public void log(int userId) {
        users.add(getTs(), String.valueOf(userId));
    }

}
