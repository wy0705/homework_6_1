package threadFile;

import java.io.*;
class Work implements Runnable {

    public synchronized void mywrite(String str){
        File file = new File(str);    //1、建立连接
        OutputStream os = null;
        try {
            //2、选择输出流,以追加形式(在原有内容上追加) 写出文件 必须为true 否则为覆盖
            os = new FileOutputStream(file,true);
//            //和上一句功能一样，BufferedInputStream是增强流，加上之后能提高输出效率，建议
//            os = new BufferedOutputStream(new FileOutputStream(file,true));
            String string = "Programmer say : Hello World!";
            byte[] data = string.getBytes();    //将字符串转换为字节数组,方便下面写入

            os.write(data, 0, data.length);    //3、写入文件
            os.flush();    //将存储在管道中的数据强制刷新出去
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件没有找到！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("写入文件失败！");
        }finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭输出流失败！");
                }
            }
        }
    }
    @Override
    public void run() {
        System.out.println("Working...");
        mywrite("src/write.txt");
    }
}
public class ThreadFile {
    public static void main(String[] args) {
        Work work=new Work();
        Thread thread1=new Thread(work);
        Thread thread2=new Thread(work);
        thread1.start();
        thread2.start();
    }


}
