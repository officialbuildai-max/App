package z4;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.util.TypeUtils;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import y4.a;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    static final String f79332c = com.alibaba.fastjson.util.b.g(y4.a.class);

    /* renamed from: d, reason: collision with root package name */
    static final String f79333d = com.alibaba.fastjson.util.b.g(y4.c.class);

    /* renamed from: a, reason: collision with root package name */
    public final com.alibaba.fastjson.util.a f79334a;

    /* renamed from: b, reason: collision with root package name */
    protected final AtomicLong f79335b = new AtomicLong();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: z4.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1003a {

        /* renamed from: a, reason: collision with root package name */
        private int f79336a;

        /* renamed from: b, reason: collision with root package name */
        private final Map f79337b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        private final Class f79338c;

        /* renamed from: d, reason: collision with root package name */
        private final com.alibaba.fastjson.util.h f79339d;

        /* renamed from: e, reason: collision with root package name */
        private final String f79340e;

        /* renamed from: f, reason: collision with root package name */
        private com.alibaba.fastjson.util.d[] f79341f;

        public C1003a(String str, y4.h hVar, com.alibaba.fastjson.util.h hVar2, int i11) {
            this.f79336a = -1;
            this.f79340e = str;
            this.f79338c = hVar2.f18324a;
            this.f79336a = i11;
            this.f79339d = hVar2;
            this.f79341f = hVar2.f18331h;
        }

        public String g(com.alibaba.fastjson.util.d dVar) {
            if (j(dVar.f18279a)) {
                return dVar.f18279a + "_asm_deser__";
            }
            return "_asm_deser__" + TypeUtils.K(dVar.f18279a);
        }

        public String h(com.alibaba.fastjson.util.d dVar) {
            if (j(dVar.f18279a)) {
                return dVar.f18279a + "_asm_prefix__";
            }
            return "asm_field_" + TypeUtils.K(dVar.f18279a);
        }

        public Class i() {
            Class cls = this.f79339d.f18325b;
            return cls == null ? this.f79338c : cls;
        }

        boolean j(String str) {
            for (int i11 = 0; i11 < str.length(); i11++) {
                char charAt = str.charAt(i11);
                if (charAt == 0) {
                    if (!com.alibaba.fastjson.util.f.g(charAt)) {
                        return false;
                    }
                } else if (!com.alibaba.fastjson.util.f.k(charAt)) {
                    return false;
                }
            }
            return true;
        }

        public int k(String str) {
            if (((Integer) this.f79337b.get(str)) == null) {
                Map map = this.f79337b;
                int i11 = this.f79336a;
                this.f79336a = i11 + 1;
                map.put(str, Integer.valueOf(i11));
            }
            return ((Integer) this.f79337b.get(str)).intValue();
        }

        public int l(String str, int i11) {
            if (((Integer) this.f79337b.get(str)) == null) {
                this.f79337b.put(str, Integer.valueOf(this.f79336a));
                this.f79336a += i11;
            }
            return ((Integer) this.f79337b.get(str)).intValue();
        }

        public int m(com.alibaba.fastjson.util.d dVar) {
            return k(dVar.f18279a + "_asm");
        }

        public int n(com.alibaba.fastjson.util.d dVar, int i11) {
            return l(dVar.f18279a + "_asm", i11);
        }
    }

    public a(ClassLoader classLoader) {
        this.f79334a = classLoader instanceof com.alibaba.fastjson.util.a ? (com.alibaba.fastjson.util.a) classLoader : new com.alibaba.fastjson.util.a(classLoader);
    }

    private void a(C1003a c1003a, com.alibaba.fastjson.asm.h hVar) {
        b(c1003a, hVar, true);
    }

    private void b(C1003a c1003a, com.alibaba.fastjson.asm.h hVar, boolean z10) {
        int length = c1003a.f79341f.length;
        for (int i11 = 0; i11 < length; i11++) {
            com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
            if (z10) {
                n(hVar, c1003a, i11, fVar);
            }
            o(c1003a, hVar, c1003a.f79341f[i11]);
            if (z10) {
                hVar.l(fVar);
            }
        }
    }

    private void c(com.alibaba.fastjson.asm.c cVar, C1003a c1003a) {
        if (Modifier.isPublic(c1003a.f79339d.f18326c.getModifiers())) {
            com.alibaba.fastjson.asm.i iVar = new com.alibaba.fastjson.asm.i(cVar, 1, "createInstance", "(L" + f79332c + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;", null, null);
            iVar.f(187, com.alibaba.fastjson.util.b.g(c1003a.i()));
            iVar.h(89);
            iVar.j(183, com.alibaba.fastjson.util.b.g(c1003a.i()), "<init>", "()V");
            iVar.h(176);
            iVar.i(3, 3);
            iVar.k();
        }
    }

    private void d(C1003a c1003a, com.alibaba.fastjson.asm.h hVar) {
        Constructor constructor = c1003a.f79339d.f18326c;
        if (Modifier.isPublic(constructor.getModifiers())) {
            hVar.f(187, com.alibaba.fastjson.util.b.g(c1003a.i()));
            hVar.h(89);
            hVar.j(183, com.alibaba.fastjson.util.b.g(constructor.getDeclaringClass()), "<init>", "()V");
        } else {
            hVar.c(25, 0);
            hVar.c(25, 1);
            hVar.c(25, 0);
            hVar.b(180, com.alibaba.fastjson.util.b.g(o.class), "clazz", "Ljava/lang/Class;");
            hVar.j(183, com.alibaba.fastjson.util.b.g(o.class), "createInstance", "(L" + f79332c + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
            hVar.f(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(c1003a.i()));
        }
        hVar.c(58, c1003a.k("instance"));
    }

    private void e(C1003a c1003a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, Class cls, int i11) {
        l(c1003a, hVar, dVar);
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        if ((dVar.f18288j & Feature.SupportArrayToBean.mask) != 0) {
            hVar.h(89);
            hVar.f(193, com.alibaba.fastjson.util.b.g(o.class));
            hVar.a(153, fVar);
            hVar.f(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(o.class));
            hVar.c(25, 1);
            if (dVar.f18284f instanceof Class) {
                hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(dVar.f18283e)));
            } else {
                hVar.c(25, 0);
                hVar.d(Integer.valueOf(i11));
                hVar.j(182, com.alibaba.fastjson.util.b.g(o.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            }
            hVar.d(dVar.f18279a);
            hVar.d(Integer.valueOf(dVar.f18288j));
            hVar.j(182, com.alibaba.fastjson.util.b.g(o.class), "deserialze", "(L" + f79332c + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
            hVar.f(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls));
            hVar.c(58, c1003a.m(dVar));
            hVar.a(167, fVar2);
            hVar.l(fVar);
        }
        hVar.c(25, 1);
        if (dVar.f18284f instanceof Class) {
            hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(dVar.f18283e)));
        } else {
            hVar.c(25, 0);
            hVar.d(Integer.valueOf(i11));
            hVar.j(182, com.alibaba.fastjson.util.b.g(o.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
        }
        hVar.d(dVar.f18279a);
        hVar.j(185, com.alibaba.fastjson.util.b.g(b2.class), "deserialze", "(L" + f79332c + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        hVar.f(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls));
        hVar.c(58, c1003a.m(dVar));
        hVar.l(fVar2);
    }

    private void f(C1003a c1003a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.asm.f fVar) {
        hVar.g(21, c1003a.k("matchedCount"));
        hVar.a(158, fVar);
        hVar.c(25, c1003a.k("lexer"));
        hVar.j(182, f79333d, "token", "()I");
        hVar.d(13);
        hVar.a(160, fVar);
        r(c1003a, hVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0ac5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g(com.alibaba.fastjson.asm.c r31, z4.a.C1003a r32) {
        /*
            Method dump skipped, instructions count: 3268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.a.g(com.alibaba.fastjson.asm.c, z4.a$a):void");
    }

    private void h(com.alibaba.fastjson.asm.c cVar, C1003a c1003a) {
        int i11;
        Class<o> cls;
        int i12;
        char c11;
        char c12;
        boolean z10;
        char c13;
        int i13;
        int i14;
        char c14;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(L");
        String str = f79332c;
        sb2.append(str);
        sb2.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        com.alibaba.fastjson.asm.i iVar = new com.alibaba.fastjson.asm.i(cVar, 1, "deserialzeArrayMapping", sb2.toString(), null, null);
        w(c1003a, iVar);
        iVar.c(25, c1003a.k("lexer"));
        iVar.c(25, 1);
        iVar.j(182, str, "getSymbolTable", "()" + com.alibaba.fastjson.util.b.b(y4.i.class));
        iVar.j(182, f79333d, "scanTypeName", "(" + com.alibaba.fastjson.util.b.b(y4.i.class) + ")Ljava/lang/String;");
        iVar.c(58, c1003a.k("typeName"));
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        iVar.c(25, c1003a.k("typeName"));
        iVar.a(198, fVar);
        iVar.c(25, 1);
        iVar.j(182, str, "getConfig", "()" + com.alibaba.fastjson.util.b.b(y4.h.class));
        iVar.c(25, 0);
        Class<o> cls2 = o.class;
        iVar.b(180, com.alibaba.fastjson.util.b.g(cls2), "beanInfo", com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.util.h.class));
        iVar.c(25, c1003a.k("typeName"));
        iVar.j(184, com.alibaba.fastjson.util.b.g(cls2), "getSeeAlso", "(" + com.alibaba.fastjson.util.b.b(y4.h.class) + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.util.h.class) + "Ljava/lang/String;)" + com.alibaba.fastjson.util.b.b(cls2));
        iVar.c(58, c1003a.k("userTypeDeser"));
        iVar.c(25, c1003a.k("userTypeDeser"));
        iVar.f(193, com.alibaba.fastjson.util.b.g(cls2));
        iVar.a(153, fVar);
        iVar.c(25, c1003a.k("userTypeDeser"));
        iVar.c(25, 1);
        iVar.c(25, 2);
        iVar.c(25, 3);
        iVar.c(25, 4);
        iVar.j(182, com.alibaba.fastjson.util.b.g(cls2), "deserialzeArrayMapping", "(L" + str + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        iVar.h(176);
        iVar.l(fVar);
        d(c1003a, iVar);
        com.alibaba.fastjson.util.d[] dVarArr = c1003a.f79339d.f18332i;
        int length = dVarArr.length;
        int i15 = 0;
        while (i15 < length) {
            boolean z11 = i15 == length + (-1);
            int i16 = z11 ? 93 : 44;
            com.alibaba.fastjson.util.d dVar = dVarArr[i15];
            Class cls3 = dVar.f18283e;
            Type type = dVar.f18284f;
            int i17 = length;
            com.alibaba.fastjson.util.d[] dVarArr2 = dVarArr;
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                i11 = i15;
                cls = cls2;
                i12 = i17;
                c11 = 184;
                c12 = ':';
                z10 = true;
                c13 = 180;
                iVar.c(25, c1003a.k("lexer"));
                iVar.c(16, i16);
                iVar.j(182, f79333d, "scanInt", "(C)I");
                iVar.c(54, c1003a.m(dVar));
            } else {
                boolean z12 = z11;
                int i18 = i15;
                if (cls3 == Byte.class) {
                    iVar.c(25, c1003a.k("lexer"));
                    iVar.c(16, i16);
                    String str2 = f79333d;
                    iVar.j(182, str2, "scanInt", "(C)I");
                    iVar.j(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                    iVar.c(58, c1003a.m(dVar));
                    com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
                    iVar.c(25, c1003a.k("lexer"));
                    iVar.b(180, str2, "matchStat", "I");
                    iVar.d(5);
                    iVar.a(160, fVar2);
                    iVar.h(1);
                    iVar.c(58, c1003a.m(dVar));
                    iVar.l(fVar2);
                } else if (cls3 == Short.class) {
                    iVar.c(25, c1003a.k("lexer"));
                    iVar.c(16, i16);
                    String str3 = f79333d;
                    iVar.j(182, str3, "scanInt", "(C)I");
                    iVar.j(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                    iVar.c(58, c1003a.m(dVar));
                    com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
                    iVar.c(25, c1003a.k("lexer"));
                    iVar.b(180, str3, "matchStat", "I");
                    iVar.d(5);
                    iVar.a(160, fVar3);
                    iVar.h(1);
                    iVar.c(58, c1003a.m(dVar));
                    iVar.l(fVar3);
                } else if (cls3 == Integer.class) {
                    iVar.c(25, c1003a.k("lexer"));
                    iVar.c(16, i16);
                    String str4 = f79333d;
                    iVar.j(182, str4, "scanInt", "(C)I");
                    iVar.j(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    iVar.c(58, c1003a.m(dVar));
                    com.alibaba.fastjson.asm.f fVar4 = new com.alibaba.fastjson.asm.f();
                    iVar.c(25, c1003a.k("lexer"));
                    iVar.b(180, str4, "matchStat", "I");
                    iVar.d(5);
                    iVar.a(160, fVar4);
                    iVar.h(1);
                    iVar.c(58, c1003a.m(dVar));
                    iVar.l(fVar4);
                } else if (cls3 == Long.TYPE) {
                    iVar.c(25, c1003a.k("lexer"));
                    iVar.c(16, i16);
                    iVar.j(182, f79333d, "scanLong", "(C)J");
                    iVar.c(55, c1003a.n(dVar, 2));
                } else if (cls3 == Long.class) {
                    iVar.c(25, c1003a.k("lexer"));
                    iVar.c(16, i16);
                    String str5 = f79333d;
                    iVar.j(182, str5, "scanLong", "(C)J");
                    iVar.j(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                    iVar.c(58, c1003a.m(dVar));
                    com.alibaba.fastjson.asm.f fVar5 = new com.alibaba.fastjson.asm.f();
                    iVar.c(25, c1003a.k("lexer"));
                    iVar.b(180, str5, "matchStat", "I");
                    iVar.d(5);
                    iVar.a(160, fVar5);
                    iVar.h(1);
                    iVar.c(58, c1003a.m(dVar));
                    iVar.l(fVar5);
                } else if (cls3 == Boolean.TYPE) {
                    iVar.c(25, c1003a.k("lexer"));
                    iVar.c(16, i16);
                    iVar.j(182, f79333d, "scanBoolean", "(C)Z");
                    iVar.c(54, c1003a.m(dVar));
                } else if (cls3 == Float.TYPE) {
                    iVar.c(25, c1003a.k("lexer"));
                    iVar.c(16, i16);
                    iVar.j(182, f79333d, "scanFloat", "(C)F");
                    iVar.c(56, c1003a.m(dVar));
                } else if (cls3 == Float.class) {
                    iVar.c(25, c1003a.k("lexer"));
                    iVar.c(16, i16);
                    String str6 = f79333d;
                    iVar.j(182, str6, "scanFloat", "(C)F");
                    iVar.j(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                    iVar.c(58, c1003a.m(dVar));
                    com.alibaba.fastjson.asm.f fVar6 = new com.alibaba.fastjson.asm.f();
                    iVar.c(25, c1003a.k("lexer"));
                    iVar.b(180, str6, "matchStat", "I");
                    iVar.d(5);
                    iVar.a(160, fVar6);
                    iVar.h(1);
                    iVar.c(58, c1003a.m(dVar));
                    iVar.l(fVar6);
                } else if (cls3 == Double.TYPE) {
                    iVar.c(25, c1003a.k("lexer"));
                    iVar.c(16, i16);
                    iVar.j(182, f79333d, "scanDouble", "(C)D");
                    iVar.c(57, c1003a.n(dVar, 2));
                } else if (cls3 == Double.class) {
                    iVar.c(25, c1003a.k("lexer"));
                    iVar.c(16, i16);
                    String str7 = f79333d;
                    iVar.j(182, str7, "scanDouble", "(C)D");
                    iVar.j(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                    iVar.c(58, c1003a.m(dVar));
                    com.alibaba.fastjson.asm.f fVar7 = new com.alibaba.fastjson.asm.f();
                    iVar.c(25, c1003a.k("lexer"));
                    iVar.b(180, str7, "matchStat", "I");
                    iVar.d(5);
                    iVar.a(160, fVar7);
                    iVar.h(1);
                    iVar.c(58, c1003a.m(dVar));
                    iVar.l(fVar7);
                } else if (cls3 == Character.TYPE) {
                    iVar.c(25, c1003a.k("lexer"));
                    iVar.c(16, i16);
                    iVar.j(182, f79333d, "scanString", "(C)Ljava/lang/String;");
                    iVar.h(3);
                    iVar.j(182, "java/lang/String", "charAt", "(I)C");
                    iVar.c(54, c1003a.m(dVar));
                } else {
                    if (cls3 == String.class) {
                        iVar.c(25, c1003a.k("lexer"));
                        iVar.c(16, i16);
                        iVar.j(182, f79333d, "scanString", "(C)Ljava/lang/String;");
                        c14 = ':';
                        iVar.c(58, c1003a.m(dVar));
                    } else if (cls3 == BigDecimal.class) {
                        iVar.c(25, c1003a.k("lexer"));
                        iVar.c(16, i16);
                        iVar.j(182, f79333d, "scanDecimal", "(C)Ljava/math/BigDecimal;");
                        c14 = ':';
                        iVar.c(58, c1003a.m(dVar));
                    } else if (cls3 == Date.class) {
                        iVar.c(25, c1003a.k("lexer"));
                        iVar.c(16, i16);
                        iVar.j(182, f79333d, "scanDate", "(C)Ljava/util/Date;");
                        c14 = ':';
                        iVar.c(58, c1003a.m(dVar));
                    } else if (cls3 == UUID.class) {
                        iVar.c(25, c1003a.k("lexer"));
                        iVar.c(16, i16);
                        iVar.j(182, f79333d, "scanUUID", "(C)Ljava/util/UUID;");
                        c14 = ':';
                        iVar.c(58, c1003a.m(dVar));
                    } else if (cls3.isEnum()) {
                        com.alibaba.fastjson.asm.f fVar8 = new com.alibaba.fastjson.asm.f();
                        com.alibaba.fastjson.asm.f fVar9 = new com.alibaba.fastjson.asm.f();
                        com.alibaba.fastjson.asm.f fVar10 = new com.alibaba.fastjson.asm.f();
                        com.alibaba.fastjson.asm.f fVar11 = new com.alibaba.fastjson.asm.f();
                        cls = cls2;
                        iVar.c(25, c1003a.k("lexer"));
                        String str8 = f79333d;
                        iVar.j(182, str8, "getCurrent", "()C");
                        iVar.h(89);
                        iVar.c(54, c1003a.k("ch"));
                        iVar.d(110);
                        iVar.a(159, fVar11);
                        iVar.c(21, c1003a.k("ch"));
                        iVar.d(34);
                        iVar.a(160, fVar8);
                        iVar.l(fVar11);
                        iVar.c(25, c1003a.k("lexer"));
                        iVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(cls3)));
                        iVar.c(25, 1);
                        iVar.j(182, f79332c, "getSymbolTable", "()" + com.alibaba.fastjson.util.b.b(y4.i.class));
                        iVar.c(16, i16);
                        iVar.j(182, str8, "scanEnum", "(Ljava/lang/Class;" + com.alibaba.fastjson.util.b.b(y4.i.class) + "C)Ljava/lang/Enum;");
                        iVar.a(167, fVar10);
                        iVar.l(fVar8);
                        iVar.c(21, c1003a.k("ch"));
                        iVar.d(48);
                        iVar.a(161, fVar9);
                        iVar.c(21, c1003a.k("ch"));
                        iVar.d(57);
                        iVar.a(163, fVar9);
                        l(c1003a, iVar, dVar);
                        iVar.f(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(h.class));
                        iVar.c(25, c1003a.k("lexer"));
                        iVar.c(16, i16);
                        iVar.j(182, str8, "scanInt", "(C)I");
                        iVar.j(182, com.alibaba.fastjson.util.b.g(h.class), "valueOf", "(I)Ljava/lang/Enum;");
                        iVar.a(167, fVar10);
                        iVar.l(fVar9);
                        iVar.c(25, 0);
                        iVar.c(25, c1003a.k("lexer"));
                        iVar.c(16, i16);
                        iVar.j(182, com.alibaba.fastjson.util.b.g(cls), "scanEnum", "(L" + str8 + ";C)Ljava/lang/Enum;");
                        iVar.l(fVar10);
                        iVar.f(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls3));
                        iVar.c(58, c1003a.m(dVar));
                        c12 = ':';
                        i12 = i17;
                        i11 = i18;
                        c11 = 184;
                        z10 = true;
                        c13 = 180;
                    } else {
                        cls = cls2;
                        if (Collection.class.isAssignableFrom(cls3)) {
                            Class S = TypeUtils.S(type);
                            if (S == String.class) {
                                if (cls3 == List.class || cls3 == Collections.class || cls3 == ArrayList.class) {
                                    iVar.f(187, com.alibaba.fastjson.util.b.g(ArrayList.class));
                                    iVar.h(89);
                                    iVar.j(183, com.alibaba.fastjson.util.b.g(ArrayList.class), "<init>", "()V");
                                } else {
                                    iVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(cls3)));
                                    iVar.j(184, com.alibaba.fastjson.util.b.g(TypeUtils.class), "createCollection", "(Ljava/lang/Class;)Ljava/util/Collection;");
                                }
                                iVar.c(58, c1003a.m(dVar));
                                iVar.c(25, c1003a.k("lexer"));
                                iVar.c(25, c1003a.m(dVar));
                                iVar.c(16, i16);
                                String str9 = f79333d;
                                iVar.j(182, str9, "scanStringArray", "(Ljava/util/Collection;C)V");
                                com.alibaba.fastjson.asm.f fVar12 = new com.alibaba.fastjson.asm.f();
                                iVar.c(25, c1003a.k("lexer"));
                                iVar.b(180, str9, "matchStat", "I");
                                iVar.d(5);
                                iVar.a(160, fVar12);
                                iVar.h(1);
                                iVar.c(58, c1003a.m(dVar));
                                iVar.l(fVar12);
                                i14 = i18;
                                c11 = 184;
                            } else {
                                com.alibaba.fastjson.asm.f fVar13 = new com.alibaba.fastjson.asm.f();
                                iVar.c(25, c1003a.k("lexer"));
                                String str10 = f79333d;
                                iVar.j(182, str10, "token", "()I");
                                iVar.c(54, c1003a.k("token"));
                                iVar.c(21, c1003a.k("token"));
                                int i19 = i18 == 0 ? 14 : 16;
                                iVar.d(Integer.valueOf(i19));
                                iVar.a(159, fVar13);
                                iVar.c(25, 1);
                                iVar.d(Integer.valueOf(i19));
                                String str11 = f79332c;
                                iVar.j(182, str11, "throwException", "(I)V");
                                iVar.l(fVar13);
                                com.alibaba.fastjson.asm.f fVar14 = new com.alibaba.fastjson.asm.f();
                                com.alibaba.fastjson.asm.f fVar15 = new com.alibaba.fastjson.asm.f();
                                iVar.c(25, c1003a.k("lexer"));
                                iVar.j(182, str10, "getCurrent", "()C");
                                iVar.c(16, 91);
                                iVar.a(160, fVar14);
                                iVar.c(25, c1003a.k("lexer"));
                                iVar.j(182, str10, "next", "()C");
                                iVar.h(87);
                                iVar.c(25, c1003a.k("lexer"));
                                iVar.d(14);
                                iVar.j(182, str10, "setToken", "(I)V");
                                iVar.a(167, fVar15);
                                iVar.l(fVar14);
                                iVar.c(25, c1003a.k("lexer"));
                                iVar.d(14);
                                iVar.j(182, str10, "nextToken", "(I)V");
                                iVar.l(fVar15);
                                i14 = i18;
                                p(iVar, cls3, i14, false);
                                iVar.h(89);
                                iVar.c(58, c1003a.m(dVar));
                                k(c1003a, iVar, dVar, S);
                                iVar.c(25, 1);
                                iVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(S)));
                                iVar.c(25, 3);
                                c11 = 184;
                                iVar.j(184, com.alibaba.fastjson.util.b.g(cls), "parseArray", "(Ljava/util/Collection;" + com.alibaba.fastjson.util.b.b(b2.class) + "L" + str11 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                            }
                            i11 = i14;
                            i12 = i17;
                            c12 = ':';
                            z10 = true;
                            c13 = 180;
                        } else {
                            c11 = 184;
                            if (cls3.isArray()) {
                                iVar.c(25, c1003a.k("lexer"));
                                iVar.d(14);
                                iVar.j(182, f79333d, "nextToken", "(I)V");
                                z10 = true;
                                iVar.c(25, 1);
                                iVar.c(25, 0);
                                iVar.d(Integer.valueOf(i18));
                                iVar.j(182, com.alibaba.fastjson.util.b.g(cls), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                                iVar.j(182, f79332c, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
                                iVar.f(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls3));
                                iVar.c(58, c1003a.m(dVar));
                                c12 = ':';
                                i11 = i18;
                                i12 = i17;
                                c13 = 180;
                            } else {
                                z10 = true;
                                com.alibaba.fastjson.asm.f fVar16 = new com.alibaba.fastjson.asm.f();
                                com.alibaba.fastjson.asm.f fVar17 = new com.alibaba.fastjson.asm.f();
                                if (cls3 == Date.class) {
                                    iVar.c(25, c1003a.k("lexer"));
                                    String str12 = f79333d;
                                    iVar.j(182, str12, "getCurrent", "()C");
                                    iVar.d(49);
                                    iVar.a(160, fVar16);
                                    iVar.f(187, com.alibaba.fastjson.util.b.g(Date.class));
                                    iVar.h(89);
                                    iVar.c(25, c1003a.k("lexer"));
                                    i13 = 16;
                                    iVar.c(16, i16);
                                    iVar.j(182, str12, "scanLong", "(C)J");
                                    iVar.j(183, com.alibaba.fastjson.util.b.g(Date.class), "<init>", "(J)V");
                                    c12 = ':';
                                    iVar.c(58, c1003a.m(dVar));
                                    iVar.a(167, fVar17);
                                } else {
                                    i13 = 16;
                                    c12 = ':';
                                }
                                iVar.l(fVar16);
                                q(c1003a, iVar, 14);
                                i11 = i18;
                                i12 = i17;
                                c13 = 180;
                                e(c1003a, iVar, dVar, cls3, i11);
                                iVar.c(25, c1003a.k("lexer"));
                                iVar.j(182, f79333d, "token", "()I");
                                iVar.d(15);
                                iVar.a(159, fVar17);
                                iVar.c(25, 0);
                                iVar.c(25, c1003a.k("lexer"));
                                if (z12) {
                                    iVar.d(15);
                                } else {
                                    iVar.d(Integer.valueOf(i13));
                                }
                                iVar.j(183, com.alibaba.fastjson.util.b.g(cls), "check", "(" + com.alibaba.fastjson.util.b.b(y4.b.class) + "I)V");
                                iVar.l(fVar17);
                            }
                        }
                    }
                    c12 = c14;
                    cls = cls2;
                    i12 = i17;
                    i11 = i18;
                    c11 = 184;
                    z10 = true;
                    c13 = 180;
                }
                cls = cls2;
                i12 = i17;
                i11 = i18;
                c11 = 184;
                c12 = ':';
                z10 = true;
                c13 = 180;
            }
            i15 = i11 + 1;
            length = i12;
            dVarArr = dVarArr2;
            cls2 = cls;
        }
        b(c1003a, iVar, false);
        com.alibaba.fastjson.asm.f fVar18 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar19 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar20 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar21 = new com.alibaba.fastjson.asm.f();
        iVar.c(25, c1003a.k("lexer"));
        String str13 = f79333d;
        iVar.j(182, str13, "getCurrent", "()C");
        iVar.h(89);
        iVar.c(54, c1003a.k("ch"));
        iVar.c(16, 44);
        iVar.a(160, fVar19);
        iVar.c(25, c1003a.k("lexer"));
        iVar.j(182, str13, "next", "()C");
        iVar.h(87);
        iVar.c(25, c1003a.k("lexer"));
        iVar.d(16);
        iVar.j(182, str13, "setToken", "(I)V");
        iVar.a(167, fVar21);
        iVar.l(fVar19);
        iVar.c(21, c1003a.k("ch"));
        iVar.c(16, 93);
        iVar.a(160, fVar20);
        iVar.c(25, c1003a.k("lexer"));
        iVar.j(182, str13, "next", "()C");
        iVar.h(87);
        iVar.c(25, c1003a.k("lexer"));
        iVar.d(15);
        iVar.j(182, str13, "setToken", "(I)V");
        iVar.a(167, fVar21);
        iVar.l(fVar20);
        iVar.c(21, c1003a.k("ch"));
        iVar.c(16, 26);
        iVar.a(160, fVar18);
        iVar.c(25, c1003a.k("lexer"));
        iVar.j(182, str13, "next", "()C");
        iVar.h(87);
        iVar.c(25, c1003a.k("lexer"));
        iVar.d(20);
        iVar.j(182, str13, "setToken", "(I)V");
        iVar.a(167, fVar21);
        iVar.l(fVar18);
        iVar.c(25, c1003a.k("lexer"));
        iVar.d(16);
        iVar.j(182, str13, "nextToken", "(I)V");
        iVar.l(fVar21);
        iVar.c(25, c1003a.k("instance"));
        iVar.h(176);
        iVar.i(5, c1003a.f79336a);
        iVar.k();
    }

    private void i(C1003a c1003a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.asm.f fVar, com.alibaba.fastjson.util.d dVar, Class cls, Class cls2, int i11) {
        String str;
        String str2;
        String str3;
        String str4;
        com.alibaba.fastjson.asm.f fVar2;
        int i12;
        int i13;
        int i14;
        com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
        String str5 = f79333d;
        hVar.j(182, str5, "matchField", "([C)Z");
        hVar.a(153, fVar3);
        u(hVar, c1003a, i11);
        com.alibaba.fastjson.asm.f fVar4 = new com.alibaba.fastjson.asm.f();
        hVar.c(25, c1003a.k("lexer"));
        hVar.j(182, str5, "token", "()I");
        hVar.d(8);
        hVar.a(160, fVar4);
        hVar.c(25, c1003a.k("lexer"));
        hVar.d(16);
        hVar.j(182, str5, "nextToken", "(I)V");
        hVar.a(167, fVar3);
        hVar.l(fVar4);
        com.alibaba.fastjson.asm.f fVar5 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar6 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar7 = new com.alibaba.fastjson.asm.f();
        hVar.c(25, c1003a.k("lexer"));
        hVar.j(182, str5, "token", "()I");
        hVar.d(21);
        hVar.a(160, fVar6);
        hVar.c(25, c1003a.k("lexer"));
        hVar.d(14);
        hVar.j(182, str5, "nextToken", "(I)V");
        p(hVar, cls, i11, true);
        hVar.a(167, fVar5);
        hVar.l(fVar6);
        hVar.c(25, c1003a.k("lexer"));
        hVar.j(182, str5, "token", "()I");
        hVar.d(14);
        hVar.a(159, fVar7);
        hVar.c(25, c1003a.k("lexer"));
        hVar.j(182, str5, "token", "()I");
        hVar.d(12);
        hVar.a(160, fVar);
        p(hVar, cls, i11, false);
        hVar.c(58, c1003a.m(dVar));
        k(c1003a, hVar, dVar, cls2);
        hVar.c(25, 1);
        hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(cls2)));
        hVar.h(3);
        hVar.j(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        String g11 = com.alibaba.fastjson.util.b.g(b2.class);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(L");
        String str6 = f79332c;
        sb2.append(str6);
        sb2.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        hVar.j(185, g11, "deserialze", sb2.toString());
        hVar.c(58, c1003a.k("list_item_value"));
        hVar.c(25, c1003a.m(dVar));
        hVar.c(25, c1003a.k("list_item_value"));
        if (cls.isInterface()) {
            str = "list_item_value";
            hVar.j(185, com.alibaba.fastjson.util.b.g(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            str = "list_item_value";
            hVar.j(182, com.alibaba.fastjson.util.b.g(cls), "add", "(Ljava/lang/Object;)Z");
        }
        hVar.h(87);
        hVar.a(167, fVar3);
        hVar.l(fVar7);
        p(hVar, cls, i11, false);
        hVar.l(fVar5);
        hVar.c(58, c1003a.m(dVar));
        boolean w11 = y4.h.w(dVar.f18283e);
        k(c1003a, hVar, dVar, cls2);
        if (w11) {
            hVar.j(185, com.alibaba.fastjson.util.b.g(b2.class), "getFastMatchToken", "()I");
            hVar.c(54, c1003a.k("fastMatchToken"));
            hVar.c(25, c1003a.k("lexer"));
            hVar.c(21, c1003a.k("fastMatchToken"));
            str2 = str5;
            str3 = "nextToken";
            str4 = "(I)V";
            hVar.j(182, str2, str3, str4);
            fVar2 = fVar3;
        } else {
            str2 = str5;
            str3 = "nextToken";
            str4 = "(I)V";
            hVar.h(87);
            hVar.d(12);
            fVar2 = fVar3;
            hVar.c(54, c1003a.k("fastMatchToken"));
            q(c1003a, hVar, 12);
        }
        hVar.c(25, 1);
        String str7 = str4;
        hVar.j(182, str6, "getContext", "()" + com.alibaba.fastjson.util.b.b(y4.g.class));
        hVar.c(58, c1003a.k("listContext"));
        hVar.c(25, 1);
        hVar.c(25, c1003a.m(dVar));
        hVar.d(dVar.f18279a);
        hVar.j(182, str6, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)" + com.alibaba.fastjson.util.b.b(y4.g.class));
        hVar.h(87);
        com.alibaba.fastjson.asm.f fVar8 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar9 = new com.alibaba.fastjson.asm.f();
        hVar.h(3);
        String str8 = str3;
        hVar.c(54, c1003a.k("i"));
        hVar.l(fVar8);
        hVar.c(25, c1003a.k("lexer"));
        hVar.j(182, str2, "token", "()I");
        hVar.d(15);
        hVar.a(159, fVar9);
        hVar.c(25, 0);
        hVar.b(180, c1003a.f79340e, dVar.f18279a + "_asm_list_item_deser__", com.alibaba.fastjson.util.b.b(b2.class));
        hVar.c(25, 1);
        hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(cls2)));
        hVar.c(21, c1003a.k("i"));
        hVar.j(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        hVar.j(185, com.alibaba.fastjson.util.b.g(b2.class), "deserialze", "(L" + str6 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        String str9 = str;
        hVar.c(58, c1003a.k(str9));
        hVar.e(c1003a.k("i"), 1);
        hVar.c(25, c1003a.m(dVar));
        hVar.c(25, c1003a.k(str9));
        if (cls.isInterface()) {
            hVar.j(185, com.alibaba.fastjson.util.b.g(cls), "add", "(Ljava/lang/Object;)Z");
            i13 = 87;
            i12 = 182;
        } else {
            i12 = 182;
            hVar.j(182, com.alibaba.fastjson.util.b.g(cls), "add", "(Ljava/lang/Object;)Z");
            i13 = 87;
        }
        hVar.h(i13);
        hVar.c(25, 1);
        hVar.c(25, c1003a.m(dVar));
        hVar.j(i12, str6, "checkListResolve", "(Ljava/util/Collection;)V");
        hVar.c(25, c1003a.k("lexer"));
        hVar.j(i12, str2, "token", "()I");
        hVar.d(16);
        hVar.a(160, fVar8);
        if (w11) {
            hVar.c(25, c1003a.k("lexer"));
            hVar.c(21, c1003a.k("fastMatchToken"));
            hVar.j(i12, str2, str8, str7);
            i14 = 167;
        } else {
            q(c1003a, hVar, 12);
            i14 = 167;
        }
        hVar.a(i14, fVar8);
        hVar.l(fVar9);
        hVar.c(25, 1);
        hVar.c(25, c1003a.k("listContext"));
        hVar.j(182, str6, "setContext", "(" + com.alibaba.fastjson.util.b.b(y4.g.class) + ")V");
        hVar.c(25, c1003a.k("lexer"));
        hVar.j(182, str2, "token", "()I");
        hVar.d(15);
        hVar.a(160, fVar);
        r(c1003a, hVar);
        hVar.l(fVar2);
    }

    private void j(C1003a c1003a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.asm.f fVar, com.alibaba.fastjson.util.d dVar, Class cls, int i11) {
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
        hVar.c(25, c1003a.k("lexer"));
        hVar.c(25, 0);
        hVar.b(180, c1003a.f79340e, c1003a.h(dVar), "[C");
        hVar.j(182, f79333d, "matchField", "([C)Z");
        hVar.a(154, fVar2);
        hVar.h(1);
        hVar.c(58, c1003a.m(dVar));
        hVar.a(167, fVar3);
        hVar.l(fVar2);
        u(hVar, c1003a, i11);
        hVar.c(21, c1003a.k("matchedCount"));
        hVar.h(4);
        hVar.h(96);
        hVar.c(54, c1003a.k("matchedCount"));
        e(c1003a, hVar, dVar, cls, i11);
        hVar.c(25, 1);
        String str = f79332c;
        hVar.j(182, str, "getResolveStatus", "()I");
        hVar.d(1);
        hVar.a(160, fVar3);
        hVar.c(25, 1);
        hVar.j(182, str, "getLastResolveTask", "()" + com.alibaba.fastjson.util.b.b(a.C0994a.class));
        hVar.c(58, c1003a.k("resolveTask"));
        hVar.c(25, c1003a.k("resolveTask"));
        hVar.c(25, 1);
        hVar.j(182, str, "getContext", "()" + com.alibaba.fastjson.util.b.b(y4.g.class));
        hVar.b(181, com.alibaba.fastjson.util.b.g(a.C0994a.class), "ownerContext", com.alibaba.fastjson.util.b.b(y4.g.class));
        hVar.c(25, c1003a.k("resolveTask"));
        hVar.c(25, 0);
        hVar.d(dVar.f18279a);
        hVar.j(182, com.alibaba.fastjson.util.b.g(o.class), "getFieldDeserializer", "(Ljava/lang/String;)" + com.alibaba.fastjson.util.b.b(l.class));
        hVar.b(181, com.alibaba.fastjson.util.b.g(a.C0994a.class), "fieldDeserializer", com.alibaba.fastjson.util.b.b(l.class));
        hVar.c(25, 1);
        hVar.d(0);
        hVar.j(182, str, "setResolveStatus", "(I)V");
        hVar.l(fVar3);
    }

    private void k(C1003a c1003a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar, Class cls) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        hVar.c(25, 0);
        hVar.b(180, c1003a.f79340e, dVar.f18279a + "_asm_list_item_deser__", com.alibaba.fastjson.util.b.b(b2.class));
        hVar.a(199, fVar);
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.j(182, f79332c, "getConfig", "()" + com.alibaba.fastjson.util.b.b(y4.h.class));
        hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(cls)));
        hVar.j(182, com.alibaba.fastjson.util.b.g(y4.h.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + com.alibaba.fastjson.util.b.b(b2.class));
        hVar.b(181, c1003a.f79340e, dVar.f18279a + "_asm_list_item_deser__", com.alibaba.fastjson.util.b.b(b2.class));
        hVar.l(fVar);
        hVar.c(25, 0);
        hVar.b(180, c1003a.f79340e, dVar.f18279a + "_asm_list_item_deser__", com.alibaba.fastjson.util.b.b(b2.class));
    }

    private void l(C1003a c1003a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        hVar.c(25, 0);
        hVar.b(180, c1003a.f79340e, c1003a.g(dVar), com.alibaba.fastjson.util.b.b(b2.class));
        hVar.a(199, fVar);
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.j(182, f79332c, "getConfig", "()" + com.alibaba.fastjson.util.b.b(y4.h.class));
        hVar.d(com.alibaba.fastjson.asm.j.g(com.alibaba.fastjson.util.b.b(dVar.f18283e)));
        hVar.j(182, com.alibaba.fastjson.util.b.g(y4.h.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + com.alibaba.fastjson.util.b.b(b2.class));
        hVar.b(181, c1003a.f79340e, c1003a.g(dVar), com.alibaba.fastjson.util.b.b(b2.class));
        hVar.l(fVar);
        hVar.c(25, 0);
        hVar.b(180, c1003a.f79340e, c1003a.g(dVar), com.alibaba.fastjson.util.b.b(b2.class));
    }

    private void m(com.alibaba.fastjson.asm.c cVar, C1003a c1003a) {
        int length = c1003a.f79341f.length;
        for (int i11 = 0; i11 < length; i11++) {
            new com.alibaba.fastjson.asm.d(cVar, 1, c1003a.h(c1003a.f79341f[i11]), "[C").c();
        }
        int length2 = c1003a.f79341f.length;
        for (int i12 = 0; i12 < length2; i12++) {
            com.alibaba.fastjson.util.d dVar = c1003a.f79341f[i12];
            Class cls = dVar.f18283e;
            if (!cls.isPrimitive()) {
                if (Collection.class.isAssignableFrom(cls)) {
                    new com.alibaba.fastjson.asm.d(cVar, 1, dVar.f18279a + "_asm_list_item_deser__", com.alibaba.fastjson.util.b.b(b2.class)).c();
                } else {
                    new com.alibaba.fastjson.asm.d(cVar, 1, c1003a.g(dVar), com.alibaba.fastjson.util.b.b(b2.class)).c();
                }
            }
        }
        com.alibaba.fastjson.asm.i iVar = new com.alibaba.fastjson.asm.i(cVar, 1, "<init>", "(" + com.alibaba.fastjson.util.b.b(y4.h.class) + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.util.h.class) + ")V", null, null);
        iVar.c(25, 0);
        iVar.c(25, 1);
        iVar.c(25, 2);
        iVar.j(183, com.alibaba.fastjson.util.b.g(o.class), "<init>", "(" + com.alibaba.fastjson.util.b.b(y4.h.class) + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.util.h.class) + ")V");
        int length3 = c1003a.f79341f.length;
        for (int i13 = 0; i13 < length3; i13++) {
            com.alibaba.fastjson.util.d dVar2 = c1003a.f79341f[i13];
            iVar.c(25, 0);
            iVar.d("\"" + dVar2.f18279a + "\":");
            iVar.j(182, "java/lang/String", "toCharArray", "()[C");
            iVar.b(181, c1003a.f79340e, c1003a.h(dVar2), "[C");
        }
        iVar.h(177);
        iVar.i(4, 4);
        iVar.k();
    }

    private void n(com.alibaba.fastjson.asm.h hVar, C1003a c1003a, int i11, com.alibaba.fastjson.asm.f fVar) {
        hVar.c(21, c1003a.k("_asm_flag_" + (i11 / 32)));
        hVar.d(Integer.valueOf(1 << i11));
        hVar.h(126);
        hVar.a(153, fVar);
    }

    private void o(C1003a c1003a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar) {
        Class cls = dVar.f18283e;
        Type type = dVar.f18284f;
        if (cls == Boolean.TYPE) {
            hVar.c(25, c1003a.k("instance"));
            hVar.c(21, c1003a.m(dVar));
            s(c1003a, hVar, dVar);
            return;
        }
        if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Character.TYPE) {
            hVar.c(25, c1003a.k("instance"));
            hVar.c(21, c1003a.m(dVar));
            s(c1003a, hVar, dVar);
            return;
        }
        if (cls == Long.TYPE) {
            hVar.c(25, c1003a.k("instance"));
            hVar.c(22, c1003a.n(dVar, 2));
            if (dVar.f18280b == null) {
                hVar.b(181, com.alibaba.fastjson.util.b.g(dVar.f18285g), dVar.f18281c.getName(), com.alibaba.fastjson.util.b.b(dVar.f18283e));
                return;
            }
            hVar.j(182, com.alibaba.fastjson.util.b.g(c1003a.i()), dVar.f18280b.getName(), com.alibaba.fastjson.util.b.c(dVar.f18280b));
            if (dVar.f18280b.getReturnType().equals(Void.TYPE)) {
                return;
            }
            hVar.h(87);
            return;
        }
        if (cls == Float.TYPE) {
            hVar.c(25, c1003a.k("instance"));
            hVar.c(23, c1003a.m(dVar));
            s(c1003a, hVar, dVar);
            return;
        }
        if (cls == Double.TYPE) {
            hVar.c(25, c1003a.k("instance"));
            hVar.c(24, c1003a.n(dVar, 2));
            s(c1003a, hVar, dVar);
            return;
        }
        if (cls == String.class) {
            hVar.c(25, c1003a.k("instance"));
            hVar.c(25, c1003a.m(dVar));
            s(c1003a, hVar, dVar);
            return;
        }
        if (cls.isEnum()) {
            hVar.c(25, c1003a.k("instance"));
            hVar.c(25, c1003a.m(dVar));
            s(c1003a, hVar, dVar);
        } else if (!Collection.class.isAssignableFrom(cls)) {
            hVar.c(25, c1003a.k("instance"));
            hVar.c(25, c1003a.m(dVar));
            s(c1003a, hVar, dVar);
        } else {
            hVar.c(25, c1003a.k("instance"));
            if (TypeUtils.S(type) == String.class) {
                hVar.c(25, c1003a.m(dVar));
                hVar.f(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls));
            } else {
                hVar.c(25, c1003a.m(dVar));
            }
            s(c1003a, hVar, dVar);
        }
    }

    private void p(com.alibaba.fastjson.asm.h hVar, Class cls, int i11, boolean z10) {
        if (cls.isAssignableFrom(ArrayList.class) && !z10) {
            hVar.f(187, "java/util/ArrayList");
            hVar.h(89);
            hVar.j(183, "java/util/ArrayList", "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedList.class) && !z10) {
            hVar.f(187, com.alibaba.fastjson.util.b.g(LinkedList.class));
            hVar.h(89);
            hVar.j(183, com.alibaba.fastjson.util.b.g(LinkedList.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(HashSet.class)) {
            hVar.f(187, com.alibaba.fastjson.util.b.g(HashSet.class));
            hVar.h(89);
            hVar.j(183, com.alibaba.fastjson.util.b.g(HashSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            hVar.f(187, com.alibaba.fastjson.util.b.g(TreeSet.class));
            hVar.h(89);
            hVar.j(183, com.alibaba.fastjson.util.b.g(TreeSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            hVar.f(187, com.alibaba.fastjson.util.b.g(LinkedHashSet.class));
            hVar.h(89);
            hVar.j(183, com.alibaba.fastjson.util.b.g(LinkedHashSet.class), "<init>", "()V");
        } else if (z10) {
            hVar.f(187, com.alibaba.fastjson.util.b.g(HashSet.class));
            hVar.h(89);
            hVar.j(183, com.alibaba.fastjson.util.b.g(HashSet.class), "<init>", "()V");
        } else {
            hVar.c(25, 0);
            hVar.d(Integer.valueOf(i11));
            hVar.j(182, com.alibaba.fastjson.util.b.g(o.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            hVar.j(184, com.alibaba.fastjson.util.b.g(TypeUtils.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
        }
        hVar.f(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls));
    }

    private void q(C1003a c1003a, com.alibaba.fastjson.asm.h hVar, int i11) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        hVar.c(25, c1003a.k("lexer"));
        String str = f79333d;
        hVar.j(182, str, "getCurrent", "()C");
        if (i11 == 12) {
            hVar.c(16, Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
        } else {
            if (i11 != 14) {
                throw new IllegalStateException();
            }
            hVar.c(16, 91);
        }
        hVar.a(160, fVar);
        hVar.c(25, c1003a.k("lexer"));
        hVar.j(182, str, "next", "()C");
        hVar.h(87);
        hVar.c(25, c1003a.k("lexer"));
        hVar.d(Integer.valueOf(i11));
        hVar.j(182, str, "setToken", "(I)V");
        hVar.a(167, fVar2);
        hVar.l(fVar);
        hVar.c(25, c1003a.k("lexer"));
        hVar.d(Integer.valueOf(i11));
        hVar.j(182, str, "nextToken", "(I)V");
        hVar.l(fVar2);
    }

    private void r(C1003a c1003a, com.alibaba.fastjson.asm.h hVar) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar4 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar5 = new com.alibaba.fastjson.asm.f();
        hVar.c(25, c1003a.k("lexer"));
        String str = f79333d;
        hVar.j(182, str, "getCurrent", "()C");
        hVar.h(89);
        hVar.c(54, c1003a.k("ch"));
        hVar.c(16, 44);
        hVar.a(160, fVar2);
        hVar.c(25, c1003a.k("lexer"));
        hVar.j(182, str, "next", "()C");
        hVar.h(87);
        hVar.c(25, c1003a.k("lexer"));
        hVar.d(16);
        hVar.j(182, str, "setToken", "(I)V");
        hVar.a(167, fVar5);
        hVar.l(fVar2);
        hVar.c(21, c1003a.k("ch"));
        hVar.c(16, Sdk$SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
        hVar.a(160, fVar3);
        hVar.c(25, c1003a.k("lexer"));
        hVar.j(182, str, "next", "()C");
        hVar.h(87);
        hVar.c(25, c1003a.k("lexer"));
        hVar.d(13);
        hVar.j(182, str, "setToken", "(I)V");
        hVar.a(167, fVar5);
        hVar.l(fVar3);
        hVar.c(21, c1003a.k("ch"));
        hVar.c(16, 93);
        hVar.a(160, fVar4);
        hVar.c(25, c1003a.k("lexer"));
        hVar.j(182, str, "next", "()C");
        hVar.h(87);
        hVar.c(25, c1003a.k("lexer"));
        hVar.d(15);
        hVar.j(182, str, "setToken", "(I)V");
        hVar.a(167, fVar5);
        hVar.l(fVar4);
        hVar.c(21, c1003a.k("ch"));
        hVar.c(16, 26);
        hVar.a(160, fVar);
        hVar.c(25, c1003a.k("lexer"));
        hVar.d(20);
        hVar.j(182, str, "setToken", "(I)V");
        hVar.a(167, fVar5);
        hVar.l(fVar);
        hVar.c(25, c1003a.k("lexer"));
        hVar.j(182, str, "nextToken", "()V");
        hVar.l(fVar5);
    }

    private void s(C1003a c1003a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.d dVar) {
        Method method = dVar.f18280b;
        if (method == null) {
            hVar.b(181, com.alibaba.fastjson.util.b.g(dVar.f18285g), dVar.f18281c.getName(), com.alibaba.fastjson.util.b.b(dVar.f18283e));
            return;
        }
        hVar.j(method.getDeclaringClass().isInterface() ? 185 : 182, com.alibaba.fastjson.util.b.g(dVar.f18285g), method.getName(), com.alibaba.fastjson.util.b.c(method));
        if (dVar.f18280b.getReturnType().equals(Void.TYPE)) {
            return;
        }
        hVar.h(87);
    }

    private void t(C1003a c1003a, com.alibaba.fastjson.asm.h hVar) {
        hVar.c(25, 1);
        hVar.c(25, c1003a.k("context"));
        hVar.j(182, f79332c, "setContext", "(" + com.alibaba.fastjson.util.b.b(y4.g.class) + ")V");
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        hVar.c(25, c1003a.k("childContext"));
        hVar.a(198, fVar);
        hVar.c(25, c1003a.k("childContext"));
        hVar.c(25, c1003a.k("instance"));
        hVar.b(181, com.alibaba.fastjson.util.b.g(y4.g.class), "object", "Ljava/lang/Object;");
        hVar.l(fVar);
    }

    private void u(com.alibaba.fastjson.asm.h hVar, C1003a c1003a, int i11) {
        String str = "_asm_flag_" + (i11 / 32);
        hVar.c(21, c1003a.k(str));
        hVar.d(Integer.valueOf(1 << i11));
        hVar.h(128);
        hVar.c(54, c1003a.k(str));
    }

    private void w(C1003a c1003a, com.alibaba.fastjson.asm.h hVar) {
        hVar.c(25, 1);
        hVar.b(180, f79332c, "lexer", com.alibaba.fastjson.util.b.b(y4.b.class));
        hVar.f(PsExtractor.AUDIO_STREAM, f79333d);
        hVar.c(58, c1003a.k("lexer"));
    }

    public b2 v(y4.h hVar, com.alibaba.fastjson.util.h hVar2) {
        String str;
        Class cls = hVar2.f18324a;
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("not support type :" + cls.getName());
        }
        String str2 = "FastjsonASMDeserializer_" + this.f79335b.incrementAndGet() + "_" + cls.getSimpleName();
        Package r42 = a.class.getPackage();
        if (r42 != null) {
            String name = r42.getName();
            String str3 = name.replace('.', '/') + "/" + str2;
            str = name + "." + str2;
            str2 = str3;
        } else {
            str = str2;
        }
        com.alibaba.fastjson.asm.c cVar = new com.alibaba.fastjson.asm.c();
        cVar.k(49, 33, str2, com.alibaba.fastjson.util.b.g(o.class), null);
        m(cVar, new C1003a(str2, hVar, hVar2, 3));
        c(cVar, new C1003a(str2, hVar, hVar2, 3));
        g(cVar, new C1003a(str2, hVar, hVar2, 5));
        h(cVar, new C1003a(str2, hVar, hVar2, 4));
        byte[] j11 = cVar.j();
        return (b2) this.f79334a.a(str, j11, 0, j11.length).getConstructor(y4.h.class, com.alibaba.fastjson.util.h.class).newInstance(hVar, hVar2);
    }
}
