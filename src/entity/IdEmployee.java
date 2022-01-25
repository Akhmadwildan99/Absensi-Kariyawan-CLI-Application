package entity;

import java.util.Objects;

public class IdEmployee {
    private Integer id;

    public IdEmployee(Integer id) {
        this.id = id;
    }

    public IdEmployee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdEmployee that = (IdEmployee) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "IdEmployee{" +
                "id=" + id +
                '}';
    }
}
