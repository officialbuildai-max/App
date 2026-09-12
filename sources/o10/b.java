package o10;

import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableLiteral;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;
import org.mvel2.util.p;

/* loaded from: classes7.dex */
public class b implements org.mvel2.compiler.a {

    /* renamed from: a, reason: collision with root package name */
    public ExecutableStatement f70772a;

    public b(String str, Class cls, Object obj, VariableResolverFactory variableResolverFactory, ParserContext parserContext) {
        this.f70772a = (ExecutableStatement) m.J0(str.toCharArray(), parserContext);
        Class T = m.T(cls);
        Class knownEgressType = this.f70772a.getKnownEgressType();
        if (this.f70772a.getKnownEgressType() == null || p.f(T, knownEgressType)) {
            return;
        }
        if ((this.f70772a instanceof ExecutableLiteral) && org.mvel2.b.a(knownEgressType, T)) {
            try {
                this.f70772a = new ExecutableLiteral(org.mvel2.b.b(this.f70772a.getValue(obj, variableResolverFactory), T));
                return;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (parserContext == null || !parserContext.isStrongTyping()) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("was expecting type: ");
        sb2.append(T);
        sb2.append("; but found type: ");
        sb2.append(knownEgressType == null ? "null" : knownEgressType.getName());
        throw new RuntimeException(sb2.toString());
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.f70772a.getKnownEgressType();
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return this.f70772a.getValue(obj2, variableResolverFactory);
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        return null;
    }
}
