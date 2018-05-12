import java.io.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class DemonC {
    public void a() {
        //properties
        ResourceBundle resource = ResourceBundle.getBundle("pro");

        String value1 = resource.getString("height");
        System.out.println(value1);
        String value2 = resource.getString("width");
        System.out.println(value2);
        String value3 = resource.getString("name");
        System.out.println(value3);
    }

    //通过流的方式
    public void b() {
        try {
            //通过类加载器获取到pro.properties文件
            InputStream is = DemonC.class.getClassLoader().getResourceAsStream("pro.properties");
            String path = DemonC.class.getClassLoader().getResource("pro.properties").getPath();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            //获取到配置文件
            Properties resource = new Properties();

            resource.load(br);//加载缓冲流

            String value1 = resource.getProperty("width");

            System.out.println(value1);
            //添加一个内容
            OutputStream out = new FileOutputStream(path);
            resource.put("name","job");
            resource.store(out,"");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new DemonC().b();
    }
}
