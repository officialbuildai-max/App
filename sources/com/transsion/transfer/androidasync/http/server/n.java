package com.transsion.transfer.androidasync.http.server;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cloud.tmc.integration.utils.share.config.ShareConstant;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.transfer.androidasync.http.b0;
import com.transsion.transfer.androidasync.http.f0;
import com.transsion.transfer.androidasync.http.server.AsyncHttpServer;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class n implements r {

    /* renamed from: c, reason: collision with root package name */
    static Hashtable f55599c;

    /* renamed from: d, reason: collision with root package name */
    static Hashtable f55600d;

    /* renamed from: a, reason: collision with root package name */
    final ArrayList f55601a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private b f55602b = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public abstract class a extends com.transsion.transfer.androidasync.http.server.c {

        /* renamed from: o, reason: collision with root package name */
        Matcher f55603o;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }
    }

    /* loaded from: classes6.dex */
    class b implements q, r {
        b() {
        }

        @Override // com.transsion.transfer.androidasync.http.server.r
        public d a(String str, String str2) {
            return n.this.a(str, str2);
        }

        @Override // com.transsion.transfer.androidasync.http.server.q
        public void b(com.transsion.transfer.androidasync.http.server.b bVar, com.transsion.transfer.androidasync.http.server.d dVar) {
            d a11 = a(bVar.B(), bVar.getPath());
            if (a11 != null) {
                a11.f55612d.b(bVar, dVar);
            } else {
                dVar.c(TTAdConstant.DEEPLINK_FALLBACK_CODE);
                dVar.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        String f55606a;

        /* renamed from: b, reason: collision with root package name */
        Pattern f55607b;

        /* renamed from: c, reason: collision with root package name */
        q f55608c;

        private c() {
        }
    }

    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f55609a;

        /* renamed from: b, reason: collision with root package name */
        public final String f55610b;

        /* renamed from: c, reason: collision with root package name */
        public final Matcher f55611c;

        /* renamed from: d, reason: collision with root package name */
        public final q f55612d;

        private d(String str, String str2, Matcher matcher, q qVar, com.transsion.transfer.androidasync.http.server.a aVar) {
            this.f55609a = str;
            this.f55610b = str2;
            this.f55611c = matcher;
            this.f55612d = qVar;
        }
    }

    static {
        Hashtable hashtable = new Hashtable();
        f55599c = hashtable;
        hashtable.put("js", "application/javascript");
        f55599c.put("json", "application/json");
        f55599c.put("png", "image/png");
        f55599c.put("jpg", "image/jpeg");
        f55599c.put("jpeg", "image/jpeg");
        f55599c.put("html", "text/html");
        f55599c.put("css", "text/css");
        f55599c.put("mp4", MimeTypes.VIDEO_MP4);
        f55599c.put("mov", "video/quicktime");
        f55599c.put("wmv", "video/x-ms-wmv");
        f55599c.put("txt", ShareConstant.SHARE_TYPE_TEXT);
        f55600d = new Hashtable();
    }

    public static b0 e(String str, com.transsion.transfer.androidasync.http.server.b bVar, com.transsion.transfer.androidasync.http.server.d dVar) {
        String c11 = bVar.getHeaders().c("Connection");
        boolean z10 = false;
        if (c11 != null) {
            String[] split = c11.split(",");
            int length = split.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if ("Upgrade".equalsIgnoreCase(split[i11].trim())) {
                    z10 = true;
                    break;
                }
                i11++;
            }
        }
        if ("websocket".equalsIgnoreCase(bVar.getHeaders().c("Upgrade")) && z10 && TextUtils.equals(str, bVar.getHeaders().c("Sec-WebSocket-Protocol"))) {
            return new f0(bVar, dVar);
        }
        return null;
    }

    public static String g(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return null;
        }
        String str2 = (String) f55599c.get(str.substring(lastIndexOf + 1));
        if (str2 != null) {
            return str2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(String str, AsyncHttpServer.a aVar, com.transsion.transfer.androidasync.http.server.b bVar, com.transsion.transfer.androidasync.http.server.d dVar) {
        b0 e11 = e(str, bVar, dVar);
        if (e11 != null) {
            aVar.a(e11, bVar);
        } else {
            dVar.c(TTAdConstant.DEEPLINK_FALLBACK_CODE);
            dVar.d();
        }
    }

    @Override // com.transsion.transfer.androidasync.http.server.r
    public d a(String str, String str2) {
        synchronized (this.f55601a) {
            try {
                Iterator it = this.f55601a.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (TextUtils.equals(str, cVar.f55606a) || cVar.f55606a == null) {
                        Matcher matcher = cVar.f55607b.matcher(str2);
                        if (matcher.matches()) {
                            q qVar = cVar.f55608c;
                            if (qVar instanceof r) {
                                return ((r) cVar.f55608c).a(str, matcher.group(1));
                            }
                            return new d(str, str2, matcher, qVar, null);
                        }
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void c(String str, String str2, q qVar) {
        d(str, str2, qVar, null);
    }

    public void d(String str, String str2, q qVar, com.transsion.transfer.androidasync.http.server.a aVar) {
        c cVar = new c();
        cVar.f55607b = Pattern.compile("^" + str2);
        cVar.f55608c = qVar;
        cVar.f55606a = str;
        synchronized (this.f55601a) {
            this.f55601a.add(cVar);
        }
    }

    public void f(String str, q qVar) {
        c("GET", str, qVar);
    }

    public void i(String str, q qVar) {
        c("POST", str, qVar);
    }

    public void j(String str, final String str2, final AsyncHttpServer.a aVar) {
        f(str, new q() { // from class: com.transsion.transfer.androidasync.http.server.l
            @Override // com.transsion.transfer.androidasync.http.server.q
            public final void b(b bVar, d dVar) {
                n.h(str2, aVar, bVar, dVar);
            }
        });
    }
}
