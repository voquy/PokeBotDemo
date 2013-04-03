package fr.univaix.iut.pokebattle.twitter;

import static org.fest.assertions.Assertions.assertThat;

import java.io.InputStream;

import org.junit.Test;

import fr.univaix.iut.pokebattle.tuse.Credentials;

public class CredentialsTest {
    @Test
    public void testLoadCredentialsGivenAValidPropertiesFileShouldReturnAValidCredentials() throws Exception {
    	/*
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("./twitter4j.properties");
        Credentials credentials = Credentials.loadCredentials(inputStream);
<<<<<<< HEAD
        assertThat(credentials.getConsumerKey()).isEqualTo("3AllOsuY8eEwoC9rSINMFA");
        assertThat(credentials.getConsumerSecret()).isEqualTo("2wIOmodDjm1cdUvYYM5IFnlM0rEXPWWIqW9Oj7nnU");
        assertThat(credentials.getToken()).isEqualTo("1283340398-FNj8FCV82GdYwMjzEk8RBjri4jhdzbTPbJ8EgUT");
        assertThat(credentials.getTokenSecret()).isEqualTo("SwdXrcx7rfYQyL6XOdWFfOaQH5iRaQutOFgPH6fWRYg");
=======
        assertThat(credentials.getConsumerKey()).isEqualTo("*******");
        assertThat(credentials.getConsumerSecret()).isEqualTo("*******");
        assertThat(credentials.getToken()).isEqualTo("*******");
        assertThat(credentials.getTokenSecret()).isEqualTo("*******");
<<<<<<< HEAD
=======

>>>>>>> master
        */
    }
}
