package com.apm.insight.runtime;

import androidx.annotation.NonNull;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.IOOMCallback;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final List<ICrashCallback> f19866a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<ICrashCallback> f19867b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final List<ICrashCallback> f19868c = new CopyOnWriteArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final List<ICrashCallback> f19869d = new CopyOnWriteArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final List<IOOMCallback> f19870e = new CopyOnWriteArrayList();

    /* renamed from: com.apm.insight.runtime.c$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f19871a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f19871a = iArr;
            try {
                iArr[CrashType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19871a[CrashType.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19871a[CrashType.JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19871a[CrashType.LAUNCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19871a[CrashType.NATIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @NonNull
    public final List<IOOMCallback> a() {
        return this.f19870e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ICrashCallback iCrashCallback, CrashType crashType) {
        int i11 = AnonymousClass1.f19871a[crashType.ordinal()];
        if (i11 == 1) {
            this.f19866a.add(iCrashCallback);
            this.f19867b.add(iCrashCallback);
            this.f19868c.add(iCrashCallback);
            this.f19869d.add(iCrashCallback);
            return;
        }
        if (i11 == 2) {
            this.f19869d.add(iCrashCallback);
            return;
        }
        if (i11 == 3) {
            this.f19867b.add(iCrashCallback);
        } else if (i11 == 4) {
            this.f19866a.add(iCrashCallback);
        } else {
            if (i11 != 5) {
                return;
            }
            this.f19868c.add(iCrashCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(IOOMCallback iOOMCallback) {
        this.f19870e.add(iOOMCallback);
    }

    @NonNull
    public final List<ICrashCallback> b() {
        return this.f19866a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(ICrashCallback iCrashCallback, CrashType crashType) {
        int i11 = AnonymousClass1.f19871a[crashType.ordinal()];
        if (i11 == 1) {
            this.f19866a.remove(iCrashCallback);
            this.f19867b.remove(iCrashCallback);
            this.f19868c.remove(iCrashCallback);
            this.f19869d.remove(iCrashCallback);
            return;
        }
        if (i11 == 2) {
            this.f19869d.remove(iCrashCallback);
            return;
        }
        if (i11 == 3) {
            this.f19867b.remove(iCrashCallback);
        } else if (i11 == 4) {
            this.f19866a.remove(iCrashCallback);
        } else {
            if (i11 != 5) {
                return;
            }
            this.f19868c.remove(iCrashCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(IOOMCallback iOOMCallback) {
        this.f19870e.remove(iOOMCallback);
    }

    @NonNull
    public final List<ICrashCallback> c() {
        return this.f19867b;
    }

    @NonNull
    public final List<ICrashCallback> d() {
        return this.f19868c;
    }

    @NonNull
    public final List<ICrashCallback> e() {
        return this.f19869d;
    }
}
