package main.java.lighting;

public enum Material {

    ODB_KIER(1, 1, 0.05, 0, 1, 2, 200),
    ODB_KIER_ROZPR(1, 1, 0.05, 0.25, 0.75, 2, 100),
    ODB_ROZPR_KIER(1, 1, 0.05, 0.75, 0.25, 2, 50),
    ODB_ROZPR(1, 1, 0.05, 1, 0, 2, 1),
    ODB_KIER_ROPR_MAKS(1, 1, 0.05, 1, 1, 2, 200);

    Phong phong;

    Material(double Ia, double Ip, double ka, double kd, double ks, double c, double n) {
        phong = new Phong(Ia, Ip, ka, kd, ks, c, n);
    }

    static Material getMaterial(int i) {
        switch (i) {
            case 0: return ODB_KIER;
            case 1: return ODB_KIER_ROZPR;
            case 2: return ODB_ROZPR_KIER;
            case 3: return ODB_ROZPR;
            case 4: return ODB_KIER_ROPR_MAKS;
        }
        return null;
    }
}
