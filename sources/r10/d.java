package r10;

import java.util.Map;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;
import org.mvel2.templates.CompiledTemplate;
import org.mvel2.templates.res.Node;
import org.mvel2.util.g;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private char[] f74153a;

    /* renamed from: b, reason: collision with root package name */
    private c f74154b;

    /* renamed from: c, reason: collision with root package name */
    private Node f74155c;

    /* renamed from: d, reason: collision with root package name */
    private String f74156d;

    /* renamed from: e, reason: collision with root package name */
    private g f74157e;

    public d(char[] cArr, c cVar, Node node, String str) {
        this.f74153a = cArr;
        this.f74154b = cVar;
        this.f74155c = node;
        this.f74156d = str;
    }

    public static Object a(String str, Object obj, VariableResolverFactory variableResolverFactory) {
        return d(b.f(str), obj, variableResolverFactory);
    }

    public static Object b(String str, Map map) {
        return d(b.f(str), null, new MapVariableResolverFactory(map));
    }

    public static Object d(CompiledTemplate compiledTemplate, Object obj, VariableResolverFactory variableResolverFactory) {
        return f(compiledTemplate.getRoot(), compiledTemplate.getTemplate(), new StringBuilder(), obj, variableResolverFactory, null);
    }

    public static Object e(CompiledTemplate compiledTemplate, Object obj, VariableResolverFactory variableResolverFactory, c cVar) {
        return f(compiledTemplate.getRoot(), compiledTemplate.getTemplate(), new StringBuilder(), obj, variableResolverFactory, cVar);
    }

    public static Object f(Node node, char[] cArr, StringBuilder sb2, Object obj, VariableResolverFactory variableResolverFactory, c cVar) {
        return new d(cArr, cVar, node, ".").c(sb2, obj, variableResolverFactory);
    }

    public Object c(StringBuilder sb2, Object obj, VariableResolverFactory variableResolverFactory) {
        return g(new t10.a(sb2), obj, variableResolverFactory);
    }

    public Object g(s10.c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        return this.f74155c.eval(this, cVar, obj, variableResolverFactory);
    }

    public c h() {
        return this.f74154b;
    }

    public g i() {
        if (this.f74157e == null) {
            g gVar = new g();
            this.f74157e = gVar;
            gVar.q(this.f74156d);
        }
        return this.f74157e;
    }

    public char[] j() {
        return this.f74153a;
    }

    public void k(c cVar) {
        this.f74154b = cVar;
    }
}
