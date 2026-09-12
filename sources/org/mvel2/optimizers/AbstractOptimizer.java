package org.mvel2.optimizers;

import java.lang.reflect.Method;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.AbstractParser;
import org.mvel2.d;
import org.mvel2.util.m;

/* loaded from: classes7.dex */
public class AbstractOptimizer extends AbstractParser {
    protected static final int BEAN = 0;
    protected static final int COL = 2;
    protected static final int METH = 1;
    protected static final int WITH = 3;
    protected boolean collection;
    protected Class currType;
    protected boolean nullSafe;
    protected boolean staticAccess;
    protected int tkStart;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractOptimizer() {
        this.collection = false;
        this.nullSafe = false;
        this.currType = null;
        this.staticAccess = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractOptimizer(ParserContext parserContext) {
        super(parserContext);
        this.collection = false;
        this.nullSafe = false;
        this.currType = null;
        this.staticAccess = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String capture() {
        char[] cArr = this.expr;
        int trimRight = trimRight(this.tkStart);
        this.tkStart = trimRight;
        return new String(cArr, trimRight, trimLeft(this.cursor) - this.tkStart);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if (r5 != '}') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0032, code lost:
    
        if (r3 == 0) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038 A[LOOP:0: B:2:0x000a->B:15:0x0038, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b A[EDGE_INSN: B:16:0x003b->B:17:0x003b BREAK  A[LOOP:0: B:2:0x000a->B:15:0x0038], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int findLastUnion() {
        /*
            r7 = this;
            int r0 = r7.start
            int r1 = r7.length
            int r0 = r0 + r1
            r1 = 1
            int r0 = r0 - r1
            r2 = -1
            r3 = 0
            r4 = r2
        La:
            int r5 = r7.start
            if (r0 == r5) goto L3b
            char[] r5 = r7.expr
            char r5 = r5[r0]
            r6 = 46
            if (r5 == r6) goto L32
            r6 = 91
            if (r5 == r6) goto L2a
            r6 = 93
            if (r5 == r6) goto L27
            r6 = 123(0x7b, float:1.72E-43)
            if (r5 == r6) goto L2a
            r6 = 125(0x7d, float:1.75E-43)
            if (r5 == r6) goto L27
            goto L35
        L27:
            int r3 = r3 + 1
            goto L35
        L2a:
            int r3 = r3 + (-1)
            if (r3 != 0) goto L35
            r7.collection = r1
        L30:
            r4 = r0
            goto L35
        L32:
            if (r3 != 0) goto L35
            goto L30
        L35:
            if (r4 == r2) goto L38
            goto L3b
        L38:
            int r0 = r0 + (-1)
            goto La
        L3b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.optimizers.AbstractOptimizer.findLastUnion():int");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int nextSubToken() {
        int i11;
        skipWhitespace();
        this.nullSafe = false;
        char[] cArr = this.expr;
        int i12 = this.cursor;
        this.tkStart = i12;
        char c11 = cArr[i12];
        if (c11 != '.') {
            if (c11 != '?') {
                if (c11 == '[') {
                    return 2;
                }
                if (c11 == '{' && cArr[i12 - 1] == '.') {
                    return 3;
                }
            } else if (this.start == i12) {
                this.tkStart = i12 + 1;
                this.cursor = i12 + 1;
                this.nullSafe = true;
            }
        } else {
            if (this.start + 1 == this.end) {
                throw new CompileException("unexpected end of statement", this.expr, this.start);
            }
            int i13 = i12 + 1;
            this.tkStart = i13;
            this.cursor = i13;
            char c12 = cArr[i13];
            if (c12 == '?') {
                skipWhitespace();
                int i14 = this.tkStart + 1;
                this.tkStart = i14;
                this.cursor = i14;
                if (i14 == this.end) {
                    throw new CompileException("unexpected end of statement", this.expr, this.start);
                }
                this.nullSafe = true;
                this.fields = -1;
            } else {
                if (c12 == '{') {
                    return 3;
                }
                if (m.q0(c12)) {
                    skipWhitespace();
                    this.tkStart = this.cursor;
                }
            }
        }
        do {
            i11 = this.cursor + 1;
            this.cursor = i11;
            if (i11 >= this.end) {
                break;
            }
        } while (m.c0(this.expr[i11]));
        skipWhitespace();
        int i15 = this.cursor;
        if (i15 >= this.end) {
            return 0;
        }
        char c13 = this.expr[i15];
        if (c13 != '(') {
            return c13 != '[' ? 0 : 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean scanTo(char c11) {
        while (true) {
            int i11 = this.cursor;
            int i12 = this.end;
            if (i11 >= i12) {
                return true;
            }
            char[] cArr = this.expr;
            char c12 = cArr[i11];
            if (c12 == '\"' || c12 == '\'') {
                this.cursor = m.h(c12, cArr, i11, i12);
            }
            char[] cArr2 = this.expr;
            int i13 = this.cursor;
            if (cArr2[i13] == c11) {
                return false;
            }
            this.cursor = i13 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object tryStaticAccess() {
        int i11;
        int i12 = this.cursor;
        try {
            int i13 = this.end;
            int i14 = i13 - 1;
            boolean z10 = false;
            while (i14 > this.start) {
                char c11 = this.expr[i14];
                if (c11 == '\"') {
                    while (true) {
                        i11 = i14 - 1;
                        if (i11 > this.start) {
                            char[] cArr = this.expr;
                            if (cArr[i11] != '\"' || cArr[i14 - 2] == '\\') {
                                i14 = i11;
                            }
                        }
                    }
                } else if (c11 != '\'') {
                    int i15 = 1;
                    if (c11 == ')') {
                        int i16 = i14 - 1;
                        int i17 = 1;
                        while (i16 > this.start && i17 != 0) {
                            char c12 = this.expr[i16];
                            if (c12 != '\"') {
                                switch (c12) {
                                    case '(':
                                        i17--;
                                        break;
                                    case ')':
                                        i17++;
                                        break;
                                }
                                i16--;
                            }
                            while (i16 > this.start) {
                                char[] cArr2 = this.expr;
                                if (cArr2[i16] != c12 && cArr2[i16 - 1] != '\\') {
                                    i16--;
                                }
                                i16--;
                            }
                            i16--;
                        }
                        z10 = true;
                        int i18 = i16;
                        i14 = i16 + 1;
                        i13 = i18;
                    } else if (c11 == '.') {
                        if (!z10) {
                            ParserContext parserContext = this.pCtx;
                            ClassLoader classLoader = parserContext != null ? parserContext.getClassLoader() : Thread.currentThread().getContextClassLoader();
                            char[] cArr3 = this.expr;
                            int i19 = this.start;
                            this.cursor = i13;
                            String str = new String(cArr3, i19, i13 - i19);
                            try {
                                if (d.f72093j && str.endsWith(".class")) {
                                    str = str.substring(0, str.length() - 6);
                                }
                                return Class.forName(str, true, classLoader);
                            } catch (ClassNotFoundException e11) {
                                try {
                                    return m.F(str, classLoader, e11);
                                } catch (ClassNotFoundException unused) {
                                    Class H = m.H(new String(this.expr, this.start, i14 - this.start), classLoader);
                                    String str2 = new String(this.expr, i14 + 1, (this.end - i14) - 1);
                                    try {
                                        return H.getField(str2);
                                    } catch (NoSuchFieldException unused2) {
                                        for (Method method : H.getMethods()) {
                                            if (str2.equals(method.getName())) {
                                                return method;
                                            }
                                        }
                                        return null;
                                    }
                                }
                            }
                        }
                        i13 = i14;
                        z10 = false;
                    } else if (c11 == '}') {
                        while (true) {
                            i14--;
                            if (i14 > this.start && i15 != 0) {
                                char c13 = this.expr[i14];
                                if (c13 == '\"' || c13 == '\'') {
                                    while (i14 > this.start) {
                                        char[] cArr4 = this.expr;
                                        if (cArr4[i14] != c13 && cArr4[i14 - 1] != '\\') {
                                            i14--;
                                        }
                                    }
                                } else if (c13 == '{') {
                                    i15--;
                                } else if (c13 == '}') {
                                    i15++;
                                }
                            }
                        }
                    }
                    i14--;
                } else {
                    while (true) {
                        i11 = i14 - 1;
                        if (i11 > this.start) {
                            char[] cArr5 = this.expr;
                            if (cArr5[i11] != '\'' || cArr5[i14 - 2] == '\\') {
                                i14 = i11;
                            }
                        }
                    }
                }
                i14 = i11;
                i14--;
            }
        } catch (Exception unused3) {
            this.cursor = i12;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void whiteSpaceSkip() {
        if (this.cursor >= this.length) {
            return;
        }
        while (m.q0(this.expr[this.cursor])) {
            int i11 = this.cursor + 1;
            this.cursor = i11;
            if (i11 == this.length) {
                return;
            }
        }
    }
}
