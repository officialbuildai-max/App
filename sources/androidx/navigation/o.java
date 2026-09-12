package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public abstract class o {

    /* renamed from: c, reason: collision with root package name */
    public static final l f14018c = new l(null);

    /* renamed from: d, reason: collision with root package name */
    public static final o f14019d = new f();

    /* renamed from: e, reason: collision with root package name */
    public static final o f14020e = new i();

    /* renamed from: f, reason: collision with root package name */
    public static final o f14021f = new e();

    /* renamed from: g, reason: collision with root package name */
    public static final o f14022g = new h();

    /* renamed from: h, reason: collision with root package name */
    public static final o f14023h = new g();

    /* renamed from: i, reason: collision with root package name */
    public static final o f14024i = new d();

    /* renamed from: j, reason: collision with root package name */
    public static final o f14025j = new c();

    /* renamed from: k, reason: collision with root package name */
    public static final o f14026k = new b();

    /* renamed from: l, reason: collision with root package name */
    public static final o f14027l = new a();

    /* renamed from: m, reason: collision with root package name */
    public static final o f14028m = new k();

    /* renamed from: n, reason: collision with root package name */
    public static final o f14029n = new j();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f14030a;

    /* renamed from: b, reason: collision with root package name */
    private final String f14031b = "nav_type";

    /* loaded from: classes2.dex */
    public static final class a extends o {
        a() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "boolean[]";
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean[] a(Bundle bundle, String key) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            return (boolean[]) bundle.get(key);
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean[] h(String value) {
            Intrinsics.h(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, boolean[] zArr) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            bundle.putBooleanArray(key, zArr);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends o {
        b() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "boolean";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void f(Bundle bundle, String str, Object obj) {
            i(bundle, str, ((Boolean) obj).booleanValue());
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Boolean a(Bundle bundle, String key) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            return (Boolean) bundle.get(key);
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean h(String value) {
            boolean z10;
            Intrinsics.h(value, "value");
            if (Intrinsics.c(value, "true")) {
                z10 = true;
            } else {
                if (!Intrinsics.c(value, "false")) {
                    throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
                }
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }

        public void i(Bundle bundle, String key, boolean z10) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            bundle.putBoolean(key, z10);
        }
    }

    /* loaded from: classes2.dex */
    public static final class c extends o {
        c() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "float[]";
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public float[] a(Bundle bundle, String key) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            return (float[]) bundle.get(key);
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public float[] h(String value) {
            Intrinsics.h(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, float[] fArr) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            bundle.putFloatArray(key, fArr);
        }
    }

    /* loaded from: classes2.dex */
    public static final class d extends o {
        d() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "float";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void f(Bundle bundle, String str, Object obj) {
            i(bundle, str, ((Number) obj).floatValue());
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Float a(Bundle bundle, String key) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            Object obj = bundle.get(key);
            if (obj != null) {
                return (Float) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Float h(String value) {
            Intrinsics.h(value, "value");
            return Float.valueOf(Float.parseFloat(value));
        }

        public void i(Bundle bundle, String key, float f11) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            bundle.putFloat(key, f11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class e extends o {
        e() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "integer[]";
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public int[] a(Bundle bundle, String key) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            return (int[]) bundle.get(key);
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public int[] h(String value) {
            Intrinsics.h(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, int[] iArr) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            bundle.putIntArray(key, iArr);
        }
    }

    /* loaded from: classes2.dex */
    public static final class f extends o {
        f() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "integer";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void f(Bundle bundle, String str, Object obj) {
            i(bundle, str, ((Number) obj).intValue());
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Integer a(Bundle bundle, String key) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            Object obj = bundle.get(key);
            if (obj != null) {
                return (Integer) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Integer h(String value) {
            int parseInt;
            Intrinsics.h(value, "value");
            if (StringsKt.W(value, "0x", false, 2, null)) {
                String substring = value.substring(2);
                Intrinsics.g(substring, "this as java.lang.String).substring(startIndex)");
                parseInt = Integer.parseInt(substring, CharsKt.a(16));
            } else {
                parseInt = Integer.parseInt(value);
            }
            return Integer.valueOf(parseInt);
        }

        public void i(Bundle bundle, String key, int i11) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            bundle.putInt(key, i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class g extends o {
        g() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "long[]";
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public long[] a(Bundle bundle, String key) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            return (long[]) bundle.get(key);
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public long[] h(String value) {
            Intrinsics.h(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, long[] jArr) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            bundle.putLongArray(key, jArr);
        }
    }

    /* loaded from: classes2.dex */
    public static final class h extends o {
        h() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "long";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void f(Bundle bundle, String str, Object obj) {
            i(bundle, str, ((Number) obj).longValue());
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Long a(Bundle bundle, String key) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            Object obj = bundle.get(key);
            if (obj != null) {
                return (Long) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Long h(String value) {
            String str;
            long parseLong;
            Intrinsics.h(value, "value");
            if (StringsKt.G(value, "L", false, 2, null)) {
                str = value.substring(0, value.length() - 1);
                Intrinsics.g(str, "this as java.lang.String…ing(startIndex, endIndex)");
            } else {
                str = value;
            }
            if (StringsKt.W(value, "0x", false, 2, null)) {
                String substring = str.substring(2);
                Intrinsics.g(substring, "this as java.lang.String).substring(startIndex)");
                parseLong = Long.parseLong(substring, CharsKt.a(16));
            } else {
                parseLong = Long.parseLong(str);
            }
            return Long.valueOf(parseLong);
        }

        public void i(Bundle bundle, String key, long j11) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            bundle.putLong(key, j11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class i extends o {
        i() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "reference";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void f(Bundle bundle, String str, Object obj) {
            i(bundle, str, ((Number) obj).intValue());
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Integer a(Bundle bundle, String key) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            Object obj = bundle.get(key);
            if (obj != null) {
                return (Integer) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Integer h(String value) {
            int parseInt;
            Intrinsics.h(value, "value");
            if (StringsKt.W(value, "0x", false, 2, null)) {
                String substring = value.substring(2);
                Intrinsics.g(substring, "this as java.lang.String).substring(startIndex)");
                parseInt = Integer.parseInt(substring, CharsKt.a(16));
            } else {
                parseInt = Integer.parseInt(value);
            }
            return Integer.valueOf(parseInt);
        }

        public void i(Bundle bundle, String key, int i11) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            bundle.putInt(key, i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class j extends o {
        j() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "string[]";
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public String[] a(Bundle bundle, String key) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            return (String[]) bundle.get(key);
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public String[] h(String value) {
            Intrinsics.h(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, String[] strArr) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            bundle.putStringArray(key, strArr);
        }
    }

    /* loaded from: classes2.dex */
    public static final class k extends o {
        k() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "string";
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public String a(Bundle bundle, String key) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            return (String) bundle.get(key);
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public String h(String value) {
            Intrinsics.h(value, "value");
            return value;
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, String str) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            bundle.putString(key, str);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l {
        private l() {
        }

        public /* synthetic */ l(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public o a(String str, String str2) {
            o oVar = o.f14019d;
            if (Intrinsics.c(oVar.b(), str)) {
                return oVar;
            }
            o oVar2 = o.f14021f;
            if (Intrinsics.c(oVar2.b(), str)) {
                return oVar2;
            }
            o oVar3 = o.f14022g;
            if (Intrinsics.c(oVar3.b(), str)) {
                return oVar3;
            }
            o oVar4 = o.f14023h;
            if (Intrinsics.c(oVar4.b(), str)) {
                return oVar4;
            }
            o oVar5 = o.f14026k;
            if (Intrinsics.c(oVar5.b(), str)) {
                return oVar5;
            }
            o oVar6 = o.f14027l;
            if (Intrinsics.c(oVar6.b(), str)) {
                return oVar6;
            }
            o oVar7 = o.f14028m;
            if (Intrinsics.c(oVar7.b(), str)) {
                return oVar7;
            }
            o oVar8 = o.f14029n;
            if (Intrinsics.c(oVar8.b(), str)) {
                return oVar8;
            }
            o oVar9 = o.f14024i;
            if (Intrinsics.c(oVar9.b(), str)) {
                return oVar9;
            }
            o oVar10 = o.f14025j;
            if (Intrinsics.c(oVar10.b(), str)) {
                return oVar10;
            }
            o oVar11 = o.f14020e;
            if (Intrinsics.c(oVar11.b(), str)) {
                return oVar11;
            }
            if (str == null || str.length() == 0) {
                return oVar7;
            }
            try {
                String q11 = (!StringsKt.W(str, ".", false, 2, null) || str2 == null) ? str : Intrinsics.q(str2, str);
                if (StringsKt.G(str, "[]", false, 2, null)) {
                    q11 = q11.substring(0, q11.length() - 2);
                    Intrinsics.g(q11, "this as java.lang.String…ing(startIndex, endIndex)");
                    Class<?> cls = Class.forName(q11);
                    if (Parcelable.class.isAssignableFrom(cls)) {
                        return new n(cls);
                    }
                    if (Serializable.class.isAssignableFrom(cls)) {
                        return new p(cls);
                    }
                } else {
                    Class<?> cls2 = Class.forName(q11);
                    if (Parcelable.class.isAssignableFrom(cls2)) {
                        return new C0115o(cls2);
                    }
                    if (Enum.class.isAssignableFrom(cls2)) {
                        return new m(cls2);
                    }
                    if (Serializable.class.isAssignableFrom(cls2)) {
                        return new q(cls2);
                    }
                }
                throw new IllegalArgumentException(Intrinsics.q(q11, " is not Serializable or Parcelable."));
            } catch (ClassNotFoundException e11) {
                throw new RuntimeException(e11);
            }
        }

        public final o b(String value) {
            Intrinsics.h(value, "value");
            try {
                try {
                    try {
                        try {
                            o oVar = o.f14019d;
                            oVar.h(value);
                            return oVar;
                        } catch (IllegalArgumentException unused) {
                            o oVar2 = o.f14024i;
                            oVar2.h(value);
                            return oVar2;
                        }
                    } catch (IllegalArgumentException unused2) {
                        o oVar3 = o.f14022g;
                        oVar3.h(value);
                        return oVar3;
                    }
                } catch (IllegalArgumentException unused3) {
                    return o.f14028m;
                }
            } catch (IllegalArgumentException unused4) {
                o oVar4 = o.f14026k;
                oVar4.h(value);
                return oVar4;
            }
        }

        public final o c(Object obj) {
            o qVar;
            if (obj instanceof Integer) {
                return o.f14019d;
            }
            if (obj instanceof int[]) {
                return o.f14021f;
            }
            if (obj instanceof Long) {
                return o.f14022g;
            }
            if (obj instanceof long[]) {
                return o.f14023h;
            }
            if (obj instanceof Float) {
                return o.f14024i;
            }
            if (obj instanceof float[]) {
                return o.f14025j;
            }
            if (obj instanceof Boolean) {
                return o.f14026k;
            }
            if (obj instanceof boolean[]) {
                return o.f14027l;
            }
            if ((obj instanceof String) || obj == null) {
                return o.f14028m;
            }
            if ((obj instanceof Object[]) && (((Object[]) obj) instanceof String[])) {
                return o.f14029n;
            }
            if (obj.getClass().isArray()) {
                Class<?> componentType = obj.getClass().getComponentType();
                Intrinsics.e(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    Class<?> componentType2 = obj.getClass().getComponentType();
                    if (componentType2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
                    }
                    qVar = new n(componentType2);
                    return qVar;
                }
            }
            if (obj.getClass().isArray()) {
                Class<?> componentType3 = obj.getClass().getComponentType();
                Intrinsics.e(componentType3);
                if (Serializable.class.isAssignableFrom(componentType3)) {
                    Class<?> componentType4 = obj.getClass().getComponentType();
                    if (componentType4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                    }
                    qVar = new p(componentType4);
                    return qVar;
                }
            }
            if (obj instanceof Parcelable) {
                qVar = new C0115o(obj.getClass());
            } else if (obj instanceof Enum) {
                qVar = new m(obj.getClass());
            } else {
                if (!(obj instanceof Serializable)) {
                    throw new IllegalArgumentException("Object of type " + ((Object) obj.getClass().getName()) + " is not supported for navigation arguments.");
                }
                qVar = new q(obj.getClass());
            }
            return qVar;
        }
    }

    /* loaded from: classes2.dex */
    public static final class m extends q {

        /* renamed from: p, reason: collision with root package name */
        private final Class f14032p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Class type) {
            super(false, type);
            Intrinsics.h(type, "type");
            if (type.isEnum()) {
                this.f14032p = type;
                return;
            }
            throw new IllegalArgumentException((type + " is not an Enum type.").toString());
        }

        @Override // androidx.navigation.o.q, androidx.navigation.o
        public String b() {
            String name = this.f14032p.getName();
            Intrinsics.g(name, "type.name");
            return name;
        }

        @Override // androidx.navigation.o.q
        /* renamed from: j, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Enum h(String value) {
            Object obj;
            Intrinsics.h(value, "value");
            Object[] enumConstants = this.f14032p.getEnumConstants();
            Intrinsics.g(enumConstants, "type.enumConstants");
            int length = enumConstants.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    obj = null;
                    break;
                }
                obj = enumConstants[i11];
                i11++;
                if (StringsKt.H(((Enum) obj).name(), value, true)) {
                    break;
                }
            }
            Enum r32 = (Enum) obj;
            if (r32 != null) {
                return r32;
            }
            throw new IllegalArgumentException("Enum value " + value + " not found for type " + ((Object) this.f14032p.getName()) + '.');
        }
    }

    /* loaded from: classes2.dex */
    public static final class n extends o {

        /* renamed from: o, reason: collision with root package name */
        private final Class f14033o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(Class type) {
            super(true);
            Intrinsics.h(type, "type");
            if (!Parcelable.class.isAssignableFrom(type)) {
                throw new IllegalArgumentException((type + " does not implement Parcelable.").toString());
            }
            try {
                this.f14033o = Class.forName("[L" + ((Object) type.getName()) + ';');
            } catch (ClassNotFoundException e11) {
                throw new RuntimeException(e11);
            }
        }

        @Override // androidx.navigation.o
        public String b() {
            String name = this.f14033o.getName();
            Intrinsics.g(name, "arrayType.name");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.c(n.class, obj.getClass())) {
                return false;
            }
            return Intrinsics.c(this.f14033o, ((n) obj).f14033o);
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Parcelable[] a(Bundle bundle, String key) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            return (Parcelable[]) bundle.get(key);
        }

        @Override // androidx.navigation.o
        public Parcelable[] h(String value) {
            Intrinsics.h(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public int hashCode() {
            return this.f14033o.hashCode();
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, Parcelable[] parcelableArr) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            this.f14033o.cast(parcelableArr);
            bundle.putParcelableArray(key, parcelableArr);
        }
    }

    /* renamed from: androidx.navigation.o$o, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0115o extends o {

        /* renamed from: o, reason: collision with root package name */
        private final Class f14034o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0115o(Class type) {
            super(true);
            Intrinsics.h(type, "type");
            if (Parcelable.class.isAssignableFrom(type) || Serializable.class.isAssignableFrom(type)) {
                this.f14034o = type;
                return;
            }
            throw new IllegalArgumentException((type + " does not implement Parcelable or Serializable.").toString());
        }

        @Override // androidx.navigation.o
        public Object a(Bundle bundle, String key) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            return bundle.get(key);
        }

        @Override // androidx.navigation.o
        public String b() {
            String name = this.f14034o.getName();
            Intrinsics.g(name, "type.name");
            return name;
        }

        @Override // androidx.navigation.o
        /* renamed from: e */
        public Object h(String value) {
            Intrinsics.h(value, "value");
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.c(C0115o.class, obj.getClass())) {
                return false;
            }
            return Intrinsics.c(this.f14034o, ((C0115o) obj).f14034o);
        }

        @Override // androidx.navigation.o
        public void f(Bundle bundle, String key, Object obj) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            this.f14034o.cast(obj);
            if (obj == null || (obj instanceof Parcelable)) {
                bundle.putParcelable(key, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(key, (Serializable) obj);
            }
        }

        public int hashCode() {
            return this.f14034o.hashCode();
        }
    }

    /* loaded from: classes2.dex */
    public static final class p extends o {

        /* renamed from: o, reason: collision with root package name */
        private final Class f14035o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(Class type) {
            super(true);
            Intrinsics.h(type, "type");
            if (!Serializable.class.isAssignableFrom(type)) {
                throw new IllegalArgumentException((type + " does not implement Serializable.").toString());
            }
            try {
                this.f14035o = Class.forName("[L" + ((Object) type.getName()) + ';');
            } catch (ClassNotFoundException e11) {
                throw new RuntimeException(e11);
            }
        }

        @Override // androidx.navigation.o
        public String b() {
            String name = this.f14035o.getName();
            Intrinsics.g(name, "arrayType.name");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.c(p.class, obj.getClass())) {
                return false;
            }
            return Intrinsics.c(this.f14035o, ((p) obj).f14035o);
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Serializable[] a(Bundle bundle, String key) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            return (Serializable[]) bundle.get(key);
        }

        @Override // androidx.navigation.o
        public Serializable[] h(String value) {
            Intrinsics.h(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public int hashCode() {
            return this.f14035o.hashCode();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, Serializable[] serializableArr) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            this.f14035o.cast(serializableArr);
            bundle.putSerializable(key, serializableArr);
        }
    }

    /* loaded from: classes2.dex */
    public static class q extends o {

        /* renamed from: o, reason: collision with root package name */
        private final Class f14036o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(Class type) {
            super(true);
            Intrinsics.h(type, "type");
            if (!Serializable.class.isAssignableFrom(type)) {
                throw new IllegalArgumentException((type + " does not implement Serializable.").toString());
            }
            if (!type.isEnum()) {
                this.f14036o = type;
                return;
            }
            throw new IllegalArgumentException((type + " is an Enum. You should use EnumType instead.").toString());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(boolean z10, Class type) {
            super(z10);
            Intrinsics.h(type, "type");
            if (Serializable.class.isAssignableFrom(type)) {
                this.f14036o = type;
                return;
            }
            throw new IllegalArgumentException((type + " does not implement Serializable.").toString());
        }

        @Override // androidx.navigation.o
        public String b() {
            String name = this.f14036o.getName();
            Intrinsics.g(name, "type.name");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof q) {
                return Intrinsics.c(this.f14036o, ((q) obj).f14036o);
            }
            return false;
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Serializable a(Bundle bundle, String key) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            return (Serializable) bundle.get(key);
        }

        @Override // androidx.navigation.o
        public Serializable h(String value) {
            Intrinsics.h(value, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public int hashCode() {
            return this.f14036o.hashCode();
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, Serializable value) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(key, "key");
            Intrinsics.h(value, "value");
            this.f14036o.cast(value);
            bundle.putSerializable(key, value);
        }
    }

    public o(boolean z10) {
        this.f14030a = z10;
    }

    public abstract Object a(Bundle bundle, String str);

    public abstract String b();

    public boolean c() {
        return this.f14030a;
    }

    public final Object d(Bundle bundle, String key, String value) {
        Intrinsics.h(bundle, "bundle");
        Intrinsics.h(key, "key");
        Intrinsics.h(value, "value");
        Object h11 = h(value);
        f(bundle, key, h11);
        return h11;
    }

    /* renamed from: e */
    public abstract Object h(String str);

    public abstract void f(Bundle bundle, String str, Object obj);

    public String toString() {
        return b();
    }
}
