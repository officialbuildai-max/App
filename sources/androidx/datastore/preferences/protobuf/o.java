package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.Map;
import okhttp3.internal.http2.Settings;

/* loaded from: classes.dex */
public class o {

    /* renamed from: b, reason: collision with root package name */
    private static volatile o f8956b;

    /* renamed from: c, reason: collision with root package name */
    static final o f8957c = new o(true);

    /* renamed from: a, reason: collision with root package name */
    private final Map f8958a = Collections.emptyMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Object f8959a;

        /* renamed from: b, reason: collision with root package name */
        private final int f8960b;

        a(Object obj, int i11) {
            this.f8959a = obj;
            this.f8960b = i11;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f8959a == aVar.f8959a && this.f8960b == aVar.f8960b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f8959a) * Settings.DEFAULT_INITIAL_WINDOW_SIZE) + this.f8960b;
        }
    }

    o(boolean z10) {
    }

    public static o b() {
        if (x0.f9013d) {
            return f8957c;
        }
        o oVar = f8956b;
        if (oVar == null) {
            synchronized (o.class) {
                try {
                    oVar = f8956b;
                    if (oVar == null) {
                        oVar = n.a();
                        f8956b = oVar;
                    }
                } finally {
                }
            }
        }
        return oVar;
    }

    public GeneratedMessageLite.d a(n0 n0Var, int i11) {
        android.support.v4.media.session.c.a(this.f8958a.get(new a(n0Var, i11)));
        return null;
    }
}
