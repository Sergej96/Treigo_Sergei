import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import static org.assertj.core.api.Java6Assertions.catchThrowable;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ExpressionParseTest {

    ExpressionParse parse;

    @Before
    public void setUp() {
        parse = new ExpressionParse();
    }

    @Test
    public void parseTest() {
        String str = "2+2";
        List<String> actual = ExpressionParse.parse(str);
        List<String> expected = Arrays.asList("2", "2", "+");
        assertThat(actual, is(expected));
    }

    @Test
    public void pasrseTestBrackets() {
        String str = "(2+2)*3";
        List<String> actual = ExpressionParse.parse(str);
        List<String> expected = new ArrayList<String>(Arrays.asList("2", "2", "+", "3", "*"));
        assertThat(actual, is(expected));
        expected.clear();
        str = "3*(2+2)";
        actual = ExpressionParse.parse(str);
        expected = Arrays.asList("3", "2", "2", "+", "*");
        assertThat(actual, is(expected));
    }

    @Test(expected = NumberFormatException.class)
    public void parseTestOpenBrackets() throws NumberFormatException {
        String str = "(2+2*3";
        List<String> actual = ExpressionParse.parse(str);
        /*
        List<String> expected= Arrays.asList("2","2","+","3","*");
        assertThat(actual,is(expected));
        Throwable thrown = catchThrowable(()->{
            ExpressionParse.parse(str);
        });
        assertThat(thrown.getMessage()).isNotBlank();
        */
    }

    @Test(expected = NumberFormatException.class)
    public void parseTestClosedBrackets() throws NumberFormatException {
        String str = "2+2)*3";
        ExpressionParse.parse(str);
    }

    @Test(expected = NumberFormatException.class)
    public void parseTestDoubleAdd() throws NumberFormatException {
        String str = "2++";
        ExpressionParse.parse(str);
    }

    @Test(expected = NumberFormatException.class)
    public void parseTestDoubleSub() throws NumberFormatException {
        String str = "2--";
        ExpressionParse.parse(str);
    }

    @Test(expected = NumberFormatException.class)
    public void parseTestDoubleMul() throws NumberFormatException {
        String str = "2**";
        ExpressionParse.parse(str);
    }

    @Test(expected = NumberFormatException.class)
    public void parseTestDoubleDiv() throws NumberFormatException {
        String str = "2//";
        ExpressionParse.parse(str);
    }
}