package PlayWithJavaIncomplet.edu.esprit.game.levels;
import PlayWithJavaIncomplet.edu.esprit.game.models.Employee;
import PlayWithJavaIncomplet.edu.esprit.game.utils.Data;
import java.util.List;
import static java.lang.System.*;

public class Level1 {
	public static void main(String[] args) {
		List<Employee> employees = Data.employees();

		/* TO DO 1: Afficher tous les employ�s */
		employees.stream().forEach(employee -> System.out.println(employee));
		/*
		 * TO DO 2: Afficher les employ�s dont le nom commence par la lettre n
		 */
		employees.stream().filter(employee -> employee.getName().startsWith("n")).forEach(employee -> System.out.println(employee));

		/*
		 * TO DO 3: Afficher les employ�s dont le nom commence par la lettre n
		 * et le salaire> 1000
		 */
		employees.stream().filter(employee -> employee.getName().startsWith("n")).filter(employee -> employee.getSalary()>1000)
				.forEach(employee -> employee.toString());

		/*
		 * TO DO 4: Afficher les employ�s dont le nom commence par la lettre s
		 * tri�s par salaire
		 */
		employees.stream().filter(employee -> employee.getName().startsWith("s"))
				.sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
				.forEach(employee -> System.out.println(employee));

		/*
		 * TO DO 5: Afficher les noms des employ�s dont le salaire > 600 avec 2
		 * mani�res diff�rentes
		 */
		/* First Way */
		employees.stream().filter(employee -> employee.getSalary()>600).forEach(employee -> System.out.println(employee.getName()));
		/* Second Way */
		 // employees.stream().filter(/* TO DO 5 */).map(/* TO DO 5 */)
		 //		.forEach(employee -> System.out.println(employee));

		/*
		 * TO DO 6: Ajouter 200 D pour les employ�s dont le nom commence avec m
		 * et les affich�s ensuite
		 */
		employees.stream().filter(employee -> employee.getName().startsWith("m"))
				.forEach(employee -> {employee.setSalary(employee.getSalary() + 200);System.out.println(employee);}) ;
	}
}
