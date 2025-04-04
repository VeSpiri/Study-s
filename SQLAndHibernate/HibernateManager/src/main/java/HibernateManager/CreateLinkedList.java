package HibernateManager;

import Entity.Courses;
import Entity.PurchaseList;
import Entity.Students;

import java.util.ArrayList;
import java.util.List;

public class CreateLinkedList {
    public List<LinkedPurchaseList> completionLinkedList(List<PurchaseList> purchaseList, List<Courses> courses, List<Students> students) {
        List<LinkedPurchaseList> linkedList = new ArrayList<>();


        for (PurchaseList p : purchaseList) {
            for(Courses c : courses) {
                 for (Students s : students) {
                     if (c.getName().equals(p.getCourseName()) && s.getName().equals(p.getStudentName())) {
                         LinkedPurchaseListKey key = new LinkedPurchaseListKey();
                         LinkedPurchaseList linked = new LinkedPurchaseList();
                         key.setStudentId(s.getId());
                         key.setCourseId(c.getId());
                         linked.setCourseId(c.getId());
                         linked.setId(key);
                         linked.setStudentId(s.getId());
                         if (!linkedList.contains(linked)) {
                             linkedList.add(linked);
                         }
                     }
                 }
            }
        }
        return  linkedList;
    }
}
