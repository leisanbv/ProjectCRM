package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Term {
    private int id;
    private String name_of_term;
    private String duration;
    private int status = 1;
    private List<Discipline> disciplines = new ArrayList<>();

    public Term() {
    }

    public Term(int id, String name_of_term, String duration, int status, List<Discipline> disciplines) {
        this.id = id;
        this.name_of_term = name_of_term;
        this.duration = duration;
        this.status = status;
        this.disciplines = disciplines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_of_term() {
        return name_of_term;
    }

    public void setName_of_term(String name_of_term) {
        this.name_of_term = name_of_term;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term term = (Term) o;
        return id == term.id && status == term.status && Objects.equals(name_of_term, term.name_of_term) && Objects.equals(duration, term.duration) && Objects.equals(disciplines, term.disciplines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name_of_term, duration, status, disciplines);
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", name_of_term='" + name_of_term + '\'' +
                ", duration='" + duration + '\'' +
                ", status=" + status +
                ", disciplines=" + disciplines +
                '}';
    }
}