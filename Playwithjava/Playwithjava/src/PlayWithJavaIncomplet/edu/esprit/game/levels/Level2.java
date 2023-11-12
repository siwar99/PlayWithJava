package PlayWithJavaIncomplet.edu.esprit.game.levels;
import PlayWithJavaIncomplet.edu.esprit.game.models.Employee;
import PlayWithJavaIncomplet.edu.esprit.game.utils.Data;
import java.util.List;
import java.util.stream.Collectors;

public class Level2 {
	public static void main(String[] args) {
	List<Employee> employees = Data.employees();


	long nbr = employees.stream().filter(e -> e.getName().startsWith("n")).count();
	System.out.println("Nombre des employ�s dont le nom commence avec n : " + nbr);


	long sum = employees.stream().mapToLong(Employee::getSalary).sum();
	System.out.println("La somme des salaires de tous les employes: " + sum);
		
	double average = employees.stream().filter(e -> e.getName().startsWith("s")).mapToDouble(Employee::getSalary).average().orElse(0);
	System.out.println("La moyenne des salaires des employes dont le nom commence avec s: " + average);

	List<Employee> emps = employees.stream().collect(Collectors.toList());
		System.out.println("List de tous les employes: " + emps);

	List<Employee> emps2 = employees.stream().filter(e -> e.getName().startsWith("s")).collect(Collectors.toList());
	System.out.println("La liste des employ�s dont le nom commence par s: " + emps2);
		

	boolean test = employees.stream().anyMatch(e -> e.getSalary() > 1000);
	System.out.println("Does at least one employee have a salary greater than 1000? " + test);


	employees.stream().filter(e -> e.getName().startsWith("s")).findFirst().ifPresent(e -> System.out.println("Le premier employ� dont le nom commence avec s: " + e));


	/* TO DO 8: Afficher le second employ� dont le nom commence avec s */
	employees.stream().filter(e -> e.getName().startsWith("s")).skip(1).findFirst().ifPresent(e -> System.out.println("Le second employ� dont le nom commence avec: " + e));

	}
}
