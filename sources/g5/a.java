package g5;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class a {

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Context f63459a;

        private b(Context context) {
            this.f63459a = context;
        }

        public a a() {
            Context context = this.f63459a;
            if (context != null) {
                return new g5.b(context);
            }
            throw new IllegalArgumentException("Please provide a valid Context.");
        }
    }

    public static b c(Context context) {
        return new b(context);
    }

    public abstract void a();

    public abstract d b();

    public abstract void d(c cVar);
}
