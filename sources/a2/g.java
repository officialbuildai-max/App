package a2;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f156a;

    /* renamed from: b, reason: collision with root package name */
    public final long f157b;

    /* renamed from: c, reason: collision with root package name */
    public final List f158c;

    /* renamed from: d, reason: collision with root package name */
    public final List f159d;

    /* renamed from: e, reason: collision with root package name */
    public final e f160e;

    public g(String str, long j11, List list, List list2) {
        this(str, j11, list, list2, null);
    }

    public g(String str, long j11, List list, List list2, e eVar) {
        this.f156a = str;
        this.f157b = j11;
        this.f158c = Collections.unmodifiableList(list);
        this.f159d = Collections.unmodifiableList(list2);
        this.f160e = eVar;
    }

    public int a(int i11) {
        int size = this.f158c.size();
        for (int i12 = 0; i12 < size; i12++) {
            if (((a) this.f158c.get(i12)).f111b == i11) {
                return i12;
            }
        }
        return -1;
    }
}
