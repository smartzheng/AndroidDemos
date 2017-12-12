package com.smartzheng.constraintlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            test();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private void test() throws DocumentException {
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        Document document = reader.read(new File("src/cn/com/yy/dom4j/s.xml"));
        //获取根节点元素对象
        Element root = document.getRootElement();
        listNodes(root);
    }
    //遍历当前节点下的所有节点
    public void listNodes(Element node){
        Log.e("AAA",("当前节点的名称：" + node.getName()));
        //首先获取当前节点的所有属性节点
        List<Attribute> list = node.attributes();
        //遍历属性节点
        for(Attribute attribute : list){
            Log.e("AAA","属性" + attribute.getName() + ":" + attribute.getValue());
        }
        //如果当前节点内容不为空，则输出
        if(!(node.getTextTrim().equals(""))){
            Log.e("AAA",( node.getName() + "：" + node.getText()));
        }
        //同时迭代当前节点下面的所有子节点
        //使用递归
        Iterator<Element> iterator = node.elementIterator();
        while(iterator.hasNext()){
            Element e = iterator.next();
            listNodes(e);
        }
    }
}
