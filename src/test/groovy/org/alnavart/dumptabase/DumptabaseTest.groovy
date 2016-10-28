package org.alnavart.dumptabase

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner)
@SpringBootTest
class DumptabaseTest
{

    @Test
    void contextLoads()
    {
    }

    @Test
    void testsConnection()
    {
        DumtabaseConection connection =
            new DumtabaseConection(
                user: 'user',
                password: 'password',
                url: 'url',
                port: 'port',
                name: 'databaseName',
                type: DatabaseTypes.H2)
        TestConnectionUseCase testConnectionUseCase = new TestConnectionUseCase()

        ConnectionStatusTypes status = testConnectionUseCase.execute connection

        assert status.equals(ConnectionStatusTypes.OK)
    }
}
