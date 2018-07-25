package test.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class MysqlDemo {

    public static void main(String[] args) {
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/neteagle3?useUnicode=yes&characterEncoding=gbk";//
        //MySQL配置时的用户名
        String user = "eccom";
        //MySQL配置时的密码
        String password = "eccom";
        //遍历查询结果集
        ResultSet rst = null;
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select * from t_common_role where name='部门经理' ;";
            //3.ResultSet类，用来存放获取的结果集！！
            rst = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");  
            System.out.println("-----------------");  
             
            ResultSetMetaData rsmd = rst.getMetaData() ;
			int count=rsmd.getColumnCount(); 
			for(int i=1;i<=count;i++){	
				// 获取列名
				String columnName = rsmd.getColumnName(i);  
				System.out.print(columnName + " | ");
            }  
			System.out.println("");
			System.out.println("---------------------------");
			while (rst.next()) {
				for(int i=1;i<=count;i++){
					String value = rst.getString(i);
					System.out.print( value + " | ");
	            } 
				System.out.println("");
			}
           
        } catch(ClassNotFoundException e) {   
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
        	Statement s;
			try {
				s = rst.getStatement();
				rst.close();
	    		s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
            System.out.println("数据库数据成功获取！！");
        }
    }
}
