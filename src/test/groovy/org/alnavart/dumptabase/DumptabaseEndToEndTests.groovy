package org.alnavart.dumptabase

import groovy.json.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
class DumptabaseEndToEndTests
{

	@Test
	void actuatorUp() {
		JsonSlurper jsonSlurper = new JsonSlurper()
		def htmlResponse = "http://localhost:8080/info".toURL().text
		def response = jsonSlurper.parseText("$htmlResponse.value")

		assert response.build.name == 'dumptabase'
	}
}
