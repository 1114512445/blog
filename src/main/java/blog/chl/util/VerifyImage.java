package blog.chl.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;



public class VerifyImage {

	private int w = 70;
	private int h = 35;
	private Color color = new Color(240,240,240);
	
	private StringBuffer verifyCode = new StringBuffer(4);
	private Random random = new Random();
	
	public String getVCode(){
		
		return verifyCode.toString();
	}
	private BufferedImage createImage(){
		
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		img.getGraphics().setColor(color);
		img.getGraphics().fillRect(0, 0, w, h);
		
		return img;
		
	}
	
	//�����ַ����ɫ
	private Color randomColor(){
		
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		return new Color(r,g,b);
	}
	
	//�����ַ��font
	private String[] fontNames ={"����","���Ŀ���","����","������κ","��������","΢���ź�","����_GB2312"};
	private int[] fontSizes = {24,25,26,27,28};
	private Font randomFont(){
		
		int index = random.nextInt(fontNames.length);		
		String fontName = fontNames[index];
		
		int style = random.nextInt(4);
		
		index = random.nextInt(fontSizes.length);
		int size = fontSizes[index];
		
		return new Font(fontName, style, size);
	}
	
	//����ַ�
	private String chars = "abcdefghijklmnopqrstuvwsyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private String randomChar(){
		
		
		int index = random.nextInt(chars.length());
		
		
		return chars.charAt(index)+"";
	}
	
	//��������
	private void drawLines(BufferedImage img){
		
		
		
		Graphics2D g = (Graphics2D) img.getGraphics();
		//���û��ʵĴ�ϸ
		g.setStroke(new BasicStroke(1.5F));
		g.setColor(Color.BLACK);
		
		for(int i=0;i<4;i++){
			
			int x1 = random.nextInt(w);
			int x2 = random.nextInt(h);
			int y1 = random.nextInt(w);
			int y2 = random.nextInt(h);
			
			g.drawLine(x1, y1, x2, y2);
		}
		
	}
	
	//��ͼ
	public BufferedImage getImage(){
		
		BufferedImage img = createImage();
		Graphics g = img.getGraphics();
		
		for(int i=0;i<4;i++){
						
			g.setColor(randomColor());
			g.setFont(randomFont());
			String ch = randomChar();
			
			g.drawString(ch, w/4*i, h-5);
			verifyCode.append(ch);
		}
		
		drawLines(img);
		
		return img;
	}
	
	//����ͼƬ
	public void saveImage(BufferedImage img,OutputStream out) throws Exception{
		
		ImageIO.write(img, "JPEG", out);
	}
	
	public String getVerifyCode(){
		
		return verifyCode.toString();
	}
	

	
}
