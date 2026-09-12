package org.mvel2.integration.impl;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.UnresolveablePropertyException;
import org.mvel2.integration.VariableResolver;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: classes7.dex */
public class DefaultLocalVariableResolverFactory extends MapVariableResolverFactory {
    private boolean noTilt;

    public DefaultLocalVariableResolverFactory() {
        super(new HashMap());
        this.noTilt = false;
    }

    public DefaultLocalVariableResolverFactory(Map<String, Object> map) {
        super(map);
        this.noTilt = false;
    }

    public DefaultLocalVariableResolverFactory(Map<String, Object> map, VariableResolverFactory variableResolverFactory) {
        super(map, variableResolverFactory);
        this.noTilt = false;
    }

    public DefaultLocalVariableResolverFactory(Map<String, Object> map, boolean z10) {
        super(map);
        this.noTilt = false;
    }

    public DefaultLocalVariableResolverFactory(VariableResolverFactory variableResolverFactory) {
        super(new HashMap(), variableResolverFactory);
        this.noTilt = false;
    }

    public DefaultLocalVariableResolverFactory(VariableResolverFactory variableResolverFactory, String[] strArr) {
        super(new HashMap(), variableResolverFactory);
        this.noTilt = false;
        this.indexedVariableNames = strArr;
        this.indexedVariableResolvers = new VariableResolver[strArr.length];
    }

    @Override // org.mvel2.integration.impl.MapVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
    public VariableResolver createVariable(String str, Object obj, Class<?> cls) {
        boolean z10;
        VariableResolver variableResolver;
        int variableIndexOf;
        if (this.indexedVariableNames == null) {
            return super.createVariable(str, obj, cls);
        }
        try {
            variableIndexOf = variableIndexOf(str);
        } catch (UnresolveablePropertyException unused) {
            z10 = false;
            variableResolver = null;
        }
        if (variableIndexOf == -1) {
            return super.createVariable(str, obj, cls);
        }
        SimpleValueResolver simpleValueResolver = new SimpleValueResolver(obj);
        VariableResolver[] variableResolverArr = this.indexedVariableResolvers;
        if (variableResolverArr[variableIndexOf] == null) {
            variableResolverArr[variableIndexOf] = simpleValueResolver;
        }
        this.variableResolvers.put(this.indexedVariableNames[variableIndexOf], simpleValueResolver);
        variableResolver = this.indexedVariableResolvers[variableIndexOf];
        z10 = true;
        if (z10 || variableResolver == null || variableResolver.getType() == null) {
            MapVariableResolver mapVariableResolver = new MapVariableResolver(this.variables, str, cls);
            addResolver(str, mapVariableResolver).setValue(obj);
            return mapVariableResolver;
        }
        throw new RuntimeException("variable already defined within scope: " + variableResolver.getType() + " " + str);
    }

    @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
    public VariableResolver getIndexedVariableResolver(int i11) {
        String[] strArr = this.indexedVariableNames;
        if (strArr == null) {
            return null;
        }
        VariableResolver[] variableResolverArr = this.indexedVariableResolvers;
        VariableResolver variableResolver = variableResolverArr[i11];
        if (variableResolver != null) {
            return variableResolver;
        }
        VariableResolver variableResolver2 = super.getVariableResolver(strArr[i11]);
        variableResolverArr[i11] = variableResolver2;
        return variableResolver2;
    }

    @Override // org.mvel2.integration.impl.MapVariableResolverFactory, org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
    public VariableResolver getVariableResolver(String str) {
        int variableIndexOf;
        if (this.indexedVariableNames != null && (variableIndexOf = variableIndexOf(str)) != -1) {
            VariableResolver[] variableResolverArr = this.indexedVariableResolvers;
            if (variableResolverArr[variableIndexOf] == null) {
                variableResolverArr[variableIndexOf] = new SimpleValueResolver(null);
            }
            this.variableResolvers.put(this.indexedVariableNames[variableIndexOf], null);
            return this.indexedVariableResolvers[variableIndexOf];
        }
        return super.getVariableResolver(str);
    }

    public VariableResolverFactory setNoTilt(boolean z10) {
        this.noTilt = z10;
        return this;
    }

    @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
    public void setTiltFlag(boolean z10) {
        if (this.noTilt) {
            return;
        }
        super.setTiltFlag(z10);
    }
}
