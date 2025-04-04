package Entity;

import HibernateManager.SubscriptionKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Subscriptions")
@Getter
@Setter
public class Subscriptions {
    @EmbeddedId
    private SubscriptionKey id;
    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    @Column(name = "subscription_date")
    private Date subscriptionDate;
}
