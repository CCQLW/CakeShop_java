package model;

public class Count {
    int id;
    int counts;

    public Count() {
        super();
    }

    @Override
    public String toString() {
        return "Count{" +
                "id=" + id +
                ", counts=" + counts +
                '}';
    }

    public Count(int id, int counts) {
        this.id = id;
        this.counts = counts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }
}
