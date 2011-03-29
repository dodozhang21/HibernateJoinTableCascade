package net.pureessence.example;

import java.util.HashSet;
import java.util.Set;

public class Bank extends BaseBean {
    private String name;
    private Set<Audit> audits = new HashSet<Audit>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Set<Audit> audits) {
        this.audits = audits;
    }
}
