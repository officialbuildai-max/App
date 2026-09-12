package org.mvel2.ast;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.UnresolveablePropertyException;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolver;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;
import org.mvel2.integration.impl.SimpleValueResolver;
import org.mvel2.util.q;

/* loaded from: classes7.dex */
public class Proto extends ASTNode {
    private int cursorEnd;
    private int cursorStart;
    private String name;
    private Map<String, c> receivers;

    /* loaded from: classes7.dex */
    public class ProtoContextFactory extends MapVariableResolverFactory {
        private final q variableResolvers;

        public ProtoContextFactory(q qVar) {
            super(qVar);
            this.variableResolvers = new q(qVar, true);
        }

        @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
        public VariableResolver createIndexedVariable(int i11, String str, Object obj) {
            VariableResolver variableResolver = (VariableResolver) this.variableResolvers.a(i11);
            if (variableResolver == null) {
                this.variableResolvers.d(i11, new SimpleValueResolver(obj));
            } else {
                variableResolver.setValue(obj);
            }
            return this.indexedVariableResolvers[i11];
        }

        @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
        public VariableResolver createIndexedVariable(int i11, String str, Object obj, Class<?> cls) {
            q qVar = this.variableResolvers;
            VariableResolver variableResolver = qVar != null ? (VariableResolver) qVar.a(i11) : null;
            if (variableResolver == null || variableResolver.getType() == null) {
                return createIndexedVariable(variableIndexOf(str), str, obj);
            }
            String str2 = "variable already defined within scope: " + variableResolver.getType() + " " + str;
            Proto proto = Proto.this;
            throw new CompileException(str2, proto.expr, proto.start);
        }

        @Override // org.mvel2.integration.impl.MapVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
        public VariableResolver createVariable(String str, Object obj) {
            try {
                VariableResolver variableResolver = getVariableResolver(str);
                variableResolver.setValue(obj);
                return variableResolver;
            } catch (UnresolveablePropertyException unused) {
                ProtoResolver protoResolver = new ProtoResolver(this.variables, str);
                addResolver(str, protoResolver).setValue(obj);
                return protoResolver;
            }
        }

        @Override // org.mvel2.integration.impl.MapVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
        public VariableResolver createVariable(String str, Object obj, Class<?> cls) {
            VariableResolver variableResolver;
            try {
                variableResolver = getVariableResolver(str);
            } catch (UnresolveablePropertyException unused) {
                variableResolver = null;
            }
            if (variableResolver == null || variableResolver.getType() == null) {
                ProtoResolver protoResolver = new ProtoResolver(this.variables, str, cls);
                addResolver(str, protoResolver).setValue(obj);
                return protoResolver;
            }
            String str2 = "variable already defined within scope: " + variableResolver.getType() + " " + str;
            Proto proto = Proto.this;
            throw new CompileException(str2, proto.expr, proto.start);
        }

        @Override // org.mvel2.integration.impl.BaseVariableResolverFactory
        public String[] getIndexedVariableNames() {
            return null;
        }

        @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
        public VariableResolver getIndexedVariableResolver(int i11) {
            return (VariableResolver) this.variableResolvers.a(i11);
        }

        @Override // org.mvel2.integration.impl.MapVariableResolverFactory, org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
        public VariableResolver getVariableResolver(String str) {
            VariableResolver variableResolver = (VariableResolver) this.variableResolvers.get(str);
            if (variableResolver != null) {
                return variableResolver;
            }
            if (this.variables.containsKey(str)) {
                q qVar = this.variableResolvers;
                ProtoResolver protoResolver = new ProtoResolver(this.variables, str);
                qVar.put(str, protoResolver);
                return protoResolver;
            }
            VariableResolverFactory variableResolverFactory = this.nextFactory;
            if (variableResolverFactory != null) {
                return variableResolverFactory.getVariableResolver(str);
            }
            throw new UnresolveablePropertyException("unable to resolve variable '" + str + "'");
        }

        @Override // org.mvel2.integration.impl.BaseVariableResolverFactory
        public void setIndexedVariableNames(String[] strArr) {
        }

        @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
        public VariableResolver setIndexedVariableResolver(int i11, VariableResolver variableResolver) {
            this.variableResolvers.d(i11, variableResolver);
            return variableResolver;
        }

        @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
        public int variableIndexOf(String str) {
            return this.variableResolvers.c(str);
        }
    }

    /* loaded from: classes7.dex */
    public class ProtoResolver implements VariableResolver {
        private Class<?> knownType;
        private String name;
        private Map<String, Object> variableMap;

        public ProtoResolver(Map<String, Object> map, String str) {
            this.variableMap = map;
            this.name = str;
        }

        public ProtoResolver(Map<String, Object> map, String str, Class cls) {
            this.name = str;
            this.knownType = cls;
            this.variableMap = map;
        }

        @Override // org.mvel2.integration.VariableResolver
        public int getFlags() {
            return 0;
        }

        @Override // org.mvel2.integration.VariableResolver
        public String getName() {
            return this.name;
        }

        @Override // org.mvel2.integration.VariableResolver
        public Class getType() {
            return this.knownType;
        }

        @Override // org.mvel2.integration.VariableResolver
        public Object getValue() {
            return ((c) this.variableMap.get(this.name)).f72066b;
        }

        public void setName(String str) {
            this.name = str;
        }

        @Override // org.mvel2.integration.VariableResolver
        public void setStaticType(Class cls) {
            this.knownType = cls;
        }

        @Override // org.mvel2.integration.VariableResolver
        public void setValue(Object obj) {
            if (this.knownType != null && obj != null) {
                Class<?> cls = obj.getClass();
                Class<?> cls2 = this.knownType;
                if (cls != cls2) {
                    if (!org.mvel2.b.a(cls2, obj.getClass())) {
                        String str = "cannot assign " + obj.getClass().getName() + " to type: " + this.knownType.getName();
                        Proto proto = Proto.this;
                        throw new CompileException(str, proto.expr, proto.start);
                    }
                    try {
                        obj = org.mvel2.b.b(obj, this.knownType);
                    } catch (Exception unused) {
                        String str2 = "cannot convert value of " + obj.getClass().getName() + " to: " + this.knownType.getName();
                        Proto proto2 = Proto.this;
                        throw new CompileException(str2, proto2.expr, proto2.start);
                    }
                }
            }
            ((c) this.variableMap.get(this.name)).f72066b = obj;
        }
    }

    /* loaded from: classes7.dex */
    public enum ReceiverType {
        DEFERRED,
        FUNCTION,
        PROPERTY
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f72060a;

        static {
            int[] iArr = new int[ReceiverType.values().length];
            f72060a = iArr;
            try {
                iArr[ReceiverType.FUNCTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f72060a[ReceiverType.PROPERTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f72060a[ReceiverType.DEFERRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Map {

        /* renamed from: a, reason: collision with root package name */
        private Proto f72061a;

        /* renamed from: b, reason: collision with root package name */
        private VariableResolverFactory f72062b;

        /* renamed from: c, reason: collision with root package name */
        private q f72063c = new q();

        public b(Proto proto, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
            this.f72061a = proto;
            for (Map.Entry entry : proto.receivers.entrySet()) {
                this.f72063c.put(entry.getKey(), ((c) entry.getValue()).d(this, obj, obj2, variableResolverFactory));
            }
            this.f72062b = new ProtoContextFactory(this.f72063c);
        }

        @Override // java.util.Map
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public c get(Object obj) {
            return (c) this.f72063c.get(obj);
        }

        @Override // java.util.Map
        public void clear() {
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return this.f72063c.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.f72063c.containsValue(obj);
        }

        @Override // java.util.Map
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public c put(String str, c cVar) {
            return (c) this.f72063c.put(str, cVar);
        }

        @Override // java.util.Map
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public c remove(Object obj) {
            return (c) this.f72063c.remove(obj);
        }

        @Override // java.util.Map
        public Set entrySet() {
            return this.f72063c.entrySet();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.f72063c.isEmpty();
        }

        @Override // java.util.Map
        public Set keySet() {
            return this.f72063c.keySet();
        }

        @Override // java.util.Map
        public void putAll(Map map) {
        }

        @Override // java.util.Map
        public int size() {
            return this.f72063c.size();
        }

        @Override // java.util.Map
        public Collection values() {
            return this.f72063c.values();
        }
    }

    /* loaded from: classes7.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        private ReceiverType f72065a;

        /* renamed from: b, reason: collision with root package name */
        private Object f72066b;

        /* renamed from: c, reason: collision with root package name */
        private ExecutableStatement f72067c;

        /* renamed from: d, reason: collision with root package name */
        private b f72068d;

        public c(b bVar, ReceiverType receiverType, Object obj) {
            this.f72068d = bVar;
            this.f72065a = receiverType;
            this.f72066b = obj;
        }

        public c(b bVar, ReceiverType receiverType, ExecutableStatement executableStatement) {
            this.f72068d = bVar;
            this.f72065a = receiverType;
            this.f72067c = executableStatement;
        }

        public Object c(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object[] objArr) {
            int i11 = a.f72060a[this.f72065a.ordinal()];
            if (i11 == 1) {
                return ((Function) this.f72066b).call(obj, obj2, new InvokationContextFactory(variableResolverFactory, this.f72068d.f72062b), objArr);
            }
            if (i11 == 2) {
                return this.f72066b;
            }
            if (i11 != 3) {
                return null;
            }
            Proto proto = Proto.this;
            throw new CompileException("unresolved prototype receiver", proto.expr, proto.start);
        }

        public c d(b bVar, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
            ExecutableStatement executableStatement;
            Proto proto = Proto.this;
            ReceiverType receiverType = this.f72065a;
            return new c(bVar, receiverType, (receiverType != ReceiverType.PROPERTY || (executableStatement = this.f72067c) == null) ? this.f72066b : executableStatement.getValue(obj, obj2, variableResolverFactory));
        }

        public void e(ExecutableStatement executableStatement) {
            this.f72067c = executableStatement;
        }

        public void f(ReceiverType receiverType) {
            this.f72065a = receiverType;
        }
    }

    public Proto(String str, ParserContext parserContext) {
        super(parserContext);
        this.name = str;
        this.receivers = new q();
    }

    public c declareReceiver(String str, Class cls, ExecutableStatement executableStatement) {
        c cVar = new c((b) null, ReceiverType.PROPERTY, executableStatement);
        this.receivers.put(str, cVar);
        return cVar;
    }

    public c declareReceiver(String str, Function function) {
        c cVar = new c((b) null, ReceiverType.FUNCTION, function);
        this.receivers.put(str, cVar);
        return cVar;
    }

    public c declareReceiver(String str, ReceiverType receiverType, ExecutableStatement executableStatement) {
        c cVar = new c((b) null, receiverType, executableStatement);
        this.receivers.put(str, cVar);
        return cVar;
    }

    public int getCursorEnd() {
        return this.cursorEnd;
    }

    public int getCursorStart() {
        return this.cursorStart;
    }

    @Override // org.mvel2.ast.ASTNode
    public String getName() {
        return this.name;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        variableResolverFactory.createVariable(this.name, this);
        return this;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        variableResolverFactory.createVariable(this.name, this);
        return this;
    }

    public b newInstance(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return new b(this, obj, obj2, variableResolverFactory);
    }

    public void setCursorPosition(int i11, int i12) {
        this.cursorStart = i11;
        this.cursorEnd = i12;
    }

    @Override // org.mvel2.ast.ASTNode
    public String toString() {
        return "proto " + this.name;
    }
}
