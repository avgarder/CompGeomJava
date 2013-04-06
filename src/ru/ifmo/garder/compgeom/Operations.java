package ru.ifmo.garder.compgeom;

import org.jscience.mathematics.number.Float64;
import org.jscience.mathematics.number.Rational;
import ru.ifmo.garder.compgeom.primitives.Contour2;
import ru.ifmo.garder.compgeom.primitives.Point2;
import ru.ifmo.garder.compgeom.primitives.Rectangle2;
import ru.ifmo.garder.compgeom.primitives.Segment2;

import java.util.Collections;
import java.util.ListIterator;


public class Operations {
    private static final double DOUBLE_EPS = 2.22045e-16;

    public static enum Orientation {
        LEFT, RIGHT, COLLINEAR
    }

    public static Orientation orientation(Point2<Float64> a, Point2<Float64> b, Point2<Float64> c) {
        Float64 l = b.x.minus(a.x).times(c.y.minus(a.y));
        Float64 r = b.y.minus(a.y).times(c.x.minus(a.x));
        Float64 res = l.minus(r);
        Float64 eps = l.abs().plus(r.abs()).times(8).times(DOUBLE_EPS);
        if (res.isGreaterThan(eps)) {
            return Orientation.LEFT;
        }

        if (res.isLessThan(eps.opposite())) {
            return Orientation.RIGHT;
        }

        return orientation_r(a, b, c);
    }

    public static Orientation orientation_r(Point2<Float64> a, Point2<Float64> b, Point2<Float64> c) {
        Point2<Rational> a1 = new Point2<Rational>(Rational.valueOf(a.x), Rational.valueOf(a.y));
        Point2<Rational> b1 = new Point2<Rational>(Rational.valueOf(b.x), Rational.valueOf(b.y));
        Point2<Rational> c1 = new Point2<Rational>(Rational.valueOf(c.x), Rational.valueOf(c.y));

        Rational l = b1.x.minus(a1.x).times(c1.y.minus(a1.y));
        Rational r = b1.y.minus(a1.y).times(c1.x.minus(a1.x));
        Rational res = l.minus(r);

        if (res.isGreaterThan(Rational.ZERO)) {
            return Orientation.LEFT;
        }

        if (res.isLessThan(Rational.ZERO)) {
            return Orientation.RIGHT;
        }

        return Orientation.COLLINEAR;
    }

    public static boolean isSegments2Intersects(Segment2<Float64> a, Segment2<Float64> b) {
        if (a.beg.equals(b.beg) || a.beg.equals(b.end) || a.end.equals(b.beg) || a.end.equals(b.end)) {
            return true;
        }

        Orientation t11 = orientation(a.beg, a.end, b.beg);
        Orientation t12 = orientation(a.beg, a.end, b.end);
        Orientation t21 = orientation(b.beg, b.end, a.beg);
        Orientation t22 = orientation(b.beg, b.end, a.end);

        if (t11 == Orientation.COLLINEAR) {
            if (b.beg.compareTo(a.min()) > 0 && b.beg.compareTo(a.max()) < 0) {
                return true;
            }
        }

        if (t12 == Orientation.COLLINEAR) {
            if (b.end.compareTo(a.min()) > 0 && b.end.compareTo(a.max()) < 0) {
                return true;
            }
        }

        if (t21 == Orientation.COLLINEAR) {
            if (a.beg.compareTo(b.min()) > 0 && a.beg.compareTo(b.max()) < 0) {
                return true;
            }
        }

        if (t22 == Orientation.COLLINEAR) {
            if (a.end.compareTo(b.min()) > 0 && a.end.compareTo(b.max()) < 0) {
                return true;
            }
        }

        return t11 != t12 && t21 != t22;
    }

    /**
     *  Triangle is counterclockwise oriented.
     */
    public static boolean isPointInTriangle(Point2<Float64> a, Point2<Float64> b, Point2<Float64> c, Point2<Float64> t) {
        if (t.equals(a) || t.equals(b) || t.equals(c)) {
            return true;
        }

        Orientation ab = orientation(a, b, t);
        Orientation bc = orientation(b, c, t);
        Orientation ca = orientation(c, a, t);

        return ab != Orientation.RIGHT && bc != Orientation.RIGHT && ca != Orientation.RIGHT;
    }

    public static boolean isSegment2AndTriangleIntersects(Point2<Float64> a, Point2<Float64> b, Point2<Float64> c,
                                                          Segment2<Float64> s) {
        boolean abs = isSegments2Intersects(new Segment2<Float64>(a, b), s);
        boolean bcs = isSegments2Intersects(new Segment2<Float64>(b, c), s);
        boolean cas = isSegments2Intersects(new Segment2<Float64>(c, a), s);

        return abs || bcs || cas || (isPointInTriangle(a, b, c, s.beg) && isPointInTriangle(a, b, c, s.end));
    }

    public static boolean isSegment2AndRectangle2Intersects(Rectangle2<Float64> r, Segment2<Float64> s) {
        Point2<Float64> ld = r.corner(Rectangle2.LEFT, Rectangle2.DOWN);
        Point2<Float64> lu = r.corner(Rectangle2.LEFT, Rectangle2.UP);
        Point2<Float64> rd = r.corner(Rectangle2.RIGHT, Rectangle2.DOWN);
        Point2<Float64> ru = r.corner(Rectangle2.RIGHT, Rectangle2.UP);

        return isSegment2AndTriangleIntersects(ld, ru, lu, s) || isSegment2AndTriangleIntersects(ld, rd, ru, s);
    }

    public enum ContourOrientation {
        CLOCKWISE, COUNTERCLOCKWISE
    }

    public static ContourOrientation contourOrientation(Contour2<Float64> c) {
        Point2<Float64> min = Collections.min(c);
        int index = c.indexOf(min);

        return orientation(c.get(index - 1), c.get(index), c.get(index + 1)) == Orientation.RIGHT ?
                ContourOrientation.CLOCKWISE : ContourOrientation.COUNTERCLOCKWISE;
    }

    /**
     *
     * @param c is a clockwise oriented contour
     */
    public static boolean isPointInConvexContour(Point2<Float64> p, Contour2<Float64> c) {
        if (orientation(c.get(0), c.get(-1), p) == Orientation.RIGHT) {
            return false;
        }

        int l = 0, r = c.size() - 1, m;

        while (r - l > 1) {
            m = (r + l) / 2;
            if (orientation(c.get(0), c.get(m), p) == Orientation.RIGHT) {
                l = m;
            } else {
                r = m;
            }
        }

        return isPointInTriangle(c.get(0), c.get(l + 1), c.get(l), p);
    }

    /**
     *
     * @param c is a clockwise oriented contour
     * @return
     */

    public static boolean isPointInContour(Point2<Float64> p, Contour2<Float64> c) {
        int countIntersects = 0;
        for (int i = 0, size = c.size(); i < size; i++) {
            if (p.equals(c.get(i))) {
                return true;
            }
            Point2<Float64> p1, p2;
            if (c.get(i).y.isLessThan(c.get(i + 1).y)) {
                p1 = c.get(i);
                p2 = c.get(i + 1);
            } else {
                p1 = c.get(i + 1);
                p2 = c.get(i);
            }
            if (p.y.isLessThan(p1.y) || p.y.isGreaterThan(p2.y) || orientation(p1, p2, p) == Orientation.RIGHT) {
                continue;
            }

            if (p.y.equals(c.get(i).y)) {
                if (orientation(p, c.get(i), c.get(i + 1)) != orientation(p, c.get(i), c.get(i - 1))) {
                    countIntersects++;
                }
            } else if (!p.y.equals(c.get(i + 1).y)) {
                countIntersects++;
            }
        }
        return countIntersects % 2 == 1;
    }
}
