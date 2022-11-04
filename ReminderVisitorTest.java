package hacs;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReminderVisitorTest {

    @Test
    void visitAssignment() {
        ReminderVisitor rv=new ReminderVisitor(new Reminder());
        Assignment Aa=new Assignment();
        Aa.setAssignmentName("SER 515-FSE");
        Aa.setDueDate(new Date());
        assertNotNull(rv.getReminder().listupcoming);

    }
}