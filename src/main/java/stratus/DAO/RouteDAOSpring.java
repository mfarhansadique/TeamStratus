package stratus.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import stratus.data.RouteRepository;

import java.util.ArrayList;
import java.util.List;

public class RouteDAOSpring implements RouteDAO {

    @Autowired
    private RouteRepository routeRepository;

    public List<String> findAll() {
        ArrayList<String> allRoutes = new ArrayList<>();
        for (Route r : routeRepository.findAll()) {
            allRoutes.add(r.getStartLocation() + r.getEndLocation());}
        return allRoutes;
    }

    public boolean save(Route direction) {
//        routeRepository.findById(direction.getId());
        routeRepository.save(direction);

        return true;
    }

    public Route findRouteById(int id){

        return routeRepository.findById(id).get();
    }

    public String getCurrencyById(int id){
        Route r=routeRepository.findById(id).get();
        return r.getCurrency();
    }
}
