package net.pureessence.example;

import org.junit.Test;

import org.springframework.test.context.ContextConfiguration;

import static junit.framework.Assert.fail;

@ContextConfiguration(locations={"/Repository.xml", "/TestContext.xml"})
public class HibernateJoinTableCascadeNoneTest extends AbstractHibernateJoinTable {

    @Test
    public void testSmth() {
        fail("not implemented");
    }
}
