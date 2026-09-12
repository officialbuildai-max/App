package y9;

import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class d implements com.google.android.exoplayer2.offline.c {

    /* renamed from: a, reason: collision with root package name */
    public final String f79073a;

    /* renamed from: b, reason: collision with root package name */
    public final List f79074b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f79075c;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(String str, List list, boolean z10) {
        this.f79073a = str;
        this.f79074b = Collections.unmodifiableList(list);
        this.f79075c = z10;
    }
}
