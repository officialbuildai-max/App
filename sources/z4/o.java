package z4;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import y4.h;

/* loaded from: classes3.dex */
public class o implements b2 {

    /* renamed from: a, reason: collision with root package name */
    private final l[] f79370a;

    /* renamed from: b, reason: collision with root package name */
    protected final l[] f79371b;

    /* renamed from: c, reason: collision with root package name */
    protected final Class f79372c;

    /* renamed from: d, reason: collision with root package name */
    public final com.alibaba.fastjson.util.h f79373d;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentMap f79374e;

    /* renamed from: f, reason: collision with root package name */
    private final Map f79375f;

    /* renamed from: g, reason: collision with root package name */
    private Map f79376g;

    /* renamed from: h, reason: collision with root package name */
    private transient long[] f79377h;

    /* renamed from: i, reason: collision with root package name */
    private transient short[] f79378i;

    public o(y4.h hVar, com.alibaba.fastjson.util.h hVar2) {
        this.f79372c = hVar2.f18324a;
        this.f79373d = hVar2;
        x4.d dVar = hVar2.f18334k;
        if (dVar != null && dVar.autoTypeCheckHandler() != h.c.class) {
            try {
                android.support.v4.media.session.c.a(hVar2.f18334k.autoTypeCheckHandler().newInstance());
            } catch (Exception unused) {
            }
        }
        com.alibaba.fastjson.util.d[] dVarArr = hVar2.f18332i;
        this.f79371b = new l[dVarArr.length];
        int length = dVarArr.length;
        HashMap hashMap = null;
        for (int i11 = 0; i11 < length; i11++) {
            com.alibaba.fastjson.util.d dVar2 = hVar2.f18332i[i11];
            l k11 = hVar.k(hVar, hVar2, dVar2);
            this.f79371b[i11] = k11;
            if (length > 128) {
                if (this.f79376g == null) {
                    this.f79376g = new HashMap();
                }
                this.f79376g.put(dVar2.f18279a, k11);
            }
            for (String str : dVar2.f18299u) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, k11);
            }
        }
        this.f79375f = hashMap;
        com.alibaba.fastjson.util.d[] dVarArr2 = hVar2.f18331h;
        this.f79370a = new l[dVarArr2.length];
        int length2 = dVarArr2.length;
        for (int i12 = 0; i12 < length2; i12++) {
            this.f79370a[i12] = j(hVar2.f18331h[i12].f18279a);
        }
    }

    public o(y4.h hVar, Class cls, Type type) {
        this(hVar, com.alibaba.fastjson.util.h.c(cls, type, hVar.f79007f, hVar.f79014m, hVar.f79016o, hVar.v()));
    }

    private Object d(y4.h hVar, Object obj) {
        return this.f79373d.f18328e.invoke(null, obj);
    }

    protected static o l(y4.h hVar, com.alibaba.fastjson.util.h hVar2, String str) {
        x4.d dVar = hVar2.f18334k;
        if (dVar == null) {
            return null;
        }
        for (Class cls : dVar.seeAlso()) {
            b2 p11 = hVar.p(cls);
            if (p11 instanceof o) {
                o oVar = (o) p11;
                com.alibaba.fastjson.util.h hVar3 = oVar.f79373d;
                if (hVar3.f18335l.equals(str)) {
                    return oVar;
                }
                o l11 = l(hVar, hVar3, str);
                if (l11 != null) {
                    return l11;
                }
            }
        }
        return null;
    }

    static boolean m(int i11, int[] iArr) {
        int i12;
        if (iArr != null && (i12 = i11 / 32) < iArr.length) {
            return ((1 << (i11 % 32)) & iArr[i12]) != 0;
        }
        return false;
    }

    protected void a(y4.b bVar, int i11) {
        if (bVar.q0() != i11) {
            throw new JSONException("syntax error");
        }
    }

    @Override // z4.b2
    public int b() {
        return 12;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        return g(aVar, type, obj, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x00b0, code lost:
    
        r7.setLong(r0, ((java.lang.Number) r1).longValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x009b, code lost:
    
        if ((r1 instanceof java.lang.Number) == false) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x009d, code lost:
    
        r7.setInt(r0, ((java.lang.Number) r1).intValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0087, code lost:
    
        if (r1 != java.lang.Boolean.FALSE) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x008f, code lost:
    
        if (r1 != java.lang.Boolean.TRUE) goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0091, code lost:
    
        r7.setBoolean(r0, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0089, code lost:
    
        r7.setBoolean(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0067, code lost:
    
        if (com.alibaba.fastjson.JSONValidator.m(r6).q() != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007b, code lost:
    
        if (r6.f18280b != null) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007d, code lost:
    
        r9 = r7.getType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0083, code lost:
    
        if (r9 != java.lang.Boolean.TYPE) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0097, code lost:
    
        if (r9 != java.lang.Integer.TYPE) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00aa, code lost:
    
        if (r9 != java.lang.Long.TYPE) goto L226;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bf, code lost:
    
        if (r9 != java.lang.Float.TYPE) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ec, code lost:
    
        if (r9 != java.lang.Double.TYPE) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0117, code lost:
    
        if (r1 == null) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x011d, code lost:
    
        if (r8 != r1.getClass()) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x011f, code lost:
    
        r7.set(r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f0, code lost:
    
        if ((r1 instanceof java.lang.Number) == false) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f2, code lost:
    
        r7.setDouble(r0, ((java.lang.Number) r1).doubleValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ff, code lost:
    
        if ((r1 instanceof java.lang.String) == false) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0101, code lost:
    
        r1 = (java.lang.String) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0107, code lost:
    
        if (r1.length() > 10) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0109, code lost:
    
        r5 = com.alibaba.fastjson.util.TypeUtils.K0(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0112, code lost:
    
        r7.setDouble(r0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x010e, code lost:
    
        r5 = java.lang.Double.parseDouble(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00c3, code lost:
    
        if ((r1 instanceof java.lang.Number) == false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00c5, code lost:
    
        r7.setFloat(r0, ((java.lang.Number) r1).floatValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00d2, code lost:
    
        if ((r1 instanceof java.lang.String) == false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00d4, code lost:
    
        r1 = (java.lang.String) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00da, code lost:
    
        if (r1.length() > 10) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00dc, code lost:
    
        r1 = com.alibaba.fastjson.util.TypeUtils.L0(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00e5, code lost:
    
        r7.setFloat(r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00e1, code lost:
    
        r1 = java.lang.Float.parseFloat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00ae, code lost:
    
        if ((r1 instanceof java.lang.Number) == false) goto L227;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(java.util.Map r13, y4.h r14) {
        /*
            Method dump skipped, instructions count: 758
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.o.e(java.util.Map, y4.h):java.lang.Object");
    }

    public Object f(y4.a aVar, Type type) {
        Object newInstance;
        if ((type instanceof Class) && this.f79372c.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
        com.alibaba.fastjson.util.h hVar = this.f79373d;
        Constructor constructor = hVar.f18326c;
        Object obj = null;
        if (constructor == null && hVar.f18328e == null) {
            return null;
        }
        Method method = hVar.f18328e;
        if (method != null && hVar.f18330g > 0) {
            return null;
        }
        try {
            if (hVar.f18330g == 0) {
                newInstance = constructor != null ? constructor.newInstance(null) : method.invoke(null, null);
            } else {
                y4.g n11 = aVar.n();
                if (n11 == null || n11.f78989a == null) {
                    throw new JSONException("can't create non-static inner class instance.");
                }
                if (!(type instanceof Class)) {
                    throw new JSONException("can't create non-static inner class instance.");
                }
                String name = ((Class) type).getName();
                String substring = name.substring(0, name.lastIndexOf(36));
                Object obj2 = n11.f78989a;
                String name2 = obj2.getClass().getName();
                if (!name2.equals(substring)) {
                    y4.g gVar = n11.f78990b;
                    if (gVar == null || gVar.f78989a == null || !("java.util.ArrayList".equals(name2) || "java.util.List".equals(name2) || "java.util.Collection".equals(name2) || "java.util.Map".equals(name2) || "java.util.HashMap".equals(name2))) {
                        obj = obj2;
                    } else if (gVar.f78989a.getClass().getName().equals(substring)) {
                        obj = gVar.f78989a;
                    }
                    obj2 = obj;
                }
                if (obj2 == null || ((obj2 instanceof Collection) && ((Collection) obj2).isEmpty())) {
                    throw new JSONException("can't create non-static inner class instance.");
                }
                newInstance = constructor.newInstance(obj2);
            }
            if (aVar != null && aVar.f78954f.n(Feature.InitStringFieldAsEmpty)) {
                for (com.alibaba.fastjson.util.d dVar : this.f79373d.f18331h) {
                    if (dVar.f18283e == String.class) {
                        try {
                            dVar.o(newInstance, "");
                        } catch (Exception e11) {
                            throw new JSONException("create instance error, class " + this.f79372c.getName(), e11);
                        }
                    }
                }
            }
            return newInstance;
        } catch (JSONException e12) {
            throw e12;
        } catch (Exception e13) {
            throw new JSONException("create instance error, class " + this.f79372c.getName(), e13);
        }
    }

    public Object g(y4.a aVar, Type type, Object obj, int i11) {
        return h(aVar, type, obj, null, i11, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x03aa, code lost:
    
        if (r11.n(com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas) != false) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x050c, code lost:
    
        r2 = r1.c(r34, r2, r36);
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0512, code lost:
    
        if ((r1 instanceof z4.o) == false) goto L394;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0514, code lost:
    
        r1 = (z4.o) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0516, code lost:
    
        if (r14 == null) goto L394;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0518, code lost:
    
        r1 = r1.j(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x051c, code lost:
    
        if (r1 == null) goto L394;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x051e, code lost:
    
        r1.i(r2, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0521, code lost:
    
        if (r4 == null) goto L396;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0523, code lost:
    
        r4.f78989a = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0527, code lost:
    
        r34.B0(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x052a, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x039c, code lost:
    
        r5 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x053b, code lost:
    
        r29 = r5;
        r0 = r17;
        r13 = r30;
        r39 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x06dc, code lost:
    
        if (r29 != null) goto L646;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x08e8, code lost:
    
        r1 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x08ea, code lost:
    
        r0 = r33.f79373d.f18329f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x08ee, code lost:
    
        if (r0 != null) goto L653;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x08f0, code lost:
    
        if (r4 == null) goto L651;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x08f2, code lost:
    
        r4.f78989a = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x08f4, code lost:
    
        r34.B0(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x08f7, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x08f9, code lost:
    
        r0 = r0.invoke(r1, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x08fd, code lost:
    
        if (r4 == null) goto L657;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x08ff, code lost:
    
        r4.f78989a = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0901, code lost:
    
        r34.B0(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0904, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0905, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x090e, code lost:
    
        throw new com.alibaba.fastjson.JSONException("build object error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x06de, code lost:
    
        if (r0 != null) goto L504;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x06e0, code lost:
    
        r1 = f(r34, r35);
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x06e4, code lost:
    
        if (r4 != null) goto L498;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x06e6, code lost:
    
        r4 = r34.z0(r15, r1, r36);
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x06ea, code lost:
    
        if (r4 == null) goto L500;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x06ec, code lost:
    
        r4.f78989a = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x06ee, code lost:
    
        r34.B0(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x06f1, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x06f5, code lost:
    
        r1 = r33.f79373d;
        r2 = r1.f18339p;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x06fb, code lost:
    
        if (r2 == null) goto L554;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x06fd, code lost:
    
        r1 = new java.lang.Object[r2.length];
        r5 = r39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0703, code lost:
    
        if (r5 >= r2.length) goto L736;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x0705, code lost:
    
        r6 = r0.remove(r2[r5]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x070b, code lost:
    
        if (r6 != null) goto L538;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x070d, code lost:
    
        r7 = r33.f79373d;
        r10 = r7.f18338o[r5];
        r7 = r7.f18331h[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x0719, code lost:
    
        if (r10 != java.lang.Byte.TYPE) goto L515;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x071b, code lost:
    
        r6 = java.lang.Byte.valueOf(r39);
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0760, code lost:
    
        r11 = r39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x0798, code lost:
    
        r1[r5] = r6;
        r5 = r5 + 1;
        r39 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x0722, code lost:
    
        if (r10 != java.lang.Short.TYPE) goto L518;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x0724, code lost:
    
        r6 = java.lang.Short.valueOf(r39);
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x072b, code lost:
    
        if (r10 != java.lang.Integer.TYPE) goto L521;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x072d, code lost:
    
        r6 = java.lang.Integer.valueOf(r39);
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x0734, code lost:
    
        if (r10 != java.lang.Long.TYPE) goto L524;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x0736, code lost:
    
        r6 = 0L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x073d, code lost:
    
        if (r10 != java.lang.Float.TYPE) goto L527;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x073f, code lost:
    
        r6 = java.lang.Float.valueOf(0.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x0746, code lost:
    
        if (r10 != java.lang.Double.TYPE) goto L530;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x0748, code lost:
    
        r6 = java.lang.Double.valueOf(0.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x074f, code lost:
    
        if (r10 != java.lang.Boolean.TYPE) goto L533;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0751, code lost:
    
        r6 = java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x0754, code lost:
    
        if (r10 != r13) goto L537;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x075d, code lost:
    
        if ((r7.f18288j & com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty.mask) == 0) goto L537;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x075f, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x0763, code lost:
    
        r7 = r33.f79373d.f18338o;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x0767, code lost:
    
        if (r7 == null) goto L537;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x076a, code lost:
    
        if (r5 >= r7.length) goto L537;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x076c, code lost:
    
        r7 = r7[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x0770, code lost:
    
        if ((r7 instanceof java.lang.Class) == false) goto L537;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x0772, code lost:
    
        r7 = (java.lang.Class) r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x0778, code lost:
    
        if (r7.isInstance(r6) != false) goto L537;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x077c, code lost:
    
        if ((r6 instanceof java.util.List) == false) goto L537;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x077e, code lost:
    
        r10 = (java.util.List) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x0786, code lost:
    
        if (r10.size() != 1) goto L537;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x0788, code lost:
    
        r11 = r39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x0792, code lost:
    
        if (r7.isInstance(r10.get(r11)) == false) goto L739;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0794, code lost:
    
        r6 = r10.get(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0809, code lost:
    
        r3 = r33.f79373d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x080d, code lost:
    
        if (r3.f18327d == null) goto L634;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x0811, code lost:
    
        if (r3.f18340q == false) goto L623;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x0813, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x0815, code lost:
    
        if (r3 >= r1.length) goto L741;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0819, code lost:
    
        if (r1[r3] != null) goto L742;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x081b, code lost:
    
        r5 = r33.f79373d;
        r6 = r5.f18331h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x081f, code lost:
    
        if (r6 == null) goto L743;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0822, code lost:
    
        if (r3 >= r6.length) goto L744;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x0828, code lost:
    
        if (r6[r3].f18283e != r13) goto L623;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x082a, code lost:
    
        r3 = r5.f18341r;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x082c, code lost:
    
        if (r3 == null) goto L623;
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x082e, code lost:
    
        r3 = r3.newInstance(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x0833, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x0835, code lost:
    
        if (r5 >= r1.length) goto L745;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0837, code lost:
    
        r6 = r1[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x0839, code lost:
    
        if (r6 == null) goto L746;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x083b, code lost:
    
        r7 = r33.f79373d.f18331h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x083f, code lost:
    
        if (r7 == null) goto L747;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x0842, code lost:
    
        if (r5 >= r7.length) goto L748;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0844, code lost:
    
        r7[r5].o(r3, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0850, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x0853, code lost:
    
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x0864, code lost:
    
        if (r2 == null) goto L644;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0866, code lost:
    
        r0 = r0.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x0872, code lost:
    
        if (r0.hasNext() == false) goto L750;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x0874, code lost:
    
        r2 = (java.util.Map.Entry) r0.next();
        r3 = j((java.lang.String) r2.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x0884, code lost:
    
        if (r3 == null) goto L753;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x0886, code lost:
    
        r3.h(r1, r2.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x08e3, code lost:
    
        if (r4 == null) goto L647;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x08e5, code lost:
    
        r4.f78989a = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x084e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x08b4, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error, " + r2 + ", " + r33.f79373d.f18327d.toGenericString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x084a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x084b, code lost:
    
        r5 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x0855, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x0856, code lost:
    
        r3 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x0859, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x085c, code lost:
    
        r1 = r33.f79373d.f18327d.newInstance(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x08b5, code lost:
    
        r0 = r3.f18328e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x08b7, code lost:
    
        if (r0 == null) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x08be, code lost:
    
        r1 = r0.invoke(null, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x08c0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x08e0, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create factory method error, " + r33.f79373d.f18328e.toString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x08e1, code lost:
    
        r1 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x07a0, code lost:
    
        r1 = r1.f18331h;
        r5 = r1.length;
        r6 = new java.lang.Object[r5];
        r7 = r39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x07a8, code lost:
    
        if (r7 >= r5) goto L755;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x07aa, code lost:
    
        r10 = r1[r7];
        r12 = r0.get(r10.f18279a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x07b2, code lost:
    
        if (r12 != null) goto L757;
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x07b4, code lost:
    
        r14 = r10.f18284f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x07b8, code lost:
    
        if (r14 != java.lang.Byte.TYPE) goto L561;
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x07ba, code lost:
    
        r12 = (byte) 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x0802, code lost:
    
        r6[r7] = r12;
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x07c2, code lost:
    
        if (r14 != java.lang.Short.TYPE) goto L564;
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x07c4, code lost:
    
        r12 = (short) 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x07cc, code lost:
    
        if (r14 != java.lang.Integer.TYPE) goto L567;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x07ce, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x07d6, code lost:
    
        if (r14 != java.lang.Long.TYPE) goto L570;
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x07d8, code lost:
    
        r12 = 0L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x07df, code lost:
    
        if (r14 != java.lang.Float.TYPE) goto L573;
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x07e1, code lost:
    
        r12 = java.lang.Float.valueOf(0.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x07e8, code lost:
    
        if (r14 != java.lang.Double.TYPE) goto L576;
     */
    /* JADX WARN: Code restructure failed: missing block: B:438:0x07ea, code lost:
    
        r12 = java.lang.Double.valueOf(0.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:441:0x07f1, code lost:
    
        if (r14 != java.lang.Boolean.TYPE) goto L579;
     */
    /* JADX WARN: Code restructure failed: missing block: B:442:0x07f3, code lost:
    
        r12 = java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:444:0x07f6, code lost:
    
        if (r14 != r13) goto L765;
     */
    /* JADX WARN: Code restructure failed: missing block: B:446:0x07ff, code lost:
    
        if ((r10.f18288j & com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty.mask) == 0) goto L766;
     */
    /* JADX WARN: Code restructure failed: missing block: B:447:0x0801, code lost:
    
        r12 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:453:0x0808, code lost:
    
        r1 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:454:0x06f2, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:455:0x06f3, code lost:
    
        r14 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:504:0x0955, code lost:
    
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + y4.f.a(r11.q0()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:508:0x06d8, code lost:
    
        r0 = r20;
        r4 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:592:0x01f3, code lost:
    
        if (r7 == (-2)) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:731:0x0374, code lost:
    
        if (r7 == (-2)) goto L147;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0969  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x0586 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:486:0x05d4  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x06cc  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x06cf A[Catch: all -> 0x06ad, TryCatch #10 {all -> 0x06ad, blocks: (B:144:0x0925, B:490:0x06c4, B:495:0x06cf, B:507:0x06d5, B:498:0x0912, B:500:0x091a, B:503:0x0937, B:504:0x0955, B:551:0x069d, B:553:0x06a3, B:557:0x06a9, B:558:0x06bc, B:561:0x0956, B:562:0x095d), top: B:143:0x0925 }] */
    /* JADX WARN: Removed duplicated region for block: B:518:0x063d A[Catch: all -> 0x05f1, TryCatch #12 {all -> 0x05f1, blocks: (B:489:0x05d8, B:515:0x05f8, B:518:0x063d, B:519:0x064b, B:526:0x0602, B:528:0x0606, B:530:0x060a, B:532:0x060e, B:534:0x0612, B:536:0x0616, B:539:0x061e, B:541:0x0626, B:543:0x062d, B:545:0x0632, B:546:0x0638, B:549:0x0675), top: B:488:0x05d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:521:0x0659  */
    /* JADX WARN: Removed duplicated region for block: B:522:0x0650 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:524:0x064a  */
    /* JADX WARN: Removed duplicated region for block: B:547:0x066d  */
    /* JADX WARN: Removed duplicated region for block: B:578:0x0577  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.Object h(y4.a r34, java.lang.reflect.Type r35, java.lang.Object r36, java.lang.Object r37, int r38, int[] r39) {
        /*
            Method dump skipped, instructions count: 2420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.o.h(y4.a, java.lang.reflect.Type, java.lang.Object, java.lang.Object, int, int[]):java.lang.Object");
    }

    public Object i(y4.a aVar, Type type, Object obj, Object obj2) {
        y4.b bVar = aVar.f78954f;
        if (bVar.q0() != 14) {
            throw new JSONException("error");
        }
        String m02 = bVar.m0(aVar.f78950b);
        if (m02 != null) {
            b2 l11 = l(aVar.m(), this.f79373d, m02);
            if (l11 == null) {
                l11 = aVar.m().p(aVar.m().j(m02, TypeUtils.Q(type), bVar.r()));
            }
            if (l11 instanceof o) {
                return ((o) l11).i(aVar, type, obj, obj2);
            }
        }
        Object f11 = f(aVar, type);
        int length = this.f79371b.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            }
            char c11 = i11 == length + (-1) ? ']' : ',';
            l lVar = this.f79371b[i11];
            Class cls = lVar.f79366a.f18283e;
            if (cls == Integer.TYPE) {
                lVar.f(f11, bVar.g0(c11));
            } else if (cls == String.class) {
                lVar.i(f11, bVar.r0(c11));
            } else if (cls == Long.TYPE) {
                lVar.g(f11, bVar.x0(c11));
            } else if (cls.isEnum()) {
                char d11 = bVar.d();
                lVar.h(f11, (d11 == '\"' || d11 == 'n') ? bVar.T(cls, aVar.v(), c11) : (d11 < '0' || d11 > '9') ? o(bVar, c11) : ((h) ((f) lVar).k(aVar.m())).d(bVar.g0(c11)));
            } else if (cls == Boolean.TYPE) {
                lVar.j(f11, bVar.V(c11));
            } else if (cls == Float.TYPE) {
                lVar.h(f11, Float.valueOf(bVar.m(c11)));
            } else if (cls == Double.TYPE) {
                lVar.h(f11, Double.valueOf(bVar.s(c11)));
            } else if (cls == Date.class && bVar.d() == '1') {
                lVar.h(f11, new Date(bVar.x0(c11)));
            } else if (cls == BigDecimal.class) {
                lVar.h(f11, bVar.t(c11));
            } else {
                bVar.c0(14);
                com.alibaba.fastjson.util.d dVar = lVar.f79366a;
                lVar.h(f11, aVar.p0(dVar.f18284f, dVar.f18279a));
                if (bVar.q0() == 15) {
                    break;
                }
                a(bVar, c11 == ']' ? 15 : 16);
            }
            i11++;
        }
        bVar.c0(16);
        return f11;
    }

    public l j(String str) {
        return k(str, null);
    }

    public l k(String str, int[] iArr) {
        l lVar;
        if (str == null) {
            return null;
        }
        Map map = this.f79376g;
        if (map != null && (lVar = (l) map.get(str)) != null) {
            return lVar;
        }
        int length = this.f79371b.length - 1;
        int i11 = 0;
        while (i11 <= length) {
            int i12 = (i11 + length) >>> 1;
            int compareTo = this.f79371b[i12].f79366a.f18279a.compareTo(str);
            if (compareTo < 0) {
                i11 = i12 + 1;
            } else {
                if (compareTo <= 0) {
                    if (m(i12, iArr)) {
                        return null;
                    }
                    return this.f79371b[i12];
                }
                length = i12 - 1;
            }
        }
        Map map2 = this.f79375f;
        if (map2 != null) {
            return (l) map2.get(str);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012d  */
    /* JADX WARN: Type inference failed for: r19v13 */
    /* JADX WARN: Type inference failed for: r19v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r19v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean n(y4.a r22, java.lang.String r23, java.lang.Object r24, java.lang.reflect.Type r25, java.util.Map r26, int[] r27) {
        /*
            Method dump skipped, instructions count: 614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.o.n(y4.a, java.lang.String, java.lang.Object, java.lang.reflect.Type, java.util.Map, int[]):boolean");
    }

    protected Enum o(y4.b bVar, char c11) {
        throw new JSONException("illegal enum. " + bVar.k());
    }

    protected Enum p(y4.c cVar, char[] cArr, b2 b2Var) {
        h hVar = b2Var instanceof h ? (h) b2Var : null;
        if (hVar == null) {
            cVar.f78984n = -1;
            return null;
        }
        long T0 = cVar.T0(cArr);
        if (cVar.f78984n <= 0) {
            return null;
        }
        Enum a11 = hVar.a(T0);
        if (a11 == null) {
            if (T0 == -3750763034362895579L) {
                return null;
            }
            if (cVar.n(Feature.ErrorOnEnumNotMatch)) {
                throw new JSONException("not match enum value, " + hVar.f79352a);
            }
        }
        return a11;
    }

    public l q(String str) {
        return r(str, null);
    }

    public l r(String str, int[] iArr) {
        boolean z10;
        if (str == null) {
            return null;
        }
        l k11 = k(str, iArr);
        if (k11 == null) {
            int i11 = 0;
            if (this.f79377h == null) {
                long[] jArr = new long[this.f79371b.length];
                int i12 = 0;
                while (true) {
                    l[] lVarArr = this.f79371b;
                    if (i12 >= lVarArr.length) {
                        break;
                    }
                    jArr[i12] = lVarArr[i12].f79366a.f18300v;
                    i12++;
                }
                Arrays.sort(jArr);
                this.f79377h = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.f79377h, TypeUtils.L(str));
            if (binarySearch < 0) {
                binarySearch = Arrays.binarySearch(this.f79377h, TypeUtils.K(str));
            }
            if (binarySearch < 0) {
                z10 = str.startsWith("is");
                if (z10) {
                    binarySearch = Arrays.binarySearch(this.f79377h, TypeUtils.K(str.substring(2)));
                }
            } else {
                z10 = false;
            }
            if (binarySearch >= 0) {
                if (this.f79378i == null) {
                    short[] sArr = new short[this.f79377h.length];
                    Arrays.fill(sArr, (short) -1);
                    while (true) {
                        l[] lVarArr2 = this.f79371b;
                        if (i11 >= lVarArr2.length) {
                            break;
                        }
                        int binarySearch2 = Arrays.binarySearch(this.f79377h, lVarArr2[i11].f79366a.f18300v);
                        if (binarySearch2 >= 0) {
                            sArr[binarySearch2] = (short) i11;
                        }
                        i11++;
                    }
                    this.f79378i = sArr;
                }
                short s11 = this.f79378i[binarySearch];
                if (s11 != -1 && !m(s11, iArr)) {
                    k11 = this.f79371b[s11];
                }
            }
            if (k11 != null) {
                com.alibaba.fastjson.util.d dVar = k11.f79366a;
                if ((dVar.f18288j & Feature.DisableFieldSmartMatch.mask) != 0) {
                    return null;
                }
                Class cls = dVar.f18283e;
                if (z10 && cls != Boolean.TYPE && cls != Boolean.class) {
                    return null;
                }
            }
        }
        return k11;
    }
}
