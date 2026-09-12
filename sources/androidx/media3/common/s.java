package androidx.media3.common;

import androidx.media3.common.util.a1;
import java.util.Objects;

/* loaded from: classes2.dex */
public class s {

    /* renamed from: c, reason: collision with root package name */
    private static final String f10281c = a1.C0(0);

    /* renamed from: d, reason: collision with root package name */
    private static final String f10282d = a1.C0(1);

    /* renamed from: a, reason: collision with root package name */
    public final String f10283a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10284b;

    public s(String str, String str2) {
        this.f10283a = a1.U0(str);
        this.f10284b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        return Objects.equals(this.f10283a, sVar.f10283a) && Objects.equals(this.f10284b, sVar.f10284b);
    }

    public int hashCode() {
        int hashCode = this.f10284b.hashCode() * 31;
        String str = this.f10283a;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}
