package com.star.springboot.service.impl;

import com.star.springboot.po.Article;
import com.star.springboot.service.ScheduleTask;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.GZIPInputStream;

/**
 * @ClassName ScheduleTaskImpl
 * @Description 定时任务实现类
 * @Author Administrator
 * @Date 2019/11/27 8:49
 * @Version 1.0
 */
@Component
public class ScheduleTaskImpl implements ScheduleTask {

	//@Scheduled(cron = "0 * 9 * * ?")
	@Override
	public void print() {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

	public void search(){
		try {
			String url = "https://blog.csdn.net/weixin_44574121/article/details/103276642";
			Runtime rt = Runtime.getRuntime();
			String exec = "E:\\package\\phantomjs-2.1.1-windows\\bin/phantomjs.exe E:\\package\\phantomjs-2.1.1-windows\\bin/code.js " + url;
			Process p = rt.exec(exec);
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br= new BufferedReader(isr);
///			File file = new File("d:/image/info.html");
//			if(file.exists()) {
//			file.delete();
//			}
//			FileOutputStream fos = new FileOutputStream(file);
			String line=null;
			System.out.println(br.readLine());
			while((line=br.readLine())!=null) {
				System.out.println(line);
//				fos.write(line.getBytes());
//				fos.write(System.getProperty("line.separator").getBytes());
			}
//			fos.flush();
//			fos.close();
			br.close();
			isr.close();;
			is.close();
			p.destroy();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Scheduled(cron = "0/3 * * * * ?")
	@Override
	public void visit(){
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet("https://blog.csdn.net/weixin_44574121/article/details/103632897");
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.1.2)");
		httpGet.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
		httpGet.setHeader("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");
		httpGet.setHeader("accept-encoding", "gzip");
		httpGet.setHeader("cookie", "uuid_tt_dd=10_20056491140-1569235521531-161714; dc_session_id=10_1569235521531.324017; __yadk_uid=BdUcFVEHzYE1YNUxSZ05uSyMYjvPVPN8; smidV2=2019092916382434463f4fc73edf6ec5c4bfc9cde3f37000a0cc3758d535c50; Hm_lvt_760b8e9d3c1f7691361ec306101d237c=1571121712; __gads=Test; UN=weixin_44574121; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=6525*1*10_20056491140-1569235521531-161714!1788*1*PC_VC!5744*1*weixin_44574121; Hm_ct_e5ef47b9f471504959267fd614d579cd=6525*1*10_20056491140-1569235521531-161714!5744*1*weixin_44574121; Hm_lvt_eb5e3324020df43e5f9be265a8beb7fd=1572856265; Hm_ct_eb5e3324020df43e5f9be265a8beb7fd=5744*1*weixin_44574121!6525*1*10_20056491140-1569235521531-161714; Hm_ct_b771b9753a47e6a3f0cc5ebdb9e7eeaf=5744*1*weixin_44574121!6525*1*10_20056491140-1569235521531-161714; Hm_lvt_4a20bfe8e339184241f52b1b2c53e116=1573124406; Hm_ct_4a20bfe8e339184241f52b1b2c53e116=5744*1*weixin_44574121!6525*1*10_20056491140-1569235521531-161714; Hm_lvt_65c9e91fa3a639df46cc94cab0f3f53f=1574306203; Hm_ct_65c9e91fa3a639df46cc94cab0f3f53f=5744*1*weixin_44574121!6525*1*10_20056491140-1569235521531-161714; Hm_lvt_e5ef47b9f471504959267fd614d579cd=1572848303,1574315239,1574751174; UM_distinctid=16eaabe0c8b26-079a87fef7e6af-6b131a7b-15f900-16eaabe0c8d28b; Hm_lvt_feacd7cde2017fd3b499802fc6a6dbb4=1574843509; Hm_ct_feacd7cde2017fd3b499802fc6a6dbb4=5744*1*weixin_44574121!6525*1*10_20056491140-1569235521531-161714; Hm_lvt_b771b9753a47e6a3f0cc5ebdb9e7eeaf=1573106511,1574822672,1574900114,1574902193; UserName=weixin_44574121; UserInfo=ccbf903d09014203a3b06684b75314dd; UserToken=ccbf903d09014203a3b06684b75314dd; UserNick=Matrix_%E6%9E%AF%E8%8D%A3; AU=8B7; BT=1574992356128; p_uid=U000000; Hm_lvt_aacce7e3ce8910733fd35b005b8a0ca6=1575017081; Hm_ct_aacce7e3ce8910733fd35b005b8a0ca6=5744*1*weixin_44574121!6525*1*10_20056491140-1569235521531-161714; acw_tc=2760822515779305149595356effb4251303d48cd78fafa59b0f100f3fced7; TY_SESSION_ID=67e4676a-24f0-4b1f-aa66-2ff2ae7284d0; firstDie=1; announcement=%257B%2522isLogin%2522%253Atrue%252C%2522announcementUrl%2522%253A%2522https%253A%252F%252Fblog.csdn.net%252Fblogdevteam%252Farticle%252Fdetails%252F103603408%2522%252C%2522announcementCount%2522%253A0%252C%2522announcementExpire%2522%253A3600000%257D; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1577930571,1577930859,1577931232,1577932183; acw_sc__v2=5e0d5dbf86ab3db125e4996ec07437da2befd815; acw_sc__v3=5e0d5dbf2861df8638cfb6a2d905f29f447f097c; dc_tos=q3glx1; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1577934326");
		HttpResponse response = null;

		try {
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			System.out.println(Jsoup.parse(EntityUtils.toString(entity)));
			if ((entity.getContentEncoding() != null)
					&& entity.getContentEncoding().getValue().contains("gzip")) {
				GZIPInputStream gzip = new GZIPInputStream(
						new ByteArrayInputStream(EntityUtils.toByteArray(entity)));
				InputStreamReader isr = new InputStreamReader(gzip);
				BufferedReader br = new BufferedReader(isr);
				StringBuilder sb = new StringBuilder();
				File file = new File("d:/images/blog.html");
				if(!file.exists()){
					file.createNewFile();
				}
				FileWriter writer = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(writer);
				PrintWriter pw = new PrintWriter(bw);
				String temp;
				while((temp = br.readLine()) != null){
					sb.append(temp);
					sb.append("\r\n");
					pw.println(temp);
				}
				isr.close();
				gzip.close();
				System.out.println(sb.toString());
				pw.flush();
				pw.close();
				bw.close();
				writer.close();
			}
		} catch (Exception e) { //发生异常换IP

		}
	}
}
