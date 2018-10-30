package base;

public class PersonImpl implements Person {
    private Person spouse;
    private final boolean man;
    private final String name;

    public PersonImpl(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    @Override
    public  boolean getMan() {
        return man;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Person getSpouse() {
        return this.spouse;
    }

    @Override
    public void setSpouse(Person person) {
        this.spouse = person;
    }

    @Override
    public boolean marry(Person person) {
        boolean cond = false;
        if (man != person.getMan() && spouse != person) {
            if (spouse != null) {
                this.divorce();
            }
            if (person.getSpouse() != null) {
                person.divorce();
            }
            spouse = person;
            person.setSpouse(this);
            cond = true;
        }
        return cond;
    }

    @Override
    public boolean divorce() {
        boolean cond = false;
        if (spouse != null) {
            spouse.setSpouse(null);
            spouse = null;
            cond = true;
        }
        return cond;
    }
}