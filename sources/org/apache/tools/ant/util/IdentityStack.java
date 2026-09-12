package org.apache.tools.ant.util;

import java.util.Stack;

/* loaded from: classes7.dex */
public class IdentityStack extends Stack {
    private static final long serialVersionUID = -5555522620060077046L;

    public IdentityStack() {
    }

    public IdentityStack(Object obj) {
        push(obj);
    }

    public static IdentityStack getInstance(Stack stack) {
        if (stack instanceof IdentityStack) {
            return (IdentityStack) stack;
        }
        IdentityStack identityStack = new IdentityStack();
        if (stack != null) {
            identityStack.addAll(stack);
        }
        return identityStack;
    }

    @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
    public synchronized boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Vector
    public synchronized int indexOf(Object obj, int i11) {
        while (i11 < size()) {
            if (get(i11) == obj) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    @Override // java.util.Vector
    public synchronized int lastIndexOf(Object obj, int i11) {
        while (i11 >= 0) {
            if (get(i11) == obj) {
                return i11;
            }
            i11--;
        }
        return -1;
    }
}
