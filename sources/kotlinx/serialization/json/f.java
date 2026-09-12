package kotlinx.serialization.json;

import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tools.zip.UnixStat;

/* loaded from: classes7.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f68378a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f68379b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f68380c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f68381d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f68382e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f68383f;

    /* renamed from: g, reason: collision with root package name */
    private final String f68384g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f68385h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f68386i;

    /* renamed from: j, reason: collision with root package name */
    private final String f68387j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f68388k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f68389l;

    public f() {
        this(false, false, false, false, false, false, null, false, false, null, false, false, UnixStat.PERM_MASK, null);
    }

    public f(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, String prettyPrintIndent, boolean z16, boolean z17, String classDiscriminator, boolean z18, boolean z19) {
        Intrinsics.h(prettyPrintIndent, "prettyPrintIndent");
        Intrinsics.h(classDiscriminator, "classDiscriminator");
        this.f68378a = z10;
        this.f68379b = z11;
        this.f68380c = z12;
        this.f68381d = z13;
        this.f68382e = z14;
        this.f68383f = z15;
        this.f68384g = prettyPrintIndent;
        this.f68385h = z16;
        this.f68386i = z17;
        this.f68387j = classDiscriminator;
        this.f68388k = z18;
        this.f68389l = z19;
    }

    public /* synthetic */ f(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, String str, boolean z16, boolean z17, String str2, boolean z18, boolean z19, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z10, (i11 & 2) != 0 ? false : z11, (i11 & 4) != 0 ? false : z12, (i11 & 8) != 0 ? false : z13, (i11 & 16) != 0 ? false : z14, (i11 & 32) != 0 ? true : z15, (i11 & 64) != 0 ? "    " : str, (i11 & 128) != 0 ? false : z16, (i11 & 256) != 0 ? false : z17, (i11 & 512) != 0 ? NativeComponentConstants.KEY_COMPONENT_TYPE : str2, (i11 & 1024) == 0 ? z18 : false, (i11 & 2048) == 0 ? z19 : true);
    }

    public final boolean a() {
        return this.f68388k;
    }

    public final boolean b() {
        return this.f68381d;
    }

    public final String c() {
        return this.f68387j;
    }

    public final boolean d() {
        return this.f68385h;
    }

    public final boolean e() {
        return this.f68378a;
    }

    public final boolean f() {
        return this.f68383f;
    }

    public final boolean g() {
        return this.f68379b;
    }

    public final boolean h() {
        return this.f68382e;
    }

    public final String i() {
        return this.f68384g;
    }

    public final boolean j() {
        return this.f68389l;
    }

    public final boolean k() {
        return this.f68386i;
    }

    public final boolean l() {
        return this.f68380c;
    }

    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f68378a + ", ignoreUnknownKeys=" + this.f68379b + ", isLenient=" + this.f68380c + ", allowStructuredMapKeys=" + this.f68381d + ", prettyPrint=" + this.f68382e + ", explicitNulls=" + this.f68383f + ", prettyPrintIndent='" + this.f68384g + "', coerceInputValues=" + this.f68385h + ", useArrayPolymorphism=" + this.f68386i + ", classDiscriminator='" + this.f68387j + "', allowSpecialFloatingPointValues=" + this.f68388k + ')';
    }
}
