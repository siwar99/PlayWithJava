package PlayWithJavaIncomplet.edu.esprit.game.levels;
import PlayWithJavaIncomplet.edu.esprit.game.models.Employee;
import PlayWithJavaIncomplet.edu.esprit.game.utils.Data;
import java.util.*;
import java.util.stream.Collectors;


public class Level3 {
	public static void main(String[] args) {
		List<Employee> employees = Data.employees();

		/* TO DO 1: Retourner une chaine de caract�re qui contient tous les noms des employ�s */
		String names = employees.stream()
				.map(Employee::getName)
				.collect(Collectors.joining(", "));
		System.out.println("Tous les noms des employ�s: " + names);

		/* TO DO 2: Retourner une chaine de caract�re qui contient tous les noms des employ�s en majuscule separ�s par # */
		String namesMajSplit = employees.stream()
				.map(Employee::getName)
				.map(String::toUpperCase)
				.collect(Collectors.joining("#"));
		System.out.println("Tous les noms des employ�s en majuscule separ�s par #: " + namesMajSplit);

		/* TO DO 3: Retourner une set d'employ�s */
		Set<Employee> emps = employees.stream().collect(Collectors.toSet());
		System.out.println("Set d'employ�s: " + emps);

		/* TO DO 4: Retourner une TreeSet d'employ�s (tri par nom) */
		TreeSet<Employee> emps2 = employees.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getName))));
		System.out.println("TreeSet of employees): " + emps2);

		/* TO DO 5: Retourner une Map qui regroupe les employ�s par salaire */
		Map<Integer, List<Employee>> map = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalary));
		System.out.println("Une Map qui regroupe les employ�s par salaire: " + map);

		/* TO DO 6: Retourner une Map qui regroupe les noms des employ�s par salaire */
		Map<Integer, String> mm = employees.stream().collect(Collectors.toMap(Employee::getSalary, Employee::getName, (name1, name2) -> name1 + ", " + name2));
		System.out.println("Une Map qui regroupe les noms des employ�s par salaire: " + mm);

		/* TO DO 7: Retourner le min, max, average, sum, count des salaires */
		String s = employees.stream()
				.collect(Collectors.summarizingInt(Employee::getSalary))
				.toString();
		System.out.println("Le min, max, average, sum, count des salaires: " + s);

	}
}