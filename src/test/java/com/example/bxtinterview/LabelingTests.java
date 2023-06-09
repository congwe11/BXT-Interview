package com.example.bxtinterview;

import com.example.bxtinterview.method.Labeling;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Congw
 * 2023/6/8 10:05
 */
@SpringBootTest
public class LabelingTests {

    Labeling labeling = new Labeling();


    // 打标签-系列测试
    @Test
    public void getSeriesLabelTest() {
        Map<String, String[]> brandMapping = Map.of(
                "雪花", new String[]{"8度","8°", "", "","清爽"},
                "迷失海岸", new String[]{"花生巧克力牛奶世涛","花生", "巧克力", "牛奶","花生巧克力牛奶世涛"},
                "海妖精酿", new String[]{"海妖之泪","", "", "","海妖之泪"},
                "其他", new String[]{"","", "", "",""}
        );

        String[] data1 = new String[]{"雪花", "SNOW雪花纯生啤酒8度500ml*12罐匠心营造易拉罐装整箱黄啤酒 500mL*12瓶"};
        String[] data2 = new String[]{"其他", "菠萝啤整箱装 24罐*320ml零酒精果啤果味汽水碳酸饮料夏日饮品"};
        String[] data3 = new String[]{"迷失海岸", "进口精酿啤酒迷失海岸花生酱牛奶世涛卡斯四料特浓巧克力组合装"};
        String[] data4 = new String[]{"海妖精酿", "海妖精酿啤酒瓶装比利时小麦白啤330ml12瓶包邮"};

        String seriesLabel1 = labeling.getSeriesLabel(data1[0], data1[1], brandMapping);
        String seriesLabel2 = labeling.getSeriesLabel(data2[0], data2[1], brandMapping);
        String seriesLabel3 = labeling.getSeriesLabel(data3[0], data3[1], brandMapping);
        String seriesLabel4 = labeling.getSeriesLabel(data4[0], data4[1], brandMapping);
        System.out.println("seriesLabel1 = " + seriesLabel1);
        System.out.println("seriesLabel2 = " + seriesLabel2);
        System.out.println("seriesLabel3 = " + seriesLabel3);
        System.out.println("seriesLabel4 = " + seriesLabel4);
        /*
        seriesLabel1 = 清爽
        seriesLabel2 = 其他
        seriesLabel3 = 花生巧克力牛奶世涛
        seriesLabel4 = 海妖之泪
        */
    }


    // 打标签-单量测试
    @Test
    public void getSingleNumberTest() {

        String data = "黑狮啤酒 啤酒黑狮白啤听装 500mL*12听罐整箱 雪花匠心营造500ml*12罐 \n" +
                "SNOW雪花纯生啤酒8度500ml*12罐匠心营造易拉罐装整箱黄啤酒 500mL*12瓶\n" +
                "【啤酒周边纪念品】百威啤酒5款355毫升红色经典限量版空铝瓶\n" +
                "北京 广州仓直发 坦克伯爵精酿 百香果味 10度百香果小麦白啤酒330ML×12瓶 整箱装 果香十足 \n" +
                "泰山传说官方经典正品德式进口工艺酿造世涛黑啤酒1L*12桶装包邮泡沫丰富饱满口味持久浓郁甘甜爽口营养丰富 \n" +
                "青西金琥珀拉格啤酒青岛特产精酿啤酒5L装熟啤酒节青岛特产全麦大桶装精酿拉格啤酒 \n" +
                "青岛特产精酿原浆啤酒全麦白啤蓝宝石酿酒师浑浊2升桶装促销包邮 \n" +
                "(1.35L*6桶)俄罗斯进口波罗的海远东古典啤酒 远东烈性啤酒 大麦黄啤整箱啤酒 远东古典1.35升*6桶(口感适中)\n" +
                "自由落体哈密瓜水果艾尔国产精酿果啤微醺酒果味酒女士低度酒饮料";

        String[] products = data.split("\n");

        List<Integer> res = new ArrayList<>();
        for (String product : products) {
             int number = labeling.getSingleNumber(product);
             res.add(number);
        }

        for (Integer num : res) {
            System.out.println("num = " + num);
        }

    }
}
