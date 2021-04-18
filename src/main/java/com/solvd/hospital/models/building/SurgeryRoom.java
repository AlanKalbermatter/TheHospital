package com.solvd.hospital.models.building;

import java.util.Objects;

public class SurgeryRoom extends Room {
    public boolean operating;

    public boolean isOperating() {
        return operating;
    }

    public void setOperating(boolean operating) {
        this.operating = operating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SurgeryRoom)) return false;
        SurgeryRoom surgery = (SurgeryRoom) o;
        return isOperating() == surgery.isOperating();
    }

    @Override
    public int hashCode() {
        return Objects.hash( isOperating() );
    }

    @Override
    public String toString() {
        return "Surgery{" +
                "operating=" + operating +
                '}';
    }
}
