package com;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class MyLogger {
	
	static private boolean status=false;
	
	static public void start()
	{
		if(status)
			return;
		try {
			SimpleDateFormat sim=new SimpleDateFormat("yyMMdd");
			Handler handler=new FileHandler("%h/travel/"+sim.format(new Date())+".log",0,10);
			Logger.getLogger("travel").addHandler(handler);
			System.out.println("日志启动成功，开始记录日志~ \n time:"+new Date());
			Logger.getLogger("travel").info("日志记录成功");
			status=true;
		} catch (SecurityException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		start();
	}

}
