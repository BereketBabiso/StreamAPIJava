package lesson9Prob8;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
	public static final Consumer<List<Employee>> consumer = e->e.stream()
				.filter(x->x.getSalary()>85000 && x.getFirstName().charAt(0)<'R')
				.map(x->x.getFirstName()+" "+x.getLastName()).sorted().forEach(x->System.out.print(x+", "));

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee("Joe", "Davis", 120000),
				          new Employee("John", "Sims", 110000),
				          new Employee("Joe", "Stevens", 200000),
		                  new Employee("Andrew", "Reardon", 80000),
		                  new Employee("Joe", "Cummings", 760000),
		                  new Employee("Steven", "Walters", 135000),
		                  new Employee("Thomas", "Blake", 111000),
		                  new Employee("Alice", "Richards", 101000),
		                  new Employee("Donald", "Trump", 100000));
		
		//print the number of Employees in list whose salary > 100000 and whose last name begins
		//with a letter that comes after the letter 'E'
		
		System.out.println(list.stream().filter(e->e.getSalary()>100000 && (e.getLastName().charAt(0)>'E'))
								.map(e->1).reduce(0,(a,b) -> a+b));//we can also use count()
		
		//print a list of sorted full names - all upper case -- of Employees with
		//salary > 85000 and whose first name begins with a letter that comes before  the letter 'R'
		
		/*//This is the solution needed for this question, below is the Option B
		list.stream().filter(e->e.getSalary()>85000 && e.getFirstName().charAt(0)<'R')
						.map(e->e.getFirstName().toUpperCase()+" "+e.getLastName().toUpperCase())
						.sorted().forEach(System.out::println);*/
		consumer.accept(list);
		System.out.println();
		
//		List<String>list1 = Arrays.asList("Bereket","Babiso");
//		List<String>list2 = Arrays.asList("Adan","Babiso");
//		List<String>list3 = Arrays.asList("Lisa","Assefa");
//		List<List<String>>listNames = Arrays.asList(list1,list2,list3);
//		listNames.stream().map(n -> n.stream().collect(Collectors.joining(" "))).sorted(Comparator.comparing(String::length).reversed().thenComparing(String::compareTo).reversed()).forEach(n->System.out.print(n+"; "));

		List<Number> xx = new ArrayList<>();
		xx.add(3.6);
		xx.add(2);
		System.out.println(xx);
	}

}
