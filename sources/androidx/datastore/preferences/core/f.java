package androidx.datastore.preferences.core;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.PreferencesProto$Value;
import androidx.datastore.preferences.core.c;
import androidx.datastore.preferences.d;
import androidx.datastore.preferences.e;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.BufferedSource;

/* loaded from: classes.dex */
public final class f implements androidx.datastore.core.okio.b {

    /* renamed from: a, reason: collision with root package name */
    public static final f f8739a = new f();

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8740a;

        static {
            int[] iArr = new int[PreferencesProto$Value.ValueCase.values().length];
            try {
                iArr[PreferencesProto$Value.ValueCase.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PreferencesProto$Value.ValueCase.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PreferencesProto$Value.ValueCase.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PreferencesProto$Value.ValueCase.INTEGER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PreferencesProto$Value.ValueCase.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PreferencesProto$Value.ValueCase.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PreferencesProto$Value.ValueCase.STRING_SET.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PreferencesProto$Value.ValueCase.BYTES.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PreferencesProto$Value.ValueCase.VALUE_NOT_SET.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f8740a = iArr;
        }
    }

    private f() {
    }

    private final void d(String str, PreferencesProto$Value preferencesProto$Value, MutablePreferences mutablePreferences) {
        PreferencesProto$Value.ValueCase c02 = preferencesProto$Value.c0();
        switch (c02 == null ? -1 : a.f8740a[c02.ordinal()]) {
            case -1:
                throw new CorruptionException("Value case is null.", null, 2, null);
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                mutablePreferences.i(e.a(str), Boolean.valueOf(preferencesProto$Value.T()));
                return;
            case 2:
                mutablePreferences.i(e.d(str), Float.valueOf(preferencesProto$Value.X()));
                return;
            case 3:
                mutablePreferences.i(e.c(str), Double.valueOf(preferencesProto$Value.W()));
                return;
            case 4:
                mutablePreferences.i(e.e(str), Integer.valueOf(preferencesProto$Value.Y()));
                return;
            case 5:
                mutablePreferences.i(e.f(str), Long.valueOf(preferencesProto$Value.Z()));
                return;
            case 6:
                c.a g11 = e.g(str);
                String a02 = preferencesProto$Value.a0();
                Intrinsics.g(a02, "value.string");
                mutablePreferences.i(g11, a02);
                return;
            case 7:
                c.a h11 = e.h(str);
                List P = preferencesProto$Value.b0().P();
                Intrinsics.g(P, "value.stringSet.stringsList");
                mutablePreferences.i(h11, CollectionsKt.W0(P));
                return;
            case 8:
                c.a b11 = e.b(str);
                byte[] byteArray = preferencesProto$Value.U().toByteArray();
                Intrinsics.g(byteArray, "value.bytes.toByteArray()");
                mutablePreferences.i(b11, byteArray);
                return;
            case 9:
                throw new CorruptionException("Value not set.", null, 2, null);
        }
    }

    private final PreferencesProto$Value f(Object obj) {
        if (obj instanceof Boolean) {
            GeneratedMessageLite m11 = PreferencesProto$Value.d0().x(((Boolean) obj).booleanValue()).m();
            Intrinsics.g(m11, "newBuilder().setBoolean(value).build()");
            return (PreferencesProto$Value) m11;
        }
        if (obj instanceof Float) {
            GeneratedMessageLite m12 = PreferencesProto$Value.d0().A(((Number) obj).floatValue()).m();
            Intrinsics.g(m12, "newBuilder().setFloat(value).build()");
            return (PreferencesProto$Value) m12;
        }
        if (obj instanceof Double) {
            GeneratedMessageLite m13 = PreferencesProto$Value.d0().z(((Number) obj).doubleValue()).m();
            Intrinsics.g(m13, "newBuilder().setDouble(value).build()");
            return (PreferencesProto$Value) m13;
        }
        if (obj instanceof Integer) {
            GeneratedMessageLite m14 = PreferencesProto$Value.d0().B(((Number) obj).intValue()).m();
            Intrinsics.g(m14, "newBuilder().setInteger(value).build()");
            return (PreferencesProto$Value) m14;
        }
        if (obj instanceof Long) {
            GeneratedMessageLite m15 = PreferencesProto$Value.d0().C(((Number) obj).longValue()).m();
            Intrinsics.g(m15, "newBuilder().setLong(value).build()");
            return (PreferencesProto$Value) m15;
        }
        if (obj instanceof String) {
            GeneratedMessageLite m16 = PreferencesProto$Value.d0().D((String) obj).m();
            Intrinsics.g(m16, "newBuilder().setString(value).build()");
            return (PreferencesProto$Value) m16;
        }
        if (obj instanceof Set) {
            PreferencesProto$Value.a d02 = PreferencesProto$Value.d0();
            e.a Q = androidx.datastore.preferences.e.Q();
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
            GeneratedMessageLite m17 = d02.E(Q.x((Set) obj)).m();
            Intrinsics.g(m17, "newBuilder().setStringSe…                ).build()");
            return (PreferencesProto$Value) m17;
        }
        if (obj instanceof byte[]) {
            GeneratedMessageLite m18 = PreferencesProto$Value.d0().y(ByteString.copyFrom((byte[]) obj)).m();
            Intrinsics.g(m18, "newBuilder().setBytes(By….copyFrom(value)).build()");
            return (PreferencesProto$Value) m18;
        }
        throw new IllegalStateException("PreferencesSerializer does not support type: " + obj.getClass().getName());
    }

    @Override // androidx.datastore.core.okio.b
    public Object a(BufferedSource bufferedSource, Continuation continuation) {
        androidx.datastore.preferences.d a11 = androidx.datastore.preferences.b.f8731a.a(bufferedSource.inputStream());
        MutablePreferences b11 = d.b(new c.b[0]);
        Map N = a11.N();
        Intrinsics.g(N, "preferencesProto.preferencesMap");
        for (Map.Entry entry : N.entrySet()) {
            String name = (String) entry.getKey();
            PreferencesProto$Value value = (PreferencesProto$Value) entry.getValue();
            f fVar = f8739a;
            Intrinsics.g(name, "name");
            Intrinsics.g(value, "value");
            fVar.d(name, value, b11);
        }
        return b11.d();
    }

    @Override // androidx.datastore.core.okio.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public c c() {
        return d.a();
    }

    @Override // androidx.datastore.core.okio.b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Object b(c cVar, BufferedSink bufferedSink, Continuation continuation) {
        Map a11 = cVar.a();
        d.a Q = androidx.datastore.preferences.d.Q();
        for (Map.Entry entry : a11.entrySet()) {
            Q.x(((c.a) entry.getKey()).a(), f(entry.getValue()));
        }
        ((androidx.datastore.preferences.d) Q.m()).h(bufferedSink.outputStream());
        return Unit.f67184a;
    }
}
