package org.mvel2;

import java.io.Serializable;
import java.util.Map;
import org.mvel2.compiler.CompiledAccExpression;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.compiler.ExpressionCompiler;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.CachingMapVariableResolverFactory;
import org.mvel2.util.m;

/* loaded from: classes7.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    static boolean f72084a = Boolean.getBoolean("mvel2.debug.fileoutput");

    /* renamed from: b, reason: collision with root package name */
    static String f72085b;

    /* renamed from: c, reason: collision with root package name */
    static boolean f72086c;

    /* renamed from: d, reason: collision with root package name */
    static boolean f72087d;

    /* renamed from: e, reason: collision with root package name */
    static boolean f72088e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f72089f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f72090g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f72091h;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f72092i;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f72093j;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f72094k;

    /* renamed from: l, reason: collision with root package name */
    static boolean f72095l;

    static {
        f72085b = System.getProperty("mvel2.debugging.file") == null ? "mvel_debug.txt" : System.getProperty("mvel2.debugging.file");
        f72086c = Boolean.getBoolean("mvel2.advanced_debugging");
        f72087d = Boolean.getBoolean("mvel2.weak_caching");
        f72088e = Boolean.getBoolean("mvel2.disable.jit");
        f72089f = Boolean.getBoolean("mvel2.invoked_meth_exceptions_bubble");
        f72090g = Boolean.getBoolean("mvel2.compiler.allow_naked_meth_calls");
        f72091h = Boolean.getBoolean("mvel2.compiler.allow_override_all_prophandling");
        f72092i = Boolean.getBoolean("mvel2.compiler.allow_resolve_inner_classes_with_dotnotation");
        f72093j = Boolean.getBoolean("mvel2.compiler.support_java_style_class_literals");
        f72094k = Boolean.getBoolean("mvel2.compiler.allocate_type_literals_to_shared_symbol_table");
        f72095l = true;
        if (System.getProperty("mvel2.optimizer") != null) {
            f72095l = Boolean.getBoolean("mvel2.optimizer");
        }
    }

    public static boolean A() {
        return f72084a;
    }

    public static void B(Object obj, String str, Object obj2) {
        g.z(obj, str, obj2);
    }

    public static void a(String str, ParserContext parserContext) {
        b(str.toCharArray(), parserContext);
    }

    public static void b(char[] cArr, ParserContext parserContext) {
        ExpressionCompiler expressionCompiler = new ExpressionCompiler(cArr, parserContext);
        expressionCompiler.setVerifyOnly(true);
        expressionCompiler.compile();
    }

    public static Class c(char[] cArr, ParserContext parserContext) {
        ExpressionCompiler expressionCompiler = new ExpressionCompiler(cArr, parserContext);
        expressionCompiler.setVerifyOnly(true);
        expressionCompiler.compile();
        return expressionCompiler.getReturnType();
    }

    public static Serializable d(String str) {
        return e(str, null, null, null);
    }

    public static Serializable e(String str, Map map, Map map2, String str2) {
        return f(str, new ParserContext((Map<String, Object>) map, (Map<String, k10.b>) map2, str2));
    }

    public static Serializable f(String str, ParserContext parserContext) {
        return m.v0(new ExpressionCompiler(str, parserContext).compile());
    }

    public static Serializable g(char[] cArr, int i11, int i12, ParserContext parserContext) {
        return m.v0(new ExpressionCompiler(cArr, i11, i12, parserContext)._compile());
    }

    public static Serializable h(char[] cArr, ParserContext parserContext) {
        return m.v0(new ExpressionCompiler(cArr, parserContext).compile());
    }

    public static Serializable i(String str, Class cls, ParserContext parserContext) {
        return new CompiledAccExpression(str.toCharArray(), cls, parserContext);
    }

    public static Serializable j(char[] cArr) {
        return new CompiledAccExpression(cArr, Object.class, new ParserContext());
    }

    public static Serializable k(char[] cArr, int i11, int i12, ParserContext parserContext) {
        return new CompiledAccExpression(cArr, i11, i12, Object.class, parserContext);
    }

    public static Serializable l(char[] cArr, Class cls, ParserContext parserContext) {
        return new CompiledAccExpression(cArr, cls, parserContext);
    }

    public static Serializable m(char[] cArr, ParserContext parserContext) {
        return new CompiledAccExpression(cArr, Object.class, parserContext);
    }

    public static Object n(String str, Object obj, VariableResolverFactory variableResolverFactory) {
        return new MVELInterpretedRuntime(str, obj, variableResolverFactory).parse();
    }

    public static Object o(String str, Object obj, VariableResolverFactory variableResolverFactory, Class cls) {
        return b.b(new MVELInterpretedRuntime(str, obj, variableResolverFactory).parse(), cls);
    }

    public static Object p(String str, Map map) {
        CachingMapVariableResolverFactory cachingMapVariableResolverFactory = new CachingMapVariableResolverFactory(map);
        try {
            return new MVELInterpretedRuntime(str, (Object) null, cachingMapVariableResolverFactory).parse();
        } finally {
            cachingMapVariableResolverFactory.externalize();
        }
    }

    public static Object q(char[] cArr, int i11, int i12, Object obj, VariableResolverFactory variableResolverFactory) {
        return new MVELInterpretedRuntime(cArr, i11, i12, obj, variableResolverFactory).parse();
    }

    public static Object r(char[] cArr, int i11, int i12, Object obj, VariableResolverFactory variableResolverFactory, Class cls) {
        return b.b(new MVELInterpretedRuntime(cArr, i11, i12, obj, variableResolverFactory).parse(), cls);
    }

    public static Object s(char[] cArr, Object obj, VariableResolverFactory variableResolverFactory) {
        return new MVELInterpretedRuntime(cArr, obj, variableResolverFactory).parse();
    }

    public static Object t(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return ((ExecutableStatement) obj).getValue(obj2, variableResolverFactory);
    }

    public static Object u(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Class cls) {
        return b.b(t(obj, obj2, variableResolverFactory), cls);
    }

    public static Object v(Object obj, Map map) {
        CachingMapVariableResolverFactory cachingMapVariableResolverFactory = new CachingMapVariableResolverFactory(map);
        try {
            return ((ExecutableStatement) obj).getValue(null, cachingMapVariableResolverFactory);
        } finally {
            cachingMapVariableResolverFactory.externalize();
        }
    }

    public static void w(Serializable serializable, Object obj, VariableResolverFactory variableResolverFactory, Object obj2) {
        ((CompiledAccExpression) serializable).setValue(obj, obj, variableResolverFactory, obj2);
    }

    public static String x() {
        return f72085b;
    }

    public static Object y(String str, Object obj) {
        return g.k(str, obj);
    }

    public static boolean z() {
        return f72086c;
    }
}
