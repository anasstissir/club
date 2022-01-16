package ma.uir.club.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Club.
 */
@Entity
@Table(name = "club")
public class Club implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "club_name", nullable = false)
    private String clubName;

    @NotNull
    @Column(name = "creation_date", nullable = false)
    private Instant creationDate;

    @ManyToMany(mappedBy = "clubs")
    @JsonIgnoreProperties(value = { "user", "clubs" }, allowSetters = true)
    private Set<Student> students = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Club id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClubName() {
        return this.clubName;
    }

    public Club clubName(String clubName) {
        this.setClubName(clubName);
        return this;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public Instant getCreationDate() {
        return this.creationDate;
    }

    public Club creationDate(Instant creationDate) {
        this.setCreationDate(creationDate);
        return this;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Student> getStudents() {
        return this.students;
    }

    public void setStudents(Set<Student> students) {
        if (this.students != null) {
            this.students.forEach(i -> i.removeClub(this));
        }
        if (students != null) {
            students.forEach(i -> i.addClub(this));
        }
        this.students = students;
    }

    public Club students(Set<Student> students) {
        this.setStudents(students);
        return this;
    }

    public Club addStudent(Student student) {
        this.students.add(student);
        student.getClubs().add(this);
        return this;
    }

    public Club removeStudent(Student student) {
        this.students.remove(student);
        student.getClubs().remove(this);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Club)) {
            return false;
        }
        return id != null && id.equals(((Club) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Club{" +
            "id=" + getId() +
            ", clubName='" + getClubName() + "'" +
            ", creationDate='" + getCreationDate() + "'" +
            "}";
    }
}
