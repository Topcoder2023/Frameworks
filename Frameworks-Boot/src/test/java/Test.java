import com.gitee.frameworks.boot.FrameworksBoot;

/**
 * @author hongda.li@hand-china.com 2022/7/11 15:04
 */
public class Test {

    @org.junit.Test
    public void test(){
        FrameworksBoot.run(new String[]{});
        System.out.println(FrameworksBoot.getInitParam().getBoot().getName());
    }
}
