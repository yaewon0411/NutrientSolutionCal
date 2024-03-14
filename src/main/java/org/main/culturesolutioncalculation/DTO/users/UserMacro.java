package org.main.culturesolutioncalculation.DTO.users;

public class UserMacro {
    private float NO3N;
    private float NH4N;
    private float H2PO4;
    private float K;
    private float Ca;
    private float Mg;
    private float SO4S;
    private String unit;
    private int user_id;

    public void setNO3N(float NO3N) {
        this.NO3N = NO3N;
    }

    public void setNH4N(float NH4N) {
        this.NH4N = NH4N;
    }

    public void setH2PO4(float h2PO4) {
        H2PO4 = h2PO4;
    }

    public void setK(float k) {
        K = k;
    }

    public void setCa(float ca) {
        Ca = ca;
    }

    public void setMg(float mg) {
        Mg = mg;
    }

    public void setSO4S(float SO4S) {
        this.SO4S = SO4S;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
