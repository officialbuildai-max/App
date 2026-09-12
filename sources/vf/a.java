package vf;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import uf.d;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: o, reason: collision with root package name */
    private static a f77402o;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f77403p;

    /* renamed from: a, reason: collision with root package name */
    final Context f77404a;

    /* renamed from: b, reason: collision with root package name */
    final File f77405b;

    /* renamed from: c, reason: collision with root package name */
    final sf.b f77406c;

    /* renamed from: d, reason: collision with root package name */
    final uf.c f77407d;

    /* renamed from: e, reason: collision with root package name */
    final d f77408e;

    /* renamed from: f, reason: collision with root package name */
    final File f77409f;

    /* renamed from: g, reason: collision with root package name */
    final File f77410g;

    /* renamed from: h, reason: collision with root package name */
    final rf.a f77411h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f77412i;

    /* renamed from: j, reason: collision with root package name */
    final boolean f77413j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f77414k;

    /* renamed from: l, reason: collision with root package name */
    int f77415l;

    /* renamed from: m, reason: collision with root package name */
    c f77416m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f77417n;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Context f77418a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f77419b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f77420c;

        /* renamed from: d, reason: collision with root package name */
        private int f77421d = -1;

        /* renamed from: e, reason: collision with root package name */
        private uf.c f77422e;

        /* renamed from: f, reason: collision with root package name */
        private d f77423f;

        /* renamed from: g, reason: collision with root package name */
        private sf.b f77424g;

        /* renamed from: h, reason: collision with root package name */
        private rf.a f77425h;

        /* renamed from: i, reason: collision with root package name */
        private File f77426i;

        /* renamed from: j, reason: collision with root package name */
        private File f77427j;

        /* renamed from: k, reason: collision with root package name */
        private File f77428k;

        /* renamed from: l, reason: collision with root package name */
        private Boolean f77429l;

        public b(Context context) {
            if (context == null) {
                throw new TinkerRuntimeException("Context must not be null.");
            }
            this.f77418a = context;
            this.f77419b = ShareTinkerInternals.isInMainProcess(context);
            this.f77420c = wf.b.c(context);
            File patchDirectory = SharePatchFileUtil.getPatchDirectory(context);
            this.f77426i = patchDirectory;
            if (patchDirectory == null) {
                ShareTinkerLog.e("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
                return;
            }
            this.f77427j = SharePatchFileUtil.getPatchInfoFile(patchDirectory.getAbsolutePath());
            this.f77428k = SharePatchFileUtil.getPatchInfoLockFile(this.f77426i.getAbsolutePath());
            ShareTinkerLog.w("Tinker.Tinker", "tinker patch directory: %s", this.f77426i);
        }

        public a a() {
            if (this.f77421d == -1) {
                this.f77421d = 15;
            }
            if (this.f77422e == null) {
                this.f77422e = new uf.a(this.f77418a);
            }
            if (this.f77423f == null) {
                this.f77423f = new uf.b(this.f77418a);
            }
            if (this.f77424g == null) {
                this.f77424g = new sf.a(this.f77418a);
            }
            if (this.f77429l == null) {
                this.f77429l = Boolean.FALSE;
            }
            return new a(this.f77418a, this.f77421d, this.f77422e, this.f77423f, this.f77424g, this.f77426i, this.f77427j, this.f77428k, this.f77425h, this.f77419b, this.f77420c, this.f77429l.booleanValue());
        }

        public b b(sf.b bVar) {
            if (bVar == null) {
                throw new TinkerRuntimeException("listener must not be null.");
            }
            if (this.f77424g != null) {
                throw new TinkerRuntimeException("listener is already set.");
            }
            this.f77424g = bVar;
            return this;
        }

        public b c(uf.c cVar) {
            if (cVar == null) {
                throw new TinkerRuntimeException("loadReporter must not be null.");
            }
            if (this.f77422e != null) {
                throw new TinkerRuntimeException("loadReporter is already set.");
            }
            this.f77422e = cVar;
            return this;
        }

        public b d(d dVar) {
            if (dVar == null) {
                throw new TinkerRuntimeException("patchReporter must not be null.");
            }
            if (this.f77423f != null) {
                throw new TinkerRuntimeException("patchReporter is already set.");
            }
            this.f77423f = dVar;
            return this;
        }

        public b e(int i11) {
            if (this.f77421d != -1) {
                throw new TinkerRuntimeException("tinkerFlag is already set.");
            }
            this.f77421d = i11;
            return this;
        }

        public b f(Boolean bool) {
            if (bool == null) {
                throw new TinkerRuntimeException("tinkerLoadVerifyFlag must not be null.");
            }
            if (this.f77429l != null) {
                throw new TinkerRuntimeException("tinkerLoadVerifyFlag is already set.");
            }
            this.f77429l = bool;
            return this;
        }
    }

    private a(Context context, int i11, uf.c cVar, d dVar, sf.b bVar, File file, File file2, File file3, rf.a aVar, boolean z10, boolean z11, boolean z12) {
        this.f77417n = false;
        this.f77404a = context;
        this.f77406c = bVar;
        this.f77407d = cVar;
        this.f77408e = dVar;
        this.f77415l = i11;
        this.f77405b = file;
        this.f77409f = file2;
        this.f77410g = file3;
        this.f77411h = aVar;
        this.f77412i = z10;
        this.f77414k = z12;
        this.f77413j = z11;
    }

    public static void d(a aVar) {
        if (f77402o != null) {
            throw new TinkerRuntimeException("Tinker instance is already set.");
        }
        f77402o = aVar;
    }

    public static a x(Context context) {
        if (!f77403p) {
            throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
        }
        synchronized (a.class) {
            try {
                if (f77402o == null) {
                    f77402o = new b(context).a();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f77402o;
    }

    public void a() {
        ShareTinkerInternals.cleanPatch(e());
    }

    public void b(File file) {
        if (this.f77405b == null || file == null || !file.exists()) {
            return;
        }
        c(SharePatchFileUtil.getPatchVersionDirectory(SharePatchFileUtil.getMD5(file)));
    }

    public void c(String str) {
        if (this.f77405b == null || str == null) {
            return;
        }
        SharePatchFileUtil.deleteDir(this.f77405b.getAbsolutePath() + "/" + str);
    }

    public Context e() {
        return this.f77404a;
    }

    public rf.a f() {
        return this.f77411h;
    }

    public uf.c g() {
        return this.f77407d;
    }

    public File h() {
        return this.f77405b;
    }

    public File i() {
        return this.f77409f;
    }

    public sf.b j() {
        return this.f77406c;
    }

    public d k() {
        return this.f77408e;
    }

    public int l() {
        return this.f77415l;
    }

    public c m() {
        return this.f77416m;
    }

    public void n(Intent intent, Class cls, tf.a aVar) {
        f77403p = true;
        TinkerPatchService.k(aVar, cls);
        ShareTinkerLog.i("Tinker.Tinker", "try to install tinker, isEnable: %b, version: %s", Boolean.valueOf(t()), "1.9.15.2");
        if (!t()) {
            ShareTinkerLog.e("Tinker.Tinker", "tinker is disabled", new Object[0]);
            return;
        }
        if (intent == null) {
            throw new TinkerRuntimeException("intentResult must not be null.");
        }
        c cVar = new c();
        this.f77416m = cVar;
        cVar.a(e(), intent);
        uf.c cVar2 = this.f77407d;
        File file = this.f77405b;
        c cVar3 = this.f77416m;
        cVar2.e(file, cVar3.f77445p, cVar3.f77446q);
        if (this.f77417n) {
            return;
        }
        ShareTinkerLog.w("Tinker.Tinker", "tinker load fail!", new Object[0]);
    }

    public boolean o() {
        return ShareTinkerInternals.isTinkerEnabledForDex(this.f77415l);
    }

    public boolean p() {
        return ShareTinkerInternals.isTinkerEnabledForNativeLib(this.f77415l);
    }

    public boolean q() {
        return ShareTinkerInternals.isTinkerEnabledForResource(this.f77415l);
    }

    public boolean r() {
        return this.f77412i;
    }

    public boolean s() {
        return this.f77413j;
    }

    public boolean t() {
        return ShareTinkerInternals.isTinkerEnabled(this.f77415l);
    }

    public boolean u() {
        return this.f77417n;
    }

    public void v() {
        this.f77415l = 0;
    }

    public void w(boolean z10) {
        this.f77417n = z10;
    }
}
