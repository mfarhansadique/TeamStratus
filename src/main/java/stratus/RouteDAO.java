package stratus;

import java.util.List;

public interface RouteDAO {
    public List<String> findAll();
    public Route save(Route direction);
}
