package ru.ifmo.garder.compgeom;

import org.jscience.mathematics.number.Float64;
import ru.ifmo.garder.compgeom.primitives.Contour2;
import ru.ifmo.garder.compgeom.primitives.Point2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static ru.ifmo.garder.compgeom.Operations.orientation;
import static ru.ifmo.garder.compgeom.Operations.Orientation;

/**
 * Created by: avgarder
 */
public class ConvexHull {
    public static Contour2<Float64> buildGrahamHull(Collection<Point2<Float64>> points) {
        if (points.size() <= 2) {
            return new Contour2<Float64>(points);
        }

        ArrayList<Point2<Float64>> a = new ArrayList<Point2<Float64>>(points);
        Collections.sort(a);
        Point2<Float64> p1 = a.get(0);
        Point2<Float64> p2 = a.get(a.size() - 1);
        ArrayList<Point2<Float64>> up = new ArrayList<Point2<Float64>>();
        ArrayList<Point2<Float64>> down = new ArrayList<Point2<Float64>>();
        up.add(p1);
        down.add(p1);

        for (int i = 1; i < a.size(); i++) {
            if (i == a.size() - 1 || orientation(p1, a.get(i), p2) == Orientation.RIGHT) {
                while (up.size() >= 2 && orientation(up.get(up.size() - 2), up.get(up.size() - 1), a.get(i)) != Orientation.RIGHT) {
                    up.remove(up.size() - 1);
                }
            }

            if (i == a.size() - 1 || orientation(p1, a.get(i), p2) == Orientation.LEFT) {
                while (down.size() >= 2 && orientation(down.get(down.size() - 2), down.get(down.size() - 1), a.get(i)) != Orientation.LEFT) {
                    down.remove(down.size() - 1);
                }
            }
        }
        a.clear();
        for (Point2<Float64> point : up) {
            a.add(point);
        }
        for (int i = down.size() - 2; i > 0; i--) {
            a.add(down.get(i));
        }
        return new Contour2<Float64>(a);
    }
}
