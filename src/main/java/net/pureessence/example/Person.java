package net.pureessence.example;

import java.util.HashSet;
import java.util.Set;

public class Person extends BaseBean {
    private String firstName;
    private String lastName;
    private Set<Audit> audits = new HashSet<Audit>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Set<Audit> audits) {
        this.audits = audits;
    }
}
