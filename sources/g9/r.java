package g9;

import android.net.Uri;
import java.util.Map;

/* loaded from: classes4.dex */
public interface r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f63577a = new r() { // from class: g9.p
        @Override // g9.r
        public /* synthetic */ l[] c(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // g9.r
        public final l[] createExtractors() {
            return q.b();
        }
    };

    l[] c(Uri uri, Map map);

    l[] createExtractors();
}
