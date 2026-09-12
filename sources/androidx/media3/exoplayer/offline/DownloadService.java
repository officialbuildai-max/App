package androidx.media3.exoplayer.offline;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.h0;
import androidx.media3.common.util.u;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.media3.exoplayer.scheduler.Requirements;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class DownloadService extends Service {

    /* renamed from: k, reason: collision with root package name */
    private static final HashMap f12434k = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final c f12435a;

    /* renamed from: b, reason: collision with root package name */
    private final String f12436b;

    /* renamed from: c, reason: collision with root package name */
    private final int f12437c;

    /* renamed from: d, reason: collision with root package name */
    private final int f12438d;

    /* renamed from: e, reason: collision with root package name */
    private b f12439e;

    /* renamed from: f, reason: collision with root package name */
    private int f12440f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f12441g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f12442h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f12443i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f12444j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements DownloadManager.d {

        /* renamed from: a, reason: collision with root package name */
        private final Context f12445a;

        /* renamed from: b, reason: collision with root package name */
        private final DownloadManager f12446b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f12447c;

        /* renamed from: d, reason: collision with root package name */
        private final f2.f f12448d;

        /* renamed from: e, reason: collision with root package name */
        private final Class f12449e;

        /* renamed from: f, reason: collision with root package name */
        private DownloadService f12450f;

        /* renamed from: g, reason: collision with root package name */
        private Requirements f12451g;

        private b(Context context, DownloadManager downloadManager, boolean z10, f2.f fVar, Class cls) {
            this.f12445a = context;
            this.f12446b = downloadManager;
            this.f12447c = z10;
            this.f12448d = fVar;
            this.f12449e = cls;
            downloadManager.d(this);
            q();
        }

        private void k() {
            Requirements requirements = new Requirements(0);
            if (o(requirements)) {
                this.f12448d.cancel();
                this.f12451g = requirements;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(DownloadService downloadService) {
            downloadService.v(this.f12446b.e());
        }

        private void n() {
            if (this.f12447c) {
                try {
                    a1.r1(this.f12445a, DownloadService.o(this.f12445a, this.f12449e, "androidx.media3.exoplayer.downloadService.action.RESTART"));
                    return;
                } catch (IllegalStateException unused) {
                    u.h("DownloadService", "Failed to restart (foreground launch restriction)");
                    return;
                }
            }
            try {
                this.f12445a.startService(DownloadService.o(this.f12445a, this.f12449e, "androidx.media3.exoplayer.downloadService.action.INIT"));
            } catch (IllegalStateException unused2) {
                u.h("DownloadService", "Failed to restart (process is idle)");
            }
        }

        private boolean o(Requirements requirements) {
            return !Objects.equals(this.f12451g, requirements);
        }

        private boolean p() {
            DownloadService downloadService = this.f12450f;
            return downloadService == null || downloadService.r();
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void a(DownloadManager downloadManager, boolean z10) {
            if (z10 || downloadManager.g() || !p()) {
                return;
            }
            List e11 = downloadManager.e();
            for (int i11 = 0; i11 < e11.size(); i11++) {
                if (((androidx.media3.exoplayer.offline.c) e11.get(i11)).f12496b == 0) {
                    n();
                    return;
                }
            }
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void b(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c cVar) {
            DownloadService downloadService = this.f12450f;
            if (downloadService != null) {
                downloadService.u();
            }
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public /* synthetic */ void c(DownloadManager downloadManager, boolean z10) {
            j.a(this, downloadManager, z10);
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public final void d(DownloadManager downloadManager) {
            DownloadService downloadService = this.f12450f;
            if (downloadService != null) {
                downloadService.w();
            }
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void e(DownloadManager downloadManager, Requirements requirements, int i11) {
            q();
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void f(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c cVar, Exception exc) {
            DownloadService downloadService = this.f12450f;
            if (downloadService != null) {
                downloadService.t(cVar);
            }
            if (p() && DownloadService.s(cVar.f12496b)) {
                u.h("DownloadService", "DownloadService wasn't running. Restarting.");
                n();
            }
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void g(DownloadManager downloadManager) {
            DownloadService downloadService = this.f12450f;
            if (downloadService != null) {
                downloadService.v(downloadManager.e());
            }
        }

        public void j(final DownloadService downloadService) {
            androidx.media3.common.util.a.g(this.f12450f == null);
            this.f12450f = downloadService;
            if (this.f12446b.l()) {
                a1.C().postAtFrontOfQueue(new Runnable() { // from class: androidx.media3.exoplayer.offline.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        DownloadService.b.this.m(downloadService);
                    }
                });
            }
        }

        public void l(DownloadService downloadService) {
            androidx.media3.common.util.a.g(this.f12450f == downloadService);
            this.f12450f = null;
        }

        public boolean q() {
            boolean m11 = this.f12446b.m();
            if (this.f12448d == null) {
                return !m11;
            }
            if (!m11) {
                k();
                return true;
            }
            Requirements i11 = this.f12446b.i();
            if (!this.f12448d.b(i11).equals(i11)) {
                k();
                return false;
            }
            if (!o(i11)) {
                return true;
            }
            if (this.f12448d.a(i11, this.f12445a.getPackageName(), "androidx.media3.exoplayer.downloadService.action.RESTART")) {
                this.f12451g = i11;
                return true;
            }
            u.h("DownloadService", "Failed to schedule restart");
            k();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        private final int f12452a;

        /* renamed from: b, reason: collision with root package name */
        private final long f12453b;

        /* renamed from: c, reason: collision with root package name */
        private final Handler f12454c = new Handler(Looper.getMainLooper());

        /* renamed from: d, reason: collision with root package name */
        private boolean f12455d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f12456e;

        public c(int i11, long j11) {
            this.f12452a = i11;
            this.f12453b = j11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            DownloadManager downloadManager = ((b) androidx.media3.common.util.a.e(DownloadService.this.f12439e)).f12446b;
            Notification n11 = DownloadService.this.n(downloadManager.e(), downloadManager.h());
            if (this.f12456e) {
                ((NotificationManager) DownloadService.this.getSystemService("notification")).notify(this.f12452a, n11);
            } else {
                a1.j1(DownloadService.this, this.f12452a, n11, 1, "dataSync");
                this.f12456e = true;
            }
            if (this.f12455d) {
                this.f12454c.removeCallbacksAndMessages(null);
                this.f12454c.postDelayed(new Runnable() { // from class: androidx.media3.exoplayer.offline.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        DownloadService.c.this.f();
                    }
                }, this.f12453b);
            }
        }

        public void b() {
            if (this.f12456e) {
                f();
            }
        }

        public void c() {
            if (this.f12456e) {
                return;
            }
            f();
        }

        public void d() {
            this.f12455d = true;
            f();
        }

        public void e() {
            this.f12455d = false;
            this.f12454c.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DownloadService(int i11, long j11, String str, int i12, int i13) {
        if (i11 == 0) {
            this.f12435a = null;
            this.f12436b = null;
            this.f12437c = 0;
            this.f12438d = 0;
            return;
        }
        this.f12435a = new c(i11, j11);
        this.f12436b = str;
        this.f12437c = i12;
        this.f12438d = i13;
    }

    private static void A(Context context, Intent intent, boolean z10) {
        if (z10) {
            a1.r1(context, intent);
        } else {
            context.startService(intent);
        }
    }

    public static Intent i(Context context, Class cls, DownloadRequest downloadRequest, int i11, boolean z10) {
        return p(context, cls, "androidx.media3.exoplayer.downloadService.action.ADD_DOWNLOAD", z10).putExtra("download_request", downloadRequest).putExtra("stop_reason", i11);
    }

    public static Intent j(Context context, Class cls, DownloadRequest downloadRequest, boolean z10) {
        return i(context, cls, downloadRequest, 0, z10);
    }

    public static Intent k(Context context, Class cls, String str, boolean z10) {
        return p(context, cls, "androidx.media3.exoplayer.downloadService.action.REMOVE_DOWNLOAD", z10).putExtra("content_id", str);
    }

    public static Intent l(Context context, Class cls, String str, int i11, boolean z10) {
        return p(context, cls, "androidx.media3.exoplayer.downloadService.action.SET_STOP_REASON", z10).putExtra("content_id", str).putExtra("stop_reason", i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent o(Context context, Class cls, String str) {
        return new Intent(context, (Class<?>) cls).setAction(str);
    }

    private static Intent p(Context context, Class cls, String str, boolean z10) {
        return o(context, cls, str).putExtra(com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadService.KEY_FOREGROUND, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        return this.f12443i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean s(int i11) {
        return i11 == 2 || i11 == 5 || i11 == 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(androidx.media3.exoplayer.offline.c cVar) {
        if (this.f12435a != null) {
            if (s(cVar.f12496b)) {
                this.f12435a.d();
            } else {
                this.f12435a.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        c cVar = this.f12435a;
        if (cVar != null) {
            cVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(List list) {
        if (this.f12435a != null) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                if (s(((androidx.media3.exoplayer.offline.c) list.get(i11)).f12496b)) {
                    this.f12435a.d();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        c cVar = this.f12435a;
        if (cVar != null) {
            cVar.e();
        }
        if (((b) androidx.media3.common.util.a.e(this.f12439e)).q()) {
            if (a1.f10432a >= 28 || !this.f12442h) {
                this.f12443i |= stopSelfResult(this.f12440f);
            } else {
                stopSelf();
                this.f12443i = true;
            }
        }
    }

    public static void x(Context context, Class cls, DownloadRequest downloadRequest, boolean z10) {
        A(context, j(context, cls, downloadRequest, z10), z10);
    }

    public static void y(Context context, Class cls, String str, boolean z10) {
        A(context, k(context, cls, str, z10), z10);
    }

    public static void z(Context context, Class cls, String str, int i11, boolean z10) {
        A(context, l(context, cls, str, i11, z10), z10);
    }

    protected abstract DownloadManager m();

    protected abstract Notification n(List list, int i11);

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public void onCreate() {
        String str = this.f12436b;
        if (str != null) {
            h0.a(this, str, this.f12437c, this.f12438d, 2);
        }
        Class<?> cls = getClass();
        HashMap hashMap = f12434k;
        b bVar = (b) hashMap.get(cls);
        if (bVar == null) {
            boolean z10 = this.f12435a != null;
            f2.f q11 = (z10 && (a1.f10432a < 31)) ? q() : null;
            DownloadManager m11 = m();
            m11.x();
            bVar = new b(getApplicationContext(), m11, z10, q11, cls);
            hashMap.put(cls, bVar);
        }
        this.f12439e = bVar;
        bVar.j(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f12444j = true;
        ((b) androidx.media3.common.util.a.e(this.f12439e)).l(this);
        c cVar = this.f12435a;
        if (cVar != null) {
            cVar.e();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i11, int i12) {
        String str;
        String str2;
        c cVar;
        this.f12440f = i12;
        this.f12442h = false;
        if (intent != null) {
            str = intent.getAction();
            str2 = intent.getStringExtra("content_id");
            this.f12441g |= intent.getBooleanExtra(com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadService.KEY_FOREGROUND, false) || "androidx.media3.exoplayer.downloadService.action.RESTART".equals(str);
        } else {
            str = null;
            str2 = null;
        }
        if (str == null) {
            str = "androidx.media3.exoplayer.downloadService.action.INIT";
        }
        DownloadManager downloadManager = ((b) androidx.media3.common.util.a.e(this.f12439e)).f12446b;
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2068303304:
                if (str.equals("androidx.media3.exoplayer.downloadService.action.SET_STOP_REASON")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1192305801:
                if (str.equals("androidx.media3.exoplayer.downloadService.action.REMOVE_DOWNLOAD")) {
                    c11 = 1;
                    break;
                }
                break;
            case -659421309:
                if (str.equals("androidx.media3.exoplayer.downloadService.action.RESTART")) {
                    c11 = 2;
                    break;
                }
                break;
            case -238450692:
                if (str.equals("androidx.media3.exoplayer.downloadService.action.INIT")) {
                    c11 = 3;
                    break;
                }
                break;
            case 32678949:
                if (str.equals("androidx.media3.exoplayer.downloadService.action.RESUME_DOWNLOADS")) {
                    c11 = 4;
                    break;
                }
                break;
            case 464223742:
                if (str.equals("androidx.media3.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS")) {
                    c11 = 5;
                    break;
                }
                break;
            case 829812082:
                if (str.equals("androidx.media3.exoplayer.downloadService.action.ADD_DOWNLOAD")) {
                    c11 = 6;
                    break;
                }
                break;
            case 845668953:
                if (str.equals("androidx.media3.exoplayer.downloadService.action.SET_REQUIREMENTS")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1746253622:
                if (str.equals("androidx.media3.exoplayer.downloadService.action.PAUSE_DOWNLOADS")) {
                    c11 = '\b';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                if (!((Intent) androidx.media3.common.util.a.e(intent)).hasExtra("stop_reason")) {
                    u.c("DownloadService", "Ignored SET_STOP_REASON: Missing stop_reason extra");
                    break;
                } else {
                    downloadManager.A(str2, intent.getIntExtra("stop_reason", 0));
                    break;
                }
            case 1:
                if (str2 != null) {
                    downloadManager.v(str2);
                    break;
                } else {
                    u.c("DownloadService", "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                    break;
                }
            case 2:
            case 3:
                break;
            case 4:
                downloadManager.x();
                break;
            case 5:
                downloadManager.u();
                break;
            case 6:
                DownloadRequest downloadRequest = (DownloadRequest) ((Intent) androidx.media3.common.util.a.e(intent)).getParcelableExtra("download_request");
                if (downloadRequest != null) {
                    downloadManager.c(downloadRequest, intent.getIntExtra("stop_reason", 0));
                    break;
                } else {
                    u.c("DownloadService", "Ignored ADD_DOWNLOAD: Missing download_request extra");
                    break;
                }
            case 7:
                Requirements requirements = (Requirements) ((Intent) androidx.media3.common.util.a.e(intent)).getParcelableExtra("requirements");
                if (requirements != null) {
                    downloadManager.z(requirements);
                    break;
                } else {
                    u.c("DownloadService", "Ignored SET_REQUIREMENTS: Missing requirements extra");
                    break;
                }
            case '\b':
                downloadManager.t();
                break;
            default:
                u.c("DownloadService", "Ignored unrecognized action: " + str);
                break;
        }
        if (a1.f10432a >= 26 && this.f12441g && (cVar = this.f12435a) != null) {
            cVar.c();
        }
        this.f12443i = false;
        if (downloadManager.k()) {
            w();
        }
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.f12442h = true;
    }

    protected abstract f2.f q();
}
