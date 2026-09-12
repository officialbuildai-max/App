package a5;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    static final String f241c = com.alibaba.fastjson.util.b.g(o0.class);

    /* renamed from: d, reason: collision with root package name */
    static final String f242d;

    /* renamed from: e, reason: collision with root package name */
    static final String f243e;

    /* renamed from: f, reason: collision with root package name */
    static final String f244f;

    /* renamed from: g, reason: collision with root package name */
    static final String f245g;

    /* renamed from: h, reason: collision with root package name */
    static final String f246h;

    /* renamed from: i, reason: collision with root package name */
    static final String f247i;

    /* renamed from: j, reason: collision with root package name */
    static final String f248j;

    /* renamed from: k, reason: collision with root package name */
    static final String f249k;

    /* renamed from: a, reason: collision with root package name */
    protected final com.alibaba.fastjson.util.a f250a = new com.alibaba.fastjson.util.a();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicLong f251b = new AtomicLong();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a5.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0004a {

        /* renamed from: h, reason: collision with root package name */
        static int f252h = 6;

        /* renamed from: i, reason: collision with root package name */
        static int f253i = 7;

        /* renamed from: j, reason: collision with root package name */
        static int f254j = 8;

        /* renamed from: a, reason: collision with root package name */
        private final com.alibaba.fastjson.util.d[] f255a;

        /* renamed from: b, reason: collision with root package name */
        private final String f256b;

        /* renamed from: c, reason: collision with root package name */
        private final f1 f257c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f258d;

        /* renamed from: e, reason: collision with root package name */
        private Map f259e = new HashMap();

        /* renamed from: f, reason: collision with root package name */
        private int f260f = 9;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f261g;

        public C0004a(com.alibaba.fastjson.util.d[] dVarArr, f1 f1Var, String str, boolean z10, boolean z11) {
            this.f255a = dVarArr;
            this.f256b = str;
            this.f257c = f1Var;
            this.f258d = z10;
            this.f261g = z11 || f1Var.f274a.isEnum();
        }

        public int f(String str) {
            int length = this.f255a.length;
            for (int i11 = 0; i11 < length; i11++) {
                if (this.f255a[i11].f18279a.equals(str)) {
                    return i11;
                }
            }
            return -1;
        }

        public int g(String str) {
            if (((Integer) this.f259e.get(str)) == null) {
                Map map = this.f259e;
                int i11 = this.f260f;
                this.f260f = i11 + 1;
                map.put(str, Integer.valueOf(i11));
            }
            return ((Integer) this.f259e.get(str)).intValue();
        }

        public int h(String str, int i11) {
            if (((Integer) this.f259e.get(str)) == null) {
                this.f259e.put(str, Integer.valueOf(this.f260f));
                this.f260f += i11;
            }
            return ((Integer) this.f259e.get(str)).intValue();
        }
    }

    static {
        String g11 = com.alibaba.fastjson.util.b.g(z0.class);
        f242d = g11;
        f243e = "L" + g11 + ";";
        String g12 = com.alibaba.fastjson.util.b.g(j1.class);
        f244f = g12;
        f245g = "L" + g12 + ";";
        f246h = com.alibaba.fastjson.util.b.g(p0.class);
        f247i = "L" + com.alibaba.fastjson.util.b.g(p0.class) + ";";
        f248j = com.alibaba.fastjson.util.b.b(e1.class);
        f249k = com.alibaba.fastjson.util.b.b(i1.class);
    }

    private void A(Class cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d[] dVarArr, C0004a c0004a) {
        String str;
        int i11;
        int i12;
        String str2;
        String str3;
        char c11;
        boolean z10;
        a aVar;
        char c12;
        String str4;
        int i13;
        Class cls2;
        int i14;
        com.alibaba.fastjson.asm.f fVar;
        com.alibaba.fastjson.asm.f fVar2;
        com.alibaba.fastjson.asm.f fVar3;
        String str5;
        com.alibaba.fastjson.asm.f fVar4;
        int i15;
        int i16;
        String str6;
        int i17;
        com.alibaba.fastjson.asm.f fVar5;
        com.alibaba.fastjson.asm.f fVar6;
        char c13;
        a aVar2 = this;
        com.alibaba.fastjson.util.d[] dVarArr2 = dVarArr;
        com.alibaba.fastjson.asm.f fVar7 = new com.alibaba.fastjson.asm.f();
        hVar.c(25, 1);
        hVar.c(25, 0);
        String str7 = f241c;
        hVar.j(182, str7, "hasPropertyFilters", "(" + f249k + ")Z");
        hVar.a(154, fVar7);
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.c(25, 2);
        hVar.c(25, 3);
        hVar.c(25, 4);
        hVar.c(21, 5);
        String str8 = f246h;
        StringBuilder sb2 = new StringBuilder();
        String str9 = "(L";
        sb2.append("(L");
        sb2.append(str7);
        String str10 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V";
        sb2.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        hVar.j(183, str8, "writeNoneASM", sb2.toString());
        hVar.h(177);
        hVar.l(fVar7);
        String str11 = "out";
        hVar.c(25, c0004a.g("out"));
        hVar.c(16, 91);
        String str12 = f244f;
        String str13 = "(I)V";
        hVar.j(182, str12, "write", "(I)V");
        int length = dVarArr2.length;
        if (length == 0) {
            hVar.c(25, c0004a.g("out"));
            hVar.c(16, 93);
            hVar.j(182, str12, "write", "(I)V");
            return;
        }
        int i18 = 0;
        while (i18 < length) {
            int i19 = i18 == length + (-1) ? 93 : 44;
            com.alibaba.fastjson.util.d dVar = dVarArr2[i18];
            Class cls3 = dVar.f18283e;
            hVar.d(dVar.f18279a);
            hVar.c(58, C0004a.f252h);
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                str = str11;
                i11 = length;
                i12 = i18;
                str2 = str9;
                str3 = str13;
                c11 = 25;
                z10 = false;
                hVar.c(25, c0004a.g(str));
                hVar.h(89);
                aVar = this;
                aVar.i(hVar, c0004a, dVar);
                String str14 = f244f;
                hVar.j(182, str14, "writeInt", str3);
                c12 = 16;
                hVar.c(16, i19);
                hVar.j(182, str14, "write", str3);
            } else {
                if (cls3 == Long.TYPE) {
                    hVar.c(25, c0004a.g(str11));
                    hVar.h(89);
                    aVar2.i(hVar, c0004a, dVar);
                    String str15 = f244f;
                    c13 = 182;
                    hVar.j(182, str15, "writeLong", "(J)V");
                    hVar.c(16, i19);
                    hVar.j(182, str15, "write", str13);
                } else if (cls3 == Float.TYPE) {
                    hVar.c(25, c0004a.g(str11));
                    hVar.h(89);
                    aVar2.i(hVar, c0004a, dVar);
                    hVar.h(4);
                    String str16 = f244f;
                    c13 = 182;
                    hVar.j(182, str16, "writeFloat", "(FZ)V");
                    hVar.c(16, i19);
                    hVar.j(182, str16, "write", str13);
                } else if (cls3 == Double.TYPE) {
                    hVar.c(25, c0004a.g(str11));
                    hVar.h(89);
                    aVar2.i(hVar, c0004a, dVar);
                    hVar.h(4);
                    String str17 = f244f;
                    c13 = 182;
                    hVar.j(182, str17, "writeDouble", "(DZ)V");
                    hVar.c(16, i19);
                    hVar.j(182, str17, "write", str13);
                } else {
                    if (cls3 == Boolean.TYPE) {
                        hVar.c(25, c0004a.g(str11));
                        hVar.h(89);
                        aVar2.i(hVar, c0004a, dVar);
                        String str18 = f244f;
                        hVar.j(182, str18, "write", "(Z)V");
                        hVar.c(16, i19);
                        hVar.j(182, str18, "write", str13);
                    } else if (cls3 == Character.TYPE) {
                        hVar.c(25, c0004a.g(str11));
                        aVar2.i(hVar, c0004a, dVar);
                        hVar.j(184, "java/lang/Character", "toString", "(C)Ljava/lang/String;");
                        hVar.c(16, i19);
                        hVar.j(182, f244f, "writeString", "(Ljava/lang/String;C)V");
                        i11 = length;
                        i12 = i18;
                        str2 = str9;
                        str3 = str13;
                        z10 = false;
                        c12 = 16;
                        aVar = aVar2;
                        str = str11;
                        c11 = 25;
                    } else if (cls3 == String.class) {
                        hVar.c(25, c0004a.g(str11));
                        aVar2.i(hVar, c0004a, dVar);
                        hVar.c(16, i19);
                        hVar.j(182, f244f, "writeString", "(Ljava/lang/String;C)V");
                        i11 = length;
                        i12 = i18;
                        str2 = str9;
                        str3 = str13;
                        z10 = false;
                        c12 = 16;
                        aVar = aVar2;
                        str = str11;
                        c11 = 25;
                    } else if (cls3.isEnum()) {
                        hVar.c(25, c0004a.g(str11));
                        hVar.h(89);
                        aVar2.i(hVar, c0004a, dVar);
                        String str19 = f244f;
                        hVar.j(182, str19, "writeEnum", "(Ljava/lang/Enum;)V");
                        hVar.c(16, i19);
                        hVar.j(182, str19, "write", str13);
                    } else if (List.class.isAssignableFrom(cls3)) {
                        Type type = dVar.f18284f;
                        Type type2 = type instanceof Class ? Object.class : ((ParameterizedType) type).getActualTypeArguments()[0];
                        if (!(type2 instanceof Class) || (cls2 = (Class) type2) == Object.class) {
                            cls2 = null;
                        }
                        aVar2.i(hVar, c0004a, dVar);
                        i11 = length;
                        hVar.f(PsExtractor.AUDIO_STREAM, "java/util/List");
                        i12 = i18;
                        hVar.c(58, c0004a.g("list"));
                        if (cls2 == String.class && c0004a.f258d) {
                            hVar.c(25, c0004a.g(str11));
                            hVar.c(25, c0004a.g("list"));
                            hVar.j(182, f244f, "write", "(Ljava/util/List;)V");
                            str = str11;
                            i17 = 182;
                            i14 = i19;
                            str2 = str9;
                            str6 = str13;
                            i15 = 25;
                            i16 = 16;
                        } else {
                            com.alibaba.fastjson.asm.f fVar8 = new com.alibaba.fastjson.asm.f();
                            com.alibaba.fastjson.asm.f fVar9 = new com.alibaba.fastjson.asm.f();
                            i14 = i19;
                            hVar.c(25, c0004a.g("list"));
                            hVar.a(199, fVar9);
                            hVar.c(25, c0004a.g(str11));
                            String str20 = f244f;
                            Type type3 = type2;
                            String str21 = str10;
                            hVar.j(182, str20, "writeNull", "()V");
                            hVar.a(167, fVar8);
                            hVar.l(fVar9);
                            hVar.c(25, c0004a.g("list"));
                            hVar.j(185, "java/util/List", "size", "()I");
                            hVar.c(54, c0004a.g("size"));
                            hVar.c(25, c0004a.g(str11));
                            hVar.c(16, 91);
                            hVar.j(182, str20, "write", str13);
                            com.alibaba.fastjson.asm.f fVar10 = new com.alibaba.fastjson.asm.f();
                            com.alibaba.fastjson.asm.f fVar11 = new com.alibaba.fastjson.asm.f();
                            com.alibaba.fastjson.asm.f fVar12 = new com.alibaba.fastjson.asm.f();
                            hVar.h(3);
                            String str22 = str9;
                            hVar.c(54, c0004a.g("i"));
                            hVar.l(fVar10);
                            hVar.c(21, c0004a.g("i"));
                            hVar.c(21, c0004a.g("size"));
                            hVar.a(162, fVar12);
                            hVar.c(21, c0004a.g("i"));
                            hVar.a(153, fVar11);
                            hVar.c(25, c0004a.g(str11));
                            hVar.c(16, 44);
                            hVar.j(182, str20, "write", str13);
                            hVar.l(fVar11);
                            hVar.c(25, c0004a.g("list"));
                            hVar.c(21, c0004a.g("i"));
                            hVar.j(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
                            hVar.c(58, c0004a.g("list_item"));
                            com.alibaba.fastjson.asm.f fVar13 = new com.alibaba.fastjson.asm.f();
                            com.alibaba.fastjson.asm.f fVar14 = new com.alibaba.fastjson.asm.f();
                            String str23 = str13;
                            hVar.c(25, c0004a.g("list_item"));
                            hVar.a(199, fVar14);
                            hVar.c(25, c0004a.g(str11));
                            String str24 = str11;
                            hVar.j(182, str20, "writeNull", "()V");
                            hVar.a(167, fVar13);
                            hVar.l(fVar14);
                            com.alibaba.fastjson.asm.f fVar15 = new com.alibaba.fastjson.asm.f();
                            com.alibaba.fastjson.asm.f fVar16 = new com.alibaba.fastjson.asm.f();
                            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                                fVar = fVar10;
                                fVar2 = fVar13;
                                fVar3 = fVar12;
                                str5 = str20;
                                str10 = str21;
                                str2 = str22;
                                fVar4 = fVar16;
                            } else {
                                hVar.c(25, c0004a.g("list_item"));
                                str5 = str20;
                                fVar3 = fVar12;
                                hVar.j(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                                hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(cls2)));
                                hVar.a(166, fVar16);
                                aVar2.k(c0004a, hVar, dVar, cls2);
                                hVar.c(58, c0004a.g("list_item_desc"));
                                com.alibaba.fastjson.asm.f fVar17 = new com.alibaba.fastjson.asm.f();
                                com.alibaba.fastjson.asm.f fVar18 = new com.alibaba.fastjson.asm.f();
                                if (c0004a.f258d) {
                                    hVar.c(25, c0004a.g("list_item_desc"));
                                    String str25 = f246h;
                                    hVar.f(193, str25);
                                    hVar.a(153, fVar17);
                                    fVar = fVar10;
                                    hVar.c(25, c0004a.g("list_item_desc"));
                                    hVar.f(PsExtractor.AUDIO_STREAM, str25);
                                    hVar.c(25, 1);
                                    hVar.c(25, c0004a.g("list_item"));
                                    if (c0004a.f261g) {
                                        hVar.h(1);
                                        fVar2 = fVar13;
                                        fVar5 = fVar16;
                                    } else {
                                        hVar.c(21, c0004a.g("i"));
                                        fVar2 = fVar13;
                                        fVar5 = fVar16;
                                        hVar.j(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                    }
                                    hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(cls2)));
                                    hVar.d(Integer.valueOf(dVar.f18287i));
                                    StringBuilder sb3 = new StringBuilder();
                                    str2 = str22;
                                    sb3.append(str2);
                                    sb3.append(f241c);
                                    str10 = str21;
                                    sb3.append(str10);
                                    fVar6 = fVar15;
                                    hVar.j(182, str25, "writeAsArrayNonContext", sb3.toString());
                                    hVar.a(167, fVar18);
                                    hVar.l(fVar17);
                                } else {
                                    fVar = fVar10;
                                    fVar2 = fVar13;
                                    fVar5 = fVar16;
                                    str10 = str21;
                                    str2 = str22;
                                    fVar6 = fVar15;
                                }
                                hVar.c(25, c0004a.g("list_item_desc"));
                                hVar.c(25, 1);
                                hVar.c(25, c0004a.g("list_item"));
                                if (c0004a.f261g) {
                                    hVar.h(1);
                                } else {
                                    hVar.c(21, c0004a.g("i"));
                                    hVar.j(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                }
                                hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(cls2)));
                                hVar.d(Integer.valueOf(dVar.f18287i));
                                hVar.j(185, f242d, "write", str2 + f241c + str10);
                                hVar.l(fVar18);
                                fVar15 = fVar6;
                                hVar.a(167, fVar15);
                                fVar4 = fVar5;
                            }
                            hVar.l(fVar4);
                            hVar.c(25, 1);
                            hVar.c(25, c0004a.g("list_item"));
                            if (c0004a.f261g) {
                                hVar.h(1);
                            } else {
                                hVar.c(21, c0004a.g("i"));
                                hVar.j(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                            }
                            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                                hVar.j(182, f241c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                            } else {
                                hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b((Class) type3)));
                                hVar.d(Integer.valueOf(dVar.f18287i));
                                hVar.j(182, f241c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                            }
                            hVar.l(fVar15);
                            hVar.l(fVar2);
                            hVar.e(c0004a.g("i"), 1);
                            hVar.a(167, fVar);
                            hVar.l(fVar3);
                            str = str24;
                            i15 = 25;
                            hVar.c(25, c0004a.g(str));
                            i16 = 16;
                            hVar.c(16, 93);
                            str6 = str23;
                            i17 = 182;
                            hVar.j(182, str5, "write", str6);
                            hVar.l(fVar8);
                        }
                        hVar.c(i15, c0004a.g(str));
                        hVar.c(i16, i14);
                        hVar.j(i17, f244f, "write", str6);
                        aVar = this;
                        str3 = str6;
                        c11 = 25;
                        z10 = false;
                        c12 = 16;
                    } else {
                        String str26 = str11;
                        i11 = length;
                        i12 = i18;
                        str2 = str9;
                        String str27 = str13;
                        com.alibaba.fastjson.asm.f fVar19 = new com.alibaba.fastjson.asm.f();
                        com.alibaba.fastjson.asm.f fVar20 = new com.alibaba.fastjson.asm.f();
                        i(hVar, c0004a, dVar);
                        hVar.h(89);
                        hVar.c(58, c0004a.g("field_" + dVar.f18283e.getName()));
                        hVar.a(199, fVar20);
                        hVar.c(25, c0004a.g(str26));
                        String str28 = f244f;
                        int i20 = i19;
                        hVar.j(182, str28, "writeNull", "()V");
                        hVar.a(167, fVar19);
                        hVar.l(fVar20);
                        com.alibaba.fastjson.asm.f fVar21 = new com.alibaba.fastjson.asm.f();
                        com.alibaba.fastjson.asm.f fVar22 = new com.alibaba.fastjson.asm.f();
                        hVar.c(25, c0004a.g("field_" + dVar.f18283e.getName()));
                        hVar.j(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                        hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(cls3)));
                        hVar.a(166, fVar22);
                        j(c0004a, hVar, dVar);
                        hVar.c(58, c0004a.g("fied_ser"));
                        com.alibaba.fastjson.asm.f fVar23 = new com.alibaba.fastjson.asm.f();
                        com.alibaba.fastjson.asm.f fVar24 = new com.alibaba.fastjson.asm.f();
                        if (c0004a.f258d && Modifier.isPublic(cls3.getModifiers())) {
                            hVar.c(25, c0004a.g("fied_ser"));
                            String str29 = f246h;
                            hVar.f(193, str29);
                            hVar.a(153, fVar23);
                            hVar.c(25, c0004a.g("fied_ser"));
                            hVar.f(PsExtractor.AUDIO_STREAM, str29);
                            hVar.c(25, 1);
                            hVar.c(25, c0004a.g("field_" + dVar.f18283e.getName()));
                            hVar.c(25, C0004a.f252h);
                            hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(cls3)));
                            hVar.d(Integer.valueOf(dVar.f18287i));
                            str4 = "writeWithFieldName";
                            hVar.j(182, str29, "writeAsArrayNonContext", str2 + f241c + str10);
                            hVar.a(167, fVar24);
                            hVar.l(fVar23);
                        } else {
                            str4 = "writeWithFieldName";
                        }
                        hVar.c(25, c0004a.g("fied_ser"));
                        hVar.c(25, 1);
                        hVar.c(25, c0004a.g("field_" + dVar.f18283e.getName()));
                        hVar.c(25, C0004a.f252h);
                        hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(cls3)));
                        hVar.d(Integer.valueOf(dVar.f18287i));
                        String str30 = f242d;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str2);
                        String str31 = f241c;
                        sb4.append(str31);
                        sb4.append(str10);
                        hVar.j(185, str30, "write", sb4.toString());
                        hVar.l(fVar24);
                        hVar.a(167, fVar21);
                        hVar.l(fVar22);
                        String k11 = dVar.k();
                        hVar.c(25, 1);
                        hVar.c(25, c0004a.g("field_" + dVar.f18283e.getName()));
                        if (k11 != null) {
                            hVar.d(k11);
                            i13 = 182;
                            hVar.j(182, str31, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
                        } else {
                            i13 = 182;
                            hVar.c(25, C0004a.f252h);
                            Type type4 = dVar.f18284f;
                            if ((type4 instanceof Class) && ((Class) type4).isPrimitive()) {
                                hVar.j(182, str31, str4, "(Ljava/lang/Object;Ljava/lang/Object;)V");
                            } else {
                                z10 = false;
                                hVar.c(25, 0);
                                hVar.b(180, c0004a.f256b, dVar.f18279a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                                hVar.d(Integer.valueOf(dVar.f18287i));
                                i13 = 182;
                                hVar.j(182, str31, str4, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                                hVar.l(fVar21);
                                hVar.l(fVar19);
                                str = str26;
                                c11 = 25;
                                hVar.c(25, c0004a.g(str));
                                hVar.c(16, i20);
                                str3 = str27;
                                hVar.j(i13, str28, "write", str3);
                                aVar = this;
                                c12 = 16;
                            }
                        }
                        z10 = false;
                        hVar.l(fVar21);
                        hVar.l(fVar19);
                        str = str26;
                        c11 = 25;
                        hVar.c(25, c0004a.g(str));
                        hVar.c(16, i20);
                        str3 = str27;
                        hVar.j(i13, str28, "write", str3);
                        aVar = this;
                        c12 = 16;
                    }
                    aVar = aVar2;
                    str = str11;
                    i11 = length;
                    i12 = i18;
                    str2 = str9;
                    str3 = str13;
                    c11 = 25;
                    z10 = false;
                    c12 = 16;
                }
                i11 = length;
                i12 = i18;
                str2 = str9;
                str3 = str13;
                z10 = false;
                c12 = 16;
                aVar = aVar2;
                str = str11;
                c11 = 25;
            }
            str13 = str3;
            i18 = i12 + 1;
            dVarArr2 = dVarArr;
            length = i11;
            str11 = str;
            aVar2 = aVar;
            str9 = str2;
        }
    }

    private void B(Class cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d[] dVarArr, C0004a c0004a) {
        com.alibaba.fastjson.asm.f fVar;
        String str;
        int i11;
        int i12;
        String str2;
        Class cls2;
        com.alibaba.fastjson.util.d[] dVarArr2 = dVarArr;
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        int length = dVarArr2.length;
        String str3 = "out";
        if (c0004a.f258d) {
            fVar = fVar2;
        } else {
            com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
            com.alibaba.fastjson.asm.f fVar4 = new com.alibaba.fastjson.asm.f();
            fVar = fVar2;
            hVar.c(25, c0004a.g("out"));
            hVar.d(Integer.valueOf(SerializerFeature.PrettyFormat.mask));
            hVar.j(182, f244f, "isEnabled", "(I)Z");
            hVar.a(154, fVar4);
            int length2 = dVarArr2.length;
            int i13 = 0;
            while (true) {
                if (i13 >= length2) {
                    hVar.a(167, fVar3);
                    break;
                }
                int i14 = length2;
                if (dVarArr2[i13].f18280b != null) {
                    hVar.c(25, c0004a.g("out"));
                    hVar.d(Integer.valueOf(SerializerFeature.IgnoreErrorGetter.mask));
                    hVar.j(182, f244f, "isEnabled", "(I)Z");
                    hVar.a(153, fVar3);
                    break;
                }
                i13++;
                length2 = i14;
            }
            hVar.l(fVar4);
            hVar.c(25, 0);
            hVar.c(25, 1);
            hVar.c(25, 2);
            hVar.c(25, 3);
            hVar.c(25, 4);
            hVar.c(21, 5);
            hVar.j(183, f246h, "write", "(L" + f241c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar.h(177);
            hVar.l(fVar3);
        }
        if (!c0004a.f261g) {
            com.alibaba.fastjson.asm.f fVar5 = new com.alibaba.fastjson.asm.f();
            hVar.c(25, 0);
            hVar.c(25, 1);
            hVar.c(25, 2);
            hVar.c(21, 5);
            hVar.j(182, f246h, "writeReference", "(L" + f241c + ";Ljava/lang/Object;I)Z");
            hVar.a(153, fVar5);
            hVar.h(177);
            hVar.l(fVar5);
        }
        String str4 = c0004a.f258d ? c0004a.f261g ? "writeAsArrayNonContext" : "writeAsArray" : "writeAsArrayNormal";
        int i15 = c0004a.f257c.f280g;
        SerializerFeature serializerFeature = SerializerFeature.BeanToArray;
        if ((i15 & serializerFeature.mask) == 0) {
            com.alibaba.fastjson.asm.f fVar6 = new com.alibaba.fastjson.asm.f();
            hVar.c(25, c0004a.g("out"));
            hVar.d(Integer.valueOf(serializerFeature.mask));
            hVar.j(182, f244f, "isEnabled", "(I)Z");
            hVar.a(153, fVar6);
            hVar.c(25, 0);
            hVar.c(25, 1);
            hVar.c(25, 2);
            hVar.c(25, 3);
            hVar.c(25, 4);
            hVar.c(21, 5);
            hVar.j(182, c0004a.f256b, str4, "(L" + f241c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar.h(177);
            hVar.l(fVar6);
        } else {
            hVar.c(25, 0);
            hVar.c(25, 1);
            hVar.c(25, 2);
            hVar.c(25, 3);
            hVar.c(25, 4);
            hVar.c(21, 5);
            hVar.j(182, c0004a.f256b, str4, "(L" + f241c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar.h(177);
        }
        if (!c0004a.f261g) {
            hVar.c(25, 1);
            String str5 = f241c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("()");
            String str6 = f248j;
            sb2.append(str6);
            hVar.j(182, str5, "getContext", sb2.toString());
            hVar.c(58, c0004a.g("parent"));
            hVar.c(25, 1);
            hVar.c(25, c0004a.g("parent"));
            hVar.c(25, 2);
            hVar.c(25, 3);
            hVar.d(Integer.valueOf(c0004a.f257c.f280g));
            hVar.j(182, str5, "setContext", "(" + str6 + "Ljava/lang/Object;Ljava/lang/Object;I)V");
        }
        boolean z10 = (c0004a.f257c.f280g & SerializerFeature.WriteClassName.mask) != 0;
        if (z10 || !c0004a.f258d) {
            com.alibaba.fastjson.asm.f fVar7 = new com.alibaba.fastjson.asm.f();
            com.alibaba.fastjson.asm.f fVar8 = new com.alibaba.fastjson.asm.f();
            com.alibaba.fastjson.asm.f fVar9 = new com.alibaba.fastjson.asm.f();
            if (z10) {
                str = "parent";
                i11 = 182;
            } else {
                hVar.c(25, 1);
                hVar.c(25, 4);
                hVar.c(25, 2);
                str = "parent";
                i11 = 182;
                hVar.j(182, f241c, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
                hVar.a(153, fVar8);
            }
            hVar.c(25, 4);
            hVar.c(25, 2);
            hVar.j(i11, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            hVar.a(165, fVar8);
            hVar.l(fVar9);
            hVar.c(25, c0004a.g("out"));
            hVar.c(16, Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
            hVar.j(i11, f244f, "write", "(I)V");
            hVar.c(25, 0);
            hVar.c(25, 1);
            if (c0004a.f257c.f276c != null) {
                hVar.d(c0004a.f257c.f276c);
            } else {
                hVar.h(1);
            }
            hVar.c(25, 2);
            hVar.j(182, f246h, "writeClassName", "(L" + f241c + ";Ljava/lang/String;Ljava/lang/Object;)V");
            hVar.c(16, 44);
            hVar.a(167, fVar7);
            hVar.l(fVar8);
            hVar.c(16, Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
            hVar.l(fVar7);
        } else {
            hVar.c(16, Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
            str = "parent";
        }
        hVar.c(54, c0004a.g("seperator"));
        if (!c0004a.f258d) {
            c(hVar, c0004a);
        }
        if (c0004a.f258d) {
            i12 = 0;
        } else {
            hVar.c(25, c0004a.g("out"));
            hVar.j(182, f244f, "isNotWriteDefaultValue", "()Z");
            hVar.c(54, c0004a.g("notWriteDefaultValue"));
            hVar.c(25, 1);
            hVar.c(25, 0);
            String str7 = f241c;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("(");
            String str8 = f249k;
            sb3.append(str8);
            sb3.append(")Z");
            hVar.j(182, str7, "checkValue", sb3.toString());
            hVar.c(54, c0004a.g("checkValue"));
            hVar.c(25, 1);
            i12 = 0;
            hVar.c(25, 0);
            hVar.j(182, str7, "hasNameFilters", "(" + str8 + ")Z");
            hVar.c(54, c0004a.g("hasNameFilters"));
        }
        while (i12 < length) {
            com.alibaba.fastjson.util.d dVar = dVarArr2[i12];
            Class cls3 = dVar.f18283e;
            hVar.d(dVar.f18279a);
            hVar.c(58, C0004a.f252h);
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                str2 = str3;
                m(cls, hVar, dVar, c0004a, c0004a.g(cls3.getName()), 'I');
            } else {
                if (cls3 == Long.TYPE) {
                    cls2 = cls;
                    p(cls2, hVar, dVar, c0004a);
                } else {
                    cls2 = cls;
                    if (cls3 == Float.TYPE) {
                        h(cls2, hVar, dVar, c0004a);
                    } else if (cls3 == Double.TYPE) {
                        e(cls2, hVar, dVar, c0004a);
                    } else if (cls3 == Boolean.TYPE) {
                        str2 = str3;
                        m(cls, hVar, dVar, c0004a, c0004a.g("boolean"), 'Z');
                    } else {
                        str2 = str3;
                        if (cls3 == Character.TYPE) {
                            m(cls, hVar, dVar, c0004a, c0004a.g("char"), 'C');
                        } else if (cls3 == String.class) {
                            w(cls2, hVar, dVar, c0004a);
                        } else if (cls3 == BigDecimal.class) {
                            d(cls2, hVar, dVar, c0004a);
                        } else if (List.class.isAssignableFrom(cls3)) {
                            o(cls2, hVar, dVar, c0004a);
                        } else if (cls3.isEnum()) {
                            f(cls2, hVar, dVar, c0004a);
                        } else {
                            s(cls2, hVar, dVar, c0004a);
                        }
                    }
                }
                str2 = str3;
            }
            i12++;
            dVarArr2 = dVarArr;
            str3 = str2;
        }
        String str9 = str3;
        if (!c0004a.f258d) {
            a(hVar, c0004a);
        }
        com.alibaba.fastjson.asm.f fVar10 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar11 = new com.alibaba.fastjson.asm.f();
        hVar.c(21, c0004a.g("seperator"));
        hVar.g(16, Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
        hVar.a(160, fVar10);
        hVar.c(25, c0004a.g(str9));
        hVar.c(16, Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
        String str10 = f244f;
        hVar.j(182, str10, "write", "(I)V");
        hVar.l(fVar10);
        hVar.c(25, c0004a.g(str9));
        hVar.c(16, Sdk$SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
        hVar.j(182, str10, "write", "(I)V");
        hVar.l(fVar11);
        hVar.l(fVar);
        if (c0004a.f261g) {
            return;
        }
        hVar.c(25, 1);
        hVar.c(25, c0004a.g(str));
        hVar.j(182, f241c, "setContext", "(" + f248j + ")V");
    }

    private void a(com.alibaba.fastjson.asm.h hVar, C0004a c0004a) {
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.c(25, 2);
        hVar.c(21, c0004a.g("seperator"));
        hVar.j(182, f246h, "writeAfter", "(L" + f241c + ";Ljava/lang/Object;C)C");
        hVar.c(54, c0004a.g("seperator"));
    }

    private void b(com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, C0004a c0004a) {
        Class cls = dVar.f18283e;
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.c(25, 2);
        hVar.c(25, C0004a.f252h);
        if (cls == Byte.TYPE) {
            hVar.c(21, c0004a.g("byte"));
            hVar.j(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            hVar.c(21, c0004a.g("short"));
            hVar.j(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            hVar.c(21, c0004a.g("int"));
            hVar.j(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            hVar.c(21, c0004a.g("char"));
            hVar.j(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            hVar.c(22, c0004a.h("long", 2));
            hVar.j(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            hVar.c(23, c0004a.g("float"));
            hVar.j(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            hVar.c(24, c0004a.h("double", 2));
            hVar.j(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            hVar.c(21, c0004a.g("boolean"));
            hVar.j(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            hVar.c(25, c0004a.g("decimal"));
        } else if (cls == String.class) {
            hVar.c(25, c0004a.g("string"));
        } else if (cls.isEnum()) {
            hVar.c(25, c0004a.g("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            hVar.c(25, c0004a.g("list"));
        } else {
            hVar.c(25, c0004a.g("object"));
        }
        hVar.j(182, f246h, "apply", "(L" + f241c + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
    }

    private void c(com.alibaba.fastjson.asm.h hVar, C0004a c0004a) {
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.c(25, 2);
        hVar.c(21, c0004a.g("seperator"));
        hVar.j(182, f246h, "writeBefore", "(L" + f241c + ";Ljava/lang/Object;C)C");
        hVar.c(54, c0004a.g("seperator"));
    }

    private void d(Class cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, C0004a c0004a) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        q(hVar, dVar, c0004a, fVar);
        i(hVar, c0004a, dVar);
        hVar.c(58, c0004a.g("decimal"));
        g(hVar, dVar, c0004a, fVar);
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar4 = new com.alibaba.fastjson.asm.f();
        hVar.l(fVar2);
        hVar.c(25, c0004a.g("decimal"));
        hVar.a(199, fVar3);
        l(hVar, dVar, c0004a);
        hVar.a(167, fVar4);
        hVar.l(fVar3);
        hVar.c(25, c0004a.g("out"));
        hVar.c(21, c0004a.g("seperator"));
        hVar.c(25, C0004a.f252h);
        hVar.c(25, c0004a.g("decimal"));
        hVar.j(182, f244f, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
        v(hVar, c0004a);
        hVar.a(167, fVar4);
        hVar.l(fVar4);
        hVar.l(fVar);
    }

    private void e(Class cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, C0004a c0004a) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        q(hVar, dVar, c0004a, fVar);
        i(hVar, c0004a, dVar);
        hVar.c(57, c0004a.h("double", 2));
        g(hVar, dVar, c0004a, fVar);
        hVar.c(25, c0004a.g("out"));
        hVar.c(21, c0004a.g("seperator"));
        hVar.c(25, C0004a.f252h);
        hVar.c(24, c0004a.h("double", 2));
        hVar.j(182, f244f, "writeFieldValue", "(CLjava/lang/String;D)V");
        v(hVar, c0004a);
        hVar.l(fVar);
    }

    private void f(Class cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, C0004a c0004a) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
        q(hVar, dVar, c0004a, fVar3);
        i(hVar, c0004a, dVar);
        hVar.f(PsExtractor.AUDIO_STREAM, "java/lang/Enum");
        hVar.c(58, c0004a.g("enum"));
        g(hVar, dVar, c0004a, fVar3);
        hVar.c(25, c0004a.g("enum"));
        hVar.a(199, fVar);
        l(hVar, dVar, c0004a);
        hVar.a(167, fVar2);
        hVar.l(fVar);
        if (c0004a.f258d) {
            hVar.c(25, c0004a.g("out"));
            hVar.c(21, c0004a.g("seperator"));
            hVar.c(25, C0004a.f252h);
            hVar.c(25, c0004a.g("enum"));
            hVar.j(182, "java/lang/Enum", "name", "()Ljava/lang/String;");
            hVar.j(182, f244f, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            hVar.c(25, c0004a.g("out"));
            hVar.c(21, c0004a.g("seperator"));
            String str = f244f;
            hVar.j(182, str, "write", "(I)V");
            hVar.c(25, c0004a.g("out"));
            hVar.c(25, C0004a.f252h);
            hVar.h(3);
            hVar.j(182, str, "writeFieldName", "(Ljava/lang/String;Z)V");
            hVar.c(25, 1);
            hVar.c(25, c0004a.g("enum"));
            hVar.c(25, C0004a.f252h);
            hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(dVar.f18283e)));
            hVar.d(Integer.valueOf(dVar.f18287i));
            hVar.j(182, f241c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        }
        v(hVar, c0004a);
        hVar.l(fVar2);
        hVar.l(fVar3);
    }

    private void g(com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, C0004a c0004a, com.alibaba.fastjson.asm.f fVar) {
        if (dVar.f18293o) {
            hVar.c(25, c0004a.g("out"));
            hVar.d(Integer.valueOf(SerializerFeature.SkipTransientField.mask));
            hVar.j(182, f244f, "isEnabled", "(I)Z");
            hVar.a(154, fVar);
        }
        r(hVar, dVar, c0004a, fVar);
        if (c0004a.f258d) {
            return;
        }
        b(hVar, dVar, c0004a);
        hVar.a(153, fVar);
        t(hVar, dVar, c0004a);
        u(hVar, dVar, c0004a, fVar);
    }

    private void h(Class cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, C0004a c0004a) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        q(hVar, dVar, c0004a, fVar);
        i(hVar, c0004a, dVar);
        hVar.c(56, c0004a.g("float"));
        g(hVar, dVar, c0004a, fVar);
        hVar.c(25, c0004a.g("out"));
        hVar.c(21, c0004a.g("seperator"));
        hVar.c(25, C0004a.f252h);
        hVar.c(23, c0004a.g("float"));
        hVar.j(182, f244f, "writeFieldValue", "(CLjava/lang/String;F)V");
        v(hVar, c0004a);
        hVar.l(fVar);
    }

    private void i(com.alibaba.fastjson.asm.h hVar, C0004a c0004a, com.alibaba.fastjson.util.d dVar) {
        Method method = dVar.f18280b;
        if (method != null) {
            hVar.c(25, c0004a.g("entity"));
            Class<?> declaringClass = method.getDeclaringClass();
            hVar.j(declaringClass.isInterface() ? 185 : 182, com.alibaba.fastjson.util.b.g(declaringClass), method.getName(), com.alibaba.fastjson.util.b.c(method));
            if (method.getReturnType().equals(dVar.f18283e)) {
                return;
            }
            hVar.f(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(dVar.f18283e));
            return;
        }
        hVar.c(25, c0004a.g("entity"));
        Field field = dVar.f18281c;
        hVar.b(180, com.alibaba.fastjson.util.b.g(dVar.f18285g), field.getName(), com.alibaba.fastjson.util.b.b(field.getType()));
        if (field.getType().equals(dVar.f18283e)) {
            return;
        }
        hVar.f(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(dVar.f18283e));
    }

    private void j(C0004a c0004a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        hVar.c(25, 0);
        String str = c0004a.f256b;
        String str2 = dVar.f18279a + "_asm_ser_";
        String str3 = f243e;
        hVar.b(180, str, str2, str3);
        hVar.a(199, fVar);
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(dVar.f18283e)));
        hVar.j(182, f241c, "getObjectWriter", "(Ljava/lang/Class;)" + str3);
        hVar.b(181, c0004a.f256b, dVar.f18279a + "_asm_ser_", str3);
        hVar.l(fVar);
        hVar.c(25, 0);
        hVar.b(180, c0004a.f256b, dVar.f18279a + "_asm_ser_", str3);
    }

    private void k(C0004a c0004a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, Class cls) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        hVar.c(25, 0);
        String str = c0004a.f256b;
        String str2 = dVar.f18279a + "_asm_list_item_ser_";
        String str3 = f243e;
        hVar.b(180, str, str2, str3);
        hVar.a(199, fVar);
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(cls)));
        hVar.j(182, f241c, "getObjectWriter", "(Ljava/lang/Class;)" + str3);
        hVar.b(181, c0004a.f256b, dVar.f18279a + "_asm_list_item_ser_", str3);
        hVar.l(fVar);
        hVar.c(25, 0);
        hVar.b(180, c0004a.f256b, dVar.f18279a + "_asm_list_item_ser_", str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void l(com.alibaba.fastjson.asm.h r18, com.alibaba.fastjson.util.d r19, a5.a.C0004a r20) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.a.l(com.alibaba.fastjson.asm.h, com.alibaba.fastjson.util.d, a5.a$a):void");
    }

    private void m(Class cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, C0004a c0004a, int i11, char c11) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        q(hVar, dVar, c0004a, fVar);
        i(hVar, c0004a, dVar);
        hVar.c(54, i11);
        g(hVar, dVar, c0004a, fVar);
        hVar.c(25, c0004a.g("out"));
        hVar.c(21, c0004a.g("seperator"));
        hVar.c(25, C0004a.f252h);
        hVar.c(21, i11);
        hVar.j(182, f244f, "writeFieldValue", "(CLjava/lang/String;" + c11 + ")V");
        v(hVar, c0004a);
        hVar.l(fVar);
    }

    private void n(com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, C0004a c0004a, com.alibaba.fastjson.asm.f fVar) {
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.d(dVar.f18289k);
        hVar.j(182, f246h, "applyLabel", "(L" + f241c + ";Ljava/lang/String;)Z");
        hVar.a(153, fVar);
    }

    private void o(Class cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, C0004a c0004a) {
        com.alibaba.fastjson.asm.f fVar;
        com.alibaba.fastjson.asm.f fVar2;
        com.alibaba.fastjson.asm.f fVar3;
        String str;
        com.alibaba.fastjson.asm.f fVar4;
        String str2;
        com.alibaba.fastjson.asm.f fVar5;
        com.alibaba.fastjson.util.d dVar2;
        com.alibaba.fastjson.asm.f fVar6;
        int i11;
        int i12;
        int i13;
        com.alibaba.fastjson.asm.f fVar7;
        com.alibaba.fastjson.asm.f fVar8;
        String str3;
        String str4;
        Type V = TypeUtils.V(dVar.f18284f);
        Class cls2 = null;
        Class cls3 = V instanceof Class ? (Class) V : null;
        if (cls3 != Object.class && cls3 != Serializable.class) {
            cls2 = cls3;
        }
        com.alibaba.fastjson.asm.f fVar9 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar10 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar11 = new com.alibaba.fastjson.asm.f();
        q(hVar, dVar, c0004a, fVar9);
        i(hVar, c0004a, dVar);
        hVar.f(PsExtractor.AUDIO_STREAM, "java/util/List");
        hVar.c(58, c0004a.g("list"));
        g(hVar, dVar, c0004a, fVar9);
        hVar.c(25, c0004a.g("list"));
        hVar.a(199, fVar10);
        l(hVar, dVar, c0004a);
        hVar.a(167, fVar11);
        hVar.l(fVar10);
        hVar.c(25, c0004a.g("out"));
        hVar.c(21, c0004a.g("seperator"));
        String str5 = f244f;
        hVar.j(182, str5, "write", "(I)V");
        x(hVar, c0004a);
        hVar.c(25, c0004a.g("list"));
        hVar.j(185, "java/util/List", "size", "()I");
        hVar.c(54, c0004a.g("size"));
        com.alibaba.fastjson.asm.f fVar12 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar13 = new com.alibaba.fastjson.asm.f();
        hVar.c(21, c0004a.g("size"));
        hVar.h(3);
        hVar.a(160, fVar12);
        hVar.c(25, c0004a.g("out"));
        hVar.d("[]");
        hVar.j(182, str5, "write", "(Ljava/lang/String;)V");
        hVar.a(167, fVar13);
        hVar.l(fVar12);
        if (c0004a.f261g) {
            fVar = fVar13;
        } else {
            hVar.c(25, 1);
            hVar.c(25, c0004a.g("list"));
            hVar.c(25, C0004a.f252h);
            fVar = fVar13;
            hVar.j(182, f241c, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
        }
        if (V == String.class && c0004a.f258d) {
            hVar.c(25, c0004a.g("out"));
            hVar.c(25, c0004a.g("list"));
            hVar.j(182, str5, "write", "(Ljava/util/List;)V");
            i12 = 25;
            i13 = 182;
            i11 = 1;
        } else {
            hVar.c(25, c0004a.g("out"));
            hVar.c(16, 91);
            hVar.j(182, str5, "write", "(I)V");
            com.alibaba.fastjson.asm.f fVar14 = new com.alibaba.fastjson.asm.f();
            com.alibaba.fastjson.asm.f fVar15 = new com.alibaba.fastjson.asm.f();
            com.alibaba.fastjson.asm.f fVar16 = new com.alibaba.fastjson.asm.f();
            hVar.h(3);
            hVar.c(54, c0004a.g("i"));
            hVar.l(fVar14);
            hVar.c(21, c0004a.g("i"));
            hVar.c(21, c0004a.g("size"));
            hVar.a(162, fVar16);
            hVar.c(21, c0004a.g("i"));
            hVar.a(153, fVar15);
            hVar.c(25, c0004a.g("out"));
            hVar.c(16, 44);
            hVar.j(182, str5, "write", "(I)V");
            hVar.l(fVar15);
            hVar.c(25, c0004a.g("list"));
            hVar.c(21, c0004a.g("i"));
            hVar.j(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
            hVar.c(58, c0004a.g("list_item"));
            com.alibaba.fastjson.asm.f fVar17 = new com.alibaba.fastjson.asm.f();
            com.alibaba.fastjson.asm.f fVar18 = new com.alibaba.fastjson.asm.f();
            hVar.c(25, c0004a.g("list_item"));
            hVar.a(199, fVar18);
            hVar.c(25, c0004a.g("out"));
            hVar.j(182, str5, "writeNull", "()V");
            hVar.a(167, fVar17);
            hVar.l(fVar18);
            com.alibaba.fastjson.asm.f fVar19 = new com.alibaba.fastjson.asm.f();
            com.alibaba.fastjson.asm.f fVar20 = new com.alibaba.fastjson.asm.f();
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                fVar2 = fVar14;
                fVar3 = fVar17;
                str = "out";
                fVar4 = fVar19;
                str2 = "write";
                fVar5 = fVar16;
                dVar2 = dVar;
                fVar6 = fVar20;
            } else {
                str = "out";
                hVar.c(25, c0004a.g("list_item"));
                fVar5 = fVar16;
                fVar2 = fVar14;
                hVar.j(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(cls2)));
                hVar.a(166, fVar20);
                dVar2 = dVar;
                k(c0004a, hVar, dVar2, cls2);
                hVar.c(58, c0004a.g("list_item_desc"));
                com.alibaba.fastjson.asm.f fVar21 = new com.alibaba.fastjson.asm.f();
                com.alibaba.fastjson.asm.f fVar22 = new com.alibaba.fastjson.asm.f();
                if (c0004a.f258d) {
                    if (c0004a.f261g && c0004a.f258d) {
                        fVar3 = fVar17;
                        str4 = "writeDirectNonContext";
                        fVar8 = fVar20;
                    } else {
                        fVar3 = fVar17;
                        fVar8 = fVar20;
                        str4 = "write";
                    }
                    fVar7 = fVar19;
                    hVar.c(25, c0004a.g("list_item_desc"));
                    String str6 = f246h;
                    hVar.f(193, str6);
                    hVar.a(153, fVar21);
                    str3 = "write";
                    hVar.c(25, c0004a.g("list_item_desc"));
                    hVar.f(PsExtractor.AUDIO_STREAM, str6);
                    hVar.c(25, 1);
                    hVar.c(25, c0004a.g("list_item"));
                    if (c0004a.f261g) {
                        hVar.h(1);
                    } else {
                        hVar.c(21, c0004a.g("i"));
                        hVar.j(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    }
                    hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(cls2)));
                    hVar.d(Integer.valueOf(dVar2.f18287i));
                    hVar.j(182, str6, str4, "(L" + f241c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    hVar.a(167, fVar22);
                    hVar.l(fVar21);
                } else {
                    fVar3 = fVar17;
                    fVar7 = fVar19;
                    fVar8 = fVar20;
                    str3 = "write";
                }
                hVar.c(25, c0004a.g("list_item_desc"));
                hVar.c(25, 1);
                hVar.c(25, c0004a.g("list_item"));
                if (c0004a.f261g) {
                    hVar.h(1);
                } else {
                    hVar.c(21, c0004a.g("i"));
                    hVar.j(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                }
                hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(cls2)));
                hVar.d(Integer.valueOf(dVar2.f18287i));
                str2 = str3;
                hVar.j(185, f242d, str2, "(L" + f241c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                hVar.l(fVar22);
                fVar4 = fVar7;
                hVar.a(167, fVar4);
                fVar6 = fVar8;
            }
            hVar.l(fVar6);
            hVar.c(25, 1);
            hVar.c(25, c0004a.g("list_item"));
            if (c0004a.f261g) {
                hVar.h(1);
            } else {
                hVar.c(21, c0004a.g("i"));
                hVar.j(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            }
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                hVar.j(182, f241c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b((Class) V)));
                hVar.d(Integer.valueOf(dVar2.f18287i));
                hVar.j(182, f241c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
            hVar.l(fVar4);
            hVar.l(fVar3);
            i11 = 1;
            hVar.e(c0004a.g("i"), 1);
            hVar.a(167, fVar2);
            hVar.l(fVar5);
            i12 = 25;
            hVar.c(25, c0004a.g(str));
            hVar.c(16, 93);
            i13 = 182;
            hVar.j(182, str5, str2, "(I)V");
        }
        hVar.c(i12, i11);
        hVar.j(i13, f241c, "popContext", "()V");
        hVar.l(fVar);
        v(hVar, c0004a);
        hVar.l(fVar11);
        hVar.l(fVar9);
    }

    private void p(Class cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, C0004a c0004a) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        q(hVar, dVar, c0004a, fVar);
        i(hVar, c0004a, dVar);
        hVar.c(55, c0004a.h("long", 2));
        g(hVar, dVar, c0004a, fVar);
        hVar.c(25, c0004a.g("out"));
        hVar.c(21, c0004a.g("seperator"));
        hVar.c(25, C0004a.f252h);
        hVar.c(22, c0004a.h("long", 2));
        hVar.j(182, f244f, "writeFieldValue", "(CLjava/lang/String;J)V");
        v(hVar, c0004a);
        hVar.l(fVar);
    }

    private void q(com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, C0004a c0004a, com.alibaba.fastjson.asm.f fVar) {
        if (!c0004a.f258d) {
            hVar.c(25, 0);
            hVar.c(25, 1);
            hVar.c(25, 2);
            hVar.c(25, C0004a.f252h);
            hVar.j(182, f246h, "applyName", "(L" + f241c + ";Ljava/lang/Object;Ljava/lang/String;)Z");
            hVar.a(153, fVar);
            n(hVar, dVar, c0004a, fVar);
        }
        if (dVar.f18281c == null) {
            hVar.c(25, c0004a.g("out"));
            hVar.d(Integer.valueOf(SerializerFeature.IgnoreNonFieldGetter.mask));
            hVar.j(182, f244f, "isEnabled", "(I)Z");
            hVar.a(154, fVar);
        }
    }

    private void r(com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, C0004a c0004a, com.alibaba.fastjson.asm.f fVar) {
        if (c0004a.f258d) {
            return;
        }
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        hVar.c(21, c0004a.g("notWriteDefaultValue"));
        hVar.a(153, fVar2);
        Class cls = dVar.f18283e;
        if (cls == Boolean.TYPE) {
            hVar.c(21, c0004a.g("boolean"));
            hVar.a(153, fVar);
        } else if (cls == Byte.TYPE) {
            hVar.c(21, c0004a.g("byte"));
            hVar.a(153, fVar);
        } else if (cls == Short.TYPE) {
            hVar.c(21, c0004a.g("short"));
            hVar.a(153, fVar);
        } else if (cls == Integer.TYPE) {
            hVar.c(21, c0004a.g("int"));
            hVar.a(153, fVar);
        } else if (cls == Long.TYPE) {
            hVar.c(22, c0004a.g("long"));
            hVar.h(9);
            hVar.h(148);
            hVar.a(153, fVar);
        } else if (cls == Float.TYPE) {
            hVar.c(23, c0004a.g("float"));
            hVar.h(11);
            hVar.h(149);
            hVar.a(153, fVar);
        } else if (cls == Double.TYPE) {
            hVar.c(24, c0004a.g("double"));
            hVar.h(14);
            hVar.h(151);
            hVar.a(153, fVar);
        }
        hVar.l(fVar2);
    }

    private void s(Class cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, C0004a c0004a) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        q(hVar, dVar, c0004a, fVar);
        i(hVar, c0004a, dVar);
        hVar.c(58, c0004a.g("object"));
        g(hVar, dVar, c0004a, fVar);
        y(hVar, dVar, c0004a, fVar);
        hVar.l(fVar);
    }

    private void t(com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, C0004a c0004a) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        hVar.c(21, c0004a.g("hasNameFilters"));
        hVar.a(153, fVar);
        Class cls = dVar.f18283e;
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.c(25, 2);
        hVar.c(25, C0004a.f252h);
        if (cls == Byte.TYPE) {
            hVar.c(21, c0004a.g("byte"));
            hVar.j(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            hVar.c(21, c0004a.g("short"));
            hVar.j(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            hVar.c(21, c0004a.g("int"));
            hVar.j(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            hVar.c(21, c0004a.g("char"));
            hVar.j(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            hVar.c(22, c0004a.h("long", 2));
            hVar.j(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            hVar.c(23, c0004a.g("float"));
            hVar.j(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            hVar.c(24, c0004a.h("double", 2));
            hVar.j(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            hVar.c(21, c0004a.g("boolean"));
            hVar.j(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            hVar.c(25, c0004a.g("decimal"));
        } else if (cls == String.class) {
            hVar.c(25, c0004a.g("string"));
        } else if (cls.isEnum()) {
            hVar.c(25, c0004a.g("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            hVar.c(25, c0004a.g("list"));
        } else {
            hVar.c(25, c0004a.g("object"));
        }
        hVar.j(182, f246h, "processKey", "(L" + f241c + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        hVar.c(58, C0004a.f252h);
        hVar.l(fVar);
    }

    private void u(com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, C0004a c0004a, com.alibaba.fastjson.asm.f fVar) {
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        Class cls = dVar.f18283e;
        if (cls.isPrimitive()) {
            com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
            hVar.c(21, c0004a.g("checkValue"));
            hVar.a(154, fVar3);
            hVar.h(1);
            hVar.h(89);
            hVar.c(58, C0004a.f253i);
            hVar.c(58, C0004a.f254j);
            hVar.a(167, fVar2);
            hVar.l(fVar3);
        }
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.c(25, 0);
        hVar.d(Integer.valueOf(c0004a.f(dVar.f18279a)));
        String str = f246h;
        hVar.j(182, str, "getBeanContext", "(I)" + com.alibaba.fastjson.util.b.b(p.class));
        hVar.c(25, 2);
        hVar.c(25, C0004a.f252h);
        if (cls == Byte.TYPE) {
            hVar.c(21, c0004a.g("byte"));
            hVar.j(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            hVar.h(89);
            hVar.c(58, C0004a.f253i);
        } else if (cls == Short.TYPE) {
            hVar.c(21, c0004a.g("short"));
            hVar.j(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            hVar.h(89);
            hVar.c(58, C0004a.f253i);
        } else if (cls == Integer.TYPE) {
            hVar.c(21, c0004a.g("int"));
            hVar.j(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            hVar.h(89);
            hVar.c(58, C0004a.f253i);
        } else if (cls == Character.TYPE) {
            hVar.c(21, c0004a.g("char"));
            hVar.j(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            hVar.h(89);
            hVar.c(58, C0004a.f253i);
        } else if (cls == Long.TYPE) {
            hVar.c(22, c0004a.h("long", 2));
            hVar.j(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            hVar.h(89);
            hVar.c(58, C0004a.f253i);
        } else if (cls == Float.TYPE) {
            hVar.c(23, c0004a.g("float"));
            hVar.j(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            hVar.h(89);
            hVar.c(58, C0004a.f253i);
        } else if (cls == Double.TYPE) {
            hVar.c(24, c0004a.h("double", 2));
            hVar.j(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            hVar.h(89);
            hVar.c(58, C0004a.f253i);
        } else if (cls == Boolean.TYPE) {
            hVar.c(21, c0004a.g("boolean"));
            hVar.j(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            hVar.h(89);
            hVar.c(58, C0004a.f253i);
        } else if (cls == BigDecimal.class) {
            hVar.c(25, c0004a.g("decimal"));
            hVar.c(58, C0004a.f253i);
            hVar.c(25, C0004a.f253i);
        } else if (cls == String.class) {
            hVar.c(25, c0004a.g("string"));
            hVar.c(58, C0004a.f253i);
            hVar.c(25, C0004a.f253i);
        } else if (cls.isEnum()) {
            hVar.c(25, c0004a.g("enum"));
            hVar.c(58, C0004a.f253i);
            hVar.c(25, C0004a.f253i);
        } else if (List.class.isAssignableFrom(cls)) {
            hVar.c(25, c0004a.g("list"));
            hVar.c(58, C0004a.f253i);
            hVar.c(25, C0004a.f253i);
        } else {
            hVar.c(25, c0004a.g("object"));
            hVar.c(58, C0004a.f253i);
            hVar.c(25, C0004a.f253i);
        }
        hVar.j(182, str, "processValue", "(L" + f241c + ";" + com.alibaba.fastjson.util.b.b(p.class) + "Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;");
        hVar.c(58, C0004a.f254j);
        hVar.c(25, C0004a.f253i);
        hVar.c(25, C0004a.f254j);
        hVar.a(165, fVar2);
        y(hVar, dVar, c0004a, fVar);
        hVar.a(167, fVar);
        hVar.l(fVar2);
    }

    private void v(com.alibaba.fastjson.asm.h hVar, C0004a c0004a) {
        hVar.c(16, 44);
        hVar.c(54, c0004a.g("seperator"));
    }

    private void w(Class cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, C0004a c0004a) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        if (dVar.f18279a.equals(c0004a.f257c.f276c)) {
            hVar.c(25, 1);
            hVar.c(25, 4);
            hVar.c(25, 2);
            hVar.j(182, f241c, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
            hVar.a(154, fVar);
        }
        q(hVar, dVar, c0004a, fVar);
        i(hVar, c0004a, dVar);
        hVar.c(58, c0004a.g("string"));
        g(hVar, dVar, c0004a, fVar);
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
        hVar.c(25, c0004a.g("string"));
        hVar.a(199, fVar2);
        l(hVar, dVar, c0004a);
        hVar.a(167, fVar3);
        hVar.l(fVar2);
        if ("trim".equals(dVar.f18298t)) {
            hVar.c(25, c0004a.g("string"));
            hVar.j(182, "java/lang/String", "trim", "()Ljava/lang/String;");
            hVar.c(58, c0004a.g("string"));
        }
        if (c0004a.f258d) {
            hVar.c(25, c0004a.g("out"));
            hVar.c(21, c0004a.g("seperator"));
            hVar.c(25, C0004a.f252h);
            hVar.c(25, c0004a.g("string"));
            hVar.j(182, f244f, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            hVar.c(25, c0004a.g("out"));
            hVar.c(21, c0004a.g("seperator"));
            hVar.c(25, C0004a.f252h);
            hVar.c(25, c0004a.g("string"));
            hVar.j(182, f244f, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
        }
        v(hVar, c0004a);
        hVar.l(fVar3);
        hVar.l(fVar);
    }

    private void x(com.alibaba.fastjson.asm.h hVar, C0004a c0004a) {
        if (c0004a.f258d) {
            hVar.c(25, c0004a.g("out"));
            hVar.c(25, C0004a.f252h);
            hVar.j(182, f244f, "writeFieldNameDirect", "(Ljava/lang/String;)V");
        } else {
            hVar.c(25, c0004a.g("out"));
            hVar.c(25, C0004a.f252h);
            hVar.h(3);
            hVar.j(182, f244f, "writeFieldName", "(Ljava/lang/String;Z)V");
        }
    }

    private void y(com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, C0004a c0004a, com.alibaba.fastjson.asm.f fVar) {
        String str;
        com.alibaba.fastjson.asm.f fVar2;
        com.alibaba.fastjson.asm.f fVar3;
        String k11 = dVar.k();
        Class cls = dVar.f18283e;
        com.alibaba.fastjson.asm.f fVar4 = new com.alibaba.fastjson.asm.f();
        if (c0004a.f258d) {
            hVar.c(25, c0004a.g("object"));
        } else {
            hVar.c(25, C0004a.f254j);
        }
        hVar.h(89);
        hVar.c(58, c0004a.g("object"));
        hVar.a(199, fVar4);
        l(hVar, dVar, c0004a);
        hVar.a(167, fVar);
        hVar.l(fVar4);
        hVar.c(25, c0004a.g("out"));
        hVar.c(21, c0004a.g("seperator"));
        hVar.j(182, f244f, "write", "(I)V");
        x(hVar, c0004a);
        com.alibaba.fastjson.asm.f fVar5 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar6 = new com.alibaba.fastjson.asm.f();
        if (!Modifier.isPublic(cls.getModifiers()) || y4.h.w(cls)) {
            str = k11;
            fVar2 = fVar5;
            fVar3 = fVar6;
        } else {
            hVar.c(25, c0004a.g("object"));
            hVar.j(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(cls)));
            hVar.a(166, fVar6);
            j(c0004a, hVar, dVar);
            hVar.c(58, c0004a.g("fied_ser"));
            com.alibaba.fastjson.asm.f fVar7 = new com.alibaba.fastjson.asm.f();
            com.alibaba.fastjson.asm.f fVar8 = new com.alibaba.fastjson.asm.f();
            hVar.c(25, c0004a.g("fied_ser"));
            String str2 = f246h;
            hVar.f(193, str2);
            hVar.a(153, fVar7);
            int i11 = dVar.f18287i;
            str = k11;
            boolean z10 = (SerializerFeature.DisableCircularReferenceDetect.mask & i11) != 0;
            boolean z11 = (SerializerFeature.BeanToArray.mask & i11) != 0;
            String str3 = (z10 || (c0004a.f261g && c0004a.f258d)) ? z11 ? "writeAsArrayNonContext" : "writeDirectNonContext" : z11 ? "writeAsArray" : "write";
            hVar.c(25, c0004a.g("fied_ser"));
            hVar.f(PsExtractor.AUDIO_STREAM, str2);
            hVar.c(25, 1);
            hVar.c(25, c0004a.g("object"));
            hVar.c(25, C0004a.f252h);
            hVar.c(25, 0);
            hVar.b(180, c0004a.f256b, dVar.f18279a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            hVar.d(Integer.valueOf(dVar.f18287i));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("(L");
            String str4 = f241c;
            sb2.append(str4);
            sb2.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar.j(182, str2, str3, sb2.toString());
            hVar.a(167, fVar8);
            hVar.l(fVar7);
            hVar.c(25, c0004a.g("fied_ser"));
            hVar.c(25, 1);
            hVar.c(25, c0004a.g("object"));
            hVar.c(25, C0004a.f252h);
            hVar.c(25, 0);
            hVar.b(180, c0004a.f256b, dVar.f18279a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            hVar.d(Integer.valueOf(dVar.f18287i));
            hVar.j(185, f242d, "write", "(L" + str4 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar.l(fVar8);
            fVar2 = fVar5;
            hVar.a(167, fVar2);
            fVar3 = fVar6;
        }
        hVar.l(fVar3);
        hVar.c(25, 1);
        if (c0004a.f258d) {
            hVar.c(25, c0004a.g("object"));
        } else {
            hVar.c(25, C0004a.f254j);
        }
        if (str != null) {
            hVar.d(str);
            hVar.j(182, f241c, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
        } else {
            hVar.c(25, C0004a.f252h);
            Type type = dVar.f18284f;
            if ((type instanceof Class) && ((Class) type).isPrimitive()) {
                hVar.j(182, f241c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                if (dVar.f18283e == String.class) {
                    hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(String.class)));
                } else {
                    hVar.c(25, 0);
                    hVar.b(180, c0004a.f256b, dVar.f18279a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                }
                hVar.d(Integer.valueOf(dVar.f18287i));
                hVar.j(182, f241c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
        }
        hVar.l(fVar2);
        v(hVar, c0004a);
    }

    public p0 z(f1 f1Var) {
        String str;
        String str2;
        String str3;
        Class<String> cls;
        boolean z10;
        Class<f1> cls2;
        boolean z11;
        com.alibaba.fastjson.util.d[] dVarArr;
        a aVar;
        int i11;
        String str4;
        boolean z12;
        boolean z13;
        String str5;
        boolean z14;
        boolean z15;
        x4.d dVar;
        int i12;
        char c11;
        com.alibaba.fastjson.asm.c cVar;
        Class<String> cls3;
        int i13;
        int i14;
        Method method;
        Class cls4 = f1Var.f274a;
        if (cls4.isPrimitive()) {
            throw new JSONException("unsupportd class " + cls4.getName());
        }
        x4.d dVar2 = (x4.d) TypeUtils.N(cls4, x4.d.class);
        com.alibaba.fastjson.util.d[] dVarArr2 = f1Var.f278e;
        for (com.alibaba.fastjson.util.d dVar3 : dVarArr2) {
            if (dVar3.f18281c == null && (method = dVar3.f18280b) != null && method.getDeclaringClass().isInterface()) {
                return new p0(f1Var);
            }
        }
        com.alibaba.fastjson.util.d[] dVarArr3 = f1Var.f279f;
        boolean z16 = dVarArr3 == f1Var.f278e;
        if (dVarArr3.length > 256) {
            return new p0(f1Var);
        }
        for (com.alibaba.fastjson.util.d dVar4 : dVarArr3) {
            if (!com.alibaba.fastjson.util.b.a(dVar4.m().getName())) {
                return new p0(f1Var);
            }
        }
        String str6 = "ASMSerializer_" + this.f251b.incrementAndGet() + "_" + cls4.getSimpleName();
        Package r52 = a.class.getPackage();
        if (r52 != null) {
            String name = r52.getName();
            str2 = name + "." + str6;
            str = name.replace('.', '/') + "/" + str6;
        } else {
            str = str6;
            str2 = str;
        }
        com.alibaba.fastjson.asm.c cVar2 = new com.alibaba.fastjson.asm.c();
        cVar2.k(49, 33, str, f246h, new String[]{f242d});
        int length = dVarArr3.length;
        int i15 = 0;
        while (true) {
            str3 = str2;
            cls = String.class;
            if (i15 >= length) {
                break;
            }
            int i16 = length;
            com.alibaba.fastjson.util.d dVar5 = dVarArr3[i15];
            com.alibaba.fastjson.util.d[] dVarArr4 = dVarArr2;
            if (dVar5.f18283e.isPrimitive() || dVar5.f18283e == cls) {
                i14 = 1;
            } else {
                new com.alibaba.fastjson.asm.d(cVar2, 1, dVar5.f18279a + "_asm_fieldType", "Ljava/lang/reflect/Type;").c();
                if (List.class.isAssignableFrom(dVar5.f18283e)) {
                    new com.alibaba.fastjson.asm.d(cVar2, 1, dVar5.f18279a + "_asm_list_item_ser_", f243e).c();
                }
                i14 = 1;
                new com.alibaba.fastjson.asm.d(cVar2, 1, dVar5.f18279a + "_asm_ser_", f243e).c();
            }
            i15 += i14;
            length = i16;
            str2 = str3;
            dVarArr2 = dVarArr4;
        }
        com.alibaba.fastjson.util.d[] dVarArr5 = dVarArr2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        Class<f1> cls5 = f1.class;
        sb2.append(com.alibaba.fastjson.util.b.b(cls5));
        sb2.append(")V");
        com.alibaba.fastjson.asm.i iVar = new com.alibaba.fastjson.asm.i(cVar2, 1, "<init>", sb2.toString(), null, null);
        iVar.c(25, 0);
        iVar.c(25, 1);
        iVar.j(183, f246h, "<init>", "(" + com.alibaba.fastjson.util.b.b(cls5) + ")V");
        int i17 = 0;
        while (i17 < dVarArr3.length) {
            com.alibaba.fastjson.util.d dVar6 = dVarArr3[i17];
            if (dVar6.f18283e.isPrimitive()) {
                cVar = cVar2;
                cls3 = cls;
            } else if (dVar6.f18283e == cls) {
                cVar = cVar2;
                cls3 = cls;
                i13 = 1;
                i17 += i13;
                cVar2 = cVar;
                cls = cls3;
            } else {
                iVar.c(25, 0);
                if (dVar6.f18280b != null) {
                    iVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(dVar6.f18285g)));
                    iVar.d(dVar6.f18280b.getName());
                    cVar = cVar2;
                    cls3 = cls;
                    iVar.j(184, com.alibaba.fastjson.util.b.g(com.alibaba.fastjson.util.b.class), "getMethodType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
                } else {
                    cVar = cVar2;
                    cls3 = cls;
                    iVar.c(25, 0);
                    iVar.d(Integer.valueOf(i17));
                    iVar.j(183, f246h, "getFieldType", "(I)Ljava/lang/reflect/Type;");
                }
                iVar.b(181, str, dVar6.f18279a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            }
            i13 = 1;
            i17 += i13;
            cVar2 = cVar;
            cls = cls3;
        }
        com.alibaba.fastjson.asm.c cVar3 = cVar2;
        iVar.h(177);
        iVar.i(4, 4);
        iVar.k();
        if (dVar2 != null) {
            for (SerializerFeature serializerFeature : dVar2.serialzeFeatures()) {
                if (serializerFeature == SerializerFeature.DisableCircularReferenceDetect) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = false;
        int i18 = 0;
        while (true) {
            cls2 = cls5;
            z11 = z10;
            if (i18 >= 3) {
                break;
            }
            if (i18 == 0) {
                str5 = "write";
                z15 = z11;
                z14 = true;
            } else if (i18 == 1) {
                str5 = "writeNormal";
                z15 = z11;
                z14 = false;
            } else {
                str5 = "writeDirectNonContext";
                z14 = true;
                z15 = true;
            }
            com.alibaba.fastjson.util.d[] dVarArr6 = dVarArr3;
            int i19 = i18;
            com.alibaba.fastjson.asm.c cVar4 = cVar3;
            C0004a c0004a = new C0004a(dVarArr3, f1Var, str, z14, z15);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("(L");
            String str7 = f241c;
            sb3.append(str7);
            sb3.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            com.alibaba.fastjson.asm.i iVar2 = new com.alibaba.fastjson.asm.i(cVar3, 1, str5, sb3.toString(), null, new String[]{"java/io/IOException"});
            com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
            iVar2.c(25, 2);
            iVar2.a(199, fVar);
            iVar2.c(25, 1);
            iVar2.j(182, str7, "writeNull", "()V");
            iVar2.h(177);
            iVar2.l(fVar);
            iVar2.c(25, 1);
            iVar2.b(180, str7, "out", f245g);
            iVar2.c(58, c0004a.g("out"));
            if (!z16 && !c0004a.f258d && (dVar2 == null || dVar2.alphabetic())) {
                com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
                iVar2.c(25, c0004a.g("out"));
                iVar2.j(182, f244f, "isSortField", "()Z");
                iVar2.a(154, fVar2);
                iVar2.c(25, 0);
                iVar2.c(25, 1);
                iVar2.c(25, 2);
                iVar2.c(25, 3);
                iVar2.c(25, 4);
                iVar2.c(21, 5);
                iVar2.j(182, str, "writeUnsorted", "(L" + str7 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                iVar2.h(177);
                iVar2.l(fVar2);
            }
            if (!c0004a.f258d || z15) {
                dVar = dVar2;
                i12 = 177;
                c11 = 4;
            } else {
                com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
                com.alibaba.fastjson.asm.f fVar4 = new com.alibaba.fastjson.asm.f();
                iVar2.c(25, 0);
                iVar2.c(25, 1);
                dVar = dVar2;
                iVar2.j(182, f246h, "writeDirect", "(L" + str7 + ";)Z");
                iVar2.a(154, fVar4);
                iVar2.c(25, 0);
                iVar2.c(25, 1);
                iVar2.c(25, 2);
                iVar2.c(25, 3);
                iVar2.c(25, 4);
                iVar2.c(21, 5);
                iVar2.j(182, str, "writeNormal", "(L" + str7 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                iVar2.h(177);
                iVar2.l(fVar4);
                iVar2.c(25, c0004a.g("out"));
                iVar2.d(Integer.valueOf(SerializerFeature.DisableCircularReferenceDetect.mask));
                iVar2.j(182, f244f, "isEnabled", "(I)Z");
                iVar2.a(153, fVar3);
                iVar2.c(25, 0);
                iVar2.c(25, 1);
                iVar2.c(25, 2);
                iVar2.c(25, 3);
                c11 = 4;
                iVar2.c(25, 4);
                iVar2.c(21, 5);
                iVar2.j(182, str, "writeDirectNonContext", "(L" + str7 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                i12 = 177;
                iVar2.h(177);
                iVar2.l(fVar3);
            }
            iVar2.c(25, 2);
            iVar2.f(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls4));
            iVar2.c(58, c0004a.g("entity"));
            B(cls4, iVar2, dVarArr6, c0004a);
            iVar2.h(i12);
            iVar2.i(7, c0004a.f260f + 2);
            iVar2.k();
            i18 = i19 + 1;
            dVarArr3 = dVarArr6;
            dVar2 = dVar;
            cls5 = cls2;
            z10 = z11;
            cVar3 = cVar4;
        }
        com.alibaba.fastjson.util.d[] dVarArr7 = dVarArr3;
        com.alibaba.fastjson.asm.c cVar5 = cVar3;
        if (z16) {
            dVarArr = dVarArr7;
            aVar = this;
            i11 = 180;
        } else {
            dVarArr = dVarArr7;
            aVar = this;
            i11 = 180;
            C0004a c0004a2 = new C0004a(dVarArr, f1Var, str, false, z11);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("(L");
            String str8 = f241c;
            sb4.append(str8);
            sb4.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            com.alibaba.fastjson.asm.i iVar3 = new com.alibaba.fastjson.asm.i(cVar5, 1, "writeUnsorted", sb4.toString(), null, new String[]{"java/io/IOException"});
            iVar3.c(25, 1);
            iVar3.b(180, str8, "out", f245g);
            iVar3.c(58, c0004a2.g("out"));
            iVar3.c(25, 2);
            iVar3.f(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls4));
            iVar3.c(58, c0004a2.g("entity"));
            aVar.B(cls4, iVar3, dVarArr5, c0004a2);
            iVar3.h(177);
            iVar3.i(7, c0004a2.f260f + 2);
            iVar3.k();
        }
        int i20 = 0;
        for (int i21 = 3; i20 < i21; i21 = i21) {
            if (i20 == 0) {
                str4 = "writeAsArray";
                z13 = z11;
                z12 = true;
            } else if (i20 == 1) {
                str4 = "writeAsArrayNormal";
                z13 = z11;
                z12 = false;
            } else {
                str4 = "writeAsArrayNonContext";
                z12 = true;
                z13 = true;
            }
            C0004a c0004a3 = new C0004a(dVarArr, f1Var, str, z12, z13);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("(L");
            String str9 = f241c;
            sb5.append(str9);
            sb5.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            com.alibaba.fastjson.asm.i iVar4 = new com.alibaba.fastjson.asm.i(cVar5, 1, str4, sb5.toString(), null, new String[]{"java/io/IOException"});
            iVar4.c(25, 1);
            iVar4.b(i11, str9, "out", f245g);
            iVar4.c(58, c0004a3.g("out"));
            iVar4.c(25, 2);
            iVar4.f(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls4));
            iVar4.c(58, c0004a3.g("entity"));
            aVar.A(cls4, iVar4, dVarArr, c0004a3);
            iVar4.h(177);
            iVar4.i(7, c0004a3.f260f + 2);
            iVar4.k();
            i20++;
        }
        byte[] j11 = cVar5.j();
        return (p0) aVar.f250a.a(str3, j11, 0, j11.length).getConstructor(cls2).newInstance(f1Var);
    }
}
