package com.krokky.DES.util;

import java.io.*;
import java.util.Properties;

public class PropertiesUtil {

    private static Properties resource;

    static {
        InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream("pro.properties");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        resource = new Properties();
        try {
            resource.load(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getWidth() {
        int width = Integer.parseInt(resource.get("width").toString());
        return width;
    }

    public static int getHeigth() {
        int height = Integer.parseInt(resource.get("height").toString());
        return height;
    }

    public static void setWidth(int width) {
        String path = PropertiesUtil.class.getClassLoader().getResource("pro.properties").getPath();
        System.out.println(path);
        try {
            OutputStream out = new FileOutputStream(path);
            resource.put("width", width + "");
            resource.save(out, "");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void setHeight(int height) {
        String path = PropertiesUtil.class.getClassLoader().getResource("pro.properties").getPath();
        System.out.println(path);
        try {
            OutputStream out = new FileOutputStream(path);
            resource.put("height", height + "");
            resource.save(out, "");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getSize() {
        int size = Integer.parseInt(resource.get("size").toString());

        return size;
    }

    public static void setSize(int size) {
        String path = PropertiesUtil.class.getClassLoader().getResource("pro.properties").getPath();
        try {
            OutputStream out = new FileOutputStream(path);
            resource.put("size", size + "");
            resource.save(out, "");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
