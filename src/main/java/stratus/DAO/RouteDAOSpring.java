package stratus.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import stratus.data.RouteRepository;

import java.util.ArrayList;
import java.util.List;

public class RouteDAOSpring implements RouteDAO {

    @Autowired
    private RouteRepository routeRepository;

    public List<String> findAll() {
        ArrayList<String> allRoutes = new ArrayList<String>();
        for (Route r : routeRepository.findAll()) {
            allRoutes.add(r.getStartLocation());}
        return allRoutes;
    }

    public boolean save(Route direction) {
//        routeRepository.findById(direction.getId());
        routeRepository.save(direction);
        return true;
    }
}
