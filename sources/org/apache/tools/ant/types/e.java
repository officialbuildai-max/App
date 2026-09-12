package org.apache.tools.ant.types;

import java.util.Stack;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.ComponentHelper;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.util.IdentityStack;

/* loaded from: classes7.dex */
public abstract class e extends org.apache.tools.ant.q implements Cloneable {
    protected boolean checked = true;
    protected r ref;

    public static void invokeCircularReferenceCheck(e eVar, Stack stack, Project project) {
        eVar.dieOnCircularReference(stack, project);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkAttributesAllowed() {
        if (isReference()) {
            throw tooManyAttributes();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkChildrenAllowed() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BuildException circularReference() {
        return new BuildException("This data type contains a circular reference.");
    }

    @Override // org.apache.tools.ant.q
    public Object clone() throws CloneNotSupportedException {
        e eVar = (e) super.clone();
        eVar.setDescription(getDescription());
        if (getRefid() != null) {
            eVar.setRefid(getRefid());
        }
        eVar.setChecked(isChecked());
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dieOnCircularReference() {
        dieOnCircularReference(getProject());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dieOnCircularReference(Stack stack, Project project) throws BuildException {
        if (this.checked || !isReference()) {
            return;
        }
        Object b11 = this.ref.b(project);
        if (b11 instanceof e) {
            IdentityStack identityStack = IdentityStack.getInstance(stack);
            if (identityStack.contains(b11)) {
                throw circularReference();
            }
            identityStack.push(b11);
            ((e) b11).dieOnCircularReference(identityStack, project);
            identityStack.pop();
        }
        this.checked = true;
    }

    protected void dieOnCircularReference(Project project) {
        if (this.checked || !isReference()) {
            return;
        }
        dieOnCircularReference(new IdentityStack(this), project);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getCheckedRef() {
        return getCheckedRef(getProject());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getCheckedRef(Class cls, String str) {
        return getCheckedRef(cls, str, getProject());
    }

    protected Object getCheckedRef(Class cls, String str, Project project) {
        if (project == null) {
            throw new BuildException("No Project specified");
        }
        dieOnCircularReference(project);
        Object b11 = this.ref.b(project);
        if (cls.isAssignableFrom(b11.getClass())) {
            return b11;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Class ");
        stringBuffer.append(b11.getClass());
        stringBuffer.append(" is not a subclass of ");
        stringBuffer.append(cls);
        log(stringBuffer.toString(), 3);
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(this.ref.a());
        stringBuffer2.append(" doesn't denote a ");
        stringBuffer2.append(str);
        throw new BuildException(stringBuffer2.toString());
    }

    protected Object getCheckedRef(Project project) {
        return getCheckedRef(getClass(), getDataTypeName(), project);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getDataTypeName() {
        return ComponentHelper.o(getProject(), this, true);
    }

    public r getRefid() {
        return this.ref;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isChecked() {
        return this.checked;
    }

    public boolean isReference() {
        return this.ref != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BuildException noChildrenAllowed() {
        return new BuildException("You must not specify nested elements when using refid");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setChecked(boolean z10) {
        this.checked = z10;
    }

    public void setRefid(r rVar) {
        this.ref = rVar;
        this.checked = false;
    }

    public String toString() {
        String description = getDescription();
        if (description == null) {
            return getDataTypeName();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getDataTypeName());
        stringBuffer.append(" ");
        stringBuffer.append(description);
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BuildException tooManyAttributes() {
        return new BuildException("You must not specify more than one attribute when using refid");
    }
}
