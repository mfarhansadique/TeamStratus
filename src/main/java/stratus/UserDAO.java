package stratus;

import org.graalvm.compiler.lir.LIRInstruction;

import java.util.List;

public interface UserDAO {
    public List<String> findAll();
    public User save(User member);
}
