package vw;

import androidx.compose.foundation.e;
import com.transsion.usercenter.setting.bean.UserSettingType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f77589a;

    /* renamed from: b, reason: collision with root package name */
    private final UserSettingType f77590b;

    /* renamed from: c, reason: collision with root package name */
    private String f77591c;

    /* renamed from: d, reason: collision with root package name */
    private Integer f77592d;

    /* renamed from: e, reason: collision with root package name */
    private final int f77593e;

    /* renamed from: f, reason: collision with root package name */
    private String f77594f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f77595g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f77596h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f77597i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f77598j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f77599k;

    public b(int i11, UserSettingType userSettingType, String str, Integer num, int i12, String str2, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f77589a = i11;
        this.f77590b = userSettingType;
        this.f77591c = str;
        this.f77592d = num;
        this.f77593e = i12;
        this.f77594f = str2;
        this.f77595g = z10;
        this.f77596h = z11;
        this.f77597i = z12;
        this.f77598j = z13;
    }

    public /* synthetic */ b(int i11, UserSettingType userSettingType, String str, Integer num, int i12, String str2, boolean z10, boolean z11, boolean z12, boolean z13, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i13 & 2) != 0 ? null : userSettingType, (i13 & 4) != 0 ? null : str, (i13 & 8) != 0 ? null : num, (i13 & 16) != 0 ? 1 : i12, (i13 & 32) == 0 ? str2 : null, (i13 & 64) != 0 ? false : z10, (i13 & 128) != 0 ? false : z11, (i13 & 256) == 0 ? z12 : true, (i13 & 512) == 0 ? z13 : false);
    }

    public final Integer a() {
        return this.f77592d;
    }

    public final String b() {
        return this.f77591c;
    }

    public final boolean c() {
        return this.f77599k;
    }

    public final boolean d() {
        return this.f77597i;
    }

    public final boolean e() {
        return this.f77598j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f77589a == bVar.f77589a && this.f77590b == bVar.f77590b && Intrinsics.c(this.f77591c, bVar.f77591c) && Intrinsics.c(this.f77592d, bVar.f77592d) && this.f77593e == bVar.f77593e && Intrinsics.c(this.f77594f, bVar.f77594f) && this.f77595g == bVar.f77595g && this.f77596h == bVar.f77596h && this.f77597i == bVar.f77597i && this.f77598j == bVar.f77598j;
    }

    public final boolean f() {
        return this.f77596h;
    }

    public final String g() {
        return this.f77594f;
    }

    public final boolean h() {
        return this.f77595g;
    }

    public int hashCode() {
        int i11 = this.f77589a * 31;
        UserSettingType userSettingType = this.f77590b;
        int hashCode = (i11 + (userSettingType == null ? 0 : userSettingType.hashCode())) * 31;
        String str = this.f77591c;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.f77592d;
        int hashCode3 = (((hashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.f77593e) * 31;
        String str2 = this.f77594f;
        return ((((((((hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + e.a(this.f77595g)) * 31) + e.a(this.f77596h)) * 31) + e.a(this.f77597i)) * 31) + e.a(this.f77598j);
    }

    public final int i() {
        return this.f77589a;
    }

    public final UserSettingType j() {
        return this.f77590b;
    }

    public final int k() {
        return this.f77593e;
    }

    public final void l(Integer num) {
        this.f77592d = num;
    }

    public final void m(String str) {
        this.f77591c = str;
    }

    public final void n(boolean z10) {
        this.f77599k = z10;
    }

    public final void o(boolean z10) {
        this.f77598j = z10;
    }

    public final void p(boolean z10) {
        this.f77596h = z10;
    }

    public final void q(String str) {
        this.f77594f = str;
    }

    public String toString() {
        return "UserSettingEntity(titleResId=" + this.f77589a + ", type=" + this.f77590b + ", content=" + this.f77591c + ", bgId=" + this.f77592d + ", uiType=" + this.f77593e + ", tips=" + this.f77594f + ", tipsLinearColor=" + this.f77595g + ", switch=" + this.f77596h + ", showDivider=" + this.f77597i + ", showNewIcon=" + this.f77598j + ")";
    }
}
