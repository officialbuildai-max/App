package org.mvel2.compiler;

import org.mvel2.integration.VariableResolverFactory;

/* loaded from: classes7.dex */
public interface a {
    Class getKnownEgressType();

    Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory);

    Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3);
}
