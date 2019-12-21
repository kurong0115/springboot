package com.star.springboot;

import com.alibaba.fastjson.JSON;
import com.star.springboot.dao.RedisDao;
import com.star.springboot.mapper.OrderMapper;
import com.star.springboot.po.Article;
import com.star.springboot.po.User;
import com.star.springboot.service.MailService;
import com.star.springboot.service.UserRedisService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPInputStream;

@SpringBootTest
@MapperScan(value = "com.star.springboot.mapper")
class SpringbootApplicationTests {

    @Autowired
    User user;

    @Autowired
    UserRedisService userRedisService;

    @Autowired
	RedisDao redisDao;

	@Autowired
	DataSource dataSource;

	@Autowired
	OrderMapper orderMapper;

//	@Autowired
//	ArticleRepository articleRepository;

	@Autowired
	MailService mailService;

    @Test
	public void dataSourceTest(){
		System.out.println(dataSource);
	}

	@Test
	public void connectTest(){
		System.out.println(orderMapper.getOrderById(1));
	}

    @Test
    void contextLoads() {
		String json = JSON.toJSONString(user);
		redisDao.set("user", json);
		String u = redisDao.get("user");
		User object = JSON.parseObject(u, User.class);
		System.out.println(object);
	}

	@Test
	public void insertTest() throws IOException {
		mailService.sendAttachMail("3468793275@qq.com", "测试", "这是一封邮件", "C:\\Users\\Administrator\\Downloads/“智慧团建”系统上线团支部整理整顿功能及依托该功能开展组织整顿工作的通知.pdf");
	}

	@Test
	public void findTest(){
		try {
			String url = "https://www.zhipin.com/gongsi/?ka=header_brand";
			Runtime rt = Runtime.getRuntime();
			String exec = "E:\\package\\phantomjs-2.1.1-windows\\bin/phantomjs.exe E:\\package\\phantomjs-2.1.1-windows\\bin/code.js " + url;
			Process p = rt.exec(exec);
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br= new BufferedReader(isr);
//			File file = new File("d:/image/info.html");
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
			rt.exit(0);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

    @Test
    public void testHelloworld() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  Factory<org.apache.shiro.mgt.SecurityManager> factory =
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
            //4、登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、身份验证失败
        }
//        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        //6、退出
        subject.logout();
    }

    @Test
	public void test(){
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet("https://www.zhipin.com/gongsir/5e139930da054b4233R43w~~.html?ka=company-jobs");
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.1.2)");
		httpGet.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
		httpGet.setHeader("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");
		httpGet.setHeader("accept-encoding", "gzip");
		httpGet.setHeader("cookie", "lastCity=101280600; _bl_uid=d0k0U24e9InrtFjzXxbFgyOmwRaO; __c=1574995699; __g=-; Hm_lvt_194df3105ad7148dcf2b98a91b5e727a=1574130322,1574941792,1574995700; __l=l=%2Fwww.zhipin.com%2F&r=https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3D3QEEr4zSvzuYMTWB9Df5HlDe60wbSbexYl3GNBCFhDAiHz0ymx9HzNcayrWNKcej%26wd%3D%26eqid%3Db9e15a0e00014a14000000065de086c7&friend_source=0&friend_source=0; __zp_stoken__=6919LngXsPj%2F%2F0Q7t7985uBjoTb1ZZebBBGz6Q5z%2FU2xUafDeOeqDTC%2BLEa24ZLwCrIl3zYq5p1jdxBt19YUr2yQ4Q%3D%3D; __a=41958594.1572227244.1574941792.1574995699.17.5.3.9; Hm_lpvt_194df3105ad7148dcf2b98a91b5e727a=1574995705\n" +
				"referer: https://www.zhipin.com/web/common/security-check.html?seed=0I2iJTbbpKOt8JUyA4xn2pmxBgukxQMNCFeIVgnx%2BD8%3D&name=a1976844&ts=1574995664460&callbackUrl=%2Fc101280600-p100199%2F%3Fka%3Dsearch_100199&srcReferer=https%3A%2F%2Fwww.zhipin.com%2F");
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
				File file = new File("d:/images/info.html");
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
