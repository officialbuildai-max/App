package z4;

import com.alibaba.fastjson.JSONException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import y4.a;

/* loaded from: classes3.dex */
public class f extends l {

    /* renamed from: c, reason: collision with root package name */
    protected b2 f79347c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f79348d;

    public f(y4.h hVar, Class cls, com.alibaba.fastjson.util.d dVar) {
        super(cls, dVar);
        boolean z10 = false;
        this.f79348d = false;
        x4.b e11 = dVar.e();
        if (e11 != null) {
            Class deserializeUsing = e11.deserializeUsing();
            if (deserializeUsing != null && deserializeUsing != Void.class) {
                z10 = true;
            }
            this.f79348d = z10;
        }
    }

    @Override // z4.l
    public int b() {
        b2 b2Var = this.f79347c;
        if (b2Var != null) {
            return b2Var.b();
        }
        return 2;
    }

    @Override // z4.l
    public void d(y4.a aVar, Object obj, Type type, Map map) {
        Object e11;
        com.alibaba.fastjson.util.d dVar;
        int i11;
        if (this.f79347c == null) {
            k(aVar.m());
        }
        b2 b2Var = this.f79347c;
        Type type2 = this.f79366a.f18284f;
        if (type instanceof ParameterizedType) {
            y4.g n11 = aVar.n();
            if (n11 != null) {
                n11.f78993e = type;
            }
            if (type2 != type) {
                type2 = com.alibaba.fastjson.util.d.i(this.f79367b, type, type2);
                if (b2Var instanceof p) {
                    b2Var = aVar.m().p(type2);
                }
            }
        }
        Type type3 = type2;
        if (!(b2Var instanceof o) || (i11 = (dVar = this.f79366a).f18288j) == 0) {
            com.alibaba.fastjson.util.d dVar2 = this.f79366a;
            String str = dVar2.f18298t;
            e11 = (!(str == null && dVar2.f18288j == 0) && (b2Var instanceof e)) ? ((e) b2Var).e(aVar, type3, dVar2.f18279a, str, dVar2.f18288j) : b2Var.c(aVar, type3, dVar2.f18279a);
        } else {
            e11 = ((o) b2Var).g(aVar, type3, dVar.f18279a, i11);
        }
        if ((e11 instanceof byte[]) && ("gzip".equals(this.f79366a.f18298t) || "gzip,base64".equals(this.f79366a.f18298t))) {
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream((byte[]) e11));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    byte[] bArr = new byte[1024];
                    int read = gZIPInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else if (read > 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
                e11 = byteArrayOutputStream.toByteArray();
            } catch (IOException e12) {
                throw new JSONException("unzip bytes error.", e12);
            }
        }
        if (aVar.u() == 1) {
            a.C0994a r11 = aVar.r();
            r11.f78966c = this;
            r11.f78967d = aVar.n();
            aVar.E0(0);
            return;
        }
        if (obj == null) {
            map.put(this.f79366a.f18279a, e11);
        } else {
            h(obj, e11);
        }
    }

    public b2 k(y4.h hVar) {
        if (this.f79347c == null) {
            x4.b e11 = this.f79366a.e();
            if (e11 == null || e11.deserializeUsing() == Void.class) {
                com.alibaba.fastjson.util.d dVar = this.f79366a;
                this.f79347c = hVar.o(dVar.f18283e, dVar.f18284f);
            } else {
                try {
                    this.f79347c = (b2) e11.deserializeUsing().newInstance();
                } catch (Exception e12) {
                    throw new JSONException("create deserializeUsing ObjectDeserializer error", e12);
                }
            }
        }
        return this.f79347c;
    }
}
