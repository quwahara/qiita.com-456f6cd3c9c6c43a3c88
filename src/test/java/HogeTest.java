import static org.junit.Assert.assertEquals;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;


public class HogeTest {

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext();
        try {
            ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine engine = factory.getEngineByName("nashorn");
            
            Resource r = appCtx.getResource("classpath:/META-INF/resources/webjars/sugar/1.4.1/sugar-full.min.js");
            String sugarJs = IOUtils.toString(r.getInputStream(), "UTF-8");

            String input = "HogeTest";
            String s = "";
            s += sugarJs + "\n";
            s += "var input = '" + input + "'" + "\n";
            s += "var actual = input.dasherize()" + "\n";

            engine.eval(s);

            assertEquals("hoge-test", engine.get("actual"));

        } finally {
            appCtx.close();
        }
    }
}
