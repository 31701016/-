package cn.edu.zucc.personplan.ui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import cn.edu.zucc.personplan.ui.Station;;


public class MainWindow extends JFrame {

	JTextArea result, jta1;
	JPanel jp1, jp2;
	JTextField jtf1, jtf2;
	JScrollPane jsp1, jsp2;
	JTabbedPane jtp;
	JLabel jl1, jl2;
	JButton jb1, jb2;

	public MainWindow() {
		super("线路显示");
		this.setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		// 调用方法
		addComponent();
		setVisible(true);
		setLocationRelativeTo(null);// 设居中显示;
	}

	public void addComponent() {
		jb1 = new JButton("计算最短距离");
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Station pr = new Station(null);
				result.setText(pr.line+ "");
			}
		});

		// 面板一
		jp1 = new JPanel(new BorderLayout());

		jl1 = new JLabel("输入起点：");
		jtf1 = new JTextField(8);
		jl2 = new JLabel("输入终点");
		jtf2 = new JTextField(8);
		jb2 = new JButton("查询");
		jta1 = new JTextArea(20, 60);
		jsp2 = new JScrollPane(jta1);
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String startAddress = jtf1.getText().trim();
				String endAddress = jtf2.getText().trim();
				String resultStr = "";
				boolean iscontinue=false;
				data st=new data();

		    	
				if (!st.list.contains(startAddress)||startAddress == null|| "".equals(startAddress)) {
					resultStr += "起点输入不正确，无法查询结果\n";
					iscontinue =true;
				}
				if (!st.list.contains(endAddress)||endAddress == null|| "".equals(endAddress)) {
					resultStr += "终点输入不正确，无法查询结果\n";
					iscontinue =true;
				}
				if(startAddress.equals(endAddress)){
					resultStr +="请输入不同的起点和终点\n";
					iscontinue =true;
				}
				
				if(!iscontinue){
					subway pr = new subway();
					pr.calculate(new Station(startAddress), new Station(endAddress));
					
					resultStr +=pr.hh;
				}
				
				jta1.setText(resultStr);
				
			}
		});
		
		JPanel jp3 = new JPanel(new FlowLayout());

		jp3.add(jl1);
		jp3.add(jtf1);
		jp3.add(jl2);
		jp3.add(jtf2);
		jp3.add(jb2);
		jp1.add(jp3, "North");
		jp1.add(jsp2, "Center");
		result = new JTextArea(20, 60);
		jtp = new JTabbedPane();
		jtp.addTab("线路查询", jp1);
		add(jtp);

	}

	public static void main(String[] args) {
		new MainWindow();
	}

}
