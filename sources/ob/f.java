package ob;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final Context f71073a;

    /* renamed from: b, reason: collision with root package name */
    private b f71074b = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f71075a;

        /* renamed from: b, reason: collision with root package name */
        private final String f71076b;

        private b() {
            int p11 = CommonUtils.p(f.this.f71073a, "com.google.firebase.crashlytics.unity_version", "string");
            if (p11 == 0) {
                if (!f.this.c("flutter_assets/NOTICES.Z")) {
                    this.f71075a = null;
                    this.f71076b = null;
                    return;
                } else {
                    this.f71075a = "Flutter";
                    this.f71076b = null;
                    g.f().i("Development platform is: Flutter");
                    return;
                }
            }
            this.f71075a = "Unity";
            String string = f.this.f71073a.getResources().getString(p11);
            this.f71076b = string;
            g.f().i("Unity Editor version is: " + string);
        }
    }

    public f(Context context) {
        this.f71073a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        if (this.f71073a.getAssets() == null) {
            return false;
        }
        try {
            InputStream open = this.f71073a.getAssets().open(str);
            if (open == null) {
                return true;
            }
            open.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private b f() {
        if (this.f71074b == null) {
            this.f71074b = new b();
        }
        return this.f71074b;
    }

    public static boolean g(Context context) {
        return CommonUtils.p(context, "com.google.firebase.crashlytics.unity_version", "string") != 0;
    }

    public String d() {
        return f().f71075a;
    }

    public String e() {
        return f().f71076b;
    }
}
