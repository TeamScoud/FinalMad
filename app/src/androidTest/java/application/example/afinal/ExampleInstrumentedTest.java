package application.example.afinal;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("application.example.afinal", appContext.getPackageName());
    }

    @Rule
    public final ActivityScenarioRule<MainActivity2> main = new ActivityScenarioRule<>(MainActivity2.class);
    @Test
    public void testSubjectnullValue() {
        onView(withId(R.id.edtSubject)).perform(typeText(""));
        onView(withId(R.id.btn)).perform(click());

    }

    @Test
    public void testSubjectNumbers() {
        onView(withId(R.id.edtSubject)).perform(typeText("123"));
        onView(withId(R.id.btn)).perform(click());

    }

    @Test
    public void testSubjectscapitalletters() {
        onView(withId(R.id.edtSubject)).perform(typeText("ABC"));
        onView(withId(R.id.btn)).perform(click());

    }
    @Rule
    public final ActivityScenarioRule<Appoinments> main1 = new ActivityScenarioRule<>(Appoinments.class);
    @Test
    public void testAppoinmentnullValue() {
        onView(withId(R.id.e1)).perform(typeText(""));
        onView(withId(R.id.button)).perform(click());

    }

}