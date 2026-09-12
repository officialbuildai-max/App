package androidx.media3.exoplayer.offline;

import android.net.Uri;
import androidx.media3.exoplayer.upstream.q;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes2.dex */
public final class r implements q.a {

    /* renamed from: a, reason: collision with root package name */
    private final q.a f12511a;

    /* renamed from: b, reason: collision with root package name */
    private final List f12512b;

    public r(q.a aVar, List list) {
        this.f12511a = aVar;
        this.f12512b = list;
    }

    @Override // androidx.media3.exoplayer.upstream.q.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public q parse(Uri uri, InputStream inputStream) {
        q qVar = (q) this.f12511a.parse(uri, inputStream);
        List list = this.f12512b;
        return (list == null || list.isEmpty()) ? qVar : (q) qVar.copy(this.f12512b);
    }
}
