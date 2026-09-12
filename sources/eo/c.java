package eo;

import android.app.NotificationManager;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f62046a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f62047b;

    /* renamed from: c, reason: collision with root package name */
    private static int f62048c;

    /* renamed from: d, reason: collision with root package name */
    private static int f62049d;

    /* renamed from: e, reason: collision with root package name */
    private static int f62050e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile int f62051f;

    /* renamed from: g, reason: collision with root package name */
    private static final Lazy f62052g;

    /* renamed from: h, reason: collision with root package name */
    private static final Lazy f62053h;

    /* loaded from: classes6.dex */
    public static final class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            super.onChange(z10, uri);
            c.f62046a.d();
        }
    }

    static {
        c cVar = new c();
        f62046a = cVar;
        f62047b = true;
        f62048c = 200;
        f62049d = 100;
        f62050e = 15;
        f62051f = 100;
        f62052g = LazyKt.b(new Function0() { // from class: eo.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                AudioManager i11;
                i11 = c.i();
                return i11;
            }
        });
        f62053h = LazyKt.b(new Function0() { // from class: eo.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                NotificationManager j11;
                j11 = c.j();
                return j11;
            }
        });
        Utils.a().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, new a(new Handler()));
        try {
            Result.Companion companion = Result.INSTANCE;
            f62050e = cVar.f().getStreamMaxVolume(3);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        f62046a.h();
    }

    private c() {
    }

    private final AudioManager f() {
        return (AudioManager) f62052g.getValue();
    }

    private final NotificationManager g() {
        return (NotificationManager) f62053h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AudioManager i() {
        Object systemService = Utils.a().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        return (AudioManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationManager j() {
        Object systemService = Utils.a().getSystemService("notification");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    public final void c(int i11, float f11) {
        float f12 = (i11 + f11) / 100.0f;
        int i12 = f62050e;
        int i13 = (int) (f12 * i12);
        if (i13 <= 0) {
            i12 = 0;
        } else if (i13 < i12) {
            i12 = i13;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("preVolume:");
        sb2.append(i11);
        sb2.append(", volume:");
        sb2.append(i12);
        try {
            if (f().isVolumeFixed() && !f62047b) {
                return;
            }
            f().setStreamVolume(3, i12, 0);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void d() {
        try {
            Result.Companion companion = Result.INSTANCE;
            int streamVolume = f().getStreamVolume(3);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("checkCurVolume volume:");
            sb2.append(streamVolume);
            if (streamVolume < f62050e) {
                int i11 = f62051f;
                int i12 = f62050e;
                int i13 = f62049d;
                if ((i11 * i12) / i13 != streamVolume) {
                    f62051f = (streamVolume * i13) / i12;
                }
            }
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public final int e() {
        return f62051f;
    }

    public final void h() {
        try {
            Result.Companion companion = Result.INSTANCE;
            f62047b = g().isNotificationPolicyAccessGranted();
            int streamVolume = f().getStreamVolume(3);
            f62051f = (f62049d * streamVolume) / f62050e;
            Result.m1185constructorimpl(Integer.valueOf(Log.d("AppVolumeManager", "curVolume:" + f62051f + ", volume:" + streamVolume + " system:" + f62050e)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public final int k(int i11) {
        int f11 = RangesKt.f(RangesKt.i(f62051f + i11, f62048c), 0);
        if (f11 <= f62049d) {
            c(f62051f, i11);
        }
        f62051f = f11;
        return f11;
    }
}
