package org.mvel2.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.ast.EndOfStatement;
import org.mvel2.ast.Proto;
import org.mvel2.compiler.ExecutableStatement;

/* loaded from: classes7.dex */
public class o {

    /* renamed from: m, reason: collision with root package name */
    private static ThreadLocal f72192m = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    private char[] f72193a;

    /* renamed from: b, reason: collision with root package name */
    private ParserContext f72194b;

    /* renamed from: c, reason: collision with root package name */
    private int f72195c;

    /* renamed from: d, reason: collision with root package name */
    private int f72196d;

    /* renamed from: e, reason: collision with root package name */
    private String f72197e;

    /* renamed from: f, reason: collision with root package name */
    String f72198f = null;

    /* renamed from: g, reason: collision with root package name */
    String f72199g = null;

    /* renamed from: h, reason: collision with root package name */
    private Class f72200h;

    /* renamed from: i, reason: collision with root package name */
    private String f72201i;

    /* renamed from: j, reason: collision with root package name */
    private String f72202j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f72203k;

    /* renamed from: l, reason: collision with root package name */
    private g f72204l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f72205a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Proto.c f72206b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f72207c;

        a(String str, Proto.c cVar, String str2) {
            this.f72205a = str;
            this.f72206b = cVar;
            this.f72207c = str2;
        }

        @Override // org.mvel2.util.o.b
        public boolean a(Proto proto) {
            if (!this.f72205a.equals(proto.getName())) {
                return false;
            }
            this.f72206b.f(Proto.ReceiverType.PROPERTY);
            this.f72206b.e((ExecutableStatement) m.G0(this.f72207c, o.this.f72194b));
            return true;
        }

        @Override // org.mvel2.util.o.b
        public String getName() {
            return this.f72205a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface b {
        boolean a(Proto proto);

        String getName();
    }

    public o(char[] cArr, int i11, int i12, String str, ParserContext parserContext, int i13, g gVar) {
        this.f72203k = false;
        this.f72193a = cArr;
        this.f72196d = i11;
        this.f72195c = i12;
        this.f72197e = str;
        this.f72194b = parserContext;
        this.f72203k = (i13 & 16) == 0;
        this.f72204l = gVar;
    }

    private void b() {
        if (this.f72199g != null) {
            try {
                if (this.f72194b.hasProtoImport(this.f72198f)) {
                    this.f72200h = Proto.class;
                } else {
                    this.f72200h = m.D(null, this.f72198f, this.f72194b);
                }
                this.f72201i = this.f72199g;
            } catch (ClassNotFoundException e11) {
                if (!this.f72203k) {
                    throw new CompileException("could not resolve class: " + this.f72198f, this.f72193a, this.f72196d, e11);
                }
                this.f72200h = b.class;
                this.f72202j = this.f72198f;
                this.f72201i = this.f72199g;
            }
        } else {
            this.f72200h = Object.class;
            this.f72201i = this.f72198f;
        }
        this.f72198f = null;
        this.f72199g = null;
    }

    public static void c(char[] cArr, int i11, ParserContext parserContext) {
        if (g()) {
            Object obj = ((LinkedHashMap) parserContext.getParserConfiguration().getImports()).values().toArray()[r5.size() - 1];
            if (obj instanceof Proto) {
                Proto proto = (Proto) obj;
                int cursorEnd = proto.getCursorEnd();
                do {
                    i11--;
                    if (i11 <= cursorEnd) {
                        break;
                    }
                } while (m.q0(cArr[i11]));
                while (i11 > cursorEnd && m.c0(cArr[i11])) {
                    i11--;
                }
                while (i11 > cursorEnd && (m.q0(cArr[i11]) || cArr[i11] == ';')) {
                    i11--;
                }
                if (i11 == cursorEnd) {
                    return;
                }
                throw new CompileException("unresolved reference (possible illegal forward-reference?): " + f(), cArr, proto.getCursorStart());
            }
        }
    }

    private void d(String str, Proto.c cVar, String str2) {
        Queue queue = (Queue) f72192m.get();
        if (queue == null) {
            ThreadLocal threadLocal = f72192m;
            LinkedList linkedList = new LinkedList();
            threadLocal.set(linkedList);
            queue = linkedList;
        }
        queue.add(new a(str, cVar, str2));
    }

    public static String f() {
        if (f72192m.get() == null || ((Queue) f72192m.get()).isEmpty()) {
            return null;
        }
        return ((b) ((Queue) f72192m.get()).poll()).getName();
    }

    public static boolean g() {
        return (f72192m.get() == null || ((Queue) f72192m.get()).isEmpty()) ? false : true;
    }

    public static void h(Proto proto) {
        if (f72192m.get() != null) {
            Queue<b> queue = (Queue) f72192m.get();
            HashSet hashSet = new HashSet();
            for (b bVar : queue) {
                if (bVar.a(proto)) {
                    hashSet.add(bVar);
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                queue.remove((b) it.next());
            }
        }
    }

    public int e() {
        return this.f72196d;
    }

    public Proto i() {
        Proto proto = new Proto(this.f72197e, this.f72194b);
        while (true) {
            int i11 = this.f72196d;
            if (i11 >= this.f72195c) {
                int i12 = i11 + 1;
                this.f72196d = i12;
                if (this.f72204l != null && m.p0(this.f72193a, i12)) {
                    this.f72204l.a(new EndOfStatement(this.f72194b));
                }
                return proto;
            }
            int E0 = m.E0(this.f72193a, i11);
            this.f72196d = E0;
            if (this.f72199g == null) {
                while (true) {
                    int i13 = this.f72196d;
                    if (i13 >= this.f72195c || !m.c0(this.f72193a[i13])) {
                        break;
                    }
                    this.f72196d++;
                }
                int i14 = this.f72196d;
                if (i14 > E0) {
                    String str = new String(this.f72193a, E0, i14 - E0);
                    this.f72198f = str;
                    if ("def".equals(str) || "function".equals(this.f72198f)) {
                        int i15 = this.f72196d + 1;
                        this.f72196d = i15;
                        int E02 = m.E0(this.f72193a, i15);
                        this.f72196d = E02;
                        while (true) {
                            int i16 = this.f72196d;
                            if (i16 >= this.f72195c || !m.c0(this.f72193a[i16])) {
                                break;
                            }
                            this.f72196d++;
                        }
                        int i17 = this.f72196d;
                        if (E02 == i17) {
                            throw new CompileException("attempt to declare an anonymous function as a prototype member", this.f72193a, E02);
                        }
                        h hVar = new h(new String(this.f72193a, E02, i17 - E02), this.f72196d, this.f72195c, this.f72193a, 0, this.f72194b, null);
                        proto.declareReceiver(hVar.b(), hVar.c());
                        this.f72196d = hVar.a() + 1;
                        this.f72198f = null;
                    }
                }
                this.f72196d = m.E0(this.f72193a, this.f72196d);
            }
            int i18 = this.f72196d;
            if (i18 > this.f72195c) {
                throw new CompileException("unexpected end of statement in proto declaration: " + this.f72197e, this.f72193a, E0);
            }
            char[] cArr = this.f72193a;
            char c11 = cArr[i18];
            if (c11 == ';') {
                this.f72196d = i18 + 1;
                b();
                if (this.f72203k && this.f72200h == b.class) {
                    d(this.f72202j, proto.declareReceiver(this.f72201i, Proto.ReceiverType.DEFERRED, (ExecutableStatement) null), null);
                } else {
                    proto.declareReceiver(this.f72201i, this.f72200h, (ExecutableStatement) null);
                }
            } else if (c11 != '=') {
                while (true) {
                    int i19 = this.f72196d;
                    if (i19 >= this.f72195c || !m.c0(this.f72193a[i19])) {
                        break;
                    }
                    this.f72196d++;
                }
                int i20 = this.f72196d;
                if (i20 > i18) {
                    this.f72199g = new String(this.f72193a, i18, i20 - i18);
                }
            } else {
                int i21 = i18 + 1;
                this.f72196d = i21;
                int E03 = m.E0(cArr, i21);
                this.f72196d = E03;
                while (true) {
                    int i22 = this.f72196d;
                    int i23 = this.f72195c;
                    if (i22 >= i23) {
                        break;
                    }
                    char[] cArr2 = this.f72193a;
                    char c12 = cArr2[i22];
                    if (c12 != '\"') {
                        if (c12 == ';') {
                            break;
                        }
                        if (c12 != '[' && c12 != '{' && c12 != '\'' && c12 != '(') {
                            this.f72196d++;
                        }
                    }
                    this.f72196d = m.e(cArr2, i22, i23, c12, this.f72194b);
                    this.f72196d++;
                }
                b();
                char[] cArr3 = this.f72193a;
                int i24 = this.f72196d;
                this.f72196d = i24 + 1;
                String str2 = new String(cArr3, E03, i24 - E03);
                if (this.f72203k && this.f72200h == b.class) {
                    d(this.f72202j, proto.declareReceiver(this.f72201i, Proto.ReceiverType.DEFERRED, (ExecutableStatement) null), str2);
                } else {
                    proto.declareReceiver(this.f72201i, this.f72200h, (ExecutableStatement) m.G0(str2, this.f72194b));
                }
            }
        }
    }
}
