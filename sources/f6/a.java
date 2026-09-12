package f6;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.sP;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.uA;
import com.bytedance.sdk.component.Dq.Dq;
import com.bytedance.sdk.component.Dq.vS;
import h6.b;
import h6.c;
import java.io.Closeable;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f62463a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f62464b = Charset.forName("UTF-8");

    public static int a() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 1);
    }

    public static int b(c cVar) {
        int lastIndexOf;
        if (cVar == null) {
            return -1;
        }
        if (cVar.d() == 200) {
            return c(cVar.g(HttpHeaders.CONTENT_LENGTH, null), -1);
        }
        if (cVar.d() == 206) {
            String g11 = cVar.g("Content-Range", null);
            if (!TextUtils.isEmpty(g11) && (lastIndexOf = g11.lastIndexOf("/")) >= 0 && lastIndexOf < g11.length() - 1) {
                return c(g11.substring(lastIndexOf + 1), -1);
            }
        }
        return -1;
    }

    public static int c(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return i11;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i11;
        }
    }

    public static sP.d d(c cVar, sP.e eVar, String str, int i11) {
        String str2;
        String str3;
        String str4;
        sP.d c11 = eVar.c(str, i11);
        if (c11 != null) {
            return c11;
        }
        int b11 = b(cVar);
        String g11 = cVar.g(HttpHeaders.CONTENT_TYPE, null);
        if (b11 <= 0 || TextUtils.isEmpty(g11)) {
            return c11;
        }
        b c12 = cVar.c();
        if (c12 != null) {
            str3 = c12.f64496b;
            str2 = w(c12.f64499e);
        } else {
            str2 = "";
            str3 = str2;
        }
        String v11 = v(cVar.h());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestUrl", str3);
            jSONObject.put("requestHeaders", str2);
            jSONObject.put("responseHeaders", v11);
            str4 = jSONObject.toString();
        } catch (Throwable unused) {
            str4 = "";
        }
        sP.d dVar = new sP.d(str, g11, b11, i11, str4);
        eVar.d(dVar);
        return dVar;
    }

    public static String e(int i11, int i12) {
        String u11 = u(i11, i12);
        if (u11 == null) {
            return null;
        }
        return "bytes=".concat(u11);
    }

    public static String f(sP.d dVar, int i11) {
        StringBuilder sb2 = new StringBuilder();
        if (i11 <= 0) {
            sb2.append("HTTP/1.1 200 OK\r\n");
        } else {
            sb2.append("HTTP/1.1 206 Partial Content\r\n");
        }
        sb2.append("Accept-Ranges: bytes\r\n");
        sb2.append("Content-Type: ");
        sb2.append(dVar.f20350b);
        sb2.append("\r\n");
        if (i11 <= 0) {
            sb2.append("Content-Length: ");
            sb2.append(dVar.f20351c);
            sb2.append("\r\n");
        } else {
            sb2.append("Content-Range: bytes ");
            sb2.append(i11);
            sb2.append("-");
            sb2.append(dVar.f20351c - 1);
            sb2.append("/");
            sb2.append(dVar.f20351c);
            sb2.append("\r\n");
            sb2.append("Content-Length: ");
            sb2.append(dVar.f20351c - i11);
            sb2.append("\r\n");
        }
        sb2.append("Connection: close\r\n");
        sb2.append("\r\n");
        String sb3 = sb2.toString();
        boolean z10 = com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b;
        return sb3;
    }

    public static String g(c cVar, int i11) {
        boolean z10;
        int b11;
        if (cVar == null || !cVar.i()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cVar.b().toUpperCase());
        sb2.append(' ');
        sb2.append(cVar.d());
        sb2.append(' ');
        sb2.append(cVar.j());
        sb2.append("\r\n");
        if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(cVar.b().toUpperCase());
            sb3.append(" ");
            sb3.append(cVar.d());
            sb3.append(" ");
            sb3.append(cVar.j());
        }
        List i12 = i(cVar.h());
        if (i12 != null) {
            int size = i12.size();
            z10 = true;
            for (int i13 = 0; i13 < size; i13++) {
                uA.c cVar2 = (uA.c) i12.get(i13);
                if (cVar2 != null) {
                    String str = cVar2.f20369a;
                    String str2 = cVar2.f20370b;
                    sb2.append(str);
                    sb2.append(": ");
                    sb2.append(str2);
                    sb2.append("\r\n");
                    if ("Content-Range".equalsIgnoreCase(str) || ("Accept-Ranges".equalsIgnoreCase(str) && "bytes".equalsIgnoreCase(str2))) {
                        z10 = false;
                    }
                }
            }
        } else {
            z10 = true;
        }
        if (z10 && (b11 = b(cVar)) > 0) {
            sb2.append("Content-Range: bytes ");
            sb2.append(Math.max(i11, 0));
            sb2.append("-");
            sb2.append(b11 - 1);
            sb2.append("/");
            sb2.append(b11);
            sb2.append("\r\n");
        }
        sb2.append("Connection: close\r\n");
        sb2.append("\r\n");
        String sb4 = sb2.toString();
        boolean z11 = com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b;
        return sb4;
    }

    public static String h(c cVar, boolean z10, boolean z11) {
        String g11;
        if (cVar == null) {
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                Log.e("TAG_PROXY_Response", "response null");
            }
            return "response null";
        }
        if (!cVar.i()) {
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                Log.e("TAG_PROXY_Response", "response code: " + cVar.d());
            }
            return "response code: " + cVar.d();
        }
        String g12 = cVar.g(HttpHeaders.CONTENT_TYPE, null);
        if (!s(g12)) {
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                Log.e("TAG_PROXY_Response", "Content-Type: ".concat(String.valueOf(g12)));
            }
            return "Content-Type: ".concat(String.valueOf(g12));
        }
        int b11 = b(cVar);
        if (b11 <= 0) {
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                Log.e("TAG_PROXY_Response", "Content-Length: ".concat(String.valueOf(b11)));
            }
            return "Content-Length: ".concat(String.valueOf(b11));
        }
        if (z10 && ((g11 = cVar.g("Accept-Ranges", null)) == null || !g11.contains("bytes"))) {
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                Log.e("TAG_PROXY_Response", "Accept-Ranges: ".concat(String.valueOf(g11)));
            }
            return "Accept-Ranges: ".concat(String.valueOf(g11));
        }
        if (!z11 || cVar.a() != null) {
            return null;
        }
        if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
            Log.e("TAG_PROXY_Response", "response body null");
        }
        return "response body null";
    }

    public static List i(List list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                uA.c cVar = (uA.c) list.get(i11);
                if (cVar != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(cVar.f20369a);
                    sb2.append(": ");
                    sb2.append(cVar.f20369a);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            uA.c cVar2 = (uA.c) it.next();
            if (HttpHeaders.HOST.equals(cVar2.f20369a) || "Keep-Alive".equals(cVar2.f20369a) || "Connection".equals(cVar2.f20369a) || "Proxy-Connection".equals(cVar2.f20369a)) {
                arrayList.add(cVar2);
            }
        }
        list.removeAll(arrayList);
        if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
            int size2 = list.size();
            for (int i12 = 0; i12 < size2; i12++) {
                uA.c cVar3 = (uA.c) list.get(i12);
                if (cVar3 != null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(cVar3.f20369a);
                    sb3.append(": ");
                    sb3.append(cVar3.f20370b);
                }
            }
        }
        return list;
    }

    public static List j(Map map) {
        if (map != null && !map.isEmpty()) {
            try {
                Set<Map.Entry> entrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : entrySet) {
                    arrayList.add(new uA.c((String) entry.getKey(), (String) entry.getValue()));
                }
                return arrayList;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static List k(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (r(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static void l(Dq dq2) {
        if (dq2 != null) {
            if (x()) {
                vS.sP(dq2);
                if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                    Log.e("TAG_PROXY_UTIL", "invoke in pool thread");
                    return;
                }
                return;
            }
            dq2.run();
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                Log.e("TAG_PROXY_UTIL", "invoke calling thread");
            }
        }
    }

    public static void m(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void n(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void o(Runnable runnable) {
        if (runnable != null) {
            if (x()) {
                runnable.run();
            } else {
                f62463a.post(runnable);
            }
        }
    }

    public static void p(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void q(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean r(String str) {
        if (str != null) {
            return str.startsWith("http://") || str.startsWith("https://");
        }
        return false;
    }

    public static boolean s(String str) {
        if (str != null) {
            return str.startsWith("video/") || OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE.equals(str) || "binary/octet-stream".equals(str);
        }
        return false;
    }

    public static int t(String str) {
        return c(str, 0);
    }

    public static String u(int i11, int i12) {
        if (i11 >= 0 && i12 > 0) {
            return i11 + "-" + i12;
        }
        if (i11 > 0) {
            return i11 + "-";
        }
        if (i11 >= 0 || i12 <= 0) {
            return null;
        }
        return "-".concat(String.valueOf(i12));
    }

    public static String v(List list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            uA.c cVar = (uA.c) list.get(0);
            if (cVar != null) {
                sb2.append(cVar.f20369a);
                sb2.append(": ");
                sb2.append(cVar.f20370b);
                sb2.append("\r\n");
            }
        }
        return sb2.toString();
    }

    public static String w(Map map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append(": ");
            sb2.append(entry.getValue());
            sb2.append("\r\n");
        }
        return sb2.toString();
    }

    public static boolean x() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
