package org.mvel2.optimizers.impl.asm;

import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import h10.g;
import h10.q;
import h10.r;
import h10.y;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.mvel2.CompileException;
import org.mvel2.OptimizationFailure;
import org.mvel2.ParserContext;
import org.mvel2.PropertyAccessException;
import org.mvel2.ast.TypeDescriptor;
import org.mvel2.ast.WithNode;
import org.mvel2.b;
import org.mvel2.compiler.AbstractParser;
import org.mvel2.compiler.ExecutableLiteral;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.compiler.PropertyVerifier;
import org.mvel2.d;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.AbstractOptimizer;
import org.mvel2.optimizers.OptimizationNotSupported;
import org.mvel2.util.i;
import org.mvel2.util.k;
import org.mvel2.util.m;
import org.mvel2.util.n;
import org.mvel2.util.p;
import org.mvel2.util.s;

/* loaded from: classes7.dex */
public class ASMAccessorOptimizer extends AbstractOptimizer implements org.mvel2.optimizers.a {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ARRAY = 0;
    private static final Object[] EMPTYARG;
    private static final Class[] EMPTYCLS;
    private static final int LIST = 1;
    private static String LIST_IMPL = null;
    private static final int MAP = 2;
    private static final String MAP_IMPL = "java/util/HashMap";
    private static String NAMESPACE = null;
    private static final int OPCODES_VERSION;
    private static final int VAL = 3;
    private static k classLoader;
    private s buildLog;
    private String className;
    private int compileDepth;
    private ArrayList<ExecutableStatement> compiledInputs;
    private Object ctx;

    /* renamed from: cw, reason: collision with root package name */
    private g f72123cw;
    private boolean deferFinish;
    private boolean first;
    private Class ingressType;
    private boolean literal;
    private int maxlocals;
    private boolean methNull;

    /* renamed from: mv, reason: collision with root package name */
    private r f72124mv;
    private boolean noinit;
    private boolean propNull;
    private Class returnType;
    private int stacksize;
    private Object thisRef;
    private long time;
    private Object val;
    private VariableResolverFactory variableFactory;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a extends ClassLoader {
        a(ClassLoader classLoader) {
            super(classLoader);
        }

        Class a(String str, byte[] bArr) {
            return defineClass(str, bArr, 0, bArr.length);
        }
    }

    static {
        String f11 = n.f();
        if (f11.startsWith("1.4")) {
            OPCODES_VERSION = 48;
        } else if (f11.startsWith("1.5")) {
            OPCODES_VERSION = 49;
        } else if (f11.startsWith("1.6") || f11.startsWith("1.7") || f11.startsWith("1.8") || f11.startsWith(PrepareException.ERROR_MINI_APP_CLOSE) || f11.startsWith("10") || f11.startsWith(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY) || f11.startsWith("12")) {
            OPCODES_VERSION = 50;
        } else {
            OPCODES_VERSION = 46;
        }
        String property = System.getProperty("mvel2.namespace");
        if (property == null) {
            NAMESPACE = "org/mvel2/";
        } else {
            NAMESPACE = property;
        }
        String property2 = System.getProperty("mvel2.jit.list_impl");
        if (property2 == null) {
            LIST_IMPL = NAMESPACE + "util/FastList";
        } else {
            LIST_IMPL = property2;
        }
        EMPTYARG = new Object[0];
        EMPTYCLS = new Class[0];
    }

    public ASMAccessorOptimizer() {
        this.first = true;
        this.noinit = false;
        this.deferFinish = false;
        this.literal = false;
        this.propNull = false;
        this.methNull = false;
        this.stacksize = 1;
        this.maxlocals = 1;
        this.compileDepth = 0;
        new g(1);
    }

    private ASMAccessorOptimizer(g gVar, r rVar, ArrayList<ExecutableStatement> arrayList, String str, s sVar, int i11) {
        this.first = true;
        this.literal = false;
        this.propNull = false;
        this.methNull = false;
        this.stacksize = 1;
        this.maxlocals = 1;
        this.f72123cw = gVar;
        this.f72124mv = rVar;
        this.compiledInputs = arrayList;
        this.className = str;
        this.buildLog = sVar;
        this.compileDepth = i11 + 1;
        this.noinit = true;
        this.deferFinish = true;
    }

    private void _finishJIT() {
        if (this.deferFinish) {
            return;
        }
        Class cls = this.returnType;
        if (cls != null && cls.isPrimitive()) {
            wrapPrimitive(this.returnType);
        }
        if (this.returnType == Void.TYPE) {
            this.f72124mv.j(1);
        }
        this.f72124mv.j(176);
        dumpAdvancedDebugging();
        this.f72124mv.u(this.stacksize, this.maxlocals);
        this.f72124mv.f();
        r g11 = this.f72123cw.g(1, "getKnownEgressType", "()Ljava/lang/Class;", null, null);
        this.f72124mv = g11;
        g11.e();
        visitConstantClass(this.returnType);
        this.f72124mv.j(176);
        this.f72124mv.u(1, 1);
        this.f72124mv.f();
        if (this.propNull) {
            this.f72123cw.e(1, "nullPropertyHandler", "L" + NAMESPACE + "integration/PropertyHandler;", null, null).c();
        }
        if (this.methNull) {
            this.f72123cw.e(1, "nullMethodHandler", "L" + NAMESPACE + "integration/PropertyHandler;", null, null).c();
        }
        buildInputs();
        s sVar = this.buildLog;
        if (sVar != null && sVar.length() != 0 && this.expr != null) {
            r g12 = this.f72123cw.g(1, "toString", "()Ljava/lang/String;", null, null);
            this.f72124mv = g12;
            g12.e();
            this.f72124mv.o(new q());
            this.f72124mv.p(this.buildLog.toString() + "\n\n## { " + new String(this.expr) + " }");
            this.f72124mv.j(176);
            this.f72124mv.o(new q());
            this.f72124mv.u(1, 1);
            this.f72124mv.f();
        }
        this.f72123cw.d();
    }

    private int _getAccessor(Object obj, Class cls) {
        int i11;
        if (obj instanceof List) {
            this.f72124mv.E(187, LIST_IMPL);
            this.f72124mv.j(89);
            this.f72124mv.j(89);
            List list = (List) obj;
            intPush(list.size());
            this.f72124mv.v(183, LIST_IMPL, "<init>", "(I)V");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (_getAccessor(it.next(), cls) != 3) {
                    this.f72124mv.j(87);
                }
                this.f72124mv.v(185, "java/util/List", "add", "(Ljava/lang/Object;)Z");
                this.f72124mv.j(87);
                this.f72124mv.j(89);
            }
            this.returnType = List.class;
            return 1;
        }
        if (obj instanceof Map) {
            this.f72124mv.E(187, MAP_IMPL);
            this.f72124mv.j(89);
            this.f72124mv.j(89);
            Map map = (Map) obj;
            intPush(map.size());
            this.f72124mv.v(183, MAP_IMPL, "<init>", "(I)V");
            for (Object obj2 : map.keySet()) {
                this.f72124mv.E(PsExtractor.AUDIO_STREAM, "java/util/Map");
                if (_getAccessor(obj2, cls) != 3) {
                    this.f72124mv.j(87);
                }
                if (_getAccessor(map.get(obj2), cls) != 3) {
                    this.f72124mv.j(87);
                }
                this.f72124mv.v(185, "java/util/Map", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
                this.f72124mv.j(87);
                this.f72124mv.j(89);
            }
            this.returnType = Map.class;
            return 2;
        }
        if (!(obj instanceof Object[])) {
            if (cls.isArray()) {
                writeLiteralOrSubexpression(m.J0(((String) obj).toCharArray(), this.pCtx), m.T(cls));
            } else {
                writeLiteralOrSubexpression(m.J0(((String) obj).toCharArray(), this.pCtx));
            }
            return 3;
        }
        org.mvel2.compiler.a[] aVarArr = new org.mvel2.compiler.a[((Object[]) obj).length];
        if (cls != null) {
            i11 = 0;
            while (cls.getName().charAt(i11) == '[') {
                i11++;
            }
        } else {
            cls = Object[].class;
            i11 = 1;
        }
        try {
            Class T = m.T(cls);
            createArray(T, ((Object[]) obj).length);
            Class D = i11 > 1 ? m.D(null, m.A0('[', i11 - 1) + "L" + m.I(cls).getName() + ";", this.pCtx) : p.h(cls);
            this.f72124mv.j(89);
            int i12 = 0;
            for (Object obj3 : (Object[]) obj) {
                intPush(i12);
                if (_getAccessor(obj3, D) != 3) {
                    this.f72124mv.j(87);
                }
                if (T.isPrimitive()) {
                    unwrapPrimitive(T);
                }
                arrayStore(T);
                this.f72124mv.j(89);
                i12++;
            }
            return 0;
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException("this error should never throw:" + m.I(cls).getName(), e11);
        }
    }

    private void _initJIT() {
        if (d.z()) {
            this.buildLog = new s();
        }
        this.f72123cw = new g(3);
        synchronized (Runtime.getRuntime()) {
            g gVar = this.f72123cw;
            int i11 = OPCODES_VERSION;
            String str = "ASMAccessorImpl_" + String.valueOf(this.f72123cw.hashCode()).replaceAll("\\-", "_") + (System.currentTimeMillis() / 10) + ((int) (Math.random() * 100.0d));
            this.className = str;
            gVar.a(i11, 33, str, null, "java/lang/Object", new String[]{NAMESPACE + "compiler/Accessor"});
        }
        r g11 = this.f72123cw.g(1, "<init>", "()V", null, null);
        g11.e();
        g11.F(25, 0);
        g11.v(183, "java/lang/Object", "<init>", "()V");
        g11.j(177);
        g11.u(1, 1);
        g11.f();
        r g12 = this.f72123cw.g(1, "getValue", "(Ljava/lang/Object;Ljava/lang/Object;L" + NAMESPACE + "integration/VariableResolverFactory;)Ljava/lang/Object;", null, null);
        this.f72124mv = g12;
        g12.e();
    }

    private void _initJIT2() {
        if (d.z()) {
            this.buildLog = new s();
        }
        this.f72123cw = new g(3);
        synchronized (Runtime.getRuntime()) {
            g gVar = this.f72123cw;
            int i11 = OPCODES_VERSION;
            String str = "ASMAccessorImpl_" + String.valueOf(this.f72123cw.hashCode()).replaceAll("\\-", "_") + (System.currentTimeMillis() / 10) + ((int) (Math.random() * 100.0d));
            this.className = str;
            gVar.a(i11, 33, str, null, "java/lang/Object", new String[]{NAMESPACE + "compiler/Accessor"});
        }
        r g11 = this.f72123cw.g(1, "<init>", "()V", null, null);
        g11.e();
        g11.F(25, 0);
        g11.v(183, "java/lang/Object", "<init>", "()V");
        g11.j(177);
        g11.u(1, 1);
        g11.f();
        r g12 = this.f72123cw.g(1, "setValue", "(Ljava/lang/Object;Ljava/lang/Object;L" + NAMESPACE + "integration/VariableResolverFactory;Ljava/lang/Object;)Ljava/lang/Object;", null, null);
        this.f72124mv = g12;
        g12.e();
    }

    private org.mvel2.compiler.a _initializeAccessor() throws Exception {
        Object newInstance;
        if (this.deferFinish) {
            return null;
        }
        Class loadClass = loadClass(this.className, this.f72123cw.r());
        try {
            if (this.compiledInputs.size() == 0) {
                newInstance = loadClass.newInstance();
            } else {
                Class<?>[] clsArr = new Class[this.compiledInputs.size()];
                for (int i11 = 0; i11 < this.compiledInputs.size(); i11++) {
                    clsArr[i11] = ExecutableStatement.class;
                }
                Constructor constructor = loadClass.getConstructor(clsArr);
                ArrayList<ExecutableStatement> arrayList = this.compiledInputs;
                newInstance = constructor.newInstance(arrayList.toArray(new ExecutableStatement[arrayList.size()]));
            }
            if (this.propNull) {
                Field field = loadClass.getField("nullPropertyHandler");
                k10.d.b();
                field.set(newInstance, null);
            }
            if (this.methNull) {
                Field field2 = loadClass.getField("nullMethodHandler");
                k10.d.a();
                field2.set(newInstance, null);
            }
            return (org.mvel2.compiler.a) newInstance;
        } catch (VerifyError e11) {
            PrintStream printStream = System.out;
            printStream.println("**** COMPILER BUG! REPORT THIS IMMEDIATELY AT http://jira.codehaus.org/browse/MVEL");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Expression: ");
            char[] cArr = this.expr;
            sb2.append(cArr != null ? new String(cArr) : null);
            printStream.println(sb2.toString());
            throw e11;
        }
    }

    private void addPrintOut(String str) {
        this.f72124mv.g(178, "java/lang/System", "out", "Ljava/io/PrintStream;");
        this.f72124mv.p(str);
        this.f72124mv.v(182, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
    }

    private Object addSubstatement(ExecutableStatement executableStatement) {
        this.compiledInputs.add(executableStatement);
        this.f72124mv.F(25, 0);
        r rVar = this.f72124mv;
        String str = this.className;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(TtmlNode.TAG_P);
        sb2.append(this.compiledInputs.size() - 1);
        rVar.g(180, str, sb2.toString(), "L" + NAMESPACE + "compiler/ExecutableStatement;");
        this.f72124mv.F(25, 2);
        this.f72124mv.F(25, 3);
        this.f72124mv.v(185, y.h(ExecutableStatement.class), "getValue", "(Ljava/lang/Object;L" + NAMESPACE + "integration/VariableResolverFactory;)Ljava/lang/Object;");
        return null;
    }

    private void anyArrayCheck(Class cls) {
        if (cls == boolean[].class) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "[Z");
            return;
        }
        if (cls == int[].class) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "[I");
            return;
        }
        if (cls == float[].class) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "[F");
            return;
        }
        if (cls == double[].class) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "[D");
            return;
        }
        if (cls == short[].class) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "[S");
            return;
        }
        if (cls == long[].class) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "[J");
            return;
        }
        if (cls == byte[].class) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "[B");
        } else if (cls == char[].class) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "[C");
        } else {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "[Ljava/lang/Object;");
        }
    }

    private void buildInputs() {
        if (this.compiledInputs.size() == 0) {
            return;
        }
        s sVar = new s("(");
        int size = this.compiledInputs.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f72123cw.e(2, TtmlNode.TAG_P + i11, "L" + NAMESPACE + "compiler/ExecutableStatement;", null, null).c();
            sVar.d("L" + NAMESPACE + "compiler/ExecutableStatement;");
        }
        sVar.d(")V");
        r g11 = this.f72123cw.g(1, "<init>", sVar.toString(), null, null);
        g11.e();
        g11.F(25, 0);
        g11.v(183, "java/lang/Object", "<init>", "()V");
        int i12 = 0;
        while (i12 < size) {
            g11.F(25, 0);
            int i13 = i12 + 1;
            g11.F(25, i13);
            g11.g(181, this.className, TtmlNode.TAG_P + i12, "L" + NAMESPACE + "compiler/ExecutableStatement;");
            i12 = i13;
        }
        g11.j(177);
        g11.u(0, 0);
        g11.f();
    }

    private void checkcast(Class cls) {
        this.f72124mv.E(PsExtractor.AUDIO_STREAM, y.h(cls));
    }

    private org.mvel2.compiler.a compileAccessor() {
        Object obj = this.ctx;
        try {
            if (d.f72091h) {
                while (true) {
                    if (this.cursor >= this.end) {
                        break;
                    }
                    int nextSubToken = nextSubToken();
                    if (nextSubToken == 0) {
                        obj = getBeanPropertyAO(obj, capture());
                    } else if (nextSubToken == 1) {
                        obj = getMethod(obj, capture());
                    } else if (nextSubToken == 2) {
                        obj = getCollectionPropertyAO(obj, capture());
                    } else if (nextSubToken == 3) {
                        obj = getWithProperty(obj);
                    }
                    if (this.fields == -1) {
                        if (obj != null) {
                            this.fields = 0;
                        } else if (this.nullSafe) {
                            throw new OptimizationNotSupported();
                        }
                    }
                    this.first = false;
                    if (this.nullSafe && this.cursor < this.end) {
                        this.f72124mv.j(89);
                        q qVar = new q();
                        this.f72124mv.n(199, qVar);
                        this.f72124mv.j(176);
                        this.f72124mv.o(qVar);
                    }
                }
            } else {
                while (true) {
                    if (this.cursor >= this.end) {
                        break;
                    }
                    int nextSubToken2 = nextSubToken();
                    if (nextSubToken2 == 0) {
                        obj = getBeanProperty(obj, capture());
                    } else if (nextSubToken2 == 1) {
                        obj = getMethod(obj, capture());
                    } else if (nextSubToken2 == 2) {
                        obj = getCollectionProperty(obj, capture());
                    } else if (nextSubToken2 == 3) {
                        obj = getWithProperty(obj);
                    }
                    if (this.fields == -1) {
                        if (obj != null) {
                            this.fields = 0;
                        } else if (this.nullSafe) {
                            throw new OptimizationNotSupported();
                        }
                    }
                    this.first = false;
                    if (this.nullSafe && this.cursor < this.end) {
                        this.f72124mv.j(89);
                        q qVar2 = new q();
                        this.f72124mv.n(199, qVar2);
                        this.f72124mv.j(176);
                        this.f72124mv.o(qVar2);
                    }
                }
            }
            this.val = obj;
            _finishJIT();
            return _initializeAccessor();
        } catch (IllegalAccessException e11) {
            throw new PropertyAccessException(new String(this.expr), this.expr, this.f72083st, e11, this.pCtx);
        } catch (IndexOutOfBoundsException e12) {
            throw new PropertyAccessException(new String(this.expr), this.expr, this.f72083st, e12, this.pCtx);
        } catch (NullPointerException e13) {
            throw new PropertyAccessException(new String(this.expr), this.expr, this.f72083st, e13, this.pCtx);
        } catch (InvocationTargetException e14) {
            throw new PropertyAccessException(new String(this.expr), this.expr, this.f72083st, e14, this.pCtx);
        } catch (PropertyAccessException e15) {
            throw new CompileException(e15.getMessage(), this.expr, this.f72083st, e15);
        } catch (CompileException e16) {
            throw e16;
        } catch (OptimizationNotSupported e17) {
            throw e17;
        } catch (Exception e18) {
            throw new CompileException(e18.getMessage(), this.expr, this.f72083st, e18);
        }
    }

    private void createArray(Class cls, int i11) {
        intPush(i11);
        if (cls.isPrimitive()) {
            this.f72124mv.l(188, toPrimitiveTypeOperand(cls));
        } else {
            this.f72124mv.E(PsExtractor.PRIVATE_STREAM_1, y.h(cls));
        }
    }

    private void dataConversion(Class cls) {
        if (cls.equals(Object.class)) {
            return;
        }
        ldcClassConstant(cls);
        this.f72124mv.v(184, NAMESPACE + "DataConversion", "convert", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;");
    }

    private boolean debug(String str) {
        s sVar = this.buildLog;
        if (sVar == null) {
            return true;
        }
        sVar.d(str).d("\n");
        return true;
    }

    private void dumpAdvancedDebugging() {
        if (this.buildLog == null) {
            return;
        }
        PrintStream printStream = System.out;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("JIT Compiler Dump for: <<");
        char[] cArr = this.expr;
        sb2.append(cArr == null ? null : new String(cArr));
        sb2.append(">>\n-------------------------------\n");
        printStream.println(sb2.toString());
        printStream.println(this.buildLog.toString());
        printStream.println("\n<END OF DUMP>\n");
        if (d.A()) {
            try {
                FileWriter Q = m.Q();
                Q.write(this.buildLog.toString());
                Q.flush();
                Q.close();
            } catch (IOException unused) {
            }
        }
    }

    private Object getBeanProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException {
        boolean z10;
        Class<?> cls;
        Object invoke;
        ParserContext parserContext = this.pCtx;
        if ((parserContext == null ? this.currType : parserContext.getVarOrInputTypeOrNull(str)) == Object.class && !this.pCtx.isStrongTyping()) {
            this.currType = null;
        }
        Class cls2 = this.returnType;
        if (cls2 != null && cls2.isPrimitive()) {
            wrapPrimitive(this.returnType);
        }
        boolean z11 = obj instanceof Class;
        if (z11) {
            if (d.f72093j && "class".equals(str)) {
                ldcClassConstant((Class) obj);
                return obj;
            }
            cls = (Class) obj;
            z10 = true;
        } else if (obj != null) {
            cls = obj.getClass();
            z10 = false;
        } else {
            z10 = false;
            cls = null;
        }
        if (k10.d.f(cls)) {
            k10.d.c(cls);
            new StringBuilder().append("unable to compileShared: custom accessor does not support producing bytecode: ");
            throw null;
        }
        Member b11 = cls != null ? n.b(cls, str) : null;
        if (b11 != null && z10 && (b11.getModifiers() & 8) == 0) {
            b11 = null;
        }
        if (b11 != null && k10.a.a()) {
            this.f72124mv.F(25, 1);
            this.f72124mv.p(b11.getName());
            this.f72124mv.F(25, 3);
            this.f72124mv.v(184, NAMESPACE + "integration/GlobalListenerFactory", "notifyGetListeners", "(Ljava/lang/Object;Ljava/lang/String;L" + NAMESPACE + "integration/VariableResolverFactory;)V");
            k10.a.c(obj, b11.getName(), this.variableFactory);
        }
        if (this.first) {
            if ("this".equals(str)) {
                this.f72124mv.F(25, 2);
                return this.thisRef;
            }
            VariableResolverFactory variableResolverFactory = this.variableFactory;
            if (variableResolverFactory != null && variableResolverFactory.isResolveable(str)) {
                if (this.variableFactory.isIndexedFactory() && this.variableFactory.isTarget(str)) {
                    try {
                        int variableIndexOf = this.variableFactory.variableIndexOf(str);
                        loadVariableByIndex(variableIndexOf);
                        return this.variableFactory.getIndexedVariableResolver(variableIndexOf).getValue();
                    } catch (Exception unused) {
                        throw new OptimizationFailure(str);
                    }
                }
                try {
                    loadVariableByName(str);
                    return this.variableFactory.getVariableResolver(str).getValue();
                } catch (Exception e11) {
                    throw new OptimizationFailure("critical error in JIT", e11);
                }
            }
            this.f72124mv.F(25, 1);
        }
        if (b11 instanceof Field) {
            return optimizeFieldMethodProperty(obj, str, cls, b11);
        }
        if (b11 != null) {
            if (this.first) {
                this.f72124mv.F(25, 1);
            }
            try {
                invoke = ((Method) b11).invoke(obj, EMPTYARG);
                if (this.returnType != b11.getDeclaringClass()) {
                    this.f72124mv.E(PsExtractor.AUDIO_STREAM, y.h(b11.getDeclaringClass()));
                }
                this.returnType = ((Method) b11).getReturnType();
                if (b11.getDeclaringClass().isInterface()) {
                    this.f72124mv.v(185, y.h(b11.getDeclaringClass()), b11.getName(), y.i((Method) b11));
                } else {
                    this.f72124mv.v(182, y.h(b11.getDeclaringClass()), b11.getName(), y.i((Method) b11));
                }
            } catch (IllegalAccessException e12) {
                Method method = (Method) b11;
                Method z12 = m.z(method);
                if (z12 == null) {
                    throw new PropertyAccessException("could not access field: " + cls.getName() + "." + str, this.expr, this.f72083st, e12, this.pCtx);
                }
                this.f72124mv.E(PsExtractor.AUDIO_STREAM, y.h(z12.getDeclaringClass()));
                this.returnType = z12.getReturnType();
                this.f72124mv.v(185, y.h(z12.getDeclaringClass()), b11.getName(), y.i(method));
                invoke = z12.invoke(obj, EMPTYARG);
            } catch (IllegalArgumentException e13) {
                if (b11.getDeclaringClass().equals(obj)) {
                    try {
                        throw new CompileException("name collision between innerclass: " + Class.forName(b11.getDeclaringClass().getName() + "$" + str).getCanonicalName() + "; and bean accessor: " + str + " (" + b11.toString() + ")", this.expr, this.tkStart);
                    } catch (ClassNotFoundException unused2) {
                        throw e13;
                    }
                }
                throw e13;
            }
            if (k10.d.e()) {
                if (invoke == null) {
                    k10.d.b();
                    b11.getName();
                    throw null;
                }
                writeOutNullHandler(b11, 0);
            }
            this.currType = p.i(this.returnType);
            return invoke;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(str) || this.nullSafe) {
                this.f72124mv.E(PsExtractor.AUDIO_STREAM, "java/util/Map");
                this.f72124mv.p(str);
                this.f72124mv.v(185, "java/util/Map", "get", "(Ljava/lang/Object;)Ljava/lang/Object;");
                return map.get(str);
            }
        }
        if (this.first && "this".equals(str)) {
            this.f72124mv.F(25, 2);
            return this.thisRef;
        }
        if ("length".equals(str) && obj.getClass().isArray()) {
            anyArrayCheck(obj.getClass());
            this.f72124mv.j(190);
            wrapPrimitive(Integer.TYPE);
            return Integer.valueOf(Array.getLength(obj));
        }
        if (AbstractParser.LITERALS.containsKey(str)) {
            Object obj2 = AbstractParser.LITERALS.get(str);
            if (obj2 instanceof Class) {
                ldcClassConstant((Class) obj2);
            }
            return obj2;
        }
        Object tryStaticAccess = tryStaticAccess();
        if (tryStaticAccess != null) {
            if (tryStaticAccess instanceof Class) {
                ldcClassConstant((Class) tryStaticAccess);
                return tryStaticAccess;
            }
            if (!(tryStaticAccess instanceof Method)) {
                return optimizeFieldMethodProperty(obj, str, cls, (Field) tryStaticAccess);
            }
            Method method2 = (Method) tryStaticAccess;
            writeFunctionPointerStub(method2.getDeclaringClass(), method2);
            return tryStaticAccess;
        }
        if (z11) {
            Class cls3 = (Class) obj;
            for (Method method3 : cls3.getMethods()) {
                if (str.equals(method3.getName())) {
                    ParserContext parserContext2 = this.pCtx;
                    if (parserContext2 == null || parserContext2.getParserConfiguration() == null ? !d.f72090g : !this.pCtx.getParserConfiguration().isAllowNakedMethCall()) {
                        writeFunctionPointerStub(cls3, method3);
                        return method3;
                    }
                    this.f72124mv.j(87);
                    this.f72124mv.v(184, y.h(method3.getDeclaringClass()), method3.getName(), y.i(method3));
                    this.returnType = method3.getReturnType();
                    return method3.invoke(null, m.f72185a);
                }
            }
            try {
                Class D = m.D(this.variableFactory, cls3.getName() + "$" + str, this.pCtx);
                ldcClassConstant(D);
                return D;
            } catch (ClassNotFoundException unused3) {
            }
        } else {
            ParserContext parserContext3 = this.pCtx;
            if (parserContext3 == null || parserContext3.getParserConfiguration() == null ? d.f72090g : this.pCtx.getParserConfiguration().isAllowNakedMethCall()) {
                return getMethod(obj, str);
            }
        }
        if (obj == null) {
            throw new PropertyAccessException("unresolvable property or identifier: " + str, this.expr, this.f72083st, this.pCtx);
        }
        throw new PropertyAccessException("could not access: " + str + "; in class: " + obj.getClass().getName(), this.expr, this.f72083st, this.pCtx);
    }

    private Object getBeanPropertyAO(Object obj, String str) throws IllegalAccessException, InvocationTargetException {
        return (obj == null || !k10.d.f(obj.getClass())) ? getBeanProperty(obj, str) : propHandlerByteCode(str, obj, obj.getClass());
    }

    private Object getCollectionProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException {
        if (str.trim().length() > 0) {
            obj = getBeanProperty(obj, str);
            this.first = false;
        }
        this.currType = null;
        int i11 = this.cursor + 1;
        this.cursor = i11;
        skipWhitespace();
        if (this.cursor == this.end) {
            throw new CompileException("unterminated '['", this.expr, this.f72083st);
        }
        if (scanTo(']')) {
            throw new CompileException("unterminated '['", this.expr, this.f72083st);
        }
        String str2 = new String(this.expr, i11, this.cursor - i11);
        if (obj == null) {
            return null;
        }
        if (this.first) {
            this.f72124mv.F(25, 1);
        }
        ExecutableStatement executableStatement = (ExecutableStatement) m.J0(str2.toCharArray(), this.pCtx);
        Object value = executableStatement.getValue(this.ctx, this.variableFactory);
        this.cursor++;
        if (obj instanceof Map) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "java/util/Map");
            Class writeLiteralOrSubexpression = writeLiteralOrSubexpression(executableStatement);
            if (writeLiteralOrSubexpression != null && writeLiteralOrSubexpression.isPrimitive()) {
                wrapPrimitive(writeLiteralOrSubexpression);
            }
            this.f72124mv.v(185, "java/util/Map", "get", "(Ljava/lang/Object;)Ljava/lang/Object;");
            return ((Map) obj).get(value);
        }
        if (obj instanceof List) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "java/util/List");
            writeLiteralOrSubexpression(executableStatement, Integer.TYPE);
            this.f72124mv.v(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
            return ((List) obj).get(((Integer) b.b(value, Integer.class)).intValue());
        }
        if (!obj.getClass().isArray()) {
            if (!(obj instanceof CharSequence)) {
                TypeDescriptor typeDescriptor = new TypeDescriptor(this.expr, this.start, this.length, 0);
                if (typeDescriptor.isArray()) {
                    try {
                        Class classReference = TypeDescriptor.getClassReference((Class) obj, typeDescriptor, this.variableFactory, this.pCtx);
                        ldcClassConstant(classReference);
                        return classReference;
                    } catch (Exception unused) {
                    }
                }
                throw new CompileException("illegal use of []: unknown type: " + obj.getClass().getName(), this.expr, this.f72083st);
            }
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "java/lang/CharSequence");
            if (value instanceof Integer) {
                Integer num = (Integer) value;
                intPush(num.intValue());
                this.f72124mv.v(185, "java/lang/CharSequence", "charAt", "(I)C");
                wrapPrimitive(Character.TYPE);
                return Character.valueOf(((CharSequence) obj).charAt(num.intValue()));
            }
            writeLiteralOrSubexpression(executableStatement, Integer.class);
            unwrapPrimitive(Integer.TYPE);
            this.f72124mv.v(185, "java/lang/CharSequence", "charAt", "(I)C");
            wrapPrimitive(Character.TYPE);
            return Character.valueOf(((CharSequence) obj).charAt(((Integer) b.b(value, Integer.class)).intValue()));
        }
        this.f72124mv.E(PsExtractor.AUDIO_STREAM, y.f(obj.getClass()));
        Class cls = Integer.TYPE;
        writeLiteralOrSubexpression(executableStatement, cls, value.getClass());
        Class I = m.I(obj.getClass());
        if (I.isPrimitive()) {
            if (I == cls) {
                this.f72124mv.j(46);
            } else if (I == Character.TYPE) {
                this.f72124mv.j(52);
            } else if (I == Boolean.TYPE) {
                this.f72124mv.j(51);
            } else if (I == Double.TYPE) {
                this.f72124mv.j(49);
            } else if (I == Float.TYPE) {
                this.f72124mv.j(48);
            } else if (I == Short.TYPE) {
                this.f72124mv.j(53);
            } else if (I == Long.TYPE) {
                this.f72124mv.j(47);
            } else if (I == Byte.TYPE) {
                this.f72124mv.j(51);
            }
            wrapPrimitive(I);
        } else {
            this.f72124mv.j(50);
        }
        return Array.get(obj, ((Integer) b.b(value, Integer.class)).intValue());
    }

    private Object getCollectionPropertyAO(Object obj, String str) throws IllegalAccessException, InvocationTargetException {
        if (str.length() > 0) {
            obj = getBeanProperty(obj, str);
            this.first = false;
        }
        this.currType = null;
        int i11 = this.cursor + 1;
        this.cursor = i11;
        skipWhitespace();
        if (this.cursor == this.end) {
            throw new CompileException("unterminated '['", this.expr, this.f72083st);
        }
        if (scanTo(']')) {
            throw new CompileException("unterminated '['", this.expr, this.f72083st);
        }
        String str2 = new String(this.expr, i11, this.cursor - i11);
        if (obj == null) {
            return null;
        }
        ExecutableStatement executableStatement = (ExecutableStatement) m.H0(str2.toCharArray());
        Object value = executableStatement.getValue(this.ctx, this.variableFactory);
        this.cursor++;
        if (obj instanceof Map) {
            if (k10.d.f(Map.class)) {
                return propHandlerByteCode(str2, obj, Map.class);
            }
            if (this.first) {
                this.f72124mv.F(25, 1);
            }
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "java/util/Map");
            Class writeLiteralOrSubexpression = writeLiteralOrSubexpression(executableStatement);
            if (writeLiteralOrSubexpression != null && writeLiteralOrSubexpression.isPrimitive()) {
                wrapPrimitive(writeLiteralOrSubexpression);
            }
            this.f72124mv.v(185, "java/util/Map", "get", "(Ljava/lang/Object;)Ljava/lang/Object;");
            return ((Map) obj).get(value);
        }
        if (obj instanceof List) {
            if (k10.d.f(List.class)) {
                return propHandlerByteCode(str2, obj, List.class);
            }
            if (this.first) {
                this.f72124mv.F(25, 1);
            }
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "java/util/List");
            writeLiteralOrSubexpression(executableStatement, Integer.TYPE);
            this.f72124mv.v(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
            return ((List) obj).get(((Integer) b.b(value, Integer.class)).intValue());
        }
        if (obj.getClass().isArray()) {
            if (k10.d.f(Array.class)) {
                return propHandlerByteCode(str2, obj, Array.class);
            }
            if (this.first) {
                this.f72124mv.F(25, 1);
            }
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, y.f(obj.getClass()));
            Class cls = Integer.TYPE;
            writeLiteralOrSubexpression(executableStatement, cls, value.getClass());
            Class I = m.I(obj.getClass());
            if (I.isPrimitive()) {
                if (I == cls) {
                    this.f72124mv.j(46);
                } else if (I == Character.TYPE) {
                    this.f72124mv.j(52);
                } else if (I == Boolean.TYPE) {
                    this.f72124mv.j(51);
                } else if (I == Double.TYPE) {
                    this.f72124mv.j(49);
                } else if (I == Float.TYPE) {
                    this.f72124mv.j(48);
                } else if (I == Short.TYPE) {
                    this.f72124mv.j(53);
                } else if (I == Long.TYPE) {
                    this.f72124mv.j(47);
                } else if (I == Byte.TYPE) {
                    this.f72124mv.j(51);
                }
                wrapPrimitive(I);
            } else {
                this.f72124mv.j(50);
            }
            return Array.get(obj, ((Integer) b.b(value, Integer.class)).intValue());
        }
        if (!(obj instanceof CharSequence)) {
            char[] cArr = this.expr;
            int i12 = this.start;
            TypeDescriptor typeDescriptor = new TypeDescriptor(cArr, i12, this.end - i12, 0);
            if (typeDescriptor.isArray()) {
                try {
                    Class classReference = TypeDescriptor.getClassReference((Class) obj, typeDescriptor, this.variableFactory, this.pCtx);
                    ldcClassConstant(classReference);
                    return classReference;
                } catch (Exception unused) {
                }
            }
            throw new CompileException("illegal use of []: unknown type: " + obj.getClass().getName(), this.expr, this.f72083st);
        }
        if (k10.d.f(CharSequence.class)) {
            return propHandlerByteCode(str2, obj, CharSequence.class);
        }
        if (this.first) {
            this.f72124mv.F(25, 1);
        }
        this.f72124mv.E(PsExtractor.AUDIO_STREAM, "java/lang/CharSequence");
        if (value instanceof Integer) {
            Integer num = (Integer) value;
            intPush(num.intValue());
            this.f72124mv.v(185, "java/lang/CharSequence", "charAt", "(I)C");
            wrapPrimitive(Character.TYPE);
            return Character.valueOf(((CharSequence) obj).charAt(num.intValue()));
        }
        writeLiteralOrSubexpression(executableStatement, Integer.class);
        unwrapPrimitive(Integer.TYPE);
        this.f72124mv.v(185, "java/lang/CharSequence", "charAt", "(I)C");
        wrapPrimitive(Character.TYPE);
        return Character.valueOf(((CharSequence) obj).charAt(((Integer) b.b(value, Integer.class)).intValue()));
    }

    private a getContextClassLoader() {
        if (this.pCtx == null) {
            return null;
        }
        return new a(this.pCtx.getClassLoader());
    }

    public static k getMVELClassLoader() {
        return classLoader;
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x054d, code lost:
    
        if (r9 == (r2.getParameterTypes().length - 1)) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0305, code lost:
    
        if ((r11[r11.length - 1] instanceof org.mvel2.compiler.ExecutableAccessor) == false) goto L129;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0463  */
    /* JADX WARN: Type inference failed for: r10v37, types: [org.mvel2.compiler.ExecutableStatement[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v45, types: [org.mvel2.compiler.ExecutableStatement[]] */
    /* JADX WARN: Type inference failed for: r11v0, types: [org.mvel2.compiler.ExecutableStatement[]] */
    /* JADX WARN: Type inference failed for: r25v0, types: [org.mvel2.optimizers.impl.asm.ASMAccessorOptimizer, org.mvel2.compiler.AbstractParser, org.mvel2.optimizers.AbstractOptimizer] */
    /* JADX WARN: Type inference failed for: r5v13, types: [org.mvel2.compiler.ExecutableStatement] */
    /* JADX WARN: Type inference failed for: r5v16, types: [org.mvel2.compiler.ExecutableStatement] */
    /* JADX WARN: Type inference failed for: r8v11, types: [org.mvel2.compiler.ExecutableStatement] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v2, types: [org.mvel2.compiler.ExecutableStatement] */
    /* JADX WARN: Type inference failed for: r8v4, types: [org.mvel2.compiler.ExecutableStatement] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object getMethod(java.lang.Object r26, java.lang.String r27) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 2054
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.optimizers.impl.asm.ASMAccessorOptimizer.getMethod(java.lang.Object, java.lang.String):java.lang.Object");
    }

    private Object getWithProperty(Object obj) {
        if (this.first) {
            this.f72124mv.F(25, 1);
            this.first = false;
        }
        String trim = new String(this.expr, 0, this.cursor - 1).trim();
        int i11 = this.cursor;
        int i12 = i11 + 1;
        this.cursor = m.e(this.expr, i11, this.end, '{', this.pCtx);
        this.returnType = obj != null ? obj.getClass() : null;
        char[] cArr = this.expr;
        int i13 = this.cursor;
        this.cursor = i13 + 1;
        for (WithNode.ParmValuePair parmValuePair : WithNode.compileWithExpressions(cArr, i12, i13 - i12, trim, this.ingressType, this.pCtx)) {
            this.f72124mv.j(89);
            this.f72124mv.F(58, this.compileDepth + 5);
            parmValuePair.eval(obj, this.variableFactory);
            if (parmValuePair.getSetExpression() == null) {
                addSubstatement(parmValuePair.getStatement());
            } else {
                this.compiledInputs.add((ExecutableStatement) parmValuePair.getSetExpression());
                this.f72124mv.F(25, 0);
                this.f72124mv.g(180, this.className, TtmlNode.TAG_P + (this.compiledInputs.size() - 1), "L" + NAMESPACE + "compiler/ExecutableStatement;");
                this.f72124mv.F(25, this.compileDepth + 5);
                this.f72124mv.F(25, 2);
                this.f72124mv.F(25, 3);
                addSubstatement(parmValuePair.getStatement());
                this.f72124mv.v(185, NAMESPACE + "compiler/ExecutableStatement", "setValue", "(Ljava/lang/Object;Ljava/lang/Object;L" + NAMESPACE + "integration/VariableResolverFactory;Ljava/lang/Object;)Ljava/lang/Object;");
                this.f72124mv.j(87);
            }
        }
        return obj;
    }

    private Class getWrapperClass(Class cls) {
        return cls == Boolean.TYPE ? Boolean.class : cls == Integer.TYPE ? Integer.class : cls == Float.TYPE ? Float.class : cls == Double.TYPE ? Double.class : cls == Short.TYPE ? Short.class : cls == Long.TYPE ? Long.class : cls == Byte.TYPE ? Byte.class : cls == Character.TYPE ? Character.class : cls;
    }

    private void intPush(int i11) {
        if (i11 < 0 || i11 >= 6) {
            if (i11 > -127 && i11 < 128) {
                this.f72124mv.l(16, i11);
                return;
            } else if (i11 > 32767) {
                this.f72124mv.p(Integer.valueOf(i11));
                return;
            } else {
                this.f72124mv.l(17, i11);
                return;
            }
        }
        if (i11 == 0) {
            this.f72124mv.j(3);
            return;
        }
        if (i11 == 1) {
            this.f72124mv.j(4);
            return;
        }
        if (i11 == 2) {
            this.f72124mv.j(5);
            return;
        }
        if (i11 == 3) {
            this.f72124mv.j(6);
        } else if (i11 == 4) {
            this.f72124mv.j(7);
        } else {
            if (i11 != 5) {
                return;
            }
            this.f72124mv.j(8);
        }
    }

    private void ldcClassConstant(Class cls) {
        if (OPCODES_VERSION != 48) {
            this.f72124mv.p(y.m(cls));
            return;
        }
        this.f72124mv.p(cls.getName());
        this.f72124mv.v(184, "java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
        q qVar = new q();
        this.f72124mv.n(167, qVar);
        this.f72124mv.E(187, "java/lang/NoClassDefFoundError");
        this.f72124mv.j(90);
        this.f72124mv.j(95);
        this.f72124mv.v(182, "java/lang/Throwable", "getMessage", "()Ljava/lang/String;");
        this.f72124mv.v(183, "java/lang/NoClassDefFoundError", "<init>", "(Ljava/lang/String;)V");
        this.f72124mv.j(191);
        this.f72124mv.o(qVar);
    }

    private Class loadClass(String str, byte[] bArr) throws Exception {
        a contextClassLoader = getContextClassLoader();
        return contextClassLoader == null ? classLoader.a(str, bArr, 0, bArr.length) : contextClassLoader.a(str, bArr);
    }

    private void loadField(int i11) {
        this.f72124mv.F(25, 0);
        this.f72124mv.g(180, this.className, TtmlNode.TAG_P + i11, "L" + NAMESPACE + "compiler/ExecutableStatement;");
    }

    private void loadVariableByIndex(int i11) {
        this.f72124mv.F(25, 3);
        intPush(i11);
        this.f72124mv.v(185, "" + NAMESPACE + "integration/VariableResolverFactory", "getIndexedVariableResolver", "(I)L" + NAMESPACE + "integration/VariableResolver;");
        this.f72124mv.v(185, "" + NAMESPACE + "integration/VariableResolver", "getValue", "()Ljava/lang/Object;");
        this.returnType = Object.class;
    }

    private void loadVariableByName(String str) {
        this.f72124mv.F(25, 3);
        this.f72124mv.p(str);
        this.f72124mv.v(185, "" + NAMESPACE + "integration/VariableResolverFactory", "getVariableResolver", "(Ljava/lang/String;)L" + NAMESPACE + "integration/VariableResolver;");
        this.f72124mv.v(185, "" + NAMESPACE + "integration/VariableResolver", "getValue", "()Ljava/lang/Object;");
        this.returnType = Object.class;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object optimizeFieldMethodProperty(Object obj, String str, Class<?> cls, Member member) throws IllegalAccessException {
        Object obj2 = ((Field) member).get(obj);
        if ((member.getModifiers() & 8) == 0) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, y.h(cls));
            r rVar = this.f72124mv;
            String h11 = y.h(cls);
            Class<?> type = ((Field) member).getType();
            this.returnType = type;
            rVar.g(180, h11, str, y.f(type));
        } else {
            if ((member.getModifiers() & 16) != 0 && ((obj2 instanceof String) || ((Field) member).getType().isPrimitive())) {
                Object obj3 = ((Field) member).get(null);
                this.f72124mv.p(obj3);
                wrapPrimitive(obj3.getClass());
                if (k10.d.e()) {
                    writeOutNullHandler(member, 0);
                }
                return obj3;
            }
            r rVar2 = this.f72124mv;
            String h12 = y.h(member.getDeclaringClass());
            String name = member.getName();
            Class<?> type2 = ((Field) member).getType();
            this.returnType = type2;
            rVar2.g(178, h12, name, y.f(type2));
        }
        this.returnType = ((Field) member).getType();
        if (k10.d.e()) {
            if (obj2 == null) {
                k10.d.b();
                member.getName();
                throw null;
            }
            writeOutNullHandler(member, 0);
        }
        this.currType = p.i(this.returnType);
        return obj2;
    }

    private Object propHandlerByteCode(String str, Object obj, Class cls) {
        k10.d.c(cls);
        new StringBuilder().append("unable to compileShared: custom accessor does not support producing bytecode: ");
        throw null;
    }

    private void propHandlerByteCodePut(String str, Object obj, Class cls, Object obj2) {
        k10.d.c(cls);
        new StringBuilder().append("unable to compileShared: custom accessor does not support producing bytecode: ");
        throw null;
    }

    public static void setMVELClassLoader(k kVar) {
        classLoader = kVar;
    }

    public static int toPrimitiveTypeOperand(Class<?> cls) {
        if (cls == Integer.TYPE) {
            return 10;
        }
        if (cls == Long.TYPE) {
            return 11;
        }
        if (cls == Double.TYPE) {
            return 7;
        }
        if (cls == Float.TYPE) {
            return 6;
        }
        if (cls == Short.TYPE) {
            return 9;
        }
        if (cls == Byte.TYPE) {
            return 8;
        }
        if (cls == Character.TYPE) {
            return 5;
        }
        if (cls == Boolean.TYPE) {
            return 4;
        }
        throw new IllegalStateException("Non-primitive type passed to toPrimitiveTypeOperand: " + cls);
    }

    private void unwrapPrimitive(Class cls) {
        if (cls == Boolean.TYPE) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "java/lang/Boolean");
            this.f72124mv.v(182, "java/lang/Boolean", "booleanValue", "()Z");
            return;
        }
        if (cls == Integer.TYPE) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "java/lang/Integer");
            this.f72124mv.v(182, "java/lang/Integer", "intValue", "()I");
            return;
        }
        if (cls == Float.TYPE) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "java/lang/Float");
            this.f72124mv.v(182, "java/lang/Float", "floatValue", "()F");
            return;
        }
        if (cls == Double.TYPE) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "java/lang/Double");
            this.f72124mv.v(182, "java/lang/Double", "doubleValue", "()D");
            return;
        }
        if (cls == Short.TYPE) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "java/lang/Short");
            this.f72124mv.v(182, "java/lang/Short", "shortValue", "()S");
            return;
        }
        if (cls == Long.TYPE) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "java/lang/Long");
            this.f72124mv.v(182, "java/lang/Long", "longValue", "()J");
        } else if (cls == Byte.TYPE) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "java/lang/Byte");
            this.f72124mv.v(182, "java/lang/Byte", "byteValue", "()B");
        } else if (cls == Character.TYPE) {
            this.f72124mv.E(PsExtractor.AUDIO_STREAM, "java/lang/Character");
            this.f72124mv.v(182, "java/lang/Character", "charValue", "()C");
        }
    }

    private void visitConstantClass(Class<?> cls) {
        if (cls == null) {
            cls = Object.class;
        }
        if (cls.isPrimitive()) {
            this.f72124mv.g(178, p.i(cls).getName().replace(".", "/"), "TYPE", "Ljava/lang/Class;");
        } else {
            this.f72124mv.p(y.m(cls));
        }
    }

    private void wrapPrimitive(Class<? extends Object> cls) {
        if (OPCODES_VERSION != 48) {
            if (cls == Boolean.TYPE || cls == Boolean.class) {
                debug("INVOKESTATIC java/lang/Boolean.valueOf");
                this.f72124mv.v(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
                return;
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                debug("INVOKESTATIC java/lang/Integer.valueOf");
                this.f72124mv.v(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                return;
            }
            if (cls == Float.TYPE || cls == Float.class) {
                debug("INVOKESTATIC java/lang/Float.valueOf");
                this.f72124mv.v(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                return;
            }
            if (cls == Double.TYPE || cls == Double.class) {
                debug("INVOKESTATIC java/lang/Double.valueOf");
                this.f72124mv.v(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                return;
            }
            if (cls == Short.TYPE || cls == Short.class) {
                debug("INVOKESTATIC java/lang/Short.valueOf");
                this.f72124mv.v(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                return;
            }
            if (cls == Long.TYPE || cls == Long.class) {
                debug("INVOKESTATIC java/lang/Long.valueOf");
                this.f72124mv.v(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                return;
            } else if (cls == Byte.TYPE || cls == Byte.class) {
                debug("INVOKESTATIC java/lang/Byte.valueOf");
                this.f72124mv.v(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                return;
            } else {
                if (cls == Character.TYPE || cls == Character.class) {
                    debug("INVOKESTATIC java/lang/Character.valueOf");
                    this.f72124mv.v(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
                    return;
                }
                return;
            }
        }
        debug("** Using 1.4 Bytecode **");
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            debug("NEW java/lang/Boolean");
            this.f72124mv.E(187, "java/lang/Boolean");
            debug("DUP X1");
            this.f72124mv.j(90);
            debug("SWAP");
            this.f72124mv.j(95);
            debug("INVOKESPECIAL java/lang/Boolean.<init>::(Z)V");
            this.f72124mv.v(183, "java/lang/Boolean", "<init>", "(Z)V");
            return;
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            debug("NEW java/lang/Integer");
            this.f72124mv.E(187, "java/lang/Integer");
            debug("DUP X1");
            this.f72124mv.j(90);
            debug("SWAP");
            this.f72124mv.j(95);
            debug("INVOKESPECIAL java/lang/Integer.<init>::(I)V");
            this.f72124mv.v(183, "java/lang/Integer", "<init>", "(I)V");
            return;
        }
        if (cls == Float.TYPE || cls == Float.class) {
            debug("NEW java/lang/Float");
            this.f72124mv.E(187, "java/lang/Float");
            debug("DUP X1");
            this.f72124mv.j(90);
            debug("SWAP");
            this.f72124mv.j(95);
            debug("INVOKESPECIAL java/lang/Float.<init>::(F)V");
            this.f72124mv.v(183, "java/lang/Float", "<init>", "(F)V");
            return;
        }
        if (cls == Double.TYPE || cls == Double.class) {
            debug("NEW java/lang/Double");
            this.f72124mv.E(187, "java/lang/Double");
            debug("DUP X2");
            this.f72124mv.j(91);
            debug("DUP X2");
            this.f72124mv.j(91);
            debug("POP");
            this.f72124mv.j(87);
            debug("INVOKESPECIAL java/lang/Double.<init>::(D)V");
            this.f72124mv.v(183, "java/lang/Double", "<init>", "(D)V");
            return;
        }
        if (cls == Short.TYPE || cls == Short.class) {
            debug("NEW java/lang/Short");
            this.f72124mv.E(187, "java/lang/Short");
            debug("DUP X1");
            this.f72124mv.j(90);
            debug("SWAP");
            this.f72124mv.j(95);
            debug("INVOKESPECIAL java/lang/Short.<init>::(S)V");
            this.f72124mv.v(183, "java/lang/Short", "<init>", "(S)V");
            return;
        }
        if (cls == Long.TYPE || cls == Long.class) {
            debug("NEW java/lang/Long");
            this.f72124mv.E(187, "java/lang/Long");
            debug("DUP X1");
            this.f72124mv.j(90);
            debug("SWAP");
            this.f72124mv.j(95);
            debug("INVOKESPECIAL java/lang/Long.<init>::(L)V");
            this.f72124mv.v(183, "java/lang/Float", "<init>", "(L)V");
            return;
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            debug("NEW java/lang/Byte");
            this.f72124mv.E(187, "java/lang/Byte");
            debug("DUP X1");
            this.f72124mv.j(90);
            debug("SWAP");
            this.f72124mv.j(95);
            debug("INVOKESPECIAL java/lang/Byte.<init>::(B)V");
            this.f72124mv.v(183, "java/lang/Byte", "<init>", "(B)V");
            return;
        }
        if (cls == Character.TYPE || cls == Character.class) {
            debug("NEW java/lang/Character");
            this.f72124mv.E(187, "java/lang/Character");
            debug("DUP X1");
            this.f72124mv.j(90);
            debug("SWAP");
            this.f72124mv.j(95);
            debug("INVOKESPECIAL java/lang/Character.<init>::(C)V");
            this.f72124mv.v(183, "java/lang/Character", "<init>", "(C)V");
        }
    }

    private void writeFunctionPointerStub(Class cls, Method method) {
        ldcClassConstant(cls);
        this.f72124mv.v(182, "java/lang/Class", "getMethods", "()[Ljava/lang/reflect/Method;");
        this.f72124mv.F(58, 7);
        this.f72124mv.j(3);
        this.f72124mv.F(54, 5);
        this.f72124mv.F(25, 7);
        this.f72124mv.j(190);
        this.f72124mv.F(54, 6);
        q qVar = new q();
        this.f72124mv.n(167, qVar);
        q qVar2 = new q();
        this.f72124mv.o(qVar2);
        this.f72124mv.F(25, 7);
        this.f72124mv.F(21, 5);
        this.f72124mv.j(50);
        this.f72124mv.F(58, 4);
        this.f72124mv.o(new q());
        this.f72124mv.p(method.getName());
        this.f72124mv.F(25, 4);
        this.f72124mv.v(182, "java/lang/reflect/Method", "getName", "()Ljava/lang/String;");
        this.f72124mv.v(182, "java/lang/String", "equals", "(Ljava/lang/Object;)Z");
        q qVar3 = new q();
        this.f72124mv.n(153, qVar3);
        this.f72124mv.o(new q());
        this.f72124mv.F(25, 4);
        this.f72124mv.j(176);
        this.f72124mv.o(qVar3);
        this.f72124mv.i(5, 1);
        this.f72124mv.o(qVar);
        this.f72124mv.F(21, 5);
        this.f72124mv.F(21, 6);
        this.f72124mv.n(161, qVar2);
        this.f72124mv.o(new q());
        this.f72124mv.j(1);
        this.f72124mv.j(176);
    }

    private Class writeLiteralOrSubexpression(Object obj) {
        return writeLiteralOrSubexpression(obj, null, null);
    }

    private Class writeLiteralOrSubexpression(Object obj, Class cls) {
        return writeLiteralOrSubexpression(obj, cls, null);
    }

    private Class writeLiteralOrSubexpression(Object obj, Class cls, Class cls2) {
        Class cls3;
        if (!(obj instanceof ExecutableLiteral)) {
            this.literal = false;
            ExecutableStatement executableStatement = (ExecutableStatement) obj;
            addSubstatement(executableStatement);
            if (cls2 == null) {
                cls2 = executableStatement.getKnownEgressType();
            }
            if (cls != null && cls2 != cls && cls.isPrimitive()) {
                if (cls2 == null) {
                    throw new OptimizationFailure("cannot optimize expression: " + new String(this.expr) + ": cannot determine ingress type for primitive output");
                }
                checkcast(cls2);
                unwrapPrimitive(cls);
            }
            return cls2;
        }
        ExecutableLiteral executableLiteral = (ExecutableLiteral) obj;
        Object literal = executableLiteral.getLiteral();
        if (literal == null) {
            this.f72124mv.j(1);
            return null;
        }
        Class<?> cls4 = literal.getClass();
        if (cls4 == Integer.class && cls == (cls3 = Integer.TYPE)) {
            intPush(executableLiteral.getInteger32());
            return cls3;
        }
        if (cls == null || cls == cls4) {
            writeOutLiteralWrapped(literal);
            return cls4;
        }
        if (b.a(cls4, cls)) {
            writeOutLiteralWrapped(b.b(literal, cls));
            return cls4;
        }
        throw new CompileException("was expecting type: " + cls.getName() + "; but found type: " + cls4.getName(), this.expr, this.f72083st);
    }

    private void writeOutLiteralWrapped(Object obj) {
        if (obj instanceof Integer) {
            intPush(((Integer) obj).intValue());
            wrapPrimitive(Integer.TYPE);
            return;
        }
        if (obj instanceof String) {
            this.f72124mv.p(obj);
            return;
        }
        if (obj instanceof Long) {
            this.f72124mv.p(obj);
            wrapPrimitive(Long.TYPE);
            return;
        }
        if (obj instanceof Float) {
            this.f72124mv.p(obj);
            wrapPrimitive(Float.TYPE);
            return;
        }
        if (obj instanceof Double) {
            this.f72124mv.p(obj);
            wrapPrimitive(Double.TYPE);
            return;
        }
        if (obj instanceof Short) {
            this.f72124mv.p(obj);
            wrapPrimitive(Short.TYPE);
            return;
        }
        if (obj instanceof Character) {
            this.f72124mv.p(obj);
            wrapPrimitive(Character.TYPE);
        } else if (obj instanceof Boolean) {
            this.f72124mv.p(obj);
            wrapPrimitive(Boolean.TYPE);
        } else if (obj instanceof Byte) {
            this.f72124mv.p(obj);
            wrapPrimitive(Byte.TYPE);
        }
    }

    private void writeOutNullHandler(Member member, int i11) {
        this.f72124mv.j(89);
        q qVar = new q();
        this.f72124mv.n(199, qVar);
        this.f72124mv.j(87);
        this.f72124mv.F(25, 0);
        if (i11 == 0) {
            this.propNull = true;
            this.f72124mv.g(180, this.className, "nullPropertyHandler", "L" + NAMESPACE + "integration/PropertyHandler;");
        } else {
            this.methNull = true;
            this.f72124mv.g(180, this.className, "nullMethodHandler", "L" + NAMESPACE + "integration/PropertyHandler;");
        }
        this.f72124mv.p(member.getName());
        this.f72124mv.F(25, 1);
        this.f72124mv.F(25, 3);
        this.f72124mv.v(185, NAMESPACE + "integration/PropertyHandler", "getProperty", "(Ljava/lang/String;Ljava/lang/Object;L" + NAMESPACE + "integration/VariableResolverFactory;)Ljava/lang/Object;");
        this.f72124mv.o(qVar);
    }

    public void arrayStore(Class cls) {
        if (!cls.isPrimitive()) {
            this.f72124mv.j(83);
            return;
        }
        if (cls == Integer.TYPE) {
            this.f72124mv.j(79);
            return;
        }
        if (cls == Character.TYPE) {
            this.f72124mv.j(85);
            return;
        }
        if (cls == Boolean.TYPE) {
            this.f72124mv.j(84);
            return;
        }
        if (cls == Double.TYPE) {
            this.f72124mv.j(82);
            return;
        }
        if (cls == Float.TYPE) {
            this.f72124mv.j(81);
            return;
        }
        if (cls == Short.TYPE) {
            this.f72124mv.j(86);
        } else if (cls == Long.TYPE) {
            this.f72124mv.j(80);
        } else if (cls == Byte.TYPE) {
            this.f72124mv.j(84);
        }
    }

    @Override // org.mvel2.optimizers.a
    public Class getEgressType() {
        return this.returnType;
    }

    public String getName() {
        return "ASM";
    }

    @Override // org.mvel2.optimizers.a
    public Object getResultOptPass() {
        return this.val;
    }

    @Override // org.mvel2.optimizers.a
    public void init() {
        try {
            classLoader = new i(Thread.currentThread().getContextClassLoader());
        } catch (Exception e11) {
            throw new RuntimeException(e11);
        }
    }

    @Override // org.mvel2.optimizers.a
    public boolean isLiteralOnly() {
        return this.literal;
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeAccessor(ParserContext parserContext, char[] cArr, int i11, int i12, Object obj, Object obj2, VariableResolverFactory variableResolverFactory, boolean z10, Class cls) {
        this.time = System.currentTimeMillis();
        if (this.compiledInputs == null) {
            this.compiledInputs = new ArrayList<>();
        }
        this.cursor = i11;
        this.start = i11;
        int i13 = i12 + i11;
        this.end = i13;
        this.length = i13 - i11;
        this.first = true;
        this.val = null;
        this.pCtx = parserContext;
        this.expr = cArr;
        this.ctx = obj;
        this.thisRef = obj2;
        this.variableFactory = variableResolverFactory;
        this.ingressType = cls;
        if (!this.noinit) {
            _initJIT();
        }
        return compileAccessor();
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeCollection(ParserContext parserContext, Object obj, Class cls, char[] cArr, int i11, int i12, Object obj2, Object obj3, VariableResolverFactory variableResolverFactory) {
        int i13;
        this.expr = cArr;
        this.start = i11;
        this.cursor = i11;
        this.end = i11 + i12;
        this.length = i12;
        this.returnType = cls;
        this.compiledInputs = new ArrayList<>();
        this.ctx = obj2;
        this.thisRef = obj3;
        this.variableFactory = variableResolverFactory;
        this.pCtx = parserContext;
        _initJIT();
        this.literal = true;
        _getAccessor(obj, cls);
        _finishJIT();
        try {
            org.mvel2.compiler.a _initializeAccessor = _initializeAccessor();
            return (cArr == null || (i13 = this.length) <= i11) ? _initializeAccessor : new org.mvel2.optimizers.impl.refl.nodes.a(parserContext, _initializeAccessor, cArr, i11, i13);
        } catch (Exception e11) {
            throw new OptimizationFailure("could not optimize collection", e11);
        }
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeObjectCreation(ParserContext parserContext, char[] cArr, int i11, int i12, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        String str;
        String str2;
        Object[] objArr;
        _initJIT();
        this.compiledInputs = new ArrayList<>();
        this.cursor = i11;
        this.start = i11;
        int i13 = i11 + i12;
        this.end = i13;
        this.length = i13 - i11;
        this.ctx = obj;
        this.thisRef = obj2;
        this.variableFactory = variableResolverFactory;
        this.pCtx = parserContext;
        String[] g11 = m.g(cArr, i11, i12);
        List w02 = m.w0(g11[0].toCharArray());
        int i14 = 89;
        try {
            if (w02 == null) {
                Class D = m.D(variableResolverFactory, new String(cArr), parserContext);
                this.f72124mv.E(187, y.h(D));
                this.f72124mv.j(89);
                this.f72124mv.v(183, y.h(D), "<init>", y.d(D.getConstructor(EMPTYCLS)));
                _finishJIT();
                org.mvel2.compiler.a _initializeAccessor = _initializeAccessor();
                return (g11.length <= 1 || (str = g11[1]) == null || str.trim().equals("")) ? _initializeAccessor : new org.mvel2.optimizers.impl.refl.nodes.a(parserContext, _initializeAccessor, g11[1].toCharArray(), 0, g11[1].length());
            }
            Iterator it = w02.iterator();
            while (it.hasNext()) {
                this.compiledInputs.add((ExecutableStatement) m.J0((char[]) it.next(), parserContext));
            }
            Class D2 = m.D(variableResolverFactory, new String(m.K0(cArr, 0, org.mvel2.util.b.a('(', i11, this.length, cArr))), parserContext);
            this.f72124mv.E(187, y.h(D2));
            this.f72124mv.j(89);
            int size = w02.size();
            Object[] objArr2 = new Object[size];
            Iterator<ExecutableStatement> it2 = this.compiledInputs.iterator();
            int i15 = 0;
            while (it2.hasNext()) {
                objArr2[i15] = it2.next().getValue(obj, variableResolverFactory);
                i15++;
            }
            Constructor N = m.N(objArr2, D2, parserContext.isStrongTyping());
            if (N == null) {
                StringBuilder sb2 = new StringBuilder();
                int i16 = 0;
                while (i16 < size) {
                    sb2.append(objArr2[i16].getClass().getName());
                    i16++;
                    if (i16 < size) {
                        sb2.append(", ");
                    }
                }
                throw new CompileException("unable to find constructor: " + D2.getName() + "(" + sb2.toString() + ")", this.expr, this.f72083st);
            }
            this.returnType = N.getDeclaringClass();
            N.getParameterTypes();
            Class<?> cls = null;
            int i17 = -1;
            int i18 = 0;
            while (i18 < w02.size()) {
                if (i18 < N.getParameterTypes().length) {
                    cls = N.getParameterTypes()[i18];
                    if (N.isVarArgs() && i18 == N.getParameterTypes().length - 1) {
                        cls = m.I(cls);
                        createArray(cls, w02.size() - i18);
                        i17 = i18;
                    }
                } else if (i17 < 0 || cls == null) {
                    throw new IllegalStateException("Incorrect argument count " + i18);
                }
                if (i17 >= 0) {
                    this.f72124mv.j(i14);
                    intPush(i18 - i17);
                }
                this.f72124mv.F(25, 0);
                r rVar = this.f72124mv;
                String str3 = this.className;
                StringBuilder sb3 = new StringBuilder();
                List list = w02;
                sb3.append(TtmlNode.TAG_P);
                sb3.append(i18);
                rVar.g(180, str3, sb3.toString(), "L" + NAMESPACE + "compiler/ExecutableStatement;");
                this.f72124mv.F(25, 2);
                this.f72124mv.F(25, 3);
                this.f72124mv.v(185, "" + NAMESPACE + "compiler/ExecutableStatement", "getValue", "(Ljava/lang/Object;L" + NAMESPACE + "integration/VariableResolverFactory;)Ljava/lang/Object;");
                Class<?> wrapperClass = cls.isPrimitive() ? getWrapperClass(cls) : cls;
                Object obj3 = objArr2[i18];
                if (obj3 == null || obj3.getClass().isAssignableFrom(cls)) {
                    objArr = objArr2;
                    this.f72124mv.E(PsExtractor.AUDIO_STREAM, y.h(cls));
                } else {
                    ldcClassConstant(wrapperClass);
                    objArr = objArr2;
                    this.f72124mv.v(184, "" + NAMESPACE + "DataConversion", "convert", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;");
                    if (cls.isPrimitive()) {
                        unwrapPrimitive(cls);
                    } else {
                        this.f72124mv.E(PsExtractor.AUDIO_STREAM, y.h(wrapperClass));
                    }
                }
                if (i17 >= 0) {
                    arrayStore(cls);
                }
                i18++;
                w02 = list;
                objArr2 = objArr;
                i14 = 89;
            }
            this.f72124mv.v(183, y.h(D2), "<init>", y.d(N));
            _finishJIT();
            org.mvel2.compiler.a _initializeAccessor2 = _initializeAccessor();
            return (g11.length <= 1 || (str2 = g11[1]) == null || str2.trim().equals("")) ? _initializeAccessor2 : new org.mvel2.optimizers.impl.refl.nodes.a(parserContext, _initializeAccessor2, g11[1].toCharArray(), 0, g11[1].length());
        } catch (ClassNotFoundException unused) {
            throw new CompileException("class or class reference not found: " + new String(cArr), cArr, this.f72083st);
        } catch (Exception e11) {
            throw new OptimizationFailure("could not optimize construtor: " + new String(cArr), e11);
        }
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeSetAccessor(ParserContext parserContext, char[] cArr, int i11, int i12, Object obj, Object obj2, VariableResolverFactory variableResolverFactory, boolean z10, Object obj3, Class cls) {
        Object obj4;
        InvocationTargetException invocationTargetException;
        IllegalAccessException illegalAccessException;
        Object obj5 = obj3;
        this.expr = cArr;
        this.cursor = i11;
        this.start = i11;
        int i13 = i11 + i12;
        this.end = i13;
        this.length = i13;
        this.first = true;
        this.ingressType = cls;
        this.compiledInputs = new ArrayList<>();
        this.ctx = obj;
        this.thisRef = obj2;
        this.variableFactory = variableResolverFactory;
        this.pCtx = parserContext;
        PropertyVerifier propertyVerifier = new PropertyVerifier(cArr, parserContext);
        int findLastUnion = findLastUnion();
        q qVar = null;
        char[] K0 = findLastUnion != -1 ? m.K0(cArr, 0, findLastUnion) : null;
        _initJIT2();
        if (K0 != null) {
            int i14 = this.length;
            char[] cArr2 = this.expr;
            this.expr = K0;
            int length = K0.length;
            this.end = length;
            this.length = length;
            this.deferFinish = true;
            this.noinit = true;
            compileAccessor();
            obj4 = this.val;
            this.expr = cArr2;
            int length2 = K0.length + i11 + 1;
            this.cursor = length2;
            int length3 = (i14 - K0.length) - 1;
            this.length = length3;
            this.end = length2 + length3;
        } else {
            this.f72124mv.F(25, 1);
            obj4 = obj;
        }
        try {
            skipWhitespace();
            try {
                if (!this.collection) {
                    char[] cArr3 = this.expr;
                    int i15 = this.cursor;
                    String str = new String(cArr3, i15, this.end - i15);
                    Member d11 = n.d(obj4.getClass(), str, obj5 == null ? null : cls);
                    if (k10.a.b()) {
                        try {
                            this.f72124mv.F(25, 1);
                            this.f72124mv.p(str);
                            this.f72124mv.F(25, 3);
                            this.f72124mv.F(25, 4);
                            this.f72124mv.v(184, NAMESPACE + "integration/GlobalListenerFactory", "notifySetListeners", "(Ljava/lang/Object;Ljava/lang/String;L" + NAMESPACE + "integration/VariableResolverFactory;Ljava/lang/Object;)V");
                            k10.a.d(obj4, str, this.variableFactory, obj5);
                        } catch (IllegalAccessException e11) {
                            e = e11;
                            illegalAccessException = e;
                            throw new PropertyAccessException("could not access property", this.expr, i11, illegalAccessException, parserContext);
                        } catch (InvocationTargetException e12) {
                            e = e12;
                            invocationTargetException = e;
                            throw new PropertyAccessException("could not access property", this.expr, i11, invocationTargetException, parserContext);
                        }
                    }
                    if (d11 instanceof Field) {
                        checkcast(obj4.getClass());
                        Field field = (Field) d11;
                        q qVar2 = new q();
                        if (field.getType().isPrimitive()) {
                            this.f72124mv.F(58, 5);
                            this.f72124mv.F(25, 4);
                            if (obj5 == null) {
                                obj5 = n.g(field.getType());
                            }
                            q qVar3 = new q();
                            this.f72124mv.n(199, qVar3);
                            this.f72124mv.F(25, 5);
                            this.f72124mv.j(3);
                            this.f72124mv.g(181, y.h(field.getDeclaringClass()), str, y.f(field.getType()));
                            this.f72124mv.n(167, qVar2);
                            this.f72124mv.o(qVar3);
                            this.f72124mv.F(25, 5);
                            this.f72124mv.F(25, 4);
                            unwrapPrimitive(field.getType());
                            qVar = qVar3;
                        } else {
                            this.f72124mv.F(25, 4);
                            checkcast(field.getType());
                        }
                        if (qVar != null || obj5 == null || field.getType().isAssignableFrom(obj5.getClass())) {
                            field.set(obj4, obj5);
                        } else {
                            if (!b.a(field.getType(), obj5.getClass())) {
                                throw new CompileException("cannot convert type: " + obj5.getClass() + ": to " + field.getType(), this.expr, i11);
                            }
                            dataConversion(field.getType());
                            field.set(obj4, b.b(obj5, field.getType()));
                        }
                        this.f72124mv.g(181, y.h(field.getDeclaringClass()), str, y.f(field.getType()));
                        this.f72124mv.o(qVar2);
                        this.f72124mv.F(25, 4);
                    } else if (d11 != null) {
                        this.f72124mv.E(PsExtractor.AUDIO_STREAM, y.h(obj4.getClass()));
                        Method method = (Method) d11;
                        this.f72124mv.F(25, 4);
                        Class<?> cls2 = method.getParameterTypes()[0];
                        q qVar4 = new q();
                        if (obj5 == null || cls2.isAssignableFrom(obj3.getClass())) {
                            if (cls2.isPrimitive()) {
                                if (obj5 == null) {
                                    obj5 = n.g(cls2);
                                }
                                q qVar5 = new q();
                                this.f72124mv.n(199, qVar5);
                                this.f72124mv.j(3);
                                this.f72124mv.v(182, y.h(method.getDeclaringClass()), method.getName(), y.i(method));
                                this.f72124mv.n(167, qVar4);
                                this.f72124mv.o(qVar5);
                                this.f72124mv.F(25, 4);
                                unwrapPrimitive(cls2);
                            } else {
                                checkcast(cls2);
                            }
                            try {
                                method.invoke(obj4, obj5);
                            } catch (IllegalAccessException e13) {
                                e = e13;
                                illegalAccessException = e;
                                throw new PropertyAccessException("could not access property", this.expr, i11, illegalAccessException, parserContext);
                            } catch (InvocationTargetException e14) {
                                e = e14;
                                invocationTargetException = e;
                                throw new PropertyAccessException("could not access property", this.expr, i11, invocationTargetException, parserContext);
                            }
                        } else {
                            if (!b.a(cls2, obj3.getClass())) {
                                throw new CompileException("cannot convert type: " + obj3.getClass() + ": to " + method.getParameterTypes()[0], this.expr, i11);
                            }
                            dataConversion(getWrapperClass(cls2));
                            if (cls2.isPrimitive()) {
                                unwrapPrimitive(cls2);
                            } else {
                                checkcast(cls2);
                            }
                            try {
                                method.invoke(obj4, b.b(obj5, method.getParameterTypes()[0]));
                            } catch (IllegalAccessException e15) {
                                e = e15;
                                illegalAccessException = e;
                                throw new PropertyAccessException("could not access property", this.expr, i11, illegalAccessException, parserContext);
                            } catch (InvocationTargetException e16) {
                                e = e16;
                                invocationTargetException = e;
                                throw new PropertyAccessException("could not access property", this.expr, i11, invocationTargetException, parserContext);
                            }
                        }
                        this.f72124mv.v(182, y.h(method.getDeclaringClass()), method.getName(), y.i(method));
                        this.f72124mv.o(qVar4);
                        this.f72124mv.F(25, 4);
                    } else {
                        if (!(obj4 instanceof Map)) {
                            try {
                                throw new PropertyAccessException("could not access property (" + str + ") in: " + cls.getName(), this.expr, i11, parserContext);
                            } catch (IllegalAccessException e17) {
                                e = e17;
                                illegalAccessException = e;
                                throw new PropertyAccessException("could not access property", this.expr, i11, illegalAccessException, parserContext);
                            } catch (InvocationTargetException e18) {
                                e = e18;
                                invocationTargetException = e;
                                throw new PropertyAccessException("could not access property", this.expr, i11, invocationTargetException, parserContext);
                            }
                        }
                        this.f72124mv.E(PsExtractor.AUDIO_STREAM, y.h(obj4.getClass()));
                        this.f72124mv.p(str);
                        this.f72124mv.F(25, 4);
                        this.f72124mv.v(185, "java/util/Map", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
                        this.f72124mv.F(25, 4);
                        ((Map) obj4).put(str, obj5);
                    }
                    try {
                        this.deferFinish = false;
                        this.noinit = false;
                        _finishJIT();
                        return _initializeAccessor();
                    } catch (Exception e19) {
                        throw new CompileException("could not generate accessor", this.expr, i11, e19);
                    }
                }
                try {
                    int i16 = this.cursor;
                    whiteSpaceSkip();
                    if (i16 == this.end) {
                        throw new PropertyAccessException("unterminated '['", this.expr, i11, parserContext);
                    }
                    try {
                        if (scanTo(']')) {
                            throw new PropertyAccessException("unterminated '['", this.expr, i11, parserContext);
                        }
                        String trim = new String(this.expr, i16, this.cursor - i16).trim();
                        this.f72124mv.E(PsExtractor.AUDIO_STREAM, y.h(obj4.getClass()));
                        if (obj4 instanceof Map) {
                            if (d.f72091h && k10.d.f(Map.class)) {
                                propHandlerByteCodePut(trim, obj4, Map.class, obj5);
                            } else {
                                Map map = (Map) obj4;
                                Object n11 = d.n(trim, obj4, this.variableFactory);
                                Class analyze = propertyVerifier.analyze();
                                this.returnType = analyze;
                                map.put(n11, b.b(obj5, analyze));
                                writeLiteralOrSubexpression(m.J0(trim.toCharArray(), parserContext));
                                this.f72124mv.F(25, 4);
                                if (obj5 != null && this.returnType != obj3.getClass()) {
                                    dataConversion(this.returnType);
                                    checkcast(this.returnType);
                                }
                                this.f72124mv.v(185, "java/util/Map", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
                                this.f72124mv.j(87);
                                this.f72124mv.F(25, 4);
                            }
                        } else if (obj4 instanceof List) {
                            if (d.f72091h && k10.d.f(List.class)) {
                                propHandlerByteCodePut(trim, obj4, List.class, obj5);
                            } else {
                                List list = (List) obj4;
                                int intValue = ((Integer) d.o(trim, obj4, this.variableFactory, Integer.class)).intValue();
                                Class analyze2 = propertyVerifier.analyze();
                                this.returnType = analyze2;
                                list.set(intValue, b.b(obj5, analyze2));
                                writeLiteralOrSubexpression(m.J0(trim.toCharArray(), parserContext));
                                unwrapPrimitive(Integer.TYPE);
                                this.f72124mv.F(25, 4);
                                if (obj5 != null && !obj3.getClass().isAssignableFrom(this.returnType)) {
                                    dataConversion(this.returnType);
                                    checkcast(this.returnType);
                                }
                                this.f72124mv.v(185, "java/util/List", "set", "(ILjava/lang/Object;)Ljava/lang/Object;");
                                this.f72124mv.F(25, 4);
                            }
                        } else if (d.f72091h && k10.d.f(obj4.getClass())) {
                            propHandlerByteCodePut(trim, obj4, obj4.getClass(), obj5);
                        } else {
                            if (!obj4.getClass().isArray()) {
                                throw new PropertyAccessException("cannot bind to collection property: " + new String(this.expr) + ": not a recognized collection type: " + obj4.getClass(), this.expr, i11, parserContext);
                            }
                            if (d.f72091h && k10.d.f(Array.class)) {
                                propHandlerByteCodePut(trim, obj4, Array.class, obj5);
                            } else {
                                Class I = m.I(obj4.getClass());
                                Object n12 = d.n(trim, obj4, this.variableFactory);
                                Serializable J0 = m.J0(trim.toCharArray(), parserContext);
                                Class cls3 = Integer.TYPE;
                                writeLiteralOrSubexpression(J0, cls3);
                                if (!(n12 instanceof Integer)) {
                                    dataConversion(Integer.class);
                                    n12 = b.b(n12, Integer.class);
                                    unwrapPrimitive(cls3);
                                }
                                this.f72124mv.F(25, 4);
                                if (I.isPrimitive()) {
                                    unwrapPrimitive(I);
                                } else if (!I.equals(obj3.getClass())) {
                                    dataConversion(I);
                                }
                                arrayStore(I);
                                Array.set(obj4, ((Integer) n12).intValue(), b.b(obj5, I));
                                this.f72124mv.F(25, 4);
                            }
                        }
                        this.deferFinish = false;
                        this.noinit = false;
                        _finishJIT();
                        try {
                            this.deferFinish = false;
                            return _initializeAccessor();
                        } catch (Exception e20) {
                            throw new CompileException("could not generate accessor", this.expr, i11, e20);
                        }
                    } catch (IllegalAccessException e21) {
                        e = e21;
                        illegalAccessException = e;
                        throw new PropertyAccessException("could not access property", this.expr, i11, illegalAccessException, parserContext);
                    } catch (InvocationTargetException e22) {
                        e = e22;
                        invocationTargetException = e;
                        throw new PropertyAccessException("could not access property", this.expr, i11, invocationTargetException, parserContext);
                    }
                } catch (IllegalAccessException e23) {
                    e = e23;
                } catch (InvocationTargetException e24) {
                    e = e24;
                }
            } catch (IllegalAccessException e25) {
                e = e25;
            } catch (InvocationTargetException e26) {
                e = e26;
            }
        } catch (IllegalAccessException e27) {
            e = e27;
        } catch (InvocationTargetException e28) {
            e = e28;
        }
    }

    public void wrapRuntimeConverstion(Class cls) {
        ldcClassConstant(getWrapperClass(cls));
        this.f72124mv.v(184, "" + NAMESPACE + "DataConversion", "convert", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;");
    }
}
