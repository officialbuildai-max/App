package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class t1 {

    /* renamed from: i, reason: collision with root package name */
    public static final int f4116i = 8;

    /* renamed from: a, reason: collision with root package name */
    private final q f4117a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f4118b;

    /* renamed from: c, reason: collision with root package name */
    private final q2 f4119c;

    /* renamed from: d, reason: collision with root package name */
    private final i1 f4120d;

    /* renamed from: e, reason: collision with root package name */
    private final Function1 f4121e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f4122f;

    /* renamed from: g, reason: collision with root package name */
    private final Object f4123g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4124h = true;

    public t1(q qVar, Object obj, boolean z10, q2 q2Var, i1 i1Var, Function1 function1, boolean z11) {
        this.f4117a = qVar;
        this.f4118b = z10;
        this.f4119c = q2Var;
        this.f4120d = i1Var;
        this.f4121e = function1;
        this.f4122f = z11;
        this.f4123g = obj;
    }

    public final boolean a() {
        return this.f4124h;
    }

    public final q b() {
        return this.f4117a;
    }

    public final Function1 c() {
        return this.f4121e;
    }

    public final Object d() {
        if (this.f4118b) {
            return null;
        }
        i1 i1Var = this.f4120d;
        if (i1Var != null) {
            return i1Var.getValue();
        }
        Object obj = this.f4123g;
        if (obj != null) {
            return obj;
        }
        k.s("Unexpected form of a provided value");
        throw new KotlinNothingValueException();
    }

    public final q2 e() {
        return this.f4119c;
    }

    public final i1 f() {
        return this.f4120d;
    }

    public final Object g() {
        return this.f4123g;
    }

    public final t1 h() {
        this.f4124h = false;
        return this;
    }

    public final boolean i() {
        return this.f4122f;
    }

    public final boolean j() {
        return (this.f4118b || g() != null) && !this.f4122f;
    }
}
