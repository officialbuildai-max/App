package org.mvel2.ast;

import java.lang.reflect.Array;
import java.util.Iterator;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.DefaultLocalVariableResolverFactory;
import org.mvel2.integration.impl.ItemResolverFactory;
import org.mvel2.util.m;

/* loaded from: classes7.dex */
public class ForEachNode extends BlockNode {
    private static final int ARRAY = 1;
    private static final int CHARSEQUENCE = 2;
    private static final int INTEGER = 3;
    private static final int ITERABLE = 0;
    protected ExecutableStatement condition;
    protected String item;
    protected Class itemType;
    private int type;

    public ForEachNode(char[] cArr, int i11, int i12, int i13, int i14, int i15, ParserContext parserContext) {
        super(parserContext);
        this.type = -1;
        this.expr = cArr;
        this.start = i11;
        this.offset = i12;
        this.fields = i15;
        handleCond(cArr, i11, i12, i15, parserContext);
        this.blockStart = i13;
        this.blockOffset = i14;
        if ((i15 & 16) != 0) {
            if (parserContext.isStrictTypeEnforcement() && this.itemType != null) {
                parserContext = parserContext.createSubcontext();
                parserContext.addInput(this.item, this.itemType);
            }
            parserContext.pushVariableScope();
            parserContext.makeVisible(this.item);
            this.compiledBlock = (ExecutableStatement) m.I0(cArr, i13, i14, parserContext);
            parserContext.popVariableScope();
        }
    }

    private void determineIterType(Class cls) {
        if (Iterable.class.isAssignableFrom(cls)) {
            this.type = 0;
            return;
        }
        if (cls.isArray()) {
            this.type = 1;
            return;
        }
        if (CharSequence.class.isAssignableFrom(cls)) {
            this.type = 2;
        } else {
            if (Integer.class.isAssignableFrom(cls)) {
                this.type = 3;
                return;
            }
            throw new CompileException("non-iterable type: " + cls.getName(), this.expr, this.start);
        }
    }

    private void enforceTypeSafety(Class cls, Class cls2) {
        if (cls.isAssignableFrom(cls2) || org.mvel2.b.a(cls2, cls)) {
            return;
        }
        throw new CompileException("type mismatch in foreach: expected: " + cls.getName() + "; but found: " + m.I(cls2), this.expr, this.start);
    }

    private void handleCond(char[] cArr, int i11, int i12, int i13, ParserContext parserContext) {
        int i14 = i11 + i12;
        int i15 = i11;
        while (i15 < i14 && cArr[i15] != ':') {
            i15++;
        }
        if (i15 == i14 || cArr[i15] != ':') {
            throw new CompileException("expected : in foreach", cArr, i15);
        }
        int i16 = i15 - i11;
        String x10 = m.x(cArr, i11, i16);
        this.item = x10;
        int indexOf = x10.indexOf(32);
        if (indexOf != -1) {
            String trim = new String(cArr, i11, indexOf).trim();
            try {
                this.itemType = m.D(null, trim, parserContext);
                this.item = new String(cArr, i11 + indexOf, i16 - indexOf).trim();
            } catch (ClassNotFoundException unused) {
                throw new CompileException("cannot resolve identifier: " + trim, cArr, i11);
            }
        }
        int i17 = i15 + 1;
        this.start = i17;
        int i18 = (i12 - i16) - 1;
        this.offset = i18;
        if ((i13 & 16) != 0) {
            ExecutableStatement executableStatement = (ExecutableStatement) m.I0(this.expr, i17, i18, parserContext);
            this.condition = executableStatement;
            Class knownEgressType = executableStatement.getKnownEgressType();
            if (this.itemType != null && knownEgressType.isArray()) {
                enforceTypeSafety(this.itemType, m.I(this.condition.getKnownEgressType()));
            } else if (parserContext.isStrongTyping()) {
                determineIterType(knownEgressType);
            }
        }
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        ItemResolverFactory.ItemResolver itemResolver = new ItemResolverFactory.ItemResolver(this.item);
        ItemResolverFactory itemResolverFactory = new ItemResolverFactory(itemResolver, new DefaultLocalVariableResolverFactory(variableResolverFactory));
        Object q11 = org.mvel2.d.q(this.expr, this.start, this.offset, obj2, variableResolverFactory);
        Class cls = this.itemType;
        if (cls != null && cls.isArray()) {
            enforceTypeSafety(this.itemType, m.I(q11.getClass()));
        }
        this.compiledBlock = (ExecutableStatement) m.I0(this.expr, this.blockStart, this.blockOffset, this.pCtx);
        if (q11 instanceof Iterable) {
            Iterator it = ((Iterable) q11).iterator();
            while (it.hasNext()) {
                itemResolver.setValue(it.next());
                Object value = this.compiledBlock.getValue(obj, obj2, itemResolverFactory);
                if (itemResolverFactory.tiltFlag()) {
                    return value;
                }
            }
            return null;
        }
        int i11 = 0;
        if (q11 != null && q11.getClass().isArray()) {
            int length = Array.getLength(q11);
            while (i11 < length) {
                itemResolver.setValue(Array.get(q11, i11));
                Object value2 = this.compiledBlock.getValue(obj, obj2, itemResolverFactory);
                if (itemResolverFactory.tiltFlag()) {
                    return value2;
                }
                i11++;
            }
            return null;
        }
        if (q11 instanceof CharSequence) {
            char[] charArray = q11.toString().toCharArray();
            int length2 = charArray.length;
            while (i11 < length2) {
                itemResolver.setValue(Character.valueOf(charArray[i11]));
                Object value3 = this.compiledBlock.getValue(obj, obj2, itemResolverFactory);
                if (itemResolverFactory.tiltFlag()) {
                    return value3;
                }
                i11++;
            }
            return null;
        }
        if (!(q11 instanceof Integer)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("non-iterable type: ");
            sb2.append(q11 != null ? q11.getClass().getName() : "null");
            throw new CompileException(sb2.toString(), this.expr, this.start);
        }
        int intValue = ((Integer) q11).intValue() + 1;
        for (int i12 = 1; i12 != intValue; i12++) {
            itemResolver.setValue(Integer.valueOf(i12));
            Object value4 = this.compiledBlock.getValue(obj, obj2, itemResolverFactory);
            if (itemResolverFactory.tiltFlag()) {
                return value4;
            }
        }
        return null;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        ItemResolverFactory.ItemResolver itemResolver = new ItemResolverFactory.ItemResolver(this.item);
        ItemResolverFactory itemResolverFactory = new ItemResolverFactory(itemResolver, new DefaultLocalVariableResolverFactory(variableResolverFactory));
        Object value = this.condition.getValue(obj, obj2, variableResolverFactory);
        if (this.type == -1) {
            determineIterType(value.getClass());
        }
        int i11 = this.type;
        if (i11 == 0) {
            Iterator it = ((Iterable) value).iterator();
            while (it.hasNext()) {
                itemResolver.setValue(it.next());
                Object value2 = this.compiledBlock.getValue(obj, obj2, itemResolverFactory);
                if (itemResolverFactory.tiltFlag()) {
                    return value2;
                }
            }
            return null;
        }
        int i12 = 0;
        if (i11 == 1) {
            int length = Array.getLength(value);
            while (i12 < length) {
                itemResolver.setValue(Array.get(value, i12));
                Object value3 = this.compiledBlock.getValue(obj, obj2, itemResolverFactory);
                if (itemResolverFactory.tiltFlag()) {
                    return value3;
                }
                i12++;
            }
            return null;
        }
        if (i11 == 2) {
            char[] charArray = value.toString().toCharArray();
            int length2 = charArray.length;
            while (i12 < length2) {
                itemResolver.setValue(Character.valueOf(charArray[i12]));
                Object value4 = this.compiledBlock.getValue(obj, obj2, itemResolverFactory);
                if (itemResolverFactory.tiltFlag()) {
                    return value4;
                }
                i12++;
            }
            return null;
        }
        if (i11 != 3) {
            return null;
        }
        int intValue = ((Integer) value).intValue() + 1;
        for (int i13 = 1; i13 != intValue; i13++) {
            itemResolver.setValue(Integer.valueOf(i13));
            Object value5 = this.compiledBlock.getValue(obj, obj2, itemResolverFactory);
            if (itemResolverFactory.tiltFlag()) {
                return value5;
            }
        }
        return null;
    }
}
