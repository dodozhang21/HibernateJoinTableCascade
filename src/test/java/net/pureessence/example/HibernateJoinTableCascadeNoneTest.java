package net.pureessence.example;

import net.pureessence.example.dao.GenericDaoImpl;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.Assert.fail;

@ContextConfiguration(locations={"/TestContext.xml"})
@Transactional
public class HibernateJoinTableCascadeNoneTest extends AbstractHibernateJoinTable {
    @Autowired
    private GenericDaoImpl<Person> personDao;

    @Autowired
    private GenericDaoImpl<Bank> bankDao;

    @Autowired
    private GenericDaoImpl<Audit> auditDao;

    @Test
    public void createPerson() {
        Person person = new Person();
        person.setFirstName("bubo");
        person.setLastName("lee");

        person.getAudits().add(audit("saved"));

        personDao.save(person);
    }

    private static Audit audit(String action) {
        Audit audit = new Audit();
        audit.setAction(action);
        return audit;
    }
}
