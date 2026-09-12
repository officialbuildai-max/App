package f8;

import java.io.File;

/* loaded from: classes4.dex */
public class c implements b {

    /* renamed from: a, reason: collision with root package name */
    private long f62484a;

    public c(long j11) {
        this.f62484a = j11;
    }

    @Override // f8.b
    public boolean b(File file) {
        return file.length() > this.f62484a;
    }
}
