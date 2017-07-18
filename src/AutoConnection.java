import okhttp3.*;

/**
 * Created by LZL on 2017/7/18.
 */
public class AutoConnection {
    static String username = "wujie427";
    static String password = "xiyou3g";
    static OkHttpClient okHttpClient = new OkHttpClient();
    static final String notFoundError = "Ping 请求找不到主机";
    static final String TTL = "TTL";

    public static boolean isConnected(String result)
    {
        if(result==null)
            return false;
        int find = result.indexOf(notFoundError);
        if(find!=-1)
            return false;
        int ttlCount = 0;
        int postition = 0;
        while((postition=result.indexOf(TTL,postition))!=-1)
        {
            postition++;
            ttlCount++;
        }
        if(ttlCount>0)
            return true;
        else
            return false;
    }

    public static void test(Callback callback)
    {
        Request.Builder builder = new Request.Builder();
        builder.url("http://www.qq.com")
                .get();
        Call call = okHttpClient.newCall(builder.build());
        call.enqueue(callback);
    }

    public static void connection(Callback callback)
    {
        FormBody.Builder formBuilder = new FormBody.Builder();
        formBuilder.add("0MKKEY","123456")
                .add("buttonClicked","")
                .add("cmd","")
                .add("DDDDD",username)
                .add("err_flag","")
                .add("Login","")
                .add("para","00")
                .add("password","")
                .add("R1","0")
                .add("R2","")
                .add("R6","0")
                .add("redirect_url","")
                .add("upass",password)
                .add("user","")
                .add("username","");
        Request.Builder builder = new Request.Builder();
        builder.post(formBuilder.build())
                .url("http://172.18.0.3/a70.htm")
                .addHeader("Accept","image/gif, image/jpeg, image/pjpeg, application/x-ms-application, application/xaml+xml, application/x-ms-xbap, */*")
                .addHeader("Accept-Encoding","gzip, deflate")
                .addHeader("Accept-Language","zh-CN")
                .addHeader("Cache-Control","no-cache")
                .addHeader("Connection","Keep-Alive")
                .addHeader("Content-Type","application/x-www-form-urlencoded")
                .addHeader("Host","172.18.0.3")
                .addHeader("Referer","http://172.18.0.3/a70.htm")
                .addHeader("User-Agent","Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 10.0; WOW64; Trident/7.0; .NET4.0C; .NET4.0E)")
                .addHeader("Cookie","program=111;vlan=3134,ip=222.24.34.121;md5_login2="+username+"%7C"+password);
        Call call = okHttpClient.newCall(builder.build());
        call.enqueue(callback);
    }
}
