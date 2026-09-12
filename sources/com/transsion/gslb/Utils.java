package com.transsion.gslb;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.transsion.core.deviceinfo.DeviceInfo;
import com.transsion.core.log.ObjectLogUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes5.dex */
public class Utils {
    public static final String SEPARATOR = "#";
    public static ObjectLogUtils LOG = new ObjectLogUtils.a().p("GSLB_SDK_LOG").q(true).n(false).m();
    public static SSLSocketFactory sslSocketFactory = null;

    public static String bufferRead(File file) {
        if (file == null) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                if (!file.exists()) {
                    return "";
                }
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr);
                    String str = new String(bArr);
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return str;
                } catch (Exception e11) {
                    e = e11;
                    fileInputStream = fileInputStream2;
                    LOG.i(Log.getStackTraceString(e));
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e12) {
                e = e12;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void bufferSave(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(str);
                } catch (IOException unused) {
                    return;
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
        } catch (Exception e12) {
            e = e12;
            fileOutputStream2 = fileOutputStream;
            LOG.i(Log.getStackTraceString(e));
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static NetResponse<String> doPost(String str, String str2) {
        NetResponse<String> netResponse;
        String str3 = GslbSdk.isTestMode() ? "https://test-gslb.shalltry.com/gslb/domain/convert" : "https://gslb.shalltry.com/gslb/domain/convert";
        LOG.g("begin net connect: " + str);
        HttpURLConnection httpURLConnection = null;
        NetResponse<String> netResponse2 = new NetResponse<>(-1, null);
        String str4 = str != null ? str : "";
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str3).openConnection()));
            try {
                httpURLConnection2.setRequestProperty("accept", "*/*");
                httpURLConnection2.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
                httpURLConnection2.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(str4.length()));
                httpURLConnection2.setRequestProperty("X-Gslb-Sign", str2);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setReadTimeout(20000);
                httpURLConnection2.setConnectTimeout(30000);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                PrintWriter printWriter = new PrintWriter(httpURLConnection2.getOutputStream());
                printWriter.write(str4);
                printWriter.flush();
                printWriter.close();
                int responseCode = httpURLConnection2.getResponseCode();
                String responseMessage = httpURLConnection2.getResponseMessage();
                LOG.n("url:" + str3 + " code:" + responseCode + " Post Data:" + str + " " + responseMessage);
                if (responseCode == 200) {
                    InputStream inputStream = httpURLConnection2.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb2.append(readLine);
                    }
                    String sb3 = sb2.toString();
                    try {
                        if (TextUtils.equals("{}", sb3)) {
                            netResponse = new NetResponse<>(1, null);
                        } else if (TextUtils.isEmpty(sb3)) {
                            netResponse = new NetResponse<>(-1, null);
                        } else {
                            netResponse2 = new NetResponse<>(0, sb3);
                            bufferedReader.close();
                            inputStream.close();
                        }
                        bufferedReader.close();
                        inputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            LOG.i(Log.getStackTraceString(th));
                        } finally {
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                        }
                    }
                    netResponse2 = netResponse;
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = httpURLConnection2;
                httpURLConnection2 = httpURLConnection;
                LOG.i(Log.getStackTraceString(th));
            }
        } catch (Throwable th4) {
            th = th4;
        }
        return netResponse2;
    }

    public static String getCurProcessName(Context context) {
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                str = Application.getProcessName();
            } else {
                int myPid = Process.myPid();
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == myPid) {
                            str = runningAppProcessInfo.processName;
                        }
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return TextUtils.isEmpty(str) ? context.getPackageName() : str;
    }

    public static String getDomain(String str) {
        String str2;
        if (str == null || !str.startsWith("http")) {
            str2 = str;
        } else {
            try {
                str2 = new URL(str).getHost();
            } catch (MalformedURLException e11) {
                e11.printStackTrace();
                str2 = "";
            }
        }
        if (TextUtils.isEmpty(str2)) {
            LOG.i("the url is illegal->" + str);
        }
        return str2;
    }

    public static String getMcc() {
        String f11 = DeviceInfo.f();
        return (TextUtils.isEmpty(f11) || f11.length() < 3) ? "" : f11.substring(0, 3);
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                if (!networkCapabilities.hasTransport(1) && !networkCapabilities.hasTransport(0) && !networkCapabilities.hasTransport(4)) {
                    if (!networkCapabilities.hasTransport(3)) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Exception e11) {
            LOG.i(Log.getStackTraceString(e11));
        }
        return false;
    }

    public static String mapToString(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append(SEPARATOR);
            sb2.append(entry.getValue());
            sb2.append(",");
        }
        return sb2.toString();
    }

    public static Map<String, String> stringToMap(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(8);
        if (str != null && str.length() != 0) {
            for (String str2 : str.split(",")) {
                String[] split = str2.split(SEPARATOR);
                if (split.length == 2) {
                    concurrentHashMap.put(split[0], split[1]);
                }
            }
        }
        return concurrentHashMap;
    }
}
