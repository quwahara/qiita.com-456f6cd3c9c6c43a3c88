import static org.junit.Assert.assertEquals;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
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

    @Test
    public void testWithRhino() throws Exception {
        ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext();
        try {
            Context cx = Context.enter();
            try {
                Scriptable scope = cx.initStandardObjects();

                Resource r = appCtx.getResource("classpath:/META-INF/resources/webjars/sugar/1.4.1/sugar-full.min.js");
                String sugarJs = IOUtils.toString(r.getInputStream(), "UTF-8");

                String input = "HogeTest";
                String s = "";
                s += sugarJs + "\n";
                s += "var input = '" + input + "'" + "\n";
                s += "var actual = input.dasherize()" + "\n";

                cx.evaluateString(scope, s, "<cmd>", 1, null);

                assertEquals("hoge-test", scope.get("actual", null));

            } finally {
                Context.exit();
            }
        } finally {
            appCtx.close();
        }
    }

}
