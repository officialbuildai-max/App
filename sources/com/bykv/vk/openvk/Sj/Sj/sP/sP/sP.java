package com.bykv.vk.openvk.Sj.Sj.sP.sP;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.SystemClock;
import android.provider.BaseColumns;
import android.text.TextUtils;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.Dq;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.TKC;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.d;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

/* loaded from: classes2.dex */
class sP extends Sj {
    final Object Fmk;
    private volatile com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.sP TzV;
    private final int Zq;
    private volatile Dq.Sj dNu;
    final Object sef;
    private final b uvD;

    /* loaded from: classes2.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        String f20339a;

        /* renamed from: b, reason: collision with root package name */
        String f20340b;

        /* renamed from: c, reason: collision with root package name */
        com.bykv.vk.openvk.Sj.Sj.sP.sP.d f20341c;

        /* renamed from: d, reason: collision with root package name */
        com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj.a f20342d;

        /* renamed from: e, reason: collision with root package name */
        e f20343e;

        /* renamed from: f, reason: collision with root package name */
        List f20344f;

        /* renamed from: g, reason: collision with root package name */
        int f20345g;

        /* renamed from: h, reason: collision with root package name */
        uA f20346h;

        /* renamed from: i, reason: collision with root package name */
        b f20347i;

        /* renamed from: j, reason: collision with root package name */
        Object f20348j;

        a a(int i11) {
            this.f20345g = i11;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a b(com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj.a aVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("cache == null");
            }
            this.f20342d = aVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a c(com.bykv.vk.openvk.Sj.Sj.sP.sP.d dVar) {
            if (dVar == null) {
                throw new IllegalArgumentException("urls is empty");
            }
            this.f20341c = dVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a d(b bVar) {
            this.f20347i = bVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a e(e eVar) {
            throw new IllegalArgumentException("db == null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a f(uA uAVar) {
            this.f20346h = uAVar;
            return this;
        }

        a g(Object obj) {
            this.f20348j = obj;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a h(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("rawKey == null");
            }
            this.f20339a = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a i(List list) {
            this.f20344f = list;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public sP j() {
            com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj.a aVar = this.f20342d;
            throw new IllegalArgumentException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a k(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("key == null");
            }
            this.f20340b = str;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(sP sPVar);
    }

    /* loaded from: classes2.dex */
    public abstract class c extends SQLiteOpenHelper {
    }

    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f20349a;

        /* renamed from: b, reason: collision with root package name */
        public final String f20350b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20351c;

        /* renamed from: d, reason: collision with root package name */
        public final int f20352d;

        /* renamed from: e, reason: collision with root package name */
        public final String f20353e;

        public d(String str, String str2, int i11, int i12, String str3) {
            this.f20349a = str;
            this.f20350b = str2;
            this.f20351c = i11;
            this.f20352d = i12;
            this.f20353e = str3;
        }
    }

    /* loaded from: classes2.dex */
    public abstract class e {

        /* renamed from: a, reason: collision with root package name */
        private final c f20354a;

        /* renamed from: b, reason: collision with root package name */
        private volatile SQLiteStatement f20355b;

        public abstract d c(String str, int i11);

        public abstract void d(d dVar);
    }

    /* loaded from: classes2.dex */
    public abstract class f implements BaseColumns {
        public static int a(boolean z10) {
            return z10 ? 1 : 0;
        }
    }

    sP(a aVar) {
        super(aVar.f20342d, aVar.f20343e);
        this.Zq = aVar.f20345g;
        this.uvD = aVar.f20347i;
        this.Fmk = this;
        this.Jcg = aVar.f20339a;
        this.Dq = aVar.f20340b;
        this.vS = aVar.f20344f;
        this.TEQ = aVar.f20341c;
        this.uA = aVar.f20346h;
        this.sef = aVar.f20348j;
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Sj(com.bykv.vk.openvk.Sj.Sj.sP.sP.d.a r13) throws java.io.IOException, com.bykv.vk.openvk.Sj.Sj.sP.sP.Dq.Sj, com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.Sj, com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.sP {
        /*
            Method dump skipped, instructions count: 501
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.Sj.Sj.sP.sP.sP.Sj(com.bykv.vk.openvk.Sj.Sj.sP.sP.d$a):void");
    }

    private boolean TEQ() throws com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.Sj {
        while (this.TEQ.b()) {
            HiB();
            d.a d11 = this.TEQ.d();
            try {
                Sj(d11);
                return true;
            } catch (Dq.Sj e11) {
                this.dNu = e11;
                Jcg();
                return false;
            } catch (TKC unused) {
                d11.a();
                Jcg();
            } catch (com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.sP e12) {
                this.TzV = e12;
                return false;
            } catch (IOException e13) {
                if (e13 instanceof SocketTimeoutException) {
                    d11.b();
                }
                if (!sP()) {
                    Jcg();
                }
            } catch (Throwable unused2) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dq.Sj Dq() {
        return this.dNu;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Sj.b(this.Dq);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            TEQ();
        } catch (Throwable unused) {
        }
        this.EjP.set(SystemClock.elapsedRealtime() - elapsedRealtime);
        this.Sj.d(this.Dq);
        b bVar = this.uvD;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.sP uA() {
        return this.TzV;
    }
}
