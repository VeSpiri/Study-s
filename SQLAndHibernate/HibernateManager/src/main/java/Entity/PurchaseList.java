package Entity;

import HibernateManager.PurchaseListKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "PurchaseList")
@Getter
@Setter
public class PurchaseList {
    @EmbeddedId
    private PurchaseListKey id;

    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;
    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "Courses",
            joinColumns = {@JoinColumn(name = "name")},
            inverseJoinColumns = {@JoinColumn(name = "id")})
    private Courses courses;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "Students",
            joinColumns = {@JoinColumn(name = "name")},
            inverseJoinColumns = {@JoinColumn(name = "id")})
    private Students students;*/
}
