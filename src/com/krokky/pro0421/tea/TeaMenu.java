package com.krokky.pro0421.tea;

//茶单类
public class TeaMenu {

    //茶单
    private Tea[] teas = new Tea[10];

    //负责初始化茶单
    public TeaMenu() {
        String[] teaName = {"西湖龙井", "洞庭碧螺春", "白毫银针", "君山银针", "黄山毛峰", "武夷岩茶", "安溪铁观音", "信阳毛尖", "庐山云雾", "六安瓜片"};

        for (int i = 0; i < teas.length; i++) {
            double price = (int) ((Math.random() * 100 + 30) * 100) / 100.0;
            Tea t = new Tea();
            t.setTeaName(teaName[i]);
            t.setTeaPrice(price);
            teas[i] = t;
        }
    }

    //负责展示茶单
    public void show() {
        System.out.println("这个是我店的最新茶单:");
        System.out.println("**********************************");
        System.out.println("序号\t\t名称\t\t\t价格");
        for (int i = 0; i < teas.length; i++) {
            Tea t = teas[i];
            System.out.println((i + 1) + ".\t\t" + ((t.getTeaName().length() == 5) ? t.getTeaName() : (t.getTeaName() + "\t")) + "\t$" + t.getTeaPrice() + "元");
        }
        System.out.println("**********************************");
    }

    public Tea[] getTeas() {
        return teas;
    }

    public void setTeas(Tea[] teas) {
        this.teas = teas;
    }


}
