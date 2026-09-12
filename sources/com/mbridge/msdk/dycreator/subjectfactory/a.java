package com.mbridge.msdk.dycreator.subjectfactory;

import com.mbridge.msdk.dycreator.viewobserver.c;
import com.mbridge.msdk.dycreator.viewobserver.d;
import com.mbridge.msdk.dycreator.viewobserver.f;
import com.mbridge.msdk.dycreator.viewobserver.h;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f34941a;

    /* renamed from: com.mbridge.msdk.dycreator.subjectfactory.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class C0478a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34942a;

        static {
            int[] iArr = new int[b.values().length];
            f34942a = iArr;
            try {
                iArr[b.VIEW_OBSERVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34942a[b.CLICK_OBSERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34942a[b.EFFECT_OBSERVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34942a[b.REPORT_OBSERVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum b {
        VIEW_OBSERVER,
        CLICK_OBSERVER,
        EFFECT_OBSERVER,
        REPORT_OBSERVER
    }

    private a() {
    }

    public static a a() {
        if (f34941a == null) {
            synchronized (a.class) {
                try {
                    if (f34941a == null) {
                        f34941a = new a();
                    }
                } finally {
                }
            }
        }
        return f34941a;
    }

    public <T extends com.mbridge.msdk.dycreator.viewobserver.a> T a(b bVar) {
        int i11 = C0478a.f34942a[bVar.ordinal()];
        if (i11 == 1) {
            return new d();
        }
        if (i11 == 2) {
            return new c();
        }
        if (i11 == 3) {
            return new f();
        }
        if (i11 != 4) {
            return null;
        }
        return new h();
    }
}
