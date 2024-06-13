package cl.web.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		String sql = "SELECT DB_NAME() AS DataBaseName";
        String nombre = jdbcTemplate.queryForObject(sql, String.class);
        System.out.println(nombre);
		return nombre;
	}
}