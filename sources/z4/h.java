package z4;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import java.lang.reflect.Type;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class h implements b2 {

    /* renamed from: a, reason: collision with root package name */
    protected final Class f79352a;

    /* renamed from: b, reason: collision with root package name */
    protected final Enum[] f79353b;

    /* renamed from: c, reason: collision with root package name */
    protected final Enum[] f79354c;

    /* renamed from: d, reason: collision with root package name */
    protected long[] f79355d;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(java.lang.Class r22) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.h.<init>(java.lang.Class):void");
    }

    public Enum a(long j11) {
        int binarySearch;
        if (this.f79353b != null && (binarySearch = Arrays.binarySearch(this.f79355d, j11)) >= 0) {
            return this.f79353b[binarySearch];
        }
        return null;
    }

    @Override // z4.b2
    public int b() {
        return 2;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        try {
            y4.b bVar = aVar.f78954f;
            int q02 = bVar.q0();
            if (q02 == 2) {
                int o11 = bVar.o();
                bVar.c0(16);
                if (o11 >= 0) {
                    Enum[] enumArr = this.f79354c;
                    if (o11 < enumArr.length) {
                        return enumArr[o11];
                    }
                }
                throw new JSONException("parse enum " + this.f79352a.getName() + " error, value : " + o11);
            }
            if (q02 != 4) {
                if (q02 == 8) {
                    bVar.c0(16);
                    return null;
                }
                throw new JSONException("parse enum " + this.f79352a.getName() + " error, value : " + aVar.T());
            }
            String k02 = bVar.k0();
            bVar.c0(16);
            if (k02.length() == 0) {
                return null;
            }
            long j11 = -3750763034362895579L;
            long j12 = -3750763034362895579L;
            for (int i11 = 0; i11 < k02.length(); i11++) {
                int charAt = k02.charAt(i11);
                long j13 = j11 ^ charAt;
                if (charAt >= 65 && charAt <= 90) {
                    charAt += 32;
                }
                j11 = j13 * 1099511628211L;
                j12 = (j12 ^ charAt) * 1099511628211L;
            }
            Enum a11 = a(j11);
            if (a11 == null && j12 != j11) {
                a11 = a(j12);
            }
            if (a11 == null && bVar.n(Feature.ErrorOnEnumNotMatch)) {
                throw new JSONException("not match enum value, " + this.f79352a.getName() + " : " + k02);
            }
            return a11;
        } catch (JSONException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new JSONException(e12.getMessage(), e12);
        }
    }

    public Enum d(int i11) {
        return this.f79354c[i11];
    }
}
