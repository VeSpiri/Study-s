package HibernateManager;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Linkedpurchaselist")
public class LinkedPurchaseList {
    @EmbeddedId
    private LinkedPurchaseListKey id;

    @Column(name = "student_id", insertable=false, updatable=false)
    private int studentId;

    @Column(name = "course_id", insertable=false, updatable=false)
    private int courseId;

}
