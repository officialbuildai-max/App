package com.transsnet.flow.event;

import android.app.Application;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f60377a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static Application f60378b;

    /* renamed from: c, reason: collision with root package name */
    private static c f60379c;

    private b() {
    }

    public final Application a() {
        Application application = f60378b;
        if (application != null) {
            return application;
        }
        Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
        return null;
    }

    public final c b() {
        return f60379c;
    }

    public final void c(Application application) {
        Intrinsics.h(application, "application");
        f60377a.d(application);
        f60379c = new d();
    }

    public final void d(Application application) {
        Intrinsics.h(application, "<set-?>");
        f60378b = application;
    }
}
