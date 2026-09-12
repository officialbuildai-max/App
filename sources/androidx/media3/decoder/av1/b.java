package androidx.media3.decoder.av1;

import androidx.media3.common.u;
import androidx.media3.common.util.q;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final q f11025a;

    /* loaded from: classes2.dex */
    class a extends q {
        a(String... strArr) {
            super(strArr);
        }

        @Override // androidx.media3.common.util.q
        protected void b(String str) {
            System.loadLibrary(str);
        }
    }

    static {
        u.a("media3.decoder.av1");
        f11025a = new a("gav1JNI");
    }

    public static boolean a() {
        return f11025a.a();
    }
}
