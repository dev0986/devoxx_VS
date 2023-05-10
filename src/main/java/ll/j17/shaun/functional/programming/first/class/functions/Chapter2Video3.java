package ll.j17.shaun.functional.programming;
//Treating functionas as other types.
public class Chapter2Video3 {

    protected static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.age = age;
            this.name = name;
        }
    }

    protected static class DataLoader {

        public final ll.j17.shaun.functional.programming.NoArgsfunction<Person> loadPerson;

        public DataLoader(Boolean isDevelopment) {
            this.loadPerson = isDevelopment
                    ? this::loadPersonFake //Object of type Function (::)
                    : this::loadPersonReal;
        }

        private Person loadPersonReal() {
            System.out.println("Loading real person");
            return new Person("Real person", 25);
        }

        private Person loadPersonFake() {
            System.out.println("Loading fake person");
            return new Person("Fake person", 100);
        }
    }

    public static void main(String[] args) {
        final Boolean IS_DEVELOPMENT = Boolean.TRUE;
        DataLoader dataLoader = new DataLoader(IS_DEVELOPMENT);
        dataLoader.loadPerson.apply();
    }
}
