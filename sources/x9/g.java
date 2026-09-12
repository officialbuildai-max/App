package x9;

import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f78219a;

    /* renamed from: b, reason: collision with root package name */
    public final long f78220b;

    /* renamed from: c, reason: collision with root package name */
    public final List f78221c;

    /* renamed from: d, reason: collision with root package name */
    public final List f78222d;

    /* renamed from: e, reason: collision with root package name */
    public final e f78223e;

    public g(String str, long j11, List list, List list2) {
        this(str, j11, list, list2, null);
    }

    public g(String str, long j11, List list, List list2, e eVar) {
        this.f78219a = str;
        this.f78220b = j11;
        this.f78221c = Collections.unmodifiableList(list);
        this.f78222d = Collections.unmodifiableList(list2);
        this.f78223e = eVar;
    }

    public int a(int i11) {
        int size = this.f78221c.size();
        for (int i12 = 0; i12 < size; i12++) {
            if (((a) this.f78221c.get(i12)).f78175b == i11) {
                return i12;
            }
        }
        return -1;
    }
}
