package v3;

import android.os.Build;
import android.os.ext.SdkExtensions;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f77140a = new a();

    /* renamed from: v3.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class C0972a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0972a f77141a = new C0972a();

        private C0972a() {
        }

        public final int a() {
            int extensionVersion;
            extensionVersion = SdkExtensions.getExtensionVersion(1000000);
            return extensionVersion;
        }
    }

    private a() {
    }

    public final int a() {
        if (Build.VERSION.SDK_INT >= 30) {
            return C0972a.f77141a.a();
        }
        return 0;
    }
}
