package my;

import androidx.collection.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class b implements n6.a {

    /* renamed from: h, reason: collision with root package name */
    public static final a f70148h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f70149a;

    /* renamed from: b, reason: collision with root package name */
    private final String f70150b;

    /* renamed from: c, reason: collision with root package name */
    private final String f70151c;

    /* renamed from: d, reason: collision with root package name */
    private final int f70152d;

    /* renamed from: e, reason: collision with root package name */
    private final long f70153e;

    /* renamed from: f, reason: collision with root package name */
    private final int f70154f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f70155g;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(String downloadPath, String downloadShowPath, String pathName, int i11, long j11, int i12) {
        Intrinsics.h(downloadPath, "downloadPath");
        Intrinsics.h(downloadShowPath, "downloadShowPath");
        Intrinsics.h(pathName, "pathName");
        this.f70149a = downloadPath;
        this.f70150b = downloadShowPath;
        this.f70151c = pathName;
        this.f70152d = i11;
        this.f70153e = j11;
        this.f70154f = i12;
    }

    public final long a() {
        return this.f70153e;
    }

    public final String b() {
        return this.f70149a;
    }

    public final String c() {
        return this.f70150b;
    }

    public final String d() {
        return this.f70151c;
    }

    public final int e() {
        return this.f70152d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.f70149a, bVar.f70149a) && Intrinsics.c(this.f70150b, bVar.f70150b) && Intrinsics.c(this.f70151c, bVar.f70151c) && this.f70152d == bVar.f70152d && this.f70153e == bVar.f70153e && this.f70154f == bVar.f70154f;
    }

    public final boolean f() {
        return this.f70155g;
    }

    public final void g(boolean z10) {
        this.f70155g = z10;
    }

    @Override // n6.a
    public int getItemType() {
        return this.f70154f;
    }

    public int hashCode() {
        return (((((((((this.f70149a.hashCode() * 31) + this.f70150b.hashCode()) * 31) + this.f70151c.hashCode()) * 31) + this.f70152d) * 31) + s.a(this.f70153e)) * 31) + this.f70154f;
    }

    public String toString() {
        return "DownloadSDCardPathInfo(downloadPath=" + this.f70149a + ", downloadShowPath=" + this.f70150b + ", pathName=" + this.f70151c + ", pathType=" + this.f70152d + ", availableSize=" + this.f70153e + ", itemType=" + this.f70154f + ")";
    }
}
