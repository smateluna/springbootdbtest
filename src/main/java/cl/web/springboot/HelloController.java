package cl.web.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
				Connection conn = null;
        		ResultSet rs = null;
        		PreparedStatement stmt = null;

        		try {
        			Class.net.sourceforge.jtds.jdbc.Driver.newInstance();	//net.sourceforge.jtds.jdbc.Driver
        		} catch (ClassNotFoundException ex){
        			throw new ClassNotFoundException("BAD DRIVER");
        		} catch (InstantiationException e) {
        			throw new IllegalAccessException("BAD DRIVER");
        		} catch (IllegalAccessException e) {
        			throw new IllegalAccessException("BAD DRIVER");
        		}

        		try {
        			conn = DriverManager.getConnection("jdbc:jtds:sqlserver://maipo.cbrs.local:1433/flujo", "sa", "sa");	// (jdbc:jtds:sqlserver://maipo.cbrs.local:1433/flujo , sa , sa )

        			String sql = "SELECT DB_NAME() AS DataBaseName";

        			stmt = conn.prepareStatement(sql);
        			rs = stmt.executeQuery();

        			if(rs.next()){
        				return "BD OK";
        			}

        		}catch (SQLException e){
        			throw new SQLException(e.getMessage());
        		}finally {
        			try { if (rs != null) rs.close(); } catch (Exception e) {throw new SQLException(e.getMessage());}
        			try { if (stmt != null) stmt.close(); } catch (Exception e) {throw new SQLException(e.getMessage());}
        			try { if (conn != null) conn.close(); } catch (Exception e) {throw new SQLException(e.getMessage());}
        		}
        		return "BD NOT OK";
	}

}