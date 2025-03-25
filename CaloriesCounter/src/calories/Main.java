package calories;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		StepTracker tracker = new StepTracker();
		int userInput = 1;
		
		while (userInput != 0)
		{
			printMenu();
			userInput = scanner.nextInt();
			switch(userInput)
			{
				case 1:
					System.out.println("Enter month:\n");
					String month = scanner.next();
					System.out.println("Enter day:\n");
					int day = scanner.nextInt();
					System.out.println("Enter number of steps:\n");
					int steps = scanner.nextInt();
					tracker.SaveSteps(month,day,steps);
					break;
				case 2:
					System.out.println("Enter month:\n");
					String month1 = scanner.next();
					tracker.StatisticMonth(month1);
					break;
				case 3:
					System.out.println("Enter new daily aim:\n");
					int daily = scanner.nextInt();
					tracker.aimSteps = daily;
					System.out.println("New daily aim: " + tracker.aimSteps + "\n");
					break;
				case 4:
					userInput = 0;
					break;
			}
		}
		System.out.println("Program has finished");
	}
	
	private static void printMenu()
	{
		System.out.println("Choose action:\n1.Enter the number of steps in day\n2.Show statistic in last month\n3.Change aim for daily steps number\n4.Exit the application");
	}
}