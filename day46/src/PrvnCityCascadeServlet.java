import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/29 9:19
 */
@WebServlet("/PrvnCityCascadeServlet")
public class PrvnCityCascadeServlet extends HttpServlet {

    private static Map<String, String[]> map = new HashMap<>(3);

    static {
        map.put("广东省", new String[]{"江门市", "鹤山市", "广州市"});
        map.put("广西省", new String[]{"南宁市", "桂平市"});
        map.put("福建省", new String[]{"福州市"});
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ObjectMapper om = new ObjectMapper();

        String type = request.getParameter("type");
        System.out.println("请求成功：type = " + type);

        switch (type) {
            case "1":
                Set<String> keySet = map.keySet();
                String json_provinces = om.writeValueAsString(keySet);
                System.out.println("信息转换成功：" + json_provinces + "，传送即将开启...");
                response.getWriter().append(json_provinces);
                break;
            case "2":
                String province = request.getParameter("province");
                System.out.println("[省] 已就绪： " + province);
                System.out.println("正在查找相关 [市] ...");
                String[] cities = map.get(province);
                String json_citis = om.writeValueAsString(cities);
                System.out.println("信息转换成功：" + json_citis + "，传送即将开启...");
                response.getWriter().append(json_citis);
                break;
            default:
                System.out.println("错误：无法读取 type ...");
        }
    }
}
