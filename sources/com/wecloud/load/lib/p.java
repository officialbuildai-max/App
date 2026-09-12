package com.wecloud.load.lib;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f60997a = new p();

    /* renamed from: b, reason: collision with root package name */
    private static volatile WeakReference f60998b;

    private p() {
    }

    public final boolean a() {
        WeakReference weakReference = f60998b;
        return (weakReference != null ? (SoLoadService) weakReference.get() : null) != null;
    }

    public final void b(SoLoadService service) {
        Intrinsics.h(service, "service");
        f60998b = new WeakReference(service);
    }

    public final void c() {
        SoLoadService soLoadService;
        WeakReference weakReference = f60998b;
        if (weakReference == null || (soLoadService = (SoLoadService) weakReference.get()) == null) {
            return;
        }
        soLoadService.B();
    }

    public final void d() {
        f60998b = null;
    }
}
