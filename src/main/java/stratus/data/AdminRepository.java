package stratus.data;

import org.springframework.data.repository.CrudRepository;
import stratus.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
}
