import com.example.lesson04.AreaTriangle;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AreaTriangleTest {


     @Test
    public void negativeNumbers() {
         Assertions.assertFalse(AreaTriangle.is_Valid(-1,-2,-3));
     }

     @Test
    public void oneSideIsZero() {
         Assertions.assertFalse(AreaTriangle.is_Valid(0,1,2));
     }

     @Test
    public void InvalidSidesProportions() {
         Assertions.assertFalse(AreaTriangle.is_Valid(4, 6, 10));
     }

    @Test
    public void validTriangle() {
         Assertions.assertTrue(AreaTriangle.is_Valid(4,5,6));
    }

    @Test
    public void ValidAreaCalculation() {
         Assertions.assertEquals(AreaTriangle.area_triangle(8,13,15),51.96152422706632);
    }
}
