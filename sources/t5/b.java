package t5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.sP.Sj.Ym;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static Context f76187a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f76188b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f76189c = false;

    /* renamed from: d, reason: collision with root package name */
    private static Ym f76190d = null;

    /* renamed from: e, reason: collision with root package name */
    private static int f76191e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f76192f;

    public static Ym a() {
        if (f76190d == null) {
            Ym.Sj sj2 = new Ym.Sj("v_config");
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            f76190d = sj2.Sj(10000L, timeUnit).sP(10000L, timeUnit).TKC(10000L, timeUnit).Sj();
        }
        return f76190d;
    }

    public static boolean b() {
        return f76192f;
    }

    public static Context c() {
        return f76187a;
    }

    public static void d(int i11) {
        f76191e = i11;
    }

    public static void e(Context context, String str) {
        f76187a = context;
        f76188b = str;
    }

    public static void f(Ym ym2) {
        f76190d = ym2;
    }

    public static void g(boolean z10) {
        f76189c = z10;
    }

    public static boolean h() {
        return f76189c;
    }

    public static String i() {
        if (TextUtils.isEmpty(f76188b)) {
            try {
                File file = new File(c().getFilesDir(), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                f76188b = file.getAbsolutePath();
            } catch (Throwable unused) {
            }
        }
        return f76188b;
    }

    public static int j() {
        return f76191e;
    }
}
