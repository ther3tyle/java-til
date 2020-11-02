package io.dsub.day21;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class RomanConverterTest {

    private RomanConverter romanConverter;

    @Before
    public void setUp() throws Exception {
        this.romanConverter = new RomanConverter();
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsExceptionWhenRomanNotSet() {
        expectedException.expect(NullPointerException.class);
        romanConverter.transform();
    }

    @Test
    public void convertI() {
        romanConverter.setRoman("I");
        int actualResult = romanConverter.transform();
        assertThat(actualResult, is(equalTo(1)));
    }

    @Test
    public void convertX() {
        romanConverter.setRoman("X");
        int actualResult = romanConverter.transform();
        assertThat(actualResult, is(equalTo(10)));
    }

    @Test
    public void convertIII() {
        romanConverter.setRoman("III");
        int actualResult = romanConverter.transform();
        assertThat(actualResult, is(equalTo(3)));
    }

    @Test
    public void convertIV() {
        romanConverter.setRoman("IV");
        int actualResult = romanConverter.transform();
        assertThat(actualResult, is(equalTo(4)));
    }

    @Test
    public void convertVI() {
        romanConverter.setRoman("VI");
        int actualResult = romanConverter.transform();
        assertThat(actualResult, is(equalTo(6)));
    }
}