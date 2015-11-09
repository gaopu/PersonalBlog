package com.blog.utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by geekgao on 15-10-18.
 */
public class BlogUtils {
    public static String getArticleFolderPath() throws IOException {
        //从properties文件获取文章存储路径
        Properties properties = new Properties();
        properties.load(BlogUtils.class.getResourceAsStream("/blog.properties"));
        return properties.getProperty("articleFolderPath");
    }

    public static File getArticleFile(int id) throws IOException {
        return new File(BlogUtils.getArticleFolderPath() + id);
    }
}
