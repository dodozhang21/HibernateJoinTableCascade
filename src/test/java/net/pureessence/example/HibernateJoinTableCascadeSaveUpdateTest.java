package net.pureessence.example;

import net.pureessence.example.dao.GenericDaoImpl;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.Assert.*;

@ContextConfiguration(locations={"/TestContext.xml"})
@Transactional
public class HibernateJoinTableCascadeSaveUpdateTest extends AbstractHibernateJoinTable {
    @Autowired
    private GenericDaoImpl<Person> personDao;

    @Autowired
    private GenericDaoImpl<Bank> bankDao;

    @Autowired
    private GenericDaoImpl<Audit> auditDao;


    @Test
    @Rollback(false)
    public void deleteBank() {
        Bank bank = bankDao.getById(1L);

        assertEquals(1L, bank.getId().longValue());
        assertEquals("very special bank", bank.getName());
        assertEquals(1, bank.getAudits().size());

        Audit bankAudit = bank.getAudits().iterator().next();
        assertEquals(2L, bankAudit.getId().longValue());
        assertEquals("inserted", bankAudit.getAction());

        bankDao.delete(bank);

        assertNotNull("delete should not be cascaded", auditDao.getById(2L));

        assertEquals(2, auditDao.getAll().size());
    }

    @Test
    @Rollback(false)
    public void deleteJustAudit() {
        Person person = personDao.getById(1L);

        assertEquals(1L, person.getId().longValue());
        assertEquals("bubo", person.getFirstName());
        assertEquals("lee", person.getLastName());

        Audit personAudit = person.getAudits().iterator().next();
        assertEquals(1L, personAudit.getId().longValue());
        assertEquals("saved", personAudit.getAction());

        person.getAudits().remove(personAudit);

        personDao.save(person);

        assertNotNull("child should not be removed", auditDao.getById(1L));

        assertEquals(2, auditDao.getAll().size());
    }

    private static Audit audit(String action) {
        Audit audit = new Audit();
        audit.setAction(action);
        return audit;
    }
}
