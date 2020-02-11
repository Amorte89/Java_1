import org.junit.Test;

public class RectangleTest {

    @Test
    public void testArea() {
        Rectangle r = new Rectangle(4, 8);
        assert  r.area() == 32;
    }
}
