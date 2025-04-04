import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "testtest";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name, count(*) / " +
                    "(max(month(subscription_date)) -  min(month(subscription_date)) + 1) avg " +
                    "FROM purchaselist group by course_name");

            System.out.println("Название курса | Скреднее количество покупок за месяц");
            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                float avg = resultSet.getFloat("avg");
                System.out.println(courseName + " | " + avg);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
