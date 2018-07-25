package test.net;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class PostTest {
	 private static HttpClient client = null;
	 static {
	        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
	        cm.setMaxTotal(128);
	        cm.setDefaultMaxPerRoute(128);
	        client = HttpClients.custom().setConnectionManager(cm).build();
	    }
	/**
     * 创建 SSL连接
     * @return
     * @throws GeneralSecurityException
     */
    private static CloseableHttpClient createSSLInsecureClient() throws GeneralSecurityException {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                        public boolean isTrusted(X509Certificate[] chain,String authType) throws CertificateException {
                            return true;
                        }
                    }).build();
            
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {

                        @Override
                        public boolean verify(String arg0, SSLSession arg1) {
                            return true;
                        }

                        @Override
                        public void verify(String host, SSLSocket ssl)
                                throws IOException {
                        }

                        @Override
                        public void verify(String host, X509Certificate cert)
                                throws SSLException {
                        }

                        @Override
                        public void verify(String host, String[] cns,
                                String[] subjectAlts) throws SSLException {
                        }

                    });
            
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
            
        } catch (GeneralSecurityException e) {
            throw e;
        }
    }
	
	 public static String post2(String url, String body, String mimeType,String charset, Integer connTimeout, Integer readTimeout) 
	            throws ConnectTimeoutException, SocketTimeoutException, Exception {
	        HttpClient client = null;
	        HttpPost post = new HttpPost(url);
	        String result = "";
	        try {
	            if (StringUtils.isNotBlank(body)) {
	                HttpEntity entity = new StringEntity(body, ContentType.create(mimeType, charset));
	                post.setEntity(entity);
	            }
	            // 设置参数
	            Builder customReqConf = RequestConfig.custom();
	            if (connTimeout != null) {
	                customReqConf.setConnectTimeout(connTimeout);
	            }
	            if (readTimeout != null) {
	                customReqConf.setSocketTimeout(readTimeout);
	            }
	            post.setConfig(customReqConf.build());

	            HttpResponse res;
	            if (url.startsWith("https")) {
	                // 执行 Https 请求.
	                client = createSSLInsecureClient();
	                res = client.execute(post);
	            } else {
	                // 执行 Http 请求.
	                client = PostTest.client;
	                res = client.execute(post);
	            }
	            result = res.getEntity().getContent().toString();
	        } finally {
	            post.releaseConnection();
	            if (url.startsWith("https") && client != null&& client instanceof CloseableHttpClient) {
	                ((CloseableHttpClient) client).close();
	            }
	        }
	        return result;
	    }  
	
	public static void post() {
		String body = "";  
		 String url = "http://localhost:8080/neteagle3.6.8/api/login.json"; 
		 String encoding = "encoding";
		 try {
			
        //创建httpclient对象  
        CloseableHttpClient client = HttpClients.createDefault();  
        //创建post方式请求对象  
        HttpPost httpPost = new HttpPost(url);  
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
	    nvps.add(new BasicNameValuePair("username", "admin"));  
	    nvps.add(new BasicNameValuePair("password", "Ecc0m@123"));  
	    //设置参数到请求对象中  
	    httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));
  
        System.out.println("请求地址："+url);  
        System.out.println("请求参数："+nvps.toString());  
          
        //设置header信息  
        //指定报文头【Content-type】、【User-Agent】  
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");  
          
        //执行请求操作，并拿到结果（同步阻塞）  
        CloseableHttpResponse response = client.execute(httpPost);  
        //获取结果实体  
        HttpEntity entity = response.getEntity();  
        if (entity != null) {  
            //按指定编码转换结果实体为String类型  
        	System.out.println("is not null");
            body = EntityUtils.toString(entity, encoding);  
        }  
        EntityUtils.consume(entity);  
        //释放链接  
        response.close(); 
        System.out.println(body);
		 } catch (Exception e) {
				// TODO: handle exception
	}
	}
    public static void main(String[] args) {
    	try {
    		String str= post2("http://localhost:8080/neteagle3.6.8/api/login.json","username=admin&password=Ecc0m@123","application/x-www-form-urlencoded", "UTF-8", 10000, 10000);
    	} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	    String url = "http://172.20.1.172/api/v1/ticket";
    	    String json = "{\n\t\"username\":\"admin\",\n\t\"password\":\"eccom@123\"\n}";  
    	    try {
    	    HttpClient httpClient = new DefaultHttpClient();  
    	    HttpPost post = new HttpPost(url);  
    	    StringEntity postingString;
    	    
    	    postingString = new StringEntity(json);
			// json传递  
    	    post.setEntity(postingString);  
    	    post.setHeader("Content-type", "application/x-www-form-urlencoded");  
    	    HttpResponse response = httpClient.execute(post);  
    	    String content = EntityUtils.toString(response.getEntity());  
    	    // Log.i("test",content);  
    	    System.out.println(content);  
    	    String result = content; 
    	    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }

}
