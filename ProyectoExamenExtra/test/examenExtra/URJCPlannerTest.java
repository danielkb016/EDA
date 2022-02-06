package examenExtra;

import examenExtra.Road;
import examenExtra.URJCPlanner;
import examenExtra.Town;
import java.util.Collection;
import material.utils.Pair;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mayte
 */
public class URJCPlannerTest {

    /**
     * Test of addTown method, of class URJCPlanner.
     */
    @Test
    public void testAddTownsAndRoads() {
        System.out.println("addTown");
        URJCPlanner planner = new URJCPlanner();
        Town m = planner.addTown("Madrid");
        Town z = planner.addTown("Zaragoza");
        Town a = planner.addTown("Albacete");
        Town v = planner.addTown("Valencia");
        Town c = planner.addTown("Cordoba");

        Road r1 = planner.connectTowns(m, z, 300);
        planner.connectTowns(m, a, 200);
        Road r2 = planner.connectTowns(m, c, 300);
        planner.connectTowns(a, v, 100);
        planner.connectTowns(v, z, 400);
        
        assertEquals(r1,planner.getRoad(m, z));
        assertEquals(r1,planner.getRoad(z, m));
        assertEquals(r2,planner.getRoad(m, c));
        assertEquals(r2,planner.getRoad(c, m));
    }

    /**
     * Test of traceRoute method, of class URJCPlanner.
     */
    @Test
    public void testTraceRoute() {
        System.out.println("traceRoute");
        URJCPlanner planner = new URJCPlanner();
        Town m = planner.addTown("Madrid");
        Town z = planner.addTown("Zaragoza");
        Town a = planner.addTown("Albacete");
        Town v = planner.addTown("Valencia");
        Town c = planner.addTown("Cordoba");

        Road r1 = planner.connectTowns(m, z, 300);
        planner.connectTowns(m, a, 200);
        Road r2 = planner.connectTowns(m, c, 300);
        planner.connectTowns(a, v, 100);
        planner.connectTowns(v, z, 400);

        Collection<Pair<Town, Integer>> result = planner.traceRoute(c, z);
        assertEquals(3, result.size());
        int cont = 0;
        for (Pair<Town, Integer> pair : result) {
            switch (cont) {
                case 0:
                    assertEquals(c,pair.getFirst());
                    assertEquals(0,pair.getSecond().intValue());
                    break;
                case 1:
                    assertEquals(m,pair.getFirst());
                    assertEquals(300,pair.getSecond().intValue());
                    break;                
                default:
                    assertEquals(z,pair.getFirst());
                    assertEquals(600,pair.getSecond().intValue());
                    break;
            }
            cont++;
        }
    }
    
}
