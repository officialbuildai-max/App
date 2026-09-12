package androidx.window.core;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public final class Version implements Comparable {

    /* renamed from: f, reason: collision with root package name */
    public static final a f15360f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final Version f15361g = new Version(0, 0, 0, "");

    /* renamed from: h, reason: collision with root package name */
    private static final Version f15362h = new Version(0, 1, 0, "");

    /* renamed from: i, reason: collision with root package name */
    private static final Version f15363i;

    /* renamed from: j, reason: collision with root package name */
    private static final Version f15364j;

    /* renamed from: a, reason: collision with root package name */
    private final int f15365a;

    /* renamed from: b, reason: collision with root package name */
    private final int f15366b;

    /* renamed from: c, reason: collision with root package name */
    private final int f15367c;

    /* renamed from: d, reason: collision with root package name */
    private final String f15368d;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f15369e;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Version a() {
            return Version.f15362h;
        }

        public final Version b(String str) {
            if (str == null || StringsKt.q0(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            String group = matcher.group(1);
            Integer valueOf = group == null ? null : Integer.valueOf(Integer.parseInt(group));
            if (valueOf == null) {
                return null;
            }
            int intValue = valueOf.intValue();
            String group2 = matcher.group(2);
            Integer valueOf2 = group2 == null ? null : Integer.valueOf(Integer.parseInt(group2));
            if (valueOf2 == null) {
                return null;
            }
            int intValue2 = valueOf2.intValue();
            String group3 = matcher.group(3);
            Integer valueOf3 = group3 == null ? null : Integer.valueOf(Integer.parseInt(group3));
            if (valueOf3 == null) {
                return null;
            }
            int intValue3 = valueOf3.intValue();
            String description = matcher.group(4) != null ? matcher.group(4) : "";
            Intrinsics.g(description, "description");
            return new Version(intValue, intValue2, intValue3, description, null);
        }
    }

    static {
        Version version = new Version(1, 0, 0, "");
        f15363i = version;
        f15364j = version;
    }

    private Version(int i11, int i12, int i13, String str) {
        this.f15365a = i11;
        this.f15366b = i12;
        this.f15367c = i13;
        this.f15368d = str;
        this.f15369e = LazyKt.b(new Function0<BigInteger>() { // from class: androidx.window.core.Version$bigInteger$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final BigInteger invoke() {
                return BigInteger.valueOf(Version.this.e()).shiftLeft(32).or(BigInteger.valueOf(Version.this.f())).shiftLeft(32).or(BigInteger.valueOf(Version.this.g()));
            }
        });
    }

    public /* synthetic */ Version(int i11, int i12, int i13, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12, i13, str);
    }

    private final BigInteger d() {
        Object value = this.f15369e.getValue();
        Intrinsics.g(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(Version other) {
        Intrinsics.h(other, "other");
        return d().compareTo(other.d());
    }

    public final int e() {
        return this.f15365a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        return this.f15365a == version.f15365a && this.f15366b == version.f15366b && this.f15367c == version.f15367c;
    }

    public final int f() {
        return this.f15366b;
    }

    public final int g() {
        return this.f15367c;
    }

    public int hashCode() {
        return ((((527 + this.f15365a) * 31) + this.f15366b) * 31) + this.f15367c;
    }

    public String toString() {
        return this.f15365a + '.' + this.f15366b + '.' + this.f15367c + (!StringsKt.q0(this.f15368d) ? Intrinsics.q("-", this.f15368d) : "");
    }
}
