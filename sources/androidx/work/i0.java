package androidx.work;

import android.os.Build;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public abstract class i0 {

    /* renamed from: d, reason: collision with root package name */
    public static final b f15574d = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private final UUID f15575a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.work.impl.model.j0 f15576b;

    /* renamed from: c, reason: collision with root package name */
    private final Set f15577c;

    /* loaded from: classes2.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        private final Class f15578a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f15579b;

        /* renamed from: c, reason: collision with root package name */
        private UUID f15580c;

        /* renamed from: d, reason: collision with root package name */
        private androidx.work.impl.model.j0 f15581d;

        /* renamed from: e, reason: collision with root package name */
        private final Set f15582e;

        public a(Class workerClass) {
            Intrinsics.h(workerClass, "workerClass");
            this.f15578a = workerClass;
            UUID randomUUID = UUID.randomUUID();
            Intrinsics.g(randomUUID, "randomUUID(...)");
            this.f15580c = randomUUID;
            String uuid = this.f15580c.toString();
            Intrinsics.g(uuid, "toString(...)");
            String name = workerClass.getName();
            Intrinsics.g(name, "getName(...)");
            this.f15581d = new androidx.work.impl.model.j0(uuid, name);
            String name2 = workerClass.getName();
            Intrinsics.g(name2, "getName(...)");
            this.f15582e = SetsKt.h(name2);
        }

        public final a a(String tag) {
            Intrinsics.h(tag, "tag");
            this.f15582e.add(tag);
            return g();
        }

        public final i0 b() {
            i0 c11 = c();
            d dVar = this.f15581d.f15855j;
            boolean z10 = (Build.VERSION.SDK_INT >= 24 && dVar.g()) || dVar.h() || dVar.i() || dVar.j();
            androidx.work.impl.model.j0 j0Var = this.f15581d;
            if (j0Var.f15862q) {
                if (z10) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                }
                if (j0Var.f15852g > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            String l11 = j0Var.l();
            if (l11 == null) {
                androidx.work.impl.model.j0 j0Var2 = this.f15581d;
                j0Var2.t(i0.f15574d.b(j0Var2.f15848c));
            } else if (l11.length() > 127) {
                this.f15581d.t(StringsKt.y1(l11, 127));
            }
            UUID randomUUID = UUID.randomUUID();
            Intrinsics.g(randomUUID, "randomUUID(...)");
            j(randomUUID);
            return c11;
        }

        public abstract i0 c();

        public final boolean d() {
            return this.f15579b;
        }

        public final UUID e() {
            return this.f15580c;
        }

        public final Set f() {
            return this.f15582e;
        }

        public abstract a g();

        public final androidx.work.impl.model.j0 h() {
            return this.f15581d;
        }

        public final a i(d constraints) {
            Intrinsics.h(constraints, "constraints");
            this.f15581d.f15855j = constraints;
            return g();
        }

        public final a j(UUID id2) {
            Intrinsics.h(id2, "id");
            this.f15580c = id2;
            String uuid = id2.toString();
            Intrinsics.g(uuid, "toString(...)");
            this.f15581d = new androidx.work.impl.model.j0(uuid, this.f15581d);
            return g();
        }

        public a k(long j11, TimeUnit timeUnit) {
            Intrinsics.h(timeUnit, "timeUnit");
            this.f15581d.f15852g = timeUnit.toMillis(j11);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.f15581d.f15852g) {
                return g();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        public final a l(f inputData) {
            Intrinsics.h(inputData, "inputData");
            this.f15581d.f15850e = inputData;
            return g();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(String str) {
            List S0 = StringsKt.S0(str, new String[]{"."}, false, 0, 6, null);
            String str2 = S0.size() == 1 ? (String) S0.get(0) : (String) CollectionsKt.u0(S0);
            return str2.length() <= 127 ? str2 : StringsKt.y1(str2, 127);
        }
    }

    public i0(UUID id2, androidx.work.impl.model.j0 workSpec, Set tags) {
        Intrinsics.h(id2, "id");
        Intrinsics.h(workSpec, "workSpec");
        Intrinsics.h(tags, "tags");
        this.f15575a = id2;
        this.f15576b = workSpec;
        this.f15577c = tags;
    }

    public UUID a() {
        return this.f15575a;
    }

    public final String b() {
        String uuid = a().toString();
        Intrinsics.g(uuid, "toString(...)");
        return uuid;
    }

    public final Set c() {
        return this.f15577c;
    }

    public final androidx.work.impl.model.j0 d() {
        return this.f15576b;
    }
}
