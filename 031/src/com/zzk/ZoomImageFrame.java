package com.zzk;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class ZoomImageFrame extends JFrame {
    private Image img = null;  // 声明图像对象
    private ZoomImagePanel imagePanel = null;  // 声明图像面板对象
    private int imgWidth, imgHeight;// 用于存储图片的宽度和高度
    private int newW, newH;// 用于存储图片缩放后的宽度和高度
    private JSlider slider = null;// 声明滑块对象
    public static void main(String args[]) {
        ZoomImageFrame frame = new ZoomImageFrame();
        frame.setVisible(true);
    }
    public ZoomImageFrame() {
        super();
        URL imgUrl = ZoomImageFrame.class.getResource("/img/image.jpg");// 获取图片资源的路径
        img = Toolkit.getDefaultToolkit().getImage(imgUrl); // 获取图像资源
        imagePanel = new ZoomImagePanel();  // 创建图像面板对象
        this.setBounds(200, 160, 355, 253); // 设置窗体大小和位置
        this.add(imagePanel); // 在窗体中部位置添加图像面板对象
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭模式
        this.setTitle("缩放图像"); // 设置窗体标题
        slider = new JSlider();// 创建滑块对象
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(final ChangeEvent e) {
                imagePanel.repaint();// 重新调用面板类的paint()方法
            }
        });
        getContentPane().add(slider, BorderLayout.SOUTH);// 在窗体底部位置添加滑块对象
    }
    // 创建面板类
    class ZoomImagePanel extends JPanel {
        public void paint(Graphics g) {
            g.clearRect(0, 0, this.getWidth(), this.getHeight());// 清除绘图上下文的内容
            imgWidth = img.getWidth(this); // 获取图片宽度
            imgHeight = img.getHeight(this); // 获取图片高度
            float value = slider.getValue();// 滑块组件的取值
            newW = (int) (imgWidth * value / 100);// 计算图片缩放后的宽度
            newH = (int) (imgHeight * value / 100);// 计算图片缩放后的高度
            g.drawImage(img, 0, 0, newW, newH, this);// 绘制指定大小的图片
        }
    }
}
