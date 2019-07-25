package stratus;

import java.util.List;

public interface AdminDAO {
    public List<String> findAll();
    public Admin save(Admin administrator);
}
