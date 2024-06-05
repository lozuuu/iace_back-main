package com.garage.garage;

import com.garage.garage.Client.Client;
import com.garage.garage.Client.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ClientRepositoryTests {

    @Autowired
    private ClientRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateClient(){
        Client client = new Client();
        client.setImie("Jan");
        client.setNazwisko("Kowalski");
        client.setAdresEmail("adres@gmail.com");
        client.setNumerTelefonu("123456789");
        client.setHaslo("123456");
        client.setIsClient(Boolean.TRUE);

       Client savedClient = repo.save(client);

       Client existClient = entityManager.find(Client.class,savedClient.getId());

       assertThat(existClient.getAdresEmail()).isEqualTo(client.getAdresEmail());
    }

    @Test
    public void testFindClientbyEmail(){
        String email = "dwdwcdwefw@wp.pl";
        Client client = repo.findByAdresEmail(email);
        assertThat(client).isNotNull();
    }

}
