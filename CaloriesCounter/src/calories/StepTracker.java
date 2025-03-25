package calories;
import java.util.HashMap;

public class StepTracker {

	HashMap<String, MonthData> monthData = new HashMap<String, MonthData>();
	private String[] months = {"Январь","Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь", "Декабрь"};
	public int aimSteps = 10000;
	
	public StepTracker()
	{
		for (String month : months) 
		{
            monthData.put(month, new MonthData());
        }
	}
	
	public void SaveSteps(String month, int day, int steps)
	{
		if (monthData.containsKey(month)) {
            monthData.get(month).SetSteps(day, steps);
        } else {
            System.out.println("Ошибка: указанного месяца нет в списке.");
        }
	}
	
	public void StatisticMonth(String month)
	{
		if (monthData.containsKey(month)) {
            monthData.get(month).ShowStatistic();
        } else {
            System.out.println("Ошибка: указанного месяца нет в списке.");
        }
	}
	
	class MonthData
	{
		private HashMap<Integer, Integer> stepsData = new HashMap<Integer,Integer>();
		
		public MonthData()
		{
			for (int i = 1; i <= 30; i++)
			{
				stepsData.put(i, 0);
			}
		}
		
		public void SetSteps(int day, int steps) {
            if (day >= 1 && day <= 30) {
                stepsData.put(day, steps);
            } else {
                System.out.println("Ошибка: день должен быть от 1 до 30.");
            }
        }

		public void ShowStatistic()
		{
			int totalSteps = 0;
			int maxSteps = 0;
			int strick = 0;
			int maxStrick = 0;
			int steps = 0;
			Converter converter = new Converter();
			
			for (int i = 1; i <= 30; i++)
			{
				steps = stepsData.get(i);
				System.out.println(i + "день:" + steps);
				totalSteps += stepsData.get(i);
				if (maxSteps < steps) maxSteps = steps;
				if (steps >= aimSteps) strick++; else strick = 0; 
				if (maxStrick < strick) maxStrick = strick;
			}
			
			System.out.println("Общее количество шагов:" + totalSteps);
			System.out.println("Максимально пройденное количество шагов за месяц:" + maxSteps);
			System.out.println("Среднее количество шагов:" + totalSteps/stepsData.size());
			System.out.println("Пройденная дистанция:" + converter.ConvertToKm(totalSteps));
			System.out.println("Количество сожженых каллорий:" + converter.ConvertToCalories(totalSteps));
			System.out.println("Максимальное количество дней подряд с выполненной целью:" + maxStrick);
			
			
		}


	}
	
	class Converter
	{
		public float ConvertToKm(int steps)
		{
			return (steps*3/4);
		}
		
		public float ConvertToCalories(int steps)
		{
			return steps*50/1000;
		}
	}
}


