package org.mvel2.templates.res;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.d;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;
import org.mvel2.templates.TemplateRuntimeError;
import org.mvel2.util.m;
import s10.a;
import s10.b;
import s10.c;

/* loaded from: classes7.dex */
public class CompiledForEachNode extends Node {
    private Serializable cSepExpr;

    /* renamed from: ce, reason: collision with root package name */
    private Serializable[] f72148ce;
    private ParserContext context;
    private String[] item;
    public Node nestedNode;
    private char[] sepExpr;

    public CompiledForEachNode(int i11, String str, char[] cArr, int i12, int i13, ParserContext parserContext) {
        super(i11, str, cArr, i12, i13);
        this.context = parserContext;
        configure();
    }

    private void configure() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i11 = this.cStart;
        int i12 = i11;
        while (true) {
            int i13 = this.cEnd;
            if (i11 >= i13) {
                if (i12 < i13) {
                    if (arrayList2.size() != arrayList.size() - 1) {
                        throw new CompileException("expected character ':' in foreach tag", this.contents, this.cEnd);
                    }
                    arrayList2.add(m.x(this.contents, i12, this.cEnd - i12));
                }
                this.item = new String[arrayList.size()];
                Iterator it = arrayList.iterator();
                int i14 = 0;
                int i15 = 0;
                while (it.hasNext()) {
                    this.item[i15] = (String) it.next();
                    i15++;
                }
                int size = arrayList2.size();
                String[] strArr = new String[size];
                this.f72148ce = new Serializable[size];
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    Serializable[] serializableArr = this.f72148ce;
                    strArr[i14] = str;
                    serializableArr[i14] = d.f(str, this.context);
                    i14++;
                }
                return;
            }
            char[] cArr = this.contents;
            char c11 = cArr[i11];
            if (c11 != '\"') {
                if (c11 != ',') {
                    if (c11 == ':') {
                        arrayList.add(m.x(cArr, i12, i11 - i12));
                    } else if (c11 != '[' && c11 != '{' && c11 != '\'' && c11 != '(') {
                        i11++;
                    }
                } else {
                    if (arrayList2.size() != arrayList.size() - 1) {
                        throw new CompileException("unexpected character ',' in foreach tag", this.contents, this.cStart + i11);
                    }
                    arrayList2.add(m.x(this.contents, i12, i11 - i12));
                }
                i12 = i11 + 1;
                i11++;
            }
            i11 = m.c(cArr, i11, c11);
            i11++;
        }
    }

    @Override // org.mvel2.templates.res.Node
    public boolean demarcate(Node node, char[] cArr) {
        this.nestedNode = this.next;
        this.next = this.terminus;
        char[] contents = node.getContents();
        this.sepExpr = contents;
        if (contents.length == 0) {
            this.sepExpr = null;
            return false;
        }
        this.cSepExpr = d.h(contents, this.context);
        return false;
    }

    @Override // org.mvel2.templates.res.Node
    public Object eval(r10.d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        int length = this.item.length;
        Iterator[] itArr = new Iterator[length];
        for (int i11 = 0; i11 < length; i11++) {
            Object t11 = d.t(this.f72148ce[i11], obj, variableResolverFactory);
            if (t11 instanceof Iterable) {
                itArr[i11] = ((Iterable) t11).iterator();
            } else if (t11 instanceof Object[]) {
                itArr[i11] = new a((Object[]) t11);
            } else {
                if (!(t11 instanceof Integer)) {
                    throw new TemplateRuntimeError("cannot iterate object type: " + t11.getClass().getName());
                }
                itArr[i11] = new b(((Integer) t11).intValue());
            }
        }
        HashMap hashMap = new HashMap();
        MapVariableResolverFactory mapVariableResolverFactory = new MapVariableResolverFactory(hashMap, variableResolverFactory);
        int i12 = length;
        while (true) {
            for (int i13 = 0; i13 < length; i13++) {
                if (itArr[i13].hasNext()) {
                    hashMap.put(this.item[i13], itArr[i13].next());
                } else {
                    i12--;
                    hashMap.put(this.item[i13], "");
                }
            }
            if (i12 == 0) {
                break;
            }
            this.nestedNode.eval(dVar, cVar, obj, mapVariableResolverFactory);
            if (this.sepExpr != null) {
                int i14 = 0;
                while (true) {
                    if (i14 >= length) {
                        break;
                    }
                    if (itArr[i14].hasNext()) {
                        cVar.append(String.valueOf(d.t(this.cSepExpr, obj, variableResolverFactory)));
                        break;
                    }
                    i14++;
                }
            }
        }
        Node node = this.next;
        if (node != null) {
            return node.eval(dVar, cVar, obj, variableResolverFactory);
        }
        return null;
    }

    public Node getNestedNode() {
        return this.nestedNode;
    }

    public void setNestedNode(Node node) {
        this.nestedNode = node;
    }
}
