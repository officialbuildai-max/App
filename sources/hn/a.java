package hn;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f64661a;

    /* renamed from: b, reason: collision with root package name */
    private int f64662b;

    /* renamed from: c, reason: collision with root package name */
    private List f64663c;

    public a(int i11, int i12) {
        this.f64661a = i11;
        this.f64662b = i12;
    }

    public /* synthetic */ a(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i13 & 2) != 0 ? 0 : i12);
    }

    public final int a() {
        return this.f64662b;
    }

    public final List b() {
        return this.f64663c;
    }

    public final int c() {
        return this.f64661a;
    }

    public final boolean d() {
        return this.f64661a > this.f64662b;
    }

    public final void e(int i11) {
        this.f64662b = i11;
    }

    public final void f(List list) {
        this.f64663c = list;
    }
}
