import org.junit.Test;

public class PointsTest {
    @Test
    public void testDistanceCorrectV1() {
        Point p1 = new Point().p1(5, 6);
        Point p2 = new Point().p2(8, 10);
        assert  p1.distance(p2) == 5.0;
    }
    @Test
    public void testDistanceCorrectV2() {
        Point p1 = new Point().p1(0, 0);
        Point p2 = new Point().p2(5, 5);
        assert  p1.distance(p2) == 7.0710678118654755;
    }
    @Test //
    public void testDistanceIncorrect() {
        Point p1 = new Point().p1(5, 6);
        Point p2 = new Point().p2(8, 10);
        assert  p1.distance(p2) == 3;
    }
}
