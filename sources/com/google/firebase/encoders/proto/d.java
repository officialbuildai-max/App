package com.google.firebase.encoders.proto;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.proto.Protobuf;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class d implements bc.d {

    /* renamed from: f, reason: collision with root package name */
    private static final Charset f31876f = Charset.forName("UTF-8");

    /* renamed from: g, reason: collision with root package name */
    private static final bc.b f31877g = bc.b.a("key").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

    /* renamed from: h, reason: collision with root package name */
    private static final bc.b f31878h = bc.b.a(AppMeasurementSdk.ConditionalUserProperty.VALUE).b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

    /* renamed from: i, reason: collision with root package name */
    private static final bc.c f31879i = new bc.c() { // from class: com.google.firebase.encoders.proto.c
        @Override // bc.c
        public final void a(Object obj, Object obj2) {
            d.w((Map.Entry) obj, (bc.d) obj2);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private OutputStream f31880a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f31881b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f31882c;

    /* renamed from: d, reason: collision with root package name */
    private final bc.c f31883d;

    /* renamed from: e, reason: collision with root package name */
    private final f f31884e = new f(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f31885a;

        static {
            int[] iArr = new int[Protobuf.IntEncoding.values().length];
            f31885a = iArr;
            try {
                iArr[Protobuf.IntEncoding.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31885a[Protobuf.IntEncoding.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31885a[Protobuf.IntEncoding.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(OutputStream outputStream, Map map, Map map2, bc.c cVar) {
        this.f31880a = outputStream;
        this.f31881b = map;
        this.f31882c = map2;
        this.f31883d = cVar;
    }

    private static ByteBuffer p(int i11) {
        return ByteBuffer.allocate(i11).order(ByteOrder.LITTLE_ENDIAN);
    }

    private long q(bc.c cVar, Object obj) {
        b bVar = new b();
        try {
            OutputStream outputStream = this.f31880a;
            this.f31880a = bVar;
            try {
                cVar.a(obj, this);
                this.f31880a = outputStream;
                long d11 = bVar.d();
                bVar.close();
                return d11;
            } catch (Throwable th2) {
                this.f31880a = outputStream;
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                bVar.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    private d r(bc.c cVar, bc.b bVar, Object obj, boolean z10) {
        long q11 = q(cVar, obj);
        if (z10 && q11 == 0) {
            return this;
        }
        x((v(bVar) << 3) | 2);
        y(q11);
        cVar.a(obj, this);
        return this;
    }

    private d s(bc.e eVar, bc.b bVar, Object obj, boolean z10) {
        this.f31884e.b(bVar, z10);
        eVar.a(obj, this.f31884e);
        return this;
    }

    private static Protobuf u(bc.b bVar) {
        Protobuf protobuf = (Protobuf) bVar.c(Protobuf.class);
        if (protobuf != null) {
            return protobuf;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private static int v(bc.b bVar) {
        Protobuf protobuf = (Protobuf) bVar.c(Protobuf.class);
        if (protobuf != null) {
            return protobuf.tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(Map.Entry entry, bc.d dVar) {
        dVar.e(f31877g, entry.getKey());
        dVar.e(f31878h, entry.getValue());
    }

    private void x(int i11) {
        while ((i11 & (-128)) != 0) {
            this.f31880a.write((i11 & 127) | 128);
            i11 >>>= 7;
        }
        this.f31880a.write(i11 & 127);
    }

    private void y(long j11) {
        while (((-128) & j11) != 0) {
            this.f31880a.write((((int) j11) & 127) | 128);
            j11 >>>= 7;
        }
        this.f31880a.write(((int) j11) & 127);
    }

    @Override // bc.d
    public bc.d c(bc.b bVar, double d11) {
        return g(bVar, d11, true);
    }

    @Override // bc.d
    public bc.d e(bc.b bVar, Object obj) {
        return i(bVar, obj, true);
    }

    bc.d g(bc.b bVar, double d11, boolean z10) {
        if (z10 && d11 == 0.0d) {
            return this;
        }
        x((v(bVar) << 3) | 1);
        this.f31880a.write(p(8).putDouble(d11).array());
        return this;
    }

    bc.d h(bc.b bVar, float f11, boolean z10) {
        if (z10 && f11 == 0.0f) {
            return this;
        }
        x((v(bVar) << 3) | 5);
        this.f31880a.write(p(4).putFloat(f11).array());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc.d i(bc.b bVar, Object obj, boolean z10) {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z10 && charSequence.length() == 0) {
                return this;
            }
            x((v(bVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f31876f);
            x(bytes.length);
            this.f31880a.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                i(bVar, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                r(f31879i, bVar, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            return g(bVar, ((Double) obj).doubleValue(), z10);
        }
        if (obj instanceof Float) {
            return h(bVar, ((Float) obj).floatValue(), z10);
        }
        if (obj instanceof Number) {
            return m(bVar, ((Number) obj).longValue(), z10);
        }
        if (obj instanceof Boolean) {
            return o(bVar, ((Boolean) obj).booleanValue(), z10);
        }
        if (!(obj instanceof byte[])) {
            bc.c cVar = (bc.c) this.f31881b.get(obj.getClass());
            if (cVar != null) {
                return r(cVar, bVar, obj, z10);
            }
            bc.e eVar = (bc.e) this.f31882c.get(obj.getClass());
            return eVar != null ? s(eVar, bVar, obj, z10) : obj instanceof ec.a ? b(bVar, ((ec.a) obj).getNumber()) : obj instanceof Enum ? b(bVar, ((Enum) obj).ordinal()) : r(this.f31883d, bVar, obj, z10);
        }
        byte[] bArr = (byte[]) obj;
        if (z10 && bArr.length == 0) {
            return this;
        }
        x((v(bVar) << 3) | 2);
        x(bArr.length);
        this.f31880a.write(bArr);
        return this;
    }

    @Override // bc.d
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public d b(bc.b bVar, int i11) {
        return k(bVar, i11, true);
    }

    d k(bc.b bVar, int i11, boolean z10) {
        if (z10 && i11 == 0) {
            return this;
        }
        Protobuf u11 = u(bVar);
        int i12 = a.f31885a[u11.intEncoding().ordinal()];
        if (i12 == 1) {
            x(u11.tag() << 3);
            x(i11);
        } else if (i12 == 2) {
            x(u11.tag() << 3);
            x((i11 << 1) ^ (i11 >> 31));
        } else if (i12 == 3) {
            x((u11.tag() << 3) | 5);
            this.f31880a.write(p(4).putInt(i11).array());
        }
        return this;
    }

    @Override // bc.d
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public d a(bc.b bVar, long j11) {
        return m(bVar, j11, true);
    }

    d m(bc.b bVar, long j11, boolean z10) {
        if (z10 && j11 == 0) {
            return this;
        }
        Protobuf u11 = u(bVar);
        int i11 = a.f31885a[u11.intEncoding().ordinal()];
        if (i11 == 1) {
            x(u11.tag() << 3);
            y(j11);
        } else if (i11 == 2) {
            x(u11.tag() << 3);
            y((j11 >> 63) ^ (j11 << 1));
        } else if (i11 == 3) {
            x((u11.tag() << 3) | 1);
            this.f31880a.write(p(8).putLong(j11).array());
        }
        return this;
    }

    @Override // bc.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public d d(bc.b bVar, boolean z10) {
        return o(bVar, z10, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d o(bc.b bVar, boolean z10, boolean z11) {
        return k(bVar, z10 ? 1 : 0, z11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d t(Object obj) {
        if (obj == null) {
            return this;
        }
        bc.c cVar = (bc.c) this.f31881b.get(obj.getClass());
        if (cVar != null) {
            cVar.a(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for " + obj.getClass());
    }
}
