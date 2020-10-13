package com.example.huffmancode;

import java.io.*;
import java.util.*;

/**
 * @author YangLiuQing
 * @date 2020/5/25 10:24
 * 哈夫曼编码的原理
 * 哈弗曼树编码是一种无损的编码方式
 * 使用哈夫曼编码，进行解码，得到字符串 i like like like java do you like java
 * 1.获取传输字符串 i like like like java do you like java
 * 2.统计各个字符对应的个数
 * 3.每个字符出现的次数作为该字符的权值，构建一棵哈夫曼树
 * 4.根据哈夫曼树，给各个字符规定编码（前缀编码，不会造成匹配的二义性），规定向左的路径为0，向右的路径为1
 */
public class HuffmanEncoding {

    public static void main(String[] args) {
        //测试压缩文件
//        String srcFile = "1.pptx";
//        String destFile = "1.zip";
//        zipFile(srcFile,destFile);
//        System.out.println("压缩文件成功.");
//


        String srcFile = "girl1.jpg";
        String destFile = "girl2.zip";
        zipFile(srcFile,destFile);
        System.out.println("压缩文件成功.");

//        String srcFile = "driver.mp4";
//        String destFile = "driver.data";
//        zipFile(srcFile,destFile);
//        System.out.println("压缩文件成功.");

        File src = new File(srcFile);
        File dst = new File(destFile);
        System.out.println("压缩前文件大小:"+src.length());
        System.out.println("压缩后文件大小:"+dst.length());
        System.out.println("压缩率:"+(1-dst.length()*1.0/src.length()));

        //测试解压文件
//        String zipFile = "Uninstall.zip";
//        String destFile = "Uninstall2.xml";
//        unZipFile(zipFile,destFile);
//        System.out.println("解压文件成功.");

//        String content = "i like like like java do you like a java";
//        byte[] bytes = content.getBytes();
//        byte[] huffmanCodesBytes = huffmanZip(bytes);
//        System.out.println("压缩后的字节数组:huffmanCodesBytes = "+Arrays.toString(huffmanCodesBytes));
//        System.out.println("压缩后的长度为:"+huffmanCodesBytes.length);
//        System.out.println("压缩率:"+(40-17)/40.0);

//        byte[] sourceBytes = decode(huffmanCodes, huffmanCodesBytes);
//        System.out.println("解码后的字符数组对应的字符串:"+new String(sourceBytes));

        //System.out.println(byteToBitString((byte) 1));

//        System.out.println(bytes.length);//40 压缩率:(40-17)/40 = 57.5%
//
//        List<Node> nodes = getNodes(bytes);
//        System.out.println(nodes);
//
//        //创建出哈弗曼树
//        Node root = createHuffmanTree(nodes);
//        //前序遍历哈夫曼树
//        preOrder(root);
//
//        //哈夫曼编码
//        Map<Byte, String> codes = getCodes(root);
//        System.out.println("生成的哈弗曼编码表"+codes);
//        byte[] huffmanCodeBytes = zip(bytes, codes);
//        System.out.println("huffmanCodeBytes = "+Arrays.toString(huffmanCodeBytes));
    }

    /**
     * 根据字符串对应的byte[]，构建字符对应的结点
     * 将准备构建的哈弗曼树的Node放入到List集合中
     * @param bytes 接收byte数组
     * @return 字符节点的List集合
     */
    public static List<Node> getNodes(byte[] bytes){
        List<Node> nodes = new ArrayList<>();
        Map<Byte,Integer> map = new HashMap<>();

        //遍历bytes，统计每一个byte出现的次数--->map[key,value]
        for(byte item : bytes){
            //获取map中字符item出现的次数
            Integer count = map.get(item);
            if(count == null){//Map中没有这个字符
                map.put(item,1);
            }else{
                map.put(item,count+1);
            }
        }

        //遍历Map，把每个键值对，转化成一个node对象，并加入到nodes集合中
        for(Map.Entry<Byte,Integer> entry : map.entrySet()){
            Node node = new Node(entry.getKey(),entry.getValue());
            nodes.add(node);
        }

        return nodes;
    }

    /**
     * 构建huffmanTree
     * @param nodes
     */
    public static Node createHuffmanTree(List<Node> nodes){
        //1.定义Node节点，data：存放数据，weight：权重，left和right结点
        //2.得到字符串对应的byte[]，构建字符节点
        //3.编写一个方法，将准备构建的哈弗曼树的Node放入到List中，形式：Node（data = 97,weight = 5）
        //4.通过List构建哈弗曼树
        while(nodes.size() != 1){
            Collections.sort(nodes);

            Node leftNode = nodes.get(0);
            Node rightNode =  nodes.get(1);

            //创建一棵新的二叉树，由于存在data域的结点都是叶子结点，所以叶子结点构成的根节点没有data域，只有权值
            Node parent = new Node(null,leftNode.weight+rightNode.weight);
            //构建二叉树
            parent.left = leftNode;
            parent.right = rightNode;

            //移除处理过的两棵二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的二叉树加入到nodes
            nodes.add(parent);
        }

        //nodes最后的节点就是哈弗曼树的根节点
        return nodes.get(0);
    }

    //根据构建完成的哈夫曼树生成对应的哈夫曼编码表
    //1.将哈夫曼编码表存放在Map<Byte,String>，形式：32--->01
    static Map<Byte,String> huffmanCodes = new HashMap<>();
    //2.在生成哈夫曼编码表时，需要拼接路径，定义一个StringBuilder存储某个叶子结点的路径
    static StringBuilder builder = new StringBuilder();

    /**
     * 功能:获取传入的nodes结点下的所有叶子结点的哈夫曼编码，并放入到Map集合中
     * @param node 传入的结点，根节点
     * @param code 路径，左子结点为0，右子结点为1
     * @param builder 用于拼接路径
     */
    private static void getCodes(Node node,String code,StringBuilder builder){
        StringBuilder stringBuilder = new StringBuilder(builder);
        //拼接上一次的code
        stringBuilder.append(code);
        if(node != null){//等于null不做任何处理
            //判断当前结点是叶子结点还是非叶子结点
            if(node.data == null){//非叶子结点
                //向左递归，直到遇见叶子结点
                getCodes(node.left,"0",stringBuilder);
                //向右递归，直到遇见叶子结点
                getCodes(node.right,"1",stringBuilder);
            }else{//说明是一个叶子结点，表示找到了某个叶子结点
                huffmanCodes.put(node.data,stringBuilder.toString());
            }
        }
    }

    //为了调用方便，重载此方法
    private static Map<Byte,String> getCodes(Node root){
        if(root == null){
            return null;
        }
        getCodes(root,"",builder);

        return huffmanCodes;
    }

    /**
     *
     * @param bytes 原始的字符串对应的byte[]
     * @param huffmanCodes 生成的哈夫曼编码表
     * @return 返回经过哈夫曼编码表处理后的byte[]
     */
    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        //1.利用huffmanCodes将bytes转成哈夫曼编码对应的字符串（0,1,......,....）
        StringBuilder stringBuilder = new StringBuilder();
        for(byte item : bytes){
            stringBuilder.append(huffmanCodes.get(item));
        }
        //System.out.println(stringBuilder.toString());
        //统计返回的byte[]的长度
        int len;
        if(stringBuilder.length() % 8 == 0){
            len = stringBuilder.length() / 8;
        }else{
            len = stringBuilder.length() / 8 + 1;
        }

        //创建一个存储压缩后的byte[]，哈夫曼编码对应的字节数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;//记录第几个byte
        for(int i = 0;i < stringBuilder.length();i+=8){//每8位对应一个byte，i+8有可能越界
            String strByte;
            if(i + 8 > stringBuilder.length()){//不够8位，往后一直取到末尾即可
                strByte = stringBuilder.substring(i);
            }else{
                strByte = stringBuilder.substring(i,i + 8);
            }
            //将strByte以二进制的形式转成一个byte字节，放入到byte[]
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte,2);
            index++;
        }

        return huffmanCodeBytes;
    }

    public static void preOrder(Node root){
        if(root == null){
            System.out.println("该树是一棵空树，无法遍历.");
        }else{
            root.preOrder();
        }
    }


    /**
     * 使用一个方法将前面的方法封装起来，便于我们调用
     * @param bytes 原始的字符串对应的字节数组
     * @return 经过哈弗曼编码压缩后的数组
     */
    public static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);

        //根据nodes，创建出哈弗曼树
        Node root = createHuffmanTree(nodes);
        //根据哈夫曼树生成对应的哈夫曼编码表
        Map<Byte, String> codes = getCodes(root);
        //根据生成的哈夫曼编码压缩得到压缩后的哈夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes, codes);
        return huffmanCodeBytes;
    }

    //实现数据的解压
    //1.把huffmanCodeBytes转成一个哈夫曼编码对应的二进制的字符串

    /**
     * 将byte[]转化成一个二进制的字符串
     * @param flag 标识当前byte是否需要补高位，如果是true表示需要补高位，否则，不需要补高位
     * 最后一位不需要补高位，其它的都需要补高位
     * @param b 要转换的值
     * @return 以补码的形式返回b对应的二进制字符串
     */
    private static String byteToBitString(boolean flag,byte b){
        //使用变量保存b
        int temp = b;
        //如果是正数，需要补齐高位，才能转成正确的补码
        if(flag){
            temp |= 256;//1 0000 0000 & 0000 00001 = 1 00000 0001
        }
        //以补码的形式，返回temp对应的二进制
        String str = Integer.toBinaryString(temp);

        if(flag){
            return str.substring(str.length() - 8);//截取最后的8位 1 00000 0001
        }else{//如果是最后一个byte，则不需要补高位，原样返回
            return str;
        }
    }

    //2.哈夫曼编码对应的二进制的字符串对照哈夫曼表转成字符串

    /**
     * 实现对压缩数据的解码
     * @param huffmanCodes 哈夫曼编码表
     * @param huffmanBytes 哈夫曼编码处理后的字符数组
     * @return 原来字符串对应的byte数组
     */
    public static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes){
        //1.先得到哈夫曼编码处理后的字符数组，对应的二进制的字符串，形式：101010000...
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二进制的字符串
        for(int i = 0;i< huffmanBytes.length;i++){
            if(i == huffmanBytes.length - 1){//如果是最后一个byte，则不需要补高位
                stringBuilder.append(byteToBitString(false, huffmanBytes[i]));

            }else{//否则，需要补高位
                stringBuilder.append(byteToBitString(true,huffmanBytes[i]));
            }
        }
        //把字符串按照指定的哈夫曼编码表进行解码
        //把哈夫曼编码表进行调换，反向查询 a --- > 100,100--->a
        Map<String,Byte> map = new HashMap<String,Byte>();//用来存放key和value调换后的map集合
        for(Map.Entry<Byte,String> entry:huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }

        //创建集合，存放Byte
        List<Byte> ls = new ArrayList<>();
        for(int i = 0;i < stringBuilder.length();){//压缩后字节数组对应的二进制字符串
            int count = 1;//计数器
            boolean flag = true;
            //Byte字符
            Byte b = null;

            while(flag){
                //取出二进制字符串中的1位
                String key = stringBuilder.substring(i,i+count);//i不动，让count移动，直到匹配到编码表中的一个字符为止
                b = map.get(key);
                if(b == null){//匹配失败
                    count++;
                }else{//匹配成功，退出
                    flag = false;
                }
            }
            //将解码后的Byte加入到集合中
            ls.add(b);
            //i直接移动到下一个Byte开始的位置
            i += count;
        }

        //当for循环结束后，List中存放了所有的Byte字符
        //把List中的数据放入到byte数组，并返回
        byte[] b = new byte[ls.size()];
        for(int i = 0;i < b.length;i++){
            b[i] = ls.get(i);
        }
        //System.out.println("map =" + map);
        //System.out.println(stringBuilder.toString());
        return b;
    }

    /**
     * 实现一个文件的压缩
     * @param srcFile 原文件的路径
     * @param destFile 压缩文件的路径
     */
    public static void zipFile(String srcFile,String destFile){
        FileInputStream is = null;
        FileOutputStream os = null;
        ObjectOutputStream oos = null;

        try {
            //创建文件输入流
            is = new FileInputStream(srcFile);

            //创建一个和源文件大小（is.available()）一样的byte[]
            byte[] b = new byte[is.available()];
            //读取文件
            is.read(b);
            //直接对源文件进行压缩，得到压缩后的字节数组
            byte[] huffmanBytes = huffmanZip(b);
            //创建文件输出流，存放压缩文件
            os = new FileOutputStream(destFile);
            //创建一个和文件流关联的ObjectOutputStream，对象输出流
            oos = new ObjectOutputStream(os);
            //把哈夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            //以对象流的方式写入哈夫曼编码表，为了以后恢复源文件
            oos.writeObject(huffmanCodes);
        }catch (Exception e){//输出异常信息
            System.out.println(e.getMessage());
        }finally {
            try {
                os.close();
                is.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 实现对文件的解压
     * @param zipFile 准备解压的文件
     * @param destFile 将文件解压到哪个路径
     */
    public static void unZipFile(String zipFile,String destFile){
        //1.定义文件输入流
        FileInputStream fis = null;
        //2.定义一个对象输入流
        ObjectInputStream ois = null;
        //定义文件的输出流
        FileOutputStream fos = null;
        try {
            //创建文件输入流
            fis = new FileInputStream(zipFile);
            //创建一个和fis关联的对象输入流
            ois = new ObjectInputStream(fis);
            //读取byte数组
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取哈夫曼编码表
            Map<Byte,String> huffmanCodes = (Map<Byte, String>) ois.readObject();
            //解码
            byte[] bytes = decode(huffmanCodes, huffmanBytes);

            //将bytes数组写入到目标文件
            fos = new FileOutputStream(destFile);
            //写出数据到文件中
            fos.write(bytes);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                fos.close();
                ois.close();
                fis.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
