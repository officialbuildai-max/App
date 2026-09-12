package com.mbridge.msdk.tracker.network.toolbox;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.tools.i0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class i {

    /* renamed from: f, reason: collision with root package name */
    private static final String f38716f = "i";

    /* renamed from: g, reason: collision with root package name */
    private static volatile i f38717g;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, InetAddress> f38718a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f38719b = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private String f38721d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f38722e = "";

    /* renamed from: c, reason: collision with root package name */
    private final com.mbridge.msdk.foundation.buffer.sharedperference.a f38720c = com.mbridge.msdk.foundation.buffer.sharedperference.a.b();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements OnDownloadStateListener<Object> {

        /* renamed from: a, reason: collision with root package name */
        private final String f38723a;

        /* renamed from: b, reason: collision with root package name */
        private final String f38724b;

        /* renamed from: c, reason: collision with root package name */
        private final String f38725c;

        public a(String str, String str2, String str3) {
            this.f38723a = str;
            this.f38724b = str2;
            this.f38725c = str3;
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onCancelDownload(DownloadMessage<Object> downloadMessage) {
            i.b().c();
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadComplete(DownloadMessage<Object> downloadMessage) {
            i.b().b(this.f38723a, this.f38724b, this.f38725c);
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadError(DownloadMessage<Object> downloadMessage, DownloadError downloadError) {
            i.b().c();
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadStart(DownloadMessage<Object> downloadMessage) {
        }
    }

    private i() {
    }

    private void a() {
        String a11 = this.f38720c.a("cache");
        String a12 = this.f38720c.a("url");
        String b11 = q0.a().b("local_dns_config_url", "", false);
        if (TextUtils.isEmpty(b11)) {
            this.f38720c.a("cache", "");
        } else if (TextUtils.isEmpty(a11) || TextUtils.isEmpty(a12) || !TextUtils.equals(b11, a12)) {
            a(b11);
        } else {
            d(a11);
        }
    }

    private void a(String str) {
        a(str, com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_OTHER) + File.separator, b(str));
    }

    private void a(String str, String str2, String str3) {
        MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str, str3, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER)).withConnectTimeout(30000L).withReadTimeout(30000L).withWriteTimeout(30000L).withTimeout(30000L).withHttpRetryCounter(5).withDirectoryPathInternal(str2).withDownloadPriority(DownloadPriority.HIGH).withDownloadStateListener(new a(str, str2, str3)).build().start();
    }

    public static i b() {
        if (f38717g == null) {
            synchronized (i.class) {
                try {
                    if (f38717g == null) {
                        f38717g = new i();
                    }
                } finally {
                }
            }
        }
        return f38717g;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String path = new URL(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3) {
        try {
            String a11 = com.mbridge.msdk.foundation.same.c.a(new FileInputStream(new File(str2, str3)));
            if (TextUtils.isEmpty(a11)) {
                return;
            }
            this.f38720c.a("cache", a11);
            this.f38720c.a("url", str);
            d(a11);
        } catch (Exception e11) {
            o0.b(f38716f, "downloadLocalDNSConfig: onDownloadComplete: file not found", e11);
            this.f38721d = "find local dns config file error";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f38719b.set(false);
        this.f38721d = "download local dns config error";
    }

    private void d(String str) {
        try {
            this.f38722e = e(com.mbridge.msdk.foundation.same.net.utils.d.h().f35546y);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(i0.a(str));
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && next.contains(this.f38722e)) {
                    String string = jSONObject.getString(next);
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            this.f38718a.put(next, InetAddress.getByAddress(next, com.mbridge.msdk.foundation.same.c.b(string)));
                        } catch (UnknownHostException e11) {
                            this.f38721d = String.format("create InetAddress failed for %s with ip %s", next, string);
                            o0.b(f38716f, "init: local dns cache error", e11);
                        }
                    }
                }
            }
            this.f38719b.set(true);
        } catch (Exception e12) {
            o0.b(f38716f, "init: local dns cache json parse error", e12);
            this.f38721d = "parse local dns config error";
            this.f38718a.clear();
            this.f38719b.set(false);
        }
    }

    private static String e(String str) {
        return str.replace("https://{}", "").replace("http://{}", "");
    }

    public List<InetAddress> a(@NonNull String str, UnknownHostException unknownHostException) throws UnknownHostException {
        InetAddress inetAddress;
        try {
            inetAddress = this.f38718a.get(str);
        } catch (Exception e11) {
            o0.b(f38716f, "lookup: local dns cache error", e11);
            inetAddress = null;
        }
        if (inetAddress == null) {
            throw unknownHostException;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(inetAddress);
        return arrayList;
    }

    public boolean c(String str) {
        return TextUtils.equals(str, com.mbridge.msdk.foundation.same.net.utils.d.h().f35524e.replace("https://", ""));
    }

    public boolean c(String str, String str2, String str3) {
        return e() && d() && TextUtils.equals(str, MBInterstitialActivity.INTENT_CAMAPIGN) && !c(str3) && (TextUtils.equals(str2, String.valueOf(94)) || TextUtils.equals(str2, String.valueOf(MBSupportMuteAdType.INTERSTITIAL_VIDEO)));
    }

    public boolean d() {
        return this.f38719b.get() && !this.f38718a.isEmpty();
    }

    public boolean e() {
        return q0.a().b("local_dns", false, false);
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str) || !e()) {
            return;
        }
        this.f38719b.set(false);
        this.f38718a.clear();
        a();
    }
}
