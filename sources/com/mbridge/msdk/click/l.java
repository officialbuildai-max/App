package com.mbridge.msdk.click;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.click.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.task.a;
import java.util.concurrent.Semaphore;

/* loaded from: classes5.dex */
public class l extends com.mbridge.msdk.foundation.same.task.a {

    /* renamed from: b, reason: collision with root package name */
    private final Context f34394b;

    /* renamed from: c, reason: collision with root package name */
    private final String f34395c;

    /* renamed from: d, reason: collision with root package name */
    private final String f34396d;

    /* renamed from: e, reason: collision with root package name */
    private final String f34397e;

    /* renamed from: f, reason: collision with root package name */
    private final CampaignEx f34398f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f34399g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f34400h;

    /* renamed from: i, reason: collision with root package name */
    private final int f34401i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f34402j;

    /* renamed from: k, reason: collision with root package name */
    private com.mbridge.msdk.click.entity.a f34403k;

    /* renamed from: l, reason: collision with root package name */
    private JumpLoaderResult f34404l;

    /* renamed from: m, reason: collision with root package name */
    private g f34405m;

    /* renamed from: n, reason: collision with root package name */
    private k f34406n;

    /* renamed from: a, reason: collision with root package name */
    private final Semaphore f34393a = new Semaphore(0);

    /* renamed from: o, reason: collision with root package name */
    private final o.f f34407o = new a();

    /* loaded from: classes5.dex */
    class a implements o.f {
        a() {
        }

        private void a() {
            synchronized (this) {
                try {
                    l.this.f34404l.setSuccess(true);
                    if (l.this.f34406n != null) {
                        l.this.f34406n.a(l.this.f34404l);
                    }
                    l.this.a();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.mbridge.msdk.click.o.f
        public void a(int i11, String str, String str2, String str3) {
            if (!TextUtils.isEmpty(str2)) {
                l.this.f34404l.setExceptionMsg(str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                l.this.f34404l.setContent(str3);
            }
            l.this.b(str);
            a();
        }

        @Override // com.mbridge.msdk.click.o.f
        public void a(String str, boolean z10, String str2) {
            l.this.b(str);
            l.this.f34404l.setContent(str2);
            a();
        }

        @Override // com.mbridge.msdk.click.o.f
        public boolean a(String str) {
            boolean b11 = l.this.b(str);
            if (b11) {
                a();
            }
            return b11;
        }

        @Override // com.mbridge.msdk.click.o.f
        public boolean b(String str) {
            return false;
        }

        @Override // com.mbridge.msdk.click.o.f
        public boolean c(String str) {
            boolean b11 = l.this.b(str);
            if (b11) {
                a();
            }
            return b11;
        }
    }

    public l(com.mbridge.msdk.click.entity.b bVar) {
        this.f34394b = bVar.c();
        this.f34395c = bVar.e();
        this.f34396d = bVar.b();
        this.f34397e = bVar.d();
        this.f34398f = bVar.a();
        this.f34399g = bVar.g();
        this.f34400h = bVar.i();
        this.f34401i = bVar.f();
        this.f34402j = bVar.h();
    }

    private String a(String str) {
        if (this.f34402j) {
            String a11 = com.mbridge.msdk.setting.b.a(this.f34394b, str);
            if (!TextUtils.isEmpty(a11)) {
                str = str + a11;
            }
        }
        return com.mbridge.msdk.util.b.a() ? m.a(this.f34398f, str) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f34393a.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        return m.a(str, this.f34398f, this.f34404l);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016b A[EDGE_INSN: B:72:0x016b->B:34:0x016b BREAK  A[LOOP:0: B:11:0x003e->B:53:0x0163], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.mbridge.msdk.click.entity.JumpLoaderResult c(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.l.c(java.lang.String):com.mbridge.msdk.click.entity.JumpLoaderResult");
    }

    public void a(g gVar) {
        this.f34405m = gVar;
    }

    public void a(k kVar) {
        this.f34406n = kVar;
    }

    @Override // com.mbridge.msdk.foundation.same.task.a
    public void cancelTask() {
    }

    @Override // com.mbridge.msdk.foundation.same.task.a
    public void pauseTask(boolean z10) {
    }

    @Override // com.mbridge.msdk.foundation.same.task.a
    public void runTask() {
        JumpLoaderResult jumpLoaderResult;
        g gVar = this.f34405m;
        if (gVar != null) {
            gVar.b(null);
        }
        JumpLoaderResult jumpLoaderResult2 = new JumpLoaderResult();
        this.f34404l = jumpLoaderResult2;
        jumpLoaderResult2.setUrl(this.f34395c);
        JumpLoaderResult c11 = c(this.f34395c);
        this.f34404l = c11;
        if (c11 != null && !TextUtils.isEmpty(c11.getExceptionMsg())) {
            this.f34404l.setSuccess(true);
        }
        if (this.mState != a.b.RUNNING) {
            k kVar = this.f34406n;
            if (kVar != null) {
                kVar.a(this.f34404l);
                return;
            }
            return;
        }
        JumpLoaderResult jumpLoaderResult3 = this.f34404l;
        if (jumpLoaderResult3 != null && !jumpLoaderResult3.isSuccess()) {
            k kVar2 = this.f34406n;
            if (kVar2 != null) {
                kVar2.a(this.f34404l);
                return;
            }
            return;
        }
        com.mbridge.msdk.click.entity.a aVar = this.f34403k;
        if (aVar != null && (jumpLoaderResult = this.f34404l) != null) {
            jumpLoaderResult.setStatusCode(aVar.f34370f);
        }
        m.a(this.f34398f, this.f34404l, this.f34403k, this.f34396d, this.f34397e, this.f34394b, this.f34407o, this.f34406n, this.f34393a);
    }
}
