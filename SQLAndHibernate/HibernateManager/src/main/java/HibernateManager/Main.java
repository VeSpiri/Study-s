package HibernateManager;

import Entity.Courses;
import Entity.PurchaseList;
import Entity.Students;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<PurchaseList> queryPurchaseList = builder.createQuery(PurchaseList.class);
        CriteriaQuery<Courses> queryCourse = builder.createQuery(Courses.class);
        CriteriaQuery<Students> queryStudent = builder.createQuery(Students.class);

        Root<PurchaseList> rootPurchaseList = queryPurchaseList.from(PurchaseList.class);
        Root<Courses> rootCourse = queryCourse.from(Courses.class);
        Root<Students> rootStudent = queryStudent.from(Students.class);

        queryPurchaseList.select(rootPurchaseList);
        queryCourse.select(rootCourse);
        queryStudent.select(rootStudent);

        List<PurchaseList> purchaseList = session.createQuery(queryPurchaseList).getResultList();
        List<Courses> courseList = session.createQuery(queryCourse).getResultList();
        List<Students> studentList = session.createQuery(queryStudent).getResultList();

        Transaction transaction = session.beginTransaction();
        CreateLinkedList create = new CreateLinkedList();
        List<LinkedPurchaseList> linkedPurchaseList = create.completionLinkedList(purchaseList, courseList, studentList);
        for (LinkedPurchaseList link : linkedPurchaseList) {
            session.save(link);
        }
        transaction.commit();

        factory.close();
    }
}