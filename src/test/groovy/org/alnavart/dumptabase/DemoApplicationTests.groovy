package org.alnavart.dumptabase

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner)
@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void actuatorUp() {
		def htmlResponse = "http://localhost:8080/info".toURL().text
	}

	@Test
	void databaseIsPopulated() {
		print "hola"
		print "adios"


	}
}
