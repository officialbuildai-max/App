package jr;

import com.transsion.share.bean.ShareType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final ShareType f66377a;

    /* renamed from: b, reason: collision with root package name */
    private final int f66378b;

    /* renamed from: c, reason: collision with root package name */
    private final String f66379c;

    public a(ShareType shareType, int i11, String shareName) {
        Intrinsics.h(shareType, "shareType");
        Intrinsics.h(shareName, "shareName");
        this.f66377a = shareType;
        this.f66378b = i11;
        this.f66379c = shareName;
    }

    public final int a() {
        return this.f66378b;
    }

    public final String b() {
        return this.f66379c;
    }

    public final ShareType c() {
        return this.f66377a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f66377a == aVar.f66377a && this.f66378b == aVar.f66378b && Intrinsics.c(this.f66379c, aVar.f66379c);
    }

    public int hashCode() {
        return (((this.f66377a.hashCode() * 31) + this.f66378b) * 31) + this.f66379c.hashCode();
    }

    public String toString() {
        return "ShareData(shareType=" + this.f66377a + ", shareIconId=" + this.f66378b + ", shareName=" + this.f66379c + ")";
    }
}
