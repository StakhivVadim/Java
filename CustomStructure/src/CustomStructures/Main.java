package CustomStructures;

import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.jar.Attributes.Name;
import java.util.stream.Stream;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Петр", Arrays.asList(
                new Book("Война и Мир", 350, 1997),
                new Book("1984", 450, 2019),
                new Book("Евгений Онегин", 750, 2005),
                new Book("Мастер и Маргарита", 400, 2013),
                new Book("Гарри Поттер", 500, 2020)
            )),
            new Student("Иван", Arrays.asList(
                new Book("Двенадцать стульев", 400, 2014),
                new Book("Мертвые души", 380, 2020),
                new Book("Горе от ума", 600, 2001),
                new Book("Отцы и дети", 330, 2015),
                new Book("Властелин колец", 800, 1996)
            )),
            new Student("Александр", Arrays.asList(
            	new Book("Война и Мир", 350, 1997),
            	new Book("1984", 450, 2019),
            	new Book("Мастер и Маргарита", 400, 2013),
                new Book("Собачье сердце", 650, 2009),
                new Book("Шерлок Холмс", 600, 2022)
            ))
        );
        
        students.stream()
        	.peek(student -> System.out.println(student)) 				// Вывести в консоль каждого студента
        	.map(Student::getBooks)										// Получить для каждого студента список книг
        	.flatMap(List::stream)             							// Получить книги
        	.sorted(Comparator.comparingInt(Book::getPages))            // Отсортировать книги по количеству страниц
        	.distinct()                                                 // Оставить только уникальные книги
        	.filter(book -> book.getYear() > 2000)                      // Отфильтровать книги, оставив только те, которые были выпущены после 2000 года
        	.limit(3)                                                   // Ограничить стрим на 3 элементах
        	.map(Book::getYear)                                         // Получить из книг годы выпуска
        	.findFirst()                                                // При помощи методов короткого замыкания вернуть Optional от книги
        	.ifPresentOrElse(											// Вывести в консоль год выпуска найденной книги, либо запись о том, что такая книга отсутствует
        			year -> System.out.println("Год выпуска найденной книги: " + year),
        			() -> System.out.println("Книга не найдена")
        			);
    }
}

