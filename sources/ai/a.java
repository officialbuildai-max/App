package ai;

import android.util.Log;
import com.tn.tranpay.logger.LogLevel;
import com.tn.tranpay.logger.LoggerPlugin;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    private static boolean f696c;

    /* renamed from: a, reason: collision with root package name */
    public static final a f694a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static LogLevel f695b = LogLevel.INFO;

    /* renamed from: d, reason: collision with root package name */
    private static final CopyOnWriteArrayList f697d = new CopyOnWriteArrayList();

    /* renamed from: ai.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public /* synthetic */ class C0009a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f698a;

        static {
            int[] iArr = new int[LogLevel.values().length];
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogLevel.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f698a = iArr;
        }
    }

    private a() {
    }

    public static /* synthetic */ void c(a aVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "TranPay";
        }
        aVar.b(str, str2);
    }

    public static /* synthetic */ void e(a aVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "TranPay";
        }
        aVar.d(str, str2);
    }

    public static /* synthetic */ void g(a aVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "TranPay";
        }
        aVar.f(str, str2);
    }

    private final void i(LogLevel logLevel, String str, String str2) {
        if (logLevel.ordinal() < f695b.ordinal()) {
            return;
        }
        if (f696c) {
            int i11 = C0009a.f698a[logLevel.ordinal()];
            if (i11 == 3) {
                Log.w(str, str2);
            } else if (i11 == 4) {
                Log.e(str, str2);
            }
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            for (LoggerPlugin loggerPlugin : f697d) {
                if (loggerPlugin != null) {
                    loggerPlugin.log(logLevel, str, str2);
                }
            }
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public static /* synthetic */ void k(a aVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "TranPay";
        }
        aVar.j(str, str2);
    }

    public final void a(LoggerPlugin loggerPlugin) {
        if (loggerPlugin != null) {
            f697d.add(loggerPlugin);
        } else {
            Log.e("TranPay", "Attempt to add null plugin ignored");
        }
    }

    public final void b(String message, String tag) {
        Intrinsics.h(message, "message");
        Intrinsics.h(tag, "tag");
        i(LogLevel.DEBUG, tag, message);
    }

    public final void d(String message, String tag) {
        Intrinsics.h(message, "message");
        Intrinsics.h(tag, "tag");
        i(LogLevel.ERROR, tag, message);
    }

    public final void f(String message, String tag) {
        Intrinsics.h(message, "message");
        Intrinsics.h(tag, "tag");
        i(LogLevel.INFO, tag, message);
    }

    public final void h(LogLevel level, boolean z10) {
        Intrinsics.h(level, "level");
        f695b = level;
        f696c = z10;
    }

    public final void j(String message, String tag) {
        Intrinsics.h(message, "message");
        Intrinsics.h(tag, "tag");
        i(LogLevel.WARNING, tag, message);
    }
}
