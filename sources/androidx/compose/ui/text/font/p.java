package androidx.compose.ui.text.font;

import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;
import com.google.logging.type.LogSeverity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class p implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    public static final a f6224b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final p f6225c;

    /* renamed from: d, reason: collision with root package name */
    private static final p f6226d;

    /* renamed from: e, reason: collision with root package name */
    private static final p f6227e;

    /* renamed from: f, reason: collision with root package name */
    private static final p f6228f;

    /* renamed from: g, reason: collision with root package name */
    private static final p f6229g;

    /* renamed from: h, reason: collision with root package name */
    private static final p f6230h;

    /* renamed from: i, reason: collision with root package name */
    private static final p f6231i;

    /* renamed from: j, reason: collision with root package name */
    private static final p f6232j;

    /* renamed from: k, reason: collision with root package name */
    private static final p f6233k;

    /* renamed from: l, reason: collision with root package name */
    private static final p f6234l;

    /* renamed from: m, reason: collision with root package name */
    private static final p f6235m;

    /* renamed from: n, reason: collision with root package name */
    private static final p f6236n;

    /* renamed from: o, reason: collision with root package name */
    private static final p f6237o;

    /* renamed from: p, reason: collision with root package name */
    private static final p f6238p;

    /* renamed from: q, reason: collision with root package name */
    private static final p f6239q;

    /* renamed from: r, reason: collision with root package name */
    private static final p f6240r;

    /* renamed from: s, reason: collision with root package name */
    private static final p f6241s;

    /* renamed from: t, reason: collision with root package name */
    private static final p f6242t;

    /* renamed from: u, reason: collision with root package name */
    private static final List f6243u;

    /* renamed from: a, reason: collision with root package name */
    private final int f6244a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final p a() {
            return p.f6237o;
        }

        public final p b() {
            return p.f6228f;
        }

        public final p c() {
            return p.f6229g;
        }

        public final p d() {
            return p.f6230h;
        }

        public final p e() {
            return p.f6231i;
        }
    }

    static {
        p pVar = new p(100);
        f6225c = pVar;
        p pVar2 = new p(200);
        f6226d = pVar2;
        p pVar3 = new p(300);
        f6227e = pVar3;
        p pVar4 = new p(400);
        f6228f = pVar4;
        p pVar5 = new p(500);
        f6229g = pVar5;
        p pVar6 = new p(600);
        f6230h = pVar6;
        p pVar7 = new p(LogSeverity.ALERT_VALUE);
        f6231i = pVar7;
        p pVar8 = new p(LogSeverity.EMERGENCY_VALUE);
        f6232j = pVar8;
        p pVar9 = new p(DescriptorProtos$Edition.EDITION_LEGACY_VALUE);
        f6233k = pVar9;
        f6234l = pVar;
        f6235m = pVar2;
        f6236n = pVar3;
        f6237o = pVar4;
        f6238p = pVar5;
        f6239q = pVar6;
        f6240r = pVar7;
        f6241s = pVar8;
        f6242t = pVar9;
        f6243u = CollectionsKt.o(pVar, pVar2, pVar3, pVar4, pVar5, pVar6, pVar7, pVar8, pVar9);
    }

    public p(int i11) {
        this.f6244a = i11;
        if (1 > i11 || i11 >= 1001) {
            throw new IllegalArgumentException(("Font weight can be in range [1, 1000]. Current value: " + i11).toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p) && this.f6244a == ((p) obj).f6244a;
    }

    @Override // java.lang.Comparable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compareTo(p pVar) {
        return Intrinsics.j(this.f6244a, pVar.f6244a);
    }

    public final int h() {
        return this.f6244a;
    }

    public int hashCode() {
        return this.f6244a;
    }

    public String toString() {
        return "FontWeight(weight=" + this.f6244a + ')';
    }
}
