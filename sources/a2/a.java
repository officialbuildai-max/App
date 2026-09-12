package a2;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f110a;

    /* renamed from: b, reason: collision with root package name */
    public final int f111b;

    /* renamed from: c, reason: collision with root package name */
    public final List f112c;

    /* renamed from: d, reason: collision with root package name */
    public final List f113d;

    /* renamed from: e, reason: collision with root package name */
    public final List f114e;

    /* renamed from: f, reason: collision with root package name */
    public final List f115f;

    public a(long j11, int i11, List list, List list2, List list3, List list4) {
        this.f110a = j11;
        this.f111b = i11;
        this.f112c = Collections.unmodifiableList(list);
        this.f113d = Collections.unmodifiableList(list2);
        this.f114e = Collections.unmodifiableList(list3);
        this.f115f = Collections.unmodifiableList(list4);
    }
}
