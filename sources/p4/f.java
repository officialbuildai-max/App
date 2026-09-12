package p4;

import androidx.collection.z;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static final f f72422b = new f();

    /* renamed from: a, reason: collision with root package name */
    private final z f72423a = new z(20);

    f() {
    }

    public static f b() {
        return f72422b;
    }

    public com.airbnb.lottie.h a(String str) {
        if (str == null) {
            return null;
        }
        return (com.airbnb.lottie.h) this.f72423a.get(str);
    }

    public void c(String str, com.airbnb.lottie.h hVar) {
        if (str == null) {
            return;
        }
        this.f72423a.put(str, hVar);
    }
}
