package ru.ifmo.garder.compgeom;

import org.jscience.mathematics.number.Float64;
import ru.ifmo.garder.compgeom.primitives.Contour2;
import ru.ifmo.garder.compgeom.primitives.Point2;
import ru.ifmo.garder.compgeom.primitives.Segment2;

import java.util.LinkedList;
import java.util.List;

public class TestUtils {
    public static Point2<Float64> getPoint2(double x, double y) {
        return new Point2<Float64>(Float64.valueOf(x), Float64.valueOf(y));
    }

    public static Segment2<Float64> getSegment2(Point2<Float64> beg, Point2<Float64> end) {
        return new Segment2<Float64>(beg, end);
    }

    public static Segment2<Float64> getSegment2(double x1, double y1, double x2, double y2) {
        return getSegment2(getPoint2(x1, y1), getPoint2(x2, y2));
    }

    public static Contour2<Float64> getContour2(Point2<Float64>... points) {
        List<Point2<Float64>> res = new LinkedList<Point2<Float64>>();
        for (Point2<Float64> point : points) {
            res.add(point);
        }
        return new Contour2<Float64>(res);
    }
}
