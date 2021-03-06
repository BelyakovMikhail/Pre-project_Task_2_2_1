package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    private Long id;

    @Column (name = "model")
    private String model;

    @Column (name = "series")
    private int series;

    @OneToOne(mappedBy = "car")
    private User user;

    public Car (){
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +'}';
    }
        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        return Objects.equals(series, car.series);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, series);
    }

}
