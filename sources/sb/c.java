package sb;

import sb.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class c extends e.b {

    /* renamed from: a, reason: collision with root package name */
    private final int f75430a;

    /* renamed from: b, reason: collision with root package name */
    private final String f75431b;

    /* renamed from: c, reason: collision with root package name */
    private final int f75432c;

    /* renamed from: d, reason: collision with root package name */
    private final long f75433d;

    /* renamed from: e, reason: collision with root package name */
    private final long f75434e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f75435f;

    /* renamed from: g, reason: collision with root package name */
    private final int f75436g;

    /* renamed from: h, reason: collision with root package name */
    private final String f75437h;

    /* renamed from: i, reason: collision with root package name */
    private final String f75438i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i11, String str, int i12, long j11, long j12, boolean z10, int i13, String str2, String str3) {
        this.f75430a = i11;
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.f75431b = str;
        this.f75432c = i12;
        this.f75433d = j11;
        this.f75434e = j12;
        this.f75435f = z10;
        this.f75436g = i13;
        if (str2 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        this.f75437h = str2;
        if (str3 == null) {
            throw new NullPointerException("Null modelClass");
        }
        this.f75438i = str3;
    }

    @Override // sb.e.b
    public int a() {
        return this.f75430a;
    }

    @Override // sb.e.b
    public int b() {
        return this.f75432c;
    }

    @Override // sb.e.b
    public long d() {
        return this.f75434e;
    }

    @Override // sb.e.b
    public boolean e() {
        return this.f75435f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e.b)) {
            return false;
        }
        e.b bVar = (e.b) obj;
        return this.f75430a == bVar.a() && this.f75431b.equals(bVar.g()) && this.f75432c == bVar.b() && this.f75433d == bVar.j() && this.f75434e == bVar.d() && this.f75435f == bVar.e() && this.f75436g == bVar.i() && this.f75437h.equals(bVar.f()) && this.f75438i.equals(bVar.h());
    }

    @Override // sb.e.b
    public String f() {
        return this.f75437h;
    }

    @Override // sb.e.b
    public String g() {
        return this.f75431b;
    }

    @Override // sb.e.b
    public String h() {
        return this.f75438i;
    }

    public int hashCode() {
        int hashCode = (((((this.f75430a ^ 1000003) * 1000003) ^ this.f75431b.hashCode()) * 1000003) ^ this.f75432c) * 1000003;
        long j11 = this.f75433d;
        int i11 = (hashCode ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f75434e;
        return ((((((((i11 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003) ^ (this.f75435f ? 1231 : 1237)) * 1000003) ^ this.f75436g) * 1000003) ^ this.f75437h.hashCode()) * 1000003) ^ this.f75438i.hashCode();
    }

    @Override // sb.e.b
    public int i() {
        return this.f75436g;
    }

    @Override // sb.e.b
    public long j() {
        return this.f75433d;
    }

    public String toString() {
        return "DeviceData{arch=" + this.f75430a + ", model=" + this.f75431b + ", availableProcessors=" + this.f75432c + ", totalRam=" + this.f75433d + ", diskSpace=" + this.f75434e + ", isEmulator=" + this.f75435f + ", state=" + this.f75436g + ", manufacturer=" + this.f75437h + ", modelClass=" + this.f75438i + "}";
    }
}
