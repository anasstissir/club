package ma.uir.club.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import ma.uir.club.IntegrationTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@IntegrationTest
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
