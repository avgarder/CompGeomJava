package ru.ifmo.garder.compgeom;

import org.jscience.mathematics.number.Float64;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.ifmo.garder.compgeom.primitives.Point2;

import java.util.Random;

import static ru.ifmo.garder.compgeom.Operations.*;

@RunWith(JUnit4.class)
public class TestOrientation {
    private final static Random random = new Random();

    private Point2<Float64> a;
    private Point2<Float64> b;

    private Point2<Float64> randomPoint2() {
        return new Point2<Float64>(Float64.valueOf(random.nextDouble()), Float64.valueOf(random.nextDouble()));
    }

    @Before
    public void setUp() {
        a = randomPoint2();
        b = randomPoint2();
    }

    @Test
    public void test() {
        while (true) {
            double t = random.nextDouble();
            Point2<Float64> c = new Point2<Float64>(a.x.plus(b.x.minus(a.x).times(t)), a.y.plus(b.y.minus(a.y).times(t)));
            Float64 l = b.x.minus(a.x).times(c.y.minus(a.y));
            Float64 r = b.y.minus(a.y).times(c.x.minus(a.x));
            Float64 res = l.minus(r);

            Orientation t1 = res.isGreaterThan(Float64.ZERO) ? Orientation.LEFT :
                    res.isLessThan(Float64.ZERO) ? Orientation.RIGHT : Orientation.COLLINEAR;

            Orientation t2 = orientation(a, b, c);

            if (t1 != t2) {
                break;
            }
        }
    }

}
