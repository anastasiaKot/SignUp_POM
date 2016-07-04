package core;

import net.sf.testng.databinding.DataBinding;
import net.sf.testng.databinding.TestInput;
import net.sf.testng.databinding.TestOutput;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConfirmationPageTest
{
@DataBinding()
@Test(groups = "csv")
public void testSumCSV( @TestInput(name = "x") int x,
                        @TestInput(name = "y") int y,
                        @TestOutput(name = "z") int sum)
{
assertThat(x + y, is(equalTo(sum)));
}

}
