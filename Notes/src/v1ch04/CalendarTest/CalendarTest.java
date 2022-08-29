package v1ch04.CalendarTest;
import java.time.*;

public class CalendarTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();   //使用静态工厂方法构造一个对象，并用当前的日期初始化
        int month = date.getMonthValue();   //获得当前的月份
        int today = date.getDayOfMonth();   //获得当前的日期

        date = date.minusDays(today - 1); // 把date设置为当月的第一天
        DayOfWeek weekday = date.getDayOfWeek();    //得到这一天是星期几(星期一、星期二...)
        int value = weekday.getValue(); // 1 = Monday, . . . , 7 = Sunday

        /*
        当月的第一天需要对齐正确的星期几
        如果当月的第一天对应星期天的话
        那么就需要很多的空格来缩进
        这样才能对齐
         */
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++){
            System.out.print("    ");
        }
        // 打印日历的主体
        while (date.getMonthValue() == month)
        {
            // date遍历一个月中的每一天
            System.out.printf("%3d", date.getDayOfMonth()); // 打印遍历到的这一天的日期
            if (date.getDayOfMonth() == today) {
                // 如果遍历到的这一天正好是今天
                System.out.print("*");
            }
            else{
                System.out.print(" ");
            }
            date = date.plusDays(1);    // 把date推到下一天
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();  // 如果达到新的一周的第一天则换行
            }
        }
        if (date.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }
    }
}
