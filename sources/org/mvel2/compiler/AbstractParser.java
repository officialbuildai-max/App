package org.mvel2.compiler;

import com.cloud.hisavana.sdk.data.bean.response.ccofig.ClientABTestDTOKt;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.transsion.gslb.Utils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.WeakHashMap;
import java.util.regex.Pattern;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.ast.ASTNode;
import org.mvel2.ast.DeclProtoVarNode;
import org.mvel2.ast.DeclTypedVarNode;
import org.mvel2.ast.DoNode;
import org.mvel2.ast.DoUntilNode;
import org.mvel2.ast.EndOfStatement;
import org.mvel2.ast.ForEachNode;
import org.mvel2.ast.ForNode;
import org.mvel2.ast.Function;
import org.mvel2.ast.IfNode;
import org.mvel2.ast.LiteralDeepPropertyNode;
import org.mvel2.ast.LiteralNode;
import org.mvel2.ast.OperatorNode;
import org.mvel2.ast.Proto;
import org.mvel2.ast.ProtoVarNode;
import org.mvel2.ast.Stacklang;
import org.mvel2.ast.Substatement;
import org.mvel2.ast.TypeDescriptor;
import org.mvel2.ast.TypedVarNode;
import org.mvel2.ast.UntilNode;
import org.mvel2.ast.WhileNode;
import org.mvel2.ast.WithNode;
import org.mvel2.c;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.g;
import org.mvel2.util.h;
import org.mvel2.util.m;
import org.mvel2.util.n;
import org.mvel2.util.o;
import org.mvel2.util.r;

/* loaded from: classes7.dex */
public class AbstractParser implements b, Serializable {
    public static HashMap<String, Object> CLASS_LITERALS = null;
    private static final WeakHashMap<String, char[]> EX_PRECACHE = new WeakHashMap<>(15);
    protected static final int GET = 2;
    protected static final int GET_OR_CREATE = 3;
    public static final int LEVEL_0_PROPERTY_ONLY = 0;
    public static final int LEVEL_1_BASIC_LANG = 1;
    public static final int LEVEL_2_MULTI_STATEMENT = 2;
    public static final int LEVEL_3_ITERATION = 3;
    public static final int LEVEL_4_ASSIGNMENT = 4;
    public static final int LEVEL_5_CONTROL_FLOW = 5;
    public static HashMap<String, Object> LITERALS = null;
    public static HashMap<String, Integer> OPERATORS = null;
    protected static final int OP_CONTINUE = 1;
    protected static final int OP_NOT_LITERAL = -3;
    protected static final int OP_OVERFLOW = -2;
    protected static final int OP_RESET_FRAME = 0;
    protected static final int OP_TERMINATE = -1;
    protected static final int REMOVE = 1;
    protected static final int SET = 0;
    protected boolean compileMode;
    protected Object ctx;
    protected int cursor;
    protected g dStack;
    protected boolean debugSymbols;
    protected int end;
    protected char[] expr;
    protected int fields;
    protected boolean greedy;
    protected int lastLineStart;
    protected ASTNode lastNode;
    protected boolean lastWasComment;
    protected boolean lastWasIdentifier;
    protected boolean lastWasLineLabel;
    protected int length;
    protected int line;
    protected int literalOnly;
    protected ParserContext pCtx;
    protected g splitAccumulator;

    /* renamed from: st, reason: collision with root package name */
    protected int f72083st;
    protected int start;
    protected g stk;
    protected VariableResolverFactory variableFactory;

    static {
        setupParser();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractParser() {
        this.greedy = true;
        this.lastWasIdentifier = false;
        this.lastWasLineLabel = false;
        this.lastWasComment = false;
        this.compileMode = false;
        this.literalOnly = -1;
        this.lastLineStart = 0;
        this.line = 0;
        this.splitAccumulator = new g();
        this.debugSymbols = false;
        this.pCtx = new ParserContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractParser(ParserContext parserContext) {
        this.greedy = true;
        this.lastWasIdentifier = false;
        this.lastWasLineLabel = false;
        this.lastWasComment = false;
        this.compileMode = false;
        this.literalOnly = -1;
        this.lastLineStart = 0;
        this.line = 0;
        this.splitAccumulator = new g();
        this.debugSymbols = false;
        this.pCtx = parserContext == null ? new ParserContext() : parserContext;
    }

    private ASTNode _captureBlock(ASTNode aSTNode, char[] cArr, boolean z10, int i11) {
        int i12;
        int i13;
        int i14;
        skipWhitespace();
        if (i11 == 48) {
            if (o.g()) {
                o.c(cArr, this.cursor, this.pCtx);
            }
            int i15 = this.cursor;
            captureToNextTokenJunction();
            String x10 = m.x(cArr, i15, this.cursor - i15);
            if (m.o0(x10) || m.f0(x10)) {
                throw new CompileException("illegal prototype name or use of reserved word", cArr, this.cursor);
            }
            int nextNonBlank = nextNonBlank();
            this.cursor = nextNonBlank;
            if (cArr[nextNonBlank] != '{') {
                throw new CompileException("expected '{' but found: " + cArr[this.cursor], cArr, this.cursor);
            }
            int i16 = nextNonBlank + 1;
            this.cursor = m.e(cArr, i16, this.end, '{', this.pCtx);
            o oVar = new o(cArr, i16, this.cursor, x10, this.pCtx, this.fields, this.splitAccumulator);
            Proto i17 = oVar.i();
            this.pCtx.addImport(i17);
            i17.setCursorPosition(i16, this.cursor);
            this.cursor = oVar.e();
            o.h(i17);
            this.lastNode = i17;
            return i17;
        }
        if (i11 == 100) {
            int i18 = this.cursor;
            captureToNextTokenJunction();
            int i19 = this.cursor;
            if (i19 == this.end) {
                throw new CompileException("unexpected end of statement", cArr, i18);
            }
            String x11 = m.x(cArr, i18, i19 - i18);
            if (m.o0(x11) || m.f0(x11)) {
                throw new CompileException("illegal function name or use of reserved word", cArr, this.cursor);
            }
            int i20 = this.cursor;
            h hVar = new h(x11, i20, this.end - i20, cArr, this.fields, this.pCtx, this.splitAccumulator);
            Function c11 = hVar.c();
            this.cursor = hVar.a();
            this.lastNode = c11;
            return c11;
        }
        if (i11 == 101) {
            int nextNonBlank2 = nextNonBlank();
            this.cursor = nextNonBlank2;
            if (cArr[nextNonBlank2] != '{') {
                throw new CompileException("expected '{' but found: " + cArr[this.cursor], cArr, this.cursor);
            }
            int i21 = nextNonBlank2 + 1;
            this.cursor = m.e(cArr, i21, this.end, '{', this.pCtx);
            Stacklang stacklang = new Stacklang(cArr, i21, this.cursor - i21, this.fields, this.pCtx);
            this.cursor++;
            this.lastNode = stacklang;
            return stacklang;
        }
        if (z10) {
            int i22 = this.cursor;
            if (cArr[i22] != '(') {
                throw new CompileException("expected '(' but encountered: " + cArr[this.cursor], cArr, this.cursor);
            }
            int e11 = m.e(cArr, i22, this.end, '(', this.pCtx);
            this.cursor = e11 + 1;
            i12 = i22 + 1;
            i13 = e11;
        } else {
            i12 = 0;
            i13 = 0;
        }
        skipWhitespace();
        int i23 = this.cursor;
        int i24 = this.end;
        if (i23 >= i24) {
            throw new CompileException("unexpected end of statement", cArr, this.end);
        }
        if (cArr[i23] == '{') {
            i14 = m.e(cArr, i23, i24, '{', this.pCtx);
            this.cursor = i14;
        } else {
            i23--;
            captureToEOSorEOL();
            i14 = this.cursor + 1;
        }
        int i25 = i14;
        if (i11 == 2048) {
            IfNode ifNode = (IfNode) aSTNode;
            if (aSTNode == null) {
                return createBlockToken(i12, i13, i23 + 1, i25, i11);
            }
            if (z10) {
                return ifNode.setElseIf((IfNode) createBlockToken(i12, i13, trimRight(i23 + 1), trimLeft(i25), i11));
            }
            int trimRight = trimRight(i23 + 1);
            this.f72083st = trimRight;
            return ifNode.setElseBlock(cArr, trimRight, trimLeft(i25) - this.f72083st, this.pCtx);
        }
        if (i11 != 65536) {
            return createBlockToken(i12, i13, trimRight(i23 + 1), trimLeft(i25), i11);
        }
        this.cursor++;
        skipWhitespace();
        this.f72083st = this.cursor;
        captureToNextTokenJunction();
        int i26 = this.f72083st;
        String str = new String(cArr, i26, this.cursor - i26);
        if ("while".equals(str)) {
            skipWhitespace();
            int i27 = this.cursor;
            int e12 = m.e(cArr, i27, this.end, '(', this.pCtx);
            this.cursor = e12;
            return createBlockToken(i27 + 1, e12, trimRight(i23 + 1), trimLeft(i25), i11);
        }
        if (!"until".equals(str)) {
            throw new CompileException("expected 'while' or 'until' but encountered: " + str, cArr, this.cursor);
        }
        skipWhitespace();
        int i28 = this.cursor;
        int e13 = m.e(cArr, i28, this.end, '(', this.pCtx);
        this.cursor = e13;
        return createBlockToken(i28 + 1, e13, trimRight(i23 + 1), trimLeft(i25), 131072);
    }

    private static int asInt(Object obj) {
        return ((Integer) obj).intValue();
    }

    private ASTNode captureCodeBlock(int i11) {
        ASTNode aSTNode = null;
        if (i11 != 2048) {
            if (i11 == 65536) {
                skipWhitespace();
                return _captureBlock(null, this.expr, false, i11);
            }
            captureToNextTokenJunction();
            skipWhitespace();
            return _captureBlock(null, this.expr, true, i11);
        }
        boolean z10 = true;
        ASTNode aSTNode2 = null;
        do {
            if (aSTNode != null) {
                captureToNextTokenJunction();
                skipWhitespace();
                char[] cArr = this.expr;
                int i12 = this.cursor;
                char c11 = cArr[i12];
                if (c11 != '{' && c11 == 'i') {
                    int i13 = i12 + 1;
                    this.cursor = i13;
                    if (cArr[i13] == 'f') {
                        int incNextNonBlank = incNextNonBlank();
                        this.cursor = incNextNonBlank;
                        if (cArr[incNextNonBlank] == '(') {
                            z10 = true;
                        }
                    }
                }
                z10 = false;
            }
            aSTNode = _captureBlock(aSTNode, this.expr, z10, i11);
            if (((IfNode) aSTNode).getElseBlock() != null) {
                this.cursor++;
                return aSTNode2;
            }
            if (aSTNode2 == null) {
                aSTNode2 = aSTNode;
            }
            int i14 = this.cursor;
            if (i14 != this.end && this.expr[i14] != ';') {
                this.cursor = i14 + 1;
            }
        } while (ifThenElseBlockContinues());
        return aSTNode2;
    }

    private ASTNode createBlockToken(int i11, int i12, int i13, int i14, int i15) {
        this.lastWasIdentifier = false;
        this.cursor++;
        if (isStatementNotManuallyTerminated()) {
            this.splitAccumulator.a(new EndOfStatement(this.pCtx));
        }
        int i16 = i12 - i11;
        int i17 = i14 - i13;
        int i18 = i17 < 0 ? 0 : i17;
        if (i15 == 2048) {
            return new IfNode(this.expr, i11, i16, i13, i18, this.fields, this.pCtx);
        }
        if (i15 != 4096) {
            if (i15 == 16384) {
                return new UntilNode(this.expr, i11, i16, i13, i18, this.fields, this.pCtx);
            }
            if (i15 == 32768) {
                return new WhileNode(this.expr, i11, i16, i13, i18, this.fields, this.pCtx);
            }
            if (i15 == 65536) {
                return new DoNode(this.expr, i11, i16, i13, i18, this.fields, this.pCtx);
            }
            if (i15 == 131072) {
                return new DoUntilNode(this.expr, i11, i16, i13, i18, this.pCtx);
            }
            if (i15 != 262144) {
                return new WithNode(this.expr, i11, i16, i13, i18, this.fields, this.pCtx);
            }
            for (int i19 = i11; i19 < i12; i19++) {
                char[] cArr = this.expr;
                char c11 = cArr[i19];
                if (c11 == ';') {
                    return new ForNode(cArr, i11, i16, i13, i18, this.fields, this.pCtx);
                }
                if (c11 == ':') {
                    break;
                }
            }
        }
        return new ForEachNode(this.expr, i11, i16, i13, i18, this.fields, this.pCtx);
    }

    private ASTNode createOperator(char[] cArr, int i11, int i12) {
        this.lastWasIdentifier = false;
        OperatorNode operatorNode = new OperatorNode(OPERATORS.get(new String(cArr, i11, i12 - i11)), cArr, i11, this.pCtx);
        this.lastNode = operatorNode;
        return operatorNode;
    }

    private ASTNode createPropertyToken(int i11, int i12) {
        if (m.n0(this.expr, i11, i12)) {
            ParserContext parserContext = this.pCtx;
            if (parserContext != null && parserContext.hasImports()) {
                int a11 = org.mvel2.util.b.a('.', i11, i12 - i11, this.expr);
                if (a11 != -1) {
                    String str = new String(this.expr, i11, a11 - i11);
                    if (this.pCtx.hasImport(str)) {
                        this.lastWasIdentifier = true;
                        LiteralDeepPropertyNode literalDeepPropertyNode = new LiteralDeepPropertyNode(this.expr, a11 + 1, (i12 - a11) - 1, this.fields, this.pCtx.getImport(str), this.pCtx);
                        this.lastNode = literalDeepPropertyNode;
                        return literalDeepPropertyNode;
                    }
                } else {
                    ParserContext parserContext2 = this.pCtx;
                    String str2 = new String(this.expr, i11, this.cursor - i11);
                    if (parserContext2.hasImport(str2)) {
                        this.lastWasIdentifier = true;
                        LiteralNode literalNode = new LiteralNode(this.pCtx.getStaticOrClassImport(str2), this.pCtx);
                        this.lastNode = literalNode;
                        return literalNode;
                    }
                }
            }
            HashMap<String, Object> hashMap = LITERALS;
            String str3 = new String(this.expr, i11, i12 - i11);
            if (hashMap.containsKey(str3)) {
                this.lastWasIdentifier = true;
                LiteralNode literalNode2 = new LiteralNode(LITERALS.get(str3), this.pCtx);
                this.lastNode = literalNode2;
                return literalNode2;
            }
            if (OPERATORS.containsKey(str3)) {
                this.lastWasIdentifier = false;
                OperatorNode operatorNode = new OperatorNode(OPERATORS.get(str3), this.expr, i11, this.pCtx);
                this.lastNode = operatorNode;
                return operatorNode;
            }
            if (this.lastWasIdentifier) {
                return procTypedNode(true);
            }
        }
        if (this.pCtx == null || !m.a0(this.expr, i11, i12) || !this.pCtx.hasImport(new String(this.expr, i11, (this.cursor - i11) - 2))) {
            this.lastWasIdentifier = true;
            ASTNode aSTNode = new ASTNode(this.expr, trimRight(i11), trimLeft(i12) - i11, this.fields, this.pCtx);
            this.lastNode = aSTNode;
            return aSTNode;
        }
        this.lastWasIdentifier = true;
        TypeDescriptor typeDescriptor = new TypeDescriptor(this.expr, i11, this.cursor - i11, this.fields);
        try {
            LiteralNode literalNode3 = new LiteralNode(typeDescriptor.getClassReference(this.pCtx), this.pCtx);
            this.lastNode = literalNode3;
            return literalNode3;
        } catch (ClassNotFoundException unused) {
            throw new CompileException("could not resolve class: " + typeDescriptor.getClassName(), this.expr, i11);
        }
    }

    private void dreduce() {
        this.stk.c(this.dStack);
        this.stk.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isArithmeticOperator(int i11) {
        return i11 != -1 && i11 < 6;
    }

    public static HashMap<String, Integer> loadLanguageFeaturesByLevel(int i11) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        switch (i11) {
            case 6:
                hashMap.put("proto", 48);
            case 5:
                hashMap.put("if", 39);
                hashMap.put("else", 40);
                hashMap.put(UrlUtils.QUESTION_MARK, 29);
                hashMap.put(ClientABTestDTOKt.SWITCH, 44);
                hashMap.put("function", 100);
                hashMap.put("def", 100);
                hashMap.put("stacklang", 101);
            case 4:
                hashMap.put(UrlUtils.EQUAL_MARK, 31);
                hashMap.put("var", 98);
                hashMap.put("+=", 52);
                hashMap.put("-=", 53);
                hashMap.put("/=", 55);
                hashMap.put("%=", 56);
            case 3:
                hashMap.put("foreach", 38);
                hashMap.put("while", 41);
                hashMap.put("until", 42);
                hashMap.put("for", 43);
                hashMap.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_DO, 45);
            case 2:
                hashMap.put("return", 99);
                hashMap.put(";", 37);
            case 1:
                hashMap.put("+", 0);
                hashMap.put("-", 1);
                hashMap.put("*", 2);
                hashMap.put("**", 5);
                hashMap.put("/", 3);
                hashMap.put("%", 4);
                hashMap.put("==", 18);
                hashMap.put("!=", 19);
                hashMap.put(">", 15);
                hashMap.put(">=", 17);
                hashMap.put("<", 14);
                hashMap.put("<=", 16);
                hashMap.put("&&", 21);
                hashMap.put("and", 21);
                hashMap.put("||", 22);
                hashMap.put("or", 23);
                hashMap.put("~=", 24);
                hashMap.put("instanceof", 25);
                hashMap.put("is", 25);
                hashMap.put("contains", 26);
                hashMap.put("soundslike", 27);
                hashMap.put("strsim", 28);
                hashMap.put("convertable_to", 36);
                hashMap.put("isdef", 47);
                hashMap.put(Utils.SEPARATOR, 20);
                hashMap.put(UrlUtils.AND_MARK, 6);
                hashMap.put("|", 7);
                hashMap.put("^", 8);
                hashMap.put("<<", 10);
                hashMap.put("<<<", 12);
                hashMap.put(">>", 9);
                hashMap.put(">>>", 11);
                hashMap.put("new", 34);
                hashMap.put("in", 35);
                hashMap.put("with", 46);
                hashMap.put("assert", 97);
                hashMap.put("import", 96);
                hashMap.put("import_static", 95);
                hashMap.put("++", 50);
                hashMap.put("--", 51);
            case 0:
                hashMap.put(":", 30);
                break;
        }
        return hashMap;
    }

    private ASTNode procTypedNode(boolean z10) {
        while (true) {
            if (this.lastNode.getLiteralValue() instanceof String) {
                char[] charArray = ((String) this.lastNode.getLiteralValue()).toCharArray();
                try {
                    this.lastNode.setLiteralValue(TypeDescriptor.getClassReference(this.pCtx, new TypeDescriptor(charArray, 0, charArray.length, 0)));
                    this.lastNode.discard();
                } catch (Exception unused) {
                }
            }
            if (this.lastNode.isLiteral() && (this.lastNode.getLiteralValue() instanceof Class)) {
                this.lastNode.discard();
                captureToEOS();
                if (z10) {
                    g gVar = this.splitAccumulator;
                    char[] cArr = this.expr;
                    int i11 = this.f72083st;
                    String str = new String(cArr, i11, this.cursor - i11);
                    char[] cArr2 = this.expr;
                    int i12 = this.f72083st;
                    gVar.a(new DeclTypedVarNode(str, cArr2, i12, this.cursor - i12, (Class) this.lastNode.getLiteralValue(), this.fields | 128, this.pCtx));
                } else {
                    captureToEOS();
                    this.splitAccumulator.a(new TypedVarNode(this.expr, this.f72083st, (this.cursor - r3) - 1, this.fields | 128, (Class) this.lastNode.getLiteralValue(), this.pCtx));
                }
            } else if (this.lastNode instanceof Proto) {
                captureToEOS();
                if (z10) {
                    g gVar2 = this.splitAccumulator;
                    char[] cArr3 = this.expr;
                    int i13 = this.f72083st;
                    gVar2.a(new DeclProtoVarNode(new String(cArr3, i13, this.cursor - i13), (Proto) this.lastNode, this.fields | 128, this.pCtx));
                } else {
                    g gVar3 = this.splitAccumulator;
                    char[] cArr4 = this.expr;
                    int i14 = this.f72083st;
                    gVar3.a(new ProtoVarNode(cArr4, i14, this.cursor - i14, this.fields | 128, (Proto) this.lastNode, this.pCtx));
                }
            } else {
                if ((this.fields & 16) != 0) {
                    throw new CompileException("unknown class or illegal statement: " + this.lastNode.getLiteralValue(), this.expr, this.cursor);
                }
                if (this.stk.k() instanceof Class) {
                    captureToEOS();
                    if (z10) {
                        g gVar4 = this.splitAccumulator;
                        char[] cArr5 = this.expr;
                        int i15 = this.f72083st;
                        String str2 = new String(cArr5, i15, this.cursor - i15);
                        char[] cArr6 = this.expr;
                        int i16 = this.f72083st;
                        gVar4.a(new DeclTypedVarNode(str2, cArr6, i16, this.cursor - i16, (Class) this.stk.n(), this.fields | 128, this.pCtx));
                    } else {
                        g gVar5 = this.splitAccumulator;
                        char[] cArr7 = this.expr;
                        int i17 = this.f72083st;
                        gVar5.a(new TypedVarNode(cArr7, i17, this.cursor - i17, this.fields | 128, (Class) this.stk.n(), this.pCtx));
                    }
                } else {
                    if (!(this.stk.k() instanceof Proto)) {
                        throw new CompileException("unknown class or illegal statement: " + this.lastNode.getLiteralValue(), this.expr, this.cursor);
                    }
                    captureToEOS();
                    if (z10) {
                        g gVar6 = this.splitAccumulator;
                        char[] cArr8 = this.expr;
                        int i18 = this.f72083st;
                        gVar6.a(new DeclProtoVarNode(new String(cArr8, i18, this.cursor - i18), (Proto) this.stk.n(), this.fields | 128, this.pCtx));
                    } else {
                        g gVar7 = this.splitAccumulator;
                        char[] cArr9 = this.expr;
                        int i19 = this.f72083st;
                        gVar7.a(new ProtoVarNode(cArr9, i19, this.cursor - i19, this.fields | 128, (Proto) this.stk.n(), this.pCtx));
                    }
                }
            }
            skipWhitespace();
            int i20 = this.cursor;
            if (i20 >= this.end || this.expr[i20] != ',') {
                break;
            }
            int i21 = i20 + 1;
            this.cursor = i21;
            this.f72083st = i21;
            this.splitAccumulator.a(new EndOfStatement(this.pCtx));
        }
        return (ASTNode) this.splitAccumulator.n();
    }

    private void reduce(int i11, int i12, int i13) {
        switch (i12) {
            case 6:
                this.stk.q(Integer.valueOf(i11 & i13));
                return;
            case 7:
                this.stk.q(Integer.valueOf(i11 | i13));
                return;
            case 8:
                this.stk.q(Integer.valueOf(i11 ^ i13));
                return;
            case 9:
                this.stk.q(Integer.valueOf(i11 >> i13));
                return;
            case 10:
                this.stk.q(Integer.valueOf(i11 << i13));
                return;
            case 11:
                this.stk.q(Integer.valueOf(i11 >>> i13));
                return;
            case 12:
                if (i11 < 0) {
                    i11 *= -1;
                }
                this.stk.q(Integer.valueOf(i11 << i13));
                return;
            default:
                return;
        }
    }

    private void reduce(int i11, int i12, long j11) {
        switch (i12) {
            case 6:
                this.stk.q(Long.valueOf(j11 & i11));
                return;
            case 7:
                this.stk.q(Long.valueOf(j11 | i11));
                return;
            case 8:
                this.stk.q(Long.valueOf(j11 ^ i11));
                return;
            case 9:
                this.stk.q(Integer.valueOf(i11 >> ((int) j11)));
                return;
            case 10:
                this.stk.q(Integer.valueOf(i11 << ((int) j11)));
                return;
            case 11:
                this.stk.q(Integer.valueOf(i11 >>> ((int) j11)));
                return;
            case 12:
                if (i11 < 0) {
                    i11 *= -1;
                }
                this.stk.q(Integer.valueOf(i11 << ((int) j11)));
                return;
            default:
                return;
        }
    }

    private void reduce(long j11, int i11, int i12) {
        switch (i11) {
            case 6:
                this.stk.q(Long.valueOf(j11 & i12));
                return;
            case 7:
                this.stk.q(Long.valueOf(j11 | i12));
                return;
            case 8:
                this.stk.q(Long.valueOf(j11 ^ i12));
                return;
            case 9:
                this.stk.q(Long.valueOf(j11 >> i12));
                return;
            case 10:
                this.stk.q(Long.valueOf(j11 << i12));
                return;
            case 11:
                this.stk.q(Long.valueOf(j11 >>> i12));
                return;
            case 12:
                if (j11 < 0) {
                    j11 *= -1;
                }
                this.stk.q(Long.valueOf(j11 << i12));
                return;
            default:
                return;
        }
    }

    private void reduce(long j11, int i11, long j12) {
        switch (i11) {
            case 6:
                this.stk.q(Long.valueOf(j11 & j12));
                return;
            case 7:
                this.stk.q(Long.valueOf(j11 | j12));
                return;
            case 8:
                this.stk.q(Long.valueOf(j11 ^ j12));
                return;
            case 9:
                this.stk.q(Long.valueOf(j11 >> ((int) j12)));
                return;
            case 10:
                this.stk.q(Long.valueOf(j11 << ((int) j12)));
                return;
            case 11:
                this.stk.q(Long.valueOf(j11 >>> ((int) j12)));
                return;
            case 12:
                if (j11 < 0) {
                    j11 *= -1;
                }
                this.stk.q(Long.valueOf(j11 << ((int) j12)));
                return;
            default:
                return;
        }
    }

    private void reduceNumeric(int i11) {
        Object l11 = this.stk.l();
        Object o11 = this.stk.o();
        if (l11 instanceof Integer) {
            if (o11 instanceof Integer) {
                reduce(((Integer) l11).intValue(), i11, ((Integer) o11).intValue());
                return;
            } else {
                reduce(((Integer) l11).intValue(), i11, ((Long) o11).longValue());
                return;
            }
        }
        if (o11 instanceof Integer) {
            reduce(((Long) l11).longValue(), i11, ((Integer) o11).intValue());
        } else {
            reduce(((Long) l11).longValue(), i11, ((Long) o11).longValue());
        }
    }

    public static void setLanguageLevel(int i11) {
        OPERATORS.clear();
        OPERATORS.putAll(loadLanguageFeaturesByLevel(i11));
    }

    public static void setupParser() {
        HashMap<String, Object> hashMap = LITERALS;
        if (hashMap == null || hashMap.isEmpty()) {
            LITERALS = new HashMap<>();
            CLASS_LITERALS = new HashMap<>();
            OPERATORS = new HashMap<>();
            CLASS_LITERALS.put("System", System.class);
            CLASS_LITERALS.put("String", String.class);
            CLASS_LITERALS.put("CharSequence", CharSequence.class);
            CLASS_LITERALS.put("Integer", Integer.class);
            CLASS_LITERALS.put("int", Integer.TYPE);
            CLASS_LITERALS.put("Long", Long.class);
            CLASS_LITERALS.put("long", Long.TYPE);
            CLASS_LITERALS.put("Boolean", Boolean.class);
            CLASS_LITERALS.put("boolean", Boolean.TYPE);
            CLASS_LITERALS.put("Short", Short.class);
            CLASS_LITERALS.put("short", Short.TYPE);
            CLASS_LITERALS.put("Character", Character.class);
            CLASS_LITERALS.put("char", Character.TYPE);
            CLASS_LITERALS.put("Double", Double.class);
            CLASS_LITERALS.put("double", Double.TYPE);
            CLASS_LITERALS.put("Float", Float.class);
            CLASS_LITERALS.put("float", Float.TYPE);
            CLASS_LITERALS.put("Byte", Byte.class);
            CLASS_LITERALS.put("byte", Byte.TYPE);
            CLASS_LITERALS.put("Math", Math.class);
            CLASS_LITERALS.put("Void", Void.class);
            CLASS_LITERALS.put("Object", Object.class);
            CLASS_LITERALS.put("Number", Number.class);
            CLASS_LITERALS.put("Class", Class.class);
            CLASS_LITERALS.put("ClassLoader", ClassLoader.class);
            CLASS_LITERALS.put("Runtime", Runtime.class);
            CLASS_LITERALS.put("Thread", Thread.class);
            CLASS_LITERALS.put("Compiler", Compiler.class);
            CLASS_LITERALS.put("StringBuffer", StringBuffer.class);
            CLASS_LITERALS.put("ThreadLocal", ThreadLocal.class);
            CLASS_LITERALS.put("SecurityManager", SecurityManager.class);
            CLASS_LITERALS.put("StrictMath", StrictMath.class);
            CLASS_LITERALS.put("Exception", Exception.class);
            CLASS_LITERALS.put("Array", Array.class);
            CLASS_LITERALS.put("StringBuilder", StringBuilder.class);
            LITERALS.putAll(CLASS_LITERALS);
            LITERALS.put("true", Boolean.TRUE);
            LITERALS.put("false", Boolean.FALSE);
            LITERALS.put("null", null);
            LITERALS.put("nil", null);
            LITERALS.put("empty", BlankLiteral.INSTANCE);
            setLanguageLevel(Boolean.getBoolean("mvel.future.lang.support") ? 6 : 5);
        }
    }

    private char[] subArray(int i11, int i12) {
        if (i11 >= i12) {
            return new char[0];
        }
        int i13 = i12 - i11;
        char[] cArr = new char[i13];
        for (int i14 = 0; i14 != i13; i14++) {
            cArr[i14] = this.expr[i14 + i11];
        }
        return cArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addFatalError(String str) {
        this.pCtx.addError(new c(this.expr, this.f72083st, true, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addFatalError(String str, int i11) {
        this.pCtx.addError(new c(this.expr, i11, true, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0187, code lost:
    
        if (r8.dStack.t() <= 1) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0189, code lost:
    
        dreduce();
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0192, code lost:
    
        if (r8.stk.h() == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0194, code lost:
    
        r8.stk.u();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int arithmeticFunctionReduction(int r9) {
        /*
            Method dump skipped, instructions count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.compiler.AbstractParser.arithmeticFunctionReduction(int):int");
    }

    protected void captureIdentifier() {
        char c11;
        if (this.cursor == this.end) {
            throw new CompileException("unexpected end of statement: EOF", this.expr, this.cursor);
        }
        boolean z10 = false;
        while (true) {
            int i11 = this.cursor;
            if (i11 == this.end || (c11 = this.expr[i11]) == ';') {
                return;
            }
            if (!m.c0(c11)) {
                if (z10) {
                    return;
                }
                throw new CompileException("unexpected symbol (was expecting an identifier): " + this.expr[this.cursor], this.expr, this.cursor);
            }
            this.cursor++;
            z10 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void captureToEOS() {
        while (true) {
            int i11 = this.cursor;
            int i12 = this.end;
            if (i11 == i12) {
                return;
            }
            char[] cArr = this.expr;
            char c11 = cArr[i11];
            if (c11 != '\"') {
                if (c11 == ',' || c11 == ';') {
                    return;
                }
                if (c11 != '[' && c11 != '{') {
                    if (c11 == '}') {
                        return;
                    }
                    if (c11 != '\'') {
                        if (c11 != '(') {
                            continue;
                            this.cursor++;
                        }
                    }
                }
                int e11 = m.e(cArr, i11, i12, c11, this.pCtx);
                this.cursor = e11;
                if (e11 >= this.end) {
                    return;
                } else {
                    this.cursor++;
                }
            }
            this.cursor = m.h(c11, cArr, i11, i12);
            this.cursor++;
        }
    }

    protected void captureToEOSorEOL() {
        char c11;
        while (true) {
            int i11 = this.cursor;
            if (i11 == this.end || (c11 = this.expr[i11]) == '\n' || c11 == '\r' || c11 == ';') {
                return;
            } else {
                this.cursor = i11 + 1;
            }
        }
    }

    protected void captureToEOT() {
        int i11;
        skipWhitespace();
        do {
            char[] cArr = this.expr;
            int i12 = this.cursor;
            char c11 = cArr[i12];
            if (c11 == '\"') {
                this.cursor = m.h('\"', cArr, i12, this.end);
            } else {
                if (c11 == ';' || c11 == '=') {
                    return;
                }
                if (c11 != '[') {
                    if (c11 == '.') {
                        this.cursor = i12 + 1;
                        skipWhitespace();
                        this.cursor--;
                    } else {
                        if (c11 == '/') {
                            return;
                        }
                        if (c11 != '{') {
                            if (c11 != '|') {
                                switch (c11) {
                                    case '%':
                                    case '&':
                                        return;
                                    case '\'':
                                        this.cursor = m.h('\'', cArr, i12, this.end);
                                        break;
                                    case '(':
                                        break;
                                    default:
                                        switch (c11) {
                                            case '*':
                                            case '+':
                                            case ',':
                                                return;
                                            default:
                                                if (m.q0(c11)) {
                                                    skipWhitespace();
                                                    int i13 = this.cursor;
                                                    int i14 = this.end;
                                                    if (i13 < i14 && this.expr[i13] == '.') {
                                                        if (i13 != i14) {
                                                            this.cursor = i13 + 1;
                                                        }
                                                        skipWhitespace();
                                                        break;
                                                    } else {
                                                        trimWhitespace();
                                                        return;
                                                    }
                                                }
                                                break;
                                        }
                                }
                            } else {
                                return;
                            }
                        }
                    }
                }
                int e11 = m.e(cArr, i12, this.end, c11, this.pCtx);
                this.cursor = e11;
                if (e11 == -1) {
                    throw new CompileException("unbalanced braces", this.expr, this.cursor);
                }
            }
            i11 = this.cursor + 1;
            this.cursor = i11;
        } while (i11 < this.end);
    }

    protected void captureToNextTokenJunction() {
        char[] cArr;
        char c11;
        while (true) {
            int i11 = this.cursor;
            int i12 = this.end;
            if (i11 == i12 || (c11 = (cArr = this.expr)[i11]) == '(') {
                return;
            }
            if (c11 != '/') {
                if (c11 != '[') {
                    if (c11 == '{' || m.q0(c11)) {
                        return;
                    } else {
                        this.cursor++;
                    }
                }
            } else if (cArr[i11 + 1] == '*') {
                return;
            }
            this.cursor = m.e(cArr, i11, i12, '[', this.pCtx) + 1;
        }
    }

    protected void expectEOS() {
        char c11;
        skipWhitespace();
        int i11 = this.cursor;
        if (i11 == this.end || (c11 = this.expr[i11]) == ';') {
            return;
        }
        if (c11 != '!') {
            if (c11 != '&') {
                if (c11 != '-' && c11 != '/') {
                    if (c11 != '|') {
                        if (c11 != '*' && c11 != '+') {
                            switch (c11) {
                                case '<':
                                case '>':
                                    return;
                                case '=':
                                    char lookAhead = lookAhead();
                                    if (lookAhead == '*' || lookAhead == '+' || lookAhead == '-' || lookAhead == '=') {
                                        return;
                                    }
                                    break;
                            }
                        }
                    } else if (lookAhead() == '|') {
                        return;
                    }
                }
                if (lookAhead() == '=') {
                    return;
                }
            } else if (lookAhead() == '&') {
                return;
            }
        } else if (lookAhead() == '=') {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("expected end of statement but encountered: ");
        int i12 = this.cursor;
        sb2.append(i12 == this.end ? "<end of stream>" : Character.valueOf(this.expr[i12]));
        throw new CompileException(sb2.toString(), this.expr, this.cursor);
    }

    public void expectNextChar_IW(char c11) {
        nextNonBlank();
        int i11 = this.cursor;
        if (i11 == this.end) {
            throw new CompileException("unexpected end of statement", this.expr, this.f72083st);
        }
        if (this.expr[i11] == c11) {
            return;
        }
        throw new CompileException("unexpected character ('" + this.expr[this.cursor] + "'); was expecting: " + c11, this.expr, this.f72083st);
    }

    public int getCursor() {
        return this.cursor;
    }

    public char[] getExpression() {
        return this.expr;
    }

    public ASTNode handleSubstatement(Substatement substatement) {
        return (substatement.getStatement() == null || !substatement.getStatement().isLiteralOnly()) ? substatement : new LiteralNode(substatement.getStatement().getValue(null, null, null), this.pCtx);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
    
        if (r1 != '[') goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected org.mvel2.ast.ASTNode handleUnion(org.mvel2.ast.ASTNode r11) {
        /*
            r10 = this;
            int r0 = r10.cursor
            int r1 = r10.end
            if (r0 == r1) goto L3c
            r10.skipWhitespace()
            int r0 = r10.cursor
            int r1 = r10.end
            r2 = -1
            if (r0 >= r1) goto L22
            char[] r1 = r10.expr
            char r1 = r1[r0]
            r3 = 46
            if (r1 == r3) goto L1f
            r3 = 91
            if (r1 == r3) goto L1d
            goto L22
        L1d:
            r5 = r0
            goto L23
        L1f:
            int r0 = r0 + 1
            goto L1d
        L22:
            r5 = r2
        L23:
            if (r5 == r2) goto L3c
            r10.captureToEOT()
            org.mvel2.ast.Union r0 = new org.mvel2.ast.Union
            char[] r4 = r10.expr
            int r1 = r10.cursor
            int r6 = r1 - r5
            int r7 = r10.fields
            org.mvel2.ParserContext r9 = r10.pCtx
            r3 = r0
            r8 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r10.lastNode = r0
            return r0
        L3c:
            r10.lastNode = r11
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.compiler.AbstractParser.handleUnion(org.mvel2.ast.ASTNode):org.mvel2.ast.ASTNode");
    }

    protected boolean ifThenElseBlockContinues() {
        int i11 = this.cursor;
        if (i11 + 4 >= this.end) {
            return false;
        }
        if (this.expr[i11] != ';') {
            this.cursor = i11 - 1;
        }
        skipWhitespace();
        int i12 = this.cursor;
        if (i12 + 4 >= this.end) {
            return false;
        }
        char[] cArr = this.expr;
        if (cArr[i12] == 'e' && cArr[i12 + 1] == 'l' && cArr[i12 + 2] == 's' && cArr[i12 + 3] == 'e') {
            return m.q0(cArr[i12 + 4]) || this.expr[this.cursor + 4] == '{';
        }
        return false;
    }

    public int incNextNonBlank() {
        this.cursor++;
        return nextNonBlank();
    }

    protected boolean isNextIdentifier() {
        while (true) {
            int i11 = this.cursor;
            if (i11 == this.end || !m.q0(this.expr[i11])) {
                break;
            }
            this.cursor++;
        }
        int i12 = this.cursor;
        return i12 != this.end && m.c0(this.expr[i12]);
    }

    protected boolean isNextIdentifierOrLiteral() {
        int i11 = this.cursor;
        if (i11 == this.end) {
            return false;
        }
        while (i11 != this.end && m.q0(this.expr[i11])) {
            i11++;
        }
        if (i11 == this.end) {
            return false;
        }
        char c11 = this.expr[i11];
        return m.c0(c11) || m.b0(c11) || c11 == '\'' || c11 == '\"';
    }

    protected boolean isStatementNotManuallyTerminated() {
        int i11 = this.cursor;
        if (i11 >= this.end) {
            return false;
        }
        while (i11 != this.end && m.q0(this.expr[i11])) {
            i11++;
        }
        return i11 == this.end || this.expr[i11] != ';';
    }

    protected boolean lastNonWhite(char c11) {
        int i11 = this.cursor - 1;
        while (m.q0(this.expr[i11])) {
            i11--;
        }
        return c11 == this.expr[i11];
    }

    protected char lookAhead() {
        int i11 = this.cursor;
        if (i11 + 1 != this.end) {
            return this.expr[i11 + 1];
        }
        return (char) 0;
    }

    protected char lookAhead(int i11) {
        int i12 = this.cursor;
        if (i12 + i11 >= this.end) {
            return (char) 0;
        }
        return this.expr[i12 + i11];
    }

    protected char lookBehind() {
        int i11 = this.cursor;
        if (i11 == this.start) {
            return (char) 0;
        }
        return this.expr[i11 - 1];
    }

    protected char lookToLast() {
        int i11 = this.cursor;
        if (i11 == this.start) {
            return (char) 0;
        }
        while (i11 != this.start) {
            i11--;
            if (!m.q0(this.expr[i11])) {
                break;
            }
        }
        return this.expr[i11];
    }

    public int nextNonBlank() {
        int i11 = this.cursor;
        if (i11 + 1 >= this.end) {
            throw new CompileException("unexpected end of statement", this.expr, this.f72083st);
        }
        while (i11 != this.end && m.q0(this.expr[i11])) {
            i11++;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0bde, code lost:
    
        return createPropertyToken(r36.f72083st, r36.cursor);
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0b3d, code lost:
    
        if (lookAhead() != '=') goto L427;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0b3f, code lost:
    
        r2 = new java.lang.String(r36.expr, r36.f72083st, trimLeft(r36.cursor) - r36.f72083st);
        r3 = r36.cursor + 2;
        r36.cursor = r3;
        r36.f72083st = r3;
        captureToEOS();
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0b5c, code lost:
    
        if (r6 == false) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0b5e, code lost:
    
        r3 = r36.expr;
        r4 = r36.f72083st;
        r2 = new org.mvel2.ast.DeepAssignmentNode(r3, r4, r36.cursor - r4, r36.fields, org.mvel2.util.m.u0(r12), r7, r36.pCtx);
        r36.lastNode = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0b81, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0b82, code lost:
    
        r3 = r36.pCtx;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0b84, code lost:
    
        if (r3 == null) goto L424;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0b86, code lost:
    
        r9 = r3.variableIndexOf(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0b8a, code lost:
    
        if (r9 == (-1)) goto L424;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0b8c, code lost:
    
        r5 = r36.expr;
        r6 = r36.f72083st;
        r2 = new org.mvel2.ast.IndexedOperativeAssign(r5, r6, r36.cursor - r6, org.mvel2.util.m.u0(r12), r9, r36.fields, r36.pCtx);
        r36.lastNode = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0ba4, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0ba5, code lost:
    
        r4 = r36.expr;
        r5 = r36.f72083st;
        r3 = new org.mvel2.ast.OperativeAssign(r2, r4, r5, r36.cursor - r5, org.mvel2.util.m.u0(r12), r36.fields, r36.pCtx);
        r36.lastNode = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0bc7, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:547:0x1223, code lost:
    
        throw new org.mvel2.CompileException("unbalanced braces", r36.expr, r36.f72083st);
     */
    /* JADX WARN: Code restructure failed: missing block: B:562:0x120e, code lost:
    
        r2 = r36.f72083st;
        r7 = r7 + 1;
        r36.cursor = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:563:0x1217, code lost:
    
        return createOperator(r3, r2, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:634:0x0e67, code lost:
    
        r2 = r36.expr;
        r3 = r36.f72083st;
        r4 = r36.cursor + 1;
        r36.cursor = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:635:0x0e74, code lost:
    
        return createOperator(r2, r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:647:0x0e9f, code lost:
    
        throw new org.mvel2.CompileException("not a statement", r36.expr, r36.f72083st);
     */
    /* JADX WARN: Code restructure failed: missing block: B:763:0x1038, code lost:
    
        if (r3 != 0) goto L652;
     */
    /* JADX WARN: Code restructure failed: missing block: B:764:0x103a, code lost:
    
        if (r2 == false) goto L650;
     */
    /* JADX WARN: Code restructure failed: missing block: B:765:0x103c, code lost:
    
        r3 = r36.expr;
        r4 = trimRight(r36.f72083st + 1);
        r2 = new org.mvel2.ast.TypeDescriptor(r3, r4, trimLeft(r36.cursor - 1) - r4, r36.fields);
     */
    /* JADX WARN: Code restructure failed: missing block: B:768:0x1058, code lost:
    
        if (r2.isClass() == false) goto L650;
     */
    /* JADX WARN: Code restructure failed: missing block: B:769:0x105a, code lost:
    
        r16 = org.mvel2.ast.TypeDescriptor.getClassReference(r36.pCtx, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:770:0x1060, code lost:
    
        if (r16 == null) goto L650;
     */
    /* JADX WARN: Code restructure failed: missing block: B:771:0x1062, code lost:
    
        r2 = r36.cursor;
     */
    /* JADX WARN: Code restructure failed: missing block: B:772:0x1064, code lost:
    
        r3 = r36.expr;
     */
    /* JADX WARN: Code restructure failed: missing block: B:773:0x1067, code lost:
    
        if (r2 >= r3.length) goto L875;
     */
    /* JADX WARN: Code restructure failed: missing block: B:774:0x1069, code lost:
    
        r3 = r3[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:775:0x106d, code lost:
    
        if (r3 == ' ') goto L876;
     */
    /* JADX WARN: Code restructure failed: missing block: B:777:0x1071, code lost:
    
        if (r3 != '\t') goto L874;
     */
    /* JADX WARN: Code restructure failed: missing block: B:780:0x10a6, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:783:0x1078, code lost:
    
        if (org.mvel2.util.m.c0(r3) != false) goto L647;
     */
    /* JADX WARN: Code restructure failed: missing block: B:784:0x107a, code lost:
    
        r2 = r36.expr[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:785:0x107e, code lost:
    
        if (r2 == '\'') goto L647;
     */
    /* JADX WARN: Code restructure failed: missing block: B:786:0x1080, code lost:
    
        if (r2 == '\"') goto L647;
     */
    /* JADX WARN: Code restructure failed: missing block: B:788:0x1084, code lost:
    
        if (r2 != '(') goto L650;
     */
    /* JADX WARN: Code restructure failed: missing block: B:789:0x1086, code lost:
    
        r36.f72083st = r36.cursor;
        captureToEOT();
        r13 = r36.expr;
        r14 = r36.f72083st;
        r2 = new org.mvel2.ast.TypeCast(r13, r14, r36.cursor - r14, r16, r36.fields, r36.pCtx);
        r36.lastNode = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:790:0x10a5, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:798:0x10fa, code lost:
    
        throw new org.mvel2.CompileException("unbalanced braces in expression: (" + r3 + "):", r36.expr, r36.f72083st);
     */
    /* JADX WARN: Code restructure failed: missing block: B:808:0x1117, code lost:
    
        r4 = r36.f72083st + 1;
        r6 = org.mvel2.util.m.h(r8, r3, r7, r36.end);
        r36.cursor = r6;
        r36.lastNode = new org.mvel2.ast.LiteralNode(org.mvel2.util.m.Y(org.mvel2.util.m.K0(r3, r4, (r6 - r36.f72083st) - 1)), java.lang.String.class, r36.pCtx);
        r36.cursor++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:809:0x1142, code lost:
    
        if (tokenContinues() == false) goto L664;
     */
    /* JADX WARN: Code restructure failed: missing block: B:810:0x1144, code lost:
    
        r2 = handleUnion(r36.lastNode);
        r36.lastNode = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:811:0x114c, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:813:0x114f, code lost:
    
        return r36.lastNode;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x022e, code lost:
    
        return (org.mvel2.ast.ASTNode) r36.splitAccumulator.n();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:246:0x04fc. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:267:0x04ff. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:268:0x0502. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:515:0x0bed. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:516:0x0bf0. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:517:0x0bf3. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:518:0x0bf6. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:519:0x0bf9. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:63:0x0148. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:64:0x014b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:65:0x014e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0381 A[Catch: CompileException -> 0x0023, ArrayIndexOutOfBoundsException -> 0x0027, StringIndexOutOfBoundsException -> 0x002b, NumberFormatException -> 0x002f, RedundantCodeException -> 0x12d6, TryCatch #4 {ArrayIndexOutOfBoundsException -> 0x0027, NumberFormatException -> 0x002f, StringIndexOutOfBoundsException -> 0x002b, CompileException -> 0x0023, RedundantCodeException -> 0x12d6, blocks: (B:3:0x0002, B:5:0x000a, B:7:0x001a, B:9:0x001e, B:13:0x0034, B:16:0x003c, B:18:0x0042, B:19:0x004a, B:21:0x0050, B:23:0x0054, B:25:0x005c, B:27:0x0068, B:28:0x0073, B:31:0x007d, B:33:0x009b, B:35:0x00a3, B:37:0x00c2, B:38:0x00cd, B:39:0x00ce, B:40:0x00d2, B:41:0x00db, B:43:0x00e1, B:45:0x00eb, B:46:0x00f0, B:48:0x00f6, B:50:0x0100, B:56:0x0114, B:58:0x012a, B:60:0x0136, B:63:0x0148, B:64:0x014b, B:65:0x014e, B:99:0x0153, B:102:0x0158, B:105:0x0166, B:67:0x0188, B:68:0x018d, B:70:0x0199, B:73:0x019f, B:80:0x01a8, B:81:0x01b3, B:82:0x01b4, B:84:0x01c3, B:86:0x01c9, B:87:0x020a, B:89:0x0210, B:91:0x0219, B:94:0x0226, B:97:0x01e6, B:108:0x022f, B:111:0x0255, B:113:0x0276, B:114:0x0291, B:116:0x0280, B:118:0x0294, B:121:0x02c9, B:124:0x02d0, B:127:0x02ee, B:130:0x02f5, B:133:0x02fc, B:136:0x0303, B:139:0x030a, B:142:0x0312, B:143:0x031d, B:145:0x031e, B:148:0x0325, B:151:0x032c, B:153:0x0340, B:155:0x034c, B:159:0x0354, B:161:0x035a, B:162:0x035d, B:164:0x0381, B:166:0x0393, B:168:0x039f, B:170:0x03a9, B:172:0x03bd, B:174:0x03c3, B:176:0x03d1, B:186:0x03dd, B:179:0x03f3, B:181:0x040c, B:183:0x043e, B:190:0x03e7, B:191:0x03f2, B:192:0x0453, B:193:0x045e, B:194:0x045f, B:196:0x046d, B:198:0x0474, B:199:0x047f, B:202:0x0480, B:203:0x04a0, B:205:0x04a1, B:207:0x04b6, B:209:0x04bf, B:211:0x04c7, B:213:0x04d0, B:215:0x04d6, B:246:0x04fc, B:267:0x04ff, B:268:0x0502, B:385:0x0507, B:398:0x0511, B:399:0x0516, B:401:0x051c, B:403:0x0526, B:388:0x052c, B:390:0x0534, B:394:0x0542, B:375:0x0548, B:377:0x0550, B:380:0x0556, B:270:0x055e, B:272:0x0566, B:274:0x056d, B:276:0x058c, B:278:0x05ae, B:280:0x05b2, B:282:0x05b8, B:284:0x05cf, B:286:0x05f1, B:288:0x05fa, B:290:0x0601, B:292:0x0620, B:294:0x0642, B:296:0x0646, B:298:0x064c, B:300:0x0663, B:303:0x0684, B:305:0x068c, B:307:0x06ac, B:309:0x06b3, B:311:0x06b9, B:313:0x06cf, B:315:0x06f1, B:316:0x0716, B:317:0x0717, B:319:0x071f, B:321:0x073f, B:323:0x0746, B:325:0x074c, B:327:0x0762, B:329:0x0783, B:330:0x07a8, B:331:0x07a9, B:333:0x07ad, B:335:0x07b3, B:337:0x07ba, B:339:0x07da, B:341:0x07de, B:343:0x07e4, B:345:0x07e8, B:347:0x07ee, B:349:0x07f6, B:351:0x081f, B:352:0x0831, B:354:0x0834, B:357:0x084e, B:359:0x0856, B:361:0x085d, B:363:0x087c, B:365:0x089e, B:367:0x08a2, B:369:0x08a8, B:371:0x08bf, B:412:0x08e1, B:414:0x08ea, B:417:0x08f4, B:419:0x08fe, B:421:0x0902, B:423:0x090c, B:426:0x0914, B:428:0x091e, B:435:0x0928, B:437:0x0947, B:439:0x0969, B:441:0x096d, B:443:0x0973, B:445:0x0992, B:448:0x09a8, B:450:0x09bd, B:452:0x09c3, B:453:0x09d6, B:455:0x09cd, B:457:0x09e2, B:460:0x09ec, B:462:0x09f6, B:464:0x09fa, B:466:0x0a04, B:469:0x0a0c, B:471:0x0a16, B:476:0x0a1d, B:478:0x0a35, B:480:0x0a60, B:482:0x0a64, B:484:0x0a6a, B:486:0x0a8b, B:489:0x0ab7, B:491:0x0acc, B:493:0x0ad2, B:494:0x0ae5, B:496:0x0adc, B:264:0x0af1, B:233:0x0b04, B:502:0x0b0f, B:504:0x0b15, B:248:0x0b39, B:250:0x0b3f, B:252:0x0b5e, B:254:0x0b82, B:256:0x0b86, B:258:0x0b8c, B:260:0x0ba5, B:220:0x0bc8, B:237:0x0bd3, B:510:0x0bdf, B:515:0x0bed, B:516:0x0bf0, B:517:0x0bf3, B:518:0x0bf6, B:519:0x0bf9, B:520:0x0bfc, B:522:0x0c02, B:524:0x0c09, B:526:0x0c3b, B:528:0x0c45, B:531:0x0c65, B:532:0x0c68, B:534:0x0c13, B:536:0x0c1f, B:539:0x0c71, B:541:0x0c7b, B:543:0x0c86, B:565:0x0c8d, B:567:0x0c99, B:569:0x0c9f, B:571:0x0cb7, B:573:0x0cd3, B:574:0x0cf9, B:558:0x0cfa, B:560:0x0cfe, B:576:0x0d04, B:580:0x0d0e, B:582:0x0d18, B:584:0x0d22, B:585:0x0d26, B:587:0x0d2f, B:590:0x0d3a, B:593:0x0d45, B:595:0x0d4f, B:597:0x0d57, B:598:0x0d5b, B:601:0x0d66, B:603:0x0d71, B:606:0x0d78, B:609:0x0d88, B:613:0x0d99, B:615:0x0dcc, B:657:0x0dd5, B:659:0x0df6, B:661:0x0dfc, B:663:0x0e06, B:617:0x0e10, B:619:0x0e16, B:621:0x0e1a, B:623:0x0e1e, B:625:0x0e49, B:627:0x0e4f, B:629:0x0e53, B:631:0x0e57, B:634:0x0e67, B:636:0x0e5d, B:638:0x0e75, B:640:0x0e7d, B:642:0x0e89, B:646:0x0e94, B:647:0x0e9f, B:649:0x0ea0, B:651:0x0e24, B:654:0x0e2e, B:667:0x0ea7, B:669:0x0eaf, B:671:0x0ed0, B:673:0x0ed6, B:675:0x0ee0, B:677:0x0eea, B:680:0x0ef8, B:682:0x0f00, B:683:0x0f05, B:686:0x0f13, B:687:0x0f1c, B:690:0x0f26, B:694:0x0f30, B:699:0x0f3b, B:701:0x0f41, B:705:0x1031, B:711:0x0f4e, B:713:0x0f52, B:715:0x0f56, B:718:0x0f60, B:720:0x0f6a, B:722:0x0f72, B:726:0x0f7e, B:728:0x0f84, B:730:0x0f8a, B:733:0x1018, B:734:0x0f8f, B:737:0x0f93, B:739:0x0f9c, B:741:0x0fc5, B:742:0x0fc8, B:744:0x0fe8, B:747:0x1008, B:749:0x100b, B:751:0x1012, B:754:0x101f, B:755:0x102a, B:760:0x102b, B:765:0x103c, B:767:0x1054, B:769:0x105a, B:771:0x1062, B:772:0x1064, B:774:0x1069, B:782:0x1074, B:784:0x107a, B:789:0x1086, B:795:0x10a9, B:797:0x10db, B:798:0x10fa, B:801:0x10fb, B:803:0x1105, B:805:0x1110, B:808:0x1117, B:810:0x1144, B:812:0x114d, B:818:0x1150, B:820:0x1159, B:822:0x115d, B:825:0x1164, B:826:0x116f, B:827:0x1170, B:829:0x118b, B:832:0x1194, B:834:0x11a9, B:836:0x11c1, B:838:0x11cb, B:842:0x11ed, B:845:0x11f7, B:847:0x1201, B:848:0x120d, B:562:0x120e, B:546:0x1218, B:547:0x1223, B:549:0x1224, B:551:0x1235, B:553:0x125a, B:554:0x125d, B:556:0x1272, B:854:0x128b, B:857:0x1291), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0393 A[Catch: CompileException -> 0x0023, ArrayIndexOutOfBoundsException -> 0x0027, StringIndexOutOfBoundsException -> 0x002b, NumberFormatException -> 0x002f, RedundantCodeException -> 0x12d6, TryCatch #4 {ArrayIndexOutOfBoundsException -> 0x0027, NumberFormatException -> 0x002f, StringIndexOutOfBoundsException -> 0x002b, CompileException -> 0x0023, RedundantCodeException -> 0x12d6, blocks: (B:3:0x0002, B:5:0x000a, B:7:0x001a, B:9:0x001e, B:13:0x0034, B:16:0x003c, B:18:0x0042, B:19:0x004a, B:21:0x0050, B:23:0x0054, B:25:0x005c, B:27:0x0068, B:28:0x0073, B:31:0x007d, B:33:0x009b, B:35:0x00a3, B:37:0x00c2, B:38:0x00cd, B:39:0x00ce, B:40:0x00d2, B:41:0x00db, B:43:0x00e1, B:45:0x00eb, B:46:0x00f0, B:48:0x00f6, B:50:0x0100, B:56:0x0114, B:58:0x012a, B:60:0x0136, B:63:0x0148, B:64:0x014b, B:65:0x014e, B:99:0x0153, B:102:0x0158, B:105:0x0166, B:67:0x0188, B:68:0x018d, B:70:0x0199, B:73:0x019f, B:80:0x01a8, B:81:0x01b3, B:82:0x01b4, B:84:0x01c3, B:86:0x01c9, B:87:0x020a, B:89:0x0210, B:91:0x0219, B:94:0x0226, B:97:0x01e6, B:108:0x022f, B:111:0x0255, B:113:0x0276, B:114:0x0291, B:116:0x0280, B:118:0x0294, B:121:0x02c9, B:124:0x02d0, B:127:0x02ee, B:130:0x02f5, B:133:0x02fc, B:136:0x0303, B:139:0x030a, B:142:0x0312, B:143:0x031d, B:145:0x031e, B:148:0x0325, B:151:0x032c, B:153:0x0340, B:155:0x034c, B:159:0x0354, B:161:0x035a, B:162:0x035d, B:164:0x0381, B:166:0x0393, B:168:0x039f, B:170:0x03a9, B:172:0x03bd, B:174:0x03c3, B:176:0x03d1, B:186:0x03dd, B:179:0x03f3, B:181:0x040c, B:183:0x043e, B:190:0x03e7, B:191:0x03f2, B:192:0x0453, B:193:0x045e, B:194:0x045f, B:196:0x046d, B:198:0x0474, B:199:0x047f, B:202:0x0480, B:203:0x04a0, B:205:0x04a1, B:207:0x04b6, B:209:0x04bf, B:211:0x04c7, B:213:0x04d0, B:215:0x04d6, B:246:0x04fc, B:267:0x04ff, B:268:0x0502, B:385:0x0507, B:398:0x0511, B:399:0x0516, B:401:0x051c, B:403:0x0526, B:388:0x052c, B:390:0x0534, B:394:0x0542, B:375:0x0548, B:377:0x0550, B:380:0x0556, B:270:0x055e, B:272:0x0566, B:274:0x056d, B:276:0x058c, B:278:0x05ae, B:280:0x05b2, B:282:0x05b8, B:284:0x05cf, B:286:0x05f1, B:288:0x05fa, B:290:0x0601, B:292:0x0620, B:294:0x0642, B:296:0x0646, B:298:0x064c, B:300:0x0663, B:303:0x0684, B:305:0x068c, B:307:0x06ac, B:309:0x06b3, B:311:0x06b9, B:313:0x06cf, B:315:0x06f1, B:316:0x0716, B:317:0x0717, B:319:0x071f, B:321:0x073f, B:323:0x0746, B:325:0x074c, B:327:0x0762, B:329:0x0783, B:330:0x07a8, B:331:0x07a9, B:333:0x07ad, B:335:0x07b3, B:337:0x07ba, B:339:0x07da, B:341:0x07de, B:343:0x07e4, B:345:0x07e8, B:347:0x07ee, B:349:0x07f6, B:351:0x081f, B:352:0x0831, B:354:0x0834, B:357:0x084e, B:359:0x0856, B:361:0x085d, B:363:0x087c, B:365:0x089e, B:367:0x08a2, B:369:0x08a8, B:371:0x08bf, B:412:0x08e1, B:414:0x08ea, B:417:0x08f4, B:419:0x08fe, B:421:0x0902, B:423:0x090c, B:426:0x0914, B:428:0x091e, B:435:0x0928, B:437:0x0947, B:439:0x0969, B:441:0x096d, B:443:0x0973, B:445:0x0992, B:448:0x09a8, B:450:0x09bd, B:452:0x09c3, B:453:0x09d6, B:455:0x09cd, B:457:0x09e2, B:460:0x09ec, B:462:0x09f6, B:464:0x09fa, B:466:0x0a04, B:469:0x0a0c, B:471:0x0a16, B:476:0x0a1d, B:478:0x0a35, B:480:0x0a60, B:482:0x0a64, B:484:0x0a6a, B:486:0x0a8b, B:489:0x0ab7, B:491:0x0acc, B:493:0x0ad2, B:494:0x0ae5, B:496:0x0adc, B:264:0x0af1, B:233:0x0b04, B:502:0x0b0f, B:504:0x0b15, B:248:0x0b39, B:250:0x0b3f, B:252:0x0b5e, B:254:0x0b82, B:256:0x0b86, B:258:0x0b8c, B:260:0x0ba5, B:220:0x0bc8, B:237:0x0bd3, B:510:0x0bdf, B:515:0x0bed, B:516:0x0bf0, B:517:0x0bf3, B:518:0x0bf6, B:519:0x0bf9, B:520:0x0bfc, B:522:0x0c02, B:524:0x0c09, B:526:0x0c3b, B:528:0x0c45, B:531:0x0c65, B:532:0x0c68, B:534:0x0c13, B:536:0x0c1f, B:539:0x0c71, B:541:0x0c7b, B:543:0x0c86, B:565:0x0c8d, B:567:0x0c99, B:569:0x0c9f, B:571:0x0cb7, B:573:0x0cd3, B:574:0x0cf9, B:558:0x0cfa, B:560:0x0cfe, B:576:0x0d04, B:580:0x0d0e, B:582:0x0d18, B:584:0x0d22, B:585:0x0d26, B:587:0x0d2f, B:590:0x0d3a, B:593:0x0d45, B:595:0x0d4f, B:597:0x0d57, B:598:0x0d5b, B:601:0x0d66, B:603:0x0d71, B:606:0x0d78, B:609:0x0d88, B:613:0x0d99, B:615:0x0dcc, B:657:0x0dd5, B:659:0x0df6, B:661:0x0dfc, B:663:0x0e06, B:617:0x0e10, B:619:0x0e16, B:621:0x0e1a, B:623:0x0e1e, B:625:0x0e49, B:627:0x0e4f, B:629:0x0e53, B:631:0x0e57, B:634:0x0e67, B:636:0x0e5d, B:638:0x0e75, B:640:0x0e7d, B:642:0x0e89, B:646:0x0e94, B:647:0x0e9f, B:649:0x0ea0, B:651:0x0e24, B:654:0x0e2e, B:667:0x0ea7, B:669:0x0eaf, B:671:0x0ed0, B:673:0x0ed6, B:675:0x0ee0, B:677:0x0eea, B:680:0x0ef8, B:682:0x0f00, B:683:0x0f05, B:686:0x0f13, B:687:0x0f1c, B:690:0x0f26, B:694:0x0f30, B:699:0x0f3b, B:701:0x0f41, B:705:0x1031, B:711:0x0f4e, B:713:0x0f52, B:715:0x0f56, B:718:0x0f60, B:720:0x0f6a, B:722:0x0f72, B:726:0x0f7e, B:728:0x0f84, B:730:0x0f8a, B:733:0x1018, B:734:0x0f8f, B:737:0x0f93, B:739:0x0f9c, B:741:0x0fc5, B:742:0x0fc8, B:744:0x0fe8, B:747:0x1008, B:749:0x100b, B:751:0x1012, B:754:0x101f, B:755:0x102a, B:760:0x102b, B:765:0x103c, B:767:0x1054, B:769:0x105a, B:771:0x1062, B:772:0x1064, B:774:0x1069, B:782:0x1074, B:784:0x107a, B:789:0x1086, B:795:0x10a9, B:797:0x10db, B:798:0x10fa, B:801:0x10fb, B:803:0x1105, B:805:0x1110, B:808:0x1117, B:810:0x1144, B:812:0x114d, B:818:0x1150, B:820:0x1159, B:822:0x115d, B:825:0x1164, B:826:0x116f, B:827:0x1170, B:829:0x118b, B:832:0x1194, B:834:0x11a9, B:836:0x11c1, B:838:0x11cb, B:842:0x11ed, B:845:0x11f7, B:847:0x1201, B:848:0x120d, B:562:0x120e, B:546:0x1218, B:547:0x1223, B:549:0x1224, B:551:0x1235, B:553:0x125a, B:554:0x125d, B:556:0x1272, B:854:0x128b, B:857:0x1291), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.mvel2.ast.ASTNode nextToken() {
        /*
            Method dump skipped, instructions count: 5006
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.compiler.AbstractParser.nextToken():org.mvel2.ast.ASTNode");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ASTNode nextTokenSkipSymbols() {
        ASTNode nextToken = nextToken();
        return (nextToken == null || nextToken.getFields() != -1) ? nextToken : nextToken();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reduce() {
        try {
            int intValue = ((Integer) this.stk.n()).intValue();
            if (intValue != 0) {
                boolean z10 = true;
                if (intValue != 1 && intValue != 2 && intValue != 3 && intValue != 4 && intValue != 5) {
                    if (intValue == 36) {
                        g gVar = this.stk;
                        gVar.q(Boolean.valueOf(org.mvel2.b.a(gVar.l().getClass(), (Class) this.stk.o())));
                        return;
                    }
                    switch (intValue) {
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                            break;
                        default:
                            switch (intValue) {
                                case 21:
                                    Object n11 = this.stk.n();
                                    g gVar2 = this.stk;
                                    if (!((Boolean) gVar2.n()).booleanValue() || !((Boolean) n11).booleanValue()) {
                                        z10 = false;
                                    }
                                    gVar2.q(Boolean.valueOf(z10));
                                    return;
                                case 22:
                                    Object n12 = this.stk.n();
                                    g gVar3 = this.stk;
                                    if (!((Boolean) gVar3.n()).booleanValue() && !((Boolean) n12).booleanValue()) {
                                        z10 = false;
                                    }
                                    gVar3.q(Boolean.valueOf(z10));
                                    return;
                                case 23:
                                    Object n13 = this.stk.n();
                                    Object n14 = this.stk.n();
                                    if (n.k(n14) && n.k(n13)) {
                                        this.stk.q(null);
                                        return;
                                    }
                                    this.stk.b();
                                    g gVar4 = this.stk;
                                    if (!n.k(n14)) {
                                        n13 = n14;
                                    }
                                    gVar4.q(n13);
                                    return;
                                case 24:
                                    g gVar5 = this.stk;
                                    gVar5.q(Boolean.valueOf(Pattern.compile(String.valueOf(gVar5.n())).matcher(String.valueOf(this.stk.n())).matches()));
                                    return;
                                case 25:
                                    g gVar6 = this.stk;
                                    gVar6.q(Boolean.valueOf(((Class) gVar6.n()).isInstance(this.stk.n())));
                                    return;
                                case 26:
                                    g gVar7 = this.stk;
                                    gVar7.q(Boolean.valueOf(m.l(gVar7.l(), this.stk.o())));
                                    return;
                                case 27:
                                    g gVar8 = this.stk;
                                    gVar8.q(Boolean.valueOf(r.a(String.valueOf(gVar8.n())).equals(r.a(String.valueOf(this.stk.n())))));
                                    return;
                                case 28:
                                    g gVar9 = this.stk;
                                    gVar9.q(Float.valueOf(m.D0(String.valueOf(gVar9.n()), String.valueOf(this.stk.n()))));
                                    return;
                                default:
                                    reduceNumeric(intValue);
                                    return;
                            }
                    }
                }
            }
            this.stk.j(intValue);
        } catch (ArithmeticException e11) {
            throw new CompileException("arithmetic error: " + e11.getMessage(), this.expr, this.f72083st, e11);
        } catch (ClassCastException e12) {
            throw new CompileException("syntax error or incompatable types", this.expr, this.f72083st, e12);
        } catch (Exception e13) {
            throw new CompileException("failed to subEval expression", this.expr, this.f72083st, e13);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setExpression(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        WeakHashMap<String, char[]> weakHashMap = EX_PRECACHE;
        synchronized (weakHashMap) {
            try {
                char[] cArr = weakHashMap.get(str);
                this.expr = cArr;
                if (cArr == null) {
                    char[] charArray = str.toCharArray();
                    this.expr = charArray;
                    int length = charArray.length;
                    this.length = length;
                    this.end = length;
                    while (true) {
                        int i11 = this.start;
                        if (i11 >= this.length || !m.q0(this.expr[i11])) {
                            break;
                        } else {
                            this.start++;
                        }
                    }
                    while (true) {
                        int i12 = this.length;
                        if (i12 == 0 || !m.q0(this.expr[i12 - 1])) {
                            break;
                        } else {
                            this.length--;
                        }
                    }
                    int i13 = this.length;
                    char[] cArr2 = new char[i13];
                    for (int i14 = 0; i14 != i13; i14++) {
                        cArr2[i14] = this.expr[i14];
                    }
                    EX_PRECACHE.put(str, cArr2);
                } else {
                    int length2 = cArr.length;
                    this.length = length2;
                    this.end = length2;
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setExpression(char[] cArr) {
        this.expr = cArr;
        int length = cArr.length;
        this.length = length;
        this.end = length;
        while (true) {
            int i11 = this.start;
            if (i11 >= this.length || !m.q0(this.expr[i11])) {
                break;
            } else {
                this.start++;
            }
        }
        while (true) {
            int i12 = this.length;
            if (i12 == 0 || !m.q0(this.expr[i12 - 1])) {
                return;
            } else {
                this.length--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void skipWhitespace() {
        int i11;
        int i12;
        int i13;
        while (true) {
            int i14 = this.cursor;
            int i15 = this.end;
            if (i14 == i15) {
                return;
            }
            char[] cArr = this.expr;
            char c11 = cArr[i14];
            if (c11 == '\n') {
                this.line++;
                this.lastLineStart = i14;
            } else if (c11 != '\r') {
                if (c11 == '/' && i14 + 1 != i15) {
                    char c12 = cArr[i14 + 1];
                    if (c12 == '*') {
                        int i16 = i15 - 1;
                        this.cursor = i14 + 1;
                        while (true) {
                            i13 = this.cursor;
                            if (i13 == i16) {
                                break;
                            }
                            char[] cArr2 = this.expr;
                            if (cArr2[i13] == '*' && cArr2[i13 + 1] == '/') {
                                break;
                            } else {
                                this.cursor = i13 + 1;
                            }
                        }
                        if (i13 != i16) {
                            this.cursor = i13 + 2;
                        }
                        while (i14 < this.cursor) {
                            this.expr[i14] = ' ';
                            i14++;
                        }
                    } else {
                        if (c12 != '/') {
                            return;
                        }
                        this.cursor = i14 + 1;
                        cArr[i14] = ' ';
                        while (true) {
                            i11 = this.cursor;
                            i12 = this.end;
                            if (i11 == i12) {
                                break;
                            }
                            char[] cArr3 = this.expr;
                            if (cArr3[i11] == '\n') {
                                break;
                            }
                            this.cursor = i11 + 1;
                            cArr3[i11] = ' ';
                        }
                        if (i11 != i12) {
                            this.cursor = i11 + 1;
                        }
                        this.line++;
                        this.lastLineStart = this.cursor;
                    }
                } else if (!m.q0(c11)) {
                    return;
                } else {
                    this.cursor++;
                }
            }
            this.cursor = i14 + 1;
        }
    }

    protected boolean tokenContinues() {
        char c11;
        int i11 = this.cursor;
        if (i11 == this.end) {
            return false;
        }
        char c12 = this.expr[i11];
        if (c12 == '.' || c12 == '[') {
            return true;
        }
        if (m.q0(c12)) {
            int i12 = this.cursor;
            skipWhitespace();
            int i13 = this.cursor;
            if (i13 != this.end && ((c11 = this.expr[i13]) == '.' || c11 == '[')) {
                return true;
            }
            this.cursor = i12;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int trimLeft(int i11) {
        int i12 = this.end;
        if (i11 > i12) {
            i11 = i12;
        }
        while (i11 > 0 && i11 >= this.f72083st) {
            int i13 = i11 - 1;
            if (!m.q0(this.expr[i13]) && this.expr[i13] != ';') {
                break;
            }
            i11--;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int trimRight(int i11) {
        while (i11 != this.end && m.q0(this.expr[i11])) {
            i11++;
        }
        return i11;
    }

    protected void trimWhitespace() {
        while (true) {
            int i11 = this.cursor;
            if (i11 == 0 || !m.q0(this.expr[i11 - 1])) {
                return;
            } else {
                this.cursor--;
            }
        }
    }
}
