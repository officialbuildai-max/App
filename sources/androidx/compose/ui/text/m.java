package androidx.compose.ui.text;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final l f6365a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6366b;

    /* renamed from: c, reason: collision with root package name */
    private final int f6367c;

    /* renamed from: d, reason: collision with root package name */
    private int f6368d;

    /* renamed from: e, reason: collision with root package name */
    private int f6369e;

    /* renamed from: f, reason: collision with root package name */
    private float f6370f;

    /* renamed from: g, reason: collision with root package name */
    private float f6371g;

    public m(l lVar, int i11, int i12, int i13, int i14, float f11, float f12) {
        this.f6365a = lVar;
        this.f6366b = i11;
        this.f6367c = i12;
        this.f6368d = i13;
        this.f6369e = i14;
        this.f6370f = f11;
        this.f6371g = f12;
    }

    public final float a() {
        return this.f6371g;
    }

    public final int b() {
        return this.f6367c;
    }

    public final int c() {
        return this.f6369e;
    }

    public final int d() {
        return this.f6367c - this.f6366b;
    }

    public final l e() {
        return this.f6365a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return Intrinsics.c(this.f6365a, mVar.f6365a) && this.f6366b == mVar.f6366b && this.f6367c == mVar.f6367c && this.f6368d == mVar.f6368d && this.f6369e == mVar.f6369e && Float.compare(this.f6370f, mVar.f6370f) == 0 && Float.compare(this.f6371g, mVar.f6371g) == 0;
    }

    public final int f() {
        return this.f6366b;
    }

    public final int g() {
        return this.f6368d;
    }

    public final float h() {
        return this.f6370f;
    }

    public int hashCode() {
        return (((((((((((this.f6365a.hashCode() * 31) + this.f6366b) * 31) + this.f6367c) * 31) + this.f6368d) * 31) + this.f6369e) * 31) + Float.floatToIntBits(this.f6370f)) * 31) + Float.floatToIntBits(this.f6371g);
    }

    public final y.i i(y.i iVar) {
        return iVar.q(y.h.a(0.0f, this.f6370f));
    }

    public final int j(int i11) {
        return i11 + this.f6366b;
    }

    public final int k(int i11) {
        return i11 + this.f6368d;
    }

    public final float l(float f11) {
        return f11 + this.f6370f;
    }

    public final int m(int i11) {
        return RangesKt.m(i11, this.f6366b, this.f6367c) - this.f6366b;
    }

    public final int n(int i11) {
        return i11 - this.f6368d;
    }

    public final float o(float f11) {
        return f11 - this.f6370f;
    }

    public String toString() {
        return "ParagraphInfo(paragraph=" + this.f6365a + ", startIndex=" + this.f6366b + ", endIndex=" + this.f6367c + ", startLineIndex=" + this.f6368d + ", endLineIndex=" + this.f6369e + ", top=" + this.f6370f + ", bottom=" + this.f6371g + ')';
    }
}
