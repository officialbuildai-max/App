package r10;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.templates.CompiledTemplate;
import org.mvel2.templates.res.CodeNode;
import org.mvel2.templates.res.CommentNode;
import org.mvel2.templates.res.CompiledCodeNode;
import org.mvel2.templates.res.CompiledDeclareNode;
import org.mvel2.templates.res.CompiledEvalNode;
import org.mvel2.templates.res.CompiledExpressionNode;
import org.mvel2.templates.res.CompiledForEachNode;
import org.mvel2.templates.res.CompiledIfNode;
import org.mvel2.templates.res.CompiledIncludeNode;
import org.mvel2.templates.res.CompiledNamedIncludeNode;
import org.mvel2.templates.res.CompiledTerminalExpressionNode;
import org.mvel2.templates.res.DeclareNode;
import org.mvel2.templates.res.EndNode;
import org.mvel2.templates.res.EvalNode;
import org.mvel2.templates.res.ExpressionNode;
import org.mvel2.templates.res.ForEachNode;
import org.mvel2.templates.res.IfNode;
import org.mvel2.templates.res.IncludeNode;
import org.mvel2.templates.res.NamedIncludeNode;
import org.mvel2.templates.res.Node;
import org.mvel2.templates.res.TerminalExpressionNode;
import org.mvel2.templates.res.TerminalNode;
import org.mvel2.templates.res.TextNode;
import org.mvel2.util.g;
import org.mvel2.util.m;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: k, reason: collision with root package name */
    private static final Map f74142k;

    /* renamed from: a, reason: collision with root package name */
    private char[] f74143a;

    /* renamed from: b, reason: collision with root package name */
    private int f74144b;

    /* renamed from: c, reason: collision with root package name */
    private int f74145c;

    /* renamed from: d, reason: collision with root package name */
    private int f74146d;

    /* renamed from: e, reason: collision with root package name */
    private int f74147e;

    /* renamed from: f, reason: collision with root package name */
    private int f74148f;

    /* renamed from: g, reason: collision with root package name */
    private int f74149g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f74150h;

    /* renamed from: i, reason: collision with root package name */
    private Map f74151i;

    /* renamed from: j, reason: collision with root package name */
    private ParserContext f74152j;

    static {
        HashMap hashMap = new HashMap();
        f74142k = hashMap;
        hashMap.put("if", 1);
        hashMap.put("else", 2);
        hashMap.put("elseif", 2);
        hashMap.put(TtmlNode.END, 10);
        hashMap.put("foreach", 3);
        hashMap.put("includeNamed", 51);
        hashMap.put("include", 50);
        hashMap.put("comment", 52);
        hashMap.put("code", 53);
        hashMap.put("eval", 55);
        hashMap.put("declare", 54);
        hashMap.put("stop", 70);
    }

    public b(CharSequence charSequence, boolean z10, ParserContext parserContext) {
        this.f74150h = false;
        char[] charArray = charSequence.toString().toCharArray();
        this.f74143a = charArray;
        this.f74144b = charArray.length;
        this.f74150h = z10;
        this.f74152j = parserContext;
    }

    private char[] a() {
        int i11 = this.f74146d - this.f74145c;
        char[] cArr = new char[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            cArr[i12] = this.f74143a[this.f74145c + i12];
        }
        return cArr;
    }

    private int b() {
        try {
            ParserContext parserContext = new ParserContext();
            char[] cArr = this.f74143a;
            int i11 = this.f74146d;
            this.f74145c = i11;
            this.f74146d = m.e(cArr, i11, this.f74144b, '{', parserContext);
            this.f74148f += parserContext.getLineCount();
            int i12 = this.f74145c + 1;
            this.f74145c = this.f74146d + 1;
            return i12;
        } catch (CompileException e11) {
            e11.setLineNumber(this.f74148f);
            e11.setColumn((this.f74146d - this.f74149g) + 1);
            throw e11;
        }
    }

    private int c() {
        int i11 = this.f74146d + 1;
        this.f74146d = i11;
        while (true) {
            int i12 = this.f74146d;
            if (i12 == this.f74144b || !m.c0(this.f74143a[i12])) {
                break;
            }
            this.f74146d++;
        }
        int i13 = this.f74146d;
        if (i13 == this.f74144b || this.f74143a[i13] != '{') {
            return -1;
        }
        return i11;
    }

    public static CompiledTemplate f(String str) {
        return new b(str, true, ParserContext.create()).d();
    }

    public static CompiledTemplate g(String str, ParserContext parserContext) {
        return new b(str, true, parserContext).d();
    }

    private boolean h(char c11) {
        int i11 = this.f74146d;
        return i11 != this.f74144b && this.f74143a[i11 + 1] == c11;
    }

    private Node i(Node node) {
        int end = node.getEnd();
        int i11 = this.f74147e;
        if (end > i11) {
            i11 = node.getEnd();
        }
        int i12 = this.f74145c;
        if (i11 >= i12) {
            return node;
        }
        int i13 = i12 - 1;
        this.f74147e = i13;
        TextNode textNode = new TextNode(i11, i13);
        node.next = textNode;
        return textNode;
    }

    public CompiledTemplate d() {
        return new CompiledTemplate(this.f74143a, e(null, new g()));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:37:0x0080. Please report as an issue. */
    public Node e(Node node, g gVar) {
        String str;
        Node compiledIfNode;
        Node terminus;
        this.f74148f = 1;
        Node textNode = node == null ? new TextNode(0, 0) : node;
        Node node2 = textNode;
        while (true) {
            try {
                int i11 = this.f74146d;
                if (i11 >= this.f74144b) {
                    if (!gVar.g()) {
                        CompileException compileException = new CompileException("unclosed @" + ((Node) gVar.k()).getName() + "{} block. expected @end{}", this.f74143a, this.f74146d);
                        compileException.setColumn(this.f74146d - this.f74149g);
                        compileException.setLineNumber(this.f74148f);
                        throw compileException;
                    }
                    int i12 = this.f74145c;
                    char[] cArr = this.f74143a;
                    if (i12 < cArr.length) {
                        TextNode textNode2 = new TextNode(i12, cArr.length);
                        textNode.next = textNode2;
                        textNode = textNode2;
                    }
                    textNode.next = new EndNode();
                    Node node3 = node2;
                    while (node3.getLength() == 0 && (node3 = node3.getNext()) != null) {
                    }
                    return (node3 == null || node3.getLength() != this.f74143a.length - 1) ? node2 : node3 instanceof ExpressionNode ? this.f74150h ? new CompiledTerminalExpressionNode(node3, this.f74152j) : new TerminalExpressionNode(node3) : node3;
                }
                char c11 = this.f74143a[i11];
                if (c11 == '\n') {
                    this.f74148f++;
                    this.f74149g = i11 + 1;
                } else if (c11 == '$' || c11 == '@') {
                    if (h(c11)) {
                        int i13 = this.f74146d + 1;
                        this.f74146d = i13;
                        this.f74145c = i13;
                        textNode = i(textNode);
                        textNode.setEnd(textNode.getEnd() + 1);
                        int i14 = this.f74146d + 1;
                        this.f74146d = i14;
                        this.f74147e = i14;
                        this.f74145c = i14;
                    } else {
                        int c12 = c();
                        if (c12 != -1) {
                            this.f74145c = c12;
                            Map map = f74142k;
                            str = new String(a());
                            Integer num = (Integer) map.get(str);
                            int intValue = num == null ? 0 : num.intValue();
                            if (intValue == 1) {
                                Node i15 = i(textNode);
                                compiledIfNode = this.f74150h ? new CompiledIfNode(this.f74145c, str, this.f74143a, b(), this.f74145c, this.f74152j) : new IfNode(this.f74145c, str, this.f74143a, b(), this.f74145c);
                                i15.next = compiledIfNode;
                                gVar.q(compiledIfNode);
                                compiledIfNode.setTerminus(new TerminalNode());
                            } else if (intValue != 2) {
                                if (intValue != 3) {
                                    if (intValue != 10) {
                                        switch (intValue) {
                                            case 50:
                                                Node i16 = i(textNode);
                                                if (this.f74150h) {
                                                    int i17 = this.f74145c;
                                                    char[] cArr2 = this.f74143a;
                                                    int b11 = b();
                                                    int i18 = this.f74146d + 1;
                                                    this.f74145c = i18;
                                                    compiledIfNode = new CompiledIncludeNode(i17, str, cArr2, b11, i18, this.f74152j);
                                                } else {
                                                    int i19 = this.f74145c;
                                                    char[] cArr3 = this.f74143a;
                                                    int b12 = b();
                                                    int i20 = this.f74146d + 1;
                                                    this.f74145c = i20;
                                                    compiledIfNode = new IncludeNode(i19, str, cArr3, b12, i20);
                                                }
                                                i16.next = compiledIfNode;
                                                break;
                                            case AD_REWARD_USER_VALUE:
                                                Node i21 = i(textNode);
                                                if (this.f74150h) {
                                                    int i22 = this.f74145c;
                                                    char[] cArr4 = this.f74143a;
                                                    int b13 = b();
                                                    int i23 = this.f74146d + 1;
                                                    this.f74145c = i23;
                                                    compiledIfNode = new CompiledNamedIncludeNode(i22, str, cArr4, b13, i23, this.f74152j);
                                                } else {
                                                    int i24 = this.f74145c;
                                                    char[] cArr5 = this.f74143a;
                                                    int b14 = b();
                                                    int i25 = this.f74146d + 1;
                                                    this.f74145c = i25;
                                                    compiledIfNode = new NamedIncludeNode(i24, str, cArr5, b14, i25);
                                                }
                                                i21.next = compiledIfNode;
                                                break;
                                            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                                                Node i26 = i(textNode);
                                                int i27 = this.f74145c;
                                                char[] cArr6 = this.f74143a;
                                                int b15 = b();
                                                int i28 = this.f74146d + 1;
                                                this.f74145c = i28;
                                                compiledIfNode = new CommentNode(i27, str, cArr6, b15, i28);
                                                i26.next = compiledIfNode;
                                                break;
                                            case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                                                Node i29 = i(textNode);
                                                if (this.f74150h) {
                                                    int i30 = this.f74145c;
                                                    char[] cArr7 = this.f74143a;
                                                    int b16 = b();
                                                    int i31 = this.f74146d + 1;
                                                    this.f74145c = i31;
                                                    compiledIfNode = new CompiledCodeNode(i30, str, cArr7, b16, i31, this.f74152j);
                                                } else {
                                                    int i32 = this.f74145c;
                                                    char[] cArr8 = this.f74143a;
                                                    int b17 = b();
                                                    int i33 = this.f74146d + 1;
                                                    this.f74145c = i33;
                                                    compiledIfNode = new CodeNode(i32, str, cArr8, b17, i33);
                                                }
                                                i29.next = compiledIfNode;
                                                break;
                                            case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                                                Node i34 = i(textNode);
                                                if (this.f74150h) {
                                                    int i35 = this.f74145c;
                                                    char[] cArr9 = this.f74143a;
                                                    int b18 = b();
                                                    int i36 = this.f74146d + 1;
                                                    this.f74145c = i36;
                                                    compiledIfNode = new CompiledDeclareNode(i35, str, cArr9, b18, i36, this.f74152j);
                                                } else {
                                                    int i37 = this.f74145c;
                                                    char[] cArr10 = this.f74143a;
                                                    int b19 = b();
                                                    int i38 = this.f74146d + 1;
                                                    this.f74145c = i38;
                                                    compiledIfNode = new DeclareNode(i37, str, cArr10, b19, i38);
                                                }
                                                i34.next = compiledIfNode;
                                                gVar.q(compiledIfNode);
                                                compiledIfNode.setTerminus(new TerminalNode());
                                                break;
                                            case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                                                Node i39 = i(textNode);
                                                if (this.f74150h) {
                                                    int i40 = this.f74145c;
                                                    char[] cArr11 = this.f74143a;
                                                    int b20 = b();
                                                    int i41 = this.f74146d + 1;
                                                    this.f74145c = i41;
                                                    compiledIfNode = new CompiledEvalNode(i40, str, cArr11, b20, i41, this.f74152j);
                                                } else {
                                                    int i42 = this.f74145c;
                                                    char[] cArr12 = this.f74143a;
                                                    int b21 = b();
                                                    int i43 = this.f74146d + 1;
                                                    this.f74145c = i43;
                                                    compiledIfNode = new EvalNode(i42, str, cArr12, b21, i43);
                                                }
                                                i39.next = compiledIfNode;
                                                break;
                                            default:
                                                if (str.length() == 0) {
                                                    Node i44 = i(textNode);
                                                    if (this.f74150h) {
                                                        int i45 = this.f74145c;
                                                        char[] cArr13 = this.f74143a;
                                                        int b22 = b();
                                                        int i46 = this.f74146d + 1;
                                                        this.f74145c = i46;
                                                        compiledIfNode = new CompiledExpressionNode(i45, str, cArr13, b22, i46, this.f74152j);
                                                    } else {
                                                        int i47 = this.f74145c;
                                                        char[] cArr14 = this.f74143a;
                                                        int b23 = b();
                                                        int i48 = this.f74146d + 1;
                                                        this.f74145c = i48;
                                                        compiledIfNode = new ExpressionNode(i47, str, cArr14, b23, i48);
                                                    }
                                                    i44.next = compiledIfNode;
                                                    break;
                                                } else {
                                                    Map map2 = this.f74151i;
                                                    if (map2 != null && map2.containsKey(str)) {
                                                        Class cls = (Class) this.f74151i.get(str);
                                                        try {
                                                            Node i49 = i(textNode);
                                                            terminus = (Node) cls.newInstance();
                                                            i49.next = terminus;
                                                            terminus.setBegin(this.f74145c);
                                                            terminus.setName(str);
                                                            terminus.setCStart(b());
                                                            int i50 = this.f74146d + 1;
                                                            this.f74145c = i50;
                                                            terminus.setCEnd(i50);
                                                            terminus.setEnd(terminus.getCEnd());
                                                            terminus.setContents(m.K0(this.f74143a, terminus.getCStart(), (terminus.getCEnd() - terminus.getCStart()) - 1));
                                                            if (terminus.isOpenNode()) {
                                                                gVar.q(terminus);
                                                                break;
                                                            }
                                                        } catch (IllegalAccessException unused) {
                                                            throw new RuntimeException("unable to instantiate custom node class: " + cls.getName());
                                                        } catch (InstantiationException unused2) {
                                                            throw new RuntimeException("unable to instantiate custom node class: " + cls.getName());
                                                        }
                                                    }
                                                }
                                                break;
                                        }
                                    } else {
                                        Node i51 = i(textNode);
                                        Node node4 = (Node) gVar.n();
                                        terminus = node4.getTerminus();
                                        terminus.setCStart(b());
                                        int i52 = this.f74145c;
                                        this.f74147e = i52;
                                        terminus.setEnd(i52 - 1);
                                        terminus.calculateContents(this.f74143a);
                                        if (node4.demarcate(terminus, this.f74143a)) {
                                            i51.next = terminus;
                                        }
                                    }
                                    textNode = terminus;
                                } else {
                                    Node i53 = i(textNode);
                                    compiledIfNode = this.f74150h ? new CompiledForEachNode(this.f74145c, str, this.f74143a, b(), this.f74145c, this.f74152j) : new ForEachNode(this.f74145c, str, this.f74143a, b(), this.f74145c);
                                    i53.next = compiledIfNode;
                                    gVar.q(compiledIfNode);
                                    compiledIfNode.setTerminus(new TerminalNode());
                                }
                            } else if (!gVar.g() && (gVar.k() instanceof IfNode)) {
                                Node i54 = i(textNode);
                                IfNode ifNode = (IfNode) gVar.n();
                                i54.next = ifNode.getTerminus();
                                ifNode.demarcate(ifNode.getTerminus(), this.f74143a);
                                textNode = this.f74150h ? new CompiledIfNode(this.f74145c, str, this.f74143a, b(), this.f74145c, this.f74152j) : new IfNode(this.f74145c, str, this.f74143a, b(), this.f74145c);
                                ifNode.next = textNode;
                                textNode.setTerminus(ifNode.getTerminus());
                                gVar.q(textNode);
                            }
                            textNode = compiledIfNode;
                        }
                    }
                }
                this.f74146d++;
            } catch (RuntimeException e11) {
                CompileException compileException2 = new CompileException(e11.getMessage(), this.f74143a, this.f74146d, e11);
                compileException2.setExpr(this.f74143a);
                if (e11 instanceof CompileException) {
                    CompileException compileException3 = (CompileException) e11;
                    if (compileException3.getCursor() != -1) {
                        compileException2.setCursor(compileException3.getCursor());
                        if (compileException3.getColumn() == -1) {
                            compileException2.setColumn(compileException2.getCursor() - this.f74149g);
                        } else {
                            compileException2.setColumn(compileException3.getColumn());
                        }
                    }
                }
                compileException2.setLineNumber(this.f74148f);
                throw compileException2;
            }
        }
        throw new RuntimeException("unknown token type: " + str);
    }
}
