package stratus.DAO;

import java.util.List;

public interface RouteDAO {
    public List<String> findAll();
    public boolean save(Route direction);
}
