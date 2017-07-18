import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by LZL on 2017/7/18.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException
    {
        while(true)
        {
            Thread.sleep(5000);
            AutoConnection.test(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String s = response.header("Server");
                    if(s == null)
                    {
                        System.out.println("网络正常");
                    }
                    else if(s.equals("DrcomServer1.0"))
                    {
                        System.out.println("网络异常");
                        response.close();
                        AutoConnection.connection(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                response.close();
                            }
                        });
                    }
                    else
                        System.out.println("网络正常");

                }
            });

        }
    }
}
