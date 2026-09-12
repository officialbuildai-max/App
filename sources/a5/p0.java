package a5;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class p0 extends i1 implements z0 {

    /* renamed from: j, reason: collision with root package name */
    protected final g0[] f384j;

    /* renamed from: k, reason: collision with root package name */
    protected final g0[] f385k;

    /* renamed from: l, reason: collision with root package name */
    protected final f1 f386l;

    /* renamed from: m, reason: collision with root package name */
    private volatile transient long[] f387m;

    /* renamed from: n, reason: collision with root package name */
    private volatile transient short[] f388n;

    public p0(f1 f1Var) {
        g0[] g0VarArr;
        this.f386l = f1Var;
        this.f385k = new g0[f1Var.f279f.length];
        int i11 = 0;
        while (true) {
            g0VarArr = this.f385k;
            if (i11 >= g0VarArr.length) {
                break;
            }
            g0VarArr[i11] = new g0(f1Var.f274a, f1Var.f279f[i11]);
            i11++;
        }
        com.alibaba.fastjson.util.d[] dVarArr = f1Var.f278e;
        if (dVarArr == f1Var.f279f) {
            this.f384j = g0VarArr;
        } else {
            this.f384j = new g0[dVarArr.length];
            int i12 = 0;
            while (true) {
                if (i12 >= this.f384j.length) {
                    break;
                }
                g0 m11 = m(f1Var.f278e[i12].f18279a);
                if (m11 == null) {
                    g0[] g0VarArr2 = this.f385k;
                    System.arraycopy(g0VarArr2, 0, this.f384j, 0, g0VarArr2.length);
                    break;
                } else {
                    this.f384j[i12] = m11;
                    i12++;
                }
            }
        }
        x4.d dVar = f1Var.f277d;
        if (dVar != null) {
            for (Class cls : dVar.serialzeFilters()) {
                try {
                    b((h1) cls.getConstructor(null).newInstance(null));
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        t(o0Var, obj, obj2, type, i11, false);
    }

    protected boolean j(o0 o0Var, String str) {
        List list = o0Var.f327g;
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                throw null;
            }
        }
        List list2 = this.f327g;
        if (list2 == null) {
            return true;
        }
        Iterator it2 = list2.iterator();
        if (!it2.hasNext()) {
            return true;
        }
        android.support.v4.media.session.c.a(it2.next());
        throw null;
    }

    public Set k(Object obj) {
        HashSet hashSet = new HashSet();
        for (g0 g0Var : this.f385k) {
            if (g0Var.d(obj) != null) {
                hashSet.add(g0Var.f281a.f18279a);
            }
        }
        return hashSet;
    }

    public g0 l(long j11) {
        PropertyNamingStrategy[] propertyNamingStrategyArr;
        int binarySearch;
        if (this.f387m == null) {
            propertyNamingStrategyArr = PropertyNamingStrategy.values();
            long[] jArr = new long[this.f385k.length * propertyNamingStrategyArr.length];
            int i11 = 0;
            int i12 = 0;
            while (true) {
                g0[] g0VarArr = this.f385k;
                if (i11 >= g0VarArr.length) {
                    break;
                }
                String str = g0VarArr[i11].f281a.f18279a;
                jArr[i12] = TypeUtils.J(str);
                i12++;
                for (PropertyNamingStrategy propertyNamingStrategy : propertyNamingStrategyArr) {
                    String translate = propertyNamingStrategy.translate(str);
                    if (!str.equals(translate)) {
                        jArr[i12] = TypeUtils.J(translate);
                        i12++;
                    }
                }
                i11++;
            }
            Arrays.sort(jArr, 0, i12);
            this.f387m = new long[i12];
            System.arraycopy(jArr, 0, this.f387m, 0, i12);
        } else {
            propertyNamingStrategyArr = null;
        }
        int binarySearch2 = Arrays.binarySearch(this.f387m, j11);
        if (binarySearch2 < 0) {
            return null;
        }
        if (this.f388n == null) {
            if (propertyNamingStrategyArr == null) {
                propertyNamingStrategyArr = PropertyNamingStrategy.values();
            }
            short[] sArr = new short[this.f387m.length];
            Arrays.fill(sArr, (short) -1);
            int i13 = 0;
            while (true) {
                g0[] g0VarArr2 = this.f385k;
                if (i13 >= g0VarArr2.length) {
                    break;
                }
                String str2 = g0VarArr2[i13].f281a.f18279a;
                int binarySearch3 = Arrays.binarySearch(this.f387m, TypeUtils.J(str2));
                if (binarySearch3 >= 0) {
                    sArr[binarySearch3] = (short) i13;
                }
                for (PropertyNamingStrategy propertyNamingStrategy2 : propertyNamingStrategyArr) {
                    String translate2 = propertyNamingStrategy2.translate(str2);
                    if (!str2.equals(translate2) && (binarySearch = Arrays.binarySearch(this.f387m, TypeUtils.J(translate2))) >= 0) {
                        sArr[binarySearch] = (short) i13;
                    }
                }
                i13++;
            }
            this.f388n = sArr;
        }
        short s11 = this.f388n[binarySearch2];
        if (s11 != -1) {
            return this.f385k[s11];
        }
        return null;
    }

    public g0 m(String str) {
        if (str == null) {
            return null;
        }
        int length = this.f385k.length - 1;
        int i11 = 0;
        while (i11 <= length) {
            int i12 = (i11 + length) >>> 1;
            int compareTo = this.f385k[i12].f281a.f18279a.compareTo(str);
            if (compareTo < 0) {
                i11 = i12 + 1;
            } else {
                if (compareTo <= 0) {
                    return this.f385k[i12];
                }
                length = i12 - 1;
            }
        }
        return null;
    }

    public Object n(Object obj, String str, long j11, boolean z10) {
        g0 l11 = l(j11);
        if (l11 == null) {
            if (!z10) {
                return null;
            }
            throw new JSONException("field not found. " + str);
        }
        try {
            return l11.b(obj);
        } catch (IllegalAccessException e11) {
            throw new JSONException("getFieldValue error." + str, e11);
        } catch (InvocationTargetException e12) {
            throw new JSONException("getFieldValue error." + str, e12);
        }
    }

    public List o(Object obj) {
        ArrayList arrayList = new ArrayList(this.f385k.length);
        for (g0 g0Var : this.f385k) {
            arrayList.add(g0Var.b(obj));
        }
        return arrayList;
    }

    public Map p(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f385k.length);
        for (g0 g0Var : this.f385k) {
            boolean isEnabled = SerializerFeature.isEnabled(g0Var.f283c, SerializerFeature.SkipTransientField);
            com.alibaba.fastjson.util.d dVar = g0Var.f281a;
            if (!isEnabled || dVar == null || !dVar.f18293o) {
                if (dVar.f18297s) {
                    Object json = com.alibaba.fastjson.a.toJSON(g0Var.b(obj));
                    if (json instanceof Map) {
                        linkedHashMap.putAll((Map) json);
                    } else {
                        linkedHashMap.put(g0Var.f281a.f18279a, g0Var.b(obj));
                    }
                } else {
                    linkedHashMap.put(dVar.f18279a, g0Var.b(obj));
                }
            }
        }
        return linkedHashMap;
    }

    public x4.d q() {
        return this.f386l.f277d;
    }

    public int r(Object obj) {
        int i11 = 0;
        for (g0 g0Var : this.f385k) {
            if (g0Var.d(obj) != null) {
                i11++;
            }
        }
        return i11;
    }

    protected boolean s(o0 o0Var, int i11) {
        int i12 = SerializerFeature.BeanToArray.mask;
        return ((this.f386l.f280g & i12) == 0 && !o0Var.f371k.f350i && (i11 & i12) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x02db, code lost:
    
        if ((r31.f386l.f280g & r4) == 0) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x00f7, code lost:
    
        if (r11.f18293o != false) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0473 A[Catch: all -> 0x03ab, Exception -> 0x03ae, TryCatch #1 {Exception -> 0x03ae, blocks: (B:238:0x03a4, B:240:0x046f, B:242:0x0473, B:244:0x0477, B:247:0x0480, B:249:0x0488, B:250:0x0490, B:252:0x0496, B:298:0x03b9, B:299:0x03bc, B:301:0x03c2, B:303:0x03ce, B:307:0x03e4, B:313:0x03f2, B:315:0x0402, B:318:0x040a, B:321:0x0414, B:323:0x041c, B:324:0x0425, B:326:0x042e, B:328:0x0435, B:329:0x0439, B:331:0x043c, B:332:0x0440, B:333:0x0444, B:335:0x0449, B:336:0x044d, B:337:0x0451, B:339:0x0455, B:341:0x0459, B:344:0x0468, B:345:0x046c, B:346:0x03fb), top: B:237:0x03a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0480 A[Catch: all -> 0x03ab, Exception -> 0x03ae, TryCatch #1 {Exception -> 0x03ae, blocks: (B:238:0x03a4, B:240:0x046f, B:242:0x0473, B:244:0x0477, B:247:0x0480, B:249:0x0488, B:250:0x0490, B:252:0x0496, B:298:0x03b9, B:299:0x03bc, B:301:0x03c2, B:303:0x03ce, B:307:0x03e4, B:313:0x03f2, B:315:0x0402, B:318:0x040a, B:321:0x0414, B:323:0x041c, B:324:0x0425, B:326:0x042e, B:328:0x0435, B:329:0x0439, B:331:0x043c, B:332:0x0440, B:333:0x0444, B:335:0x0449, B:336:0x044d, B:337:0x0451, B:339:0x0455, B:341:0x0459, B:344:0x0468, B:345:0x046c, B:346:0x03fb), top: B:237:0x03a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x053d A[Catch: all -> 0x0550, TRY_ENTER, TryCatch #9 {all -> 0x0550, blocks: (B:264:0x0519, B:267:0x053d, B:268:0x058d, B:270:0x0593, B:271:0x05ab, B:273:0x05af, B:276:0x05b8, B:277:0x05bd, B:281:0x0554, B:283:0x0558, B:285:0x055c, B:286:0x0577), top: B:263:0x0519 }] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0593 A[Catch: all -> 0x0550, TryCatch #9 {all -> 0x0550, blocks: (B:264:0x0519, B:267:0x053d, B:268:0x058d, B:270:0x0593, B:271:0x05ab, B:273:0x05af, B:276:0x05b8, B:277:0x05bd, B:281:0x0554, B:283:0x0558, B:285:0x055c, B:286:0x0577), top: B:263:0x0519 }] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x05af A[Catch: all -> 0x0550, TryCatch #9 {all -> 0x0550, blocks: (B:264:0x0519, B:267:0x053d, B:268:0x058d, B:270:0x0593, B:271:0x05ab, B:273:0x05af, B:276:0x05b8, B:277:0x05bd, B:281:0x0554, B:283:0x0558, B:285:0x055c, B:286:0x0577), top: B:263:0x0519 }] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x05b6  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0402 A[Catch: all -> 0x03ab, Exception -> 0x03ae, TryCatch #1 {Exception -> 0x03ae, blocks: (B:238:0x03a4, B:240:0x046f, B:242:0x0473, B:244:0x0477, B:247:0x0480, B:249:0x0488, B:250:0x0490, B:252:0x0496, B:298:0x03b9, B:299:0x03bc, B:301:0x03c2, B:303:0x03ce, B:307:0x03e4, B:313:0x03f2, B:315:0x0402, B:318:0x040a, B:321:0x0414, B:323:0x041c, B:324:0x0425, B:326:0x042e, B:328:0x0435, B:329:0x0439, B:331:0x043c, B:332:0x0440, B:333:0x0444, B:335:0x0449, B:336:0x044d, B:337:0x0451, B:339:0x0455, B:341:0x0459, B:344:0x0468, B:345:0x046c, B:346:0x03fb), top: B:237:0x03a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x046c A[Catch: all -> 0x03ab, Exception -> 0x03ae, TryCatch #1 {Exception -> 0x03ae, blocks: (B:238:0x03a4, B:240:0x046f, B:242:0x0473, B:244:0x0477, B:247:0x0480, B:249:0x0488, B:250:0x0490, B:252:0x0496, B:298:0x03b9, B:299:0x03bc, B:301:0x03c2, B:303:0x03ce, B:307:0x03e4, B:313:0x03f2, B:315:0x0402, B:318:0x040a, B:321:0x0414, B:323:0x041c, B:324:0x0425, B:326:0x042e, B:328:0x0435, B:329:0x0439, B:331:0x043c, B:332:0x0440, B:333:0x0444, B:335:0x0449, B:336:0x044d, B:337:0x0451, B:339:0x0455, B:341:0x0459, B:344:0x0468, B:345:0x046c, B:346:0x03fb), top: B:237:0x03a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x050b A[Catch: all -> 0x03ab, Exception -> 0x0506, TRY_LEAVE, TryCatch #7 {all -> 0x03ab, blocks: (B:238:0x03a4, B:240:0x046f, B:242:0x0473, B:244:0x0477, B:247:0x0480, B:249:0x0488, B:250:0x0490, B:252:0x0496, B:298:0x03b9, B:299:0x03bc, B:301:0x03c2, B:303:0x03ce, B:307:0x03e4, B:313:0x03f2, B:315:0x0402, B:318:0x040a, B:321:0x0414, B:323:0x041c, B:324:0x0425, B:326:0x042e, B:328:0x0435, B:329:0x0439, B:331:0x043c, B:332:0x0440, B:333:0x0444, B:335:0x0449, B:336:0x044d, B:337:0x0451, B:339:0x0455, B:341:0x0459, B:344:0x0468, B:345:0x046c, B:346:0x03fb, B:381:0x04ae, B:415:0x04ef, B:417:0x04f7, B:419:0x04ff, B:421:0x050b), top: B:237:0x03a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:435:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void t(a5.o0 r32, java.lang.Object r33, java.lang.Object r34, java.lang.reflect.Type r35, int r36, boolean r37) {
        /*
            Method dump skipped, instructions count: 1473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.p0.t(a5.o0, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    protected char u(o0 o0Var, Object obj, char c11) {
        List list = o0Var.f322b;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c11 = ((i) it.next()).a(o0Var, obj, c11);
            }
        }
        List list2 = this.f322b;
        if (list2 != null) {
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                c11 = ((i) it2.next()).a(o0Var, obj, c11);
            }
        }
        return c11;
    }

    protected char v(o0 o0Var, Object obj, char c11) {
        List list = o0Var.f321a;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c11 = ((q) it.next()).a(o0Var, obj, c11);
            }
        }
        List list2 = this.f321a;
        if (list2 != null) {
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                c11 = ((q) it2.next()).a(o0Var, obj, c11);
            }
        }
        return c11;
    }

    protected void w(o0 o0Var, String str, Object obj) {
        if (str == null) {
            str = o0Var.f370j.f307c;
        }
        o0Var.f371k.x(str, false);
        String str2 = this.f386l.f275b;
        if (str2 == null) {
            Class<?> cls = obj.getClass();
            if (TypeUtils.x0(cls)) {
                cls = cls.getSuperclass();
            }
            str2 = cls.getName();
        }
        o0Var.B(str2);
    }

    public void x(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        t(o0Var, obj, obj2, type, i11, false);
    }

    public boolean y(o0 o0Var, Object obj, int i11) {
        IdentityHashMap identityHashMap;
        e1 e1Var = o0Var.f378r;
        int i12 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (e1Var == null || (e1Var.f272d & i12) != 0 || (i11 & i12) != 0 || (identityHashMap = o0Var.f377q) == null || !identityHashMap.containsKey(obj)) {
            return false;
        }
        o0Var.D(obj);
        return true;
    }
}
