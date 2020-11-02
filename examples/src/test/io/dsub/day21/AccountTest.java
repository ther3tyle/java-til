package io.dsub.day21;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class AccountTest {

    private Account account;

    // BeforeClass -> Before -> Test1 -> After -> Before -> Test2 -> After -> AfterClass

    @BeforeClass
    public static void classSetup() {
        // what you need to do only once
    }

    @Before
    public void setUpBySetBalanceOneHundred() {
        account = new Account(100);
    }

    @Test
    public void answerIsMinusWithNegativeBalance() {
        account.withdraw(200);
        boolean actualResult = account.isMinus();
        assertThat(actualResult, is(equalTo(true)));
    }

    @Test
    public void answerIsNotMinusWithPositiveBalance() {
        account.withdraw(50);
        boolean actualResult = account.isMinus();
        assertThat(actualResult, is(not(equalTo(true))));
    }

    @Test
    public void checkPositiveBalanceAfterWithdrawal() {
        account.withdraw(80);
        int actualResult = account.getBalance();

        assertThat(actualResult, is(equalTo(20)));
    }

    @Test
    public void checkNegativeBalanceAfterWithdrawal() {
        account.withdraw(120);
        int actualResult = account.getBalance();
        assertThat(actualResult, is(equalTo(-20)));
    }

    @Test
    @Ignore("this will be tested later")
    public void toBeDetermined() {

    }

    @Test(expected = ArithmeticException.class)
    public void checkExceptionByAnnotation() {
        account.throwException();
    }

    @Test
    public void checkExceptionByTryCatch() {
        try {
            account.throwException();
            fail("expected exception to be thrown");
        } catch (ArithmeticException exception) {
            assertThat(exception, is(instanceOf(ArithmeticException.class)));
        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none(); // none 으로 단순 초기화

    @Test
    public void checkExpectedExceptionByRule() {
        thrown.expect(ArithmeticException.class);
        account.throwException();
    }


}