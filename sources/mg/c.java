package mg;

import android.app.Application;
import android.os.Environment;
import android.util.Log;
import com.elvishew.xlog.printer.file.FilePrinter;
import com.tn.lib.logger.xlog.LogType;
import f8.d;
import java.io.File;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mg.c;
import q7.a;
import q7.e;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    private static Application f69684b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f69685c;

    /* renamed from: a, reason: collision with root package name */
    public static final a f69683a = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static LogType f69686d = LogType.TYPE_LOGCAT;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: mg.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public /* synthetic */ class C0866a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f69687a;

            static {
                int[] iArr = new int[LogType.values().length];
                try {
                    iArr[LogType.TYPE_LOGCAT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LogType.TYPE_XLOG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f69687a = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void g(a aVar, Application application, LogType logType, boolean z10, String str, long j11, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                str = "";
            }
            String str2 = str;
            if ((i11 & 16) != 0) {
                j11 = 0;
            }
            aVar.f(application, logType, z10, str2, j11);
        }

        private final void h(String str, long j11, boolean z10) {
            i(str, j11, z10);
        }

        private final void i(String str, long j11, boolean z10) {
            String c11 = c(b());
            if (str.length() <= 0) {
                str = c11;
            }
            q7.a r11 = new a.C0920a().B(Integer.MIN_VALUE).E("X-LOG").A(new u7.a()).H(new x7.a()).G(new w7.a()).F(new ng.b()).D(new y7.a()).q(new t7.b()).p(new a8.a() { // from class: mg.b
                @Override // a8.a
                public final q7.b a(q7.b bVar) {
                    q7.b j12;
                    j12 = c.a.j(bVar);
                    return j12;
                }
            }).r();
            e8.a aVar = new e8.a();
            FilePrinter b11 = str.length() > 0 ? new FilePrinter.b(str).d(new ng.a()).a(new d()).c(new ng.c()).f(new r7.a()).b() : null;
            if (z10) {
                if (b11 == null) {
                    e.f(r11, aVar);
                    return;
                } else {
                    e.f(r11, aVar, b11);
                    return;
                }
            }
            if (b11 == null) {
                e.e(r11);
            } else {
                e.f(r11, b11);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final q7.b j(q7.b bVar) {
            return bVar;
        }

        private final boolean k() {
            return Intrinsics.c(Environment.getExternalStorageState(), "mounted");
        }

        public final Application b() {
            return c.f69684b;
        }

        public final String c(Application application) {
            if (application == null) {
                throw new RuntimeException("日志库传入Application为空");
            }
            if (k()) {
                StringBuilder sb2 = new StringBuilder();
                File externalFilesDir = application.getExternalFilesDir(null);
                sb2.append(externalFilesDir != null ? externalFilesDir.getParent() : null);
                sb2.append(File.separator);
                sb2.append("log");
                return sb2.toString();
            }
            StringBuilder sb3 = new StringBuilder();
            File filesDir = application.getFilesDir();
            sb3.append(filesDir != null ? filesDir.getParent() : null);
            sb3.append(File.separator);
            sb3.append("log");
            return sb3.toString();
        }

        public final LogType d() {
            return c.f69686d;
        }

        public final boolean e() {
            return c.f69685c;
        }

        public final void f(Application application, LogType logType, boolean z10, String loggerPath, long j11) {
            Intrinsics.h(application, "application");
            Intrinsics.h(logType, "logType");
            Intrinsics.h(loggerPath, "loggerPath");
            a aVar = c.f69683a;
            if (aVar.b() != null) {
                return;
            }
            c.f69686d = logType;
            c.f69685c = z10 || Log.isLoggable("oneroom_logger", 3);
            aVar.l(application);
            int i11 = C0866a.f69687a[logType.ordinal()];
            if (i11 == 1) {
                h(loggerPath, j11, z10);
            } else {
                if (i11 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                i(loggerPath, j11, z10);
            }
        }

        public final void l(Application application) {
            c.f69684b = application;
        }
    }
}
