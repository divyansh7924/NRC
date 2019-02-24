package info.androidhive.recyclerview;


public class Center {
    private String title, add, dist;

    public Center() {
    }

    public Center(String title, String add, String dist) {
        this.title = title;
        this.add = add;
        this.dist = dist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return dist;
    }

    public void setYear(String dist) {
        this.dist = dist;
    }

    public String getGenre() {
        return add;
    }

    public void setGenre(String add) {
        this.add = add;
    }
}
