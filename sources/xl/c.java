package xl;

import android.content.Context;

/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private volatile h f78441a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f78442b;

    public c(Context context) {
        this.f78442b = context;
    }

    public h a(long j11, long j12) {
        if (this.f78441a == null) {
            synchronized (this) {
                try {
                    if (this.f78441a == null) {
                        this.f78441a = new g(this.f78442b, j11, j12).a();
                    }
                } finally {
                }
            }
        }
        return this.f78441a;
    }
}
