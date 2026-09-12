package c2;

import androidx.media3.exoplayer.offline.q;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class d implements q {

    /* renamed from: a, reason: collision with root package name */
    public final String f17066a;

    /* renamed from: b, reason: collision with root package name */
    public final List f17067b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f17068c;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(String str, List list, boolean z10) {
        this.f17066a = str;
        this.f17067b = Collections.unmodifiableList(list);
        this.f17068c = z10;
    }
}
