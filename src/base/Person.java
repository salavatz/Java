package base;
public interface Person {
    String getName();
    boolean getMan();
    boolean marry(Person person);// поженить двух персонов и сохранить ссылку на супругу
    boolean divorce();// разводит супругов, у обоих супругов ссылка в NULL
    Person getSpouse();
    void setSpouse(Person person);
}

