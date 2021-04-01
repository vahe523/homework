import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //ex. 1
        ArrayList<String> string = new ArrayList<>();
        string.add("My");
        string.add("name");
        string.add("is");
        string.add("John");
        string.add("Doe");

        Stream<String> stream_ex1 = string.stream();
        Stream<String> s = stream_ex1.map(p -> p.toUpperCase());

        //ex. 2
        Stream<String> stream_ex2 = string.stream();
        Stream<String> s1 = stream_ex2.filter(p -> p.length() < 4);

        //ex. 3
        List<List<String>> list = Arrays.asList(Arrays.asList("15", "26"), Arrays.asList("27", "28"));
        Stream<List<String>> stream_ex3 = list.stream();
        List<String> list_ex3 = stream_ex3.flatMap(p -> p.stream()).collect(Collectors.toList());

        //ex. 4
        List<Integer> list_ex4 = Arrays.asList(15, 16, 78, 5, 1);
        Stream<Integer> stream_ex4 = list_ex4.stream();
        Integer age = stream_ex4.max(Integer::compare).get();

        //ex. 5
        List<Integer> list_ex5 = Arrays.asList(15, 16, 78, 5, 1);
        Stream<Integer> stream_ex5 = list_ex5.stream();
        Integer sum = stream_ex5.mapToInt(Integer::intValue).sum();

        //ex. 6
        Person sara = new Person("Sara", 4, "The US");
        Person viktor = new Person("Viktor", 40, "The UK");
        Person eva = new Person("Eva", 42, "The US");
        Person anna = new Person("Anna", 5, "Netherlands");

        List<Person> collection = Arrays.asList(sara, viktor, eva, anna);
        Stream<Person> stream_ex6 = collection.stream();
        List<String> under_age_of_18 = stream_ex6.filter(p -> p.getAge() < 18).map(p -> p.getName()).collect(Collectors.toList());

        //ex. 7
        List<Person> adult_kid_list = Arrays.asList(sara, viktor, eva, anna);
        Map<Boolean, List<Person>> adult_kid_map = adult_kid_list.stream().
                collect(Collectors.groupingBy(p -> p.getAge() < 18));

        //ex. 8
        List<Person> nationality = Arrays.asList(sara, viktor, eva, anna);
        Map<String, List<Person>> nationality_map = nationality.stream().
                collect(Collectors.groupingBy(Person::getCountry, Collectors.toList()));

        //ex. 9
        List<Person> people_names_list = Arrays.asList(sara, viktor, eva, anna);
        Optional name = people_names_list.stream().map(Person::getName).
                reduce((p1, p2) -> p1 + ", " + p2);

        String people_names_string = "";
        if (name.isPresent())
            people_names_string = "name: " + name.get();
    }
}
