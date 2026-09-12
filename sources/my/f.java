package my;

import android.text.format.Formatter;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.n;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final String f70163a;

    /* renamed from: b, reason: collision with root package name */
    private final String f70164b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f70165c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f70166d;

    /* renamed from: e, reason: collision with root package name */
    private final long f70167e;

    /* renamed from: f, reason: collision with root package name */
    private final long f70168f;

    public f(String path, String state, boolean z10, boolean z11) {
        long j11;
        Intrinsics.h(path, "path");
        Intrinsics.h(state, "state");
        this.f70163a = path;
        this.f70164b = state;
        this.f70165c = z10;
        this.f70166d = z11;
        long j12 = 0;
        try {
            j11 = n.k(path);
        } catch (Throwable unused) {
            j11 = 0;
        }
        this.f70167e = j11;
        try {
            j12 = n.j(path);
        } catch (Throwable unused2) {
        }
        this.f70168f = j12;
    }

    public final long a() {
        return this.f70168f;
    }

    public final String b() {
        return this.f70163a;
    }

    public final boolean c() {
        return this.f70165c;
    }

    public String toString() {
        return "SDCardInfo {path = " + this.f70163a + ", state = " + this.f70164b + ", isRemovable = " + this.f70165c + ", isEmulated = " + this.f70166d + ", totalSize = " + Formatter.formatFileSize(Utils.a(), this.f70167e) + ", availableSize = " + Formatter.formatFileSize(Utils.a(), this.f70168f) + "}";
    }
}
