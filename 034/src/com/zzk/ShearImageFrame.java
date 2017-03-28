package com.zzk;
import java.awt.*;
import java.net.URL;
import javax.swing.*;
public class ShearImageFrame extends JFrame {
	private Image img;
	private ShearImagePanel canvasPanel = null;
	public ShearImageFrame() {
        URL imgUrl = ShearImageFrame.class.getResource("/img/image.jpg");// 获取图片资源的路径
        img = Toolkit.getDefaultToolkit().getImage(imgUrl);  // 获取图片资源
        canvasPanel = new ShearImagePanel();     // 创建绘制倾斜图像的面板对象
        this.setBounds(100, 100, 360, 240);                // 设置窗体大小和位置
        add(canvasPanel);// 在窗体上添加面板对象
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭模式
        this.setTitle("倾斜图像");                    // 设置窗体标题
	}
	public static void main(String[] args) {
		new ShearImageFrame().setVisible(true);
	}
	class ShearImagePanel extends JPanel {// 绘制倾斜图像的面板类
		public void paint(Graphics g) {
			Graphics2D g2=(Graphics2D) g;// 获得Graphics2D对象
			g2.shear(0, -0.5);// 倾斜图像
			g2.drawImage(img, 10, 20, 220, 160, this);     // 绘制指定大小的图片
		}
	}
}
