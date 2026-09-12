package androidx.media3.common.util;

import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    private String[] f10522a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f10523b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10524c;

    public q(String... strArr) {
        this.f10522a = strArr;
    }

    public synchronized boolean a() {
        if (this.f10523b) {
            return this.f10524c;
        }
        this.f10523b = true;
        try {
            for (String str : this.f10522a) {
                b(str);
            }
            this.f10524c = true;
        } catch (UnsatisfiedLinkError unused) {
            u.h("LibraryLoader", "Failed to load " + Arrays.toString(this.f10522a));
        }
        return this.f10524c;
    }

    protected abstract void b(String str);
}
