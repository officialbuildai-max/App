package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.click.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.task.a;
import com.mbridge.msdk.foundation.tools.s0;
import java.util.concurrent.Semaphore;

/* loaded from: classes5.dex */
public class p extends f implements a.InterfaceC0493a {

    /* renamed from: b, reason: collision with root package name */
    private g f34442b;

    /* renamed from: c, reason: collision with root package name */
    private JumpLoaderResult f34443c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f34445e;

    /* renamed from: f, reason: collision with root package name */
    private Context f34446f;

    /* renamed from: g, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.task.b f34447g;

    /* renamed from: h, reason: collision with root package name */
    private com.mbridge.msdk.click.entity.a f34448h;

    /* renamed from: d, reason: collision with root package name */
    private boolean f34444d = true;

    /* renamed from: i, reason: collision with root package name */
    private Handler f34449i = new Handler(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    class a implements k {
        a() {
        }

        @Override // com.mbridge.msdk.click.k
        public void a(JumpLoaderResult jumpLoaderResult) {
            p.this.f34443c = jumpLoaderResult;
        }
    }

    /* loaded from: classes5.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.this.f34442b != null) {
                if (p.this.f34443c.isSuccess()) {
                    p.this.f34442b.a(p.this.f34443c);
                } else {
                    p.this.f34442b.a(p.this.f34443c, p.this.f34443c.getMsg());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c extends com.mbridge.msdk.foundation.same.task.a {

        /* renamed from: b, reason: collision with root package name */
        private final Context f34453b;

        /* renamed from: c, reason: collision with root package name */
        private String f34454c;

        /* renamed from: d, reason: collision with root package name */
        private String f34455d;

        /* renamed from: e, reason: collision with root package name */
        private String f34456e;

        /* renamed from: f, reason: collision with root package name */
        private CampaignEx f34457f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f34458g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f34459h;

        /* renamed from: i, reason: collision with root package name */
        private int f34460i;

        /* renamed from: a, reason: collision with root package name */
        private final Semaphore f34452a = new Semaphore(0);

        /* renamed from: j, reason: collision with root package name */
        private o.f f34461j = new a();

        /* loaded from: classes5.dex */
        class a implements o.f {
            a() {
            }

            private void a() {
                synchronized (p.this) {
                    p.this.f34443c.setSuccess(true);
                    c.this.a();
                }
            }

            @Override // com.mbridge.msdk.click.o.f
            public void a(int i11, String str, String str2, String str3) {
                if (!TextUtils.isEmpty(str2)) {
                    p.this.f34443c.setExceptionMsg(str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    p.this.f34443c.setContent(str3);
                }
                c.this.d(str);
                a();
            }

            @Override // com.mbridge.msdk.click.o.f
            public void a(String str, boolean z10, String str2) {
                c.this.d(str);
                p.this.f34443c.setContent(str2);
                a();
            }

            @Override // com.mbridge.msdk.click.o.f
            public boolean a(String str) {
                boolean d11 = c.this.d(str);
                if (d11) {
                    a();
                }
                return d11;
            }

            @Override // com.mbridge.msdk.click.o.f
            public boolean b(String str) {
                return false;
            }

            @Override // com.mbridge.msdk.click.o.f
            public boolean c(String str) {
                boolean d11 = c.this.d(str);
                if (d11) {
                    a();
                }
                return d11;
            }
        }

        public c(Context context, String str, String str2, String str3, CampaignEx campaignEx, boolean z10, boolean z11, int i11) {
            this.f34453b = context;
            this.f34454c = str;
            this.f34455d = str2;
            this.f34456e = str3;
            this.f34457f = campaignEx;
            this.f34458g = z10;
            this.f34459h = z11;
            this.f34460i = i11;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x01fb A[EDGE_INSN: B:86:0x01fb->B:55:0x01fb BREAK  A[LOOP:0: B:19:0x0064->B:51:0x01a5], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private com.mbridge.msdk.click.entity.JumpLoaderResult a(java.lang.String r16, boolean r17, boolean r18, com.mbridge.msdk.foundation.entity.CampaignEx r19, int r20) {
            /*
                Method dump skipped, instructions count: 508
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.p.c.a(java.lang.String, boolean, boolean, com.mbridge.msdk.foundation.entity.CampaignEx, int):com.mbridge.msdk.click.entity.JumpLoaderResult");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f34452a.release();
        }

        private boolean a(int i11) {
            return i11 == 200;
        }

        private boolean a(String str) {
            return s0.a.b(str);
        }

        private boolean b(int i11) {
            return i11 == 301 || i11 == 302 || i11 == 307;
        }

        private boolean b(String str) {
            return !URLUtil.isNetworkUrl(str);
        }

        private boolean c(String str) {
            return str.startsWith("/");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d(String str) {
            return q.a(str, this.f34457f, p.this.f34443c);
        }

        @Override // com.mbridge.msdk.foundation.same.task.a
        public void cancelTask() {
        }

        @Override // com.mbridge.msdk.foundation.same.task.a
        public void pauseTask(boolean z10) {
        }

        @Override // com.mbridge.msdk.foundation.same.task.a
        public void runTask() {
            if (p.this.f34442b != null) {
                p.this.f34442b.b(null);
            }
            p.this.f34443c = new JumpLoaderResult();
            p.this.f34443c.setUrl(this.f34454c);
            p.this.f34443c = a(this.f34454c, this.f34458g, this.f34459h, this.f34457f, this.f34460i);
            if (!TextUtils.isEmpty(p.this.f34443c.getExceptionMsg())) {
                p.this.f34443c.setSuccess(true);
            }
            if (p.this.f34444d && p.this.f34443c.isSuccess()) {
                if (p.this.f34448h != null) {
                    p.this.f34443c.setStatusCode(p.this.f34448h.f34370f);
                }
                q.a(this.f34457f, p.this.f34443c, p.this.f34448h, this.f34455d, this.f34456e, this.f34453b, this.f34461j, this.f34452a);
            }
        }
    }

    public p(Context context) {
        this.f34446f = context;
        this.f34447g = new com.mbridge.msdk.foundation.same.task.b(context, 2);
    }

    @Override // com.mbridge.msdk.foundation.same.task.a.InterfaceC0493a
    public void a(a.b bVar) {
        if (bVar == a.b.FINISH && this.f34444d) {
            this.f34449i.post(new b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(String str, g gVar, boolean z10, String str2, String str3, CampaignEx campaignEx, boolean z11, boolean z12, int i11) {
        c cVar;
        this.f34442b = gVar;
        this.f34445e = z10;
        com.mbridge.msdk.click.entity.b bVar = new com.mbridge.msdk.click.entity.b();
        bVar.a(this.f34446f);
        bVar.c(str);
        bVar.b(z10);
        bVar.a(str2);
        bVar.b(str3);
        bVar.a(campaignEx);
        bVar.a(z11);
        bVar.c(z12);
        bVar.a(i11);
        if (str.startsWith("tcp")) {
            l lVar = new l(bVar);
            lVar.a(this.f34442b);
            lVar.a(new a());
            cVar = lVar;
        } else {
            cVar = new c(this.f34446f, str, str2, str3, campaignEx, z11, z12, i11);
        }
        this.f34447g.b(cVar, this);
    }
}
