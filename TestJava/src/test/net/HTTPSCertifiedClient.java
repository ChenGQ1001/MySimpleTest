package test.net;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

import org.apache.http.conn.ssl.SSLSocketFactory;

public class HTTPSCertifiedClient extends HTTPSClient {
	public SSLSocketFactory socketFactory;
    public HTTPSCertifiedClient() {

    }

    @Override
    public void prepareCertificate() throws Exception {
        // 获得密匙库
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        FileInputStream instream = new FileInputStream(
                new File("C:/Users/zhda6001/Downloads/software/xxx.keystore"));
        // FileInputStream instream = new FileInputStream(new File("C:/Users/zhda6001/Downloads/xxx.keystore"));
        // 密匙库的密码
        trustStore.load(instream, "password".toCharArray());
        // 注册密匙库
        this.socketFactory = new SSLSocketFactory(trustStore);
        // 不校验域名
        socketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
    }
}
