package org.apache.tools.ant.types.resources.comparators;

import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.e;
import org.apache.tools.ant.types.t;

/* loaded from: classes7.dex */
public class DelegatedResourceComparator extends ResourceComparator {

    /* renamed from: v, reason: collision with root package name */
    private Vector f71653v = null;

    public synchronized void add(ResourceComparator resourceComparator) {
        try {
            if (isReference()) {
                throw noChildrenAllowed();
            }
            if (resourceComparator == null) {
                return;
            }
            Vector vector = this.f71653v;
            if (vector == null) {
                vector = new Vector();
            }
            this.f71653v = vector;
            vector.add(resourceComparator);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.tools.ant.types.e
    public void dieOnCircularReference(Stack stack, Project project) throws BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
            return;
        }
        Vector vector = this.f71653v;
        if (vector != null && !vector.isEmpty()) {
            Iterator it = this.f71653v.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof e) {
                    stack.push(next);
                    e.invokeCircularReferenceCheck((e) next, stack, project);
                }
            }
        }
        setChecked(true);
    }

    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator, java.util.Comparator
    public synchronized boolean equals(Object obj) {
        boolean z10 = true;
        if (obj == this) {
            return true;
        }
        if (isReference()) {
            return getCheckedRef().equals(obj);
        }
        if (!(obj instanceof DelegatedResourceComparator)) {
            return false;
        }
        Vector vector = ((DelegatedResourceComparator) obj).f71653v;
        Vector vector2 = this.f71653v;
        if (vector2 != null) {
            z10 = vector2.equals(vector);
        } else if (vector != null) {
            z10 = false;
        }
        return z10;
    }

    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public synchronized int hashCode() {
        if (isReference()) {
            return getCheckedRef().hashCode();
        }
        Vector vector = this.f71653v;
        return vector == null ? 0 : vector.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public synchronized int resourceCompare(t tVar, t tVar2) {
        Vector vector = this.f71653v;
        if (vector != null && !vector.isEmpty()) {
            Iterator it = this.f71653v.iterator();
            int i11 = 0;
            while (i11 == 0 && it.hasNext()) {
                i11 = ((ResourceComparator) it.next()).resourceCompare(tVar, tVar2);
            }
            return i11;
        }
        return tVar.compareTo(tVar2);
    }
}
