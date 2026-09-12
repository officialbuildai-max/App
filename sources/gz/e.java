package gz;

import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* loaded from: classes7.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final a f64163b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final OkHttpClient f64164a;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f64164a = builder.connectTimeout(30L, timeUnit).readTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).build();
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0215, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.c(r11, r22) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x024d, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.c(r11, r22) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0217, code lost:
    
        r11.delete();
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0206 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x023e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x020b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(java.lang.String r21, java.io.File r22) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: gz.e.a(java.lang.String, java.io.File):boolean");
    }

    public final boolean b(String downloadUrl, File targetFile) {
        Intrinsics.h(downloadUrl, "downloadUrl");
        Intrinsics.h(targetFile, "targetFile");
        return a(downloadUrl, targetFile);
    }
}
