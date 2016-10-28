package org.alnavart.dumptabase

import groovy.json.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DumptabaseEndToEndTest
{
    @LocalServerPort
    int port;

    @Test
    void actuatorUp()
    {
        JsonSlurper jsonSlurper = new JsonSlurper()
        def htmlResponse = "http://localhost:${port}/info".toURL().text
        def response = jsonSlurper.parseText("$htmlResponse.value")

        assert response.build.name == 'dumptabase'
    }
}
