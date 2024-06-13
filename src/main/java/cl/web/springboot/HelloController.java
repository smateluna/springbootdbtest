package cl.web.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
public class HelloController {

    private JdbcTemplate jdbcTemplate;
	@GetMapping("/")
	public String index() {
		String sql = "SELECT DB_NAME() AS DataBaseName";
		this.jdbcTemplate = jdbcTemplate;
        String nombre = jdbcTemplate.queryForObject(sql, String.class);
        System.out.println(nombre);
		return nombre;
	}
}