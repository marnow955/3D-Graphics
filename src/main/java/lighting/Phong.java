package main.java.lighting;

import javafx.geometry.Point3D;

public class Phong {
    double Ia;      //natezenie swiatla tla
    double Ip;      //natezenie swiatla punktowego zrodla
    double ka;      //wspolczynnik odbicia swiatla tla
    double kd;      //wspolczynnik odbicia rozproszonego
    double ks;      //wspolczynnik odbicie kierunkowego
    double c;       //stala tlumienia
    double n;       //wykladnik potegi, współczynnik gładkości powierzchni

    public Phong(double Ia, double Ip, double ka, double kd, double ks, double c, double n) {
        this.Ia = Ia;
        this.Ip = Ip;
        this.ka = ka;
        this.kd = kd;
        this.ks = ks;
        this.c = c;
        this.n = n;
    }

    public Double spherePointLighting(Point3D lightSource, Point3D observer, Point3D sphereCenter, Point3D spherePoint) {
        if (spherePoint == null) {
            return null;
        }
        Vector N = new Vector(sphereCenter, spherePoint);      //wektor normalny
        N.normalize();
        Vector V = new Vector(spherePoint, observer);       //wektor do obserwatora
        V.normalize();
        Vector L = new Vector(spherePoint, lightSource);    //wektor do zrodla swiatla
        double r = L.norm();                                       //odl. punktu sfery od zrodla swiatla

        L.normalize();
        Vector R = (N.multiply(2)).multiply(N.dotProduct(L)).diff(L);   //wektor odbity
        R.normalize();

        double I = Ia * ka + Ip * (kd * Math.max(N.dotProduct(L), 0) + ks * Math.pow(Math.max(R.dotProduct(V), 0), n) ) / (c + r);
//        double I = Ia * ka + Ip * (kd * Math.max(N.dotProduct(L), 0) + ks * Math.pow(Math.max(R.dotProduct(V), 0), n) );
        return I;

    }

}
